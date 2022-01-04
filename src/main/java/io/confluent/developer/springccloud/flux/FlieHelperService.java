package io.confluent.developer.springccloud.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FlieHelperService {

    public void writeFile(Path path){

        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
            for(int i = 1; i<= 100; i++){
                bufferedWriter.write("This is line no: " + i);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private Callable<BufferedReader> getBufferedReader(Path path){
        return () -> Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> getFunction(){
        return (bufferedReader, stringSynchronousSink) -> {
            System.out.println("Emitting...");
            try {
                String line = bufferedReader.readLine();
                if(line != null)
                    stringSynchronousSink.next(line);
                else
                    stringSynchronousSink.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bufferedReader;
        };
    }

    private Consumer<BufferedReader> getConsumer(){
        return bufferedReader -> {
            try {
                System.out.println("Closing the BufferedReader");
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public Flux<String> readFile(Path path){
        return Flux.generate(getBufferedReader(path), getFunction(), getConsumer());
    }
}
