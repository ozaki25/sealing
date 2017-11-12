CREATE TABLE IF NOT EXISTS player (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  password varchar(255) DEFAULT NULL,
  role_type int(11) DEFAULT NULL,
  user_id varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_fpxwfe7n29rwsbyu5p1wl2mq1 (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS daily_request (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  date datetime DEFAULT NULL,
  status_type int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS request (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  date datetime DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  daily_request_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKa7ephvchaib4ha1q3shiwhlyg (daily_request_id),
  CONSTRAINT FKa7ephvchaib4ha1q3shiwhlyg FOREIGN KEY (daily_request_id) REFERENCES daily_request (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
