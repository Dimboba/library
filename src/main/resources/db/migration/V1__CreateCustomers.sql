CREATE TABLE IF NOT EXISTS customers(
    id uuid NOT NULL,
    first_name CHAR(64) NOT NULL,
    last_name CHAR(64) NOT NULL,
    gender CHAR(8) NOT NULL,

    PRIMARY KEY(id)

)