package concepts.data_structures;

import concepts.utils.OutputUtils;

public class Bst {
    public static class Tree {
        Tree left;
        Tree right;
        int value;

        Tree(int value) {
            this.value = value;
        }

        Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insertValue(int value, Tree head) {
            Tree node = new Tree(value);
            Tree temp = head;

            while (temp != null) {
                if (temp.value > value) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    }
                    temp = temp.left;
                } else if (temp.value < value) {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    }
                    temp = temp.right;
                }
            }
            return;
        }

        public Tree removeValue(int value, Tree head) {
            Tree temp = head;

            if(temp.value == value){
                Tree nodeToBeReplaced = isolateRightMostSuccessorOfNode(head.left);
                OutputUtils.printKeys("Setting: head as: ",
                    Integer.toString(nodeToBeReplaced.value), " deleting : ", Integer.toString(head.value));
                nodeToBeReplaced.right = head.right;
                return nodeToBeReplaced;
            }

            while (temp != null) {
                Tree rightChild = temp.right;
                Tree leftChild = temp.left;

                if (rightChild != null && rightChild.value == value) {
                    removeNode(temp, rightChild, false);
                    return head;
                } else if (leftChild != null && leftChild.value == value) {
                    removeNode(temp, leftChild, true);
                    return head;
                } else {
                    if (temp.value > value) {
                        temp = temp.left;
                    } else {
                        temp = temp.right;
                    }
                }
            }

            OutputUtils.printKeys(Integer.toString(value), "not found in the tree");
            return head;
        }

        private void removeNode(Tree parentNode, Tree nodeToBeDeleted, boolean isLeftChild) {
            Tree nodeToBeReplaced = null;
            if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
                // delete leaf node
                nodeToBeReplaced = null;
            } else if (nodeToBeDeleted.left == null || nodeToBeDeleted.right == null) {
                // single child
                nodeToBeReplaced = nodeToBeDeleted.left == null ? nodeToBeDeleted.right : nodeToBeDeleted.left;
            } else {
                /*
                 * 2 children -> 2 approaches
                 * 1. Find largest element to the left of nodeToBeDeleted
                 * 2. Find smallest element to the right of nodeToBeDeleted
                 * Going with 1 here.
                 */
                Tree temp = isolateRightMostSuccessorOfNode(nodeToBeDeleted.left);
                nodeToBeReplaced = temp;
            }

            OutputUtils.printKeys("Setting: ", Integer.toString(parentNode.value), "'s child as: ",
                    Integer.toString(nodeToBeReplaced.value), " deleting : ", Integer.toString(nodeToBeDeleted.value));
            if (isLeftChild) {
                parentNode.left = nodeToBeReplaced;
            } else {
                parentNode.right = nodeToBeReplaced;
            }
        }

        private Tree isolateRightMostSuccessorOfNode(Tree temp){
            Tree parent = temp;
            
            while (temp.right != null) {
                parent = temp;
                temp = temp.right;
            }
            if(parent != temp){
                parent.right = temp.left;
            }

            return temp;
        }

        void preorder(Tree head){
            System.out.println("-------------------Preorder-------------------");
            printPreorder(head);
            System.out.println();
            System.out.println("-------------------Preorder-------------------");
        }
    
        private void printPreorder(Tree head) {
            if (head == null) {
                System.out.print("null ");
                return;
            } else {
                System.out.print(head.value + " ");
                printPreorder(head.left);
                printPreorder(head.right);
            }
        }
    }

    public static void main(String args[]) {
        Tree head = new Tree(10);

        for (int i = 0; i < 10; i++) {
            head.insertValue(i * 10 + i * 3, head);
        }

        head.preorder(head);
        head = head.removeValue(10, head);
        head.preorder(head);
        head = head.removeValue(4*10 + 4*3, head);
        head.preorder(head);
    }
}
