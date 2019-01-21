package com.hello.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RootServiceAsync {

	void getStudentByRoot(AsyncCallback<List<User>> callback);

	void addStudent(String userId, String userName, String password, AsyncCallback<Boolean> callback);

	void deleteUser(String userId, AsyncCallback<Boolean> callback);

}
