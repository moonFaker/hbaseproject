package com.hbase.core.authmgr;


import com.hbase.core.authmgr.model.ServiceAuth;
import com.hbase.core.authmgr.model.TokenInfo;

import java.util.List;

/**
 * Created by jixin on 18-3-8.
 */
public interface IAuthService {

  public boolean addAuth(ServiceAuth auth);

  public boolean deleteAuth(String bucketName, String token);

  public boolean deleteAuthByBucket(String bucketName);

  public boolean deleteAuthByToken(String token);

  public ServiceAuth getServiceAuth(String bucketName, String token);

  public boolean addToken(TokenInfo tokenInfo);

  public boolean updateToken(String token, int expireTime, boolean isActive);

  public boolean refreshToken(String token);

  public boolean deleteToken(String token);

  public boolean checkToken(String token);

  public TokenInfo getTokenInfo(String token);

  public List<TokenInfo> getTokenInfos(String creator);
}
