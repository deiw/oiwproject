package pl.majorczyk.server.article;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Article not found")
class ArticleNotFoundException extends RuntimeException {
}
