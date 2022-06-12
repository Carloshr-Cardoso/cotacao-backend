package com.carlosdev.cotacaobackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cotacao {
    public final String code;
    public final String codein;
    public final String name;
    public final String high;
    public final String low;
    public final String pctChange;
    public final String bid;
    public final String ask;
    public final String varBid;
    public final String timestamp;
    public final String create_date;



    public Cotacao(@JsonProperty("code") String code,
                   @JsonProperty("codein") String codein,
                   @JsonProperty("name") String name,
                   @JsonProperty("high") String high,
                   @JsonProperty("low") String low,
                   @JsonProperty("pctChange") String pctChange,
                   @JsonProperty("bid") String bid,
                   @JsonProperty("ask") String ask,
                   @JsonProperty("varBid") String varBid,
                   @JsonProperty("timestamp") String timestamp,
                   @JsonProperty("create_date") String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.varBid = varBid;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }
}