BEGIN << outer >> FOR l_outer_counter IN 1..3 LOOP dbms_output.put_line('l_outer_counter: ' || l_outer_counter);<<inner>>
        FOR l_inner_counter IN 1..3 LOOP
              CONTINUE outer WHEN l_inner_counter = 2;
              DBMS_OUTPUT.PUT_LINE('  l_inner_counter: '|| l_inner_counter);
        END LOOP inner;
        DBMS_OUTPUT.PUT_LINE('l_outer_counter at end: '||l_outer_counter);
   END LOOP outer;END;


-- RESULT

/*
    l_outer_counter: 1
      l_inner_counter: 1
    l_outer_counter: 2
      l_inner_counter: 1
    l_outer_counter: 3
      l_inner_counter: 1
*/