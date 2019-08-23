CREATE TABLE departments (
    dept_id     NUMBER NOT NULL PRIMARY KEY,
    dept_name   VARCHAR2(60)
);

INSERT INTO departments (
    dept_id,
    dept_name
) VALUES (
    1,
    'sales'
);

INSERT INTO departments (
    dept_id,
    dept_name
) VALUES (
    2,
    'it'
);

COMMIT;