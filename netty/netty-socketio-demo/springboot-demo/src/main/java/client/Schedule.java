package client;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.SocketIOServer;
import io.socket.client.Socket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kosinov.entity.PointC2s;

import javax.annotation.Resource;
import java.util.Random;

@Slf4j
@Component
public class Schedule {

    private final Socket socket;

    @Autowired
    public Schedule(Socket server) {
        this.socket = server;
    }



    @Scheduled(cron = "0/5 * * * * ?")
	public void updateRedis() {
        Random random = new Random();

        PointC2s c2s = new PointC2s( random.nextDouble(),random.nextDouble() );
        String str =  JSON.toJSONString( c2s );
        socket.emit("addridevent", str );
        log.info("send loc task, info:{}", str);
    }

}