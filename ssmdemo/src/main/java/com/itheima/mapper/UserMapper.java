package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from t_user where name=#{name} and password=#{password}")
    public User login(User user);

}
