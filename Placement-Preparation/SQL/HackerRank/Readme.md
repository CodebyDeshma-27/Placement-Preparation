# HackerRank SQL - Selected Problems & Concepts

This section contains selected HackerRank SQL problems that introduced new concepts, medium-level logic, or useful interview patterns.

## Concepts Covered

* CASE Statements
* String Functions
* Aggregation
* Recursive CTE
* Mathematical Functions
* GROUP_CONCAT
* EXISTS / NOT EXISTS
* Hierarchical Data
## Concepts
Concepts Covered
## String Functions
1. CONCAT()
2. LEFT()
3. LOWER()
4. REPLACE()
## Aggregation
1. COUNT()
2. SUM()
3. AVG()
4. GROUP BY
5. HAVING
## Joins
1. INNER JOIN
2. LEFT JOIN
3. CROSS JOIN
4. RIGHT JOIN
5. SELF JOIN
## Conditional Logic
1. CASE WHEN
2. Date Functions
3. DATE_FORMAT()
## Mathematical Functions
1. MOD()
2. POWER()
3. SQRT()
4. ROUND()
5. CEIL()
## Advanced SQL
1. Recursive CTE
2. Subqueries
3. UNION ALL
4. GROUP_CONCAT
5. EXISTS / NOT EXISTS
## Selected Problems
| Problem | Difficulty | Key Concepts |
|----------|----------|----------|
| The PADS | Medium | String Formatting, Aggregation |
| Type of Triangle | Easy | CASE WHEN |
| Print Prime Numbers | Medium | GROUP_CONCAT, NOT EXISTS |
| Draw The Triangle 1 | Medium | Recursive CTE |
| Draw The Triangle 2 | Medium | Recursive CTE |
| Weather Observation Station 19 | Easy | Geometry Functions, Mathematical Operations |
| The Blunder | Easy | Data Cleaning, String Manipulation |
| Monthly Transactions I | Medium | Conditional Aggregation, CASE WHEN |
| Movie Rating | Medium | UNION ALL, Aggregation |
| Tree Node | Medium | Hierarchical Data, CASE WHEN |
| Students and Examinations | Easy | CROSS JOIN, LEFT JOIN |

---

## Type of Triangle

**Difficulty:** Easy

**Concept:** CASE Statement

**Problem Summary:**
Classify each set of side lengths as Equilateral, Isosceles, Scalene, or Not A Triangle.

### Solution

```sql
SELECT
    CASE
        WHEN A+B<=C OR A+C<=B OR B+C<=A THEN 'Not A Triangle'
        WHEN A=B AND B=C THEN 'Equilateral'
        WHEN A=B OR B=C OR A=C THEN 'Isosceles'
        ELSE 'Scalene'
    END
FROM TRIANGLES;
```

### Key Learning

Use CASE statements to classify records based on multiple conditions. Always validate the triangle inequality before checking the triangle type.

---

## The PADS

**Difficulty:** Medium

**Concept:** String Functions, Aggregation

**Problem Summary:**
Display names with the first letter of occupation and report the count of each occupation.

### Solution

```sql
SELECT CONCAT(Name, '(', LEFT(Occupation,1), ')')
FROM OCCUPATIONS
ORDER BY Name;

SELECT CONCAT(
    'There are a total of ',
    COUNT(Occupation),
    ' ',
    LOWER(Occupation),
    's.'
)
FROM OCCUPATIONS
GROUP BY Occupation
ORDER BY COUNT(Occupation), Occupation;
```

### Key Learning

Formatting output using CONCAT(), LEFT(), LOWER(), GROUP BY, and COUNT().

---

## Print Prime Numbers

**Difficulty:** Medium

**Concept:** GROUP_CONCAT, NOT EXISTS

**Problem Summary:**
Print all prime numbers less than or equal to 1000 separated by '&'.

### Solution

```sql
SET @num = 1;

SELECT GROUP_CONCAT(prime SEPARATOR '&')
FROM
(
    SELECT @num:=@num+1 AS prime
    FROM information_schema.tables t1,
         information_schema.tables t2
    WHERE @num < 1000
) numbers
WHERE NOT EXISTS (
    SELECT *
    FROM
    (
        SELECT @div:=@div+1 AS divisor
        FROM information_schema.tables t3,
             information_schema.tables t4,
             (SELECT @div:=1) temp
        LIMIT 1000
    ) divisors
    WHERE divisor < prime
    AND prime % divisor = 0
);
```

### Key Learning

Prime number generation can be achieved using divisibility checks combined with NOT EXISTS.

---

## Draw The Triangle 1

**Difficulty:** Medium

**Concept:** Recursive CTE

**Problem Summary:**
Print an inverted triangle pattern with 20 rows.

### Solution

```sql
WITH RECURSIVE pattern AS (
    SELECT 20 AS n
    UNION ALL
    SELECT n - 1
    FROM pattern
    WHERE n > 1
)
SELECT REPEAT('* ', n) AS pattern
FROM pattern;
```

### Key Learning

Recursive CTEs can generate sequences and patterns without requiring a numbers table.

---

## The Blunder

**Difficulty:** Easy

**Concept:** String Manipulation, Aggregation

**Problem Summary:**
Calculate the difference between the actual average salary and the incorrectly calculated average salary where all zeros are removed.

### Solution

```sql
SELECT CEIL(
    AVG(SALARY) -
    AVG(REPLACE(Salary,'0',''))
)
FROM EMPLOYEES;
```

### Key Learning

REPLACE() can be combined with aggregate functions to simulate modified datasets.

---
