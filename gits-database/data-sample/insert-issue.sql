truncate table issue;
insert into issue (issue_id, issue_type_code, title, description, registrant_id, register_date, representative_id, priority, start_date, end_date, progress, cost, status, update_date_time) values (1, '010', '人生がハードモードな件', 'あえいうえおあお', 2, '2013-01-01', 4, '1', '2013-02-01', '2013-03-01', 12, 34, '2', current_timestamp);
insert into issue (issue_id, issue_type_code, title, description, registrant_id, register_date, representative_id, priority, start_date, end_date, progress, cost, status, update_date_time) values (123, '010', 'メニュー画面より単一プログラムが複数起動できてしまう。', 'どうなってるんですか？', 2, '2013-01-01', 4, '1', '2013-02-01', '2013-03-01', 12, 34, '2', current_timestamp);
insert into issue (issue_id, issue_type_code, title, description, registrant_id, register_date, representative_id, priority, start_date, end_date, progress, cost, status, update_date_time) values (2341, '020', 'いいじゃない、人間だもの！', 'あえいうえおあお', 2, '2013-01-01', 4, '1', '2013-02-01', '2013-03-01', 12, 34, '2', current_timestamp);
insert into issue (issue_id, issue_type_code, title, description, registrant_id, register_date, representative_id, priority, start_date, end_date, progress, cost, status, update_date_time) values (8673, '050', '節子それドロップやない、チェンジアップや！', 'あいうえおかきくけこ
さしすせそ
うわぁあああああああああああああああああああああああああああああああ', 2, '2013-01-01', 4, '1', '2013-02-01', '2013-03-01', 12, 34, '2', current_timestamp);
insert into issue (issue_id, issue_type_code, title, description, registrant_id, register_date, representative_id, priority, start_date, end_date, progress, cost, status, update_date_time) values (9999, '040', '(｀・ω・´)ｼｬｷｰﾝ', 'あえいうえおあお', 2, '1980-12-24', 5, '1', '2013-02-01', '2013-03-01', 12, 34, '2', current_timestamp);
commit;
