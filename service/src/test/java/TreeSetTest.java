import org.junit.jupiter.api.Test;

import java.util.TreeSet;

/**
 * spring.PACKAGE_NAME.TreeSet
 *
 * @author 张奥
 * @date 2023/02/07 星期二 19:43
 * @description
 */
public class TreeSetTest {
    @Test
    public void method1(){
        TreeSet<Person> tree = new TreeSet<>(){{
            add(new Person(1,"张三",22));
            add(new Person(2,"李四",12));
            add(new Person(3,"王五",62));
            add(new Person(4,"赵六",42));
            add(new Person(5,"猴七",23));
            add(new Person(6,"狗八",15));
        }};
        tree.forEach((v) -> {
            System.out.format("k = %s\n", v);
        });
    }
    @Test
    public void method2(){
        //外部比较器
        TreeSet<Person> tree = new TreeSet<>(
                (o1, o2) -> o2.getAge()-o1.getAge()){{
            add(new Person(1,"张三",22));
            add(new Person(2,"李四",12));
            add(new Person(3,"王五",62));
            add(new Person(4,"赵六",42));
            add(new Person(5,"猴七",23));
            add(new Person(6,"狗八",15));
        }};
        tree.forEach((v) -> {
            System.out.format("k = %s\n", v);
        });
    }
}
