
Samochodziki Apokalipsy

Are you afraid of tomorrow? Don't know what's next year bring? Now it's not a problem due to our amazing app, you can stay reassured, because we will keep you updated all the time what's going to happen. Whether it'll be financial, ecological or political catastrophy, our tiny, cute racing cars presenting changing world condition will provide you solid, up-to-date informations.


createdb:
dbname: samochodziki
user: postgres
password: 123




CREATE SEQUENCE public.car_id_car_seq;

CREATE TABLE public.car (
                id_car INTEGER NOT NULL DEFAULT nextval('public.car_id_car_seq'),
                name VARCHAR NOT NULL,
                points INTEGER NOT NULL,
                phrase VARCHAR NOT NULL,
                CONSTRAINT car_pk PRIMARY KEY (id_car)
);


ALTER SEQUENCE public.car_id_car_seq OWNED BY public.car.id_car;

INSERT INTO car(name, points, phrase) values ('political', 69, 'Trump'), 
('biological', 13, 'virus'),
('economical', 55, 'inflation'),
('military', 44, 'war');

