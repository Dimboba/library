CREATE TABLE IF NOT EXISTS customers(
    id uuid NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    gender VARCHAR(8) NOT NULL,

    PRIMARY KEY(id)

)