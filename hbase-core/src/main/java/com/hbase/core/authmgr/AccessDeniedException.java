package com.hbase.core.authmgr;

import com.hbase.core.ErrorCodes;
import com.hbase.core.HosException;

public class AccessDeniedException extends HosException {

  public AccessDeniedException(String message, Throwable cause) {
    super(message, cause);
  }

  public AccessDeniedException(String resPath, long userId, String accessType) {
    super(String.format("access denied:%d->%s,%s", userId, resPath, accessType), null);
  }

  public AccessDeniedException(String resPath, long userId) {
    super(String.format("access denied:%d->%s not owner", userId, resPath), null);
  }

  @Override
  public int errorCode() {
    return ErrorCodes.ERROR_PERMISSION_DENIED;
  }
}
