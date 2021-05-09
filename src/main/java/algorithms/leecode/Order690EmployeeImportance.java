package algorithms.leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 *
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Order690EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer,Employee> map = new HashMap<>(employees.size());
            employees.parallelStream().forEach(employee -> {
                map.putIfAbsent(employee.id,employee);
            });
            Employee leader = map.get(id);
            int ret = map.get(id).importance;
            Deque<Integer> stack = new LinkedList<>(leader.subordinates);
            while(!stack.isEmpty()){
                Employee employee = map.get(stack.pop());
                ret+=employee.importance;
                stack.addAll(employee.subordinates);
            }
            return ret;
        }
    }
}
