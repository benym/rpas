package com.benym.rpas.architecture.pojo;

/**
 * @date 2022/7/26 7:00 下午
 */
public class Dependency {

    private Consul consul;

    private Feign feign;

    public Consul getConsul() {
        return consul;
    }

    public void setConsul(Consul consul) {
        this.consul = consul;
    }

    public Feign getFeign() {
        return feign;
    }

    public void setFeign(Feign feign) {
        this.feign = feign;
    }
}
