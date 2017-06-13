
CREATE TABLE IF NOT EXISTS user(
  id bigint not null auto_increment,
  username varchar(64) not null,
  password varchar(64) not null,
  token varchar(64) not null,
  ctime DATETIME DEFAULT CURRENT_TIMESTAMP,
  level int DEFAULT 0,
  PRIMARY KEY(id),
  INDEX(token)
);


#服装类商品中要记录商品的名称，品牌，颜色，大小，适合人群，价格，数量。
create table goods_clothes(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64)  not null,
  pingpai int not null,
  color VARCHAR(32) not null,
  size VARCHAR(32) NOT NULL,
  person VARCHAR(32) NOT NULL DEFAULT 'all',
  price FLOAT NOT NULL ,
  num INT NOT NULL,
  INDEX (name),
  INDEX (price),
  INDEX (person),
  INDEX (num),
  INDEX (color),
  INDEX (size),
  INDEX (name,price,person,num,color,size)
);


#食品类商品记录商品名称，品牌，保质期截止日期，产地，价格，数量。
create table goods_food(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64)  not null,
  pingpai int not null,
  baozhiqi DATETIME NOT NULL ,
  chandi VARCHAR(64) NOT NULL ,
  price FLOAT NOT NULL ,
  num int not NULL ,
  INDEX (name),
  INDEX (price),
  INDEX (chandi),
  INDEX (num),
  INDEX (baozhiqi),
  INDEX (name,price,chandi,num,baozhiqi)
);

#// 销售记录中包括销售时间，产品编号，数量，单价，总价。
CREATE table sell_record(
  id int PRIMARY KEY AUTO_INCREMENT,
  selltime DATETIME NOT NULL ,
  gid int NOT NULL ,
  num INT NOT NULL ,
  price FLOAT NOT NULL ,
  allprice FLOAT not NULL ,
  index (selltime),
  index(gid),
  index(num),
  index(price),
  INDEX (allprice),
  index(selltime,gid,num,price,allprice)
);


#// 进货记录中包括进货时间，产品编号，数量，单价，总价。
CREATE table in_record(
  id int PRIMARY KEY AUTO_INCREMENT,
  intime DATETIME NOT NULL ,
  gid int NOT NULL ,
  num INT NOT NULL ,
  price FLOAT NOT NULL ,
  allprice FLOAT not NULL ,
  index (intime),
  index(gid),
  index(num),
  index(price),
  INDEX (allprice),
  index(intime,gid,num,price,allprice)
);

#下架的产品信息记录记录在下架产品表中（该表处理产品信息还要有下架时间，下架原因）
create table under_sell(
  id int PRIMARY KEY  AUTO_INCREMENT,
  gid  int NOT NULL ,
  undertiem DATETIME NOT NULL DEFAULT current_timestamp,
  reson VARCHAR(128)

);
create table tongzhi(
  id int PRIMARY KEY AUTO_INCREMENT,
  type VARCHAR(32) NOT NULL ,
  content VARCHAR(64) NOT NULL ,
  ctime DATETIME DEFAULT current_timestamp
);

create table pingpai(
  id int PRIMARY KEY  AUTO_INCREMENT,
  name VARCHAR(32) not NULL
)