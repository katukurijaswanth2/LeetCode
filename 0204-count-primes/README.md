<h2><a href="https://leetcode.com/problems/count-primes">204. Count Primes</a></h2>
<h3>Medium</h3>
<hr>

<p>Given an integer <code>n</code>, return <em>the number of prime numbers that are strictly less than</em> <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 0
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> <a href="#simple-explanation-with-example-n--10">Jump to the Simple Explanation with Example (n = 10) ↓</a></p>

---

### Simple Explanation with Example (n = 10)

**1. Create array of size 10:**

```text
Index:  0  1  2  3  4  5  6  7  8  9
Value:  F  F  T  T  T  T  T  T  T  T
```

**2. Start with i = 2 (prime)**

* Mark multiples of 2: 4, 6, 8

```text
Index:  0  1  2  3  4  5  6  7  8  9
Value:  F  F  T  T  F  T  F  T  F  T
```

**3. Next i = 3 (still prime)**

* Mark multiples of 3: 9 (6 was already marked)

```text
Index:  0  1  2  3  4  5  6  7  8  9
Value:  F  F  T  T  F  T  F  T  F  F
```

**4.** Next possible i = 4 → but `isPrime[4]` is already `false`, so skip.

**5.** Count the remaining `true` values → 2, 3, 5, 7 → **Answer = 4**

---

### Solution (Sieve of Eratosthenes)

```java
class Solution {
    public int countPrimes(int n) {
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
```

**Complexity:** Time is O(n log log n), space is O(n).
