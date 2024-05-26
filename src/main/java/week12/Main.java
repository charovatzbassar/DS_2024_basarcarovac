package week12;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<String, Integer> rbt = new RedBlackTree<>();

        rbt.put("T", 0);
        rbt.put("E", 1);
        rbt.put("X", 2);
        rbt.put("A", 3);
        rbt.put("R", 4);
        rbt.put("C", 5);
        rbt.put("H", 6);
        rbt.put("M", 7);

        System.out.println("R: " + rbt.get("R"));
        System.out.println("M: " + rbt.get("M"));
        System.out.println("X: " + rbt.get("X"));

    }
}
