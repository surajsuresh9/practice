package implementation.dynamicArray;

public class MyDynamicArray {
    int[] arr;
    int capacity;
    int ptr;

    public MyDynamicArray(int maxSize) {
        this.capacity = maxSize;
        arr = new int[maxSize];
        ptr = -1;
    }

    public void ensureCapacity() {
        if (ptr == arr.length - 1) {
            // copy contents to new array of double size
            System.out.println("Max capacity reached...");
            System.out.print("Expanding array");
            int[] temp = new int[capacity * 2];
            // copy content of existing arr to new array
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            // assign temp array to arr
            arr = temp;
            // double size
            capacity *= 2;
            System.out.print(".. Done");
        }

    }

    public void push(int data) {
        ensureCapacity();
        arr[++ptr] = data;
    }

    public void push(int data, int index) {
        if (index >= capacity) {
            System.out.println("Invalid index, try a smaller index");
            return;
        }
        if (ptr == getCapacity()) {
            push(data);
        } else {
            arr[index] = data;
        }
    }

    public int getSize() {
        return ptr;
    }

    int getCapacity() {
        return capacity;
    }

    public void get(int index) {
        if (index < 0 || index > ptr) {
            System.out.println("Invalid index, check and try again");
            return;
        }
        System.out.println(arr[index]);

    }

    public void printArray() {
        String str = "Array [";
        for (int i = 0; i <= ptr; i++) {
            str += arr[i] + ", ";
        }
        if (ptr > -1) {
            str = str.substring(0, str.length() - 2);
        }
        str += "]";
        System.out.println(str);
    }

    public static void main(String[] args) {
        MyDynamicArray array = new MyDynamicArray(5);
        array.printArray();
        array.push(10);
        array.push(20);
        array.printArray();
        array.push(30);
        System.out.println("Size: " + array.getSize());
        System.out.println("Capacity: " + array.getCapacity());
        array.get(3);
        array.push(33, 11);
        array.push(44, 1100);
        array.printArray();
        array.push(40);
        array.push(50);
        array.printArray();
        array.push(60);
        array.printArray();
    }

}
