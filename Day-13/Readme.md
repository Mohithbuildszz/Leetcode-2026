# 1752. Check if Array Is Sorted and Rotated

**Example:**

```text
Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
```
<div>
  <img width="1536" height="1024" alt="9693a09e-abd5-4d1b-9b02-8a815e75b1f7" src="https://github.com/user-attachments/assets/3c268fe3-8a65-41a7-a105-0106f234f333" />

</div>

## What i understand on this problem is:

Approach

The key observation is that a sorted array, when rotated, can have **at most one position** where the order decreases. This decrease is called a **drop** and occurs when the current element is greater than the next element.

Traverse the array once and compare each element with its next element. To handle the circular nature of a rotated array, compare the last element with the first element as well.

Count the number of drops encountered during the traversal:
- If there are **0 drops**, the array is already sorted.
- If there is **1 drop**, the array is sorted and rotated.
- If there are **more than 1 drop**, the array cannot be obtained by rotating a sorted array.

Finally, return `true` if the number of drops is at most one; otherwise, return `false`.

**Time Complexity:** `O(n)`  
**Space Complexity:** `O(1)`
