package ru.kosinov;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.SocketIOClient;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.springframework.boot.SpringApplication;
import ru.kosinov.entity.PointC2s;

import java.net.URISyntaxException;

/**
 * Created by wangqinghui on 2016/5/16.
 */
public class Client {

    public static void main(String[] args) throws URISyntaxException {

        final Socket socket = IO.socket("http://localhost:9092");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println("connect");
                socket.emit("foo", "hi");

                socket.emit("addridevent",JSON.toJSONString(new PointC2s(12.2D,33D)));

//                socket.disconnect();
            }


        }).on("event", new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        socket.connect();

    }
}
