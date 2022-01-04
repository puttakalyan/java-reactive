package io.confluent.developer.springccloud.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassC {

    @Autowired
    private ClassB b;
    public String helloC(){
        return b.helloB();
    }
}