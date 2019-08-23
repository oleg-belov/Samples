DECLARE
  l_num NUMBER(5,2):= 123.45;
BEGIN 
  DBMS_OUTPUT.PUT_LINE('l_num  Assigned 123.45 Final: '||l_num);
  l_num := 123.789;
  DBMS_OUTPUT.PUT_LINE('l_num Assigned 123.789; Final: '||l_num);
  --l_num := 1234.56;
END;

-- RESULT

/*
	l_num  Assigned 123.45 Final: 123.45
    l_num Assigned 123.789; Final: 123.79
*/
