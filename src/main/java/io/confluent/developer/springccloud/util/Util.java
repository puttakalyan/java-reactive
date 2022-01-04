package io.confluent.developer.springccloud.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();

    public static Faker getFaker(){
        return FAKER;
    }

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received ---> " + o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR ---> " + e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber(){
        return new CustomSubscriber();
    }


}
