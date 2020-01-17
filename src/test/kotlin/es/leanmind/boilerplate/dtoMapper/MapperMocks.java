package es.leanmind.boilerplate.dtoMapper;

import es.leanmind.boilerplate.app.user.UserDto;
import es.leanmind.boilerplate.app.user.UserDtoMapper;
import es.leanmind.boilerplate.app.user.UserStubs;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.when;

public class MapperMocks {

    public void initMocks(UserDtoMapper userDtoMapper){
        when(userDtoMapper.toUser(ArgumentMatchers.any(UserDto.class))).thenReturn(UserStubs.generateUser());
    }

}
