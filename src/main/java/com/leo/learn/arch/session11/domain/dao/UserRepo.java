package com.leo.learn.arch.session11.domain.dao;

import com.leo.learn.arch.session11.domain.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {

  Map<String, User> users;

  public UserRepo() {
    users = new HashMap();
  }

  public User saveUser(User user) {
    if(user.getId() == null) return null;
    else{
      this.users.put(user.getId(), user);
      return user;
    }
  }

  public boolean login(String id, String pwd) {
    User user = users.get(id);
    String storedPWD = user.getPwd();
    return pwd.equals(storedPWD);
  }

  public User findUserById(String id) {
    return users.get(id);
  }
}
