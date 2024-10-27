package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    @Override
    public void required() {
        isRequired = true;
        checkList.add(val -> val != null && !val.isEmpty());
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
