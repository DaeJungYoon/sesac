package com.example.demo.myjpasitev3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV3 {
    private final EntityManager em;

    public PostJpaV3 save(PostJpaV3 post){
        em.persist(post);
        return post;
    }
    
    public List<PostJpaV3> getPosts(){
        return em.createQuery("SELECT p FROM PostJpaV3 p", PostJpaV3.class)
                .getResultList();
    }
}