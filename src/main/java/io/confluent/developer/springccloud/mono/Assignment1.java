package io.confluent.developer.springccloud.mono;

import io.confluent.developer.springccloud.util.FileService;
import io.confluent.developer.springccloud.util.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import javax.validation.executable.ValidateOnExecution;

public class Assignment1 {

    public static void main(String[] args) {

        FileService service = new FileService();
        //write
        Mono<Void> write = service.write("File3.txt", "Hello this is new file....3");
        write.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        Util.sleep(1);
        //read
        Mono<String> read = service.read("File3.txt");
        read.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        Util.sleep(1);
        //delete
        Mono<Void> delete = service.delete("File3.txt");
        delete.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
