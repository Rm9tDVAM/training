# MySQL
## mysql --version
mysql  Ver 15.1 Distrib 10.4.11-MariaDB, for Win64 (AMD64)
> XAMPPのMySQLはMariaDB 10.4.11
## [CREATE DATABASE.](https://mariadb.com/docs/reference/es/sql-statements/CREATE_DATABASE/)
~~~mysql
CREATE [OR REPLACE] {DATABASE | SCHEMA} [IF NOT EXISTS] db_name
    [create_specification] ...

create_specification:
    [DEFAULT] CHARACTER SET [=] charset_name
  | [DEFAULT] COLLATE [=] collation_name
  | COMMENT [=] 'comment'
~~~
~~~mysql
CREATE DATABASE db_name
DEFAULT CHARACTER SET utf8mb4;
~~~
## [DROP DATABASE.](https://mariadb.com/docs/reference/es/sql-statements/DROP_DATABASE/)
~~~mysql
DROP DATABASE IF EXISTS db_name;
~~~
## [CREATE TABLE.](https://mariadb.com/docs/reference/es/sql-statements/CREATE_TABLE/)
~~~musql
CREATE [OR REPLACE] [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    (create_definition,...) [table_options    ]... [partition_options]
CREATE [OR REPLACE] [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    [(create_definition,...)] [table_options   ]... [partition_options]
    select_statement
CREATE [OR REPLACE] [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
   { LIKE old_table_name | (LIKE old_table_name) }


select_statement:
    [IGNORE | REPLACE] [AS] SELECT ...   (Some legal select statement)
~~~
~~~mysql
CREATE TABLE tbl_name(
id INT PRIMARY KEY AUTO_INCREMENt,
name VARCHAR(30),
depart VARCHAR(20) DEFAULT '無所属',
age INt,
updated DATE
);
~~~
- id INT PRIMARY KEY AUTO_INCREMENt
プライマリキーのINT idの値をTableが新しく作られるたびに自動でインクリメントする
- [VARCHAR.](https://mariadb.com/docs/reference/es/data-types/VARCHAR/)
## [DROP TABLE.](https://mariadb.com/docs/reference/es/sql-statements/DROP_TABLE/)
~~~mysql
DROP [TEMPORARY] TABLE [IF EXISTS] [/*COMMENT TO SAVE*/]
    tbl_name [, tbl_name] ...
    [WAIT n|NOWAIT]
    [RESTRICT | CASCADE]
~~~
~~~mysql
DROP TABLE IF EXISTS members;
~~~
## Link
[wiki MySQL](https://ja.wikipedia.org/wiki/MySQL).  
[wiki MariaDB](https://ja.wikipedia.org/wiki/MariaDB).  
[MariaDB Reference](https://mariadb.com/docs/reference/).
## Other
[Defines all Languages known to GitHub](https://github.com/github/linguist/blob/master/lib/linguist/languages.yml).
