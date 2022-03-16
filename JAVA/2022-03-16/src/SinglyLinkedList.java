import java.util.Objects;

public class SinglyLinkedList {
    int size = 0;
    Node first; // head

    static class Node {
        Object item;
        Node next;

        Node(Object element, Node next) {
            this.item = element;
            this.next = next;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public SinglyLinkedList() {
    }

    public void addFirst(Object o) {
        if (isEmpty()) {    // 첫 노드가 없으면 여기로 추가
            first = new Node(o, null);
        } else {    // 첫 노드가 있으면 처음 노드 앞에
            Node next = first;
            first = new Node(o, next);
        }
        this.size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(Object o) {
        if (isEmpty()) {    // 첫 노드가 없으면 여기로 추가
            first = new Node(o, null);
        } else {    // 첫 노드가 있으면 마지막 노드를 찾아서 마지막 노드의 다음으로 추가되는 객체를 연결
            Node last = getLastNode();
            last.next = new Node(o, null);
        }
        this.size++;
    }

    private Node getLastNode() {
        if (isEmpty()) {
            return null;
        }
        Node current = first;
        while (current.hasNext()) {
            current = current.next;
        }
        return current;
    }

    public void add(int index, Object o) {
        if (isFirstIndex(index)) {
            addFirst(o);
            return;
        }
        Node prev = getNode(index - 1);
        Node next = getNode(index);
        Node newNode = new Node(o, next);
        prev.next = newNode;
        this.size++;
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    private Node getNode(int index) {
        checkIndex(index);
        if (index == 0) {
            return first;
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("SingleLinkedList에는 " + index + " 에 위치하는 노드가 없어요");
    }

    public Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.item;
    }

    public Object getLast() {
        if (isEmpty()) {
            return null;
        }
//        while (!first.hasNext()) {
//            first = first.next;
//            return first;
//        }
        return getLastNode().item;
    }

    public Object get(int index) {
        if (isEmpty()) {
            return null;
        }

        return getNode(index).item;
    }

    public int indexOf(Object o) {
        int count = 0;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("찾으려는 노드가 없습니다.");
        }

        while (!first.hasNext()) {
            if (first.next.item.equals(o)) {
                return count;
            } else {
                first.next = first.next.next;
                count += 1;
            }
        }

//        int index = 0;
//        for(Node c = first; c!=null; c= c.next){
//            if(Objects.equals(c.item, c)){
//                return index;
//            }
//            index++;
//        }

        return -1;
    }

    public void clear() {
        while (!isEmpty()) {
            first.next = null;
            first.item = null;
            first = first.next;
            first.item = first.next.item;
        }

//        first = null;
//        size = 0;

    }

    public Object removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("노드가 없습니다");
        }
        Object result = first.item;
        first = first.next;
        size --;
        return result;
    }

    public Object removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("노드가 없습니다");
        }
        getLastNode().item = null;
        return getLastNode();
    }

    public Object remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("노드가 없습니다.");
        }
        getNode(index).item = null;
        getNode(index - 1).next = getNode(index).next;
        return getNode(index);
    }
}
