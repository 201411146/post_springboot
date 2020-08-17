create table category(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(50) NOT NULL
);

create table board(
   id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   title varchar(50) NOT NULL,
   content text NULL,
   category_id int NOT NULL,
   create_date datetime NOT NULL DEFAULT now(),
   modify_date datetime NOT NULL DEFAULT now(),
   FOREIGN KEY(category_id) REFERENCES `category`(`id`)
);


INSERT INTO category values(1, "A");
INSERT INTO category values(2, "B");
INSERT INTO category values(3, "C");

INSERT INTO board VALUES(1, "basic title1", "basic content1", 1, now(), now());
INSERT INTO board VALUES(2, "basic title2", "basic content2", 2, now(), now());
INSERT INTO board VALUES(3, "basic title3", "basic content3", 3, now(), now());
INSERT INTO board VALUES(4, "basic title4", "basic content4", 1, now(), now());
INSERT INTO board VALUES(5, "basic title5", "basic content1", 1, now(), now());

INSERT INTO board VALUES(6, "test title1", "basic content2", 2, now(), now());
INSERT INTO board VALUES(7, "test title2", "basic content3", 3, now(), now());
INSERT INTO board VALUES(8, "test title3", "basic content4", 1, now(), now());
INSERT INTO board VALUES(9, "test title4", "basic content1", 1, now(), now());
INSERT INTO board VALUES(10, "test title5", "basic content2", 2, now(), now());

INSERT INTO board VALUES(11, "basic title3", "test content1", 3, now(), now());
INSERT INTO board VALUES(12, "basic title4", "test content2", 1, now(), now());
INSERT INTO board VALUES(13, "basic title1", "test content3", 1, now(), now());
INSERT INTO board VALUES(14, "basic title2", "test content4", 2, now(), now());
INSERT INTO board VALUES(15, "basic title3", "test content5", 3, now(), now());

INSERT INTO board VALUES(16, "basic title4", "basic content4", 1, now(), now());
INSERT INTO board VALUES(17, "basic title1", "basic content1", 1, now(), now());
INSERT INTO board VALUES(18, "basic title2", "basic content2", 2, now(), now());
INSERT INTO board VALUES(19, "basic title3", "basic content3", 3, now(), now());
INSERT INTO board VALUES(20, "basic title4", "basic content4", 1, now(), now());




