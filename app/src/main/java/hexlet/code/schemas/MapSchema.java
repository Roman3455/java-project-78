package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema sizeof(int size) {
        checkList.put("sizeof", val -> val == null || val.size() == size);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <K, V> MapSchema shape(Map<K, BaseSchema<V>> schemas) {
        checkList.put("shape", map -> map != null && schemas.entrySet().stream()
                .allMatch(schema -> schema.getValue().isValid((V) map.get(schema.getKey()))));
        return this;

    }
}
