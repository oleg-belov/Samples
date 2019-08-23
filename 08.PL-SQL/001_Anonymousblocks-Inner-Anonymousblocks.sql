DECLARE
  l_var NUMBER; 
  l_outer NUMBER;
BEGIN
  l_outer := 1; 
  l_var   := 1;
   DECLARE    
      l_var NUMBER;
      l_inner NUMBER;
   BEGIN
      l_inner := 2;
      l_var := 2;
      dbms_output.put_line('l_var in the inner block is '||l_var);
   END;
   dbms_output.put_line('l_var in the outer block is '||l_var);
EXCEPTION
   WHEN OTHERS THEN
    -- Do something
    null;
END;

-- RESULT

/*
	l_var in the inner block is 2
	l_var in the outer block is 1
*/