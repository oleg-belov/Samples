DECLARE
    l_tsmp_begin   TIMESTAMP(2) WITH TIME ZONE := to_timestamp_tz('02-NOV-2013 10:00:00.00 PST PDT', 'DD-MON-RRRR HH24:MI:SS.FF TZR TZD'
    );
    l_tsmp_end     TIMESTAMP(2) WITH TIME ZONE := to_timestamp_tz('03-NOV-2013 10:00:00.00 PST PST', 'DD-MON-RRRR HH24:MI:SS.FF TZR TZD'
    );
    l_int_ym       INTERVAL YEAR ( 3 ) TO MONTH;
    l_int_ds       INTERVAL DAY ( 2 ) TO SECOND ( 2 );
BEGIN
    l_int_ds := l_tsmp_end - l_tsmp_begin;
    dbms_output.put_line('interval ' || l_int_ds);	-- interval_day +01 01:00:00.00
END;

-- RESULT

/*
	interval +01 01:00:00.00
*/