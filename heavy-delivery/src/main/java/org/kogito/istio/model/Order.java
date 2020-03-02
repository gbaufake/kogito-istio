package org.kogito.istio.model;

import java.util.ArrayList;


public class Order  {
    public String id;
    public ArrayList<Parcel> items;
    public String origin;
    public String destination;
    public String status;
}