CREATE TABLE user(
   user_id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(30) NOT NULL,
   password VARCHAR(30) NOT NULL,
   is_manager TINYINT NOT NULL DEFAULT 0,
   is_baned TINYINT NOT NULL DEFAULT 0,
   PRIMARY KEY (user_id)
);

CREATE TABLE post(
   post_id INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(250) NOT NULL,
   time  TIMESTAMP NOT NULL DEFAULT current_timestamp,
   content TEXT NOT NULL,
   link  VARCHAR(300) NOT NULL,
   user_id INT NOT NULL,
   type VARCHAR(10) NOT NULL,
   PRIMARY KEY (post_id)
);

CREATE TABLE comment(
   user_id INT NOT NULL,
   post_id INT NOT NULL,
   time TIMESTAMP NOT NULL DEFAULT current_timestamp,
   content TEXT NOT NULL,
   PRIMARY KEY (user_id, post_id, time)
);

CREATE TABLE image(
   post_id INT NOT NULL,
   url VARCHAR(250) NOT NULL
);
