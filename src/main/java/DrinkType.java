import java.math.BigDecimal;

public enum DrinkType {
    TEA("T", new BigDecimal("0.40")),
    HOT_CHOCOLATE("H", new BigDecimal("0.50")),
    COFFEE("C", new BigDecimal("0.60")),
    ORANGE_JUICE("O", new BigDecimal("0.60")),
    EXTRA_HOT_COFFEE("Ch", new BigDecimal("0.60")),
    EXTRA_HOT_HOT_CHOCOLATE("Hh", new BigDecimal("0.50")),
    EXTRA_HOT_TEA("Th", new BigDecimal("0.40"));

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
