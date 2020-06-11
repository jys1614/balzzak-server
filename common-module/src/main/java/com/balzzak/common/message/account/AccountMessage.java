package com.balzzak.common.message.account;

import com.balzzak.common.message.IName;
import com.balzzak.common.message.MessageSerializer;
import com.balzzak.common.message.goods.GoodsMessageName;
import com.balzzak.common.utils.JsonUtil;

public class AccountMessage extends MessageSerializer {

    private static final String ROUTING_KEY = "balzzak.service.account";

    public AccountMessage() {
    }

    public AccountMessage(AccountMessageName msg, Object body) {
        this.key = ROUTING_KEY;
        this.name = msg.name();
        String json = JsonUtil.toJson(body);
        this.value = json;
    }

    @Override
    public AccountMessageName getName() {
        return AccountMessageName.valueOf(super.getName().toString());
    }
}
