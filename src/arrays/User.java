package arrays;

public class User {

    public String name;

    public static void main(String[] args) {
        User a =new User();
        a.name = "Vusala";

        User bb = a;

        //here does not change name, because in method b reference new User obj and assign it to a
        changeReference(a);
        System.out.println(a.name);

        System.out.println("bb: " + bb.name);

        //bu in this method c refer to same address in memory as a refer
        modifyReference(a);
        System.out.println(a.name);
    }

    public static void changeReference(User a) {
        User b = new User();
        b.name = "new user";
        a = b;
    }

    public static void modifyReference(User c) {
        c.name = "Gulshan";
    }

}
