package ru.kosinov.handler;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kosinov.ChatObject;
import ru.kosinov.entity.PointC2s;
import ru.kosinov.util.SerializeUtil;


@Slf4j
@Component
public class ChatEventHandler {

    private final SocketIOServer server;

    @Autowired
    public ChatEventHandler(SocketIOServer server) {
        this.server = server;
    }

    @OnEvent(value = "chatevent")
    public void onEvent(SocketIOClient client, AckRequest request, ChatObject data) {

        log.info("rec chatevent:" + JSON.toJSONString(data));
        server.getBroadcastOperations().sendEvent("chatevent", data);
    }

    @OnEvent(value = "addridevent")
    public void addridevent(SocketIOClient client, AckRequest request, String data) {

        log.info("rec addridevent:" + data);

        PointC2s c2s = JSON.parseObject(data, PointC2s.class);
        String retStr = c2s.getLat() + "," + c2s.getLon();
        client.sendEvent( "pushpoint", retStr );

    }

}
