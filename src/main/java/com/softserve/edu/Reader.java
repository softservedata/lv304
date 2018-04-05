package com.softserve.edu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "READER")
public class Reader {
    @Id
    @Column(name = "IDREADER")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReader;
    @Column(name = "NAME", length = 64)
    private String name;

    public Long getIdReader() {
        return idReader;
    }

    public void setIdReader(Long idReader) {
        this.idReader = idReader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
