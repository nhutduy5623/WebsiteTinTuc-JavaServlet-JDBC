use newservletjee;

create TABLE role(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    createDate TIMESTAMP NULL,
    modifyDate TIMESTAMP NULL,
    createBy VARCHAR(255) NULL,
    modifyBy VARCHAR(255) NULL
);

create TABLE user(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    userName VARCHAR(255) NOT NULL,
    passWord VARCHAR(255) NOT NULL,
    fullName VARCHAR(255) NULL,
    status int default 1,
    roleId bigint NOT NULL,
    createDate TIMESTAMP NULL,
    modifyDate TIMESTAMP NULL,
    createBy VARCHAR(255) NULL,
    modifyBy VARCHAR(255) NULL
);

create TABLE newCategory (
	id bigint NOT NULL PRIMARY KEY auto_increment,
    typeName VARCHAR(255) NOT NULL, 
    description Text NULL,
    createDate TIMESTAMP NULL,
    modifyDate TIMESTAMP NULL,
    createBy VARCHAR(255) NULL,
    modifyBy VARCHAR(255) NULL
);

create TABLE news(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    title VARCHAR(510) NOT NULL,
    description Text NULL,
    thumbnail VARCHAR(255) NULL,
	content Text NULL,
    newCategoryId bigint NOT NULL,
    status int default 1,
    createDate TIMESTAMP NULL,
    modifyDate TIMESTAMP NULL,
    createBy VARCHAR(255) NULL,
    modifyBy VARCHAR(255) NULL
);

create TABLE comment(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    newId bigint NOT NULL,
    content text NOT NULL,
    createBy bigint NOT NULL,
    likeCount int default 0,
    createDate TIMESTAMP NULL,
    status int default 1
);

create TABLE Hastag(
	id bigint NOT NULL PRIMARY KEY auto_increment,
	newsID bigint NULL,
    Hastag VARCHAR(255) NOT NULL
);

alter TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleId) REFERENCES role(id);
alter TABLE news ADD CONSTRAINT fk_News_Category FOREIGN KEY (newCategoryId) REFERENCES newCategory(id);
alter TABLE comment ADD CONSTRAINT fk_cmt_new FOREIGN KEY (newId) REFERENCES news(id);
alter TABLE comment ADD CONSTRAINT fk_cmt_user FOREIGN KEY (createBy) REFERENCES user(id);

alter TABLE comment ADD CONSTRAINT fk_cmt_user FOREIGN KEY (userId) REFERENCES user(id);
alter TABLE comment ADD CONSTRAINT fk_cmt_cmt FOREIGN KEY (cmtId) REFERENCES comment(id);

ALTER TABLE comment DROP FOREIGN KEY fk_cmt_user;

insert into newcategory(code, typeName) values("the-thao","Thể thao");
insert into newcategory(code, typename) values("giai-tri","Giải trí");
insert into newcategory(code, typename) values("the-gioi","Thế giới");
insert into newcategory(code, typename) values("thoi-su","Thời sự");

select * FROM newCategory;
select * FROM news;
select * FROM comment;


use newservletjee;

