-- 코드를 입력하세요  
SELECT a_out.animal_id, a_out.name from animal_outs as a_out
join animal_ins as a_in
on a_out.animal_id = a_in.animal_id
where a_in.datetime > a_out.datetime
order by a_in.datetime asc



# SELECT O.ANIMAL_ID, O.NAME
# FROM ANIMAL_OUTS O
# JOIN ANIMAL_INS I
# ON I.ANIMAL_ID = O.ANIMAL_ID
# WHERE I.DATETIME > O.DATETIME
# ORDER BY I.DATETIME ASC