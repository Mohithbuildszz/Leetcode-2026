<img width="1181" height="1331" alt="23aab88b-9acd-46e5-8f71-97d8ba9d7e57" src="https://github.com/user-attachments/assets/87fc9c62-c0fa-4dde-a003-d56254b21496" />
# LeetCode 66. Plus One

## Approach

The given array represents a large integer, where each element is a single digit. Our task is to add **1** to this number and return the updated array.

Instead of converting the array into a number (which may overflow for very large integers), we simulate the addition exactly as we do by hand.

---

## Intuition

When adding `1` to a number, we always start from the **last digit**.

- If the last digit is less than `9`, simply increment it and return the array.
- If the last digit is `9`, it becomes `0` and generates a carry.
- Continue moving left until the carry is resolved.
- If every digit is `9`, create a new array with an extra digit.

---

## Step-by-Step Explanation

### Step 1: Traverse from the End

```java
for (int i = digits.length - 1; i >= 0; i--)
```

We start from the last digit because adding `1` always begins from the least significant digit.

Example:

```
  1 2 3
+     1
-------
  1 2 4
```

The first digit we check is `3`.

---

### Step 2: Check if Adding 1 Creates a Carry

```java
if (digits[i] < 9)
```

If the current digit is less than `9`, adding `1` will not produce a carry.

Examples:

```
3 + 1 = 4
5 + 1 = 6
8 + 1 = 9
```

---

### Step 3: Increment and Return

```java
digits[i]++;
return digits;
```

Once we increment the digit, no carry remains.

Example:

Input:

```
[1,2,3]
```

Output:

```
[1,2,4]
```

No other digits need to be modified.

---

### Step 4: Handle the Digit 9

```java
digits[i] = 0;
```

If the current digit is `9`:

```
9 + 1 = 10
```

We store:

```
0
```

and pass the carry to the previous digit.

Example:

Input:

```
[1,2,9]
```

Process:

```
[1,2,9]
      ↓
9 + 1 = 10

↓

[1,2,0]
```

The loop continues to the previous digit.

---

## Dry Run

### Input

```
[1,9,9]
```

### Iteration 1

```
i = 2

9 + 1 = 10

↓

[1,9,0]
```

Carry continues.

---

### Iteration 2

```
i = 1

9 + 1 = 10

↓

[1,0,0]
```

Carry continues.

---

### Iteration 3

```
i = 0

1 + 1 = 2

↓

[2,0,0]
```

Carry is resolved.

Return:

```
[2,0,0]
```

---

## Special Case: All Digits are 9

Input:

```
[9,9,9]
```

Iteration:

```
[9,9,9]

↓

[9,9,0]

↓

[9,0,0]

↓

[0,0,0]
```

The loop finishes without returning.

This means every digit was `9`.

Create a new array:

```java
digits = new int[digits.length + 1];
```

Initially:

```
[0,0,0,0]
```

Set the first digit:

```java
digits[0] = 1;
```

Result:

```
[1,0,0,0]
```

which represents:

```
1000
```

---

## Algorithm

1. Start traversing from the last digit.
2. If the current digit is less than `9`:
   - Increment it.
   - Return the array immediately.
3. Otherwise:
   - Set the current digit to `0`.
   - Continue moving left.
4. If the loop finishes:
   - All digits were `9`.
   - Create a new array of size `n + 1`.
   - Set the first element to `1`.
   - Return the new array.

---

## Code

```java
class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
```

---

## Complexity Analysis

### Time Complexity

```
O(n)
```

- In the worst case (e.g., `[9,9,9]`), we traverse the entire array once.

---

### Space Complexity

```
O(1)
```

- No extra space is used except in the special case where all digits are `9`.
- Creating the new array is required by the problem and does not change the overall auxiliary space complexity.

---

## Key Takeaways

- Start from the last digit because addition begins from the least significant digit.
- If a digit is less than `9`, increment it and return immediately.
- If a digit is `9`, convert it to `0` and continue propagating the carry.
- If every digit is `9`, create a new array with an additional leading `1`.
- This approach efficiently simulates manual addition without converting the array into a number.
