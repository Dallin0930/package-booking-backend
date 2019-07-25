package com.oocl.packagebooking.modle;

import javax.persistence.*;
import java.util.List;

@Entity
public class LuggageStroe {
    @Id
    @GeneratedValue
    long storeId;
    String storeName;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Luggage> luggages;


    public LuggageStroe() {
    }

    public List<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(List<Luggage> luggages) {
        this.luggages = luggages;
    }

    public LuggageStroe(String storeName) {
        this.storeName = storeName;
    }

    public long getStoreId(long l) {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
