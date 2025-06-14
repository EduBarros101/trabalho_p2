CREATE TABLE IF NOT EXISTS personagens (
    id serial PRIMARY KEY,
    nome varchar(50),
    idade int,
    raca varchar(20),
    classe varchar(11)
);