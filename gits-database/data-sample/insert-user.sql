trancate table user;
inser into user (user_id, user_name, password, expiration_date, first_name, last_name, mail_address, update_date_time) values (1, 'masudken', '1234', null, '賢一', '増田', 'masuda@gfam.co.jp', current_timestamp);
commit;
