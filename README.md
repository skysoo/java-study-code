# 1. basic-demo 프로젝트 
Java의 기본 스펙 테스트 및 오픈 소스 툴 기능 테스트

* [알고리즘 테스트 코드 관련 패키지 ](./basic-demo/src/main/java/org/example/codingtest/)
* [오픈소스 툴 테스트 관련 패키지](./basic-demo/src/main/java/org/example/opnesource)
* [테스트에 사용되는 각종 유틸리티 패키지](./basic-demo/src/main/java/org/example/utility)
* [테스트시 사용되는 VO 클래스 패키지](./basic-demo/src/main/java/org/example/vo)


# 2. concurrency-demo 프로젝트
Java의 버전별 Concurrency 관련 지원 기능 테스트

## 2-1. Low Level Concurrency
1. Thread State
2. Synchronized
3. GuardedBlock
4. Starvation
5. Deadlock
6. Immutable
7. latch

## 2-2. High Level Concurrency
1. Future
2. ForkJoinPool
3. CompletableFuture

#### 2-2-1. Future
Java 5부터 지원된 기능으로 비동기 처리 결과의 return 값을 받을 때 사용한다.

#### 2-2-2. ForkJoinPool
Java 7부터 지원된 기능으로 Fork Join Framework의 대표적인 클래스이며, 쓰레드 풀의 일종이다.

> 즉 ForkJoinPool 은 newCachedThreadPool 이나 newFixedThreadPool 처럼 ExecutorService 의 구현체이다. 

기본 개념은 큰 업무를 작은 업무 단위로 쪼개고, 그것을 각기 다른 CPU에서 병렬로 실행한후 결과를 취합하는 방식이다.

핵심 기술은 work-stealling 이라는 기술이다. 이것은 유휴 상태의 쓰레드를 없애는 방식인데, 세부 동작은 아래와 같다. 

![ForkJoinPool img](https://postfiles.pstatic.net/20160610_241/2feelus_1465489835811BcaiD_PNG/2016-06-10_at_1.30.19_AM.png?type=w2)

만약 위 그림처럼 B 쓰레드가 모든 일을 다 처리해서 더이상 할일이 없는 경우, CPU자원이 놀게 된다(Idle). 
이런 상황에서 work-stealling이 동작하게 되면 A 쓰레드 큐에 남은 Task를 B에서 가져와서 처리를 하는 식으로 구현을 해주면 CPU가 놀지않고 최적의 성능을 낼 수 있다.

#### 2-2-3. CompletableFuture
Java 8부터 지원된 기능으로 Java 5에서 나왔던 Future 의 제한 사항들을 개선한 모델이다.

1. Future 결과값을 가지고 Non-Blocking 상태로 어떤 행동을 수행할 수 없다.
2. Multi Future Task 들의 비동기 흐름을 만들 수가 없다. 하나의 Future 가 완료된 후, 다음 Future 로의 연결이 안된다.
3. Multi Future Task 들을 서로 연결할 수 없다. 병렬로 실해하고 완료된 후, 어떤 기능을 실행하고 싶은 다른 것이 있어도 할 수 없다.
4. Future 는 결과값에 대한 어떠한 Exception 처리를 할 수 없다. 

> CompletableFuture 는 위의 Future 가 가지는 제한 사항들을 모두 수행할 수 있다. 

# 3. spring-demo 프로젝트

> SPRING JPA, CACHE 등 스프링에서 사용되는 여러 기술들을 테스트해보는 프로젝트

## 3-1. Spring Cache With Caffeine

* Caffeine 캐시를 사용해야 하는 이유
1. 크기 기반 삭제 (빈도 및 최근 사용도에 따라 최대값을 초과하는 경우)
2. 시간 기반 항목 만료, 마지막 액세스 또는 마지막 쓰기 이후 측정
3. 항목에 대한 첫번째 요청이 Missing 되었다면 비동기식으로 새로 요청
4. 제거된 항목에 대한 알림
5. 캐시 액세스에 대한 통계 축적

```java
// Cache 속성을 ENUM 클래스로 관리하여 데이터에 대한 일관성 및 가독성을 높인다.
// 또한 캐시별로 설정값을 다르게 가져갈 수 있다.
public enum CacheType {
    USERS("users",5*60, 10000),
    USER_INFO("userInfo",24*60*60, 10000);

    CacheType(String cachename, int expiredAfterWrite, int maximumSize) {
        this.cachename = cachename;
        this.expiredAfterWrite = expiredAfterWrite;
        this.maximumSize = maximumSize;
    }

    private String cachename; // 캐시명
    private int expiredAfterWrite; // 캐시 갱신 타임 
    private int maximumSize; // 캐시 크기
}
```

```java
@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
         List<CaffeineCache> caches = Arrays.stream(CacheType.values())
                 .map(cache -> new CaffeineCache(cache.getCachename(), Caffeine.newBuilder().recordStats()
                         .expireAfterWrite(cache.getExpiredAfterWrite(), TimeUnit.SECONDS)
                         .maximumSize(cache.getMaximumSize())
                         .build()))
                 .collect(Collectors.toList());

         cacheManager.setCaches(caches);
        return cacheManager;
    }
}
```

[참고 사이트](https://medium.com/programming-sharing/spring-boot-and-caffeine-cache-integration-9913da699f8c)