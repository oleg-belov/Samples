--This demo shows how to declare interval as well as the difference between timestamp and timestamp with timezone for daylight savings
DECLARE
    l_tsmp          TIMESTAMP(2);
    l_tsmp_tz       TIMESTAMP(2) WITH TIME ZONE;
    l_tsmp_new      TIMESTAMP(2);
    l_tsmp_tz_new   TIMESTAMP(2) WITH TIME ZONE;
    l_int           INTERVAL DAY ( 2 ) TO SECOND ( 2 ) := '7 00:00:00.00'; -- INTERVAL '7' DAY;
BEGIN
    l_tsmp := to_timestamp('02-NOV-2013 10:00:00.00', 'DD-MON-RRRR HH24:MI:SS.FF');
    l_tsmp_tz := to_timestamp_tz('02-NOV-2013 10:00:00.00 PST PDT', 'DD-MON-RRRR HH24:MI:SS.FF TZR TZD');
    l_tsmp_tz := to_timestamp_tz('02-NOV-2013 10:00:00.00 America/Los_Angeles PDT', 'DD-MON-RRRR HH24:MI:SS.FF TZR TZD');
  
  -- Add 7 days
    l_tsmp_new := l_tsmp + l_int;
    l_tsmp_tz_new := l_tsmp_tz + l_int;
    dbms_output.put_line('New Timestamp is ' || to_char(l_tsmp_new, 'DD-MON-RRRR HH24:MI:SS.FF'));
    dbms_output.put_line('New Timestamp with timezone is ' || to_char(l_tsmp_tz_new, 'DD-MON-RRRR HH24:MI:SS.FF TZR TZD'));
END;

-- RESULT

/*
	New Timestamp is 09-NOV-2013 10:00:00.000000000
    New Timestamp with timezone is 09-NOV-2013 09:00:00.000000000 AMERICA/LOS_ANGELES PST
*/