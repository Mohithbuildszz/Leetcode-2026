# Remove Duplicates from Sorted Array (LeetCode 26)

## Problem

Given a sorted integer array `nums`, remove the duplicates in-place such that each unique element appears only once.

Return the number of unique elements.

The first `k` elements of the array should contain the unique elements.

---

## Intuition

Since the array is already sorted:

- Duplicate elements are always adjacent.
- Keep one pointer for the last unique element.
- Use another pointer to scan the array.
- Whenever a new element is found, move it next to the last unique element.

---

## Approach (Two Pointers)

- `i` → Points to the last unique element.
- `j` → Traverses the array.

Steps:

1. Start `i = 0`.
2. Traverse the array using `j`.
3. If `nums[j] != nums[i]`
   - Increment `i`
   - Copy `nums[j]` to `nums[i]`
4. Return `i + 1`.

---

## Dry Run

Input

```
[1,1,2,2,3]
```

Initial

```
i = 0
j = 1
```

| j | nums[j] | Action | Array |
|---|----------|--------|-------|
|1|1|Duplicate|[1,1,2,2,3]|
|2|2|New element → i++, copy|[1,2,2,2,3]|
|3|2|Duplicate|[1,2,2,2,3]|
|4|3|New element → i++, copy|[1,2,3,2,3]|

Return

```
3
```

First 3 elements

```
[1,2,3]
```

---

## Algorithm

```
Initialize i = 0

For j from 1 to n-1

    If nums[i] != nums[j]
        i++
        nums[i] = nums[j]

Return i + 1
```

---

## Java Solution

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
```

---

## Why It Works

Because the array is sorted:

- Duplicate values are consecutive.
- `i` always points to the last unique element.
- `j` searches for the next different value.
- Every new unique value is placed immediately after the previous one.

---

## Time Complexity

```
O(n)
```

Only one traversal of the array.

---

## Space Complexity

```
O(1)
```

No extra space is used.

---

# Memory Trick (Remember Forever)

Think of it as:

```
i = Unique Pointer
j = Search Pointer
```

Whenever `j` finds a **new number**:

```
i++
nums[i] = nums[j]
```

Remember this one line:

```
Different?
→ Move i
→ Copy j to i
```

Or even shorter:

```
Search → Found New → Move → Copy
```
