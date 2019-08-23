DECLARE
    l_location             agent_sales.agent_loc%TYPE := 'NY';
    l_total_sales          NUMBER;
    l_previous_year_comm   NUMBER;
    l_new_commission       NUMBER := 0;
    l_ratio                NUMBER;
BEGIN
    l_previous_year_comm := 0;
    FOR agent_sales_var IN (
        SELECT
            *
        FROM
            agent_sales
        WHERE
            agent_loc = l_location
    ) LOOP l_total_sales := l_total_sales + agent_sales_var.agent_sales_amt;
    END LOOP;

    dbms_output.put_line('l_total_sales ' || to_char(l_total_sales));
    IF l_total_sales > 2000 THEN
        l_new_commission := 2000 * 0.10;
    ELSIF l_total_sales <= 2000 THEN
        l_new_commission := 2000 * 0.05;
    END IF;

    l_ratio := l_previous_year_comm / l_new_commission;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Error Stack: ' || sys.dbms_utility.format_error_stack);
        dbms_output.put_line('Error Backtrace: ' || sys.dbms_utility.format_error_backtrace);
END;

-- RESULT

/*
    l_total_sales 
    Error Stack: ORA-01476: divisor is equal to zero
    
    Error Backtrace: ORA-06512: at line 26
*/