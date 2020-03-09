package org.kogito.istio.service;

import org.kogito.istio.model.Order;

import io.quarkus.kafka.client.serialization.JsonbSerializer;

public class OrderSerializer extends JsonbSerializer<Order> {
    public OrderSerializer(){
        // pass the class to the parent.
        super();
    }
}