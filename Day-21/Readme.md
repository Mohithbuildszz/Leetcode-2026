# 3014. Minimum Number of Pushes to Type Word I

## Problem Statement

You are given a string `word` containing distinct lowercase English letters.

A telephone keypad contains keys numbered from **2 to 9** (8 keys). You are allowed to remap the letters to these keys in any way you want.

For every key:

- The first letter requires **1 push**
- The second letter requires **2 pushes**
- The third letter requires **3 pushes**
- And so on...

Your task is to determine the **minimum number of key presses** required to type the given word.

---

## Example

### Input

```text
word = "abcdefghijk"
```

### Output

```text
14
```

### Explanation

There are 11 distinct letters.

- First 8 letters → 1 push each
- Remaining 3 letters → 2 pushes each

```text
8 × 1 + 3 × 2 = 14
```

---

# Intuition

Since every character appears **exactly once**, all letters have equal importance.

Therefore, it does not matter which letter gets assigned first.

To minimize the total pushes:

- Fill every **first position** on the keypad first.
- Then fill every **second position**.
- Then every **third position**.

Since there are **8 keys**, each push level can contain at most **8 letters**.

---

# Key Observation

There are only **8 keys**.

| Letter Index | Pushes |
|--------------|---------|
| 0 – 7 | 1 |
| 8 – 15 | 2 |
| 16 – 23 | 3 |
| 24 – 31 | 4 |

This means the number of pushes for any letter at index `i` is

```text
(i / 8) + 1
```

where `/` is integer division.

---

# Approach

1. Let `n` be the length of the word.
2. Initialize the answer as `0`.
3. Traverse every character using its index.
4. Calculate the push count as:

```text
(i / 8) + 1
```

5. Add it to the answer.
6. Return the final answer.

---

# Dry Run

### Input

```text
word = "abcdefghijk"
```

| Index | Push Cost | Running Total |
|-------:|----------:|--------------:|
|0|1|1|
|1|1|2|
|2|1|3|
|3|1|4|
|4|1|5|
|5|1|6|
|6|1|7|
|7|1|8|
|8|2|10|
|9|2|12|
|10|2|14|

Final Answer

```text
14
```

---

# Java Solution

```java
class Solution {
    public int minimumPushes(String word) {
        int pushes = 0;

        for (int i = 0; i < word.length(); i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }
}
```

---

# Code Explanation

```java
int pushes = 0;
```

Stores the total number of key presses.

---

```java
for (int i = 0; i < word.length(); i++)
```

Traverse every character in the word.

---

```java
(i / 8)
```

Integer division determines which group of 8 the current character belongs to.

Example:

```text
0/8 = 0
1/8 = 0
...
7/8 = 0

8/8 = 1
9/8 = 1
...
15/8 = 1

16/8 = 2
```

---

```java
(i / 8) + 1
```

Converts the group number into the required push count.

| Index | Group | Pushes |
|-------:|------:|--------:|
|0–7|0|1|
|8–15|1|2|
|16–23|2|3|
|24–31|3|4|

---

```java
pushes += (i / 8) + 1;
```

Adds the push cost of the current character to the total.

---

```java
return pushes;
```

Returns the minimum number of pushes.

---

# Correctness

- Every key has exactly one first position.
- There are 8 keys.
- Therefore, at most 8 letters can cost 1 push.
- After filling those positions, the next cheapest available positions are all second positions.
- Repeating this process always produces the minimum possible number of pushes.

Thus, the greedy strategy is optimal.

---

# Complexity Analysis

### Time Complexity

```text
O(n)
```

The word is traversed once.

---

### Space Complexity

```text
O(1)
```

Only a few integer variables are used.

---

# Topics

- Greedy
- Math
- Simulation
- Implementation

---

# Key Takeaways

- Since all letters are distinct, every character has equal importance.
- Always assign letters to the cheapest available positions first.
- Every group of 8 letters has the same push cost.
- Integer division `(i / 8)` directly identifies the push level.
- The solution runs in linear time with constant extra space.
