package sorting;

import java.util.*;

public class OrderedStream {
    int currentPos=0, oldPos=0;
    ArrayList list;

    public OrderedStream(int n) {
        list = new ArrayList();

        for(int i=0;i<=n;i++){
            list.add(null);
        }
    }

    public List<String> insert(int idKey, String value) {
        list.set(idKey-1,value);
        oldPos=currentPos;

        while(list.get(currentPos)!=null){
            currentPos++;
        }
        return  list.subList(oldPos, currentPos);
    }

    public static void main(String[] args) {
        OrderedStream stream = new OrderedStream(5);

        System.out.println(stream.insert(3, "ccccc"));
        System.out.println(stream.insert(1, "aaaaa"));
        System.out.println(stream.insert(2, "bbbbb"));
        System.out.println(stream.insert(5, "eeeee"));
        System.out.println(stream.insert(4, "ddddd"));
    }
}
