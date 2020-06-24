package com.leo.learn.arch.session3;

import com.leo.learn.arch.session3.components.*;

public class Main {

  public static void main(String[] args) {
    WinForm form = new WinForm();
    Picture pic = new Picture("LOGO图片");
    Button btn1 = new Button("登录");
    Button btn2 = new Button("注册");

    Frame frame = new Frame();

    Label lab1 = new Label("用户名");
    TextBox tb1 = new TextBox("文本框");
    Label lab2 = new Label("密码");
    PasswordBox pb = new PasswordBox("密码框");
    CheckBox cb = new CheckBox("复选框");
    TextBox tb2 = new TextBox("记住用户名");
    LinkLable ll = new LinkLable("忘记密码");
    frame.add(lab1);
    frame.add(tb1);
    frame.add(lab2);
    frame.add(pb);
    frame.add(cb);
    frame.add(tb2);
    frame.add(ll);

    form.add(pic);
    form.add(btn1);
    form.add(btn2);
    form.add(frame);

    form.print();

  }

}
