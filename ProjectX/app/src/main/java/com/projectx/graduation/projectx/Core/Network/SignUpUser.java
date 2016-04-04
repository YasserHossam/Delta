package com.projectx.graduation.projectx.Core.Network;

import com.projectx.graduation.projectx.Core.Models.Device;
import com.projectx.graduation.projectx.Core.Models.User;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface SignUpUser {
  public  void userSignUp(User user , Device device , Iresponse response) ;
}
