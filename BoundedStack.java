import java.util.NoSuchElementException;

public class BoundedStack<E> {



    private final Object[] elements;
    private final int capacity;
    private int size;

    private void checkRep() {
        assert elements != null : "elements array cannot be null";
        assert capacity > 0 : "capacity must be positive";
        assert elements.length == capacity : "array length must equal capacity";
        assert size >= 0 && size <= capacity : "size must be between 0 and capacity";

        for (int i = 0; i < size; i++) {
            assert elements[i] != null : "occupied index " + i + " cannot be null";
        }
        for (int j = size; j < capacity; j++) {
            assert elements[j] == null : "unoccupied index " + j + " must be null";
        }
    }

    public BoundedStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
        checkRep();
    }

    public int size() { return size; }
    public int capacity() { return capacity; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }

    public void push(E item) {
        checkRep();
        if (item == null) {
            throw new IllegalArgumentException("Null item not allowed");
        }
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        elements[size] = item;
        size++;
        checkRep();
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        checkRep();
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return (E) elements[size - 1];
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        checkRep();
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        size--;
        E item = (E) elements[size];
        elements[size] = null; // Clean reference to prevent memory leak
        checkRep();
        return item;
    }
}
