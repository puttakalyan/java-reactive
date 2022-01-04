package io.confluent.developer.springccloud.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public
class ClassB {

    @Autowired
    private ClassA a;
    public String helloB(){
        return a.helloA();
    }
}