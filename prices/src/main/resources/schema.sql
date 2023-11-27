CREATE TABLE IF NOT EXISTS prices(
    id                 INTEGER NOT NULL AUTO_INCREMENT,
    brand_id           INTEGER NOT NULL,
    start_date         TIMESTAMP,
    end_date           TIMESTAMP,
    tariff_indicator   SMALLINT,
    currency           VARCHAR,
    product_id         INTEGER,
    priority           SMALLINT,
    price              NUMERIC(6,2),
    PRIMARY KEY (id)
);