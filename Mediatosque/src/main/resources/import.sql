INSERT INTO USERS (FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) VALUES ('Fionna', 'Westbury','fwestbury@gmail.com','$2b$05$B6NP/xspwKVFh/ij8O.e8eyjPD0nPvJqZ3LvssJi2anbv.EJc21xC');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) VALUES ('Clémentine', 'Bouillaud','cbouillaud@gmail.com','$2b$05$LxbrkEhVdtLp5mvcyw9Ieug5wQo6MXtulEa1tgD6NxK4OrxtbESU6');
INSERT INTO USERS (FIRST_NAME, LAST_NAME, LOGIN, PASSWORD) VALUES ('David', 'Thibau','dthibau@gmail.com','$2b$05$zbwPFujYu8xCqhikRKR6Fe9Kv5tJnMC1DjCWe687ZLDYu1lUvq03e');

INSERT INTO ITEM (AUTHOR, QUANTITY, RELEASE_DATE, TITLE) VALUES ('Fionna', 3,'2022-10-07','le gras cest la vie');
INSERT INTO ITEM (AUTHOR, QUANTITY, RELEASE_DATE, TITLE) VALUES ('Clémentine', 1,'2022-10-07','vive les gauffres');
INSERT INTO ITEM (AUTHOR, QUANTITY, RELEASE_DATE, TITLE) VALUES ('David', 2,'2022-10-07','cours de java');
INSERT INTO ITEM (AUTHOR, QUANTITY, RELEASE_DATE, TITLE) VALUES ('Agathe', 0,'2022-10-07','lart de lennui');
INSERT INTO ITEM (AUTHOR, QUANTITY, RELEASE_DATE, TITLE) VALUES ('Marine', 4,'2022-10-07','angular pour les nulls');
INSERT INTO ITEM (AUTHOR, QUANTITY, RELEASE_DATE, TITLE) VALUES ('Morgane', 2,'2022-10-07','apprendre le management par les forums');

INSERT INTO DVD (ID, DURATION, TYPE) VALUES (2, 30,'BLUERAY');
INSERT INTO DVD (ID, DURATION, TYPE) VALUES (5, 50,'NORMAL');

INSERT INTO CD (ID, DURATION, NB_TITLE) VALUES (1, 30,4);

INSERT INTO BOOK (ID, ISBN) VALUES (3, '9788175257665');
INSERT INTO BOOK (ID, ISBN) VALUES (4, '7525797881665');
INSERT INTO BOOK (ID, ISBN) VALUES (6, '5257665978817');

INSERT INTO BORROW (BORROW_DATE, RETURN_DATE, USER_ID) VALUES ('2022-10-07', '2022-10-14', 1);
INSERT INTO BORROW (BORROW_DATE, RETURN_DATE, USER_ID) VALUES ('2022-10-07', '2022-10-14', 2);
INSERT INTO BORROW (BORROW_DATE, RETURN_DATE, USER_ID) VALUES ('2022-10-07', '2022-10-14', 3);
INSERT INTO BORROW (BORROW_DATE, RETURN_DATE, USER_ID) VALUES ('2022-10-07', '2022-10-14', 3);

INSERT INTO BORROW_ITEMS (BORROW_ID, ITEMS_ID) VALUES (1,2);
INSERT INTO BORROW_ITEMS (BORROW_ID, ITEMS_ID) VALUES (2,3);
INSERT INTO BORROW_ITEMS (BORROW_ID, ITEMS_ID) VALUES (2,5);
INSERT INTO BORROW_ITEMS (BORROW_ID, ITEMS_ID) VALUES (3,1);
INSERT INTO BORROW_ITEMS (BORROW_ID, ITEMS_ID) VALUES (4,2);
INSERT INTO BORROW_ITEMS (BORROW_ID, ITEMS_ID) VALUES (4,3);