public class Tree<K, T> implements MyTree<K, T> {
    private Node<K,T> root;

    public Tree() {
        this.root = root;
    }

    @Override
    public T find(K key){
        return findRecursive(root,key);
    }
    @Override
    public void insert(K key, T data, K parentKey){
        if (root == null) {
            root = new Node<>(key, data);
        } else {
            insertRecursive(root, key, data, parentKey);
        }
    }
    @Override
    public void delete(K key) {
        root = deleteRecursive(root, key);
    }

    // Métodos auxiliares recursivos

    private T findRecursive(Node<K, T> node, K key) {
        return node.findNode(key).getData();
    }

    private void insertRecursive(Node<K, T> node, K key, T data, K parentKey) {
        if (node == null){
            return;
        }
        if (parentKey.equals(node.getKey())){
            if (node.getLeftChild().equals(null)){
                node.setLeftChild(new Node<>(key, data));
            } else if (node.getRightChild().equals(null)){
                node.setRightChild(new Node<>(key, data));
            }
        } else {
            insertRecursive(node.getRightChild(), key, data, parentKey);
            insertRecursive(node.getLeftChild(), key, data, parentKey);
        }
        Node<K,T> nodeInsert = new Node<>(key,data);

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(key, data);
            } else {
                insertRecursive(node.leftChild, key, data, parentKey);
            }
        } else if (compare > 0) {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(key, data);
            } else {
                insertRecursive(node.rightChild, key, data, parentKey);
            }
        }
    }

    private Node<K, T> deleteRecursive(Node<K, T> node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.leftChild = deleteRecursive(node.leftChild, key);
        } else if (compare > 0) {
            node.rightChild = deleteRecursive(node.rightChild, key);
        } else {
            // Caso 1: Sin hijos
            if (node.leftChild == null && node.rightChild == null) {
                return null;
            }
            // Caso 2: Un hijo
            if (node.leftChild == null) {
                return node.rightChild;
            }
            if (node.rightChild == null) {
                return node.leftChild;
            }
            // Caso 3: Dos hijos
            Node<K, T> successor = findMin(node.rightChild);
            node.key = successor.key;
            node.data = successor.data;
            node.rightChild = deleteRecursive(node.rightChild, successor.key);
        }
        return node;
    }

    private Node<K, T> findMin(Node<K, T> node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }


}
