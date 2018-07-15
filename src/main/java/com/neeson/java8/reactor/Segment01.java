package com.neeson.java8.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: neeson
 * Date: 2018/3/24
 * Time: 13:02
 * Description:
 */
public class Segment01 {

    public static void main(String[] args) {
        new Segment01().run();
    }

    public void run(){
        test1();
    }

    void test1(){
        Flux.just("Hello","World").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1,2,3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1,20).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
    }

    void generate(){
        Flux.generate(sink ->{
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new,(list,sink) ->{
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10){
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    void create(){
        Flux.create(sink -> {
            for (int i = 0; i <10 ; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }

    void mono(){
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(monoSink -> monoSink.success("Hello")).subscribe(System.out::println);
    }


    void buffer(){
        Flux.range(1,100).buffer(20).subscribe(System.out::println);
        Flux.interval(Duration.of(100,ChronoUnit.SECONDS)).buffer(1001).take(2).toStream().forEach(System.out::print);
        Flux.range(1,10).bufferUntil(i -> i%2 == 0).subscribe(System.out::println);
        Flux.range(1,10).bufferWhile(i -> i%2 == 0).subscribe(System.out::println);
    }

    void window(){
        Flux.range(1,100).window(20).subscribe(System.out::println);
    }

    void zipWith(){
        Flux.just("a","b")
                .zipWith(Flux.just("c","d"))
                .subscribe(System.out::println);
        Flux.just("a","b")
                .zipWith(Flux.just("c","d"),(s1,s2) -> String.format("%s-%s",s1,s2))
                .subscribe(System.out::println);
    }

}
