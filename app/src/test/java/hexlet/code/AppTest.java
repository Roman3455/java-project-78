package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    Validator validator = new Validator();

    @Test
    void testStringSchema() {
        var schema = validator.string();

        var actual1 = schema.isValid("");
        var actual2 = schema.isValid(null);
        assertThat(actual1).isTrue();
        assertThat(actual2).isTrue();

        schema.required();

        var actual3 = schema.isValid(null);
        var actual4 = schema.isValid("");
        var actual5 = schema.isValid("hexlet");
        assertThat(actual3).isFalse();
        assertThat(actual4).isFalse();
        assertThat(actual5).isTrue();

        var actual6 = schema.contains("what").isValid("what does the fox say");
        var actual7 = schema.contains("whatthe").isValid("what does the fox say");
        assertThat(actual6).isTrue();
        assertThat(actual7).isFalse();

        var actual8 = schema.isValid("what does the fox say");
        assertThat(actual8).isFalse();

        var schema1 = validator.string();

        var actual9 = schema1.minLength(10).minLength(4).isValid("Hexlet");
        var actual10 = schema1.contains("whatthe").contains("Hex").isValid("Hexlet");
        assertThat(actual9).isTrue();
        assertThat(actual10).isTrue();
    }
}
