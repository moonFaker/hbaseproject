package com.hbase.core.test;


import com.hbase.core.usermgr.CoreUtil;
import com.hbase.core.usermgr.IUserService;
import com.hbase.core.usermgr.model.SystemRole;
import com.hbase.core.usermgr.model.UserInfo;
import com.hbase.mybatis.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by jixin on 18-3-8.
 */
public class UserServiceTest extends BaseTest {

  @Autowired
  @Qualifier("userServiceImpl")
  IUserService userService;

  @Test
  public void addUser() {
    UserInfo userInfo =  new UserInfo(CoreUtil.SYSTEM_USER, "superadmin", SystemRole.SUPERADMIN,
            "this is superadmin");
    userService.addUser(userInfo);
  }

  @Test
  public void getUser() {
    UserInfo userInfo = userService.getUserInfoByName("jixin");
    System.out
        .println(
            userInfo.getUserId() + "|" + userInfo.getUserName() + "|" + userInfo.getPassword());
  }

  @Test
  public void deleteUser() {
    UserInfo userInfo = userService.getUserInfoByName("jixin");
    userService.deleteUser(userInfo.getUserId());
  }
}
