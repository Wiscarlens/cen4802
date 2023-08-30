public class Main {
    public static void main(String[] args) {
        System.out.println("The 10th term of the Fibonacci sequence is " + fibonacci(10) + ".");
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}