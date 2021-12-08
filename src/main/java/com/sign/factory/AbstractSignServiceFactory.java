package com.sign.factory;

import com.sign.dto.SignConfigDTO;

public abstract class AbstractSignServiceFactory {

  private SignConfigDTO signConfigDTO;
  private Boolean hasSign = false;

  public abstract String sign();

  public SignConfigDTO getSignConfigDTO() {
    return signConfigDTO;
  }

  public void setSignConfigDTO(SignConfigDTO signConfigDTO) {
    this.signConfigDTO = signConfigDTO;
  }

  public Boolean getHasSign() {
    return hasSign;
  }

  public void setHasSign(Boolean hasSign) {
    this.hasSign = hasSign;
  }
}
