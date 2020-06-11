package com.balzzak.common.message;

import lombok.Getter;

@Getter
public abstract class MessageBase {
    protected String name = "";
    protected String value = "";

    protected String key = "";
    private final String exchangeName = "balzzak.exchange";

    public MessageBase() {}

    protected Object getName() {
        return this.name;
    }
}
