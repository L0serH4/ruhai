package com.lx.ruhai.mapper;

import com.lx.ruhai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
     User queryUserByName(String name);

}
