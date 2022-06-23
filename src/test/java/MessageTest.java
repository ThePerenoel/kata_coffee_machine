import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest {

    @Nested
    @DisplayName("getStringCommand() should")
    class GetStringCommandShould {

        @Test
        void return_M_message_given_a_message() {
            Message message = new Message("My message");

            String stringCommand = message.getStringCommand();

            assertThat(stringCommand).isEqualTo("M:My message");
        }
    }

}