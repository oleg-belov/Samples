BEGIN
    FOR l_counter IN 1..4 LOOP
        IF l_counter = 3 THEN
            CONTINUE;
        END IF;
        dbms_output.put_line(l_counter);
    END LOOP;
END;

-- RESULT

/*
	1
    2
    4
*/