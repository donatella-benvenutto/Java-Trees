public class Tree<K, T> implements MyTree<K, T> {
    private Node<K, T> root;

    public Tree() {
        this.root = root;
    }


    @Override
    public T find(K key) {
        return findRecursive(root, key);
    }

    private T findRecursive(Node<K, T> currentNode, K key) {
        if (currentNode == null) {
            return null; // Si llegamos a una hoja vacía, retornamos null (clave no encontrada)
        }
        if (currentNode.getKey().equals(key)) {
            return currentNode.getData(); // Si la clave del nodo actual coincide con la clave buscada, retornamos su valor
        }
        // Realizamos la búsqueda en los hijos del nodo actual
        T leftResult = findRecursive(currentNode.getLeftChild(), key);
        if (leftResult != null) {
            return leftResult; // Si se encontró en el subárbol izquierdo, retornamos el resultado
        }
        return findRecursive(currentNode.getRightChild(), key); // Si no, continuamos la búsqueda en el subárbol derecho
    }

    @Override
    public void insert(K key, T data, K parentKey) {
        Node<K, T> newNode = new Node<>(key, data);

        if (parentKey == null) {
            // Si parentKey es null, el nuevo nodo será la raíz del árbol
            root = newNode;
            return;
        }

        // Buscamos el nodo padre en el árbol
        Node<K, T> parentNode = findNode(root, parentKey);
        if (parentNode == null) {
            // Si no se encuentra el nodo padre, no se puede insertar
            System.out.println("No se encontró el nodo padre");
            return;
        }

        // Insertamos el nuevo nodo como hijo de parentNode
        if (parentNode.getLeftChild() == null) {
            parentNode.setLeftChild(newNode);
        } else if (parentNode.getRightChild() == null) {
            parentNode.setRightChild(newNode);
        } else {
            // Si ambos hijos del nodo padre están ocupados, no se puede insertar
            System.out.println("No se pueden insertar más hijos en este nodo padre");
        }

    }

    // Función auxiliar para encontrar un nodo dado su clave
    private Node<K, T> findNode(Node<K, T> currentNode, K key) {
        if (currentNode == null) {
            return null; // Si llegamos a una hoja vacía, retornamos null (nodo no encontrado)
        }
        if (currentNode.getKey().equals(key)) {
            return currentNode; // Si la clave del nodo actual coincide con la clave buscada, retornamos el nodo actual
        }
        // Realizamos la búsqueda en los hijos del nodo actual
        Node<K, T> leftResult = findNode(currentNode.getLeftChild(), key);
        if (leftResult != null) {
            return leftResult; // Si se encontró en el subárbol izquierdo, retornamos el nodo encontrado
        }
        return findNode(currentNode.getRightChild(), key); // Si no, continuamos la búsqueda en el subárbol derecho
    }

    @Override
    public void delete(K key) {
        root = deleteRecursive(root, key);
    }

    // Función auxiliar recursiva para eliminar un nodo dado su clave
    private Node<K, T> deleteRecursive(Node<K, T> currentNode, K key) {
        if (currentNode == null) {
            return null; // Si llegamos a una hoja vacía, retornamos null
        }
        if (currentNode.getKey().equals(key)) {
            return null; // Si encontramos el nodo con la clave deseada, lo marcamos como nulo
        }
        // Eliminamos el nodo de los subárboles izquierdo y derecho
        currentNode.setLeftChild(deleteRecursive(currentNode.getLeftChild(), key));
        currentNode.setRightChild(deleteRecursive(currentNode.getRightChild(), key));
        return currentNode;
    }


}

    // private void insertRecursive(Node<K, T> node, K key, T data, K parentKey) {
        /*if (node == null){
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
        }*/
   // }

    //private Node<K, T> deleteRecursive(Node<K, T> node, K key) {return node;}
/*        if (node == null) {
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
        return node;*/


   /* private Node<K, T> findMin(Node<K, T> node) {
        *//*while (node.leftChild != null) {
            node = node.leftChild;
        }*//*
        return node;
    }*/



