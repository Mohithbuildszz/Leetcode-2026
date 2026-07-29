# 125. Valid Palindrome (Brute Force - StringBuilder)

## Problem Statement

Given a string `s`, determine whether it is a palindrome after:

- Converting all uppercase letters to lowercase.
- Removing all non-alphanumeric characters.

Return `true` if it is a palindrome; otherwise, return `false`.

---

## Examples

### Example 1

**Input**

```text
s = "A man, a plan, a canal: Panama"
```

**Output**

```text
true
```

**Explanation**

After removing non-alphanumeric characters and converting to lowercase:

```text
amanaplanacanalpanama
```

The string reads the same forwards and backwards.

---

### Example 2

**Input**

```text
s = "race a car"
```

**Output**

```text
false
```

**Explanation**

Cleaned string:

```text
raceacar
```

Reversed string:

```text
racaecar
```

Both are different.

---

## Brute Force Approach

The brute force approach is straightforward:

1. Create a new `StringBuilder`.
2. Traverse the input string.
3. Keep only letters and digits.
4. Convert each valid character to lowercase.
5. Store the cleaned characters in `StringBuilder`.
6. Convert the cleaned string into a normal string.
7. Reverse the cleaned string.
8. Compare the original cleaned string with the reversed string.

If both are equal, return `true`; otherwise, return `false`.

---

## Algorithm

1. Initialize an empty `StringBuilder`.
2. Iterate through every character of the string.
3. If the character is alphanumeric:
   - Convert it to lowercase.
   - Append it to `StringBuilder`.
4. Convert the builder into a string.
5. Reverse the cleaned string.
6. Compare both strings.
7. Return the result.

---

## Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder cleaned = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        String original = cleaned.toString();

        String reverse = new StringBuilder(original)
                .reverse()
                .toString();

        return original.equals(reverse);
    }
}
```

---

## Dry Run

### Input

```text
"A man, a plan, a canal: Panama"
```

### Step 1

Original String

```text
A man, a plan, a canal: Panama
```

### Step 2

Remove special characters and spaces

```text
AmanaplanacanalPanama
```

### Step 3

Convert to lowercase

```text
amanaplanacanalpanama
```

### Step 4

Reverse

```text
amanaplanacanalpanama
```

### Step 5

Compare

```text
Original == Reversed
```

Result

```text
true
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time Complexity | **O(n)** |
| Space Complexity | **O(n)** |

### Why?

- Traversing the string takes **O(n)**.
- Reversing the string takes **O(n)**.
- Comparing both strings takes **O(n)**.

Overall Time Complexity remains **O(n)**.

Since a new cleaned string and a reversed string are created, the extra space required is **O(n)**.

---

## Java Methods Used

| Method | Description |
|---------|-------------|
| `Character.isLetterOrDigit(ch)` | Checks whether the character is a letter or digit. |
| `Character.toLowerCase(ch)` | Converts a character to lowercase. |
| `StringBuilder.append()` | Adds a character to the builder. |
| `StringBuilder.reverse()` | Reverses the string. |
| `toString()` | Converts `StringBuilder` to a `String`. |
| `equals()` | Compares two strings. |

---

## Key Takeaways

- Create a cleaned string containing only lowercase letters and digits.
- Reverse the cleaned string.
- Compare the cleaned string with its reverse.
- This is a simple and easy-to-understand brute force solution.
- Although the time complexity is optimal (**O(n)**), the space complexity is **O(n)** because additional strings are created.

---

## Follow-up

Can we solve this without creating another string?

Yes. The optimal solution uses the **Two Pointers** technique, which achieves:

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

This is the preferred approach in interviews because it avoids extra memory.
