CREATE DATABASE IF NOT EXISTS game_library ;
USE game_library;
# DROP DATABASE game_library;

CREATE TABLE genres (id INT AUTO_INCREMENT, ganre VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE publishers (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE developers (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE roles_users (id INT AUTO_INCREMENT, role_user VARCHAR(30) UNIQUE , PRIMARY KEY (id));
CREATE TABLE platforms (id INT AUTO_INCREMENT, name VARCHAR(50) UNIQUE ,PRIMARY KEY (id));
CREATE TABLE cpu (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE ram (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE hdd (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE video_card (id INT AUTO_INCREMENT, name VARCHAR(30) UNIQUE,PRIMARY KEY (id));
CREATE TABLE users (id INT AUTO_INCREMENT, name VARCHAR(30), nickName VARCHAR(30),
                    birthday DATE, password VARCHAR(30), mail VARCHAR(50),roles_users_id INT,
  PRIMARY KEY (id), FOREIGN KEY (roles_users_id) REFERENCES roles_users(id));
CREATE TABLE reviews_news (id INT AUTO_INCREMENT,users_id INT, review VARCHAR(30), PRIMARY KEY (id,users_id),FOREIGN KEY (users_id) REFERENCES users(id));
CREATE TABLE reviews_forum (id INT AUTO_INCREMENT, name VARCHAR(100), user_id INT, PRIMARY KEY (id, user_id), FOREIGN KEY (user_id) REFERENCES users(id));
CREATE TABLE forum_theme (id INT AUTO_INCREMENT, theme VARCHAR(100), PRIMARY KEY (id));


CREATE TABLE forum (id INT AUTO_INCREMENT,forum_theme_id INT, reviews_forum_id INT, PRIMARY KEY (id, forum_theme_id, reviews_forum_id), FOREIGN KEY (forum_theme_id) REFERENCES forum_theme(id), FOREIGN KEY (reviews_forum_id) REFERENCES reviews_forum (id));
CREATE TABLE system_settings (id INT AUTO_INCREMENT,cpu_id INT, ram_id INT ,
                              hdd_id INT , video_card_id INT ,PRIMARY KEY (id,cpu_id, ram_id, hdd_id, video_card_id),
  FOREIGN KEY (cpu_id) REFERENCES cpu(id),FOREIGN KEY (ram_id) REFERENCES ram(id), FOREIGN KEY (hdd_id) REFERENCES hdd(id), FOREIGN KEY (video_card_id) REFERENCES video_card(id));
CREATE TABLE platforms_system (id INT AUTO_INCREMENT, platforms_id INT, system_settings_id INT, PRIMARY KEY (id,platforms_id,system_settings_id),
  FOREIGN KEY (platforms_id) REFERENCES platforms(id), FOREIGN KEY (system_settings_id) REFERENCES system_settings(id));
CREATE TABLE games (id INT AUTO_INCREMENT, name VARCHAR (100), release_day DATE,
                    genres_id INT, publishers_id INT, developers_id INT, platforms_system_id INT ,
  PRIMARY KEY (id), FOREIGN KEY (genres_id) REFERENCES genres(id),
  FOREIGN KEY  (publishers_id) REFERENCES publishers(id),
  FOREIGN KEY (developers_id) REFERENCES developers(id),
  FOREIGN KEY (platforms_system_id) REFERENCES platforms_system(id));
CREATE TABLE news (id INT AUTO_INCREMENT, name VARCHAR(100), date DATE, text VARCHAR(20000), PRIMARY KEY (id));
CREATE TABLE news_reviews_news (id INT AUTO_INCREMENT, news_id INT, reviews_news_id INT, PRIMARY KEY (id, news_id, reviews_news_id),
  FOREIGN KEY (news_id) REFERENCES news(id), FOREIGN KEY (reviews_news_id) REFERENCES reviews_news (id));

CREATE TABLE reviews_game (id INT AUTO_INCREMENT,users_id INT,games_id INT, review VARCHAR(1000), PRIMARY KEY (id,users_id,games_id),FOREIGN KEY (users_id) REFERENCES users(id), FOREIGN KEY (games_id) REFERENCES games(id));

CREATE TABLE games_news (id INT AUTO_INCREMENT, games_id INT, news_id INT, PRIMARY KEY (id, games_id,news_id), FOREIGN KEY (games_id) REFERENCES games(id), FOREIGN KEY (news_id) REFERENCES news(id));

INSERT INTO developers (name) VALUE ('Ubisoft')
