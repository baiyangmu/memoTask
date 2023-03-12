package com.baiyangmu.memotask.mapper;

import com.baiyangmu.memotask.entity.User;
import com.baiyangmu.memotask.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserConvert {

    UserConvert USER_INSTANCE = Mappers.getMapper(UserConvert.class);
    UserVo toUserDTO(User user);

    UserConvert USER_VO_INSTANCE = Mappers.getMapper(UserConvert.class);
    User toUser(UserVo userVo);

}
