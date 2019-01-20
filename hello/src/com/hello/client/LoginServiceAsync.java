package com.hello.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface LoginServiceAsync {

	void getUser(String username, String password, AsyncCallback<User> callback);



}
