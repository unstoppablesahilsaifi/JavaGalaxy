package MultiThreadingMastery;
/*Future<Integer> f = executor.submit(task);
Integer result = f.get();   // ❌ BLOCKING
👉 Jab tak result nahi aata, thread ruk jaata hai
👉 CPU waste
👉 Scale nahi karta
Industry ko chahiye tha:

✔ Async execution
✔ Result aaye tab automatic next step
✔ Thread block na ho

👉 Isi problem ka solution = CompletableFuture

CompletableFuture = Async ka result + next steps + non-blocking execution

❌ Future ki Limitations
get() → blocking
Chaining nahi
Callbacks nahi

✅ CompletableFuture Kya-Kya Deta Hai
Async execution
Non-blocking callbacks
Method chaining
Error handling
Parallel execution


*/

import java.util.concurrent.*;

// THREAD CLASS (ALAG RAKHI HAI)
// ===============================
class HeavyCalculationTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() +
                " : Heavy calculation started...");

        Thread.sleep(2000);   // simulate delay

        return 10 + 20;
    }
}
public class Step19_CompletableFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // =====================================
        // 1️⃣ FUTURE (BLOCKING DEMO)
        // =====================================
        System.out.println("---- FUTURE BLOCKING DEMO ----");

        Future<Integer> future =
                executor.submit(new HeavyCalculationTask());

        System.out.println("Main thread waiting...");
        Integer futureResult = future.get();   // ❌ BLOCKING
        System.out.println("Future Result = " + futureResult);


        // =====================================
        // 2️⃣ COMPLETABLEFUTURE SIMPLE ASYNC
        // =====================================
        System.out.println("\n---- COMPLETABLEFUTURE ASYNC ----");

        CompletableFuture<Void> cf1 =
                CompletableFuture.runAsync(() -> {
                    System.out.println(Thread.currentThread().getName()
                            + " : Async task running");
                });


        // =====================================
        // 3️⃣ SUPPLYASYNC + RESULT
        // =====================================
        CompletableFuture<Integer> cf2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName()
                            + " : Supplying value");
                    return 50;
                });

        cf2.thenAccept(result ->
                System.out.println("CF Result = " + result)
        );


        // =====================================
        // 4️⃣ CHAINING
        // =====================================
        System.out.println("\n---- CHAINING ----");

        CompletableFuture<Integer> chain =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(r -> r * 2)
                        .thenApply(r -> r + 5);

        chain.thenAccept(r ->
                System.out.println("Chained Result = " + r)
        );


        // =====================================
        // 5️⃣ ERROR HANDLING
        // =====================================
        System.out.println("\n---- ERROR HANDLING ----");

        CompletableFuture<Integer> errorCF =
                CompletableFuture.supplyAsync(() -> {
                    if (true)
                        throw new RuntimeException("Something wrong");
                    return 100;
                }).exceptionally(ex -> {
                    System.out.println("Exception handled: "
                            + ex.getMessage());
                    return 0;
                });

        errorCF.thenAccept(r ->
                System.out.println("After Error Value = " + r)
        );


        // =====================================
        // 6️⃣ PARALLEL TASKS + COMBINE
        // =====================================
        System.out.println("\n---- PARALLEL COMBINE ----");

        CompletableFuture<Integer> service1 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("User Service called");
                    return 30;
                });

        CompletableFuture<Integer> service2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Order Service called");
                    return 40;
                });

        CompletableFuture<Integer> combined =
                service1.thenCombine(service2,
                        (a, b) -> a + b);

        combined.thenAccept(r ->
                System.out.println("Combined Result = " + r)
        );


        // =====================================
        // WAIT LITTLE SO ASYNC PRINTS COMPLETE
        // =====================================
        Thread.sleep(4000);
        executor.shutdown();

        System.out.println("\n---- PROGRAM END ----");


    }
}
