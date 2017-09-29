GRANT CONNECT, TEMPORARY ON DATABASE "spring-blibrary" TO public;
GRANT ALL ON DATABASE "spring-blibrary" TO postgres;
GRANT CONNECT ON DATABASE "spring-blibrary" TO blibrary;

-- Schema: public

DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA public
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public
  IS 'standard public schema';

DROP TABLE IF EXISTS book_author CASCADE;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS author CASCADE;
DROP TABLE IF EXISTS book_category CASCADE;
DROP TABLE IF EXISTS vote CASCADE;

------ Cteate Table for books category --------
CREATE TABLE book_category (
	category_id integer PRIMARY KEY,
	category_name varchar(20) NOT NULL
)

WITH (
  OIDS=FALSE
);

ALTER TABLE public.book_category
  OWNER TO blibrary;
  
------ Insert into book category table --------
INSERT INTO book_category (category_id, category_name)
VALUES (1, 'Core');

INSERT INTO book_category (category_id, category_name)
VALUES (2, 'Generics');

INSERT INTO book_category (category_id, category_name)
VALUES (3, 'Web - services');

INSERT INTO book_category (category_id, category_name)
VALUES (4, 'Servlets, Jsp, Jstl');

INSERT INTO book_category (category_id, category_name)
VALUES (5, 'Jsf');

INSERT INTO book_category (category_id, category_name)
VALUES (6, 'Jaas');

INSERT INTO book_category (category_id, category_name)
VALUES (7, 'Spring framework');

INSERT INTO book_category (category_id, category_name)
VALUES (8, 'Jdbc');

INSERT INTO book_category (category_id, category_name)
VALUES (9, 'Log4j');

INSERT INTO book_category (category_id, category_name)
VALUES (10, 'JUnit');

INSERT INTO book_category (category_id, category_name)
VALUES (11, 'Concurrensy');

INSERT INTO book_category (category_id, category_name)
VALUES (12, 'EJB');

INSERT INTO book_category (category_id, category_name)
VALUES (13, 'Hibernate, Jpa');

INSERT INTO book_category (category_id, category_name)
VALUES (14, 'JavaFx');

INSERT INTO book_category (category_id, category_name)
VALUES (15, 'Swing');

INSERT INTO book_category (category_id, category_name)
VALUES (16, 'Postgre SQL');

INSERT INTO book_category (category_id, category_name)
VALUES (17, 'MySQL');

INSERT INTO book_category (category_id, category_name)
VALUES (18, 'Oracle DB');

INSERT INTO book_category (category_id, category_name)
VALUES (19, 'Microsoft SQL');

INSERT INTO book_category (category_id, category_name)
VALUES (20, 'DB2');

INSERT INTO book_category (category_id, category_name)
VALUES (21, 'HTML');

INSERT INTO book_category (category_id, category_name)
VALUES (22, 'Css');

INSERT INTO book_category (category_id, category_name)
VALUES (23, 'JavaScript');

------ Cteate Table for authors --------
CREATE TABLE author (
	author_id SERIAL PRIMARY KEY,
	author_name varchar(30) NOT NULL,
	author_img bytea,
	author_date_of_birth date 
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.author
  OWNER TO blibrary;

------ Cteate table for book --------
CREATE TABLE book (
	book_id SERIAL PRIMARY KEY,
	book_name varchar(100) NOT NULL,
	book_descr text NOT NULL,
	book_pages int NOT NULL,
	book_img bytea NOT NULL,
	book_date int NOT NULL,
	book_language varchar(10) NOT NULL,
	category_id int NOT NULL,
	book_tupe varchar(5) NOT NULL,
	book_content bytea
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.book
  OWNER TO blibrary;

------ Add foreign key constraint for book table references  book_category --------
ALTER TABLE book ADD CONSTRAINT book_category_id_fk FOREIGN KEY (category_id) REFERENCES book_category (category_id);

------ Cteate table to link authors and books --------
CREATE TABLE book_author (
	book_id int,
	author_id int	
)

WITH (
  OIDS=FALSE
);

ALTER TABLE public.book_author
  OWNER TO blibrary;
  
------ Add foreign key constraint for book_author table references  book --------
------ Add foreign key constraint for book_author table references  author --------
ALTER TABLE book_author ADD CONSTRAINT book_author_book_id_fk FOREIGN KEY (book_id) REFERENCES book (book_id);
ALTER TABLE book_author ADD CONSTRAINT book_author_author_id_fk FOREIGN KEY (author_id) REFERENCES author (author_id);

------ Cteate table for vote --------
CREATE TABLE vote (
	vote_id SERIAL PRIMARY KEY,
	book_id int NOT NULL,
	vote_value int NOT NULL
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.vote
  OWNER TO blibrary;

------ Add foreign key constraint for vote table references  book --------
ALTER TABLE vote ADD CONSTRAINT vote_book_id_fk FOREIGN KEY (book_id) REFERENCES book (book_id);
	
CREATE VIEW book_rating_view AS
   SELECT book_id AS "rating_id", avg(vote_value) AS "rating_value"
   FROM vote
   GROUP BY book_id;
   
