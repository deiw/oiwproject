package pl.majorczyk.server.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserData {

    @NotBlank
    @Size(min = 4, max = 10)
    private String username;
    @NotBlank
    private String password;
}
