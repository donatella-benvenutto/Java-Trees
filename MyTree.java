import java.util.List;
public interface MyTree<K,T> {
    T find(K key);
    void insert (K key, T data, K parentKey);
    void delete (K key);
    int size(Node<K,T> node);
    int countLeaf(Node<K,T> node);
    int countCompleteElements(Node<K,T> node);
    List<K>	inOrder();
    List<K>	preOrder();
    List<K> postOrder();
    List<K> levelRoute();
    //void loadPostFijaExpression	(String	sPostFija);
}
