DECLARE
    TYPE rc_weak IS REF CURSOR;
    rc_weak_cur      rc_weak;
    l_dept_rowtype   departments%rowtype;
    l_emp_rowtype    employee%rowtype;
BEGIN
    OPEN rc_weak_cur FOR SELECT
                             *
                         FROM
                             departments
                         WHERE
                             dept_id = 1;

    LOOP
        FETCH rc_weak_cur INTO l_dept_rowtype;
        EXIT WHEN rc_weak_cur%notfound;
        dbms_output.put_line(l_dept_rowtype.dept_name);
    END LOOP;

    OPEN rc_weak_cur FOR SELECT
                            *
                        FROM
                            employee
                        WHERE
                            emp_dept_id = 2;

    LOOP
        FETCH rc_weak_cur INTO l_emp_rowtype;
        EXIT WHEN rc_weak_cur%notfound;
        dbms_output.put_line(l_emp_rowtype.emp_id);
    END LOOP;

    CLOSE rc_weak_cur;
END;

-- RESULT

/*
   sales
    50
    60
*/