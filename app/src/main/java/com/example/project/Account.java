package com.example.project;

import java.util.ArrayList;

public class Account
{
    private String name;
    private String pass;
    private String Phone;
    private String E_mail;
    //the Accounts data
    public static ArrayList<Account> users = new ArrayList<Account>();
    public static ArrayList<Account> admins = new ArrayList<Account>();



    public static ArrayList<Account> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<Account> user) {
        Account.users = user;
    }

    public static ArrayList<Account> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Account> admins) {
        this.admins = admins;
    }
    //end of the Accounts data


    public Account(String name, String pass, String phone, String e_mail) {
        this.name = name;
        this.pass = pass;
        Phone = phone;
        E_mail = e_mail;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }
}
