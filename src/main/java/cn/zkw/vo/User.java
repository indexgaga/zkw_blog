package cn.zkw.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class User implements Serializable {
    private Integer user_id;
    private String user_ip;
    private String user_name; //用户名&账号
    private String user_password;
    private String user_email;
    private String user_photo;
    private Integer user_level;
    private Integer user_rights; //用户权限,0为普通用户,1为1级会员
    private Date user_registration_time; //注册日期
    private Date user_birthday;
    private Integer user_telephone_number; //电话
    private String user_nickname; //用户昵称
    private Integer user_lock;

    public Integer getUser_lock() {
        return user_lock;
    }

    public void setUser_lock(Integer user_lock) {
        this.user_lock = user_lock;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public Integer getUser_level() {
        return user_level;
    }

    public void setUser_level(Integer user_level) {
        this.user_level = user_level;
    }

    public Integer getUser_rights() {
        return user_rights;
    }

    public void setUser_rights(Integer user_rights) {
        this.user_rights = user_rights;
    }

    public Date getUser_registration_time() {
        return user_registration_time;
    }

    public void setUser_registration_time(Date user_registration_time) {
        this.user_registration_time = user_registration_time;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public Integer getUser_telephone_number() {
        return user_telephone_number;
    }

    public void setUser_telephone_number(Integer user_telephone_number) {
        this.user_telephone_number = user_telephone_number;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_ip='" + user_ip + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", user_level='" + user_level + '\'' +
                ", user_rights='" + user_rights + '\'' +
                ", user_registration_time=" + user_registration_time +
                ", user_birthday=" + user_birthday +
                ", user_telephone_number=" + user_telephone_number +
                ", user_nickname='" + user_nickname + '\'' +
                '}';
    }
}
