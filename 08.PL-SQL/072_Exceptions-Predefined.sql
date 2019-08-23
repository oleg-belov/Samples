DECLARE
    l_name departments.dept_name%TYPE;
BEGIN
    SELECT
        dept_name
    INTO l_name
    FROM
        departments;

EXCEPTION
    WHEN too_many_rows THEN
        dbms_output.put_line('SQLCODE: ' || sqlcode);
        dbms_output.put_line('SQLERRM: ' || sqlerrm);
END;

-- RESULT

/*
    SQLCODE: -1422
    SQLERRM: ORA-01422: exact fetch returns more than requested number of rows
*/