# MySQL
## データベース作成
~~~mysql
CREATE DATABASE myapp
DEFAULT CHARACTER SET utf8;
~~~
## データベース削除
~~~mysql
DROP DATABASE IF EXISTS myapp;
~~~
## テーブル作成
~~~mysql
CREATE TABLE members(
id INT PRIMARY KEY AUTO_INCREMENt,
name VARCHAR(30),
depart VARCHAR(20) DEFAULT '無所属',
age INt,
updated DATE
);
~~~
## テーブル削除
~~~mysql
DROP TABLE IF EXISTS members;
~~~
## Link
[wiki MySQL](https://ja.wikipedia.org/wiki/MySQL).
[日本MySQLユーザ会](http://www.mysql.gr.jp/).
[MySQL Reference Manuals](https://dev.mysql.com/doc/).
## Other
[Defines all Languages known to GitHub.](https://github.com/github/linguist/blob/master/lib/linguist/languages.yml).
