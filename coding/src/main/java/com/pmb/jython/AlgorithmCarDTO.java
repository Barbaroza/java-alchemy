package com.pmb.jython;

import java.util.List;

/**
 * @author lvrui
 */
public class AlgorithmCarDTO {
    private Long id;
    private Integer capacity;
    private Integer max_capacity;
    private List<Long> load_order_list;
    private List<Long> matched_not_load_order_list;
    private Long location;
    private Long route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(Integer max_capacity) {
        this.max_capacity = max_capacity;
    }

    public List<Long> getLoad_order_list() {
        return load_order_list;
    }

    public void setLoad_order_list(List<Long> load_order_list) {
        this.load_order_list = load_order_list;
    }

    public List<Long> getMatched_not_load_order_list() {
        return matched_not_load_order_list;
    }

    public void setMatched_not_load_order_list(List<Long> matched_not_load_order_list) {
        this.matched_not_load_order_list = matched_not_load_order_list;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Long getRoute() {
        return route;
    }

    public void setRoute(Long route) {
        this.route = route;
    }
}
