package com.org.oh_backend.Model;

public enum OHUserProfileType {
	USER("USER"),
    IRM("IRM"),
    HRBP("HRBP"),
	ADMIN("ADMIN");
     
    String userProfileType;
     
    private OHUserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
}
