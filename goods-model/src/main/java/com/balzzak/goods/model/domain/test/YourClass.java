package com.balzzak.goods.model.domain.test;

import lombok.Data;

import javax.persistence.*;

//@Entity
@IdClass(YourId.class)
public class YourClass {
    @Id
    @Column(name="YOUR_ID")
    private String yourId;

    @Id      // <--------------- 외래키 매핑
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "myId"),
            @JoinColumn(name = "aa")
    })
    private MyClass myclass;
}
