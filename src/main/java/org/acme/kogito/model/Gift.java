
package org.acme.kogito.model;

public class Gift {
    private String name;
    private boolean christmasGift;

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChristmasGift() {
        return christmasGift;
    }

    public void setChristmasGift(boolean christmasGift) {
        this.christmasGift = christmasGift;
    }

    @Override
	public String toString() {
		return "Gift [name=" + name + ",]";
	}

    
}