package org.example.interview;

import java.util.concurrent.*;

public class CompletableFutureAllAny {
  public static void main(String[] args) throws Exception {
    ExecutorService ex = Executors.newFixedThreadPool(3);
    CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "A", ex);
    CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "B", ex);
    CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "C", ex);

    CompletableFuture<Object> any = CompletableFuture.anyOf(f1, f2, f3);
    System.out.println("anyOf result=" + any.get());

    CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
    all.join();
    System.out.println("allOf done");
    ex.shutdown();
  }
}
