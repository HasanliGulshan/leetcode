package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : cpdomains) {
            String[] arr = s.split(" ");
            String[] addresses = arr[1].split("\\.");
            int value = Integer.parseInt(arr[0]);

            String curr = "";
            for (int i = addresses.length - 1; i >= 0; i--) {
               curr = addresses[i] + (i < addresses.length - 1 ? "." : "") + curr;

               map.put(curr, map.getOrDefault(curr, 0) + value);
            }
        }

        List<String> ans = new ArrayList<>();

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            ans.add(m.getValue() + " " + m.getKey());
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] req = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        subdomainVisits(req);
    }
}
