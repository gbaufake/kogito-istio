package org.kogito.istio.model;


import java.time.Duration;

public class Route {
    public Route(Truck truck, String origin, String destination, Duration duration) {
        this.truck = truck;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }
	public String origin;
    public String destination;
    public Truck truck; 
    public Duration duration;
}