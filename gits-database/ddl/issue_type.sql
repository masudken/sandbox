--課題種別
DROP TABLE issue_type;

CREATE TABLE issue_type (
    issue_type_id                  INT NOT NULL AUTO_INCREMENT,
    issue_type_code                CHAR(3) NOT NULL,
    issue_type_name                VARCHAR(50) NOT NULL,
    update_date_time               DATETIME NOT NULL,
    PRIMARY KEY (issue_type_id)
);
