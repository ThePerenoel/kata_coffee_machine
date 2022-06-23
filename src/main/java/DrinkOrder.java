import java.math.BigDecimal;

public class DrinkOrder {
    public static final String NO_SUGAR_SEPARATOR = "::";
    public static final String SEPARATOR = ":";
    public static final String ONE_STICK = ":0";
    private DrinkType drinkType;
    private int numberOfSugar;
    private BigDecimal givenMoney;

    public DrinkOrder(DrinkType drinkType, int numberOfSugar, BigDecimal givenMoney) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        this.givenMoney = givenMoney;
    }

    public String getStringCommand() {
        if (numberOfSugar == 0) {
            return drinkType.getValue() + NO_SUGAR_SEPARATOR;
        }
        return drinkType.getValue() + SEPARATOR + numberOfSugar + ONE_STICK;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType=" + drinkType +
                ", numberOfSugar=" + numberOfSugar +
                '}';
    }
}
