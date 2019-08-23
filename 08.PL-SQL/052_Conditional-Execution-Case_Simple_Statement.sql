DECLARE
    l_ticket_priority   VARCHAR2(8) := 'MEDIUM';
    l_support_tier      NUMBER;
BEGIN
    CASE l_ticket_priority
        WHEN 'HIGH' THEN
            l_support_tier := 1;
        WHEN 'MEDIUM' THEN
            l_support_tier := 2;
        WHEN 'LOW' THEN
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