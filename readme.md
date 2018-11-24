
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
                date DATE NOT NULL,
                CONSTRAINT news_pk PRIMARY KEY (id_news, id_phrase)
);


ALTER SEQUENCE public.news_id_news_seq OWNED BY public.news.id_news;

CREATE SEQUENCE public.car_id_car_seq;

CREATE TABLE public.car (
                id_car INTEGER NOT NULL DEFAULT nextval('public.car_id_car_seq'),
                name VARCHAR NOT NULL,
                points INTEGER NOT NULL,
                CONSTRAINT car_pk PRIMARY KEY (id_car)
);


ALTER SEQUENCE public.car_id_car_seq OWNED BY public.car.id_car;

CREATE TABLE public.phrase_car (
                id_car INTEGER NOT NULL,
                id_phrase INTEGER NOT NULL,
                CONSTRAINT phrase_car_pk PRIMARY KEY (id_car, id_phrase)
);


ALTER TABLE public.phrase_car ADD CONSTRAINT phrase_phrase_car_fk
FOREIGN KEY (id_phrase)
REFERENCES public.phrase (id_phrase)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.news ADD CONSTRAINT phrase_news_fk
FOREIGN KEY (id_phrase)
REFERENCES public.phrase (id_phrase)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.phrase_car ADD CONSTRAINT car_phrase_car_fk
FOREIGN KEY (id_car)
REFERENCES public.car (id_car)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


INSERT INTO car(name, points, phrase) values ('political', 69, 'Trump'), 
('biological', 13, 'virus'),
('economical', 55, 'inflation'),
('military', 44, 'war');

