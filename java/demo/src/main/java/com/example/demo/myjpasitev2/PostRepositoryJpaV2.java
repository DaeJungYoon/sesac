package com.example.demo.myjpasitev2;

import com.example.demo.mysite.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV2{

    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 post){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(post); // 저장

            tx.commit();
            return post;

        } catch (Exception e){
            tx.rollback();
            throw e;

        } finally {
            em.close();
        }
    }

    public PostJpaV2 getPostById(Long id){
        EntityManager em = emf.createEntityManager();
        try{
           return em.find(PostJpaV2.class, id);
        }finally {
            em.close();
        }
    }
    public List<PostJpaV2> getPosts(){
        EntityManager em = emf.createEntityManager();
        // post에서 모든 데이터를 가져오고 싶어
        // SELLECT * FROM entity
        try {
        return em.createQuery("SELECT p FROM PostJpaV2 p", PostJpaV2.class)
                .getResultList();
        }finally {
            em.close();
        }
    }
    public PostJpaV2 update(Long id, PostJpaV2 updatedPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
//            업데이트할 entity를 가져온다
            PostJpaV2 post = em.find(PostJpaV2.class, id);

//            수정한다
            String title = updatedPost.getTitle();
            String content = updatedPost.getContent();

            post.update(title, content);

            tx.commit();
            return post;
        }catch (Exception e){
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }
    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            PostJpaV2 post = em.find(PostJpaV2.class, id);
            em.remove(post);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}