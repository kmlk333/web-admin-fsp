package com.lti.fsp.request;

import com.lti.fsp.dto.UserDTO;

public class Global {
	
	private String apiName;
	private UserDTO userData;
	
	
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public UserDTO getUserData() {
		return userData;
	}
	public void setUserData(UserDTO userData) {
		this.userData = userData;
	}
	@Override
	public String toString() {
		return "Global [apiName=" + apiName + ", userData=" + userData + "]";
	}
	
	
}
