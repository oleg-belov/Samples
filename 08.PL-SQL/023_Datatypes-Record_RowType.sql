DECLARE
    l_dept_rec departments%rowtype;
BEGIN
    l_dept_rec.dept_id := 10;
    dbms_output.put_line('Department id is ' || l_dept_rec.dept_id);
END;


-- RESULT

/*
	Department id is 10
*/