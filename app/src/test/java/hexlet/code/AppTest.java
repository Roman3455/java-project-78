package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    void testSayHi() {
        var expected = "Hi";
        var actual = App.sayHi();
        assertThat(actual).isEqualTo(expected);
    }
}
