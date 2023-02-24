# Итоговая аттестация

## Информация о проекте

Необходимо организовать систему учета для питомника, в котором живут
домашние и вьючные животные.

### Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
Решение:

**Создание файла**:

	cat > Pets
	Dogs
    Cats
    Hamsters
	CTRL+D

    cat > PackAnimals
	Horses
    Camels
    Donkeys
	CTRL+D

**Объединить файлы**:

	cat Pets PackAnimals > Animals

**Посмотреть содержимое файлов**:

	cat Animals

**Переименовать файл**:

	mv Animals mansFriends

2. Создать директорию, переместить файл туда.

**Создать директорию**:

	mkdir animals

**Перенос файла**:

	mv mansFriends animals

**Проверка**

    root@taya-VirtualBox:/home/taya# cat mansFriends

    cat: mansFriends: Нет такого файла или каталога

    root@taya-VirtualBox:/home/taya# cat animals/mansFriends
    Dogs
    Cats
    Hamsters
    Horses
    Camels
    Donkeys


3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

*Скачать версию файла конфигурации репозитория*

    wget https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb

*Добавить репозиторий*

    sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb

*Обновление баз пакетов*

    sudo apt update

*Установка MySQL*

    sudo apt install -y mysql-server

*Проверка статуса сервиса*

    systemctl status mysql

*Вывод*

    ● mysql.service - MySQL Community Server
        Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
        Active: active (running) since Thu 2023-02-23 02:34:06 +07; 23s ago
        Docs: man:mysqld(8)
                http://dev.mysql.com/doc/refman/en/using-systemd.html
    Main PID: 57089 (mysqld)
        Status: "Server is operational"
        Tasks: 39 (limit: 2279)
        Memory: 371.8M
            CPU: 3.931s
        CGroup: /system.slice/mysql.service
                └─57089 /usr/sbin/mysqld

    фев 23 02:34:03 alexandra-VirtualBox systemd[1]: Starting MySQL Community Server...
    фев 23 02:34:06 alexandra-VirtualBox systemd[1]: Started MySQL Community Server.

4. Установить и удалить deb-пакет с помощью dpkg.

    wget [https://download.virtualbox.org/virtualbox/7.0.4/virtualbox-7.0_7.0.4-154605~Ubuntu~jammy_amd64.deb] (*ссылка на deb - пакет)

    sudo dpkg -i virtualbox-7.0_7.0.4-154605~Ubuntu~jammy_amd64.deb

    sudo apt -f  install (*для установки зависимых ) 

5. Выложить историю команд в терминале ubuntu

   14  wget https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb
   15  sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb
   16  sudo apt  update
   17  sudo apt install -y mysql-server
   18  systemctl status mysql
   19  wget https://download.virtualbox.org/virtualbox/7.0.4/virtualbox-7.0_7.0.4-154605~Ubuntu~jammy_amd64.deb
   20  sudo dpkg -i virtualbox-7.0_7.0.4-154605~Ubuntu~jammy_amd64.deb
   21  sudo apt -f install
   22  apt list | grep virtualbox
   23  cat > Pets
   24  cat > PackAnimals
   25  cat Pets PackAnimals > Animals
   26  cat Animals
   27  mkdir animals
   28  mv Animals mansFriends
   29  mv mansFriends animals
   30  cat mansFriends
   31  cat animals/mansFriends

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

[https://drive.google.com/file/d/1r3IL0Ozz3eqT--IR1uZ4k92YGhpXjsU-/view?usp=share_link]

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”

    create database mansfriends;

8. Создать таблицы с иерархией из диаграммы в БД

*-- для использования созданной БД*

    USE mansFriends; 

*-- для реализации иерархии создала таблицу типы животных и  зависимую через внешний ключ виды животных. Наполнила данными.*

    CREATE TABLE animalType (
	id INT PRIMARY KEY AUTO_INCREMENT,
    animalType VARCHAR(10) NOT NULL);

    CREATE TABLE animalSpecies(
	id INT PRIMARY KEY AUTO_INCREMENT,
    species VARCHAR(10) NOT NULL,
    animalType_id INT NOT NULL,
    foreign key(animalType_id) references animalType(id));
   
    INSERT INTO animalType (animalType)
    VALUES('pet'),
    ('pack');

    INSERT INTO animalSpecies (species, animalType_id)
    VALUES('cat', 1),
    ('dog', 1),
    ('hamster', 1),
    ('horse', 2),
    ('donkey', 2),
    ('camel', 2);

*-- создаем таблицы с данными о животных*

    CREATE TABLE cats(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(145) NOT NULL,
    birthdate DATE NOT NULL,
    commands VARCHAR(145),
    animalSpecies_id int NOT NULL,
    foreign key(animalSpecies_id) references animalSpecies(id));

    CREATE TABLE dogs(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(145) NOT NULL,
    birthdate DATE NOT NULL,
    commands VARCHAR(145),
    animalSpecies_id int NOT NULL,
    foreign key(animalSpecies_id) references animalSpecies(id));

    CREATE TABLE hamsters(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(145) NOT NULL,
    birthdate DATE NOT NULL,
    commands VARCHAR(145),
    animalSpecies_id int NOT NULL,
    foreign key(animalSpecies_id) references animalSpecies(id));

    CREATE TABLE horses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(145) NOT NULL,
    birthdate DATE NOT NULL,
    commands VARCHAR(145),
    animalSpecies_id int NOT NULL,
    foreign key(animalSpecies_id) references animalSpecies(id)
    );

    CREATE TABLE donkeys    (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(145) NOT NULL,
    birthdate DATE NOT NULL,
    commands VARCHAR(145),
    animalSpecies_id int NOT NULL,
    foreign key(animalSpecies_id) references animalSpecies(id)
    );

    CREATE TABLE camels    (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(145) NOT NULL,
    birthdate DATE NOT NULL,
    commands VARCHAR(145),
    animalSpecies_id int NOT NULL,
    foreign key(animalSpecies_id) references animalSpecies(id)
    );


9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения


    INSERT INTO cats (nickname, birthdate, commands, animalSpecies_id) 
    VALUES ('jerry', '2012-02-02', 'come', 1),
    ('ammy','2022-04-12', null, 1);

    INSERT INTO dogs (nickname, birthdate, commands, animalSpecies_id) 
    VALUES ('jessy', '2015-12-22', 'sit', 2),
    ('barry','2010-05-29', 'come', 2),
    ('jack','2021-01-12', 'come', 2);

    INSERT INTO hamsters (nickname, birthdate, commands, animalSpecies_id) 
    VALUES ('blue', '2019-03-27', 'go', 3),
    ('flow','2021-08-01', null, 3);

    INSERT INTO horses (nickname, birthdate, commands, animalSpecies_id) 
    VALUES ('mustang', '2010-04-09', 'go', 4),
    ('lilly','2022-12-06', null, 4);


    INSERT INTO donkeys (nickname, birthdate, commands, animalSpecies_id) 
    VALUES ('molly', '2013-04-09', 'stop', 5),
    ('puck','2021-05-01', 'go', 5);

    INSERT INTO camels (nickname, birthdate, commands, animalSpecies_id) 
    VALUES ('ferrari', '2021-04-08', 'go', 6),
    ('ford','2019-08-10', 'stop', 6);


10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

*-- Удаление таблицы верблюдов  с проверкой при помощи вывода списка таблиц до и после операции*

    show tables;
    drop table camels;
    show tables;

*-- Объединение таблиц лошадей и ослов:*

    CREATE table horseAndDonkey
    SELECT * FROM horses 
    UNION
    SELECT * FROM donkeys;


11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице

*--Запрос*

    CREATE table youngAnimals
    SELECT *, TIMESTAMPDIFF(MONTH, birthdate, curdate()) AS ageINmonth
    FROM cats
    WHERE TIMESTAMPDIFF(YEAR, birthdate, curdate()) > 1 AND TIMESTAMPDIFF(YEAR, birthdate, curdate()) < 3
    UNION
    SELECT *, TIMESTAMPDIFF(MONTH, birthdate, curdate()) AS ageINmonth
    FROM dogs
    WHERE TIMESTAMPDIFF(YEAR, birthdate, curdate()) > 1 AND TIMESTAMPDIFF(YEAR, birthdate, curdate()) < 3
    UNION
    SELECT *, TIMESTAMPDIFF(MONTH, birthdate, curdate()) AS ageINmonth
    FROM hamsters
    WHERE TIMESTAMPDIFF(YEAR, birthdate, curdate()) > 1 AND TIMESTAMPDIFF(YEAR, birthdate, curdate()) < 3
    UNION
    SELECT *, TIMESTAMPDIFF(MONTH, birthdate, curdate()) AS ageINmonth
    FROM horseanddonkey
    WHERE TIMESTAMPDIFF(YEAR, birthdate, curdate()) > 1 AND TIMESTAMPDIFF(YEAR, birthdate, curdate()) < 3;


12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

*-- Запрос*

    SELECT id, nickname, birthdate, commands, animalspecies_id as fromTable FROM cats
    UNION ALL
    SELECT id, nickname, birthdate, commands, animalspecies_id as fromTable  FROM dogs
    UNION ALL
    SELECT id, nickname, birthdate, commands, animalspecies_id as fromTable  FROM hamsters
    UNION ALL
    SELECT id, nickname, birthdate, commands, animalspecies_id as fromTable  FROM horseanddonkey;

13.-15. Результат в проекте.
