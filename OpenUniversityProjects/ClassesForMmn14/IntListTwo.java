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

    // sum all the nums between low to high
    private int f(int low, int high) {
        int result = 0;
        IntNodeTwo temp = _head;
        // O(n)
        for (int i = 0; i < low; i++)
            temp = temp.getNext();
        // O(n)
        for (int j = low; j <= high; j++) {
            result += temp.getNum();
            temp = temp.getNext();
        }
        return result;
    }

    // find if for input num there is sub list that it's sum is the sam as num. if
    // so print between i (first place) and j (second place)
    // Else if not find range that sum is equal to num print No
    public boolean what(int num) {
        int listSize = size(); // O(n)
        // O(n^3)
        for (int i = 0; i < listSize; i++) { // O(n)
            for (int j = i; j < listSize; j++) { // O(n)
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
        IntNodeTwo left = _head, right = _tail;

        while (left != right) {
            
        }

        // write your code here
        return true;
    }

    public int longestCommonSublist(IntListTwo list2) {
        return longestCommonSublist(list2, _head, list2._head);
    }

    public int longestCommonSublist(IntListTwo list2, IntNodeTwo currentNode1, IntNodeTwo currentNode2) {
        int localCountInLists = 0; // local count for every call.

        if (currentNode1.getNum() == currentNode2.getNum()) {
            if (isNumInLists(currentNode1.getNum(), list2)) {
                localCountInLists++;
            }
        }

        else {
            if (isNumInLists(currentNode1.getNum(), list2)) {
                localCountInLists++;
            }

            if (isNumInLists(currentNode2.getNum(), list2)) {
                localCountInLists++;
            }
        }

        if (currentNode1.getNext() == null) {
            if (currentNode2.getNext() == null) {
                return localCountInLists;
            }

            return localCountInLists + longestCommonSublist(list2, currentNode1, currentNode2.getNext());
        }

        if (currentNode2.getNext() == null) {
            return localCountInLists + longestCommonSublist(list2, currentNode1.getNext(), currentNode2);
        }

        return localCountInLists + longestCommonSublist(list2, currentNode1.getNext(), currentNode2.getNext());
    }

    private boolean isNumInLists(int num, IntListTwo list2) {
        boolean isNumInList1 = false, isNumInList2 = false;
        return isNumInLists(num, _head, list2._head, isNumInList1, isNumInList2);
    }

    private boolean isNumInLists(int num, IntNodeTwo currentNode1, IntNodeTwo currentNode2, boolean isNumInList1,
            boolean isNumInList2) {

        if (currentNode1.getNum() == num) {
            isNumInList1 = true;
        }

        if (currentNode2.getNum() == num) {
            isNumInList2 = true;
        }

        if (isNumInList1 && isNumInList2) {
            return true;
        }

        if (currentNode1.getNext() == null || currentNode2.getNext() == null) {
            return false;
        }

        return isNumInLists(num, currentNode1.getNext(), currentNode2.getNext(), isNumInList1, isNumInList2);
    }

    public int maxEqualValue() {
        return maxEqualValue(_head, 0);
    }

    public int maxEqualValue(IntNodeTwo currentNode, int maxEqualValue) {
        if (currentNode.getNext() == null) {
            return maxEqualValue;
        }

        int currentSubListSize = subListSize(currentNode.getNum(), currentNode);

        return maxEqualValue(currentNode.getNext(), Math.max(maxEqualValue, currentSubListSize));
    }

    private int subListSize(int num, IntNodeTwo currentNode) {
        if (currentNode.getNext() == null) {
            return 1;
        }

        if (currentNode.getNum() != num) {
            return 0;
        }

        return 1 + subListSize(num, currentNode.getNext());
    }
}
