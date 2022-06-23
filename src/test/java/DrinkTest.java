import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DrinkTest {

    @Nested
    @DisplayName("getStringCommand() should")
    class GetStringCommandShould {

        @Test
        @DisplayName("return H:: given hot chocolate with no sugar")
        void return_H_given_hot_chocolate_with_no_sugar() {
            Drink hotChocolateWithoutSugar = new Drink(DrinkType.HOT_CHOCOLATE, 0);
            String expectedStringCommand = "H::";

            String stringCommand = hotChocolateWithoutSugar.getStringCommand();

            assertThat(stringCommand).isEqualTo(expectedStringCommand);
        }

        @Test
        @DisplayName("return H:1:0 given hot chocolate with one sugar")
        void return_H10_given_hot_chocolate_with_one_sugar() {
            Drink hotChocolateWithoutSugar = new Drink(DrinkType.HOT_CHOCOLATE, 1);
            String expectedStringCommand = "H:1:0";

            String stringCommand = hotChocolateWithoutSugar.getStringCommand();

            assertThat(stringCommand).isEqualTo(expectedStringCommand);
        }
    }

}
