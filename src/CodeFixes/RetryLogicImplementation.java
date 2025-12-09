package CodeFixes;
/*Retry logic implement (3 attempts)
Write code to call a service method.
If it fails, retry 3 times with 2 seconds gap.*/
public class RetryLogicImplementation {

    int maxRetry = 3;  // max attempts

    public static void main(String[] args) throws Exception {
        RetryLogicImplementation obj = new RetryLogicImplementation();
        obj.callWithRetry();
    }

    // Your retry logic
    public void callWithRetry() throws Exception {
        int attempt = 0;

        while (attempt < maxRetry) {
            try {
                attempt++;
                callService();  // service call
                System.out.println("Success on attempt " + attempt);
                break;          // successful → exit loop

            } catch (Exception e) {
                System.out.println("Attempt " + attempt + " failed");

                if (attempt == maxRetry) {
                    System.out.println("All attempts failed. Throwing exception.");
                    throw e;    // last attempt → rethrow
                }

                try {
                    Thread.sleep(2000); // 2 sec gap
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Dummy service method
    public void callService() throws Exception {
        System.out.println("Calling service...");
        // force failure for testing
        throw new Exception("Service failed");
    }
}
