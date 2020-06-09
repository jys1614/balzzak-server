package com.balzzak.common.message;

import lombok.Getter;

@Getter
public class MessageBase {
    protected String name = "";
    protected String key = "";
    protected String value = "";
    private final String exchangeName = "balzzak.exchange";

    public MessageBase() {}
}
