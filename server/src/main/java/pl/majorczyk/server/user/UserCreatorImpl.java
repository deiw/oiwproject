package pl.majorczyk.server.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    public UserEntity create(UserData userData) {

        UserEntity userEntity = UserEntity.builder()
                .username(userData.getUsername())
                .password(userData.getPassword())
                .build();

        return userRepository.save(userEntity);
    }
}
