public class MyIntLinkedList {

    DoubleLinkedListNode[] myIntLinkedList;
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;

    public MyIntLinkedList() {
        this.myIntLinkedList = null;
        this.head = null;
        this.tail = null;
    }


    public void add(int index, int element) {
        if (index > size()) {
            System.out.println("Nu se poate adauga element pe acea pozitie");
        }

        DoubleLinkedListNode it = head;
        DoubleLinkedListNode elem = new DoubleLinkedListNode(element);

        for (int i = 0; i < index - 1; i++) {
            it = it.next();
        }

        DoubleLinkedListNode before = it;
        DoubleLinkedListNode after = it.next();

        before.next(elem);
        after.prev(elem);
        elem.prev(before);
        elem.next(after);

    }

    public boolean add(int e) {
        DoubleLinkedListNode elem = new DoubleLinkedListNode(e);

        if (head == null) {
            head = elem;
        }
        if (tail == null) {
            tail = elem;
        } else {
            DoubleLinkedListNode it = this.tail;
            it.next(elem);
            elem.prev(it);
            this.tail = elem;
        }
        return true;
    }

    public int size() {
        if (this.head == null)
            return 0;

        DoubleLinkedListNode it = head;
        int counter = 1;

        while (it.next() != null) {
            it = it.next();
            counter++;
        }
        return counter;
    }

    public boolean contains(int e) {
        DoubleLinkedListNode elem = new DoubleLinkedListNode(e);
        DoubleLinkedListNode it = head;

        while (it != null) {
            if (it == elem) {
                return true;
            }
            it = it.next();
        }
        return false;
    }

    public int get(int index) {
        if (index > size() - 1) {
            System.out.println("Acea pozitie nu exista");
            return -1;
        }
        DoubleLinkedListNode it = head;
        for (int i = 0; i < index; i++)
            it = it.next();
        return it.value();
    }

    public int indexOf(int e) {
        int counter = 0;

        DoubleLinkedListNode elem = new DoubleLinkedListNode(e);
        DoubleLinkedListNode it = head;
        while (it != null) {
            if (it.value() == elem.value()) {
                return counter;
            }
            counter++;
            it = it.next();
        }
        return -1;
    }

    public int lastIndexOf(int e) {
        int counter = 0;
        int poz = -1;

        DoubleLinkedListNode elem = new DoubleLinkedListNode(e);
        DoubleLinkedListNode it = head;
        while (it != null) {
            if (it.value() == elem.value()) {
                poz = counter;
            }
            counter++;
            it = it.next();
        }

        return poz;
    }

    public boolean remove(int e) {
        DoubleLinkedListNode elem = new DoubleLinkedListNode(e);
        DoubleLinkedListNode it = head;

        while (it != null) {
            if (it.value() == elem.value()) {
                it = it.prev();
                it.next(it.next().next());
                it = it.next();
                it.prev(it.prev().prev());
                return true;
            }
            it = it.next();
        }
        return false;
    }

    public int removeElementAtIndex(int index) {
        if (index > size()) {
            return -1;
        }

        if (index == 0) {
            head = head.next();
            head.prev(null);
            return 0;
        }

        DoubleLinkedListNode it = head;
        for (int i = 0; i < index - 1; i++) {
            it = it.next();
        }

        it.next(it.next().next());
        it = it.next();
        it.prev(it.prev().prev());

        return 0;
    }

    public void clear() {
        this.head = null;
        this.head.next(null);
        this.tail = null;
        this.tail.prev(null);
    }

    public int set(int index, int e) {
        if (index > size()) {
            return -1;
        }

        DoubleLinkedListNode it = head;

        for (int i = 0; i < index; i++) {
            it.value(e);
        }
        return e;
    }

    public boolean addAll(MyIntLinkedList c) {
        DoubleLinkedListNode it = tail;
        it.next(c.head);
        it = it.next();
        it.prev(it.prev().prev());
        tail = c.tail;
        return true;
    }

    public boolean addAll(int index, MyIntLinkedList c) {
        if (index > size()) {
            return false;
        }

        DoubleLinkedListNode it = head;

        for (int i = 0; i < index; i++) {
            it = it.next();
        }
        DoubleLinkedListNode left = it;
        DoubleLinkedListNode right = it.next();
        c.head.prev(left);
        left.next(c.head);
        c.tail.next(right);
        right.prev(c.tail);

        return true;
    }

    public int[] toArray() {
        int[] arr = new int[size()];

        DoubleLinkedListNode it = head;
        for (int i = 0; i < size(); i++) {
            arr[i] = it.value();
            it = it.next();
        }

        return arr;
    }
}
