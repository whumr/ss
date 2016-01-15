package com.savior.common;

/**
 * Created by Administrator on 2015/2/9.
 */
public class Constants {

    public static class ErrorMsg {
        public static class Common {
            public static String SystemError = "系统异常";
            public static String IllegalArgument = "参数不正确";
            public static String FileTooLarge = "file too large";
            public static String NotLogin = "用户未登录";
        }
        public static class Account {
            public static String AccountExists = "手机号已存在";
            public static String NotExists = "账号不存在";
            public static String LoginFail = "用户名或密码错误";
        }
    }

    public static class Keys {
        public static class Session {
            public static String KeyAccount = "account";
        }
    }

    public static class Path {
        public static String Img = "/imgs/";
        public static String UserImg = Img + "users/";
    }
}
