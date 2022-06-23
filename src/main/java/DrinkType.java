public enum DrinkType {
    TEA("T"), HOT_CHOCOLATE("H"), COFFEE("C");

    private String value;

    DrinkType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
