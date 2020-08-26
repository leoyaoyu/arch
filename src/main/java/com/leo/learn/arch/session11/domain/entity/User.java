package com.leo.learn.arch.session11.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

  private String id;

  private String nickName;

  private String pwd;

  private String salt;

  private Date generateTime;

}
