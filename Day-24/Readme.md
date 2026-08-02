# 169. Majority Element

## Problem Statement

Given an integer array `nums` of size `n`, return the **majority element**.

The **majority element** is the element that appears **more than** `⌊n / 2⌋` times.

It is guaranteed that the majority element always exists.

---

## Example

### Input

```text
nums = [2,2,1,1,1,2,2]
```

### Output

```text
2
```

### Explanation

- Frequency of `2` = 4
- Frequency of `1` = 3
- Array size = 7
- `7 / 2 = 3`
- Since `4 > 3`, the majority element is **2**.

---

# Approach 1: Brute Force

## Intuition

For every element, count how many times it appears in the array.

If its frequency becomes greater than `n / 2`, return that element.

---

## Algorithm

1. Traverse each element of the array.
2. For every element, traverse the array again.
3. Count its frequency.
4. If the frequency is greater than `n / 2`, return that element.

---

## Dry Run

```text
nums = [3,2,3]

i = 0
Element = 3

Count occurrences of 3

3 2 3

Count = 2

n = 3
n/2 = 1

2 > 1

Answer = 3
```

---

## Java Code

```java
class Solution {
    public int majorityElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(1)`

---

# Approach 2: Moore's Voting Algorithm (Optimal)

## Intuition

Imagine every occurrence of the majority element casts a **positive vote**.

Every different element cancels one vote.

Since the majority element appears **more than n / 2 times**, it can never be completely canceled.

The remaining candidate at the end is the majority element.

---

## Algorithm

1. Initialize
   - `candidate = 0`
   - `count = 0`
2. Traverse the array.
3. If `count == 0`, choose the current element as the new candidate.
4. If the current element equals the candidate, increment `count`.
5. Otherwise, decrement `count`.
6. Return the final candidate.

---

## Dry Run

```text
nums = [2,2,1,1,1,2,2]

Candidate = -
Count = 0

Read 2
Candidate = 2
Count = 1

Read 2
Count = 2

Read 1
Count = 1

Read 1
Count = 0

Read 1
Candidate = 1
Count = 1

Read 2
Count = 0

Read 2
Candidate = 2
Count = 1

Answer = 2
```

---

## Visualization

```text
2  2  1  1  1  2  2

+1
+1
-1
-1
+1
-1
+1

Remaining Candidate = 2
```

---

## Java Code

```java
class Solution {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

# Comparison

| Approach | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Brute Force | `O(n²)` | `O(1)` |
| Moore's Voting Algorithm | `O(n)` | `O(1)` |

---

# Key Takeaways

- **Brute Force** is simple and easy to understand but inefficient because it counts the frequency of every element repeatedly.
- **Moore's Voting Algorithm** is the optimal solution with linear time and constant extra space.
- The algorithm works because the majority element appears more than half of the time, so it cannot be completely canceled by the other elements.

---

## Topics

- Arrays
- Frequency Counting
- Moore's Voting Algorithm
- Boyer-Moore Voting Algorithm
