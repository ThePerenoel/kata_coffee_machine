public class DrinkOrder {
    private DrinkType drinkType;
    private int numberOfSugar;

    public DrinkOrder(DrinkType drinkType, int numberOfSugar) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
    }

    public String getStringCommand() {
        if (numberOfSugar == 0) {
            return drinkType.getValue() + "::";
        }
        return drinkType.getValue() + ":" + numberOfSugar + ":0";
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType=" + drinkType +
                ", numberOfSugar=" + numberOfSugar +
                '}';
    }
}