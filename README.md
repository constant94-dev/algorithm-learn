## 알고리즘 문제풀이

<h3> 24.08 (leetcode) </h3>

`Array`
  
  + Two Sum (problem number 1)
  + Best Time to Buy and Sell Stock (problem number 121)
  + Insert Interval (problem number 57)
  + Majority Element (problem number 169)
  + Contains Duplicate (problem number 217)
  + Move Zeroes (problem number 283)
  

<h3> 24.09 (leetcode) </h3>

`Array`

  + Squares of a Sorted Array (problem number 977)

`String`

  + Valid Palindrome (problem number 125)
  + Valid Anagram (problem number 242)
  + Longest Palindrome (problem number 409)
  + Longest Common Prefix (problem number 14)

`Math`

  + Roman To Integer (problem number 13)
  + Palindrome Number (problem number 9)

`Stack`

  + Valid Parentheses (problem number 20)
  + Implement Queue Using Stacks (problem number 232)
  + Backspace String Compare (problem number 844)

`Binary`

  + Add Binary (problem number 67)
  + Counting Bits (problem number 338)

---
<h3> Looking back on issue </h3>

`problem number 121`
  
  + 첫 접근은 재귀적 접근으로 풀이
  + 시간 복잡도 O(N) 제한사항인걸 알았지만 실제 코드를 작성해보니 O(N^2)
  + 재귀적 접근으로만 생각하니 O(N) 솔루션이 생각 안남
  + discuss 참고 후 새로운 접근법 적용 O(N)
  + 아직 문제를 읽을 때 재귀가 필요한지 아닌지 구분 어려움
  + solution. 재귀를 먼저 떠올리기 보다 입력을 순회하며 처리하는 방안을 먼저 고려하자.

`problem number 57`
  
  + 2차원 리스트 → 2차원 배열로 변환
  + 새로운 배열의 end값이 비교중인 기존 배열 start값 보다 작다면 다음 요소들을 붙여서 반환
  + 기존 배열이 비어있을 경우 새로운 배열만 반환

`problem number 217`
  
  + 첫 접근은 입력으로 주어진 배열의 각 수를 인덱스 번호로하는 새로운 인덱스 생성
  + 새로운 배열의 인덱스를 입력 배열의 각 수가 출현하면 증가
  + IndexOutOfBoundsException 발생
    + 입력이 음수일 경우
    + 입력 배열 중 {1,2,3,100000}일 경우
    + 입력 배열이 하나일 경우
  + 위 오류를 배열로만 처리하려다보니 경우의 수가 많아짐
  + 고민하다 solution 확인. HashSet 구현해 해결.

`problem number 283`

  + 첫 접근은 입력으로 주어진 배열을 순회하며 '0' 위치를 끝 요소로 이동
  + 결과적으로 앞 요소는 정렬되지 않은 수 가 된다
  + 모두 이동 후 '0' 인덱스 전 까지 정렬을 해주었다
  + 하지만, 문제에서는 앞 요소들이 정렬 된 것이 아니라 상대적 위치로 나열되어야 했다.

```
right answer.
[4,0,1,0,3] → [4,1,3,0,0]

wrong answer.
[4,0,1,0,3] → [1,3,4,0,0]
```

  + 처음에는 상대적 위치를 고려했지만 코드 작성 하다보니 상대적 위치 조건을 잊어버림...
  + solution 확인. '0'이 아닌 수를 앞으로 옮긴 후
  + '0'이 채워져야 하는 position 을 기억해 해당 position 부터 끝 까지 채운다

`problem number 125`

  + ASCII TABLE 활용하면 실행시간을 줄일 수 있었다.

<img src="images/ASCII_TABLE.png" width="500" height="350"/>

`problem number 242`

  + Unicode Character는 한글, 한자, 이모지, 특수기호 등이 포함된다.
  + solution은 compare() 사용 or codePoint 사용이 있다.
  + 여기서는 각 문자의 codePoint 값을 구해 solution을 만들었다.

> codePoint: 유니코드에서 각 문자를 나타내는 고유한 값

`problem number 409`

  + 문자열 관련 알고리듬은 Map 클래스를 자주 사용하게 된다.
  + 짝수,홀수 연산을 위해 두 번의 stream을 만들었지만 하나로 통합할 수 있었다.
  + 입력 값이 비어있을 때, 하나만 있을 때를 고려하자.
  + 영어 대,소문자만 존재할 경우 ASCII 코드를 활용할 수 있다.

`problem number 14`

  + 처음 접근은 ASCII 코드를 저장해 비교했다. 이 접근은 빈도 수 확인에는 효과적이지만 공통 접두사 찾기에는 올바른 솔루션이 아니다.
  + 다음 솔루션은 pivot(기준 문자열) 하나를 정하고 공통 접두사 찾기를 시도했다. 경우의 수가 너무 많아져서 디버깅 하며 수정했지만 끝이 나질 않는다.
  + 결국 Solution을 확인했고 정렬된 문자열을 사용하게 되었을 때 첫번째 요소와 마지막 요소 문자열의 접두사가 가장 긴 공통 접두사가 되는 것을 확인
  + because 문자열을 정렬하면 알파벳 사전 순으로 정렬되기 때문이다.

```
input array of string.
ex1. {"flower", "flow", "flight"}
ex2. {"abc","aaa"}
ex3. {"cddd","cdab","cdaa","cdba"}

after sorting the array.
after1. {"flight", "flow", "flower"}
after2. {"aaa","abc"}
after3. {"cdaa","cdab","cdba","cddd"}
```

```
회고.
공통 접두사를 찾을 때는 정렬된 문자열이 되는 것이 좋다라는 생각이 떠오르질 않음

앞으로 문자열 관련 문제 풀이 시 고려해볼 것
- 정렬 된 배열에서 비교
- ASCII 코드 사용
- pivot을 정하고 비교
- left, right 값을 비교
```

`problem number 13`

  + 첫 접근 solution 시간/공간 복잡도 O(N), 실행 시간 6ms
  + 다른 접근 solution 시간/공간 복잡도 O(N), 실행 시간 5ms
  + 복잡도와 실행 시간의 측면으로 보면 큰 차이는 없음

```
회고.
로마 숫자의 subtractive 규칙을 찾을 경우 역순 처리시 더 쉽게 처리할 수 있다.

역순 처리를 사용해 본 적 있지만 해당 문제가 역순 처리로 어떻게 규칙을 찾을 수 있는지 떠오르지 않음
로마 숫자 패턴을 알면 역순 처리가 생각나지 않았을까 추측

역순 처리 접근 solution으로 작성한 로직 장점
+ 메서드 호출을 제거
+ Map.get() 호출 수 감소
+ 조건절이 간결해짐
```

`problem number 20`

  + 처음 접근은 input 문자열의 괄호의 순서가 무작위로 생각함. 경우의 수가 복잡해짐.
  + 하지만, input 문자열 괄호는 순서가 존재함. 열린 괄호부터 입력되고 닫는 괄호가 입력되려면 항상 그 전 문자에 상응하는 열린 괄호가 존재함.

```
회고.
문제 지문을 정확히 해석해야 함.

문제 지문을 올바르게 해석하고 이해하지 못하면 경우의 수가 복잡해지고 올바른 답을 찾을 수 없다.

Stack은 LIFO(Last-In First-Out) 동작방식을 가지고 Stack 클래스보다는 ArrayDeque 클래스가 성능이 더 좋음
```

`problem number 844`

  + 처음 접근은 문자열을 순회하며 백스페이스를 수행
  + 수행 한 결과를 비교 후 반환
  + 하지만, 문자 포인터를 지정해 비교하는 데 경우의 수가 많아짐
  + solution 확인해보니 Stack 자료구조 사용하면 굉장히 간단함

```
회고.
Easy 문제에서 많은 시간을 낭비하고 있다고 생각해 solution 확인

Stack 자료구조 사용하니 간단히 solution을 만들 수 있었지만 공간 복잡도를 O(N) 사용
Follow up 확인 후 공간 복잡도 O(N) → O(1) 변경 시도
처음에 접근한 solution이 O(1) 공간 복잡도를 할 수 있는 방법
하지만, 다양한 경우의 수를 고려하다보니 코드가 길어지고 문자열 포인터 지정에 대한 아이디어가 필요함

해당 문제에 많은 시간을 투자하기 보다는 O(1) 접근 방법 확인 후 멈춤
```

`problem number 67`

  + 처음 접근한 solution은 RuntimeError 발생
  + 문자열을 int or long 형태로 변환 해 값을 찾았지만 자료형 범위를 벗어나는 input 존재
  + 다른 solution 생각 안나 올바른 solution 확인
  + ASCII 숫자를 사용해 범위 문제 해결
  + Decimal, Binary Form을 비교하며 solution 아이디어 얻어낼 수 있음

```
회고.
long 자료형 범위를 벗어나는 input 존재할지 모름

숫자 자료형 범위를 효과적으로 사용하기 위해서 ASCII 코드를 생각하자
이진 수 Decimal, Binary Form을 고려하는 아이디어를 처음 봄

숫자를 가지고 연산하거나 변환할 때 ASCII를 고려해보자
십진 수 → 이진 수 변환 해주는 메서드 Integer.toBinaryString() 존재
```

`problem number 338`

  + 처음 접근한 solution은 시간 복잡도 O(NlogN)
  + 시간 복잡도 O(NlogN) → O(N) solution 확인
  + 비트 연산 사용과 결과 배열의 누적된 값을 재활용하는 동적 프로그래밍(Dynamic Programming) 기법 사용해 코드를 효과적으로 변경

```
회고.
+ 정수 i의 이진수 표현은 최대 log(i) 길이를 가진다
+ 비트연산의 동작방식과 누적된 배열 값을 어떻게 활용하는지가 중요

비트연산 방식 AND(&)
두 비트가 모두 1인 경우만 1을 반환
101 (5)
&
100 (4)
---
100 (4)

result[5] = result[5 & 4] + 1;
result[5 & 4] = result[4];
result[5] = result[4] + 1;

result[4]의 비트 카운트는 이미 계산되어 있어 추가적인 계산을 피할 수 있다
이렇게 해서 시간 복잡도를 O(NlogN) → O(N) 변경 됨
```
