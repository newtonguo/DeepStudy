create table if not exists config_info (
  id int  PRIMARY KEY,
  application VARCHAR (20),
  `profile` VARCHAR (20),

  lable VARCHAR(40) NOT NULL,
  `key` VARCHAR(40) NOT NULL,
  `value` VARCHAR(255) NOT NULL
);

