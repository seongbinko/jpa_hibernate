package com.seongbindb.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; // JPA의 핵심 api

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Post post = new Post();
        post.setTitle("Spring Data Jpa 언제 보나....");

        Comment comment = new Comment();
        comment.setComment("빨리 보고 싶어요");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("곧 보여드릴게요");
        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);




















        /*        Account account = new Account();
        account.setUsername("seongbin");
        account.setPassword("pass");

        Study study = new Study();
        study.setName("Spring Data JPA");

        // 객체 지향적으로 생각했을때 반드시 묶어줘야함
//        account.getStudies().add(study);
//        study.setOwner(account);
        account.addStudy(study);


        Study study2 = new Study();
        study2.setName("SpringBoot");
//        account.getStudies().add(study2);
//        study2.setOwner(account);
        account.addStudy(study2);

        // entityManager.persist(account); // 엔티티와 관련된 모든 작업들은 한 트랜잭션안에서 일어나야한다

        //jpa가 hibernate를 사용하기 때문에 하이버네이트 api로 등록하기
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
        session.save(study2);*/
    }
}
