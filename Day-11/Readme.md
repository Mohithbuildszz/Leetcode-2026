# 35. Search Insert Position

## Problem Statement

Given a sorted array of distinct integers and a target value, return the index if the target is found.

If the target is not found, return the index where it should be inserted to maintain the sorted order.

The expected time complexity is **O(log n)**.

---

## Examples

### Example 1

```text
Input:
nums = [1,3,5,6]
target = 5

Output:
2
```

### Example 2

```text
Input:
nums = [1,3,5,6]
target = 2

Output:
1
```

### Example 3

```text
Input:
nums = [1,3,5,6]
target = 7

Output:
4
```

### Example 4

```text
Input:
nums = [1,3,5,6]
target = 0

Output:
0
```

---

## Approach 1: Linear Search

### Intuition

Traverse the array from left to right.

- If the current element is greater than or equal to the target, return its index.
- If no such element exists, the target should be inserted at the end of the array.

### Algorithm

1. Traverse the array from index `0`.
2. Compare each element with the target.
3. If `nums[i] >= target`, return `i`.
4. If the loop finishes, return `nums.length`.

### Java Code

```java
class Solution {
    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
}
```

### Complexity Analysis

- Time Complexity: **O(n)**
- Space Complexity: **O(1)**

---

## Approach 2: Binary Search (Optimal)

### Intuition

Since the array is already sorted, Binary Search allows us to find the target or its insertion position efficiently by reducing the search space by half in each iteration.

### Algorithm

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Find the middle index.
3. If the middle element equals the target, return its index.
4. If the middle element is less than the target, search the right half.
5. Otherwise, search the left half.
6. When the loop ends, `left` represents the correct insertion position.

### Java Code

```java
class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
```

### Complexity Analysis

- Time Complexity: **O(log n)**
- Space Complexity: **O(1)**

---

## Key Observation

The answer is the first index where the array element is greater than or equal to the target.

If every element is smaller than the target, the insertion position is at the end of the array.

---

## Topics Covered

- Arrays
- Linear Search
- Binary Search
- Sorted Arrays
- Time Complexity Optimization

---

## Tags

- Array
- Binary Search
- Easy
- LeetCode 35
