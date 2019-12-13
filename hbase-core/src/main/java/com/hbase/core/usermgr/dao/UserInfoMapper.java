package com.hbase.core.usermgr.dao;

import com.hbase.core.usermgr.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 18:22
 **/
@Mapper
public interface UserInfoMapper {

    void addUser(@Param("userInfo")UserInfo userInfo);
    void  deleteUser(@Param("userId")String userId);

    int updateUserInfo(@Param("userId")String userId,@Param("password")String password
    ,@Param("detail")String detail);

    UserInfo getUserInfo(@Param("userId")String userId);
    UserInfo getUserInfoByName(@Param("userName")String userName);
    UserInfo checkPassword(@Param("userName")String userName,@Param("password")String password);
}
