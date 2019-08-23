DECLARE
    l_dept_count NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO l_dept_count
    FROM
        departments;

    FOR l_counter IN 1..l_dept_count LOOP dbms_output.put_line(l_counter);
    END LOOP;
END;

-- RESULT

/*
	1
	2
*/