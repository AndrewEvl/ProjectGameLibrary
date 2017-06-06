CREATE DATABASE IF NOT EXISTS game_library ;
USE game_library;
# DROP DATABASE game_library;

CREATE TABLE genres (id INT AUTO_INCREMENT, genre VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE publishers (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE developers (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE roles_users (id INT AUTO_INCREMENT, role_user VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE platforms (id INT AUTO_INCREMENT, name VARCHAR(50) UNIQUE ,PRIMARY KEY (id));
CREATE TABLE cpu (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE ram (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE hdd (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE video_card (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE users (id INT AUTO_INCREMENT, name VARCHAR(30), nickName VARCHAR(30),city VARCHAR(50),country VARCHAR(50),
                    birthday DATE, password VARCHAR(30), mail VARCHAR(50),roles_users_id INT,
  PRIMARY KEY (id), FOREIGN KEY (roles_users_id) REFERENCES roles_users(id));

CREATE TABLE forum_theme (id INT AUTO_INCREMENT, theme VARCHAR(100), text VARCHAR(10000), PRIMARY KEY (id));
CREATE TABLE comments_forum (id INT AUTO_INCREMENT, name VARCHAR(100),forum_theme_id INT, user_id INT, PRIMARY KEY (id, user_id,forum_theme_id), FOREIGN KEY (user_id) REFERENCES users(id), FOREIGN KEY (forum_theme_id) REFERENCES forum_theme(id));
CREATE TABLE system_requirements (id INT AUTO_INCREMENT,cpu_id INT, ram_id INT ,
                                  hdd_id INT , video_card_id INT ,PRIMARY KEY (id,cpu_id, ram_id, hdd_id, video_card_id),
  FOREIGN KEY (cpu_id) REFERENCES cpu(id),FOREIGN KEY (ram_id) REFERENCES ram(id), FOREIGN KEY (hdd_id) REFERENCES hdd(id), FOREIGN KEY (video_card_id) REFERENCES video_card(id));
CREATE TABLE platforms_system (id INT AUTO_INCREMENT, platforms_id INT, system_settings_id INT, PRIMARY KEY (id,platforms_id,system_settings_id),
  FOREIGN KEY (platforms_id) REFERENCES platforms(id), FOREIGN KEY (system_settings_id) REFERENCES system_requirements(id));
CREATE TABLE games (id INT AUTO_INCREMENT, name VARCHAR (100), release_day DATE,
                    genres_id INT, publishers_id INT, developers_id INT,
  PRIMARY KEY (id), FOREIGN KEY (genres_id) REFERENCES genres(id),
  FOREIGN KEY  (publishers_id) REFERENCES publishers(id),
  FOREIGN KEY (developers_id) REFERENCES developers(id));
CREATE TABLE news (id INT AUTO_INCREMENT, name VARCHAR(100),games_id INT, date DATE, text VARCHAR(20000), PRIMARY KEY (id), FOREIGN KEY (games_id) REFERENCES games(id));
CREATE TABLE comments_news (id INT AUTO_INCREMENT,users_id INT,news_id INT, review VARCHAR(30), PRIMARY KEY (id,users_id,news_id),FOREIGN KEY (users_id) REFERENCES users(id), FOREIGN KEY (news_id) REFERENCES news(id));
CREATE TABLE reviews_game (id INT AUTO_INCREMENT,users_id INT,games_id INT, review VARCHAR(1000), PRIMARY KEY (id,users_id,games_id),FOREIGN KEY (users_id) REFERENCES users(id), FOREIGN KEY (games_id) REFERENCES games(id));
CREATE TABLE game_platforms_system (id INT AUTO_INCREMENT, games_id INT, platform_system_id INT, PRIMARY KEY (id, games_id,platform_system_id), FOREIGN KEY (games_id) REFERENCES games(id), FOREIGN KEY (platform_system_id) REFERENCES platforms_system(id));

INSERT INTO genres (genre) VALUES ('FPS');
INSERT INTO publishers (name) VALUE ('Sierra Studios');
INSERT INTO developers (name) VALUE ('Valve Corporation');
INSERT INTO platforms (name) VALUE ('PC');
INSERT INTO cpu (name) VALUE ('Процессор 133 МГц');
INSERT INTO ram (name) VALUE ('24 МБ');
INSERT INTO video_card (name) VALUE ('VGA (640 x 480)');
INSERT INTO roles_users (role_user) VALUE ('Admin');
INSERT INTO users (name, nickName,city,country, password, mail, roles_users_id) VALUE ('Andrew','Lino','Minsk','Belarus',1,'mail@gmail.com',1);
INSERT INTO forum_theme (theme, text) VALUE ('Как написать проект?','Как успеть написать проект?');
INSERT INTO comments_forum (name, forum_theme_id, user_id) VALUE ('никак))',1,1);
INSERT INTO hdd (name) VALUE ('1.5 Гб');
INSERT INTO system_requirements (cpu_id, ram_id, hdd_id, video_card_id) VALUE (1,1,1,1);
INSERT INTO platforms_system (platforms_id, system_settings_id) VALUE (1,1);
INSERT INTO games (name, genres_id, publishers_id, developers_id) VALUE ('Half-Life',1,1,1);
INSERT INTO news (name, text) VALUE ('Анонс Half-Life 3', 'Анонсировали выход Half-Life 3');
INSERT INTO comments_news (users_id, news_id, review) VALUE (1,1,'Круто!');
INSERT INTO reviews_game (users_id, games_id, review) VALUE (1,1,'Легендарная вещь!');
INSERT INTO game_platforms_system (games_id, platform_system_id) VALUE (1,1);
