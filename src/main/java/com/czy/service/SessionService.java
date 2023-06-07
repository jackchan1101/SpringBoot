package com.czy.service;

import com.czy.entity.UserOnline;

import java.util.List;


public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
