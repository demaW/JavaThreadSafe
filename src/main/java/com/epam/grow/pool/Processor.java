package com.epam.grow.pool;

public class Processor implements Runnable {
    public int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Process " + this.id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("Process " + this.id + " completed");
    }
}
