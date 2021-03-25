package com.seongbindb.demospringdata;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@SuppressWarnings("ALL") // @AttributeOverride(name = "street", column = @Column(name = "home_street")) 에 빨간줄을 막기 위함
public class Account {

    @Id @GeneratedValue // (strategy = GenerationType.AUTO) default 값이 auto기 때문에 설정하지 않아도 됨
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // @Entity라 선언을 하였기 때문에 사실상 @Column이 생략되있는 거나 마찬가지

    private String password;

    @OneToMany (mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();














    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }


// Temperal()은 자바 8 이전 Date Calendar만가능 하지만 지금은 LocaldateTime @CreatedDate @ LastModifiedDate 등을 사용할 수 있다.

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @CreatedDate
    private LocalDateTime localDateTime = LocalDateTime.now();

    private String yes;

    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    public Account() {
    }

    // Getter setter는 컬럼 매핑에 필수가 아니다.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
