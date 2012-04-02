package com.lingona.es4j.sample.etishor.domainmodel.funds;


public class Ticker {

    public String symbol; // { get; private set; }

    public Ticker(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
