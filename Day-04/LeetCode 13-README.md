# LeetCode 13 - Roman to Integer

## Problem

Convert a Roman numeral string into its corresponding integer.

---

## Visual Explanation
<img width="1672" height="941" alt="67f22aa6-4667-4d13-a9df-c8fe428a4527" src="https://github.com/user-attachments/assets/1f9d61c3-9ff5-4efb-a022-861d37c7f347" />

---

# Roman Numerals

| Symbol | Value |
|---------|------:|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

---

# Key Observation

Normally, Roman numerals are **added**.

```
III = 1 + 1 + 1 = 3
VIII = 5 + 1 + 1 + 1 = 8
```

If a **smaller value appears before a larger value**, it is **subtracted**.

```
IV = 4
IX = 9
XL = 40
XC = 90
CD = 400
CM = 900
```

Instead of memorizing these six cases, simply compare the current character with the next character.

```
current < next
        ↓
     Subtract

Otherwise
        ↓
       Add
```

---

# Intuition

Every Roman numeral decides its contribution by looking only at the next symbol.

```
Current > Next
      ↓
     Add

Current < Next
      ↓
  Subtract
```

Only one comparison is needed.

---

# Approach

### Step 1

Create a HashMap.

```
I → 1
V → 5
X → 10
L → 50
C → 100
D → 500
M → 1000
```

---

### Step 2

Initialize

```
result = 0
```

---

### Step 3

Traverse the string until the second-last character.

```
for(i = 0; i < n-1; i++)
```

---

### Step 4

Get

```
current = map.get(s.charAt(i))

next = map.get(s.charAt(i+1))
```

---

### Step 5

Compare

```
current < next ?

YES
    result -= current

NO
    result += current
```

---

### Step 6

After the loop,

the last character has not been processed.

```
result += value(last character)
```

---

### Step 7

Return result.

---

# Workflow

```
Start
   │
   ▼
Create HashMap
   │
   ▼
result = 0
   │
   ▼
Traverse String
   │
   ▼
Get Current & Next Value
   │
   ▼
Is Current < Next ?
      │
 ┌────┴────┐
 │         │
Yes        No
 │         │
 ▼         ▼
Subtract   Add
 │         │
 └────┬────┘
      ▼
 Continue Loop
      │
      ▼
Add Last Character
      │
      ▼
Return Result
```

---

# Dry Run

Input

```
MCMXCIV
```

| Current | Next | Action | Result |
|---------|------|--------|-------:|
| M(1000) | C(100) | +1000 | 1000 |
| C(100) | M(1000) | -100 | 900 |
| M(1000) | X(10) | +1000 | 1900 |
| X(10) | C(100) | -10 | 1890 |
| C(100) | I(1) | +100 | 1990 |
| I(1) | V(5) | -1 | 1989 |

Loop Ends

```
Add Last Character

1989 + 5 = 1994
```

Final Answer

```
1994
```

---

# Why Add the Last Character?

The loop runs only until

```
n - 2
```

because we access

```
i + 1
```

inside the loop.

The last character has **no next character**, so it never gets processed.

Therefore,

```
result += map.get(s.charAt(s.length()-1));
```

---

# Algorithm

```
Create HashMap

result = 0

for each character except last

    current = value(current)

    next = value(next)

    if current < next

        subtract current

    else

        add current

Add last character

Return result
```

---

# Complexity

**Time Complexity**

```
O(n)
```

One traversal of the string.

**Space Complexity**

```
O(1)
```

HashMap always stores only 7 Roman symbols.

---

# Interview Recall (30 Seconds)

```
1. Create HashMap.

2. Traverse till n-2.

3. Compare current with next.

4. current < next
      ↓
   Subtract

5. Else
      ↓
      Add

6. Add last character.

7. Return result.
```

---

# What I Learned

- Using a HashMap for constant-time lookups.
- Identifying patterns instead of memorizing special cases.
- Solving the problem using adjacent comparisons.
- Why the last element sometimes needs separate handling.
- Designing an efficient single-pass algorithm.
- Time Complexity: O(n)
- Space Complexity: O(1)
