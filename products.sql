-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Авг 11 2020 г., 22:42
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
-- Структура таблицы `products`
--

CREATE TABLE `products` (
  `ID` int(11) NOT NULL,
  `PRICE` float NOT NULL,
  `DESCRIPTION` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 NOT NULL,
  `CATEGORY` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`ID`, `PRICE`, `DESCRIPTION`, `NAME`, `CATEGORY`) VALUES
(1, 325.99, 'Япония, 1936 год. Эксцентричный художник, проживавший вместе с шестью дочерьми, падчерицами и племянницами, был найден мертвым в комнате, запертой изнутри. Его дневники, посвященные алхимии и астрологии, содержали подробный план убийства каждой из них. Лишить жизни нескольких, чтобы дать жизнь одной, но совершенной — обладательнице самых сильных качеств всех знаков Зодиака. И вскоре после этого план исполнился: части тел этих женщин находят спрятанными по всей Японии. К 1979 году Токийские убийства по Зодиаку будоражили нацию десятилетиями, но так и не были раскрыты. Предсказатель судьбы, астролог и великий детектив Киёси Митараи и его друг-иллюстратор должны за одну неделю разгадать тайну этого невозможного преступления. У вас есть все необходимые ключи, но сможете ли вы найти отгадку прежде, чем это сделают они?', '\"Токийский зодиак\" Содзи Симада', 1),
(2, 45.34, 'Новый сборник А. К. Дойла представляет известные произведения о Шерлоке Холмсе. В сборник вошли: \"Скандал в Богемии\", \"Союз рыжих\", \"Установление личности\", \"Тайна Боскомской долины\", \"Пять зернышек апельсина\", \"Человек с рассеченной губой\", \"Голубой карбункул\", \"Пестрая лента\", \"Палец инженера\", \"Знатный холостяк\", \"Берилловая диадема\", \"Медные буки\".', '\"Приключения Шерлока Холмса\" Артур Конан Дойл', 1),
(3, 150.23, 'В английском алфавите 26 букв. В подписи преступника, затеявшего с Эркюлем Пуаро игру при помощи писем, всего три буквы, первые, А, B и С. Он планирует совершить убийства в местах, названия которых расположены в алфавитном порядке. Задача Пуаро - разгадать замыслы убийцы и не дать ему совершить задуманные 26 преступлений. А в романе \"Загадка Эндхауза\" Пуаро предстоит решить самую серьезную задачу в истории человечества - разобраться в женской душе.', '\"Убийства по алфавиту\" Агата Кристи', 1),
(4, 210, 'Герои романа Александра Дюма «Три мушкетера» — пылкий гасконец д’Артаньян, гордый и утонченный Атос, хитромудрый красавец Арамис и простодушный добряк Портос — попадают в круговорот многочисленных интриг и любовных приключений при дворе французского короля Людовика ХІІІ, где на каждом шагу их подстерегает опасность. Но какие бы препятствия и неожиданности ни возникали на их пути, они неизменно выходят победителями, ибо всегда и всюду остаются верными девизу — «Один за всех и все за одного!».', '\"Три мушкетера\" Александр Дюма', 2),
(5, 314.56, 'Во второй половине 19 века в морях и океанах на глаза мореплавателям стал попадаться необычный объект — светящийся веретенообразный предмет, превосходящий скоростью и размерами кита. Газеты, а за ними и ученые всего мира заинтересовались «морским чудовищем».\r\n\r\nНо судьба оказалась милостива только к профессору Аронаксу, который со слугой Конселем и гарпунером Недом Лендом волею случая (или автора, что по сути одно и то же), попадают на борт необыкновенной и единственной в мире подводной лодки.\r\n\r\nКапитан и экипаж лодки оказались совсем не чудовищами и герои пережили немало опасных и удивительных приключений, совершив кругосветное путешествие в 20 тысяч лье под водой.', '\"Двадцать тисяч лье под водой\" Жюль Верн', 2),
(6, 130.23, 'Жизнь и удивительные приключения Робинзона Крузо — роман английского писателя Даниэля Дефо, написанный как вымышленная автобиография, тем не менее основан на реальных событиях, произошедших с шотландским моряком Александром Селкирком, проведшим четыре года на необитаемом острове. Герою романа, Робинзону Крузо предстоит спастись в кораблекрушении и затем прожить в одиночестве на острове более 20 лет. Это книга о мужестве и воле к жизни, об упорстве и дружбе, мудрости и оптимизме.', '\"Робинзон Крузо\" Даниель Дефо', 2),
(7, 210.44, 'Книгой «Последнее желание» начинается один из лучших циклов в истории жанра фэнтези. Семь новелл о ведьмаке Геральте из Ривии, его друзьях и возлюбленных, о его нелегкой «работе» по истреблению всякой нечисти, о мире, населенном эльфами, гномами, оборотнями, драконами, и, конечно, людьми – со всеми их страстями, пороками и добродетелями.\r\nСага А. Сапковского давно занимает почетное место в мировой традиции жанра фэнтези, а Геральт стал культовым персонажем не только в мире литературы, но в универсуме компьютерных игр. Аудитория пана Анджея неуклонно расширяется, и мы рады содействовать этому, выпустив первую книгу о Ведьмаке с иллюстрациями, созданными специально для этого издания.', '\"Последнее желание\" Анджей Сапковский', 3),
(8, 168.21, 'Смерть ловит рыбу. Веселится на вечеринке. Напивается в трактире. А все обязанности Мрачного Жнеца сваливаются на хрупкие плечи его ученика. Но делать нечего: берем косу, прыгаем на белую лошадь Бинки - и вперед!', '\"Мор, ученик Смерти\" Терри Пратчетт', 3),
(9, 140.9, 'Мара с детства знала, что таким, как она - красным, - от судьбы не стоит ждать подарков. Кусок хлеба для своей семьи она добывала воровством. А все богатства и блага жизни в ее стране по праву рождения принадлежат серебряным, людям с серебристой кровью. Однажды девушка случайно обчистила карманы наследного принца! Но вместо наказания вдруг попала во дворец, где ее объявили наследницей знатного рода… и невестой принца! Зачем это нужно королевской семье? Вскоре Мара понимает, что отличается от своих родных. Неужели она и правда серебряная?', '\"Алая королева\" Виктория Авеярд', 3);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
