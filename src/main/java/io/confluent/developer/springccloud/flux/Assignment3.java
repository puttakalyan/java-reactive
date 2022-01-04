package io.confluent.developer.springccloud.flux;

import io.confluent.developer.springccloud.util.Util;
import reactor.core.publisher.Flux;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Assignment3 {

    public static final Path PATH = Paths.get("src/main/resources/assignment/sec02/File01.txt");

    public static void main(String[] args) {

    FlieHelperService flieHelperService = new FlieHelperService();

        Flux<String> stringFlux = flieHelperService.readFile(PATH);

        stringFlux
                .log()
                .map(line -> {
                    int num = Util.getFaker().random().nextInt(0, 10);
                    if (num>8)
                       throw new RuntimeException("Exiting because the number grater than 8");
                    return line;
                })
                .subscribe(Util.subscriber());


    }
}
