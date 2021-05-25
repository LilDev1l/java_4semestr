package com.example.lab10.model;

import com.example.lab10.db.Identified;

public class User implements Identified<Integer> {
    private int id;
    private String login;
    private String password;
    private ROLE role;

    //region Getter and Setter
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
    //endregion

    public enum ROLE {
        ADMIN, USER, UNKNOWN
    }
}


