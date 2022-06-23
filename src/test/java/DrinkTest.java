import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DrinkTest {

    @Nested
    @DisplayName("getStringCommand() should")
    class GetStringCommandShould {

        @ParameterizedTest
        @DisplayName("return the correct string command according to the drink")
        @MethodSource("namedArguments")
        void return_the_correct_string_command_according_to_the_drink(Payload payload) {
            String stringCommand = payload.drink.getStringCommand();
            assertThat(stringCommand).isEqualTo(payload.expectedCommand);
        }

        static Stream<Arguments> namedArguments() {
            return Stream.of(
                    Arguments.of(Named.of(
                            "return H:: when the drink is hot chocolate with no sugar",
                            new Payload(new Drink(DrinkType.HOT_CHOCOLATE, 0), "H::")
                    )), Arguments.of(Named.of(
                            "return H:1:0 when the drink is hot chocolate with one sugar",
                            new Payload(new Drink(DrinkType.HOT_CHOCOLATE, 1), "H:1:0")
                    )), Arguments.of(Named.of(
                            "return H:2:0 when the drink is hot chocolate with 2 sugars",
                            new Payload(new Drink(DrinkType.HOT_CHOCOLATE, 2), "H:2:0")
                    )), Arguments.of(Named.of(
                            "return T:: when the drink is tea with no sugar",
                            new Payload(new Drink(DrinkType.TEA, 0), "T::")
                    )), Arguments.of(Named.of(
                            "return T:1:0 when the drink is tea with 1 sugar",
                            new Payload(new Drink(DrinkType.TEA, 1), "T:1:0")
                    )), Arguments.of(Named.of(
                            "return T:2:0 when the drink is tea with 2 sugars",
                            new Payload(new Drink(DrinkType.TEA, 2), "T:2:0")
                    )), Arguments.of(Named.of(
                            "return C:: when the drink is coffee with no sugar",
                            new Payload(new Drink(DrinkType.COFFEE, 0), "C::")
                    )), Arguments.of(Named.of(
                            "return C:1:0 when the drink is coffee with no sugar",
                            new Payload(new Drink(DrinkType.COFFEE, 1), "C:1:0")
                    )), Arguments.of(Named.of(
                            "return C:2:0 when the drink is coffee with no sugar",
                            new Payload(new Drink(DrinkType.COFFEE, 2), "C:2:0")
                    ))
            );
        }

        private static class Payload {
            Drink drink;
            String expectedCommand;

            public Payload(Drink drink, String expectedCommand) {
                this.drink = drink;
                this.expectedCommand = expectedCommand;
            }
        }
    }

}
