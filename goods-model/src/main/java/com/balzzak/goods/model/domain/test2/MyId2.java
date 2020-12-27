package com.balzzak.goods.model.domain.test2;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MyId2 implements Serializable {

    private String aa;

    @Column(name = "myId")
    private String id;
}
