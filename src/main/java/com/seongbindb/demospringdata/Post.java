package com.seongbindb.demospringdata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    // CascadeType.REMOVE 삭제될 때 같이 삭제 시킴
    // 보통은 CascadeType을 ALL로 설정함
    @OneToMany(mappedBy = "post" , cascade = CascadeType.PERSIST)
    private Set<Comment> comment = new HashSet<>();

    // convinent method
    public void addComment(Comment comment) {
        this.getComment().add(comment);
        comment.setPost(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }
}
