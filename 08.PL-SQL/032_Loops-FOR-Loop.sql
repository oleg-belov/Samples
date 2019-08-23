BEGIN
    FOR l_counter IN 1..3 LOOP
        dbms_output.put_line(l_counter);
    END LOOP;
END;

-- RESULT

/*
	0
	1
	3
*/