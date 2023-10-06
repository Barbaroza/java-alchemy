package com.pmb.jython;

import java.util.List;

/**
 * @author lvrui
 */
public class AlgorithmRouteDTO {
    private Integer id;
    private List<Long> node;
    private List<Integer> interval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Long> getNode() {
        return node;
    }

    public void setNode(List<Long> node) {
        this.node = node;
    }

    public List<Integer> getInterval() {
        return interval;
    }

    public void setInterval(List<Integer> interval) {
        this.interval = interval;
    }
}
