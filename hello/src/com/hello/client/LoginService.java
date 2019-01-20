package com.hello.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service/loginservice")
public interface LoginService extends RemoteService {
	public User getUser(String username, String password);
}
