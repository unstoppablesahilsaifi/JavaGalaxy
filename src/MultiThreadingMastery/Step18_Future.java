package MultiThreadingMastery;
//Callable result deta hai, par result ko handle karta hai Future

//Task background me chal raha hai
//Result abhi nahi, thodi der baad milega
//Tab tak main thread kya kare?
//👉 Answer: Future

//🔑 Future kya-kya deta hai?
//Result lana (get())
//Status check (isDone())
//Cancel karna (cancel())


//Main abhi value nahi dunga, main ek Future object dunga jisme future me value milegi


//Task background thread me start hota hai
//Future ek placeholder box jaisa hota hai
//Jab result ready ho jata hai, tab Future ke andar value aa jati hai


//🔹 Jab aap likhte ho:
//System.out.println(ans.get());
//Toh:
//Agar result ready hai → turant mil jaayega
//Agar result ready nahi hai → main thread wait karega 🛑

// Why return Type not int why future
//| Reason          | Explanation                                        |
//| --------------- | -------------------------------------------------- |
//| Task async hai  | Result turant exist nahi karta                     |
//| Thread alag hai | Main thread ko pata nahi kab complete hoga         |
//| JVM safety      | JVM Future ke through synchronization manage karta |


//🔹 Agar synchronous hota to?
//Integer ans = new CallTask().call();
//System.out.println(ans);
//Yaha Future ki zarurat nahi 👍
//Kyunki same thread me execution ho raha hai.

import java.util.concurrent.*;

//Future isliye use hota hai kyunki asynchronous task ka result future me milta hai,
// aur normal int sirf turant available value store kar sakta hai.
class CalculationTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println(
                "Callable task running in thread : " +
                        Thread.currentThread().getName()
        );

        Thread.sleep(5000);   // 5 second ka kaam

        return 99;
    }
}
public class Step18_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main thread start");

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        // ONLY submit()
        Future<Integer> future =
                executor.submit(new CalculationTask());

        System.out.println("Before get()");

        // ONLY get()
        Integer result = future.get();   // <-- WAIT HERE

        System.out.println("After get()");
        System.out.println("Result = " + result);

        executor.shutdown();

    }
}
