package com.hbase.core.usermgr;

import com.hbase.core.usermgr.model.UserInfo;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 18:39
 **/
public interface IUserService {
    public boolean addUser(UserInfo userInfo);

    public boolean updateUserInfo(String userId, String password, String detail);

    public boolean deleteUser(String userId);

    public UserInfo getUserInfo(String userId);

    public UserInfo getUserInfoByName(String userName);

    public UserInfo checkPassword(String userName, String password);


}
