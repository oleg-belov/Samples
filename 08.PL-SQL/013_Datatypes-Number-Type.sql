DECLARE
  l_num NUMBER(5,2)  NOT NULL DEFAULT 2.21;
  l_num_vartype  l_num%TYPE := 1.123;  --inherits data type and constraint 
  l_num_coltype  departments.dept_id%TYPE; -- inherit only data type
BEGIN 
  DBMS_OUTPUT.PUT_LINE('l_num_vartype assigned value 1.123. Final value '||l_num_vartype);
  DBMS_OUTPUT.PUT_LINE('l_num_coltype not assigned any value. Final value'||l_num_coltype);
END;

-- RESULT

/*
	l_num_vartype assigned value 1.123. Final value 1.12
	l_num_coltype not assigned any value. Final value
*/