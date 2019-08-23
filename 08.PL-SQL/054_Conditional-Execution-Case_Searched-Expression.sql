DECLARE
    l_ticket_priority   VARCHAR2(8) := 'MEDIUM';
    l_support_tier      NUMBER;
BEGIN
    l_support_tier :=
        CASE
            WHEN l_ticket_priority = 'HIGH' THEN
                1
            WHEN l_ticket_priority = 'MEDIUM' THEN
                2
            WHEN l_ticket_priority = 'LOW' THEN
                3
            ELSE 0
        END;

    dbms_output.put_line(l_support_tier);
END;

-- RESULT

/*
    2
*/