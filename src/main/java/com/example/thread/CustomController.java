package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jhonatan Mamani
 */
@RestController
public class CustomController {

    @Autowired
    private CustomThread customThread;

    @PostConstruct
    public void init() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(customThread);
    }

    @GetMapping(value = "/message")
    public String getMessage() {
        customThread.add("from rest controller X");
        System.out.println("done");
        return "done";
    }
}
