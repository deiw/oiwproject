package pl.majorczyk.server.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserEntity create(UserData userData) {

        UserEntity userEntity = UserEntity.builder()
                .username(userData.getUsername())
                .password(encoder.encode(userData.getPassword()))
                .build();

        return userRepository.save(userEntity);
    }
}
