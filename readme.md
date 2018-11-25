
Samochodziki Apokalipsy

Are you afraid of tomorrow? Don't know what next year bring? Now it's not a problem due to our amazing app, you can stay reassured, because we will keep you updated all the time what's going to happen. Whether it'll be financial, ecological or political catastrophy, our tiny, cute racing cars presenting changing world condition will provide you solid, up-to-date informations.


createdb:
dbname: samochodziki (NOT REVELANT ON BRANCH)
user: postgres
password: 123



CREATE SEQUENCE public.phrase_id_phrase_seq;

CREATE TABLE public.phrase (
                id_phrase INTEGER NOT NULL DEFAULT nextval('public.phrase_id_phrase_seq'),
                phrase VARCHAR NOT NULL,
                CONSTRAINT phrase_pk PRIMARY KEY (id_phrase)
);


ALTER SEQUENCE public.phrase_id_phrase_seq OWNED BY public.phrase.id_phrase;

CREATE SEQUENCE public.news_id_news_seq;

CREATE TABLE public.news (
                id_news INTEGER NOT NULL DEFAULT nextval('public.news_id_news_seq'),
                id_phrase INTEGER NOT NULL,
                popularity INTEGER NOT NULL,
                collected_Timestamp TIMESTAMP NOT NULL,
                CONSTRAINT news_pk PRIMARY KEY (id_news, id_phrase)
);


ALTER SEQUENCE public.news_id_news_seq OWNED BY public.news.id_news;

CREATE SEQUENCE public.car_id_car_seq;

CREATE TABLE public.car (
                id_car INTEGER NOT NULL DEFAULT nextval('public.car_id_car_seq'),
                name VARCHAR NOT NULL,
                points INTEGER DEFAULT 0 NOT NULL,
                CONSTRAINT car_pk PRIMARY KEY (id_car)
);


ALTER SEQUENCE public.car_id_car_seq OWNED BY public.car.id_car;

CREATE TABLE phrase_car (
        id_phrase int references phrase(id_phrase),
        id_car int references car(id_car),
        constraint id PRIMARY KEY(id_phrase, id_car)
);


ALTER TABLE public.news ADD CONSTRAINT phrase_news_fk
FOREIGN KEY (id_phrase)
REFERENCES public.phrase (id_phrase)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;






INSERT INTO phrase(phrase) VALUES ('trump'),
('kaczynski'),
('pis'),
('virus'),
('aids'),
('STD'),
('global warming'),
('antarctica'),
('inflation'),
('dolar'),
('war'),
('afghanistan'),
('nuclear');


INSERT INTO car(name) VALUES ('political'),
('biological'),
('economical'),
('war');

INSERT INTO phrase_car(id_car, id_phrase) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(4, 11),
(4, 12),
(4, 13);

INSERT INTO news(id_phrase, popularity, collected_timestamp) VALUES
(1, 5, '2018-11-25 19:10:25-07'),
(2, 15, '2018-11-25 19:12:25-07'),
(3, 22, '2018-11-25 18:12:25-07'),
(4, 125, '2018-11-25 16:15:25-07'),
(5, 5, '2018-11-25 19:13:25-07'),
(6, 15, '2018-11-25 19:12:26-07'),
(7, 21, '2018-11-25 19:18:25-07'),
(8, 17, '2018-11-25 20:12:25-07'),
(9, 3, '2018-11-25 19:12:25-07'),
(10, 45, '2018-11-25 23:32:25-07'),
(11, 15, '2018-11-25 21:12:25-07'),
(12, 15, '2018-11-25 21:12:25-07'),
(13, 15, '2018-11-25 21:12:25-07');




