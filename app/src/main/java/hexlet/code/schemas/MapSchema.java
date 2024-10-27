package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public void sizeof(int size) {
        checkList.removeIf(checkList::contains);
        checkList.add(val -> val == null || val.size() == size);
    }
}
