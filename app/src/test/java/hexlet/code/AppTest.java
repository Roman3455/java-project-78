package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    void testNumberSchema() {
        var schema = validator.number();

        var actual1 = schema.isValid(5);
        var actual2 = schema.isValid(null);
        var actual3 = schema.positive().isValid(null);
        assertThat(actual1).isTrue();
        assertThat(actual2).isTrue();
        assertThat(actual3).isTrue();

        schema.required();

        var actual4 = schema.isValid(null);
        var actual5 = schema.isValid(10);
        var actual6 = schema.isValid(-10);
        var actual7 = schema.isValid(0);
        assertThat(actual4).isFalse();
        assertThat(actual5).isTrue();
        assertThat(actual6).isFalse();
        assertThat(actual7).isFalse();

        schema.range(5, 10);

        var actual8 = schema.isValid(5);
        var actual9 = schema.isValid(10);
        var actual10 = schema.isValid(4);
        var actual11 = schema.isValid(11);
        assertThat(actual8).isTrue();
        assertThat(actual9).isTrue();
        assertThat(actual10).isFalse();
        assertThat(actual11).isFalse();
    }

    @Test
    void testMapSchema1() {
        var schema = validator.map();

        var actual1 = schema.isValid(null);
        assertThat(actual1).isTrue();

        schema.required();

        var actual2 = schema.isValid(null);
        var actual3 = schema.isValid(new HashMap<>());
        assertThat(actual2).isFalse();
        assertThat(actual3).isTrue();

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        var actual4 = schema.isValid(data);
        assertThat(actual4).isTrue();

        schema.sizeof(2);

        var actual5 = schema.isValid(data);
        assertThat(actual5).isFalse();
        data.put("key2", "value2");
        var actual6 = schema.isValid(data);
        assertThat(actual6).isTrue();
    }

    @Test
    void testMapSchema2() {
        var schema = validator.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        var actual1 = schema.isValid(human1);
        assertThat(actual1).isTrue();

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        var actual2 = schema.isValid(human2);
        assertThat(actual2).isFalse();

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        var actual3 = schema.isValid(human3);
        assertThat(actual3).isFalse();
    }
}
