package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicate {
    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : paths) {
            String[] doc = s.split(" ");
            String root = doc[0];

            for (int i = 1; i < doc.length; i++) {
                String fileName = doc[i].substring(0, doc[i].indexOf('('));
                String contentName = doc[i].substring(doc[i].indexOf('('));

                if (map.containsKey(contentName)) {
                    List<String> exist = map.get(contentName);

                    exist.add(root + "/" + fileName);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(root + "/" + fileName);

                    map.put(contentName, list);
                }
            }
        }

        List<List<String>> ans = map.values().stream().filter(strings -> strings.size() > 1).collect(Collectors.toList());

        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};

        findDuplicate(s);
}
}
