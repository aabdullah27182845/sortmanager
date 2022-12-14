# Sort Manager

This is the first instance of the sort manager project. It contains
an interface for the sorter classes which was implemented three times.

- Bubble Sort Class is implemented from the Sorter interface. The arraySort method sorts the list using the bubble sort algorithm.
- Merge Sort Class sorts the array using the merge sort algorithm.
- Tree Sort class sorts the array by creating a binary search tree and then returning the object using in-order traversal.
- Both the bubble sort and the merge sort algorithms contain a timeTaken attribute that measures the time taken for the algorithm to complete.
- Merger class exists to merge two sorted arrays.

### Sorter interface

```java
public interface Sorter {

    int[] sortArray(int[] arrayToSort);
}
```

### Bubble Sort Algorithm

```java
 public int[] sortArray(int[] arrayToSort) {
        boolean flag = true;
        int rounds = 0;

        long timeStart = System.nanoTime();

        while (flag) {
            flag = false;
            for (int i = 0; i < arrayToSort.length - 1 - rounds; i++) {
                if (arrayToSort[i] > arrayToSort[i+1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i+1];
                    arrayToSort[i+1] = temp;
                    flag = true;
                }
            }
            rounds++;
        }

        long timeEnd = System.nanoTime();
        this.timeTaken = timeEnd - timeStart;
        return arrayToSort;
    }
```

### Merge Sort Algorithm

```java
public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public void mergeSort(int[] inputList, int listLength) {
        if (listLength < 2) {
            return;
        }
        int mid = listLength / 2;
        int[] left = new int[mid];
        int[] right = new int[listLength - mid];

        System.arraycopy(inputList, 0, left, 0, mid);
        if (listLength - mid >= 0) System.arraycopy(inputList, mid, right, mid - mid, listLength - mid);
        mergeSort(left, mid);
        mergeSort(right, listLength - mid);

        merge(inputList, left, right, mid, listLength - mid);
    }
```

### Tree Sort Algorithm

```java
public int[] sortArray(int[] arrayToSort) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int number: arrayToSort) {
            tree.add(number);
        }
        return tree.inOrderTraversal();
    }
```

### Binary Search Tree

```java
public class BinarySearchTree {
    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node currentNode = root;
        while (true) {
            Node parentNode = currentNode;
            if (value == currentNode.value) {
                currentNode.count++;
                break;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
                if (currentNode == null) {
                    currentNode = new Node(value);
                    parentNode.right = currentNode;
                    break;
                }
            } else {
                currentNode = currentNode.left;
                if (currentNode==null) {
                    currentNode = new Node(value);
                    parentNode.left = currentNode;
                    break;
                }
            }
        }
    }

    public int[] inOrderTraversal() {
        if (root == null) return new int[0];

        ArrayList<Integer> traversal = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();

            for (int i=0; i<currentNode.count; i++)
                traversal.add(currentNode.value);

            currentNode = currentNode.right;
        }

        return traversal.stream().mapToInt(i -> i).toArray();
    }
}
```

### Contr