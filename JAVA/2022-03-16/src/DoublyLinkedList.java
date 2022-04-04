public class DoublyLinkedList {
    int size = 0;
    DoublyLinkedList.Node first; // head
    DoublyLinkedList.Node last; // tail

    static class Node {
        Object item;
        DoublyLinkedList.Node next;
        DoublyLinkedList.Node last;

        Node(Object element, DoublyLinkedList.Node next, DoublyLinkedList.Node last) {
            this.item = element;
            this.next = next;
            this.last = last;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    public DoublyLinkedList() {
    }

    public void addFirst(Object o) {
        if (isEmptyFirst()) {    // 첫 노드가 없으면 여기로 추가
            first = new DoublyLinkedList.Node(o, null, null);
        } else {
            DoublyLinkedList.Node prev = first;
            DoublyLinkedList.Node next = first;
            first = new DoublyLinkedList.Node(o, null, next);
        }
        this.size++;
    }

    private boolean isEmptyFirst() {
        return first == null;
    }


    public void addLast(Object o) {
        if (isEmptyFirst()) {    // 첫 노드가 없으면 여기로 추가
            DoublyLinkedList.Node prev = first;
            first = new DoublyLinkedList.Node(o, null, prev );
        } else {    // 첫 노드가 있으면 마지막 노드를 찾아서 마지막 노드의 다음으로 추가되는 객체를 연결
            DoublyLinkedList.Node last = getLastNode();
            last.next = new DoublyLinkedList.Node(o, null, last);
        }
        this.size++;
    }

    private DoublyLinkedList.Node getLastNode() {
        if (isEmptyFirst()) {
            return null;
        }
        DoublyLinkedList.Node current = first;
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
        DoublyLinkedList.Node prev = getNode(index - 1);
        DoublyLinkedList.Node next = getNode(index);
        DoublyLinkedList.Node newNode = new DoublyLinkedList.Node(o, next, prev);
        prev.next = newNode;
        this.size++;
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    private DoublyLinkedList.Node getNode(int index) {
        checkIndex(index);
        if (index == 0) {
            return first;
        }
        DoublyLinkedList.Node current = first;
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
        if (isEmptyFirst()) {
            return null;
        }
        return first.item;
    }

    public Object getLast() {
        if (isEmptyFirst()) {
            return null;
        }
//        while (!first.hasNext()) {
//            first = first.next;
//            return first;
//        }
        return getLastNode().item;
    }

    public Object get(int index) {
        if (isEmptyFirst()) {
            return null;
        }

        return getNode(index).item;
    }

    public int indexOf(Object o) {
        int count = 0;
        if (isEmptyFirst()) {
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
        while (!isEmptyFirst()) {
            first.next = null;
            first.item = null;
            first = first.next;
            first.item = first.next.item;
        }

//        first = null;
//        size = 0;

    }

    public Object removeFirst() {
        if (isEmptyFirst()) {
            throw new IndexOutOfBoundsException("노드가 없습니다");
        }
        Object result = first.item;
        first = first.next;
        size --;
        return result;
    }

    public Object removeLast() {
        if (isEmptyFirst()) {
            throw new IndexOutOfBoundsException("노드가 없습니다");
        }
        getLastNode().item = null;
        return getLastNode();
    }

    public Object remove(int index) {
        if (isEmptyFirst()) {
            throw new IndexOutOfBoundsException("노드가 없습니다.");
        }
        getNode(index).item = null;
        getNode(index - 1).next = getNode(index).next;
        return getNode(index);
    }
}
