DECLARE
    CURSOR get_emp_info (
        p_dept_id employee.emp_dept_id%TYPE
    ) IS
    SELECT
        emp_name
    FROM
        employee
    WHERE
        emp_dept_id = p_dept_id;

BEGIN
    << dept_loop >> FOR get_dept_info_var IN (
        SELECT
            dept_id
        FROM
            departments
    ) LOOP
        dbms_output.put_line('Dept id : ' || get_dept_info_var.dept_id);
        << emp_loop >> FOR get_emp_info_var IN get_emp_info(get_dept_info_var.dept_id) LOOP dbms_output.put_line('Emp Name: ' || get_emp_info_var
        .emp_name);
        END LOOP emp_loop;

    END LOOP dept_loop;
END;

-- RESULT

/*
    Dept id : 1
    Emp Name: Tom
    Emp Name: John
    Dept id : 2
    Emp Name: Tim
    Emp Name: Jack
*/