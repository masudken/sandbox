--課題
DROP TABLE issue;

CREATE TABLE issue (
    issue_id                       INT NOT NULL AUTO_INCREMENT,
    issue_type_id                  INT NOT NULL,
    title                          TINYTEXT NOT NULL,
    description                    TEXT,
    registrant_id                  INT NOT NULL,
    register_date                  DATE NOT NULL,
    representative_id              INT,
    priority                       CHAR(1),
    start_date                     DATE,
    end_date                       DATE,
    progress                       TINYINT,
    cost                           TINYINT,
    status                         CHAR(2) NOT NULL,
    update_date_time               DATETIME NOT NULL,
    PRIMARY KEY (issue_id)
);
