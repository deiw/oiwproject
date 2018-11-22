package pl.majorczyk.server.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class User {

    private Long id;
    private String username;
}
