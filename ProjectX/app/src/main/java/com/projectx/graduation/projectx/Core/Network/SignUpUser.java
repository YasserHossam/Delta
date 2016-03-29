package com.projectx.graduation.projectx.Core.Network;

import com.projectx.graduation.projectx.API.Iresponse;
import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface SignUpUser {
  public   void userSignUp(User user , Device device , Iresponse response) ;
}
