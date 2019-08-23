DECLARE
    l_counter   NUMBER := 0;
    l_sum       NUMBER := 0;
BEGIN
    LOOP
        l_sum := l_sum + l_counter;
        l_counter := l_counter + 1;
        dbms_output.put_line(l_sum);
        IF l_sum > 2 THEN
            GOTO out_of_loop;
        END IF;
    END LOOP;

    << out_of_loop >> NULL;
END;

-- RESULT

/*
	0
	1
	3
*/