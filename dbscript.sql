-- runscript from 'E:\Training-Workspace\phoneKitab\dbscript.sql'
drop table contacts if exists;
drop table users if exists;

CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       email VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(500) NOT NULL,
                       created_at DATETIME
);

CREATE TABLE contacts (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          firstname VARCHAR(50) NOT NULL,
                          lastname VARCHAR(50),
                          email VARCHAR(50) NOT NULL UNIQUE,
                          phone VARCHAR(50) NOT NULL UNIQUE,
                          avatar VARCHAR(255),
                          address VARCHAR(255),
                          city VARCHAR(255) DEFAULT 'Ballia',
                          pincode VARCHAR(10),
                          state VARCHAR(50),
                          country VARCHAR(50),
                          created_at DATETIME,
                          user_id INT,
                          CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (id)
);
