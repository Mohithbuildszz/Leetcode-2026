# 8. String to Integer (atoi)
<img width="1024" height="1536" alt="65710d21-9bbd-4798-ba11-25737d8da11d" src="https://github.com/user-attachments/assets/b9121380-ef75-41ab-bf89-14eede30c50c" />

## Problem Statement

Implement the `myAtoi(String s)` function that converts a string into a **32-bit signed integer**.

The function should:

- Ignore leading whitespaces.
- Check for an optional `+` or `-` sign.
- Read the digits one by one.
- Stop reading when a non-digit character is encountered.
- Return the integer within the 32-bit signed integer range.

---

# Understanding the Problem

The problem is **not asking us to convert the entire string**.

Instead, we have to **read the string exactly like a human reads a number**.

For example,

Input

```text
"   -123abc"
```

How a human reads it:

1. Ignore the spaces.
2. See the `-` sign.
3. Remember the number is negative.
4. Read `1`, `2`, `3`.
5. Stop when `a` appears.
6. Return `-123`.

The computer should follow the exact same process.

---

# Examples

### Example 1

Input

```text
"42"
```

Output

```text
42
```

---

### Example 2

Input

```text
"   42"
```

Output

```text
42
```

Ignore the leading spaces.

---

### Example 3

Input

```text
"-42"
```

Output

```text
-42
```

Remember the negative sign.

---

### Example 4

Input

```text
"+42"
```

Output

```text
42
```

Positive sign is optional.

---

### Example 5

Input

```text
"4193 with words"
```

Output

```text
4193
```

Read digits until a non-digit appears.

---

### Example 6

Input

```text
"words and 987"
```

Output

```text
0
```

Since the first non-space character is not a digit or sign, return `0`.

---

### Example 7

Input

```text
"+-12"
```

Output

```text
0
```

Only one sign is allowed.

---

### Example 8

Input

```text
"-91283472332"
```

Output

```text
-2147483648
```

The number is smaller than Integer.MIN_VALUE, so clamp it.

---

# How to Think

Instead of thinking,

> "How do I convert the string?"

Think,

> "How do I read this string from left to right?"

Imagine your finger moving through the string.

```text
"   -123abc"

 ^
```

Skip spaces.

```text
"   -123abc"

    ^
```

See `-`

Store

```text
sign = -1
```

Move to digits.

```text
123abc
^
```

Read

```text
1
```

Read

```text
2
```

Read

```text
3
```

Next character

```text
a
```

Not a digit.

Stop.

Return

```text
-123
```

---

# Approach

The solution can be divided into **5 simple steps**.

---

## Step 1 : Ignore Leading Spaces

Skip all spaces at the beginning.

Example

```text
"     123"
```

↓

```text
123
```

Why?

The problem statement says to ignore leading whitespace.

---

## Step 2 : Check the Sign

The next character can be

```text
+
```

or

```text
-
```

or a digit.

If

```text
-
```

Store

```java
sign = -1;
```

Otherwise

```java
sign = 1;
```

---

## Step 3 : Read Digits

Now keep reading digits one by one.

The formula is

```java
num = num * 10 + digit;
```

### Why multiply by 10?

Suppose

Current number

```text
45
```

Next digit

```text
6
```

We need

```text
456
```

First shift left.

```text
45 × 10 = 450
```

Then add

```text
6
```

Result

```text
456
```

This is why we use

```java
num = num * 10 + digit;
```

---

## Step 4 : Stop at the First Invalid Character

Example

```text
123abc
```

Read

```text
1
2
3
```

Next character

```text
a
```

Not a digit.

Stop immediately.

Answer

```text
123
```

---

## Step 5 : Handle Overflow

Java Integer range

```text
-2147483648

to

2147483647
```

If the number becomes larger than

```text
2147483647
```

Return

```java
Integer.MAX_VALUE
```

If it becomes smaller than

```text
-2147483648
```

Return

```java
Integer.MIN_VALUE
```

---

# Variables Used

```java
int i = 0;
int sign = 1;
long num = 0;
int n = s.length();
```

## i

Acts like our finger.

```text
12345

^
```

Moves one character at a time.

---

## sign

Stores whether the answer is positive or negative.

Default

```java
sign = 1;
```

If `-` is found

```java
sign = -1;
```

---

## num

Stores the number being built.

We use

```java
long
```

instead of

```java
int
```

so that we can detect overflow safely before returning.

---

## n

Stores the string length.

```java
int n = s.length();
```

Used to avoid repeatedly calling `s.length()`.

---

# Algorithm

1. Remove leading spaces.
2. If the string becomes empty, return `0`.
3. Initialize
   - `i`
   - `sign`
   - `num`
4. Check for `+` or `-`.
5. Read digits while they exist.
6. Build the number using

```java
num = num * 10 + digit;
```

7. Check overflow.
8. Return

```java
(sign * num)
```

---

# Flow Diagram

```text
Input String
      │
      ▼
Ignore Leading Spaces
      │
      ▼
Empty String?
      │
 ┌────┴────┐
 │         │
Yes        No
 │         │
0          ▼
      Initialize
 i, sign, num
      │
      ▼
Check '+' or '-'
      │
      ▼
Read Digits
      │
      ▼
num = num * 10 + digit
      │
      ▼
Overflow?
      │
 ┌────┴─────┐
 │          │
Yes         No
 │          │
Return      ▼
MAX/MIN   Continue
      │
      ▼
Stop at First Non-digit
      │
      ▼
Return sign × num
```

---

# Dry Run

Input

```text
"   -123abc"
```

### Step 1

Skip spaces.

```text
-123abc
```

---

### Step 2

Read

```text
-
```

Store

```java
sign = -1;
```

---

### Step 3

Read

```text
1
```

```text
num = 1
```

Read

```text
2
```

```text
num = 12
```

Read

```text
3
```

```text
num = 123
```

---

### Step 4

Next character

```text
a
```

Not a digit.

Stop.

---

### Step 5

Return

```text
-123
```

---

# Java Implementation

```java
class Solution {
    public int myAtoi(String s) {

        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int sign = 1;
        long num = 0;
        int n = s.length();

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {

            num = num * 10 + (s.charAt(i) - '0');

            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * num);
    }
}
```

---

# Time Complexity

```text
O(n)
```

We traverse the string only once.

---

# Space Complexity

```text
O(1)
```

Only a few variables are used.

---

# Key Takeaways

- Think of the problem as **reading** the string, not converting it.
- Move through the string one character at a time.
- Ignore leading spaces.
- Check the sign.
- Read digits only.
- Build the number using:

```java
num = num * 10 + digit;
```

- Stop at the first non-digit character.
- Handle integer overflow before returning.
