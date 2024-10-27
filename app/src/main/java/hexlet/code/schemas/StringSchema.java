package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        checkList.put("required", val -> val != null && !val.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        checkList.put("minLength", val -> val == null || val.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        checkList.put("contains", val -> val == null || val.contains(substring));
        return this;
    }
}
