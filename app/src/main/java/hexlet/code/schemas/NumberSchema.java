package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        checkList.put("positive", val -> val == null || val > 0);
        return this;
    }

    public NumberSchema range(int startsWith, int endsWith) {
        checkList.put("range", val -> val == null || val >= startsWith && val <= endsWith);
        return this;
    }
}
