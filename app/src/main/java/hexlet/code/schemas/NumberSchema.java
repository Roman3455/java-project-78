package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checkList.removeIf(checkList::contains);
        checkList.add(val -> val == null || val > 0);
        return this;
    }

    public NumberSchema range(int startsWith, int endsWith) {
        checkList.removeIf(checkList::contains);
        checkList.add(val -> val == null || val >= startsWith && val <= endsWith);
        return this;
    }
}
