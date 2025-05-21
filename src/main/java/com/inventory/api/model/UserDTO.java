package com.inventory.api.model;

import java.util.List;

public class UserDTO {

    private String name;
    private String mail;
    private String password;
    private List<Long> permissionsIds;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Long> getPermissionsIds() {
        return permissionsIds;
    }

    public void setPermissionsIds(List<Long> permissionsIds) {
        this.permissionsIds = permissionsIds;
    }
}
