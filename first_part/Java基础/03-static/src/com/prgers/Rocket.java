package com.prgers;

/**
 * 单例模式
 */
public class Rocket {
    //饿汉式
//    private static Rocket instance = new Rocket();
//    private Rocket(){}
//    public static Rocket getInstance() {
//        return instance;
//    }

    //懒汉式
    private static Rocket instance = null;
    private Rocket(){}
    public static Rocket getInstance() {
        if (instance == null) {
            instance = new Rocket();
        }
        return instance;
    }
}
