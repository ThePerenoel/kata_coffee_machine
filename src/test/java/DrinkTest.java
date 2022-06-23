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
            Drink hotChocolateWithoutSugar = new Drink(DrinkType.HOT_CHOCOLATE);
            String expectedStringCommand = "H::";

            String stringCommand = hotChocolateWithoutSugar.getStringCommand();

            assertThat(stringCommand).isEqualTo(expectedStringCommand);
        }
    }

}
