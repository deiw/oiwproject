package pl.majorczyk.server.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserCreator userCreator;

    @Override
    public User saveUser(UserData userData) {
        UserEntity userEntity = userCreator.create(userData);
        return userMapper.map(userEntity);
    }
}
