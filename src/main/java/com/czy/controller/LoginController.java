package com.czy.controller;

import com.czy.common.R;
import com.czy.entity.UserInfo;
import com.czy.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public R<Void> login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (UnknownAccountException e) {
            return R.fail(e.getMessage());
        } catch (AuthenticationException e) {
            return R.fail("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
