// class Solution {
//     // public int[] maxSlidingWindow(int[] nums, int k) {
// //         int[] result = new int[nums.length - k + 1];
// //         List<Integer> li = new LinkedList<>();
// //         int curr = 0;

// //         for (int i = 0; i < k; i++) {
// //             li.add(nums[i]);

// //         }
// //         result[curr] = Collections.max(li);
// //         curr++;
// //         for (int j = k; j < nums.length; j++) {
// //             li.removeFirst();
// //             li.add(nums[j]);
// //             result[curr] = Collections.max(li);
// //             curr++;
// //         }
// // return result;


//     public int[] maxSlidingWindow(int[] nums, int k) {

//         int[] result = new int[nums.length - k + 1];

//         Queue<Integer> q = new LinkedList<>();

//         int curr = 0;

//         for (int i = 0; i < nums.length; i++) {

//             q.add(nums[i]);

//             if (q.size() > k) {
//                 q.poll();
//             }

//             if (q.size() == k) {
//                 result[curr] = Collections.max(q);
//                 curr++;
//             }
//         }

//         return result;
//     // }
// // }

//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> q = new ArrayDeque<>();

        int curr = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove elements outside window
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }

            // Remove smaller elements
            while (!q.isEmpty() &&
                   nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }

            q.offerLast(i);

            if (i >= k - 1) {
                result[curr++] = nums[q.peekFirst()];
            }
        }

        return result;
    }
}
