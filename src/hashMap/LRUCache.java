package hashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    LinkedHashMap<Integer, Integer> isbnToPrice;

    LRUCache(final int capacity) {
        this.isbnToPrice
                = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            @Override

            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return this.size() > capacity;
            }
        };
    }

    public Integer lookup(Integer key) {
        if (!isbnToPrice.containsKey(key)) {
            return null;
        }
        return isbnToPrice.get(key);
    }

    public Integer insert(Integer key, Integer value) {
// We add the value for key only if key is not present - we don’t update
// existing values.
        Integer currentValue = isbnToPrice.get(key);
        if (!isbnToPrice.containsKey(key)) {
            isbnToPrice.put(key, value);
            return currentValue;
        } else {
            return null;
        }
    }

    public Integer erase(Object key) {
        return isbnToPrice.remove(key);
    }
}
