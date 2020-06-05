CREATE TABLE CUSTOMER( 
  ID integer NOT NULL,
  NAME varchar2(50),
  CPF varchar2(11),
  GENDER varchar2(1),
  EMAIL varchar2(50)
);  

CREATE SEQUENCE CUSTOMER_SEQ START WITH 1;
ALTER SEQUENCE CUSTOMER_SEQ NOCACHE;
ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY (ID);
