package com.asgc.concurrent.ParameterizedType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test2{
    public static void main(String[] args){
        Foo2<String> foo = new Foo2<String>(){};
        // 在类的外部这样获取
        Type type = ((ParameterizedType)foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);
        // 在类的内部这样获取
        System.out.println(foo.getTClass());
    }
}

class Foo2<T>{
    public Class<T> getTClass(){
    	Foo2<T> foo = new Foo2<T>(){};
        Class<T> tClass = (Class<T>)((ParameterizedType)foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
}