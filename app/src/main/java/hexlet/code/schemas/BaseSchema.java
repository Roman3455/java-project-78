package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected final List<Predicate<T>> checkList = new ArrayList<>();
    protected boolean isRequired = false;

    public boolean isValid(T value) {
        if (!isRequired && (value == null || (value instanceof String && ((String) value).isEmpty()))) {
            return true;
        }
        return checkList.stream().allMatch(check -> check.test(value));
    }

    public void required() {
        isRequired = true;
        checkList.add(Objects::nonNull);
    }
}
