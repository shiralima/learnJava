package ClassesForMmn14; //todo - remove

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

    /**
     * EX 2
     * 
     * 1. The "what" function checks if there is a sub array whose sum equals the
     * specified number.
     * If such a sub array exists, it prints the start and end indices of the
     * sub array and returns true. If no such
     * sub array is found, it prints "No" and returns false.
     * 
     * 2. Time Complexity of "what" function: In the "what" function,
     * we have two nested loops that iterate over the list size,
     * which means O(n^2) for this part.
     * However, inside the nested loops, we call the "f" function, which itself
     * iterates over the list within a for loop.
     * This means that the total time complexity is O(n^3).
     * 
     * 4. Time Complexity of "betterWhat" function: In the "betterWhat" function,
     * we have two nested loops that iterate over the list size,
     * which means O(n^2).
     * 
     * 
     * @param num the target sum to search for within contiguous sub arrays
     * @return true if there exists a contiguous sub array with the sum equal to
     *         num,
     *         false otherwise
     */
    public boolean betterWhat(int num) {
        int listSize = size();
        int sum = _head.getNum();

        if (listSize == 1) {
            return num == sum;
        }

        IntNodeTwo temp = _head.getNext();

        for (int i = 0; i < listSize; i++) {
            for (int j = i; j < listSize; j++) {
                sum += temp.getNum();
                if (sum == num) {
                    System.out.println("between " + i + " and " + j);
                    return true;
                }
                temp.getNext();
            }
        }
        System.out.println("No ");
        return false;
    }

    // * EX 3 */
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

    /**
     * Finds the maximum size of a contiguous sublist with equal values starting
     * from the head of the linked list.
     *
     * @return the size of the largest sublist with equal values.
     */
    public int maxEqualValue() {
        return maxEqualValue(_head, 0);
    }

    /**
     * Recursively finds the maximum size of a contiguous sublist with equal values.
     *
     * @param currentNode   the current node being checked.
     * @param maxEqualValue the current maximum size of sublist with equal values.
     * @return the updated maximum size of the sublist with equal values.
     */
    private int maxEqualValue(IntNodeTwo currentNode, int maxEqualValue) {
        if (currentNode.getNext() == null) {
            return maxEqualValue;
        }

        // Get the size of the current sublist with equal values
        int currentSubListSize = subListSize(currentNode.getNum(), currentNode);

        // Recursively call maxEqualValue with the maximum of the previous max and the
        // current sublist size
        return maxEqualValue(currentNode.getNext(), Math.max(maxEqualValue, currentSubListSize));
    }

    /**
     * Calculates the size of a sublist starting from the current node with all
     * values equal to the given number.
     *
     * @param num         the value to be matched in the sublist.
     * @param currentNode the starting node of the sublist.
     * @return the size of the sublist where all values are equal to the given
     *         number.
     */
    private int subListSize(int num, IntNodeTwo currentNode) {
        // If we reach the tail, return 1
        if (currentNode.getNext() == null) {
            return 1;
        }

        // If the current node's value is not equal to num, return 0
        if (currentNode.getNum() != num) {
            return 0;
        }

        // Recursively call subListSize and add 1
        return 1 + subListSize(num, currentNode.getNext());
    }
}
