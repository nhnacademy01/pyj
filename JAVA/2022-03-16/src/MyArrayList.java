import javax.swing.*;
import java.util.Objects;

class MyArrayList {
    private Object[] elements; // null로 초기화
    private int size; // 1로 초기화

    public MyArrayList() {
        // TODO
        this.elements = new Object[128];
    }

    public boolean add(Object o) {
        // TODO
        this.elements[this.size++] = o;
        return true;
    }

    public Object get(int index) {
        // TODO
        checkIndex(index, this.size);
        return this.elements[index];
    }

    void checkIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("MyArrayList에는 " + index + " 에 위치하는 요소가 없어요");
        }
    }

    public int indexOf(Object o) {
        //TODO
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }
        return -1;
    }


    public int size() {
        // TODO
        return this.elements.length;
    }


    public boolean isEmpty() {
        // TODO
        return this.size == 0;
    }


    public void clear() {
        // TODO
        this.elements = new Object[128];
        this.size = 0;
        // 메모리를 새로 할당한다는 단점

//        for (int i = 0; i < this.size; i++) {
//            elements[i] = null;
//
//        }
        // 이렇게 해도 된다
        // 이렇게 하면 메모리를 새로 할당하지 않는 장점
    }

    public Object remove(int index) {
        // TODO
        // 삭제 후 요소를 땡겨주는 과정도 필요함
        Object result = get(index);
        final int newSize = this.size - 1;

        if (newSize > index) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);

        }
        this.elements[newSize] = null;
        // 복제가 되어도 맨 마지막은 값이 남아있는데
        // 이거를 null로 바꾸는 것
        this.size = newSize;

        return null;
    }
}