package org.kogito.istio.service;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.kogito.istio.model.Order;
import org.kogito.istio.model.Parcel;
import org.kogito.istio.model.Route;
import org.kogito.istio.model.Truck;

@ApplicationScoped
public class DeliveryService {
    // Include Infinispan, Kafka and Jaeger

    private Set<Truck> trucks = Collections.synchronizedSet(new LinkedHashSet<>());
    private Set<Order> orders = Collections.synchronizedSet(new LinkedHashSet<>());


    public DeliveryService() {
        trucks.add(new Truck("AMF T61", "Ford Transit Cargo Van"));
    }

    public Order registerOrder(Order order) {
        order.status = "created";
        order.id = UUID.randomUUID().toString();
        for (Parcel parcel : order.items) {
            parcel.id =  UUID.randomUUID().toString();
        }
        orders.add(order);
        deliverOrder(order);
        return order;
    }   
    
	private void deliverOrder(Order order) {
        Route route = new Route(trucks.iterator().next(), order.origin, order.destination, Duration.ofMinutes(1));
        try {
            TimeUnit.MINUTES.sleep(1);
            order.status = "delivered";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public Order retrieveOrder(String id) {
        for (Order order : orders) {
            if (order.id == id) {
                return order;
            }
        }
		return null;
	}
    
}