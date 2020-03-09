package org.kogito.istio.service;

import javax.enterprise.context.ApplicationScoped;

import org.kogito.istio.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.Stores;

import io.quarkus.kafka.client.serialization.JsonbSerde;


import io.quarkus.kafka.client.serialization.JsonbSerde;

@ApplicationScoped
public class DeliveryService {
    // Include Infinispan, Kafka and Jaeger
    private static final Logger LOG = LoggerFactory.getLogger(DeliveryService.class);

    private static final String ORDERS_TOPIC = "orders";

    // public void deliver() {
    //     StreamsBuilder builder = new StreamsBuilder();

    //     JsonbSerde<Order> ordersSerde = new JsonbSerde<>(
    //             Order.class);

    //     GlobalKTable<String, Orders> stations = builder.globalTable( 
    //         ORDERS_TOPIC,
    //         Consumed.with(Serdes.Integer(), ordersSerde));
    //     // order.status = "delivered";
    //     // LOG.warn(order.toString());
    // }
}