package com.sparta.abdullah.structures;

public class Node {
        int value;
        int count;
        Node left, right;

        public Node(int _value) {
            value = _value;
            count = 1;
            left = right = null;
        }
}
