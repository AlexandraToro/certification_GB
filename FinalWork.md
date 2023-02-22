Итоговая аттестация
Информация о проекте
Необходимо организовать систему учета для питомника, в котором живут
домашние и вьючные животные.

Задание
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

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

    Подключение дополнительного репозитория ведется по инструкции, желательно официального сайта. В данном случае инструкция https://dev.mysql.com/doc/mysql-apt-repo-quick-guide/en/#apt-repo-setup.

    После подключения дополнительного репозитория для установки MySql-server набрать следующую команду:

    sudo apt-get install mysql-server

4. Установить и удалить deb-пакет с помощью dpkg.

    wget [https://download.virtualbox.org/virtualbox/7.0.4/virtualbox-7.0_7.0.4-154605~Ubuntu~jammy_amd64.deb] (*ссылка на deb - пакет)

    sudo dpkg -i virtualbox-7.0_7.0.4-154605~Ubuntu~jammy_amd64.deb

    sudo apt -f  install (*для установки зависимых ) 

5. Выложить историю команд в терминале ubuntu

    см.выше

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

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

    SELECT * FROM cats
    UNION ALL
    SELECT * FROM dogs
    UNION ALL
    SELECT * FROM hamsters
    UNION ALL
    SELECT * FROM horseanddonkey;

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое
животное” Сделайте так, чтобы с объектом такого типа можно было работать в
блоке try-with-resources. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведении животного заполнены все поля.
