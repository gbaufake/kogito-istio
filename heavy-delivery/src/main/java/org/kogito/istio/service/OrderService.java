package org.kogito.istio.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.kogito.istio.model.Order;
import org.kogito.istio.model.Parcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.smallrye.reactive.messaging.annotations.Merge;
import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import jdk.internal.jline.internal.Log;

@ApplicationScoped
public class OrderService {
    // Include Infinispan, Kafka and Jaeger
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private Set<Order> orders = Collections.synchronizedSet(new LinkedHashSet<>());


     // @Outgoing("orders-received")
    // @Broadcast
    public Order registerOrder(Order order) {
        order.status = "created";
        order.id = UUID.randomUUID().toString();
        for (Parcel parcel : order.items) {
            parcel.id =  UUID.randomUUID().toString();
        }
        orders.add(order);
        LOG.warn(order.toString());
        return order;
    } 

    @Incoming("orders")
    @Outgoing("orders-received")
    @Merge
    @Broadcast
    public Order dispatchOrders(Order order) {
        return order;
    }


    // @Outgoing("orders")
    // @Broadcast
    // public Flowable<KafkaMessage<String, Order>> dispatchOrders() {
    //     List<KafkaMessage<String, Order>> kafkaList = new ArrayList<>();
    //     for (Order order : orders) {
    //         KafkaMessage<String, Order> kafkaMessage = KafkaMessage.of(order.id, order);
    //         kafkaList.add(kafkaMessage);
    //     }
    //     Flowable<KafkaMessage<String, Order>> flowable = Flowable.fromIterable(kafkaList);
    //     Flowable.interval(500, TimeUnit.MILLISECONDS);
    //     return flowable;
    // }
}