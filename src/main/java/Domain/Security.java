package Domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Security {

    private final String symbol;
    private final double marketPercent;
    private final int bidSize;
    private final double bidPrice;
    private final int askSize;
    private final double askPrice;
    private final int volume;
    private final double lastSalePrice;
    private final int lastSaleSize;
    private final long lastSaleTime;
    private final long lastUpdated;
    private final String sector;
    private final String securityType;

    @JsonCreator
    public Security(@JsonProperty("symbol") String symbol, @JsonProperty("marketPercent") double marketPercent, @JsonProperty("bidSize") int bidSize,
                    @JsonProperty("bidPrice") double bidPrice, @JsonProperty("askSize") int askSize, @JsonProperty("askPrice") double askPrice,
                    @JsonProperty("volume") int volume, @JsonProperty("lastSalePrice") double lastSalePrice,
                    @JsonProperty("lastSaleSize") int lastSaleSize, @JsonProperty("lastSaleTime") long lastSaleTime,
                    @JsonProperty("lastUpdated") long lastUpdated, @JsonProperty("sector") String sector, @JsonProperty("securityType") String securityType) {
        this.symbol = symbol;
        this.marketPercent = marketPercent;
        this.bidSize = bidSize;
        this.bidPrice = bidPrice;
        this.askSize = askSize;
        this.askPrice = askPrice;
        this.volume = volume;
        this.lastSalePrice = lastSalePrice;
        this.lastSaleSize = lastSaleSize;
        this.lastSaleTime = lastSaleTime;
        this.lastUpdated = lastUpdated;
        this.sector = sector;
        this.securityType = securityType;
    }

    public String toString(){
        return String.format("%s: %s percent", symbol, marketPercent);
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMarketPercent() {
        return marketPercent;
    }

    public int getBidSize() {
        return bidSize;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public int getVolume() {
        return volume;
    }

    public double getLastSalePrice() {
        return lastSalePrice;
    }

    public int getLastSaleSize() {
        return lastSaleSize;
    }

    public long getLastSaleTime() {
        return lastSaleTime;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public String getSector() {
        return sector;
    }

    public String getSecurityType() {
        return securityType;
    }
}
