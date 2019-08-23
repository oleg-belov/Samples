DECLARE
    invalid_quantity EXCEPTION;
    l_order_qty NUMBER := -2;
BEGIN
    DECLARE
        invalid_quantity EXCEPTION; -- Add 1   
    BEGIN
        IF l_order_qty < 0 THEN
            RAISE invalid_quantity;
        END IF; --Add2
    EXCEPTION
        WHEN invalid_quantity THEN
            dbms_output.put_line('Inside Inner invalid_quantity handler');
            RAISE; -- Add3
    END;

    dbms_output.put_line('Resuming Outer Block');
EXCEPTION
    WHEN invalid_quantity THEN
        dbms_output.put_line('Inside outer invalid_quantity handler');
    WHEN OTHERS THEN
        dbms_output.put_line('Inside outer When Others');
END;

-- RESULT

/*
    Inside Inner invalid_quantity handler
    Inside outer When Others
*/