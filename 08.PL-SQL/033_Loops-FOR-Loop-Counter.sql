DECLARE
    l_lower   NUMBER := 2;
    l_upper   NUMBER := 5;
BEGIN
    FOR l_counter IN l_lower..( l_upper / l_lower ) LOOP
        dbms_output.put_line(l_counter);
    END LOOP;
END;

-- RESULT

/*
	2
	3
*/