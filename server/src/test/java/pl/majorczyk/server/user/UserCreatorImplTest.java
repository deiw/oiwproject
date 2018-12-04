package pl.majorczyk.server.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserCreatorImplTest {

    @Autowired
    private UserRepository userRepository;
    private UserCreator userCreator;

    @Before
    public void setUp() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.userCreator = new UserCreatorImpl(userRepository, encoder);
    }

    @Test
    public void shouldCreateUser() {
        //given
        UserData data = new UserData("user", "password");

        //when
        UserEntity userEntity = userCreator.create(data);

        //then
        assertNotNull(userEntity);
        assertEquals(1L, userEntity.getId().longValue());
        assertEquals("user", userEntity.getUsername());

    }

}