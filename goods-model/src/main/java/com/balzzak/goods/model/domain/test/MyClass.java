package com.balzzak.goods.model.domain.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

//@Entity
@IdClass(MyId.class)
public class MyClass {

    @Id
    @Column(name="myId")
    private String myId;

    @Id
    @Column(name="aa")
    private String aa;

}
