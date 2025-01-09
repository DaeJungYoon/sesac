eager:
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,p1_0.title,p1_0.updated_at,c1_0.post_id,c1_0.id,c1_0.content,c1_0.created_at,c1_0.updated_at 
from post p1_0 left join comment c1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?

lazy:
Hibernate: select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,p1_0.title,p1_0.updated_at 
from post p1_0 
where p1_0.id=?


lazy with size:
Hibernate: select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,p1_0.title,p1_0.updated_at 
from post p1_0 
where p1_0.id=?

Hibernate: select c1_0.post_id,c1_0.id,c1_0.content,c1_0.created_at,c1_0.updated_at 
from comment c1_0 
where c1_0.post_id=?

eager: post만 사용할 때도 post + create


eager  O -> 
eager  x -> 

lazy  O -> 
lazy  x -> 

eager  O -> 
eager  x -> 