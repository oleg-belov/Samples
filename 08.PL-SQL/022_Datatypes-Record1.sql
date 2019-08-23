DECLARE
    TYPE emp_rec IS RECORD (
        emp_name   VARCHAR2(60),
        dept       departments.dept_id%TYPE,
        loc        VARCHAR2(10) DEFAULT 'CA'
    );
    l_emprec emp_rec;
BEGIN
    l_emprec.emp_name := 'John';
    l_emprec.dept := 10;
    dbms_output.put_line('Employee Name is ' || l_emprec.emp_name);
    dbms_output.put_line('Employee Location is ' || l_emprec.loc);
END;

-- RESULT

/*
	Employee Name is John
    Employee Location is CA
*/