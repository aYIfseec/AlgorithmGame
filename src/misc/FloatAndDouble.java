package misc;

public class FloatAndDouble {
    public static void main(String[] args) {
        Float f = 2.89f;
        Double d = 2.89;

        System.out.println(f.doubleValue() == d);
        System.out.println(d.floatValue() == f);

        System.out.println(f);
        System.out.println(d);
        System.out.println(f.doubleValue());
        System.out.println(d.floatValue());

        testStr();
    }

    private static void testStr() {
        String s1 = "hello world";
        String s2 = new String("hello world");
        String s3 = "hello" + " " + "world";

        System.out.println("String test");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
