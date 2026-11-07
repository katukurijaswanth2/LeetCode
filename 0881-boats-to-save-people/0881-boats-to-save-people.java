class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        Arrays.sort(people);
       int left= 0;
       int right = people.length-1;
   
       while(left<=right){
            int check = people[left]+people[right];
        if(check<=limit){
            left++;

        }
        right--;
        count++;
       }
        return count;
    }
}

Here’s a clear, self-contained explanation you can come back to even after a year.

---

### Problem Recap
You are given:
- An array `people` where each number is a person’s weight.
- A number `limit` = maximum weight one boat can carry.

Rules:
- Each boat can carry **at most 2 people**.
- The total weight of people in a boat must be ≤ `limit`.
- You have unlimited boats.
- Goal: Find the **minimum number of boats** needed to rescue everyone.

---

### Core Idea (The Key Insight)

The heaviest person left **must** take a boat.  
There is no choice about that.

So the only question is:  
**“Can I put someone else with this heavy person to save a boat?”**

The best person to try pairing with the heavy person is the **lightest** remaining person (because that gives the highest chance of staying under the limit).

This is a **greedy** strategy:
- Always handle the current heaviest person.
- Pair them with the lightest person **if possible**.
- Otherwise, send the heavy person alone.

This never wastes capacity and always gives the minimum number of boats.

---

### The Algorithm (Step by Step)

1. **Sort** the array.  
   Now the lightest person is at the front and the heaviest is at the end.

2. Use **two pointers**:
   - `left` → points to the lightest remaining person
   - `right` → points to the heaviest remaining person

3. While there are still people left (`left <= right`):
   - Look at `people[left] + people[right]`
   - If they can fit together → move both pointers (`left++` and `right--`)
   - If they cannot fit → only the heavy person takes the boat (`right--`)
   - In both cases, one boat is used (`count++`)

4. Return the total number of boats used.

---

### Code
```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);               // Step 1: Sort
        
        int left = 0;                      // lightest person
        int right = people.length - 1;     // heaviest person
        int boats = 0;

        while (left <= right) {            // while people remain
            // Can lightest + heaviest fit in one boat?
            if (people[left] + people[right] <= limit) {
                left++;                    // yes → both go together
            }
            // Heavy person always takes a boat
            right--;
            boats++;                       // one boat used
        }
        return boats;
    }
}
```

---

### Why This Works (Deep Intuition)

Imagine you always deal with the current heaviest person first.

- If even the lightest person cannot sit with them → no one can. So they must go alone.
- If the lightest person *can* sit with them → it’s the best possible pairing. You just saved a future boat.

By always making the best possible decision for the current heaviest person, you never create a situation where you later need extra boats.

---

### Example Walkthrough

**Input:** `people = [3, 2, 2, 1]`, `limit = 3`

After sorting → `[1, 2, 2, 3]`

| Step | left | right | Lightest | Heaviest | Sum   | Decision              | Boats |
|------|------|-------|----------|----------|-------|-----------------------|-------|
| 1    | 0    | 3     | 1        | 3        | 4 > 3 | 3 goes alone          | 1     |
| 2    | 0    | 2     | 1        | 2        | 3 ≤ 3 | Both go together      | 2     |
| 3    | 1    | 1     | 2        | 2        | 4 > 3 | 2 goes alone          | 3     |

Final answer: **3 boats**

---

### Another Quick Example

`people = [1, 2]`, `limit = 3`  
→ Sorted: `[1, 2]`  
→ 1 + 2 ≤ 3 → both go together → **1 boat**

---

### Time & Space Complexity
- Time: \(O(n \log n)\) → because of sorting
- Space: \(O(1)\) extra space

---

### Mental Shortcut (Remember This)

> “Always try to pair the heaviest remaining person with the lightest remaining person.  
> If they fit → great, both go.  
> If not → heavy person goes alone.  
> Repeat until everyone is rescued.”

That’s the entire algorithm.
