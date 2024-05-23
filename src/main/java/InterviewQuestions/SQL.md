1. Why indexing in SQL is useful ?
    - A SQL index is a quick lookup table that helps to find records that are frequently searched by a user. An index is
      fast, small, and optimized for quick look-ups. It is useful for establishing a connection between the relational
      tables, searching large tables, and fast retrieval of data from a database.
2. What are the ACID properties of Relational Databases?
    - Atomicity
    - Consistency
    - Isolation
    - Durability
3. What is Isolation in ACID?
    - Isolation makes sure that one transaction does not know about the updates done by another transaction occuring at
      the same time.
    - Isolation aims to prevent all types of Read Phenomena.
4. What is Read Phenomena?
    - Read phenomena refers to three different read phenomena when a transaction retrieves data that another transaction
      might have updated.
        1. Dirty Read
        2. Non-Repeatable Read
        3. Phantom Read
5. Dirty read vs Non-Repeatable read vs Phantom Read?
    - Dirty Read :- Accessing an updated value that has not been committed is considered a dirty read because it is
      possible for that value to be rolled back to its previous value. If you read a value that is later rolled back,
      you will have read an invalid value.
    - Non-repeatable Read :- It occurs when transaction A retrieves a row, transaction B subsequently updates the row,
      and transaction A later retrieves the same row again. Transaction A retrieves the same row twice but sees
      different data.
    - Phantom Read :- It occurs when a transaction retrieves a set of rows twice and new rows are inserted into or
      removed from that set by another transaction that is committed in between.
    - Therefore, in the case of dirty read we read data that has not been committed yet. Whereas, in non-repeatable read
      we read two different committed values.
6. What is Consistency in ACID?
    - Consistency ensures that the data in the database remains consistent even in case of power failures.
    - Use of Foreign Keys(makes sure if data in other table changes then it is reflected in this table as well),
      Atomicity and Isolation ensures consistency because even if a power failure occurs the changes aren't committed
      and thus when you restart the system the state will not have been updated. Therefore, CONSISTENT.
7. Why can't we use aggregate functions(like COUNT()) with WHERE clause?
   - WHERE filters data before any aggregation happens. Aggregate functions need the entire dataset to calculate the summary value. Including them in WHERE would disrupt this order.
   - We can use HAVING instead of the WHERE clause
   - Also, An aggregate function can be used in a WHERE clause only if that clause is part of a subquery of a HAVING clause and the column name specified in the expression is a correlated reference to a group
     - For example,
     - ```sql
       SELECT * FROM orders
       WHERE order_id IN (
          SELECT order_id FROM orders
             GROUP BY customer_id
          HAVING COUNT(*) > 5
       );
       ```
