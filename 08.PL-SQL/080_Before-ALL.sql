CREATE TABLE agent_sales (
    agent_id          NUMBER PRIMARY KEY,
    agent_sales_amt   NUMBER,
    agent_loc         VARCHAR2(10)
);

INSERT INTO agent_sales (
    agent_id,
    agent_sales_amt,
    agent_loc
) VALUES (
    10,
    100.2,
    'CA'
);

INSERT INTO agent_sales (
    agent_id,
    agent_sales_amt,
    agent_loc
) VALUES (
    20,
    1000,
    'NY'
);

INSERT INTO agent_sales (
    agent_id,
    agent_sales_amt,
    agent_loc
) VALUES (
    30,
    200,
    'CA'
);

COMMIT;