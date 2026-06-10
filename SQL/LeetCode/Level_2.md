# LeetCode Database - Level 2

## 586. Customer Placing the Largest Number of Orders

**Difficulty:** Easy

**Concept:** GROUP BY, COUNT, ORDER BY

**Problem Summary:**
Find the customer who has placed the highest number of orders.

### Solution

```sql
SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;
```

### Key Learning

Use `GROUP BY` with `COUNT(*)` to aggregate records and `ORDER BY ... DESC` to identify the highest occurrence.

---

## 596. Classes With at Least 5 Students

**Difficulty:** Easy

**Concept:** GROUP BY, HAVING

**Problem Summary:**
Find all classes that have at least five enrolled students.

### Solution

```sql
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
```

### Key Learning

`HAVING` is used to filter grouped results after aggregation.

---

## 1193. Monthly Transactions I

**Difficulty:** Medium

**Concept:** GROUP BY, Conditional Aggregation, CASE WHEN

**Problem Summary:**
For each month and country, report:

* Total transactions and amount
* Approved transactions and amount

### Solution

```sql
SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) AS trans_count,
    SUM(amount) AS trans_total_amount,
    SUM(
        CASE
            WHEN state = 'approved' THEN 1
            ELSE 0
        END
    ) AS approved_count,
    SUM(
        CASE
            WHEN state = 'approved' THEN amount
            ELSE 0
        END
    ) AS approved_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date,'%Y-%m'), country;
```

### Key Learning

Conditional aggregation using `CASE WHEN` allows multiple metrics to be computed in a single query.

---

## 1141. User Activity for the Past 30 Days I

**Difficulty:** Easy

**Concept:** Date Filtering, COUNT DISTINCT

**Problem Summary:**
Find the number of active users for each day within the 30-day period ending on 2019-07-27.

### Solution

```sql
SELECT
    activity_date AS day,
    COUNT(DISTINCT user_id) AS active_users
FROM Activity
WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY activity_date;
```

### Key Learning

`COUNT(DISTINCT column)` is commonly used to count unique entities while avoiding duplicates.
