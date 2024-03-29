/*A binary search tree (BST) is a node based binary tree data structure which has the following properties.
        • The left subtree of a node contains only nodes with keys less than the node’s key.
        • The right subtree of a node contains only nodes with keys greater than the node’s key.
        • Both the left and right subtrees must also be binary search trees.

        From the above properties it naturally follows that:
        • Each node (item in the tree) has a distinct key.  */


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            Node tempNode=q.poll();
            System.out.print(tempNode.data+" ");
            if(tempNode.left!=null)
                q.add(tempNode.left);
            if(tempNode.right!=null)
                q.add(tempNode.right);
        }

    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

        levelOrder(tree.root);
    }
}

class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}