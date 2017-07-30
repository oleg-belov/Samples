DROP TABLE IF EXISTS book_author CASCADE;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS author CASCADE;
DROP TABLE IF EXISTS book_category CASCADE;

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
	author_date_of_birth date 
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.author
  OWNER TO blibrary;
  
------ Insert into author table --------
INSERT INTO author (author_name, author_date_of_birth)
VALUES ('Герберт Шилдт', TO_DATE('23/2/1951', 'DD/MM/YYYY'));

INSERT INTO author (author_name)
VALUES ('Кей С. Хорстманн');

INSERT INTO author (author_name)
VALUES ('Гари Корнелл');

------ Cteate table for book --------
CREATE TABLE book (
	book_id SERIAL PRIMARY KEY,
	book_name varchar(100) NOT NULL,
	book_descr text,
	book_pages int ,
	book_date int ,
	book_language varchar(10),
	category_id int NOT NULL,
	book_tupe varchar(5)	
)

WITH (
  OIDS=FALSE
);
ALTER TABLE public.book
  OWNER TO blibrary;

------ Add foreign key constraint for book table references  book_category--------
ALTER TABLE book ADD CONSTRAINT book_category_id_fk FOREIGN KEY (category_id) REFERENCES book_category (category_id);

------ Insert into book table --------
INSERT INTO book (book_name, book_descr, book_pages, book_date, book_language, category_id,
	book_tupe)
	
VALUES ('Java 8. Полное руководство', 
'Книга Java 8. Полное руководство является исчерпывающим руководством по программированию на языке Java.  В этом справочном пособии, полностью обновленном с учетом последней версии Java SE 8, поясняется, как разрабатывать, компилировать, отлаживать и выполнять программы на языке программирования Java. Книга написана Гербертом Шилдтом, автором популярных во всем мире книг по языкам программирования, таким образом, чтобы охватить все языковые средства Java, включая синтаксис, ключевые слова, основные принципы объектно-ориентированного программирования, значительную часть прикладного программного интерфейса Java API, библиотеки классов, аплеты и сервлеты, компоненты JavaBeans, библиотеки AWT и Swing, а также продемонстрировать их применение на простых и наглядных примерах. В книге «Java 8. Полное руководство» не обойдены вниманием и новые средства, появившиеся в версии Java SE 8, в том числе лямбда-выражения, стандартные интерфейсные методы, библиотека потоков ввода-вывода, а также технология JavaFX.', 
1377, 2015, 'русский', 1, 'pdf');

INSERT INTO book (book_name, book_descr, book_pages, book_date, book_language, category_id,
	book_tupe)
	
VALUES ('Java. Библиотека профессионала. Том 1. Основы', 
'Эта книга давно уже признана авторитетным, исчерпывающим руководством и практическим справочным пособием для опытных программистов, стремящихся писать на Java надежный код для реальных приложений. Настоящее, десятое издание книги, было полностью обновлено с учетом версии Java SE 8. В нем отражены самые долгожданные за последние годы нововведения в языке Java. Оно было переписано и реорганизовано с целью проиллюстрировать на сотнях тщательно подобранных, простых для понимания и удобных для практического применения примеров новые языковые средства Java SE 8, идиомы и нормы передовой практики программирования на Java.
Эта книга написана К.Хорстманном для серьезных программистов, которым приходится решать практические задачи. Она поможет им достичь глубокого понимания языка Java и его библиотеки. В первом томе настоящего двухтомного издания основное внимание уделяется основным понятиям языка Java и принципам современного программирования пользовательского интерфейса. В этом томе рассматриваются самые разные вопросы: от принципов объектно-ориентированного программирования до обобщений, коллекций, лямбда-выражений, разработки графического интерфейса средствами библиотеки Swing, а также новейшие методики параллельного и функционального программирования.', 
855,2014, 'русский', 1, 'pdf');

INSERT INTO book (book_name, book_descr, book_pages, book_date, book_language, category_id,
	book_tupe)
	
VALUES ('Java. Библиотека профессионала. Том 2. Расширенные средства программирования', 
'Это полностью обновленное для версии Java SE 7 издание представляет собой солидное справочное руководство по языку программирования Java для тех, кто разрабатывает настоящие проекты на платформе Java. 
В этом надежном и полезном практическом руководстве описаны расширенные языковые средства, библиотеки и прикладные интерфейсы, проиллюстрированные тщательно подобранными и проверенными примерами из практики программирования на Java. Приведенные примеры просты для понимания, практически полезны и служат неплохой отправной точкой для написания собственного кода. 
Из второго тома книги вы узнаете о новых развитых функциональных возможностях, внедренных в версии Java SE 7, в том числе о новом прикладном интерфейсе API для файлового ввода-вывода и дополнительных возможностях разработки графических пользовательских интерфейсов. Исходный код всех приведенных примеров обновлен с учетом нововведений в версии Java SE 7, а их полное описание изящно вплетено в общую канву подробных пояснений расширенных средств программирования на Java. ', 
993, 2014, 'русский', 1, 'pdf');

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

------ Insert into book_author table --------
INSERT INTO book_author (book_id, author_id)
VALUES (1, 1);

INSERT INTO book_author (book_id, author_id)
VALUES (2, 2);

INSERT INTO book_author (book_id, author_id)
VALUES (2, 3);

INSERT INTO book_author (book_id, author_id)
VALUES (3, 2);

INSERT INTO book_author (book_id, author_id)
VALUES (3, 3);
