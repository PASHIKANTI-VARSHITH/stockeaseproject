package com.mini.stockeaseproject.Model;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String username;
    private String usermobilenumber;
    private String useremail;
    private String shopname;
    private String gstnumber;
    private String password;
    private String retrypassword;


    //no parameter constructor:
    public User() {
    }

    //parameterized constuctor:
    public User(String username, String usermobilenumber, String useremail, String shopname, String gstnumber, String password, String retrypassword) {
        this.username = username;
        this.usermobilenumber = usermobilenumber;
        this.useremail = useremail;
        this.shopname = shopname;
        this.gstnumber = gstnumber;
        this.password = password;
        this.retrypassword = retrypassword;
    }

    public User(String usermobilenumber, String password) {
        this.usermobilenumber = usermobilenumber;
        this.password = password;
    }
    //getter and setters :

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermobilenumber() {
        return usermobilenumber;
    }

    public void setUsermobilenumber(String usermobilenumber) {
        this.usermobilenumber = usermobilenumber;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getGstnumber() {
        return gstnumber;
    }

    public void setGstnumber(String gstnumber) {
        this.gstnumber = gstnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetrypassword() {
        return retrypassword;
    }

    public void setRetrypassword(String retrypassword) {
        this.retrypassword = retrypassword;
    }
}
