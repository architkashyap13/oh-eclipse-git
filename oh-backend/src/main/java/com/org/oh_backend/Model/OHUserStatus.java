package com.org.oh_backend.Model;

public enum OHUserStatus {
	ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");
     
    private String status;
     
    private OHUserStatus(final String status){
        this.status = status;
    }
     
    public String getStatus(){
        return this.status;
    }
 
    @Override
    public String toString(){
        return this.status;
    }
 
 
    public String getName(){
        return this.name();
    }
}
