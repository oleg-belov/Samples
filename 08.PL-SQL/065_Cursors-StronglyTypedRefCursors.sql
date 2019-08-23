DECLARE
    TYPE rc_dept IS REF CURSOR RETURN departments%rowtype;
    rc_dept_cur_initial   rc_dept;
    rc_dept_cur_final     rc_dept;
    l_dept_rowtype        departments%rowtype;
    l_choice              NUMBER := 1;
    l_lower               NUMBER := 1;
    l_upper               NUMBER := 2;
BEGIN
    IF l_choice = 1 THEN
        OPEN rc_dept_cur_initial FOR SELECT
                                         *
                                     FROM
                                         departments
                                     WHERE
                                         dept_id BETWEEN l_lower AND l_upper;

    ELSE
        OPEN rc_dept_cur_initial FOR SELECT
                                         *
                                     FROM
                                         departments
                                     WHERE
                                         dept_name = 'Accounting';

    END IF;

    rc_dept_cur_final := rc_dept_cur_initial;
    LOOP
        FETCH rc_dept_cur_final INTO l_dept_rowtype;
        EXIT WHEN rc_dept_cur_final%notfound;
        dbms_output.put_line(l_dept_rowtype.dept_id);
    END LOOP;

    CLOSE rc_dept_cur_final;
END;


-- RESULT

/*
    1
    2
*/