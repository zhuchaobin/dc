CREATE FUNCTION `_trans_lnk_inf_def_func`(old_name varchar(50), flag int) RETURNS varchar(50) CHARSET utf8
begin 
declare RESULT varchar(50);
IF flag =1
then
set RESULT=(select Aply_PcStp_Chn_Nm from R1_Lnk_Inf_Def where Pcs_Step_Eng_Nm=old_name);
elseif flag =2
then
set RESULT=(select Aply_PcStp_Cd from R1_Lnk_Inf_Def where Pcs_Step_Eng_Nm=old_name);
end if;
RETURN RESULT;
end

CREATE  FUNCTION `_nextindex`(n varchar(50)) RETURNS int(11)
begin 
declare b_num int;
declare incr_num int; 
set b_num=(select begin_num from t_sequence where name=n);
set incr_num=(select incr from t_sequence where name=n); 
update t_sequence
 set begin_num = (b_num + incr_num)
 where name= n ;  
return b_num+incr_num;  
end

CREATE  FUNCTION `_get_coname_func`(id_in int) RETURNS varchar(50) CHARSET utf8
begin 
declare b_num varchar(50);
set b_num=(select name from company where id=id_in);
return b_num;  
end