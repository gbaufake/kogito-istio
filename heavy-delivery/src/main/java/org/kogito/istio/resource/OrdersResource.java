package org.kogito.istio.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kogito.istio.model.Order;
import org.kogito.istio.service.DeliveryService;
import org.kogito.istio.service.OrderService;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.OnOverflow;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdersResource {
    

    @Inject 
    @Channel("orders") 
    Emitter<Order> orderEmitter;

    @Inject
    OrderService deliveryService;

    // @GET
    // @Path("/{id}")
    // public Order getOrder(@PathParam String id) {   
    //     return deliveryService.retrieveOrder(id);
    // }

    @POST
    public Order createOrder(Order order) {    
        order = deliveryService.registerOrder(order);
        orderEmitter.send(order);
        return order;
    }
}