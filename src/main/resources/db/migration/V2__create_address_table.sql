CREATE TABLE tbl_address (
                             id SERIAL PRIMARY KEY,
                             state VARCHAR(255) NOT NULL,
                             city VARCHAR(255) NOT NULL,
                             public_place VARCHAR(255) NOT NULL,
                             number INTEGER NOT NULL,
                             zip_code VARCHAR(10) NOT NULL
);
