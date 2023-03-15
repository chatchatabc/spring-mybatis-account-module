package com.example.user.application.mapper;

import com.example.user.SpringBootBaseTest;
import com.example.user.application.commons.mapper.UserMapper;
import com.example.user.application.commons.vo.UserVO;
import com.example.user.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserMapperTest extends SpringBootBaseTest {
    @Test
    public void shouldMapUserToDto() {
        //given
        User user = new User();
        user.setUsername("anton");
        user.setPassword("123");
        user.setEmail("anton@email.com");

        //when
        UserVO userVO = UserMapper.INSTANCE.modelToVO( user );

        //then
        assertThat(userVO).isNotNull();
        assertThat( userVO.getEmail() ).isEqualTo( "anton@email.com" );
        assertThat( userVO.getPassword() ).isEqualTo( "123" );
        assertThat( userVO.getUsername() ).isEqualTo( "anton" );
    }
}
