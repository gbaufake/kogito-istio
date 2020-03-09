package org.kogito.istio.model;

import java.io.Serializable;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Parcel implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String id;
    public String height;
    public String width;
    public String depth;
    public String weight;
    // public float girth; 
}