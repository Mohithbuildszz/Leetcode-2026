# 3016. Minimum Number of Pushes to Type Word II

## Problem Statement

You are given a string `word` consisting of lowercase English letters.

A telephone keypad has **8 keys (2 to 9)**. Each key can contain any number of distinct lowercase letters.

- Pressing the **first letter** on a key requires **1 push**.
- Pressing the **second letter** on the same key requires **2 pushes**.
- Pressing the **third letter** requires **3 pushes**, and so on.

You are allowed to **remap** the letters to the keys in any way.

Return the **minimum number of pushes** required to type the given word.

---

## Example

### Input

```text
word = "abcabc"
```

### Output

```text
6
```

### Explanation

Frequency of each character:

```text
a → 2
b → 2
c → 2
```

Since there are only three unique letters, assign each one as the first letter of a different key.

```text
a → 1 press
b → 1 press
c → 1 press
```

Total pushes:

```text
2 × 1 + 2 × 1 + 2 × 1 = 6
```

---

# Intuition

To minimize the total number of pushes:

- Letters that appear **more frequently** should require **fewer pushes**.
- Since there are **8 keys**, only **8 letters** can be placed in the first position (cost = 1).
- The next **8 letters** must be placed in the second position (cost = 2).
- Continue similarly for the remaining letters.

Therefore, we should:

1. Count the frequency of every letter.
2. Sort frequencies in descending order.
3. Assign the minimum press cost to the highest frequencies.

---

# Approach

### Step 1

Create a frequency array of size **26**.

```java
int[] freq = new int[26];
```

---

### Step 2

Count the frequency of every character.

```java
for(char ch : word.toCharArray()){
    freq[ch - 'a']++;
}
```

Example

```text
word = "abca"

Frequency

a = 2
b = 1
c = 1
```

---

### Step 3

Sort the frequency array.

```java
Arrays.sort(freq);
```

The largest frequencies will now be at the end of the array.

---

### Step 4

Traverse from the largest frequency to the smallest.

```java
for(int i = 25; i >= 0; i--)
```

Skip remaining zeros.

```java
if(freq[i] == 0)
    break;
```

---

### Step 5

Assign presses.

Since every group of **8 letters** shares the same press count:

| Position | Presses |
|----------|----------|
| 0 – 7 | 1 |
| 8 – 15 | 2 |
| 16 – 23 | 3 |
| 24 – 25 | 4 |

Formula

```java
presses = (position / 8) + 1;
```

---

### Step 6

Each letter contributes

```text
frequency × presses
```

```java
answer += freq[i] * presses;
```

---

# Dry Run

### Input

```text
word = "aaabbbccccd"
```

### Frequency

```text
a = 3
b = 3
c = 4
d = 1
```

After sorting

```text
0 0 0 ... 1 3 3 4
```

Traverse from largest:

|Position|Frequency|Presses|Contribution|
|---------|---------|--------|------------|
|0|4|1|4|
|1|3|1|3|
|2|3|1|3|
|3|1|1|1|

Answer

```text
4 + 3 + 3 + 1 = 11
```

---

# Algorithm

1. Create a frequency array.
2. Count the occurrence of each character.
3. Sort the frequency array.
4. Traverse from highest frequency.
5. Calculate presses using:

```text
(position / 8) + 1
```

6. Multiply

```text
frequency × presses
```

7. Return the total.

---

# Correct Java Solution

```java
class Solution {
    public int minimumPushes(String word) {

        int[] freq = new int[26];

        // Count frequency of each letter
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int answer = 0;
        int position = 0;

        // Traverse from highest frequency
        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0)
                break;

            int presses = (position / 8) + 1;

            answer += freq[i] * presses;

            position++;
        }

        return answer;
    }
}
```

---

# Why Does `(position / 8) + 1` Work?

There are only **8 keys**.

The first **8 letters** get **1 press**.

```text
Position 0-7 → 1 press
```

The next **8 letters** get **2 presses**.

```text
Position 8-15 → 2 presses
```

The next **8 letters** get **3 presses**.

```text
Position 16-23 → 3 presses
```

The last **2 letters** get **4 presses**.

```text
Position 24-25 → 4 presses
```

Using integer division:

|Position|Position / 8|Presses|
|---------|------------|--------|
|0|0|1|
|1|0|1|
|7|0|1|
|8|1|2|
|9|1|2|
|16|2|3|
|24|3|4|

Hence,

```java
presses = (position / 8) + 1;
```

---

# Complexity Analysis

### Time Complexity

- Frequency Count → **O(n)**
- Sorting 26 elements → **O(26 log 26) ≈ O(1)**
- Traversing frequency array → **O(26) ≈ O(1)**

**Overall:**

```text
O(n)
```

---

### Space Complexity

Frequency array of size 26.

```text
O(1)
```

---

# Key Takeaways

- Use a frequency array to count character occurrences.
- Assign the minimum press cost to the most frequent letters.
- Sorting frequencies enables the greedy approach.
- Every group of **8 letters** shares the same press count.
- The formula `(position / 8) + 1` automatically determines the required number of key presses.

---
<div>
    <img width="1024" height="1536" alt="c01855cb-c010-425e-b8ba-42cc6ca4f69a" src="https://github.com/user-attachments/assets/c405d212-e0aa-4b98-928b-e24ffea04465" />
</div>
