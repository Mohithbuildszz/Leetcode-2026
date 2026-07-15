# Move Zeroes

## Problem

Given an integer array `nums`, move all `0`s to the end while maintaining the relative order of the non-zero elements.

The operation must be performed **in-place** without creating another array.
<div>
    <img width="1024" height="1536" alt="81ba64ca-f06c-42de-a870-47ca2bddc061" src="https://github.com/user-attachments/assets/6bf4d748-1a15-45ec-86c9-8d4c75739895" />
</div>
### Example

**Input**

```text
nums = [0,1,0,3,12]
```

**Output**

```text
[1,3,12,0,0]
```

---

# Approach

This solution uses the **Two Pointer** technique.

- Find the first occurrence of `0`.
- Use another pointer to scan the remaining elements.
- Whenever a non-zero element is found, swap it with the zero at pointer `j`.
- Move `j` to the next zero position.
- Continue until the end of the array.

---

# Code

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;

        // Find the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // No zero found
        if (j == -1) return;

        // Move non-zero elements forward
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
```

---

# Code Explanation

### Step 1: Find the first zero

```java
int j = -1;

for (int i = 0; i < nums.length; i++) {
    if (nums[i] == 0) {
        j = i;
        break;
    }
}
```

The pointer `j` stores the index of the first zero in the array.

If no zero exists, the array is already in the correct order.

---

### Step 2: Handle the case where no zero exists

```java
if (j == -1) return;
```

If `j` is still `-1`, there are no zeros, so no changes are required.

---

### Step 3: Traverse the remaining array

```java
for (int i = j + 1; i < nums.length; i++)
```

Start checking elements after the first zero.

---

### Step 4: Swap non-zero elements

```java
if (nums[i] != 0) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    j++;
}
```

Whenever a non-zero element is found:

- Swap it with the zero at index `j`.
- Increment `j` so it points to the next zero position.

This keeps all non-zero elements together while pushing zeros toward the end.

---

# Dry Run

Input:

```text
[0,1,0,3,12]
```

First zero:

```text
j = 0
```

Swap `1` and `0`

```text
[1,0,0,3,12]
```

Swap `3` and `0`

```text
[1,3,0,0,12]
```

Swap `12` and `0`

```text
[1,3,12,0,0]
```

Final Output:

```text
[1,3,12,0,0]
```

---

# Complexity Analysis

**Time Complexity:** `O(n)`

- One pass to find the first zero.
- One pass to move non-zero elements.

Overall complexity is `O(n)`.

**Space Complexity:** `O(1)`

No extra array is used. The array is modified in place.

---

# Key Takeaways

- Uses the Two Pointer technique.
- Maintains the relative order of non-zero elements.
- Moves all zeros to the end.
- Solves the problem in-place.
- Efficient with `O(n)` time and `O(1)` space.
