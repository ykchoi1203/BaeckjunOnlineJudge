# [level 0] 문자열 밀기 - 120921 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120921) 

### 성능 요약

메모리: 77.1 MB, 시간: 11.59 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

<br/>정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p style="user-select: auto;">문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다. 이것을 문자열을 민다고 정의한다면 문자열 <code style="user-select: auto;">A</code>와 <code style="user-select: auto;">B</code>가 매개변수로 주어질 때, <code style="user-select: auto;">A</code>를 밀어서 <code style="user-select: auto;">B</code>가 될 수 있다면 몇 번 밀어야 하는지 횟수를 return하고 밀어서 <code style="user-select: auto;">B</code>가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.</p>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">제한사항</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">0 &lt; <code style="user-select: auto;">A</code>의 길이 = <code style="user-select: auto;">B</code>의 길이 &lt; 100</li>
<li style="user-select: auto;"><code style="user-select: auto;">A</code>, <code style="user-select: auto;">B</code>는 알파벳 소문자로 이루어져 있습니다.</li>
</ul>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">입출력 예</h5>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">A</th>
<th style="user-select: auto;">B</th>
<th style="user-select: auto;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">"hello"</td>
<td style="user-select: auto;">"ohell"</td>
<td style="user-select: auto;">1</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">"apple"</td>
<td style="user-select: auto;">"elppa"</td>
<td style="user-select: auto;">-1</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<h5 style="user-select: auto;">입출력 예 설명</h5>

<p style="user-select: auto;">입출력 예 #1</p>

<ul style="user-select: auto;">
<li style="user-select: auto;">"hello"를 오른쪽으로 한 칸 밀면 "ohell"가 됩니다.</li>
</ul>

<p style="user-select: auto;">입출력 예 #2</p>

<ul style="user-select: auto;">
<li style="user-select: auto;">"apple"은 몇 번을 밀어도 "elppa"가 될 수 없습니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges