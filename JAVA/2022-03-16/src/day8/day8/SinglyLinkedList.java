package day8;

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
        if (isEmpty()) {    // 첫 노드가 없으면 첫 노드로 추가
            first = new Node(o, null);
        } else {    // 첫 노드가 있으면 처음 노드 앞에 추가
            first = new Node(o, first);
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
        if (isEmpty()) {    // 첫 노드가 없으면 null 반환
            return null;
        }
        Node current = first;
        while (current.hasNext()) {    // node.next == null이 마지막 노드
            current = current.next;
        }
        return current;
    }

    public void add(int index, Object o) {
        if (isFirstIndex(index)) {
            addFirst(o);
            return;
        }
        /*
            prev -> next(*)
            prev -> next, newNode(*) -> next
            prev -> newNode(*) -> next
         */
        Node prev = getNode(index - 1); // 인덱스 앞 노드
        Node next = prev.next;               // 인덱스 노드
        Node newNode = new Node(o, next);    // 추가할 노드를 생성 및 다음 노드 설정까지
        prev.next = newNode;                // 인덱스 앞 노드의 다음 노드르 추가할 노드 설정
        this.size++;
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    private Node getNode(int index) {
        checkIndex(index);
        if (isFirstIndex(index)) {
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
            throw new IndexOutOfBoundsException("SinglyLinkedList에는 " + index + " 에 위치하는 노드가 없어요");
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size - 1);
    }

    public Object get(int index) {
        return getNode(index).item;
    }

    private boolean isLastIndex(int index) {
        return index == size - 1;
    }

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
        // 원래는 순회하면서 모든 node의 요소들을 null 처리하는 것이 더 좋음
        first = null;
        size = 0;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public Object remove(int index) {
        if (isFirstIndex(index)) {
            return removeFirst();
        }
        /*
            node0 -> node1(x) -> node2 -> null
            node0 ->             node2 -> null
         */
        Node prevRemoveNode = getNode(index - 1);
        Node removeNode = prevRemoveNode.next;
        prevRemoveNode.next = removeNode.next;
        size--;
        return removeNode.item;
    }
}
