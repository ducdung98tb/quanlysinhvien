package com.hello.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service/getListStudent")
public interface RootService extends RemoteService {
	public List<User> getStudentByRoot();
	public boolean addStudent(String userId, String userName, String password);
	public boolean deleteUser(String userId);
}
