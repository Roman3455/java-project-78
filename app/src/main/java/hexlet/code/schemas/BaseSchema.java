package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checkList = new HashMap<>();

    public boolean isValid(T value) {
        return checkList.values().stream().allMatch(check -> check.test(value));
    }

    public BaseSchema<T> required() {
        checkList.put("required", Objects::nonNull);
        return this;
    }
}
