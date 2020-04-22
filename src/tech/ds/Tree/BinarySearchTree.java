package tech.ds.Tree;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(int value){
        root = addNodeInBST(root, value);
    }

    private Node addNodeInBST(Node currentNode, int value){
        //This condition for:
        //1. If tree is empty then create a root node.
        //2. And it will generate node for new value at the end of the recursion return in tree.
        //Example: For last node in tree call will be => addNodeInBST(null, value)
        if (currentNode == null){
            return new Node(value);
        }

        //check new value will insert at left or right side?
        if(value < currentNode.value){
            currentNode.left = addNodeInBST(currentNode.left, value);
        }
        else if(value > currentNode.value){
            currentNode.right = addNodeInBST(currentNode.right, value);
        }

        //1. For new node, it will insert the address in last node recursion call.
        //Example: currentNode.left = currentNode {return new Node(value);}
        // 2. Also for previous recursion call it will update the same address.
        return currentNode;
    }

    public Node search(Node root, int value){
        if (root == null){
            return null;
        }

        if (value < root.value){
            root = search(root.left, value);
        }else if (value > root.value){
            root = search(root.right, value);
        }
        return root;
    }

    public boolean deleteTwoChildNode(Node root, int value){
        if(root == null){
            return false;
        }
        Node delPar = root;
        while(true){
            if (value != root.value){
                delPar = root;
            }
            if(value < root.value){
                root = root.left;
            }else if(value > root.value){
                root = root.right;
            }else{
                break;
            }
        }

        System.out.println("Node: "+root.value);
        System.out.println("Node Par: "+delPar.value);

        Node suc = root.right.left;
        Node sucPar = root.right;


        while(suc.left != null){
            sucPar = suc;
            suc = suc.left;
        }

        System.out.println("SucPar: "+sucPar.value);
        System.out.println("Suc: "+suc.value);

        if(suc.right != null){
            sucPar.left = suc.right;
        }else{
            sucPar.left = null;
        }

        suc.left = root.left;
        suc.right = root.right;
        if (delPar.left == root){
            delPar.left = suc;
        }else{
            delPar.right = suc;
        }
        return true;
    }
}
