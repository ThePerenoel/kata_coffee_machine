import java.math.BigDecimal;

public enum DrinkType {
    TEA("T", new BigDecimal("0.40")),
    HOT_CHOCOLATE("H", new BigDecimal("0.50")),
    COFFEE("C", new BigDecimal("0.60")),
    ORANGE_JUICE("O", new BigDecimal("0.60"));

    private String value;
    private BigDecimal price;

    DrinkType(String value, BigDecimal price) {
        this.value = value;
        this.price = price;
    }

    public String getValue() {
        return value;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
