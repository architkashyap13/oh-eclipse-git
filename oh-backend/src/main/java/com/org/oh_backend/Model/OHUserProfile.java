package com.org.oh_backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_PROFILE")
public class OHUserProfile {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
 
    @Column(name="TYPE", length=15, unique=true, nullable=false)
    private String type = OHUserProfileType.USER.getUserProfileType();
     
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
}
