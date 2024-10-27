package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private final List<Predicate<String>> checkList = new ArrayList<>();
    private boolean isRequired = false;

    public boolean isValid(String value) {
        if (!isRequired && (value == null || value.isEmpty())) {
            return true;
        }
        return checkList.stream().allMatch(check -> check.test(value));
    }

    public StringSchema required() {
        isRequired = true;
        checkList.add(val -> val != null && !val.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        checkList.removeIf(checkList::contains);
        checkList.add(val -> val == null || val.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        checkList.removeIf(checkList::contains);
        checkList.add(val -> val == null || val.contains(substring));
        return this;
    }
}
