package pl.majorczyk.server.user;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserMapperImplTest {

    private UserMapper userMapper;

    @Before
    public void setUp() {
        this.userMapper = new UserMapperImpl();
    }

    @Test
    public void shouldMapUserEntityToUser() {
        //given
        UserEntity userEntity = new UserEntity(1L, "user", "password");

        //when
        User user = userMapper.map(userEntity);

        //then
        assertNotNull(user);
        assertEquals(1L, user.getId().longValue());
        assertEquals("user", user.getUsername());
    }
}