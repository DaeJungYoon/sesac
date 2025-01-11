# JSON
```json
{
    "id": 14,
    "title": "haha",
    "content": "howqho",
    "author": null,
    "createdAt": "2025-01-09T16:05:50.495672",
    "updatedAt": "2025-01-09T16:05:50.495672",
    "comments": [
        {
            "id": 14,
            "content": "new content",
            "createdAt": "2025-01-09T16:27:03.401496"
        },
        {
            "id": 15,
            "content": "content",
            "createdAt": "2025-01-09T16:27:16.594346"
        },
        {
            "id": 16,
            "content": "content",
            "createdAt": "2025-01-10T10:53:40.451392"

        },
        {
            "id": 17,
            "content": "content",
            "createdAt": "2025-01-10T10:53:41.382802"
        },
        {
            "id": 18,
            "content": "content",
            "createdAt": "2025-01-10T10:53:42.083789"
        },
        {
            "id": 19,
            "content": "content",
            "createdAt": "2025-01-10T10:53:42.798754"
        },
        {
            "id": 20,
            "content": "content",
            "createdAt": "2025-01-10T10:53:43.438601"
        },
        {
            "id": 21,
            "content": "content",
            "createdAt": "2025-01-10T10:53:44.129157"
        }
    ],
    "tags": [
        "Unit",
        "Unit",
        "nit",
        "Spting",
        "React",
        "React",
        "HTTP"
    ]
}
```
# FETCH
## FETCH
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id 
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?
```
## FETCH with DISTINCT
```java
@Query("SELECT p DISTINCT FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```
```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id 
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?
```
## FETCH with @BatchSize(size = n) to {somthing table}
### FETCH with @BatchSize(size = 1) to comments
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id 
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?

```

#### FETCH with @BatchSize(size = 2)
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id 
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?
```

#### FETCH with @BatchSize(size = 4)
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?
```

### FETCH with @BatchSize(size = 1) to postTags
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id 
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?

```

#### FETCH with @BatchSize(size = 2)
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id 
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?
```

#### FETCH with @BatchSize(size = 4)
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN FETCH p.postTags pt " +  
        "LEFT JOIN FETCH pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,pt1_0.post_id,pt1_0.id,pt1_0.created_at,t1_0.id,t1_0.name,p1_0.title,p1_0.updated_at 
from post p1_0 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
left join tag t1_0 on t1_0.id=pt1_0.tag_id
where p1_0.id=?

Hibernate: 
select c1_0.id,c1_0.content,c1_0.created_at,c1_0.post_id,c1_0.updated_at 
from comment c1_0 
left join post p1_0 on p1_0.id=c1_0.post_id 
where p1_0.id=?
```

# Without FETCH
## without FETCH 
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN p.postTags pt " +  
        "LEFT JOIN pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,p1_0.title,p1_0.updated_at 
from post p1_0 
left join comment c1_0 on p1_0.id=c1_0.post_id 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
where p1_0.id=?

Hibernate: 
select c1_0.post_id,c1_0.id,c1_0.content,c1_0.created_at,c1_0.updated_at 
from comment c1_0 
where c1_0.post_id=?

Hibernate: 
select pt1_0.post_id,pt1_0.id,pt1_0.created_at,pt1_0.tag_id 
from post_tag pt1_0 
where pt1_0.post_id=?

Hibernate: 
select t1_0.id,t1_0.name 
from tag t1_0 
where t1_0.id=?

Hibernate: 
select t1_0.id,t1_0.name 
from tag t1_0 
where t1_0.id=?

Hibernate: 
select t1_0.id,t1_0.name 
from tag t1_0 
where t1_0.id=?
```
## @BatchSize(size = 2) without FETCH
```java
@Query("SELECT p FROM Post p " +  
        "LEFT JOIN p.comments c " +  
        "LEFT JOIN p.postTags pt " +  
        "LEFT JOIN pt.tag " +  
        "WHERE p.id = :id")  
Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);
```

```log
Hibernate: 
select p1_0.id,p1_0.author,p1_0.content,p1_0.created_at,p1_0.title,p1_0.updated_at 
from post p1_0 
left join comment c1_0 on p1_0.id=c1_0.post_id 
left join post_tag pt1_0 on p1_0.id=pt1_0.post_id 
where p1_0.id=?

Hibernate: 
select c1_0.post_id,c1_0.id,c1_0.content,c1_0.created_at,c1_0.updated_at 
from comment c1_0 
where c1_0.post_id=?

Hibernate: 
select pt1_0.post_id,pt1_0.id,pt1_0.created_at,pt1_0.tag_id 
from post_tag pt1_0 
where pt1_0.post_id=?

Hibernate: 
select t1_0.id,t1_0.name 
from tag t1_0 
where t1_0.id=?

Hibernate: 
select t1_0.id,t1_0.name 
from tag t1_0 
where t1_0.id=?

Hibernate: 
select t1_0.id,t1_0.name 
from tag t1_0 
where t1_0.id=?
```
