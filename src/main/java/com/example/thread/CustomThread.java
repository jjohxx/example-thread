package com.example.thread;

import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonatan Mamani
 */
@Service
public class CustomThread implements Runnable {

    private static final int TIME_TO_SLEEP = 2000;

    private final Stack<String> stack;

    @Autowired
    private CustomService service;

    public CustomThread() {
        this.stack = new Stack<>();
    }

    public void add(String string) {
        stack.add(string);
    }

    @Override
    public void run() {
        try {
            while (Boolean.TRUE) {
                if (stack.isEmpty()) {
                    Thread.sleep(TIME_TO_SLEEP);
                } else {
                    service.show(stack.pop());
                }
            }
        } catch (InterruptedException ex) {
        }
    }
}
