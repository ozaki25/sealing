CREATE TABLE IF NOT EXISTS player (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  password varchar(255) DEFAULT NULL,
  role_type int(11) DEFAULT NULL,
  user_id varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;