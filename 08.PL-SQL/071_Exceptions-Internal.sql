DECLARE
    l_name departments.dept_name%TYPE;
BEGIN
    SELECT
        dept_name
    INTO l_name
    FROM
        departments
    WHERE
        dept_id = 10;

EXCEPTION  -- Add 1
    WHEN OTHERS THEN
        dbms_output.put_line('System error. Please contact Application Support');
        dbms_output.put_line('SQLCODE: ' || sqlcode);
        dbms_output.put_line('SQLERRM: ' || sqlerrm);
END;

-- RESULT

/*
    System error. Please contact Application Support
    SQLCODE: 100
    SQLERRM: ORA-01403: no data found
*/