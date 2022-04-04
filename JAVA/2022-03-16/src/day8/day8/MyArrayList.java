package day8;

import java.util.Objects;

public class MyArrayList {
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        this.elements = new Object[100];
    }

    public boolean add(Object o) {
        this.elements[this.size++] = o;
        return true;
    }

    public Object get(int index) {
        checkIndex(index);
        return this.elements[index];
    }

    void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("MyArrayList에는 " + index + " 에 위치하는 요소가 없어요");
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(elements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elements[i] = null;
        }
//        this.elements = new Object[128];
        this.size = 0;
    }

    public Object remove(int index) {
        Object result = get(index);

        final int newSize = this.size - 1;
        if (newSize > index)
            System.arraycopy(elements, index + 1, elements, index, newSize - index);

        this.elements[newSize] = null;
        this.size = newSize;

        return result;
    }
}
