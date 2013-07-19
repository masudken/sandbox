truncate table issue_type;
insert into issue_type (issue_type_code, issue_type_name, update_date_time) values ('010', '不具合', current_timestamp);
insert into issue_type (issue_type_code, issue_type_name, update_date_time) values ('020', '仕様変更', current_timestamp);
insert into issue_type (issue_type_code, issue_type_name, update_date_time) values ('030', '障害', current_timestamp);
insert into issue_type (issue_type_code, issue_type_name, update_date_time) values ('040', '調査', current_timestamp);
insert into issue_type (issue_type_code, issue_type_name, update_date_time) values ('050', '問題', current_timestamp);
commit;
