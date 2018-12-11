package pl.majorczyk.server.utils;

import pl.majorczyk.server.user.UserEntity;

public class UserUtils {

    private UserUtils() {
    }

    public static UserEntity getDefaultUser() {
        return UserEntity.builder()
                .username("user")
                .password("pass")
                .id(1L)
                .build();
    }
}
