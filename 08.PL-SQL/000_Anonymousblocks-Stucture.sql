DECLARE
    -- Declare local variable
    l_counter NUMBER;
    l_var NUMBER;
BEGIN
    l_counter := 1; -- l_var assigned value
    l_var := 1;

    dbms_output.put_line('l_counter is '||l_counter);
    /* dbms_output.put_line sends output messages
    to the console*/

EXCEPTION
    WHEN OTHERS THEN
        null;
END;

-- RESULT

/*
	l_counter is 1
*/