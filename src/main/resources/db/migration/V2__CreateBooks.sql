CREATE TABLE IF NOT EXISTS books(
    id uuid NOT NULL,
    title CHAR(128) NOT NULL,
    author CHAR(128) NOT NULL,

    PRIMARY KEY(id)

    )