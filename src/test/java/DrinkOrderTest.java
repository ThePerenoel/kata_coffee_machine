import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DrinkOrderTest {

    @Nested
    @DisplayName("getStringCommand() should")
    class GetStringCommandShould {

        @ParameterizedTest
        @DisplayName("return the correct string command according to the drink")
        @MethodSource("namedArguments")
        void return_the_correct_string_command_according_to_the_drink(Payload payload) {
            String stringCommand = payload.drinkOrder.getStringCommand();
            assertThat(stringCommand).isEqualTo(payload.expectedCommand);
        }

        static Stream<Arguments> namedArguments() {
            return Stream.of(
                    Arguments.of(Named.of(
                            "return H:: when the drink is hot chocolate with no sugar",
                            Payload.of(DrinkType.HOT_CHOCOLATE, 0, new BigDecimal("0.50"), "H::")
                    )), Arguments.of(Named.of(
                            "return H:1:0 when the drink is hot chocolate with one sugar",
                            Payload.of(DrinkType.HOT_CHOCOLATE, 1, new BigDecimal("0.50"), "H:1:0")
                    )), Arguments.of(Named.of(
                            "return H:2:0 when the drink is hot chocolate with 2 sugars",
                            Payload.of(DrinkType.HOT_CHOCOLATE, 2, new BigDecimal("0.50"), "H:2:0")
                    )), Arguments.of(Named.of(
                            "return T:: when the drink is tea with no sugar",
                            Payload.of(DrinkType.TEA, 0, new BigDecimal("0.40"), "T::")
                    )), Arguments.of(Named.of(
                            "return T:1:0 when the drink is tea with 1 sugar",
                            Payload.of(DrinkType.TEA, 1, new BigDecimal("0.40"), "T:1:0")
                    )), Arguments.of(Named.of(
                            "return T:2:0 when the drink is tea with 2 sugars",
                            Payload.of(DrinkType.TEA, 2, new BigDecimal("0.40"), "T:2:0")
                    )), Arguments.of(Named.of(
                            "return C:: when the drink is coffee with no sugar",
                            Payload.of(DrinkType.COFFEE, 0, new BigDecimal("0.60"), "C::")
                    )), Arguments.of(Named.of(
                            "return C:1:0 when the drink is coffee with no sugar",
                            Payload.of(DrinkType.COFFEE, 1, new BigDecimal("0.60"), "C:1:0")
                    )), Arguments.of(Named.of(
                            "return C:2:0 when the drink is coffee with no sugar",
                            Payload.of(DrinkType.COFFEE, 2, new BigDecimal("0.60"), "C:2:0")
                    )), Arguments.of(Named.of(
                            "return M:Missing 0.10 euros when the drink is coffee with 0.50 euros",
                            Payload.of(DrinkType.COFFEE, 0, new BigDecimal("0.50"), "M:Missing 0.10 euros")
                    )), Arguments.of(Named.of(
                            "return M:Missing 0.40 euros when the drinkOrder is tea with 0.00 euros",
                            Payload.of(DrinkType.TEA, 0, new BigDecimal("0.00"), "M:Missing 0.40 euros")
                    )), Arguments.of(Named.of(
                            "return H:: when the drink is hot chocolate with no sugar",
                            Payload.of(DrinkType.HOT_CHOCOLATE, 0, new BigDecimal("1.10"), "H::")
                    ))
            );
        }

        private static class Payload {
            DrinkOrder drinkOrder;
            String expectedCommand;

            private Payload(DrinkOrder drinkOrder, String expectedCommand) {
                this.drinkOrder = drinkOrder;
                this.expectedCommand = expectedCommand;
            }

            public static Payload of(DrinkType drinkType, int numberOfSugar, BigDecimal givenMoney, String expectedCommand) {
                DrinkOrder drinkOrder = new DrinkOrder(drinkType, numberOfSugar, givenMoney);
                return new Payload(drinkOrder, expectedCommand);
            }
        }
    }
}
