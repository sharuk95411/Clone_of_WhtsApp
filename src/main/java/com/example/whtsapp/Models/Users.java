package com.example.whtsapp.Models;

public class Users {

    String profilepic,username, mail,password, userId,lasemessage;

    public Users(String profilepic, String username, String mail, String password, String userId, String lasemessage) {
        this.profilepic = profilepic;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lasemessage = lasemessage;
    }
public Users() { }
// Constructor for Sign-Up
    public Users(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }
    
        public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLasemessage() {
        return lasemessage;
    }

    public void setLasemessage(String lasemessage) {
        this.lasemessage = lasemessage;
    }
}
