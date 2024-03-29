package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 23:12 2021/3/13
 **/
public class Order705DesignHashset {

    boolean[] nodes = new boolean[1000009];

    public void add(int key) {
        nodes[key] = true;
    }

    public void remove(int key) {
        nodes[key] = false;
    }

    public boolean contains(int key) {
        return nodes[key];
    }

}
