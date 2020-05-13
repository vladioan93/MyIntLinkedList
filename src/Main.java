public class Main {

    public static void main(String[] args) {
        MyIntLinkedList myIntLinkedList = new MyIntLinkedList();
        myIntLinkedList.add(0);
        myIntLinkedList.add(1);
        myIntLinkedList.add(2);
        myIntLinkedList.add(3);
        myIntLinkedList.add(4);
        myIntLinkedList.add(5);
        myIntLinkedList.add(6);
        myIntLinkedList.add(7);
        myIntLinkedList.add(8);
        myIntLinkedList.add(9);
        myIntLinkedList.add(5, 6);

        DoubleLinkedListNode it = myIntLinkedList.head;

        while (it != null) {
            System.out.print(" " + it.value());
            it = it.next();
        }
        System.out.println("\nsize: " + myIntLinkedList.size());

        System.out.println(myIntLinkedList.get(2));

        System.out.println(myIntLinkedList.lastIndexOf(4));

        myIntLinkedList.removeElementAtIndex(0);

        it = myIntLinkedList.head;
        while (it != null) {
            System.out.print(" " + it.value());
            it = it.next();
        }
    }
}
