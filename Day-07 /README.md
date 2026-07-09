<div>
  
</div>

# 3Sum (LeetCode 15)

## Problem Statement

Given an integer array `nums`, return **all the unique triplets** `[nums[i], nums[j], nums[k]]` such that:

- `i != j`
- `i != k`
- `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set **must not contain duplicate triplets**.

---

## Example

### Input

```text
nums = [-1,0,1,2,-1,-4]
```

### Output

```text
[[-1,-1,2],[-1,0,1]]
```

---

# Brute Force Approach

## Idea

Try every possible combination of three numbers.

Use three nested loops:

- First loop selects the first element.
- Second loop selects the second element.
- Third loop selects the third element.
- If their sum is `0`, store the triplet.

Since duplicate triplets may occur, sort each triplet and store it inside a `HashSet`.

---

## Algorithm

```text
for i

    for j

        for k

            if(nums[i]+nums[j]+nums[k]==0)

                sort triplet

                add into HashSet
```

---

## Time Complexity

```text
O(n³)
```

## Space Complexity

```text
O(k)

k = number of unique triplets
```

---

# Optimal Approach (Sorting + Two Pointers)

## Intuition

Instead of selecting all three numbers using three loops, fix one number and search for the remaining two numbers.

We know:

```text
a + b + c = 0
```

Fix one element:

```text
a
```

Then we only need

```text
b + c = -a
```

Now the problem becomes a **Two Sum** problem.

If the array is sorted, we can solve Two Sum using Two Pointers.

---

# Why Sorting?

Original Array

```text
[-1,0,1,2,-1,-4]
```

After Sorting

```text
[-4,-1,-1,0,1,2]
```

Sorting helps because:

- Moving the left pointer increases the sum.
- Moving the right pointer decreases the sum.

---

# Two Pointer Thinking

Suppose

```text
[-4,-1,-1,0,1,2]
```

Fix

```text
i = 0
```

Current number

```text
-4
```

Need

```text
x + y = 4
```

Initialize

```java
left = i + 1;
right = nums.length - 1;
```

Diagram

```text
Index

0   1   2   3   4   5

-4 -1 -1  0  1  2
 ^
     L           R
```

Current Sum

```text
-4 + (-1) + 2 = -3
```

Since

```text
sum < 0
```

Move

```text
left++
```

because moving left forward increases the sum.

---

Suppose

```text
-1 + 1 + 2 = 2
```

Current sum

```text
2
```

Need

```text
0
```

Since

```text
sum > 0
```

Move

```text
right--
```

because moving right backward decreases the sum.

---

Suppose

```text
-1 + (-1) + 2 = 0
```

Triplet found.

Store it.

Move both pointers.

```java
left++;
right--;
```

Continue searching.

---

# Movement Rules

## Case 1

```text
sum < 0
```

Need a bigger sum.

Move

```text
left++
```

---

## Case 2

```text
sum > 0
```

Need a smaller sum.

Move

```text
right--
```

---

## Case 3

```text
sum == 0
```

Triplet found.

Store it.

Move both pointers.

```text
left++
right--
```

---

# Handling Duplicates

## Duplicate i

Sorted Array

```text
[-4,-1,-1,0,1,2]
```

Iteration 1

```text
i = 1

nums[i] = -1
```

Already generates

```text
[-1,-1,2]

[-1,0,1]
```

Iteration 2

```text
i = 2

nums[i] = -1
```

Same fixed element.

It will generate the same answers again.

Skip it.

```java
if(i > 0 && nums[i] == nums[i-1])
    continue;
```

---

## Duplicate Left Pointer

Example

```text
[-2,0,0,0,2]
```

Found

```text
[-2,0,2]
```

Move

```text
left++
```

If next left value is still

```text
0
```

Skip it.

```java
while(left < right && nums[left] == nums[left-1])
    left++;
```

---

## Duplicate Right Pointer

Similarly

```java
while(left < right && nums[right] == nums[right+1])
    right--;
```

---

# Complete Algorithm

```text
Sort the array

Create answer list

Loop through every element

    Skip duplicate i

    left = i + 1

    right = n - 1

    while(left < right)

        sum = nums[i] + nums[left] + nums[right]

        if(sum == 0)

            store answer

            left++

            right--

            skip duplicate left

            skip duplicate right

        else if(sum < 0)

            left++

        else

            right--

Return answer
```

---

# Java Solution

```java
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                }

                else if (sum < 0) {

                    left++;

                }

                else {

                    right--;

                }
            }
        }

        return ans;
    }
}
```

---

# Dry Run

Input

```text
[-1,0,1,2,-1,-4]
```

Sort

```text
[-4,-1,-1,0,1,2]
```

### i = 0

```text
-4 -1 -1 0 1 2
 ^
    L       R
```

```text
sum = -3

Move left
```

Continue until

```text
left == right
```

---

### i = 1

```text
-4 -1 -1 0 1 2
    ^
       L     R
```

```text
sum = 0

Store

[-1,-1,2]
```

Move

```text
left++

right--
```

Now

```text
-4 -1 -1 0 1 2
    ^
          L R
```

```text
sum = 0

Store

[-1,0,1]
```

Pointers cross.

---

### i = 2

```text
nums[2] == nums[1]
```

Duplicate.

Skip.

---

Final Answer

```text
[
 [-1,-1,2],
 [-1,0,1]
]
```

---

# Complexity Analysis

## Time Complexity

Sorting

```text
O(n log n)
```

Outer Loop

```text
O(n)
```

Two Pointer

```text
O(n)
```

Overall

```text
O(n²)
```

---

## Space Complexity

```text
O(1)
```

Excluding the output list.

---

# Key Takeaways

- Convert `3Sum` into `2Sum` by fixing one element.
- Sort the array before using Two Pointers.
- If `sum < 0`, move `left`.
- If `sum > 0`, move `right`.
- If `sum == 0`, store the triplet and move both pointers.
- Skip duplicate values for `i`, `left`, and `right` to avoid duplicate triplets.
- The optimal solution runs in **O(n²)** time and **O(1)** extra space (excluding the output).
