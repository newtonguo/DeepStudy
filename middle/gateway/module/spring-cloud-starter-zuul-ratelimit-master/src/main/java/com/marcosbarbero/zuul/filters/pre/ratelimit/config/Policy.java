package com.marcosbarbero.zuul.filters.pre.ratelimit.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A policy is used to define rate limit constraints within RateLimiter implementations
 *
 * @author Marcos Barbero
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    private Long refreshInterval = 60L;
    private Long limit;
    private List<Type> type = new ArrayList<>();

    public enum Type {
        ORIGIN, USER
    }

}
