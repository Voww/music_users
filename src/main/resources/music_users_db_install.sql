CREATE TABLE address
(
  id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  postcode INT UNSIGNED,
  city VARCHAR(120),
  street VARCHAR(120),
  house INT UNSIGNED,
  flat INT UNSIGNED
);
CREATE TABLE music
(
  id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(80),
  rating INT UNSIGNED NOT NULL DEFAULT 0
);
CREATE TABLE role
(
  id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(30)
);
CREATE TABLE user
(
  id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  login VARCHAR(50),
  password VARCHAR(30),
  email VARCHAR(100),
  reg_date DATE
);
CREATE TABLE user_address
(
  user_id BIGINT UNSIGNED NOT NULL,
  address_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (user_id, address_id)
);
CREATE TABLE user_music
(
  user_id BIGINT UNSIGNED NOT NULL,
  music_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (user_id, music_id)
);
CREATE TABLE user_role
(
  user_id BIGINT UNSIGNED NOT NULL,
  role_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (user_id, role_id)
);
CREATE UNIQUE INDEX id ON address (id);
CREATE UNIQUE INDEX id ON music (id);
CREATE UNIQUE INDEX id ON role (id);
CREATE UNIQUE INDEX id ON user (id);
ALTER TABLE user_address ADD FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE;
ALTER TABLE user_address ADD FOREIGN KEY (address_id) REFERENCES address (id) ON UPDATE CASCADE;
ALTER TABLE user_music ADD FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE;
ALTER TABLE user_music ADD FOREIGN KEY (music_id) REFERENCES music (id) ON UPDATE CASCADE;
ALTER TABLE user_role ADD FOREIGN KEY (user_id) REFERENCES user (id) ON UPDATE CASCADE;
ALTER TABLE user_role ADD FOREIGN KEY (role_id) REFERENCES role (id) ON UPDATE CASCADE;

create trigger insert_rating after insert on user_music for each row
  update music set rating = (select count(*) from user_music where music_id = id);

create trigger update_rating after update on user_music for each row
  update music set rating = (select count(*) from user_music where music_id = id);

create trigger delete_rating after delete on user_music for each row
  update music set rating = (select count(*) from user_music where music_id = id);