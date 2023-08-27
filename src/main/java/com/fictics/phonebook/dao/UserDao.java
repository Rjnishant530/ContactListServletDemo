package com.fictics.phonebook.dao;

import com.fictics.phonebook.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    //CRUD

    @Insert("insert into USERS (name,email,password,created_at) values (#{name},#{email},#{password},#{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void createUser(User user);

    //Queries

    @Select("select * from USERS where email=#{email}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    public User getUserByEmail(String email);
}
