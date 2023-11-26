package com.fornax.petware.Entity.AnimalPackage;

public class FilterAnimalBody {
    private long userId;
    private boolean getCoordinates;

    public FilterAnimalBody() {
    }

    public FilterAnimalBody(Long userId, boolean getCoordinates) {
        this.userId = userId;
        this.getCoordinates = getCoordinates;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isGetCoordinates() {
        return getCoordinates;
    }

    public void setGetCoordinates(boolean getCoordinates) {
        this.getCoordinates = getCoordinates;
    }
}
