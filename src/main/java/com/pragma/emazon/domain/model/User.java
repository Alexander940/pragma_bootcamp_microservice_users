package com.pragma.emazon.domain.model;

import java.util.Calendar;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private String documentID;
    private String phone;
    private Calendar birthday;
    private String email;
    private String password;
    private Integer locked;
    private Integer disabled;
    private Role role;
    private String roleName;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.documentID = builder.documentID;
        this.phone = builder.phone;
        this.birthday = builder.birthday;
        this.email = builder.email;
        this.password = builder.password;
        this.locked = builder.locked;
        this.disabled = builder.disabled;
        this.role = builder.role;
        this.roleName = builder.roleName;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String lastname;
        private String documentID;
        private String phone;
        private Calendar birthday;
        private String email;
        private String password;
        private Integer locked;
        private Integer disabled;
        private Role role;
        private String roleName;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder documentID(String documentID) {
            this.documentID = documentID;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder birthday(Calendar birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder locked(Integer locked) {
            this.locked = locked;
            return this;
        }

        public Builder disabled(Integer disabled) {
            this.disabled = disabled;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
