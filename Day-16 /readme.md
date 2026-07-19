# 485. Max Consecutive Ones

## Problem Statement

Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

### Example 1

**Input**
```text
nums = [1,1,0,1,1,1]
```

**Output**
```text
3
```

### Example 2

**Input**
```text
nums = [1,0,1,1,0,1]
```

**Output**
```text
2
```

---

## Approach

1. Initialize two variables:
   - `count` to store the current consecutive count of `1`s.
   - `maxi` to store the maximum consecutive count found so far.
2. Traverse the array from left to right.
3. If the current element is `1`, increment `count`.
4. Otherwise, reset `count` to `0`.
5. Update `maxi` with the maximum of `maxi` and `count` after each iteration.
6. Return `maxi`.

---

## Java Solution

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            maxi = Math.max(maxi, count);
        }

        return maxi;
    }
}
```

---

## Dry Run

### Input

```text
nums = [1,1,0,1,1,1]
```

| Index | Value | Count | Max |
|------:|------:|------:|----:|
| 0 | 1 | 1 | 1 |
| 1 | 1 | 2 | 2 |
| 2 | 0 | 0 | 2 |
| 3 | 1 | 1 | 2 |
| 4 | 1 | 2 | 2 |
| 5 | 1 | 3 | 3 |

**Output**

```text
3
```

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Key Idea

- Keep counting consecutive `1`s.
- Reset the count whenever a `0` is encountered.
- Continuously update the maximum count.
- Since the array is traversed only once, the solution is optimal.
