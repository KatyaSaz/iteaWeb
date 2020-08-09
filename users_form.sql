-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Авг 05 2020 г., 15:48
-- Версия сервера: 10.1.40-MariaDB
-- Версия PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `test`
--

-- --------------------------------------------------------

--
-- Структура таблицы `users_form`
--

CREATE TABLE `users_form` (
  `ID` int(11) NOT NULL,
  `LOGIN` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `GENDER` varchar(10) NOT NULL,
  `ADDRESS` varchar(10) NOT NULL,
  `COMMENT` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `users_form`
--

INSERT INTO `users_form` (`ID`, `LOGIN`, `PASSWORD`, `NAME`, `GENDER`, `ADDRESS`, `COMMENT`) VALUES
(1, 'ekaterina@sazonov-online.info', 'This89Pass', 'Katya', 'female', 'dnr', 'Checking registration form!		'),
(2, 'kile@back2void.com', 'PolkJ1029', 'Jack', 'male', 'dnr', 'Servlet work (maven project) check		'),
(3, 'roter@dam-num.org', 'HI47Sam2', 'Sam', 'female', 'crimea', 'I want to register'),
(4, 'ek9-8@e.ct', '096e9ebd402975d6df492a7797506c41', 'Mick', 'male', 'crimea', 'Something		\r\n		\r\n		'),
(5, 'link@online.us', '1a45a34da7b11c2931c612bb1135e02c', 'Link', 'male', 'crimea', 'key word/////......		\r\n		'),
(6, 'po@gmail.com', '-3e88edd311005713ac9e415aa394f740', 'Po', 'male', 'lnr', 'information, very important information		');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `users_form`
--
ALTER TABLE `users_form`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `users_form`
--
ALTER TABLE `users_form`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
