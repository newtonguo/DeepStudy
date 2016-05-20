package client;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.kosinov.entity.PointC2s;

import java.net.URISyntaxException;

/**
 * Created by wangqinghui on 2016/5/16.
 */
@Slf4j
@ComponentScan("client")
@EnableScheduling
@SpringBootApplication
public class SocketClientApplication {

    @Value("${wss.server.url}")
    private String url;

    @Bean
    public Socket client() throws URISyntaxException {

        final Socket socket = IO.socket(url);
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println("connect");
                socket.emit("foo", "hi");

                socket.emit("addrid",JSON.toJSONString(new PointC2s(12.2D,33D)));

//                socket.disconnect();
            }


        }).on("addrid", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                log.info("rec server response:{}",JSON.toJSONString(args));
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                log.error("disconnect to server.");
            }

        });

        socket.connect();

        log.info("program main end.");
        return socket;

    }

//    @Bean
//    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer ssrv) {
//        return new SpringAnnotationScanner(ssrv);
//    }

    public static void main(String[] args) throws URISyntaxException {

            SpringApplication.run(SocketClientApplication.class, args);


    }


}

