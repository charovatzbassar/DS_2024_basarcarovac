package week2;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Basar");
        stack.push("Daniel");
        stack.push("Stela");

        System.out.println(stack.peek());


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<String> queue = new Queue<>();
        queue.enqueue("Basar");
        queue.enqueue("Daniel");
        queue.enqueue("Stela");
        queue.enqueue("Eldin");

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());

        System.out.println(TwoStackAlgorithm.calculate("( ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) - ( 5 / 4 ) )"));
    }
}
