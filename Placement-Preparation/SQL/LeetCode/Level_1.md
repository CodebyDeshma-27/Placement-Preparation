SQL Basic Query Workstation
# LeetCode Database - Level 1

## 175. Combine Two Tables

**Difficulty:** Easy

**Concept:** LEFT JOIN

**Problem Summary:**
Return the first name, last name, city, and state of every person. If a person does not have an address, return NULL for city and state.

### Solution

```sql
SELECT
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId;
```

### Key Learning

Use `LEFT JOIN` when all records from the left table must be retained, even when matching records do not exist in the right table.

---

## 181. Employees Earning More Than Their Managers

**Difficulty:** Easy

**Concept:** Self Join

**Problem Summary:**
Find employees whose salary is greater than their manager's salary.

### Solution

```sql
SELECT e.name AS Employee
FROM Employee e
INNER JOIN Employee m
ON e.managerId = m.id
WHERE e.salary > m.salary;
```

### Key Learning

A table can be joined with itself using aliases to compare employees with their managers.

---

## 620. Not Boring Movies

**Difficulty:** Easy

**Concept:** Filtering, Ordering

**Problem Summary:**
Return movies with odd-numbered IDs and a description that is not "boring", ordered by rating in descending order.

### Solution

```sql
SELECT id, movie, description, rating
FROM Cinema
WHERE MOD(id,2) <> 0
AND description <> 'boring'
ORDER BY rating DESC;
```

### Key Learning

Use `MOD()` to identify odd/even IDs and combine multiple filtering conditions using `AND`.

---

## 584. Find Customer Referee

**Difficulty:** Easy

**Concept:** NULL Handling

**Problem Summary:**
Return customers who were either not referred by customer ID 2 or were not referred by anyone.

### Solution

```sql
SELECT name
FROM Customer
WHERE referee_id <> 2
OR referee_id IS NULL;
```

### Key Learning

Always handle `NULL` values explicitly because comparisons with `NULL` do not return TRUE.

