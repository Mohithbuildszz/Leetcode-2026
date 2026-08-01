# 1021. Remove Outermost Parentheses

## Problem Statement

A valid parentheses string is made up of one or more **primitive** valid parentheses strings.

A **primitive** parentheses string is a valid parentheses string that **cannot be split into two non-empty valid parentheses strings**.

Your task is to **remove the outermost parentheses from every primitive string** and return the final result.

---

## Example

### Example 1

**Input**

```text
s = "(()())(())"
```

Primitive decomposition

```text
(()()) + (())
```

Remove outermost parentheses

```text
(()())  →  ()()
(())
      →  ()
```

**Output**

```text
()()()
```

---

### Example 2

**Input**

```text
s = "(()())(())(()(()))"
```

Primitive decomposition

```text
(()())
(())
(()(()))
```

After removing outermost parentheses

```text
()()
()
()(())
```

**Output**

```text
()()()()(())
```

---

# Intuition

The first opening parenthesis `(` of every primitive and the last closing parenthesis `)` of every primitive are called the **outermost parentheses**.

We only need to keep the parentheses that are **inside** each primitive.

Instead of using a stack, we only need to know **how deep we are inside the current primitive**.

We use a variable called **balance**.

- `'('` → `balance++`
- `')'` → `balance--`

Whenever

```text
balance = 0
```

we are outside any primitive.

Whenever

```text
balance > 0
```

we are inside a primitive.

---

# Approach

## Step 1

Create a `StringBuilder` to store the final answer.

```java
StringBuilder sb = new StringBuilder();
```

---

## Step 2

Maintain a balance counter.

```java
int balance = 0;
```

The balance represents the current nesting depth.

---

## Step 3

Traverse every character of the string.

```java
for(char ch : s.toCharArray())
```

---

## Step 4

If the character is `'('`

- If `balance > 0`
  - We are already inside a primitive.
  - Append `'('`.
- Increase balance.

```java
if(balance > 0)
    sb.append(ch);

balance++;
```

---

## Step 5

If the character is `')'`

- First decrease balance.
- If `balance > 0`
  - We are still inside the primitive.
  - Append `')'`.

```java
balance--;

if(balance > 0)
    sb.append(ch);
```

---

## Step 6

Return the final string.

```java
return sb.toString();
```

---

# Dry Run

Input

```text
(()())(())
```

| Character | Balance Before | Action | Balance After | Append | Answer |
|-----------|---------------:|--------|--------------:|:------:|--------|
| ( | 0 | Skip, balance++ | 1 | ❌ | "" |
| ( | 1 | Append, balance++ | 2 | ✅ | "(" |
| ) | 2 | balance--, Append | 1 | ✅ | "()" |
| ( | 1 | Append, balance++ | 2 | ✅ | "()(" |
| ) | 2 | balance--, Append | 1 | ✅ | "()()" |
| ) | 1 | balance-- | 0 | ❌ | "()()" |
| ( | 0 | Skip, balance++ | 1 | ❌ | "()()" |
| ( | 1 | Append, balance++ | 2 | ✅ | "()()(" |
| ) | 2 | balance--, Append | 1 | ✅ | "()()()" |
| ) | 1 | balance-- | 0 | ❌ | "()()()" |

Final Output

```text
()()()
```

---

# Why This Works

The balance variable represents the current nesting depth.

- `balance == 0`
  - Outside any primitive.
- `balance > 0`
  - Inside a primitive.

### Opening Parenthesis

```java
if(balance > 0)
    sb.append(ch);

balance++;
```

The first `'('` of every primitive has `balance == 0`.

So it is skipped.

---

### Closing Parenthesis

```java
balance--;

if(balance > 0)
    sb.append(ch);
```

The last `')'` of every primitive makes the balance become `0`.

So it is skipped.

---

# Algorithm

1. Create a `StringBuilder`.
2. Initialize `balance = 0`.
3. Traverse each character.
4. For `'('`
   - If `balance > 0`, append it.
   - Increment `balance`.
5. For `')'`
   - Decrement `balance`.
   - If `balance > 0`, append it.
6. Return the answer.

---

# Java Solution

```java
class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                if (balance > 0) {
                    sb.append(ch);
                }

                balance++;

            } else {

                balance--;

                if (balance > 0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
```

---

# Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the string exactly once.

---

### Space Complexity

```text
O(n)
```

`StringBuilder` stores the resulting string.

---

# Key Takeaways

- Parentheses problem.
- Uses **Balance Counter (Depth Tracking)**.
- `balance` stores the current nesting depth.
- Skip the first `'('` of every primitive.
- Skip the last `')'` of every primitive.
- `StringBuilder` efficiently constructs the answer.
- Single traversal solution.

---

# Pattern Recognition

**Category**

- String

**Pattern**

- Parentheses
- Balance Counter (Depth Tracking)

**Data Structure**

- StringBuilder

**Technique**

- Single Pass Traversal

---

## Interview Tip

When you see a parentheses problem, ask yourself:

- Do I need to know the matching brackets?
  - ✅ Yes → Use **Stack**
  - ❌ No, I only need the nesting depth → Use **Balance Counter**

For this problem, only the nesting depth matters, so a simple integer `balance` is enough. This reduces the extra space from **O(n)** (stack) to **O(1)** while maintaining **O(n)** time complexity.
