package com.myfeike.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by serv on 14-5-18.
 */
@Entity(name = "test_my_table111")
public class TestTable {
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "MEMO_TEST")
    private String memo_test;
    @Column(name = "title")
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo_test() {
        return memo_test;
    }

    public void setMemo_test(String memo_test) {
        this.memo_test = memo_test;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
