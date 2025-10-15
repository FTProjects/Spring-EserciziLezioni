CREATE TABLE IF NOT EXISTS tutorials (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    title           VARCHAR(50) NOT NULL,
    category        VARCHAR(50) NOT NULL,
    description     TEXT,
    published       BOOLEAN DEFAULT FALSE
);