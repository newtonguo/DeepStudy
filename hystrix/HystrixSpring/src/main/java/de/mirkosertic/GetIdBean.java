package de.mirkosertic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Scope("singleton")
public class GetIdBean {

    private final Random random;

    public GetIdBean() {
        random = new Random();
    }

    @CircuitBreaker
    public String getId() {
        return UUID.randomUUID().toString();
    }
}
