public class ChildrenSumProperty {
    TreeNode root;
    boolean isChildrenSumProperty(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true; // An empty node or leaf node satisfies the property
        }

        int leftData = (node.left != null) ? node.left.data : 0;
        int rightData = (node.right != null) ? node.right.data : 0;

        return (node.data == leftData + rightData) &&
                isChildrenSumProperty(node.left) &&
                isChildrenSumProperty(node.right);
    }
    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(2);
        if (tree.isChildrenSumProperty(tree.root)) {
            System.out.println("The tree satisfies the children sum property.");
        } else {
            System.out.println("The tree does not satisfy the children sum property.");
        }
    }
}
