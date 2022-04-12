package Object_grammer07;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

enum TestType{
    FIRST,FINAL
}
@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
    String yymmdd();
    String hhmmss();
}
@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용가능하도록 지정
@interface TestInfo{
    int count() default 1;
    String testedBy();
    String[] testTools() default {"JUnit", "JUnit5"};
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101", hhmmss="235959"))
public class ch12_29_메타애너테이션 {
    /*******************************************************************
     * 메타 애너테이션
     * 애너테이션을 위한 애너테이션 (애너테이션을 만들때 사용)
     * java.lang.annotation 패키지에 포함
     * Type -> 클래스 or 인터페이스, FIELD -> iv, cv, TYPE_USE -> 참조변수
     * @Target : 애너테이션을 정의할때, 적용대상 지정에 사용
     * @Retention : 애너테이션이 유지되는 기간을 지정하는데 사용 (SOURCE, CLASS, RUNTIME)
     * @Documented : javadoc으로 작성한 문서에 포함시키려면 사용
     * @Inherited : 애너테이션을 자손 클래스에 상속하고자 할때 사용
     * @Repeatable : 반복해서 붙일 수 있는 애너테이션을 정의할 때 사용 (@ToDo)
     *               Repeatable인 @ToDo를 하나로 묶을 컨테이너 애너테이션도 정의해야 함
     *******************************************************************/
    /*******************************************************************
     * 애너테이션 타입 정의하기
     * @interface 애너테이션이름 {
     *     타입 요소이름(); // 애너테이션의 요소를 선언한다.
     * }
     * 애너테이션의 메서드는 추상메서드이며, 애너테이션을 적용할 때 지정 (순서 X)
     *******************************************************************/
    /*******************************************************************
     * 애너테이션의 요소
     * 적용시 값을 지정하지 않으면, 사용될 수 있는 기본값 지정 가능 (null 제외)
     * 요소가 하나이고 이름이 value일 때는 요소의 이름 생략가능 ex: @Test("passed")
     * 요소의 타입이 배열인 경우, 괄호{}를 사용해야 한다. ex: @Test(testTools={"JUniut", "AutoTester"})
     *******************************************************************/
    /*******************************************************************
     * 모든 애너테이션의 조상 - java.lang.annotation.Annotation
     * Annotation은 모든 애너테이션의 조상이지만 상손은 불가
     * 사실 Annotation은 인터페이스이다. (조상이가지고 있는 추상메서드 사용가능)
     *******************************************************************/
    /*******************************************************************
     * 마커 애너테이션
     * 요소가 하나도 정의되지 않은 애너테이션
     * 애너테이션이 붙어있는 것만으로도 충분한 정보를 준다고 봄
     *******************************************************************/
    /*******************************************************************
     * 애너테이션 요소의 규칙
     * 애너테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야 한다.
     * - 요소의 타입은 기본형, String, enum, 애너테이션, Class만 허용됨
     * - 괄호()안에 매개변수를 선언할 수 없다.
     * - 예외를 선언할 수 없다.
     * - 요소를 타입 매개변수로 정의할 수 없다.
     *******************************************************************/
    public static void main(String[] args) {
        Class<ch12_29_메타애너테이션> cls = ch12_29_메타애너테이션.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

        for(String str : anno.testTools()){
            System.out.println("testTools = " + str);
        }
        System.out.println();
        
        // 현 클래스에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();
        for(Annotation a : annoArr){
            System.out.println(a);
        }
    } // main의 끝
}
