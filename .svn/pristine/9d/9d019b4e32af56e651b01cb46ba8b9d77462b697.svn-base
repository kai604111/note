set names utf8;

show databases;
show tables;
desc cn_user;
select * from cn_notebook;
desc  cn_user;
select * from cn_user;

update cn_user set cn_user_password='504929d004b51174576974d584f14516' where cn_user_name='zhoujia';
select * from cn_user;

update cn_user set cn_user_name='haha' where cn_user_id='1';

select cn_user_id id ,cn_user_name name ,cn_user_password password ,cn_user_token token ,cn_user_nick nick  from cn_user

show tables;

select 
 cn_note_id as id,            
 cn_notebook_id as notebookId,
 cn_user_id as userId,
 cn_note_status_id as statusId,
 cn_note_type_id as typeId,
 cn_note_title as title,
 cn_note_body as body,
 cn_note_create_time as createTime,      
 cn_note_last_modify_time as modifyTime 
from cn_note where cn_note_id='53d1b3ed-59a1-4715-a7b2-9027b0d551e0';

desc cn_note;

insert into 
	cn_note
	 cn_note_id = #{id},            
	 cn_notebook_id = #{notebookId},
	 cn_user_id = #{userId},
	 cn_note_status_id = #{statusId},
	 cn_note_type_id = #{typeId},
	 cn_note_title = #{title},
	 cn_note_body = #{body},
	 cn_note_create_time = #{createTime},      
	 cn_note_last_modify_time as #{modifyTime} 
	 
update cn_note set 
	 
	 
	 
