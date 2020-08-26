package com.leo.learn.arch.session11.domain.service;

import com.leo.learn.arch.session11.Application;
import com.leo.learn.arch.session11.domain.dao.UserRepo;
import com.leo.learn.arch.session11.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class UserService {
  static Logger log = LoggerFactory.getLogger(UserService.class);

  PwdService pwdService;

  UserRepo userRepo;

  public UserService() {
    pwdService = Application.pwdService;
    userRepo = Application.userRepo;
  }

  public void saveUser(String id, String pwd) {

    if(id == null || id.equals("") || pwd == null || pwd.equals("")) return;
    else{
      String salt = pwdService.generateSalt();
      String hashedPwd = pwdService.getHashedPassword(pwd, salt);
      User user = User.builder()
              .id(id)
              .salt(salt)
              .pwd(hashedPwd)
              .generateTime(new Date())
              .build();
      log.debug("saved user {}", user);
      userRepo.saveUser(user);
    }
  }

  public boolean checkPW(String id, String pwd) {
    log.debug("checkPW pwd {}", pwd);
    User user = userRepo.findUserById(id);
    log.debug("checkPW user.pwd {}", user.getPwd());
    log.debug("checkPW user.salt {}", user.getSalt());
    return user.getPwd().equals(pwdService.getHashedPassword(pwd, user.getSalt()));
  }
}
