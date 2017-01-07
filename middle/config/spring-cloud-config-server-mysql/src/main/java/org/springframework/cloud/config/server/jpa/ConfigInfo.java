package org.springframework.cloud.config.server.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "config_info")
public class ConfigInfo implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String application;
    @Column(name = "`profile'", nullable = false)
    private String profile;
    private String lable;

    @Column(name = "`key'", nullable = false)
    private String key;
    @Column(name = "`value'", nullable = false)
    private String value;
//    private String description;
//    private Integer delStatus;

}