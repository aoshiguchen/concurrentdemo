package com.asgc.concurrent.unsafe.singleton;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * TODO
 * Author: yangwen
 * Date:  2019/7/2
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(EnumSingleton2.SINGLETON);
        System.out.println(getSingleton());
        System.out.println(EnumSingleton2.SINGLETON == getSingleton());
    }

    public static EnumSingleton2 getSingleton(){
        EnumSingleton2 singleton = null;

        try{
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            Class clazz = EnumSingleton2.class;
            singleton = (EnumSingleton2) unsafe.allocateInstance(clazz);
        }catch(Exception e){
            e.printStackTrace();
        }

        return singleton;
    }
}
