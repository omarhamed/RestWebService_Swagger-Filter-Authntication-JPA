package com.restwebservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "bookName")
    private String bookName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Department() {
    }

    public Department(Long id,String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}
