package day8;

import java.util.Objects;

/**
 * null <- node0 <-> node1 <-> node2 <-> ... <-> nodeN -> null
 *        (first)                               (last)
 */
public class DoublyLinkedList {
    int size = 0;
    Node first;
    Node last;

    static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        void next(Node node) {
            this.next = node;
            node.prev = this;
        }

        public void prev(Node node) {
            this.prev = node;
            node.next = this;
        }
    }

    /**
     * null        <-  node0 <-> node1 ....
     *                 (first)
     * null <- new  -> node0 <-> node1 ....
     *                 (first)
     * null <- new <-> node0 <-> node1 ....
     *        (first)
     */
    public void addFirst(Object o) {
        if (isEmpty()) {
            Node node = new Node(null, o, null);
            first = node;
            last = node;
            size++;
            return;
        }
        Node node = new Node(null, o, first);
        first.prev = node;
        first = node;
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    /**
     * ... <-> nodeN-1 <-> nodeN         -> null
     *                    (last)
     * ... <-> nodeN-1 <-> nodeN <-> new -> null
     *                              (last)
     */
    public void addLast(Object o) {
        if (isEmpty()) {
            addFirst(o);
            return;
        }
        Node node = new Node(last, o, null);
        last.next = node;
        last = node;
        size++;
    }

    /**
     * ... node7 <->            node8(*) <-> node9 ...
     * add(8, new)
     * ... node7 <-> new(*) <-> node8    <-> node9 ...
     */
    public void add(int index, Object o) {
        if (isFirstIndex(index)) {   // 처음
            addFirst(o);
            return;
        }
        if (isLastIndex(index)) {    // 마지막
            addLast(o);
            return;
        }
        Node prev = getNode(index - 1); // 인덱스 이전 노드
        Node next = prev.next;               // 인덱스 노드이지만 다음 노드로 밀릴 노드
        Node newNode = new Node(prev, o, next);    // 추가할 노드(prev <- newNode -> next)
        prev.next(newNode);                // prev -> newNode, prev <- nowNode
        next.prev(newNode);                // newNode <- next, newNode -> next
        this.size++;
    }

    private boolean isLastIndex(int index) {
        return index == size - 1;
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    private Node getNode(int index) {
        checkIndex(index);
        if (isFirstIndex(0)) {
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
            throw new IndexOutOfBoundsException("DoublyLinkedList에는 " + index + " 에 위치하는 노드가 없어요");
    }

    public Object getFirst() {
        if (first == null) {
            return null;
        }
        return first.item;
    }

    public Object getLast() {
        if (last == null) {
            return null;
        }
        return last.item;
    }

    /**
     * n0 <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 <-> n7
     *(first)                                          (last)
     */
    public Object get(int index) {
        if (isFirstIndex(index)) {
            return getFirst();
        }
        if (isLastIndex(index)) {
            return getLast();
        }
        return getNode(index).item;
    }

    /**
     * n0 <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 <-> n7
     *(first)                                          (last)
     */
    public int indexOf(Object o) {
        int index = 0;
        for (Node c = first; c != null; c = c.next) {
            if (Objects.equals(c.item, o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * null <- n0 <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 <-> n7 -> null
     *        (first)                                          (last)
     * null <-------  n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 <-> n7 -> null
     *               (first)                                   (last)
     */
    public Object removeFirst() {
        Object result = first.item;
        if (size == 1) {
            clear();
            return result;
        }
        first = first.next;
        first.prev = null;
        size--;
        return result;
    }

    /**
     * null <- n0 <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 <-> n7 -> null
     *        (first)                                          (last)
     * null <- n0 <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 --------> null
     *        (first)                                   (last)
     */
    public Object removeLast() {
        Object result = last.item;
        if (size == 1) {
            clear();
            return result;
        }
        last = last.prev;
        last.next = null;
        size--;
        return result;
    }

    /**
     *  n0 <-> n1 <-> n2 <-> n3 <-> n4 <-> n5 <-> n6 <-> n7
     * (first)                                          (last)
     *  remove(3)
     *  n0 <-> n1 <-> n2 <--------> n4 <-> n5 <-> n6 <-> n7
     * (first)                                          (last)
     */
    public Object remove(int index) {
        if (isFirstIndex(index)) {
            return removeFirst();
        }
        if (isLastIndex(index)) {
            return removeLast();
        }
        /*
            node0 <-> node1(x) <-> node2 -> null
            node0 <->              node2 -> null
         */
        Node removeNode = getNode(index);
        Node prevNode = removeNode.prev;
        Node nextNode = removeNode.next;

        prevNode.next(nextNode);

        size--;
        return removeNode.item;
    }
}
