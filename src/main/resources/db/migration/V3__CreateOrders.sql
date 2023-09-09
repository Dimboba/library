CREATE TABLE IF NOT EXISTS orders (
    id uuid NOT NULL,
    customer_id uuid NOT NULL REFERENCES customers(id),
    book_id uuid NOT NULL REFERENCES books(id),
    order_timestamp timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    return_timestamp timestamp(6) DEFAULT NULL,

    PRIMARY KEY(id)
    )