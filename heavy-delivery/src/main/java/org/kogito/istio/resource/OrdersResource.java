package org.kogito.istio.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kogito.istio.model.Order;
import org.kogito.istio.service.DeliveryService;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdersResource {
    
    @Inject
    DeliveryService deliveryService;

    @GET
    @Path("/{id}")
    public Order getOrder(@PathParam String id) {   
        return deliveryService.retrieveOrder(id);
    }

    @POST
    public Order createOrder(Order order) {   
        return deliveryService.registerOrder(order);
    }
}