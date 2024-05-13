public class Node<K, T> {
    private K key;
    private T data;
    private Node<K, T> leftChild;
    private Node<K, T> rightChild;

    public Node(K key, T data) {
        this.key = key;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }

   /* public Node<K, T> findNode(K key) {
        if (key == this.key) {
            return this;
        } else {
            if (this.rightChild != null) {
                Node<K, T> value = this.rightChild.findNode(key);
                if (value != null) {
                    return value;
                }
            }
            if (this.leftChild != null) {
                Node<K, T> value = this.leftChild.findNode(key);
                if (value != null) {
                    return value;
                }
            }
            return null;
        }
    }*/
}