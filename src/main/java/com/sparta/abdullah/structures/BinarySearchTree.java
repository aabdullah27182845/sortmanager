package com.sparta.abdullah.structures;

import java.util.ArrayList;
import java.util.Stack;

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
