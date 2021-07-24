import java.util.Scanner;

 class Node1 {
    Node1 left;
    Node1 right;
    int data;

    Node1(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}

public  class HeighOfBinaryTree {
    public static Node1 insert(Node1 root, int data) {
        if(root == null) {
            return new Node1(data);
        } else {
            Node1 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static int height(Node1 root) {
        if(root == null) {
            return -1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = 6;
        Node1 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}







