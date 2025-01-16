package w3_6_oop;

import lombok.*;
//import lombok.Value;
//import lombok.experimental.FieldDefaults;
//
//import java.beans.BeanProperty;

// @Data
@Getter @Setter
@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
@RequiredArgsConstructor
// @AllArgsConstructor
// @Builder
@Value  // final private 일괄 적용
public class LombokUsageSample {
    @NonNull
    final private int age;
    final private boolean employed;

    /* lombok 을 사용하면 아래와 같은 메서드를 수동 생성할 필요가 없어짐
    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isEmployed() {
        return employed;
    }
    */

    // @BeanProperty
    public static void main(String[] args) {
//        LombokUsageSample sul = new LombokUsageSample();
//        System.out.println(sul.getAge());
//        sul.setAge(30);
//        System.out.println(sul.getAge());
//
//        System.out.println(sul.isEmployed());
//        sul.setEmployed(true);
//        System.out.println(sul.isEmployed());

        // System.out.println(sul);

//        LombokUsageSample myLombokObj1 = new LombokUsageSample(
//            1
//        );
        LombokUsageSample myLombokObj2 = new LombokUsageSample(
            1, false
        );
    }
}