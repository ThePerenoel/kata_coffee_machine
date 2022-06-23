public class Drink {
    private DrinkType drinkType;

    public Drink(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String getStringCommand() {
        return "H::";
    }
}
