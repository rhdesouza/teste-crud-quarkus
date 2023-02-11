CREATE TABLE IF NOT EXISTS `book`(
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(120) NOT NULL,
  `launch_year` int NOT NULL,
  `pages` int NOT NULL,
  `author` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);