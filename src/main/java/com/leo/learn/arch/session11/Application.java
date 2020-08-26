package com.leo.learn.arch.session11;

import com.leo.learn.arch.session11.domain.dao.UserRepo;
import com.leo.learn.arch.session11.domain.service.PwdService;
import com.leo.learn.arch.session11.domain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

  static Logger log = LoggerFactory.getLogger(Application.class);

  public static UserRepo userRepo = new UserRepo();
  public static PwdService pwdService = new PwdService();
  public static UserService userService = new UserService();

  public static void main(String[] args) {
    String id = "jiagoushixunlianying11";
    String pwd = "hellowPassword123";

    String id2 = "jiagoushixunlianying12";
    String pwd2 = "hellowPassword121";

    log.info("register user with id {} and pwd {}", id, pwd);
    userService.saveUser(id, pwd);
    log.info("register user2 with id {} and pwd {}", id2, pwd2);
    userService.saveUser(id2, pwd2);

    log.info("login with id {} and pwd {}", id, pwd);
    Boolean logged = userService.checkPW(id, pwd);
    log.info("logged result {}", logged);

    log.info("login with id {} and pwd {}", id2, pwd2);
    Boolean logged2 = userService.checkPW(id2, pwd2);
    log.info("logged result2 {}", logged2);

    log.info("login3 with id {} and pwd {}", id, pwd2);
    Boolean logged3 = userService.checkPW(id, pwd2);
    log.info("logged3 result {}", logged3);

  }
}
