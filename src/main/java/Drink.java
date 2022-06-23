public class Drink {
    private DrinkType drinkType;
    private int numberOfSugar;

    public Drink(DrinkType drinkType, int numberOfSugar) {
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
    }

    public String getStringCommand() {
        if (numberOfSugar == 0) {
            return "H::";
        }
        return "H:" + numberOfSugar + ":0";
    }
}
