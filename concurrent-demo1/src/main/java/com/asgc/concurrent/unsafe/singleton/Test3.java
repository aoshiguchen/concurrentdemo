package com.asgc.concurrent.unsafe.singleton;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 枚举单例测试
 * Author: yangwen
 * Date:  2019/7/2
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(EnumSingleton.getInstance());
        System.out.println(getSingleton());
        System.out.println(EnumSingleton.getInstance() == getSingleton());
    }

    public static EnumSingleton getSingleton(){
        EnumSingleton singleton = null;

        try{
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            Class clazz = EnumSingleton.class;
            singleton = (EnumSingleton) unsafe.allocateInstance(clazz);
        }catch(Exception e){
            e.printStackTrace();
        }

        return singleton;
    }
}
