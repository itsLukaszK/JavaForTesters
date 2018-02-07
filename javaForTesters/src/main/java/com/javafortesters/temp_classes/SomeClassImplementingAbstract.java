package com.javafortesters.temp_classes;

import com.javafortesters.temp_abstract_classes.SomeAbstractClass;
import com.javafortesters.temp_interfaces.SomeInterface;
import com.javafortesters.temp_interfaces.SomeOtherInterface;

public class SomeClassImplementingAbstract extends SomeAbstractClass implements SomeInterface, SomeOtherInterface {
    @Override
    public void voidMethod() {
        System.out.println(string);
    }

    @Override
    public String returnString(String string) {
        string = this.string;
        return super.returnString(string);
    }

    @Override
    public void someMethod() {

    }

    @Override
    public void calculateSth(int sth) {

    }

    @Override
    public void someOtherMethod(String name) {

    }
}
