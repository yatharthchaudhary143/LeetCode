# Write your MySQL query statement below
SELECT id, COUNT(*) AS num
FROM (
    SELECT requester_id AS id
    FROM RequestAccepted

    UNION ALL

    SELECT accepter_id AS id
    FROM RequestAccepted
) t
GROUP BY id
HAVING COUNT(*) = (
    SELECT MAX(num)
    FROM (
        SELECT id, COUNT(*) AS num
        FROM (
            SELECT requester_id AS id
            FROM RequestAccepted
            UNION ALL
            SELECT accepter_id AS id
            FROM RequestAccepted
        ) x
        GROUP BY id
    ) y
);