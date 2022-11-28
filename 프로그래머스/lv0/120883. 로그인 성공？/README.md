# [level 0] 로그인 성공? - 120883 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120883) 

### 성능 요약

메모리: 78.7 MB, 시간: 2.41 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

<br/>정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p style="user-select: auto;">머쓱이는 프로그래머스에 로그인하려고 합니다. 머쓱이가 입력한 아이디와 패스워드가 담긴 배열 <code style="user-select: auto;">id_pw</code>와 회원들의 정보가 담긴 2차원 배열 <code style="user-select: auto;">db</code>가 주어질 때, 다음과 같이 로그인 성공, 실패에 따른 메시지를 return하도록 solution 함수를 완성해주세요.</p>

<ul style="user-select: auto;">
<li style="user-select: auto;">아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return합니다.</li>
<li style="user-select: auto;">로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를, 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 합니다.</li>
</ul>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">제한사항</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">회원들의 아이디는 문자열입니다.</li>
<li style="user-select: auto;">회원들의 아이디는 알파벳 소문자와 숫자로만 이루어져 있습니다.</li>
<li style="user-select: auto;">회원들의 패스워드는 숫자로 구성된 문자열입니다.</li>
<li style="user-select: auto;">회원들의 비밀번호는 같을 수 있지만 아이디는 같을 수 없습니다.</li>
<li style="user-select: auto;"><code style="user-select: auto;">id_pw</code>의 길이는 2입니다.</li>
<li style="user-select: auto;"><code style="user-select: auto;">id_pw</code>와 db의 원소는 [아이디, 패스워드] 형태입니다.</li>
<li style="user-select: auto;">1 ≤ 아이디의 길이 ≤ 15</li>
<li style="user-select: auto;">1 ≤ 비밀번호의 길이 ≤ 6</li>
<li style="user-select: auto;">1 ≤ <code style="user-select: auto;">db</code>의 길이 ≤ 10</li>
<li style="user-select: auto;"><code style="user-select: auto;">db</code>의 원소의 길이는 2입니다.</li>
</ul>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">입출력 예</h5>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">id_pw</th>
<th style="user-select: auto;">db</th>
<th style="user-select: auto;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">["meosseugi", "1234"]</td>
<td style="user-select: auto;">[["rardss", "123"], ["yyoom", "1234"], ["meosseugi", "1234"]]</td>
<td style="user-select: auto;">"login"</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">["programmer01", "15789"]</td>
<td style="user-select: auto;">[["programmer02", "111111"], ["programmer00", "134"], ["programmer01", "1145"]]</td>
<td style="user-select: auto;">"wrong pw"</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">["rabbit04", "98761"]</td>
<td style="user-select: auto;">[["jaja11", "98761"], ["krong0313", "29440"], ["rabbit00", "111333"]]</td>
<td style="user-select: auto;">"fail"</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<h5 style="user-select: auto;">입출력 예 설명</h5>

<p style="user-select: auto;">입출력 예 #1</p>

<ul style="user-select: auto;">
<li style="user-select: auto;"><code style="user-select: auto;">db</code>에 같은 정보의 계정이 있으므로 "login"을 return합니다.</li>
</ul>

<p style="user-select: auto;">입출력 예 #2</p>

<ul style="user-select: auto;">
<li style="user-select: auto;"><code style="user-select: auto;">db</code>에 아이디는 같지만 패스워드가 다른 계정이 있으므로 "wrong pw"를 return합니다.</li>
</ul>

<p style="user-select: auto;">입출력 예 #3</p>

<ul style="user-select: auto;">
<li style="user-select: auto;"><code style="user-select: auto;">db</code>에 아이디가 맞는 계정이 없으므로 "fail"을 return합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges