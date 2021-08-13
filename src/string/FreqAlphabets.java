package string;

import java.util.HashMap;

public class FreqAlphabets {
    public static String freqAlphabets(String s) {
        HashMap<Character, Character> alphaChar = new HashMap<>();
        alphaChar.put('1', 'a');
        alphaChar.put('2', 'b');
        alphaChar.put('3', 'c');
        alphaChar.put('4', 'd');
        alphaChar.put('5', 'e');
        alphaChar.put('6', 'f');
        alphaChar.put('7', 'g');
        alphaChar.put('8', 'h');
        alphaChar.put('9', 'i');

        HashMap<String, String> alphaStr = new HashMap<>();

        alphaStr.put("10", "j");
        alphaStr.put("11", "k");
        alphaStr.put("12", "l");
        alphaStr.put("13", "m");
        alphaStr.put("14", "n");
        alphaStr.put("15", "o");
        alphaStr.put("16", "p");
        alphaStr.put("17", "q");
        alphaStr.put("18", "r");
        alphaStr.put("19", "s");
        alphaStr.put("20", "t");
        alphaStr.put("21", "u");
        alphaStr.put("22", "v");
        alphaStr.put("23", "w");
        alphaStr.put("24", "x");
        alphaStr.put("25", "y");
        alphaStr.put("26", "z");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append(alphaStr.get(s.substring(i, i + 2)));
                i += 2;
            } else {
                sb.append(alphaChar.get(s.charAt(i)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
