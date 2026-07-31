# Design Document: BoundedStack ADT

## Design Decisions
- **Mutability**: Mutable (ตามมาตรฐาน Stack)
- **Base Structure**: Array (`Object[]`) เพื่อประสิทธิภาพ $\mathcal{O}(1)$
- **Null Policy**: ไม่อนุญาตให้ใส่ `null`
- **Overflow Policy**: โยน `IllegalStateException`
- **Underflow Policy**: โยน `NoSuchElementException`

## Operations Specification
- `BoundedStack(int capacity)`: Creator (capacity > 0)
- `push(E item)`: Mutator (item != null, size < capacity)
- `pop()`: Mutator (size > 0)
- `peek()`: Observer (size > 0)
- `size()`, `capacity()`, `isEmpty()`, `isFull()`: Observer
- `copy()`: Producer
