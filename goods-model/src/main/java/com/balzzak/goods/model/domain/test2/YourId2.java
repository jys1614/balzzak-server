package com.balzzak.goods.model.domain.test2;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class YourId2 implements Serializable {

    private String myId;

    @Column(name = "yourId")
    private String yourId;
}
