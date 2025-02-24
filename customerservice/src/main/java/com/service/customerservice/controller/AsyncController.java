package com.service.customerservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
@Tag(name = "Async APIs ",description = "Aysnc APIs to run asyncronous tasks")
@RequestMapping("/v1")
@RestController
public class AsyncController {

    public final ExecutorService executorService = Executors.newFixedThreadPool(4);


    @GetMapping(value = "/asyncPrint/{str}")
    public CompletableFuture<String> AsyncMethod(@PathVariable String str){

       return CompletableFuture.supplyAsync(()->{
           System.out.println("Executing Async Thread "+ str +"  "+ Thread.currentThread().getName());
           return "Task Exected";
       },executorService);
    }

}
