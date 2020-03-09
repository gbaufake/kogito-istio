package org.kogito.istio.service;

import org.kogito.istio.model.Order;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class OrderDeserializer extends JsonbDeserializer<Order> {
    public OrderDeserializer(){
        // pass the class to the parent.
        super(Order.class);
    }
}