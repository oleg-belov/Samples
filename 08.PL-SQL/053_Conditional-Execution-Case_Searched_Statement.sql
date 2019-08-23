DECLARE
    l_ticket_priority   VARCHAR2(8) := 'MEDIUM';
    l_support_tier      NUMBER;
BEGIN
    CASE
        WHEN l_ticket_priority = 'HIGH' THEN
            l_support_tier := 1;
        WHEN l_ticket_priority = 'MEDIUM' THEN
            l_support_tier := 2;
        WHEN l_ticket_priority = 'LOW' THEN
            l_support_tier := 3;
        ELSE
            l_support_tier := 0;
    END CASE;

    dbms_output.put_line(l_support_tier);
END;

-- RESULT

/*
    2
*/