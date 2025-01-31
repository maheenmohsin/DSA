import java.util.LinkedList;
import java.util.Queue;
class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class TreeProperties {
    Node root;
    public boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean reachedEnd = false;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode != null) {
                if (reachedEnd) {
                    return false;
                }
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            } else {
                reachedEnd = true;
            }
        }
        return true;
    }
    public boolean isFullTree(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        return false;
    }
    public static void main(String[] args) {
        TreeProperties tree = new TreeProperties();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        boolean isComplete = tree.isCompleteTree(tree.root);
        boolean isFull = tree.isFullTree(tree.root);

        System.out.println("Is the tree a Complete Binary Tree? " + isComplete);
        System.out.println("Is the tree a Full Binary Tree? " + isFull);

        if (isComplete && isFull) {
            System.out.println("The tree is both Complete and Full.");
        } else if (!isComplete && !isFull) {
            System.out.println("The tree is neither Complete nor Full.");
        }
    }
}
