# Java Thread

주제와 관련된 모든 예제는 [여기](https://github.com/leeheefull/blog-source/tree/main/java/src/main/java/thread)에 있습니다.

　

　

## Thread

　

스레드란, 프로세스 내에서 작업을 수행하는 주체를 의미합니다. 하나의 프로세스(프로그램) 안에서는 여러 개의 스레드를 사용할 수 있습니다.

　

자바에서는 스레드를 인스턴스로 선언하여 사용할 수 있습니다. 각 스레드마다 run()이라는 일종의 main 메서드를 가지고 있고 run() 메서드를 통해서 작업을 처리하게 됩니다.

　

　

　

　

## Runnable

　

　

![Runnable interface](https://user-images.githubusercontent.com/58816862/165680300-80894cba-ddd2-4edc-900f-e5b6bf14757d.png)

Runnable interface

　

자바에서 [Thread](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)는 [Runnable](https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html)이라는 인터페이스를 구현하고 있습니다. 러너블 인터페이스는 함수형 인터페이스로서 스레드의 작업 행위를 구현할 수 있게 합니다.

　

　

　

　

## extends Thread vs implement Runnable

　

스레드 구현 법은 크게 두 가지가 있습니다. 첫 번째는 스레드를 상속받아 사용하는 것이고 두 번째는 러너블을 구현하여 스레드에 주입하는 것입니다.

　

![스레드 상속](https://user-images.githubusercontent.com/58816862/165681536-bdd144d0-6291-4457-a1f1-ca8f8e799758.png)

스레드 상속

　

![러너블 구현](https://user-images.githubusercontent.com/58816862/165681593-5cf32f2f-aea9-4044-ba39-2988d04d5153.png)

러너블 구현

　

![테스트](https://user-images.githubusercontent.com/58816862/166131696-5d8ed94e-4897-41cf-97e8-2726e9961cba.png)

테스트

　

![결과 (서로 비동기)](https://user-images.githubusercontent.com/58816862/165685308-b783a307-50cf-48c0-9f89-a748db992428.png)

결과 (서로 비동기)

　

주의할 점은 러너블의 run()은 동기 메서드라는 것입니다. 스레드의 start() 메서드를 사용해서 러너블의 run() 메서드를 비동기 처리할 수 있습니다.

　

　

　

### 두 가지 방법이 있는 이유?

　

![https://user-images.githubusercontent.com/58816862/166131970-bb05ce0c-b156-41cf-8bb1-fa70cbb39bf4.png](https://user-images.githubusercontent.com/58816862/166131970-bb05ce0c-b156-41cf-8bb1-fa70cbb39bf4.png)

　

![https://user-images.githubusercontent.com/58816862/166131958-4af243b3-b881-4c9c-bd7d-76c9f4e79dee.png](https://user-images.githubusercontent.com/58816862/166131958-4af243b3-b881-4c9c-bd7d-76c9f4e79dee.png)

　

![https://user-images.githubusercontent.com/58816862/166131982-0f4d26f3-b3bd-4ca2-ab86-a88ff35bfbf2.png](https://user-images.githubusercontent.com/58816862/166131982-0f4d26f3-b3bd-4ca2-ab86-a88ff35bfbf2.png)

　

위처럼, Person 클래스가 Animal 클래스를 상속을 받는 상황에서 Person 클래스를 스레드로 구현할 수는 없습니다. 자바에서 다중 상속을 지원하지 않기 때문입니다. 그래서, 위와 같은 상황에서는 러너블 인터페이스를 사용합니다.

　

　

　

　

## Thread ID

　

![https://user-images.githubusercontent.com/58816862/165712985-74cd05c4-a749-47fa-abe9-93556d864353.png](https://user-images.githubusercontent.com/58816862/165712985-74cd05c4-a749-47fa-abe9-93556d864353.png)

　

고유한 값으로서 스레드를 식별할 수 있습니다. getId()를 통해서 값을 가져올 수 있습니다.

　

　

　

　

## Thread Name

　

![https://user-images.githubusercontent.com/58816862/165713087-6d38c9a4-2a83-4ca0-bc72-cc1f9eec53cc.png](https://user-images.githubusercontent.com/58816862/165713087-6d38c9a4-2a83-4ca0-bc72-cc1f9eec53cc.png)

　

스레드의 이름입니다. setName()을 통해서 스레드의 이름을 설정할 수 있으며, getName()으로 가져올 수 있습니다.

　

　

　

　

## Thread state

　

![https://user-images.githubusercontent.com/58816862/165727434-3d1f60b9-21f8-43c1-95b6-5a5646b1f993.png](https://user-images.githubusercontent.com/58816862/165727434-3d1f60b9-21f8-43c1-95b6-5a5646b1f993.png)

　

### New

　

스레드 생성 상태, 프로세스가 메모리에 올라와 실행 준비를 완료한 상태입니다. 스레드가 생성되고 start()가 호출되지 않은 상태입니다.

　

　

### Ready (Runnable)

　

스레드 준비 상태, 생성된 프로세스가 CPU를 얻을 때까지 기다리는 상태입니다. start() 메서드가 호출된 상태입니다. 실행 상태로 언제든지 갈 수 있는 상태입니다.

　

　

### Running (Runnable)

　

스레드 실행 대기 상태, run() 메서드가 호출된 상태입니다.

　

　

### Waiting

　

스레드 대기 상태, 다른 스레드가 통지할 때까지 기다리는 상태입니다.

　

　

### Timed waiting

　

스레드 시간 대기 상태, 주어진 시간 동안 기다리는 상태입니다.

　

　

### Blocked

　

스레드 봉쇄 상태, 사용하고자 하는 객체의 락이 풀릴 때까지 기다리는 상태입니다.

　

　

### Terminated

　

스레드 종료 상태, 실행을 마친 상태입니다.

　

　

　

　

## Thread method

　

![https://user-images.githubusercontent.com/58816862/165716848-07089447-3561-4687-8876-4620adc8deda.png](https://user-images.githubusercontent.com/58816862/165716848-07089447-3561-4687-8876-4620adc8deda.png)

　

### run()

　

스레드의 작업을 갖고 있는 메서드입니다.

　

　

### start()

　

run() 메서드를 비동기 처리하는 메서드입니다.

　

　

### sleep()

　

주어진 시간 동안 스레드를 일시 정지 상태로 만듭니다. 주어진 시간이 지나면 자동적으로 실행 대기 상태가 됩니다.

　

　

### yield()

　

실행 중에 우선순위가 동일한 다른 스레드에게 실행을 양보하고 실행 대기 상태가 됩니다.

　

　

### isAlive()

　

스레드가 살아있는지 확인합니다. 스레드가 시작되었고 아직 죽지 않은 경우 true를 반환합니다.

　

　

### join()

　

join() 메서드를 호출한 스레드는 일시 정지 상태가 됩니다. 실행 대기 상태로 가려면, join() 메서드를 멤버로 가지는 스레드가 종료되거나, 매개 값으로 주어진 시간이 지나야 합니다.

　

　

### interrupt()

　

sleep(), join(), wait()에 의해 일시 정지 상태인 스레드에서 InterruptedException 예외를 발생시켜, 예외처리 코드(catch)로 보냅니다. catch문에서 실행 대기 상태로 가거나 종료 상태로 갈 수 있도록 합니다.

　

　

### wait()

　

동기화(synchronized) 블록 내에서 스레드를 일시 정지 상태로 만듭니다. 매개 값으로 주어진 시간이 지나면 자동적으로 실행 대기 상태가 됩니다. 시간이 주어지지 않으면 notify(), notifyAll() 메서드에 의해 실행 대기 상태로 갈 수 있습니다.

　

　

### notify() / notifyAll()

　

동기화 블록 내에서 wait() 메서드에 의해 일시 정지 상태에 있는 스레드를 실행 대기 상태로 만듭니다.

　

　

　

　

## Priority

　

스레드의 우선순위를 설정할 수 있습니다. min(0) ~ max(10)이고 클수록 높은 우선순위를 갖습니다.

　

　

　

　

## Daemon thread

　

보조적인 스레드로서, 업무를 직접적으로 다루지 않고 업무를 다루는 스레드들을 돕는 역할을 합니다. 데몬 스레드는 본인이 주된 업무를 갖고 있지 않기 때문에 다른 스레드들이 종료된다면, 더 이상 진행할 이유가 없기 때문에 그대로 종료하게 됩니다. 그래서 보통 데몬스레드의 우선순위는 최소로 낮춥니다.

　

데몬 스레드의 대표적인 예시로는 가비지 컬렉터가 있습니다. 이처럼 자원을 만들기만 하고 소거하지 않거나 공유자원의 데이터가 결함이 있는지 체크해야 하는 등의 경우에는 데몬 스레드를 사용하여 해결합니다.

　

　

　

이렇게 자바에서 스레드를 사용하는 기본 방법에 대해 알아보았습니다. 이후에는 동시성 문제해 대해 이해하고 해결하는 방법에 대해 정리하도록 하겠습니다. 이상입니다. 수정 사항이나 피드백이 있으시다면 편하게 댓글 부탁드리겠습니다. 글 읽어 주셔서 감사합니다.