package com.lulz_bot.Server;

public class Item {
    private String name;
    private String seller;
    private String buyer;

    private int cost;

    Item(String name, String seller, int cost) {
        this.name = name;
        this.seller = seller;
        this.cost = cost;
    }


}
