package OpenUniversityProjects.ClassesForMmn14; //todo - remove

public class IntListTwo {
    IntNodeTwo _head, _tail;
    // ���� �� ! ������, ������� ��� ������ �����,
    // �� ������ �� ��� ������� ���� �-private.
    // ����� ��� ��� ����� ������ ���� �� ������ ����.
    // ������ ����� ��� ��� ���� ��� ���� ���� !

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    /**
     * adds a new node to the end of the list where its value is the received number
     * 
     * @param num - integer
     */
    public void addToEnd(int num) {

        IntNodeTwo newNode = new IntNodeTwo(num);
        if (_head == null) { // List empty, new node is new head
            _head = newNode;
            _tail = newNode;
        } else {
            newNode.setPrev(_tail);
            _tail.setNext(newNode);
            _tail = newNode;
        }
    }

    // the method return a String that represents the list
    /**
     * Returns a String that represents the list
     * 
     * @return a String that represents the list in the fprmat:
     *         {first value, seconed bofore, ..., last value}
     */
    public String toString() {
        // if the list is empty return empty parentheses
        if (_head == null)
            return "{}";

        // opening parenthesis
        String s = "{";
        IntNodeTwo temp = _head;

        // for each node return its value and + ", "
        while (temp != _tail) {
            s += temp.getNum() + ", ";
            temp = temp.getNext();
        }

        // the last and closing parenthesis
        s += _tail.getNum() + "}";
        return s;
    }

    public int size() {
        IntNodeTwo temp;
        int result;
        for (temp = _head, result = 0; temp != null; result++, temp = temp.getNext())
            ;
        return result;
    }

    public int win() {
        // write your code here
        return 0;
    }

    private int f(int low, int high) {
        int result = 0;
        IntNodeTwo temp = _head;
        for (int i = 0; i < low; i++)
            temp = temp.getNext();
        for (int j = low; j <= high; j++) {
            result += temp.getNum();
            temp = temp.getNext();
        }
        return result;
    }

    public boolean what(int num) {
        int listSize = size();
        for (int i = 0; i < listSize; i++) {
            for (int j = i; j < listSize; j++) {
                if (f(i, j) == num) {
                    System.out.println("between " + i + " and " + j);
                    return true;
                }
            }
        }
        System.out.println("No ");
        return false;
    }

    public boolean betterWhat(int num) {
        // write your code here
        return true;
    }

    public int longestCommonSublist(IntListTwo list2) {
        return longestCommonSublist(list2, _head, list2._head);
    }

    public int longestCommonSublist(IntListTwo list2, IntNodeTwo currentValue1, IntNodeTwo currentValue2) {
        int localCountInLists = 0; // local count for every call.

        if (currentValue1.getNum() == currentValue2.getNum()) {
            if (isNumInLists(currentValue1.getNum(), list2)) {
                localCountInLists++;
            }
        }

        else {
            if (isNumInLists(currentValue1.getNum(), list2)) {
                localCountInLists++;
            }

            if (isNumInLists(currentValue2.getNum(), list2)) {
                localCountInLists++;
            }
        }

        if (currentValue1.getNext() == null) {
            if (currentValue2.getNext() == null) {
                return localCountInLists;
            }

            return localCountInLists + longestCommonSublist(list2, currentValue1, currentValue2.getNext());
        }

        if (currentValue2.getNext() == null) {
            return localCountInLists + longestCommonSublist(list2, currentValue1.getNext(), currentValue2);
        }

        return localCountInLists + longestCommonSublist(list2, currentValue1.getNext(), currentValue2.getNext());
    }

    private boolean isNumInLists(int num, IntListTwo list2) {
        boolean isInList1 = false, isInList2 = false;
        return isNumInLists(num, _head, list2._head, isInList1, isInList2);
    }

    private boolean isNumInLists(int num, IntNodeTwo currentValue1, IntNodeTwo currentValue2, boolean isInList1,
            boolean isInList2) {

        if (currentValue1.getNum() == num) {
            isInList1 = true;
        }

        if (currentValue2.getNum() == num) {
            isInList2 = true;
        }

        if (isInList1 && isInList2) {
            return true;
        }

        if (currentValue1.getNext() == null || currentValue2.getNext() == null) {
            return false;
        }

        return isNumInLists(num, currentValue1.getNext(), currentValue2.getNext(), isInList1, isInList2);
    }

    public int maxEqualValue() {
        // write your code here
        return 0;
    }
}
