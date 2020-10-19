package ir.javacup.thread;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    static final ConcurrentLinkedDeque<Integer> holder = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Producer producer = new Producer(resource, holder, 10);
        Consumer consumer = new Consumer(resource, holder, 10);
        consumer.start();
        producer.start();

        consumer.join();
        producer.join();

        System.out.println(holder);
    }

}