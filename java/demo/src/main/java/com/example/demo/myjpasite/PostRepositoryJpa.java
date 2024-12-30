package com.example.demo.myjpasite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryJpa extends JpaRepository<PostJpa, Long> {

}
