package com.allanperes.studies.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinarySearchTree {

    private Node root = null;

    public boolean find(int id) {
        if (Objects.isNull(this.root)) {
            return false;
        } else {
            return search(id, root);
        }
    }

    public void insert(int data) {
        if (!Objects.isNull(this.root)) {
            insert(root, data);
        } else {
            this.root = new Node(data);
        }
    }

    public List<Integer> getInOrder() {
        LinkedList<Integer> result = new LinkedList<>();
        iterate(this.root, result);
        return result;
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        //Case 1: node has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }

            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Case 2: note to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public void iterate(Node current, List<Integer> results) {
        if (current != null) {
            iterate(current.left, results);
            results.add(current.data);
            iterate(current.right, results);
        }
    }

    public boolean isBalanced(Node node) {
        int leftHeight, rightHeight;

        if (node == null) {
            return true;
        }

        leftHeight = height(node.left);
        rightHeight = height(node.right);
        return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(node.left) && isBalanced(node.right);
    }

    private boolean search(int id, Node currentNode) {
        if (Objects.isNull(currentNode)) {
            return false;
        }

        if (id == currentNode.data) {
            return true;
        } else if (id < currentNode.data) {
            return search(id, currentNode.left);
        }
        return search(id, currentNode.right);
    }

    private void insert(Node currentNode, int data) {
        if (data < currentNode.data) {
            if (currentNode.left != null) {
                insert(currentNode.left, data);
            } else {
                currentNode.left = new Node(data);
            }
        } else if (data > currentNode.data) {
            if (currentNode.right != null) {
                insert(currentNode.right, data);
            } else {
                currentNode.right = new Node(data);
            }
        }
    }

    private Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
