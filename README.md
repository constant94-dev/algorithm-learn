## 알고리즘 문제풀이

<h3> 24.08 (leetcode) </h3>

+ <strong> Array </strong>
  
  + Two Sum (problem number 1)
  + Best Time to Buy and Sell Stock (problem number 121)
  + Insert Interval (problem number 57)
  
<h3> Issue Tracking </h3>

+ <strong> problem number 121. </strong>
  
  + 첫 접근은 재귀적 접근으로 풀이
  + 시간 복잡도 O(N) 제한사항인걸 알았지만 실제 코드를 작성해보니 O(N^2)
  + 재귀적 접근으로만 생각하니 O(N) 솔루션이 생각 안남
  + discuss 참고 후 새로운 접근법 적용 O(N)
  + 아직 문제를 읽을 때 재귀가 필요한지 아닌지 구분 어려움
  + solution. 재귀를 먼저 떠올리기 보다 입력을 순회하며 처리하는 방안을 먼저 고려하자.

+ <strong> problem number 57. </strong>
  
  + 2차원 리스트 → 2차원 배열로 변환
  + 새로운 배열의 end값이 비교중인 기존 배열 start값 보다 작다면 다음 요소들을 붙여서 반환
  + 기존 배열이 비어있을 경우 새로운 배열만 반환

