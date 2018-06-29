CREATE  TABLE users (
  username VARCHAR(45) NOT NULL primary key,
  password VARCHAR(60) NOT NULL,
  enabled number(1) DEFAULT 1
 );

CREATE TABLE user_roles (
  user_role_id number(11) NOT NULL,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT fk_username FOREIGN KEY (username) 
     REFERENCES users (username)
 );
 
create sequence user_roles_seq
	start with 1
	increment by 1
	maxvalue 99999
    nocycle 

-- example
-- pw : 123456789
INSERT INTO users(username,password,enabled)
VALUES ('admin','$2a$10$US3HfE49gc5k.2nDwr/a9u1uCg6O8olzJZc5yERG.obR7xveqIHE2', 1);


INSERT INTO user_roles (user_role_id, username, role)
VALUES (user_roles_seq.nextval, 'admin', 'ROLE_ADMIN');


		SELECT 	member_id, pw, 
				name, email,
				phonenum, jumin1, 
				jumin2, zipcode, 
				address, birthday,
				sex, grade, enabled
		FROM MEMBER


create table OUTER_TB (
OUTER_NO number(10,0) not null, 
AMOUNT number(10,0) not null, 
COLOR varchar2(100 char) not null, 
CONTENT varchar2(1000 char) not null, 
NAME varchar2(100 char) not null, 
PRICE number(10,0) not null, 
SIZE varchar2(10 char) not null, 
OUTER_TYPE varchar2(100 char) not null, 
primary key (OUTER_NO))
	SELECT  	s.SIZE_TYPE, s.CHEST,	
				s.SLEEVE, s.SHOULDER, 
				s.WHOLE, s.AMOUNT, s.OUTER_NO,
				c.COLOR_NO, c.COLOR_TYPE, c.SIZE_NO
	FROM		OUTER_SIZE s, COLOR c	
	WHERE		s.SIZE_NO = c.SIZE_NO(+)
	AND			s.SIZE_NO = c.SIZE_NO(+)	
	
	
	
	
SELECT 	ORDER_NO, TOTAL_PRICE, HANDLING, MEMBER_ID, ADDRESS, PHONENUM, EMAIL, MESSAGE, ORDER_DATE
FROM ORDER_CHECK	
ORDER BY ORDER_NO DESC;	
	
