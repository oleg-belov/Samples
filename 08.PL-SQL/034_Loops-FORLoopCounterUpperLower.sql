BEGIN
    FOR l_counter IN 4..4 LOOP
        dbms_output.put_line(l_counter);
    END LOOP;
END;

-- RESULT

/*
	4
*/