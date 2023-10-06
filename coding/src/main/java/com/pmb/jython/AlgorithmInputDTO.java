package com.pmb.jython;

import java.util.List;

/**
 * @author lvrui
 */
public class AlgorithmInputDTO {
    private List<AlgorithmCarDTO> cars;
    private List<AlgorithmRouteDTO> routes;
    private List<AlgorithmOrderDTO> orders;

    public List<AlgorithmCarDTO> getCars() {
        return cars;
    }

    public void setCars(List<AlgorithmCarDTO> cars) {
        this.cars = cars;
    }

    public List<AlgorithmRouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<AlgorithmRouteDTO> routes) {
        this.routes = routes;
    }

    public List<AlgorithmOrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<AlgorithmOrderDTO> orders) {
        this.orders = orders;
    }
}
