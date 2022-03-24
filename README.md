# 객체 지향 프로그래밍 VS 람다식 구현

## 객체 지향 프로그래밍과 람다식 비교

- 문자열 두 개를 연결하여 출력하는 예제를 두 가지 방식으로 구현해 보자.
- 인터페이스 선언

```java
public interface StringConcat {
    public void makeString(String s1, String s2);
}
```

- 객체 지향 프로그래밍으로 구현하기

인터페이스를 구현한 클래스 만들기

```java
public class StringConcatImpl implements StringConcat {
    @override
    public void makeString(String s1, String s2) {
        System.out.println(s1 + ", " + s2);
    }
}
```

클래스를 생성하고 메서드 호출하기

```java
public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        StringConcatImpl stringConcat = new StringConcatImpl();

        stringConcat.makeString(s1, s2);
        // 결과
        //hello, world
    }
}
```

- 람다식으로 구현하기

```java
public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        StringConcat lambdaStringConcat = (ss1, ss2) -> System.out.println(ss1 + ", " + ss2);
        lambdaStringConcat.makeString(s1, s2);
        // 결과
        //hello, world
    }
}
```

## 익명 객체를 생성하는 람다식

- JAVA에서는 객체 없이 메서드가 호출될 수 없음.
- 람다식을 구현하면 내부 익명 클래스가 만들어지고, 이를 통해 익명 객체가 생성됨.

```java
public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

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
```

- 익명 내부 클래스에서와 마찬가지로 람다식 내부에서도 외부에 있는 지역 변수의 값을 변경하면 오류가 발생함.

## 함수를 변수처럼 사용하는 람다식

변수는...

특정 자료형으로 변수를 선언한 후 값을 대입함.    int a = 10;
매개 변수로 전달하여 사용함.    int add(int x, int y)
메서드의 반환값으로 반환하기.    return num;

- 인터페이스형 변수에 람다식 대입하기

함수형 인터페이스

```java
interface PrintString {
    public void showString(String str);
}
```

```java
PrintString lambdaStr = s -> System.out.println(s); // 람다식으로 변수에 대입
lambdaStr.showString("hello lambda_1");
```

- 매개 변수로 전달하는 람다식

```java
showMyString(lambdaStr);

public static void showMyString(PrintString p) {
    p.showString("hello lambda_2");
}
```

- 반환값으로 쓰이는 람다식

```java
public static PrintString returnString() { // 반환값으로 사용
    return s -> System.out.println(s + "world");
}

PrintString reStr = returnString();
reStr.showString("hello");
```