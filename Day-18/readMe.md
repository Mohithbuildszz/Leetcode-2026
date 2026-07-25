# 42. Trapping Rain Water

## Problem Statement

Given an array representing the elevation map where each bar has a width of `1`, determine how many units of rainwater can be trapped after raining.

---

## Intuition

Water can only be trapped when there are taller bars on both the left and the right.

For every index:

- Find the tallest bar on the left.
- Find the tallest bar on the right.
- The shorter of these two bars determines the maximum water level.
- The current bar occupies some height, so the remaining space stores water.

Water trapped at any index is determined by:

> Water Level = Minimum of (Left Maximum, Right Maximum)

---

## Key Observation

- If the left boundary is shorter, the left side determines the water level.
- If the right boundary is shorter, the right side determines the water level.
- The taller boundary does not matter because water can never rise above the shorter boundary.

This observation allows us to solve the problem using the **Two Pointer** technique without storing extra arrays.

---

## Two Pointer Approach

Maintain two pointers:

- **Left Pointer** → Starts from the beginning.
- **Right Pointer** → Starts from the end.

Also maintain:

- **leftMax** → Tallest bar seen from the left.
- **rightMax** → Tallest bar seen from the right.

### Processing Logic

- Compare the heights at both pointers.
- Process the side with the smaller height.
- Update the corresponding maximum height.
- If the current bar is smaller than the maximum seen so far, water is trapped.
- Move the processed pointer inward.
- Continue until both pointers meet.

---

## Why Does This Work?

When the left bar is smaller than the right bar:

- A taller wall already exists on the right.
- Therefore, only the tallest wall on the left determines the water trapped at the current position.

Similarly,

When the right bar is smaller:

- A taller wall already exists on the left.
- Therefore, only the tallest wall on the right determines the trapped water.

Because of this, there is no need to know both maximums at every step.

---

## Example

Input

```
[3,0,2,0,4]
```

| Index | Height | Left Max | Right Max | Water Trapped |
|------:|-------:|---------:|----------:|--------------:|
| 0 | 3 | 3 | 4 | 0 |
| 1 | 0 | 3 | 4 | 3 |
| 2 | 2 | 3 | 4 | 1 |
| 3 | 0 | 3 | 4 | 3 |
| 4 | 4 | 4 | 4 | 0 |

Total Water Trapped = **7**

---

## Dry Run Summary

1. Initialize two pointers at both ends.
2. Track the maximum height seen from both sides.
3. Process the side with the smaller height.
4. Update the corresponding maximum.
5. Calculate trapped water if the current height is smaller than the maximum.
6. Move the pointer inward.
7. Continue until both pointers cross.

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |

---

## Key Takeaways

- Water needs **two boundaries**.
- The **shorter boundary** determines the water level.
- Always process the side with the **smaller height**.
- Maintain only two maximum values instead of two extra arrays.
- Two Pointer is the most optimal solution with **O(n)** time and **O(1)** space.

---
<div>
  <img width="1254" height="1254" alt="45e5c1de-abdd-4cc7-af04-cfb1d46d788b" src="https://github.com/user-attachments/assets/288b2973-b1d2-42a6-8496-6dd5b49095e2" />

</div>
## Interview Tips

- Remember the formula:
  - Water Level = Minimum(Left Maximum, Right Maximum)
- The current bar itself is included while calculating both **leftMax** and **rightMax**.
- Never calculate:
  - `leftMax - rightMax`
- Always calculate:
  - `min(leftMax, rightMax) - currentHeight`
- Think of the shorter wall as the limiting factor because water cannot rise above it.

---

## Pattern

- Arrays
- Prefix/Suffix Maximum
- Two Pointers
- Simulation
- Greedy Observation

---

## Tags

`Array` `Two Pointers` `Dynamic Programming` `Prefix Maximum` `Greedy`
