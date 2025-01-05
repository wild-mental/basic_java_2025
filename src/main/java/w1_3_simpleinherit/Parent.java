package w1_3_simpleinherit;

public class Parent {
    public void hello (String target) {
        if (target==null || target.isEmpty()) {
            System.out.println("Hello nobody!");
        } else {
            System.out.println("Hello " + target);
        }
    }
}
