package com.javafortesters.temp_classes;

import com.javafortesters.temp_interfaces.SomeInterface;
import com.javafortesters.temp_interfaces.SomeOtherInterface;

public class SomeClass implements SomeInterface, SomeOtherInterface {
    @Override
    public void someMethod() {
        System.out.println("Sth");
    }

    @Override
    public void calculateSth(int sth) {
        System.out.println(sth + name);
    }

    @Override
    public void someOtherMethod(String name) {
        name = this.name;
        System.out.println(name);
    }
}
