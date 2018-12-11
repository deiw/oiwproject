package pl.majorczyk.server.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ArticleData {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @URL
    private String imgUrl;
    @NotBlank
    private String creator;
}
