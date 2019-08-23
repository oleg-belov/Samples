DECLARE
    l_num PLS_INTEGER;
    too_big EXCEPTION;
    PRAGMA exception_init ( too_big, -1426 );
BEGIN
    l_num := 2147483648;
EXCEPTION
    WHEN too_big THEN
        dbms_output.put_line('SQLCODE: ' || sqlcode);
        dbms_output.put_line('SQLERRM: ' || sqlerrm);
END;

-- RESULT

/*
    SSQLCODE: -1426
    SQLERRM: ORA-01426: numeric overflow
*/