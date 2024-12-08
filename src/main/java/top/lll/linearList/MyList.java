package top.lll.linearList;

public interface MyList<E> {
    //增加
    void add(int index, E element);

    boolean add(E element);

    //删除
    E remove(int index);

    //修改
    E set(int index, E element);

    //是否包含某个元素
    boolean contains(E element);

    //查找数组中是否包含值，若有，返回下标；如没有，返回-1.
    int indexOf(E element);

    //返回下标对应的元素值
    E get(int index);

    //返回数组长度
    int size();

    //判断数组是否为空
    boolean isEmpty();

    //清空数组
    void clean();

    String toString();
}
