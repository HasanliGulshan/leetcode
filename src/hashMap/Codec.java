package hashMap;

import java.util.HashMap;

public class Codec {
    int index = 0;
    HashMap<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
       String key = longUrl + index;
       map.put(key, longUrl);
       index++;

       return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (map.containsKey(shortUrl)) {
            return map.get(shortUrl);
        }

        return null;
    }
}
