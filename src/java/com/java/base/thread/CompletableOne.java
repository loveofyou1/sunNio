package com.java.base.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description CompletableOne
 * @Author sunlei19
 * @Date 2021/1/30 15:09
 * @Version 1.0
 */
public class CompletableOne {

    public static void main(String[] args) {
        //completableFutureAnyOfTest();
        //completableFutureThenApplyTest();
//        completableFutureThreadTest();
        //completableFutureCombineTest();
        //completableFutureApplyToEitherTest();
        completableFutureWhenCompleteTest();
    }

    private static void completableFutureAnyOfTest() {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello world1 start!");
            sleep(2000);
            System.out.println("Hello world1 wake!");
            return "Hello world1 finished!";
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello world2 start!");
            sleep(1000);
            System.out.println("Hello world2 wake!");
            return "Hello world2 finished!";
        });
        CompletableFuture completableFutureAny = CompletableFuture.anyOf(completableFuture1, completableFuture2);
        try {
            System.out.println(completableFutureAny.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completableFutureThenApplyTest() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("task 1 start");
            return "task 1 end";
        }).thenApply(s -> {
            System.out.println(s + "  task 2 start");
            return "task 2 end";
        });
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completableFutureThreadTest() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync thread name = " + Thread.currentThread().getName());
            return "task one ";
        }).thenApplyAsync(s -> {
            System.out.println("thenApplyAsync thread name = " + Thread.currentThread().getName());
            return "task two";
        });

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync thread name = " + Thread.currentThread().getName());
            return "task one";
        }).thenApply(s -> {
            System.out.println("thenApply thread name = " + Thread.currentThread().getName());
            return "task two";
        });

        try {
            System.out.println(completableFuture.get());
            System.out.println(completableFuture1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completableFutureCombineTest() {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "hello world1 ");

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("task two ");
            return "hello world2 ";
        }).thenCombine(completableFuture1, (s1, s2) -> s1 + ":" + s2);

        try {
            System.out.println(completableFuture2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completableFutureApplyToEitherTest() {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello world1 start!");
            sleep(200);
            System.out.println("Hello world1 wake!");
            return "Hello world1 finished!";
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello world2 start!");
            sleep(100);
            System.out.println("Hello world2 wake!");
            return "Hello world2 finished!";
        }).applyToEither(completableFuture1, (r) -> {
            System.out.println("Hello world applyToEither start!");
            return r;
        });
        try {
            System.out.println(completableFuture2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void completableFutureWhenCompleteTest() {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                return "success";
            } else {
                throw new RuntimeException();
            }
        }).whenComplete((r, e) -> {
            System.out.println("result1:" + r);
            System.out.println("exception1:" + e);
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            if (false) {
                return "success";
            } else {
                throw new RuntimeException();
            }
        }).whenComplete((r, e) -> {
            System.out.println("result2:" + r);
            System.out.println("exception2:" + e);
        });

        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(() -> "hello compose")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "sou"));
        try {
            System.out.println("get1:" + completableFuture1.get());
            System.out.println("get compse:" + objectCompletableFuture.get());
            System.out.println("get2:" + completableFuture2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
