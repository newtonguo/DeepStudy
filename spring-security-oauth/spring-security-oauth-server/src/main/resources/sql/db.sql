
CREATE DATABASE IF NOT EXISTS `test_oauth_user`;
USE `test_oauth_user`;


CREATE TABLE IF NOT EXISTS `user_authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `user_authorities` (`username`, `authority`) VALUES
	('app_u1', 'ROLE_APP'),
	('krishna', 'ROLE_ADMIN'),
	('sudama', 'ROLE_USER');

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
  ('app_u1','b41798e72a4406a1c8fd2372fb71f5d34a87d2c8',1)
	('krishna', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 1),
	('sudama', '904752ad9c4ae4186c4b4897321c517de0618702', 1);