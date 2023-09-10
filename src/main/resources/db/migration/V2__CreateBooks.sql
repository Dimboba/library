CREATE TABLE IF NOT EXISTS books(
    id uuid NOT NULL,
    title VARCHAR(128) NOT NULL,
    author VARCHAR(128) NOT NULL,


    PRIMARY KEY(id)

    )