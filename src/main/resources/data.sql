-- Use to generate master data
USE test;
INSERT INTO account (account_id, account_user, account_password, account_startdate) VALUES (1,'tuankiet','$2a$10$xmfbKnZDsCI.f6ASDE29y.IOV1tARo8gKVE3d7w7j8TK2R991J4RO',SYSDATE());
INSERT INTO account (account_id, account_user, account_password, account_startdate) VALUES (2,'leminh','$2a$10$xmfbKnZDsCI.f6ASDE29y.IOV1tARo8gKVE3d7w7j8TK2R991J4RO',SYSDATE());
INSERT INTO account (account_id, account_user, account_password, account_startdate) VALUES (3,'lean','$2a$10$xmfbKnZDsCI.f6ASDE29y.IOV1tARo8gKVE3d7w7j8TK2R991J4RO',SYSDATE());
INSERT INTO account (account_id, account_user, account_password, account_startdate) VALUES (4,'myhuyen','$2a$10$xmfbKnZDsCI.f6ASDE29y.IOV1tARo8gKVE3d7w7j8TK2R991J4RO',SYSDATE());
INSERT INTO account (account_id, account_user, account_password, account_startdate) VALUES (5,'jackson','$2a$10$xmfbKnZDsCI.f6ASDE29y.IOV1tARo8gKVE3d7w7j8TK2R991J4RO',SYSDATE());

INSERT INTO comment (comment_id, comment_content,account_id) VALUES (1,'It so bad',1);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (2,'it normally',1);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (3,'good job A',1);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (4,'it is greate bro',3);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (5,'Cool',4);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (6,'thanks for your app',4);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (7,'too bad',5);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (8,'not good',3);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (9,'next time to use',2);
INSERT INTO comment (comment_id, comment_content,account_id) VALUES (10,'so cool',2);

INSERT INTO role (role_id,role_level,role_descr) VALUES (1,'ROLE_ADMIN','Admin user');
INSERT INTO role (role_id,role_level,role_descr) VALUES (2,'ROLE_MOD','Mod user');
INSERT INTO role (role_id,role_level,role_descr) VALUES (3,'ROLE_USER','Normal user');

INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(1,1,1);
INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(2,2,1);
INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(3,3,1);

INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(4,2,2);
INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(5,3,2);

INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(6,2,3);
INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(7,3,3);

INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(8,3,4);

INSERT INTO role_linked(role_linked_id,role_id,account_id) VALUES(9,3,5);