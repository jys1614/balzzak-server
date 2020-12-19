package com.balzzak.goods.model.domain.test2;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//@Entity
public class MyClass2 {

    @EmbeddedId
    private MyId2 id;


}
