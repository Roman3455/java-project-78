package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checkList = new HashMap<>();

    public final boolean isValid(T value) {
        return checkList.values().stream().allMatch(check -> check.test(value));
    }

    public abstract BaseSchema<T> required();
}
