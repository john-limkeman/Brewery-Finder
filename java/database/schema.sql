BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('brewerBob', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_BREWER');



CREATE Table Breweries (

id serial, 
name varchar,
address varchar,
description varchar,
image varchar,
brewer_id int,
brewery_url varchar,
phone bigint,
hours varchar,
active boolean,

constraint pk_Breweries primary key (id),
constraint fk_Breweries_Brewer foreign key (brewer_id) references users (user_id)
);

INSERT INTO Breweries (name, address, description, image, brewer_id, brewery_url, phone, hours, active) VALUES 
('Denver Beer Company', '1695 Platte St, Denver, CO 80202', 'Brewery-based taproom with an industrial vibe, dog-friendly outdoor beer garden & food trucks', 'https://denverbeerco.com/wp-content/uploads/2014/07/logo_final3.png', 3,
'https://denverbeerco.com/', 3034332739, '11am to 11pm', true);
INSERT INTO Breweries (name, address, description, image, brewer_id, brewery_url, phone, hours, active) VALUES 
('TRVE Brewing Company', '227 Broadway #101, Denver, CO 80203', 'Small local brewery & taproom featuring eclectic housemade beers in heavy metal–inspired environs.', 'https://trvebrewing.square.site/product/bandanna-wolf/186?cs=true', 3, 'https://www.trvebrewing.com/ontap/', '3033511021', '3pm to 11pm', true);

CREATE TABLE Beers
(
beer_id serial,
beer_name varchar(64) not null,
brewery_id int not null,
beer_type varchar(64) not null,
description varchar(500) not null,
picture varchar,
abv varchar(64),
ibu varchar(64),
rating int,
available boolean,

constraint pk_Beers primary key (beer_id),
constraint fk_Beers_Breweries foreign key (brewery_id) references Breweries (id)

);

INSERT INTO Beers (beer_name, brewery_id, beer_type, description, picture, abv, ibu, rating, available) VALUES ('Juicy Freak Juicy IPA', 1, 'IPA', 'Juicy Freak carries a bright citrus punch and smooth tropical hop bliss. Exploding with rich American hop notes of orange, mango, pear, and stone fruit, this tropical journey is smooth and creamy. Light on bitterness, big on juicy citrus, for living your best life.', 'https://denverbeerco.com/wp-content/uploads/2014/07/jf1.jpg',
'6.5', null, 5, true);
INSERT INTO Beers (beer_name, brewery_id, beer_type, description, picture, abv, ibu, rating, available) VALUES ('COSMIC CRYPT', 2, 'Pale Ale', 'Farmhouse Pale Ale fermented with Belgian Farmhouse yeast and dry hopped with Mosaic and Mandarina Bavaria hop', 'https://cdn.beeradvocate.com/im/c_beer_image.gif',
'5.6', null ,3.5, true);






COMMIT TRANSACTION;
