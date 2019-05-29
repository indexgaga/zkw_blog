package cn.zkw.controller;

import cn.zkw.util.encrypt.MyPasswordEncrypt;

public class test1 {
    public static void main(String args[]){
        String password =   MyPasswordEncrypt.encryptPassword("123");
        System.out.println(password);
    }
}