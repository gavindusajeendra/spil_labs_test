# spil_labs_test
Programming Test: Optimal Patrol Path Around Machines

# Optimal Patrol Path Around Machines

## Problem Statement

A factory floor contains N rectangular machines, each aligned with the coordinate axes. A
security robot must patrol around them along a simple closed polygonal path (a loop).
The path:
• Must not pass through the interior of any rectangle.
• Must enclose all rectangles (each rectangle must lie entirely inside the loop or on its edges).
Among all such paths, the factory wants the shortest possible path length.
You may assume:
• Rectangles can touch each other but do not overlap in their interior.
• The optimal path is the boundary of the convex hull of all rectangle corners.\

Input Format

• An integer N with 1 ≤ N ≤ 2 × 105
.
• Then N lines follow. Each line contains four numbers
x1, y1, x2, y2
representing the opposite corners of one axis-aligned rectangle.
Coordinates are real numbers or integers with absolute value up to 10^6.

Output Format
Output a single real number: the minimum possible path length, with absolute or relative error
at most 10−6

# Mathematical Transformation

Each rectangle is represented by two opposite corners:

(x1, y1), (x2, y2)

From these coordinates, the four corners of the rectangle are generated:

(x1, y1)
(x1, y2)
(x2, y1)
(x2, y2)

For `N` rectangles:

Total points = 4N

The problem is therefore transformed into:

Compute the convex hull of all rectangle corner points and calculate its perimeter.

# Why Convex Hull Gives the Optimal Patrol Path

Conveex Hull is a polygon that encloses all of the points.

The shortest enclosing polygon must be convex.

If the path contains any inward indentation (concavity), replacing that section with a straight line would shorten the total perimeter while still enclosing all rectangles.

Optimal Patrol Path = Convex Hull of All Rectangle Corners

# Algorithm Used

# Andrew’s Monotone Chain Algorithm

This solution uses Andrew’s Monotone Chain algorithm to compute the convex hull efficiently.

# Mathematical Formulas

## Cross Product / Orientation Test

Used to determine turn direction between three points:

cross(O, A, B) = (Ax - Ox)(By - Oy) - (Ay - Oy)(Bx - Ox)


Interpretation:

- Positive → Counterclockwise turn
- Negative → Clockwise turn
- Zero → Collinear

---

## Euclidean Distance

Distance between two points:

d(A, B) = √((Ax - Bx)² + (Ay - By)²)

1. Mathematical Explanation
(a) Explain how to transform the rectangle problem into a problem on points (for example,
by considering the corners of each rectangle).
(b) Explain why it is valid to consider the convex hull of all rectangle corners as the optimal
patrol path.
(c) Describe the algorithm you will use to compute this convex hull (for example, Andrew’s
monotone chain or Graham scan), including:
• Why sorting the points is needed.
• How cross products / orientation tests are used to build the hull.
• The overall time complexity in terms of N.
1
2. Mathematical Details (Formulas)
In your explanation, clearly state and use:
• The formula for the cross product / orientation test of three points O, A, B.
• The Euclidean distance between two points.
• The formula for the perimeter as the sum of distances along the convex hull.


