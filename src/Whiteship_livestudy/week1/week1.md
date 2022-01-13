# 1주차 - JVM은 무엇이며 자바 코드는 어떻게 실행하는가



##### 목표

- 자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하자.



##### 학습할 것

- JVM이란 무엇인가
- 컴파일 하는 방법
- 실행하는 방법
- 바이트코드란 무엇인가
- JIT 컴파일러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이



---



### I. JVM 이란 무엇인가?

JVM이란 Java Virtual Machine의 줄임말으로, 우리가 작성한 소스프로그램을 실행하기 위해선 컴파일 과정을 거치는데 이때 타겟 머신에 종속적인 문제가 있을 수 있다. 자바의 핵심인 Write once, run anywhere을 보장하기 위해서 여러 타겟 머신에 대해서 각각에 대한 JVM이 중간에서 애뮬레이터의 역할을 수행한다.
그 결과 자바를 운영체제에 독립적인 언어라고 부를 수 있게 되었다.



<img src="https://techvidvan.com/tutorials/wp-content/uploads/sites/2/2020/06/Working-of-JVM.jpg" alt="JVM - Java Virtual Machine Working and Architecture - TechVidvan" style="zoom:67%;" />

> https://techvidvan.com/tutorials/java-virtual-machine/

위의 그림을 보면, Java로 작성된 소스 프로그램 또는 어플리케이션은 컴파일 이후 Java Bytecode로 변환된다. 이렇게 생성된 Java Bytecode는 타겟 머신에 맞는 JVM에 전달하고 JVM이 자신의 환경에 맞게 다시 인터프리팅 하는 과정을 거친다.

> 컴파일러 구성 강의 - 이때 bytecode는 중간 코드의 한 종류이다.



- 컴파일? 인터프리팅?

> 컴파일러 : 고급 언어로 작성된 소스프로그램을 어떤 특정한 "컴퓨터"에서 직접 실행 가능한 형태의 프로그램으로 번역해주는 프로그램
>
> 인터프리터 : 목적 언어(object code)로 변환하지 않고, 직접 실행해서, 그 결과를 출력해주는 프로그램

<img src="https://static.javatpoint.com/core/images/java-interpreter.png" alt="자바 인터프리터" style="zoom:67%;" />

> https://www.javatpoint.com/java-interpreter



##### 컴파일 & 실행하는 방법

- 일단 다음과 같은 소스 프로그램이 있다고 하자.

  ``` java
  package Whiteship_livestudy.week1;
  
  public class Student {
      private String s_name;
      private String s_addr;
      private String s_pwd;
      private String s_college;
      private String s_major;
  
      public Student() {
          s_name = null;
          s_addr = null;
          s_pwd = null;
          s_college = null;
          s_major = null;
      }
  
      public String getS_name() {
          return this.s_name;
      }
  
      public void setS_name(String s_name) {
          this.s_name = s_name;
      }
  
      public String getS_addr() {
          return this.s_addr;
      }
  
      public void setS_addr(String s_addr) {
          this.s_addr = s_addr;
      }
  
      public String getS_pwd() {
          return this.s_pwd;
      }
  
      public void setS_pwd(String s_pwd) {
          this.s_pwd = s_pwd;
      }
  
      public String getS_college() {
          return this.s_college;
      }
  
      public void setS_college(String s_college) {
          this.s_college = s_college;
      }
  
      public String getS_major() {
          return this.s_major;
      }
  
      public void setS_major(String s_major) {
          this.s_major = s_major;
      }
  
  }
  ```

- `javac` 명령어를 이용하여 컴파일을 진행할 수 있다.

  기본적으로 아래와 같은 형태를 띈다.

  ``` 
  javac filename.java
  ```



##### 조심할 것 ! 패키지 구조 관계

- 해당 예제에서 패키지 경로를 같이 명시해줘야 해당 클래스의 위치가 올바르게 전달된다. 

- 안그러면 `NoClassDefFoundError` 발생

  > https://yangbox.tistory.com/117



- 실행은 `java` 명령어를 이용하여 인터프리터를 실행한다.





##### 바이트코드란?

- 컴파일러는 `고급 언어로 작성된 소스 프로그램`을 어떤 특정한 "컴퓨터"에서 `직접 실행 가능한 형태`의 프로그램으로 번역(translator)해주는 프로그램이다.

  > 해당 구조를 그대로 따른 다면, 언어마다, 기계마다 하나의 컴파일러가 필요해 N개의 언어, M개의 기계에 대해
  >
  > N*M 개의 컴파일러가 필요하게 된다.

- 그러한 비효율성을 없애기 위해 언어에 의존적인 부분, 기계에 의존적인 부분을 각각 컴파일러의 전단부, 후반부로 나누어 N+M개의 컴파일러만 필요하게 된다.

  > - Front End (전반부) : 소스 프로그램을 분석하고, `중간 코드` (Intermidiate Code)를 생성한다.
      >   - Lanagues denpendent part 이다.
  > - Back End : 전반부에서 생성한 I.C 를 특정 기계를 위한 목적 코드로 번역/변환 하는 작업을 한다.
      >   - Machine dependent part 이다.



- 바이트코드는 스택 가상 머신을 이용하는 중간 코드의 한 종류이다.

  > 자바 프로그래밍 환경에서 지원하는 중간언어.
  >
  > 여러 실행 환경에서 적합하도록 설계된 스택 기반의 가상 기계 코드.
  >
  > 이식성과 유연성이 높다는 것이 장점
  >
  > 바이트코드 명령어 집합은 JVM으로 전달되어 인터프리터 방식과 JIT(Just-In-Time) 컴파일러 방식에 의해 실행되어짐.
  >
  > 명령어 형식은 하나의 opcode, 여러개의 operand 부분으로 구성됨.





`중간 코드` 란 컴파일러의 전단부와 후단부를 연결해주는 중간 형태의 코드를 말하며, `중간 언어` 라고도 포괄적으로 지칭된다.

중간 언어를 사용함으로서 얻은 **장점**은

- 컴파일러의 기능별 모듈화
- 이식성(portability)
- high level 언어와 low level 언어의 의미적인 차이(semantic gap)을 이어주어 번역이 좀 더 쉽게, 효율적으로 처리
- 중간 코드를 이용한 최적화로, 기계와 독립적인 최적화가 가능.
    - 기계 코드로 바뀐 상태에서 하는 것보다 효율적으로 가능해짐
- 인터프리티브 컴파일링 시스템에서 인터프리터를 이용하여 실행할 수 있는 등의 장점이 있다.

**단점**은

- 목적 코드로 직접 번역하는 것보다 컴파일 시간 더 많이 소요, 비효율적인 코드 생산의 가능성이 있다.
    - 최적화를 통해 극복할 수 있다.





### 2. JIT 컴파일러란?



앞서 자바 인터프리터의 장점은

- 빠르게 바이트코드를 로드하고 자바 어플리케이션을 해당 머신에 맞게 번역하여 바로 실행할 수 있었다.

그러나 단점으로

- 최적화가 되어 있지 않아, 한 라인의 명령어를 한번에 처리하여 속도가 느려지며,
- 같은 코드가 반복적으로 기계 코드로 변한되는 단점이 있다.

