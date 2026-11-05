class Solution {
    public int countPrimes(int n) {
    //     int count = 0;
    //     if (n == 0)
    //         return count;
    //     if (n == 1)
    //         return count;

    //     for (int i = 2; i < n; i++) {
    //         if (isPrime(i)) {
    //             count++;
    //         }

    //     }
    //     return count;
    // }

    // private boolean isPrime(int num) {
    //     for (int j = 2; j < num; j++) {
    //         if (num % j == 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    if (n <= 2) return 0;

        // Step 1: Create a boolean array
        // isPrime[i] will be true if 'i' is a prime number
        boolean[] isPrime = new boolean[n];

        // Step 2: Assume all numbers from 2 to n-1 are prime initially
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Step 3: Start marking non-prime numbers
        // We only need to go up to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            
            // If i is still marked as prime
            if (isPrime[i]) {
                
                // Mark all multiples of i as NOT prime
                // Start from i*i (because smaller multiples are already marked)
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 4: Count how many numbers are still marked as true (prime)
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;}


}