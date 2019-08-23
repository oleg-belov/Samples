DECLARE
    l_date               DATE := current_date;
    l_systimestamp       TIMESTAMP WITH TIME ZONE := systimestamp;
    l_currenttimestamp   TIMESTAMP WITH TIME ZONE := current_timestamp;
    l_timestamp          TIMESTAMP := current_timestamp;
BEGIN
    dbms_output.put_line('l_date ' || l_date);
    dbms_output.put_line('l_systimestamp ' || l_systimestamp); -- System timestamp shows the db time in pacific zone with -8 offset
    dbms_output.put_line('l_currenttimestamp ' || l_currenttimestamp); -- Current timestamp shows the session time in eastern zone with -5 offset
    dbms_output.put_line('l_timestamp ' || l_timestamp); -- Current timestamp fetched in timestamp variable loosing the timezone information
END;

-- RESULT

/*
	l_date 15-AUG-19
    l_systimestamp 15-AUG-19 10.41.00.208000 AM +03:00
    l_currenttimestamp 15-AUG-19 02.41.00.208000 AM EST
    l_timestamp 15-AUG-19 02.41.00.208000 AM
*/