# 53. Maximum Subarray

## Problem Statement

Given an integer array `nums`, find the contiguous subarray (containing at least one number) that has the largest sum and return its sum.

### Example

**Input**

```text
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

**Output**

```text
6
```

**Explanation**

The subarray `[4,-1,2,1]` has the largest sum.

---

# Approach 1: Brute Force

## Idea

Generate every possible contiguous subarray.

For each starting index:

- Initialize `currentSum = 0`
- Extend the subarray one element at a time.
- Update the maximum sum whenever a larger sum is found.

---

## Algorithm

1. Initialize `maxSum` as `Integer.MIN_VALUE`.
2. Iterate through every starting index `i`.
3. Initialize `currentSum = 0`.
4. Iterate through every ending index `j`.
5. Add `nums[j]` to `currentSum`.
6. Update `maxSum`.
7. Return `maxSum`.

---

## Java Code

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int currentSum = 0;

            for (int j = i; j < nums.length; j++) {

                currentSum += nums[j];

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
```

---

## Dry Run

```text
nums = [1, -2, 3]

i = 0
current = 1
max = 1

current = -1
max = 1

current = 2
max = 2

------------------

i = 1

current = -2
max = 2

current = 1
max = 2

------------------

i = 2

current = 3
max = 3
```

Answer:

```text
3
```

---

## Complexity

- Time Complexity: **O(n²)**
- Space Complexity: **O(1)**

---

# Approach 2: Kadane's Algorithm (Optimal)

## Idea

Instead of checking every subarray, maintain a running sum.

- Keep adding elements.
- If the running sum becomes negative, discard it.
- Track the maximum sum seen so far.

A negative running sum cannot help future subarrays, so reset it to `0`.

---

## Algorithm

1. Initialize:
   - `currentSum = 0`
   - `maxSum = Integer.MIN_VALUE`
2. Traverse the array.
3. Add the current element to `currentSum`.
4. Update `maxSum`.
5. If `currentSum < 0`, reset it to `0`.
6. Return `maxSum`.

---

## Java Code

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {

            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
```

---

## Dry Run

```text
nums = [-2,1,-3,4,-1,2,1,-5,4]

current = -2
max = -2
Reset

current = 1
max = 1

current = -2
max = 1
Reset

current = 4
max = 4

current = 3
max = 4

current = 5
max = 5

current = 6
max = 6

current = 1
max = 6

current = 5
max = 6
```

Answer:

```text
6
```

---

## Why Reset the Running Sum?

Suppose the running sum is negative.

```text
currentSum = -5
nextElement = 7
```

### Continue

```text
-5 + 7 = 2
```

### Start Fresh

```text
7
```

Starting fresh gives a larger sum.

Therefore, whenever the running sum becomes negative, reset it to `0`.

---

## Complexity

- Time Complexity: **O(n)**
- Space Complexity: **O(1)**

---

# Comparison

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Kadane's Algorithm | O(n) | O(1) |

---

# Key Takeaways

- The subarray must be **contiguous**.
- Brute Force checks every possible subarray.
- Kadane's Algorithm maintains a running sum.
- Reset the running sum when it becomes negative.
- Kadane's Algorithm is the optimal solution for the Maximum Subarray problem.

---

# Related Problems

- LeetCode 53 - Maximum Subarray
- LeetCode 918 - Maximum Sum Circular Subarray
- LeetCode 152 - Maximum Product Subarray
- LeetCode 1749 - Maximum Absolute Sum of Any Subarray
- LeetCode 1191 - K-Concatenation Maximum Sum
- Maximum Sum Rectangle in a Matrix (2D Kadane)
