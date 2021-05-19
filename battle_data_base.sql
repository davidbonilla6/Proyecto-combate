

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP DATABASE IF EXISTS `battle_data_base`;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE DATABASE `battle_data_base`;


USE `battle_data_base`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Data base: `battle_data_base`
--

-- --------------------------------------------------------

--
-- table `weapons`
--

CREATE TABLE weapon (
  weapon_id integer primary key,
  weapon_name varchar(20) NOT NULL,
  weapon_image_path varchar(100),
  speed int,
  power int,
  weapon_race varchar(50) NOT NULL,
  points int not null
);

--
-- table race
--

create table race (
race_id integer primary key,
race_name varchar(200) not null,
health int not null,
power int not null,
speed int not null,
agility int not null,
defense int not null,
points int  not null
);

--
-- table warrior
--

CREATE TABLE warriors (
  warrior_id integer PRIMARY KEY,
  warrior_name varchar(20) NOT NULL,
  warrior_image_path varchar(100),
  description_warrior varchar(20) NOT NULL,
  race integer,
  FOREIGN KEY (race) REFERENCES race(race_id)
);

--
-- table players
--

create table players (
player_id integer primary key,
player_name varchar(200)
);

--
-- table ranking
--

create table ranking (
players_id integer,
total_points int not null,
warriors_id integer,
foreign key (players_id) references players(player_id),
foreign key (warriors_id) references warriors(warrior_id)
);

--
-- table battles
--

create table battles (
battle_id int auto_increment not null primary key,
players integer,
warrior integer,
weapon integer,
opponent_id int not null,
opponent_weapon_id int not null,
injuries_caused int not null,
injuries_suffered int not null,
battle_points int not null,
foreign key (players) references players(player_id),
foreign key (warrior) references warriors(warrior_id),
foreign key (weapon) references weapon(weapon_id)
);



INSERT INTO `weapon` (`weapon_id`, `weapon_name`, `weapon_image_path`, `speed`, `power`, `weapon_race`, `points`) VALUES
(1, 'dagger', '', 3, 0, 'human, elf', 10),
(2, 'axe', '',0 , 3, 'human, dwarf', 10),
(3, 'doubleSword', '', 2, 2, 'human, elf', 14),
(4, 'scimitar', '', '2', '1', 'human, elf', 14),
(5, 'bow', '', 5, 1, 'elf', 15),
(6, 'katana', '', 3, 2, 'human', 18),
(7, 'dirk', '', 4, 0, 'human, elf, dwarf', 12),
(8, 'doubleAxe', '', 0, 5, 'dwarf', 20),
(9, 'sword', '', 1, 1, 'human, elf, dwarf', 10);
INSERT INTO `race` (`race_id`, `race_name`, `health`, `power`, `speed`, `agility`, `defense`, `points` ) VALUES
(1, 'elf', 40, 4, 7, 7, 2, 19),
(2, 'human', 50, 5, 5, 6, 3, 20),
(3, 'dwarf', 60, 6, 3, 	5, 4, 21);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
