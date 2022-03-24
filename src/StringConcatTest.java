public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        StringConcatImpl stringConcat = new StringConcatImpl();

        stringConcat.makeString(s1, s2);
        // 결과
        //hello, world

        StringConcat lambdaStringConcat = (ss1, ss2) -> System.out.println(ss1 + ", " + ss2);
        lambdaStringConcat.makeString(s1, s2);
        // 결과
        //hello, world

        // 람다식은 클래스 생성 없이 구현될 수 없다. 아래와 같이 생성했을 때 일반적으로 람다식을 구현했을 때에는 보이지는 않지만 내부적으로 익명 클래스를 생성해서 구현하고 있다.
        StringConcat lambdaStringConcat2 = new StringConcat() { // 내부 익명 클래스
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + "~ " + s2 + "~");
            }
        };

        lambdaStringConcat2.makeString(s1, s2);
        // 결과
        //hello~ world~
    }
}
