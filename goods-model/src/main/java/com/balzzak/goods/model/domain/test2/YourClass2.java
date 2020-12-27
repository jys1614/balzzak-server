package com.balzzak.goods.model.domain.test2;

import javax.persistence.*;

//@Entity
public class YourClass2 {

    @EmbeddedId
    private YourId2 yourid;

    @MapsId(value = "myId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "myId"),
            @JoinColumn(name = "aa")
    })
    private MyClass2 myClass;
}
