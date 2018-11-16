package pl.majorczyk.server.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ArticleData {

    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String content;
}
