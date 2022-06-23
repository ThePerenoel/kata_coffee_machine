public enum DrinkType {
    TEA("T"), HOT_CHOCOLATE("H");

    private String value;

    DrinkType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
