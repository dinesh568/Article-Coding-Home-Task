It support JAVA version 8 and MySQL version above 5.0

Create Scheme named 'article'

Create Table name 'article'

CREATE TABLE `article` (
  `slug` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `body` varchar(45) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `tags` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Build Project - clean install

Server Port : 8080
Start the application : http://localhost:8080/