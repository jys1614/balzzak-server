package com.balzzak.common.message.goods;

import com.balzzak.common.message.IName;
import com.balzzak.common.message.MessageSerializer;
import com.balzzak.common.utils.JsonUtil;

public class GoodsMessage extends MessageSerializer implements IName  {

    private static final String ROUTING_KEY = "balzzak.service.goods";

    public GoodsMessage() {
    }

    public GoodsMessage(GoodsMessageName msg, Object body) {
        this.key = ROUTING_KEY;
        this.name = msg.name();
        String json = JsonUtil.toJson(body);
        this.value = json;
    }

    @Override
    public GoodsMessageName getMessageName() {
        return GoodsMessageName.valueOf(this.name);
    }

}
