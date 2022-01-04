package io.confluent.developer.springccloud;

import io.confluent.developer.springccloud.Test.AppConfig;
import io.confluent.developer.springccloud.Test.ClassA;
import io.confluent.developer.springccloud.Test.ClassB;
import io.confluent.developer.springccloud.Test.ClassC;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


//@ExtendWith(SpringExtension.class)

//@RunWith(SpringRunner.class)

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class ClassABC {

    @MockBean
    ClassA a;

    @MockBean
    @Autowired
    ClassB b;

    @MockBean
    @Autowired
    ClassC c;

    @Test
    public void test(){
//        MockitoAnnotations.initMocks(this);
        System.out.println(c.helloC());
    }



}
