package week1;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addToFront(5);
        list.addToFront(3);
        list.addToFront(9);

        list.removeFromFront();

        list.addToRear(8);
        list.addToRear(11);

        list.removeFromRear();



        list.add(2,11);
        list.remove(3);

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.addToFront(1);
        doublyLinkedList.addToFront(2);
        doublyLinkedList.addToFront(3);
        doublyLinkedList.addToFront(4);

        doublyLinkedList.removeFromFront();

        doublyLinkedList.addToRear(5);
        doublyLinkedList.addToRear(6);
        doublyLinkedList.removeFromRear();
        doublyLinkedList.add(2,9);

        doublyLinkedList.remove(1);


        for (Integer i : doublyLinkedList) {
            System.out.println(i);
        }



    }
}
