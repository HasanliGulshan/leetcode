package string;

public class ComplexNumberMultiply {
    public static String complexNumberMultiply(String a, String b) {
       int aReal = getNumber(a.substring(0, a.indexOf("+")));
       int aImag = getNumber(a.substring(a.indexOf("+") + 1, a.indexOf("i")));

       int bReal = getNumber(b.substring(0, b.indexOf("+")));
       int bImag = getNumber(b.substring(b.indexOf("+") + 1, b.indexOf("i")));

       int finalReal = aReal * bReal - aImag * bImag;
       int finalImag = aReal * bImag + aImag * bReal;

        return finalReal + "+" + finalImag + "i";
    }

    public static int getNumber(String s) {
        return  s.charAt(0) == '-'? -Integer.parseInt(s.substring(1)) : Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
