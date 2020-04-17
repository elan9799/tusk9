class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.addFirst(2);
        System.out.println();
        list.print();
        list.removeFirst();
        System.out.println();
        list.print();
        list.removeLast();
        System.out.println();
        list.print();
        System.out.println();
        list.size();
    }

}
class Item { // один элемент списка
    int value; // значение в ячейке
    Item prev; // ссылка на предыдущий
    Item next; // ссылка на следующий

    public Item(int itemValue) {
        value = itemValue;
    }
}


class MyLinkedList { // список, цепочка элементов Item
    Item head;
    Item tail;

    public void add(int value) {
        if (head == null) { // список пустой
            Item current = new Item(value);
            head = current;
            tail = current;
        } else { // список непустой
            Item current = new Item(value);
            tail.next = current;
            current.prev = tail;
            tail = current;
        }
    }

    // добавляет элемент в начало списка
    public void addFirst(int value) {
        if (head != null) {
            Item current = new Item(value);
            current.next = head;
            head.prev = current;
            head = current;
        }else {
            Item current = new Item(value);
            head = current;
            tail = current;
        }
    }

    public void print() {
        Item current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next; // переход между элементами
        }
    }

    // удаляет первый элемент списка
    public void removeFirst() {
        Item current = head;
        if(head != null){
            head = current.next;
            current.next = null;
            head.prev = null;
        }
    }

    // удаляет последний элемент списка
    public void removeLast() {
        Item current = tail;
        if (tail != null){
            tail = current.prev;
            current.prev = null;
            tail.next = null;
        }
    }

    // возвращает количество элементов
    public void size() {
        Item current = head;
        int counter = 0;
        while (current != null){
            counter++;
            current = current.next;
        }
        System.out.println(counter);
    }
}