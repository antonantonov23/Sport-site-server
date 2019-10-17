INSERT INTO accounts (full_name, email, password, is_admin) VALUES
  ('Aliko', 'Dangote@gmail.com', '$2a$10$.dxNhFflX5GDGCelz8ASeum47kM2/cm4gOGTSV.xQnRTzv7Ed7VI6',false);

INSERT INTO accounts (full_name, email, password, is_admin) VALUES
  ('Petko', 'petko@gmail.com', '$2a$10$.dxNhFflX5GDGCelz8ASeum47kM2/cm4gOGTSV.xQnRTzv7Ed7VI6',true);

INSERT INTO sport_categories(name_of_category) VALUES
  ('Football');

INSERT INTO sport_categories(name_of_category) VALUES
  ('Basketball');

INSERT INTO leagues(name_of_league,sport_category_id) VALUES
  ('A grupa',1);

INSERT INTO leagues(name_of_league,sport_category_id) VALUES
  ('LIGA BBVA',1);

INSERT INTO leagues(name_of_league,sport_category_id) VALUES
  ('BASKET LIGA',2);

INSERT INTO leagues(name_of_league,sport_category_id) VALUES
  ('PAMPOROVO LEAGUE',2);

INSERT INTO teams(name_of_team,league_id) VALUES
  ('LOKO PD',1);

INSERT INTO teams(name_of_team,league_id) VALUES
  ('BOTEV PD',1);

INSERT INTO teams(name_of_team,league_id) VALUES
  ('LOKO SOFIA',1);

  INSERT INTO teams(name_of_team,league_id) VALUES
  ('LEVSKI',1);

  INSERT INTO teams(name_of_team,league_id) VALUES
  ('PSG',3);

  INSERT INTO teams(name_of_team,league_id) VALUES
  ('REAL MADRID',2);

  INSERT INTO teams(name_of_team,league_id) VALUES
  ('BARCELONA',3);

  INSERT INTO teams(name_of_team,league_id) VALUES
  ('SEVILLA',3);

INSERT INTO players (name_of_player,date_of_birth,number,team_id) VALUES
  ('Valio Bojinov','1/02/1994',5,1);

INSERT INTO players (name_of_player,date_of_birth,number,team_id) VALUES
  ('EVTIM MILOSHEF','11/05/1991',7,1);

insert into players (name_of_player, date_of_birth, number, team_id) values ('Costanza Mellor', '7/1/1992', 1, 8);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Else Henrie', '7/11/1987', 2, 5);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Stanfield Mahedy', '7/4/1992', 3, 7);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Thorstein d'' Elboux', '1/11/1990', 4, 7);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Meyer Fulker', '10/2/2000', 5, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Meaghan Kaesmans', '8/27/1984', 6, 6);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Evan Halstead', '4/1/1994', 7, 5);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Jaimie Croy', '6/9/1987', 8, 1);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Eben Grew', '6/14/1996', 9, 6);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Pru McLellan', '5/17/1993', 10, 8);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Rich McIlhagga', '4/7/1989', 11, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Brana Brayson', '2/18/1997', 12, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Irwin Siemons', '7/5/1983', 13, 1);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Lydon Yakunchikov', '1/31/1991', 14, 7);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Skyler Breitler', '11/12/1981', 15, 6);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Tallie Woodison', '6/23/1995', 16, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Hedvige Lampart', '8/26/1998', 17, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Thaxter Leynham', '7/3/1986', 18, 5);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Andy Whitsun', '10/9/1991', 19, 5);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Ketty Martinat', '6/2/1999', 20, 8);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Pippa Sleep', '6/21/1982', 21, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Cedric Zellmer', '8/8/1995', 22, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Kelcie Marshland', '1/11/1995', 23, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Candi Bum', '10/5/1986', 24, 6);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Constantine Kaplin', '4/27/1987', 25, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Duffy Figgess', '2/5/1981', 26, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Chloe Kubiczek', '2/22/1999', 27, 3);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Sheila Cockrill', '12/31/1991', 28, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Neala Gullam', '10/4/1993', 29, 5);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Crosby Edmonston', '7/27/1991', 30, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Tilly Mishow', '7/10/1993', 31, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Concettina Custed', '12/25/1998', 32, 8);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Broddie Eates', '9/9/1983', 33, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Anthia Iacovielli', '5/7/1983', 34, 1);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Sybilla Trattles', '6/16/1994', 35, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Reinwald Dorro', '9/26/1984', 36, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Shaylyn Shippey', '11/3/1995', 37, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Conan Crang', '12/26/1995', 38, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Rustie Brahams', '8/22/1984', 39, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Jacobo Whitehair', '8/26/1981', 40, 6);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Catharine Kemmish', '6/8/1986', 41, 3);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Scotty Creak', '9/22/2000', 42, 1);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Tiffani Aucock', '3/1/1988', 43, 8);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Christal Pauley', '6/16/1994', 44, 7);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Cyril Dilnot', '1/12/1982', 45, 2);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Arlen Bruniges', '10/24/1984', 46, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Morena Height', '12/19/1994', 47, 4);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Auria Theaker', '5/14/1989', 48, 6);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Tabbie Leonardi', '8/22/1990', 49, 1);
insert into players (name_of_player, date_of_birth, number, team_id) values ('Modestia Worland', '5/19/1991', 50, 8);
