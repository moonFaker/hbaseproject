package com.hbase.core.authmgr.model;

import com.hbase.core.usermgr.CoreUtil;

import java.util.Date;


/**
 * Created by jixin on 18-3-8.
 */
public class TokenInfo {

  private String token;
  private int expireTime;
  private Date refreshTime;
  private Date createTime;
  private boolean active;
  private String creator;

  public TokenInfo() {

  }

  public TokenInfo(String creator) {
    this.token = CoreUtil.getUUIDStr();
    this.expireTime = 7;
    Date date = new Date();
    this.refreshTime = date;
    this.createTime = date;
    this.active = true;
    this.creator = creator;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public int getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(int expireTime) {
    this.expireTime = expireTime;
  }

  public Date getRefreshTime() {
    return refreshTime;
  }

  public void setRefreshTime(Date refreshTime) {
    this.refreshTime = refreshTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }
}
