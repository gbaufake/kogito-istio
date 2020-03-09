package org.kogito.istio.model;

import java.io.Serializable;
import java.util.ArrayList;

import io.quarkus.runtime.annotations.RegisterForReflection;


@RegisterForReflection
public class Order implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String id;
    public ArrayList<Parcel> items;
    public String origin;
    public String destination;
    public String status;
    
    
    public Order() {
    }
    
    public Order(String id) {
        this.id = id;
    }
    

	@Override
	public String toString() {
		return "Order [destination=" + destination + ", id=" + id + ", items=" + items + ", origin=" + origin
				+ ", status=" + status + "]";
	}
}