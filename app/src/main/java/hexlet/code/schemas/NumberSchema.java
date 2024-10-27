package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    @Override
    public BaseSchema<Integer> required() {
        checkList.put("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        checkList.put("positive", val -> val == null || val > 0);
        return this;
    }

    public NumberSchema range(int startsWith, int endsWith) {
        checkList.put("range", val -> val == null || val >= startsWith && val <= endsWith);
        return this;
    }
}
