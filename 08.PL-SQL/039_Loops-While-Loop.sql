DECLARE
    l_evaluation INTEGER := 1;
BEGIN
    WHILE l_evaluation < 5 LOOP
        l_evaluation := dbms_random.value(1, 10);
        dbms_output.put_line(l_evaluation);
    END LOOP;
END;


-- RESULT

/*
    9
*/