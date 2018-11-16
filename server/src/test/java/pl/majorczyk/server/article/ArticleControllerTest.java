package pl.majorczyk.server.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper mapper;
    @Mock
    private ArticleService articleService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new ArticleController(articleService))
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
        this.mapper = new ObjectMapper();
    }

    @Test
    public void shouldCreateArticle() throws Exception {
        //given
        ArticleData articleData = new ArticleData("title", "content");

        //when
        mockMvc.perform(post("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(articleData)))
                .andExpect(status().isCreated());

        //verify
    }

    @Test
    public void shouldValidEmptyArticleDataFields() throws Exception {
        //given
        ArticleData articleData = new ArticleData("", "");

        //when
        mockMvc.perform(post("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(articleData)))
                .andExpect(status().isBadRequest());
        //verify
    }

    @Test
    public void shouldValidIncompleteArticleData() throws Exception {
        //given
        ArticleData articleData = new ArticleData();
        articleData.setContent("content");

        //when
        mockMvc.perform(post("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(articleData)))
                .andExpect(status().isBadRequest());

        //verify
    }

    @Test
    public void shouldReturnPageOfArticles() throws Exception {
        //when
        mockMvc.perform(get("/article"))
                .andExpect(status().isOk());

        //verify
    }

    @Test
    public void shouldReturnArticleByTitle() throws Exception {
        //when
        mockMvc.perform(get("/article/{title}","title"))
                .andExpect(status().isOk());

        //verify
    }

    @Test
    public void ifArticleNotFound_shouldReturnStatusNotFound() throws Exception {
        //given
        when(articleService.findArticleByTitle(any())).thenThrow(ArticleNotFoundException.class);

        //when
        mockMvc.perform(get("/article/title"))
                .andExpect(status().isNotFound());

        //verify
    }
}