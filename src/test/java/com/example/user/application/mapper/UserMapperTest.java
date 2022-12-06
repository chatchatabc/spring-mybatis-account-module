package com.example.user.application.mapper;

import com.example.user.SpringBootBaseTest;
import com.example.user.application.commons.dto.UserRegisDto;
import com.example.user.application.commons.mapper.UserMapper;
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
        UserRegisDto userRegisDto = UserMapper.INSTANCE.modelToDto( user );

        //then
        assertThat( userRegisDto ).isNotNull();
        assertThat( userRegisDto.getEmail() ).isEqualTo( "anton@email.com" );
        assertThat( userRegisDto.getPassword() ).isEqualTo( "123" );
        assertThat( userRegisDto.getUsername() ).isEqualTo( "anton" );
    }
}
