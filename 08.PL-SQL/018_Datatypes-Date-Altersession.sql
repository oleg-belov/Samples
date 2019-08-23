--Currently the time zone for the database and the session are both Pacific
SELECT
    current_timestamp,
    systimestamp
FROM
    dual;

--Set Session time zone to Eastern

ALTER SESSION SET time_zone = 'EST';

SELECT
    current_timestamp,
    systimestamp
FROM
    dual;