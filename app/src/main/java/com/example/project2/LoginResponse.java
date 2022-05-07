package com.example.project2;

class User{

    private int id;
    private String email;
    private String username;
    private String name;
    private String phone;
    private String credit_card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getemail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}

public class LoginResponse {


    private String access_token;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getaccess_token() {
        return access_token;
    }

    public void setaccess_token(String access_token) {
        this.access_token = access_token;
    }

}
