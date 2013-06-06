--ユーザ
DROP TABLE user;

CREATE TABLE user (
    user_id                        INT NOT NULL AUTO_INCREMENT,
    user_name                      VARCHAR(150) NOT NULL,
    password                       VARCHAR(100) NOT NULL,
    expiration_date                DATE,
    first_name                     VARCHAR(30),
    last_name                      VARCHAR(30),
    mail_address                   VARCHAR(150),
    update_date_time               DATETIME  NOT NULL,
    PRIMARY KEY (user_id),
    UNIQUE KEY (user_name)
);
