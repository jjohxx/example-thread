package com.example.thread;

import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonatan Mamani
 */
@Service
public class CustomService {

    public void show(String pop) {
        System.out.printf(" cleanup() %s ", pop);
        System.out.println("");
    }
}
