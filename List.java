/**
 * A linked list of character data objects.
 * (Actually, a list of Node objects, each holding a reference to a character
 * data object.
 * However, users of this class are not aware of the Node objects. As far as
 * they are concerned,
 * the class represents a list of CharData objects. Likwise, the API of the
 * class does not
 * mention the existence of the Node objects).
 */
public class List {

    // Points to the first node in this list
    private Node first;

    // The number of elements in this list
    private int size;

    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
        return size;
    }

    /** Returns the first element in the list */
    public CharData getFirst() {
        return first.cp;
    }

    /**
     * GIVE Adds a CharData object with the given character to the beginning of this
     * list.
     */
    public void addFirst(char chr) {
        // Your code goes here
        CharData newCharData = new CharData(chr);
        Node newNode = new Node(newCharData);
        newNode.next = first;
        first = newNode;
        size++;
    }

    /** GIVE Textual representation of this list. */
    public String toString() {
        // Your code goes here
        String str = "(";
        Node current = first;
        int index = 0;
        while (current != null) {
            str += listIterator(index).current + " ";
            current = current.next;
            index++;
        }
        return str.substring(0, str.length() - 1) + ")";
    }

    /**
     * Returns the index of the first CharData object in this list
     * that has the same chr value as the given char,
     * or -1 if there is no such object in this list.
     */
    public int indexOf(char chr) {
        // Your code goes here
        Node current = first;// pointer on firs Node.
        int index = 0;
        // goes untill gets to the last Node.
        while (current != null) {
            // goes untill gets to the last Node.
            if (current.cp.chr == chr) {
                return index;
            }
            // pointer goes to the next node.
            current = current.next;
            // index increment by 1.
            index++;
        }
        // if not fount returns -1;
        return -1;

    }

    /**
     * If the given character exists in one of the CharData objects in this list,
     * increments its counter. Otherwise, adds a new CharData object with the
     * given chr to the beginning of this list.
     */
    public void update(char chr) {
        // Your code goes here
        int index = indexOf(chr);
        if (index >= 0) {
            get(index).count++;
        } else {
            addFirst(chr);
        }

    }

    /**
     * GIVE If the given character exists in one of the CharData objects
     * in this list, removes this CharData object from the list and returns
     * true. Otherwise, returns false.
     */
    public boolean remove(char chr) {
        // Your code goes here
        Node prev = null; // pointer
        Node current = first; // pointer
        // seatch for char.
        while (current != null && current.cp.chr != chr) {
            prev = current;
            current = current.next;
        }
        // if element not found return false.
        if (current == null) {
            return false;
        }
        // Removes elements
        if (prev == null) {
            first = first.next; // if this is first element updates first to next.
        } else {
            prev.next = current.next; // removes element
        }
        size--;
        return true;
    }

    /**
     * Returns the CharData object at the specified index in this list.
     * If the index is negative or is greater than the size of this list,
     * throws an IndexOutOfBoundsException.
     */
    public CharData get(int index) {
        // Your code goes here
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        return current.cp;

    }

    /**
     * Returns an array of CharData objects, containing all the CharData objects in
     * this list.
     */
    public CharData[] toArray() {
        CharData[] arr = new CharData[size];
        Node current = first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.cp;
            current = current.next;
        }
        return arr;
    }

    /**
     * Returns an iterator over the elements in this list, starting at the given
     * index.
     */
    public ListIterator listIterator(int index) {
        // If the list is empty, there is nothing to iterate
        if (size == 0)
            return null;
        // Gets the element in position index of this list
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // Returns an iterator that starts in that element
        return new ListIterator(current);
    }

}

