# LeetCode Database - Level 3

## Concepts Covered

* CROSS JOIN
* LEFT JOIN
* GROUP BY
* HAVING
* COUNT DISTINCT
* Subqueries
* CASE Statements
* Self-Referencing Tables
* Aggregate Functions
* UNION ALL

---

## 1280. Students and Examinations

**Difficulty:** Easy

**Concept:** CROSS JOIN, LEFT JOIN, GROUP BY

**Problem Summary:**
For every student and every subject, determine how many times the student attended the exam.

### Solution

```sql
SELECT
    s.student_id,
    s.student_name,
    sub.subject_name,
    COUNT(e.student_id) AS attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
    ON s.student_id = e.student_id
   AND sub.subject_name = e.subject_name
GROUP BY
    s.student_id,
    s.student_name,
    sub.subject_name
ORDER BY
    s.student_id,
    sub.subject_name;
```

### Key Learning

Use `CROSS JOIN` to generate all possible student-subject combinations and `LEFT JOIN` to count matching exam records, including cases where attendance is zero.

---

## 1045. Customers Who Bought All Products

**Difficulty:** Medium

**Concept:** GROUP BY, HAVING, COUNT DISTINCT, Subquery

**Problem Summary:**
Find customers who purchased every product available in the Product table.

### Solution

```sql
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) =
(
    SELECT COUNT(*)
    FROM Product
);
```

### Key Learning

Compare the number of unique products purchased by each customer against the total number of products using a subquery.

---

## 608. Tree Node

**Difficulty:** Medium

**Concept:** CASE Statement, Hierarchical Data

**Problem Summary:**
Classify each node in a tree as Root, Inner, or Leaf.

### Solution

```sql
SELECT
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT p_id FROM Tree) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree
ORDER BY id;
```

### Key Learning

`CASE` expressions are useful for categorizing rows based on multiple conditions. Tree structures often require checking parent-child relationships.

---

## 1341. Movie Rating

**Difficulty:** Medium

**Concept:** Aggregation, Sorting, UNION ALL

**Problem Summary:**

1. Find the user who rated the greatest number of movies.
2. Find the movie with the highest average rating in February 2020.

For ties, return the lexicographically smaller name.

### Solution

```sql
(
    SELECT u.name AS results
    FROM Users u
    JOIN MovieRating mr
        ON u.user_id = mr.user_id
    GROUP BY u.user_id, u.name
    ORDER BY COUNT(mr.movie_id) DESC,
             u.name ASC
    LIMIT 1
)

UNION ALL

(
    SELECT m.title AS results
    FROM Movies m
    JOIN MovieRating mr
        ON m.movie_id = mr.movie_id
    WHERE mr.created_at LIKE '2020-02%'
    GROUP BY m.movie_id, m.title
    ORDER BY AVG(mr.rating) DESC,
             m.title ASC
    LIMIT 1
);
```

### Key Learning

Complex SQL problems can often be broken into multiple independent queries and combined using `UNION ALL`.
