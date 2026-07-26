# 75. Sort Colors

## Problem Statement

Given an array `nums` containing `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order:

- `0` → Red
- `1` → White
- `2` → Blue

You must solve this problem **without using the library's sort function**.

---

## Example

### Input

```text
nums = [2,0,2,1,1,0]
```

### Output

```text
[0,0,1,1,2,2]
```

---

# Approach 1: Counting Sort

## Idea

Since the array contains only three distinct values (`0`, `1`, and `2`), count the occurrences of each value and overwrite the array.

### Algorithm

1. Count the number of `0`s, `1`s, and `2`s.
2. Fill the array with:
   - All `0`s
   - All `1`s
   - All `2`s

### Java Solution

```java
class Solution {
    public void sortColors(int[] nums) {

        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0)
                count0++;
            else if (num == 1)
                count1++;
            else
                count2++;
        }

        int index = 0;

        while (count0-- > 0)
            nums[index++] = 0;

        while (count1-- > 0)
            nums[index++] = 1;

        while (count2-- > 0)
            nums[index++] = 2;
    }
}
```

### Complexity

- Time Complexity: **O(n)**
- Space Complexity: **O(1)**

---

# Approach 2: Dutch National Flag Algorithm (Optimal)

## Idea

Maintain three pointers:

- `low`
- `mid`
- `high`

The array is divided into four regions.

```text
0 ... low-1        -> All 0s

low ... mid-1      -> All 1s

mid ... high       -> Unknown

high+1 ... n-1     -> All 2s
```

### Rules

If `nums[mid] == 0`

- Swap `low` and `mid`
- `low++`
- `mid++`

If `nums[mid] == 1`

- `mid++`

If `nums[mid] == 2`

- Swap `mid` and `high`
- `high--`
- Do **not** increment `mid`

---

## Java Solution

```java
class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}
```

---

## Dry Run

Input

```text
[2,0,2,1,1,0]
```

Initial

```text
L
M
          H

2 0 2 1 1 0
```

### Step 1

```text
nums[mid] = 2

Swap(mid, high)

0 0 2 1 1 2

high--
```

### Step 2

```text
nums[mid] = 0

Swap(low, mid)

low++
mid++
```

### Step 3

```text
nums[mid] = 0

Swap(low, mid)

low++
mid++
```

### Step 4

```text
nums[mid] = 2

Swap(mid, high)

0 0 1 1 2 2

high--
```

### Step 5

```text
nums[mid] = 1

mid++
```

### Step 6

```text
nums[mid] = 1

mid++

mid > high
```

Sorted Array

```text
0 0 1 1 2 2
```

---

## Why don't we increment `mid` after swapping with `high`?

Example

```text
2 1 0

M   H
```

Swap

```text
0 1 2

M   H
```

The new element at `mid` is `0`.

If we increment `mid`, we skip checking this value.

Therefore,

- After swapping with `high`, move only `high--`.
- Keep `mid` at the same position.

---

# Complexity Comparison

| Approach | Time | Space | Passes |
|----------|------|--------|--------|
| Counting Sort | O(n) | O(1) | 2 |
| Dutch National Flag | O(n) | O(1) | 1 |

---
#diagram 
<div>
   <img width="1402" height="1122" alt="6966ec98-f4ab-4142-b541-0f6c1184bd43" src="https://github.com/user-attachments/assets/a8a5c58b-4ad5-4542-bc64-8ef7ba9cab2f" />
</div>
# Key Takeaways

- Counting Sort is simple and easy to implement.
- Dutch National Flag Algorithm is the optimal interview solution.
- The algorithm uses three pointers (`low`, `mid`, `high`) to partition the array in a single traversal.
- Never increment `mid` after swapping with `high`.

---

## Tags

- Array
- Two Pointers
- Sorting
- Dutch National Flag Algorithm
- Counting Sort
- LeetCode 75
