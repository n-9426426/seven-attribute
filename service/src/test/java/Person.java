import lombok.*;
import lombok.experimental.Accessors;

/**
 * spring.PACKAGE_NAME.Person
 *
 * @author 张奥
 * @date 2023/02/07 星期二 19:44
 * @description 内部比较器 见row17
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Accessors(chain = true)
//public class Person implements Comparable<Person>{
public class Person{
    private Integer id;
    private String name;
    private Integer age;
}
