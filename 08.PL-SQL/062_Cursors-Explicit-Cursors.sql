DECLARE
    CURSOR cur_get_departments (
        p_rows NUMBER DEFAULT 5
    ) IS
    SELECT
        dept_id,
        dept_name
    FROM
        departments
    WHERE
        ROWNUM <= p_rows;

    cur_get_departments_var cur_get_departments%rowtype;
BEGIN
    OPEN cur_get_departments(2);
    LOOP
        FETCH cur_get_departments INTO cur_get_departments_var;
        EXIT WHEN cur_get_departments%notfound;
        dbms_output.put_line('Dept Id: ' || cur_get_departments_var.dept_id);
        dbms_output.put_line('RowCount: ' || cur_get_departments%rowcount);
    END LOOP;

    IF cur_get_departments%isopen THEN
        CLOSE cur_get_departments;
    END IF;
END;

-- RESULT

/*
    Dept Id: 1
    RowCount: 1
    Dept Id: 2
    RowCount: 2
*/