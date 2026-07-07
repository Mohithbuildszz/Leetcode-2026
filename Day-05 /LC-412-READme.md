<img width="1536" height="1024" alt="fe6207ce-cf03-49b8-85ee-d62f189480b6" src="https://github.com/user-attachments/assets/ee3aeb09-a383-447b-bcb2-ae80f203e8d3" />
# FizzBuzz

## Problem Statement

Given an integer `n`, generate a list of strings from `1` to `n`.

Rules:

- If a number is divisible by both `3` and `5`, add `"FizzBuzz"`.
- If a number is divisible only by `3`, add `"Fizz"`.
- If a number is divisible only by `5`, add `"Buzz"`.
- Otherwise, add the number as a string.

---

# Observation

- Input is an integer `n`.
- We must process every number from `1` to `n`.
- Since we need to visit each number once, a `for` loop is the best choice.
- Since the output is a list of strings, we use `ArrayList<String>`.

---

  <div>
    
  </div>
  
# Approach

### Step 1

Create an empty list.

```java
List<String> result = new ArrayList<>();
```

This list stores every answer.

---

### Step 2

Iterate from `1` to `n`.

```java
for (int i = 1; i <= n; i++)
```

Why start from `1`?

Because the problem asks us to process numbers from `1` to `n`.

Example:

```
n = 5

1
2
3
4
5
```

Not

```
0
1
2
3
4
5
```

---

### Step 3

Check if the number is divisible by both `3` and `5`.

```java
if (i % 15 == 0)
```

or

```java
if (i % 3 == 0 && i % 5 == 0)
```

Both are correct.

We check this first because every number divisible by both `3` and `5` is also divisible by `3`.

Example:

```
15

15 % 3 == 0
15 % 5 == 0
```

If we check only `3` first, we'll never reach `"FizzBuzz"`.

---

### Step 4

Check divisibility by `3`.

```java
else if (i % 3 == 0)
```

Add

```java
result.add("Fizz");
```

---

### Step 5

Check divisibility by `5`.

```java
else if (i % 5 == 0)
```

Add

```java
result.add("Buzz");
```

---

### Step 6

If none of the conditions match,

convert the integer into a string.

```java
else
{
    result.add(String.valueOf(i));
}
```

---

### Step 7

Return the result.

```java
return result;
```

---

# Dry Run

Input

```
n = 5
```

Initially

```
result = []
```

| i | Condition | Added | Result |
|---|-----------|-------|--------|
|1|None|"1"|["1"]|
|2|None|"2"|["1","2"]|
|3|Divisible by 3|"Fizz"|["1","2","Fizz"]|
|4|None|"4"|["1","2","Fizz","4"]|
|5|Divisible by 5|"Buzz"|["1","2","Fizz","4","Buzz"]|

Return

```
["1","2","Fizz","4","Buzz"]
```

---

# Java Code

```java
class Solution {

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (i % 15 == 0) {
                result.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                result.add("Fizz");
            }
            else if (i % 5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
```

---

# Time Complexity

```
O(n)
```

Reason:

- The loop runs exactly `n` times.
- Every iteration performs constant-time operations.

---

# Space Complexity

```
O(n)
```

Reason:

- We store `n` strings inside the `ArrayList`.

---

# Important Points to Remember

### Why `ArrayList`?

Because the size of the output grows dynamically while iterating.

---

### Why `for` loop?

Because we need to process every number from `1` to `n`.

---

### Why `i = 1`?

The problem asks us to process numbers from `1` to `n`.

---

### Why not `i = 0`?

Because `0` is not part of the required range.

Also,

```
0 % 3 == 0
0 % 5 == 0
```

which would incorrectly produce `"FizzBuzz"`.

---

### Why not `n.length`?

`n` is an integer.

```
int n
```

Only arrays have

```java
array.length
```

and strings have

```java
string.length()
```

An integer has no length.

---

### Why check `FizzBuzz` first?

Example:

```
i = 15
```

If you check

```java
i % 3 == 0
```

first,

the answer becomes

```
Fizz
```

and the remaining conditions are skipped.

Correct order:

```
FizzBuzz
↓

Fizz
↓

Buzz
↓

Number
```

---

# Pattern Learned

Whenever a problem says

```
Process numbers from 1 to n
```

Think:

```
for loop
```

Whenever it says

```
Store all answers
```

Think:

```
ArrayList
```

Whenever it says

```
Different outputs based on conditions
```

Think:

```
if
else if
else
```

---

# Interview Recall

```
Input
↓

Create ArrayList

↓

Loop from 1 to n

↓

Check divisible by 15

↓

Check divisible by 3

↓

Check divisible by 5

↓

Otherwise add number

↓

Return ArrayList
```

This is the complete thought process you should recall before writing the code. If you can remember this flow, you can solve FizzBuzz in under a minute during interviews or coding rounds.
