package com.czy.controller;

import com.czy.common.R;
import com.czy.entity.UserOnline;
import com.czy.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @GetMapping("index")
    public String online() {
        return "online";
    }

    @ResponseBody
    @GetMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }

    @ResponseBody
    @GetMapping("forceLogout")
    public R<Void> forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("踢出用户失败");
        }
    }
}
