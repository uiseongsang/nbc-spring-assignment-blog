# spring-lv2

# Questions

------

Q1) 처음 설계한 API와 ERD에 변경사항이 있었나요? 
변경되었다면 어떤 점 때문일까요? 첫 설계의 중요성에 대해 생각해보세요

A1) 첫 설계는 기본 틀을 잡아주는 역할로써 개발하는데 가이드를 해주는 역할이라고 생각합니다.

------

Q2) ERD를 먼저 설계한 후 Entity를 개발했을 때 어떤 점이 도움이 되셨나요?

A2) Class 다이어그램을 설계하고 객체지향적인 코드를 짜듯이 비슷한 도움이라고 생각합니다.

--------

Q3) JWT를 사용하여 인증/인가를 구현 했을 때의 장점은 무엇일까요?

A3) JWT는 따로 JWT 토큰을 저장할 필요없이 토큰자체를 브라우저에 Request하고 그 브라우저는 Response 하면 그냥 검증만 하면 되기 떄문에 쿠키-세션보다 더 효율적일 수 있다.

--------

Q4) 반대로 JWT를 사용한 인증/인가의 한계점은 무엇일까요?

A4)
1. 구현의 복잡도가 생각보다 많다.
   
2. JWT에 담는 내용 즉, JWT 길이가 길어지면 네트워크 비용이 증가한다.
   
3. Secret Key 유출시 JWT 조작이 가능하다 현재 프로젝트에선 application.properties파일에 JWT secret Key를 설정 하는데 보통은 이렇게 허술하게 관리되지 않고 실제로 키를 볼수 없다.
오직관리자만이 알수 있게 따로 관리된다. 왜냐하면 저 키를 알면 값을 다 디코딩 할수 있기 떄문이다.


------
# 새로운 요구사항을 구현
1. 회원 가입 API
    - username, password를 Client에서 전달받기
    - username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성되어야 한다.
    - password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성되어야 한다.
    - DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환하기
    - 참고자료
        1. https://mangkyu.tistory.com/174
        2. [https://ko.wikipedia.org/wiki/정규_표현식](https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D)
        3. https://bamdule.tistory.com/35
            
            
2. 로그인 API
    - username, password를 Client에서 전달받기
    - DB에서 username을 사용하여 저장된 회원의 유무를 확인하고 있다면 password 비교하기
    - 로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급하고, 
    발급한 토큰을 Header에 추가하고 성공했다는 메시지, 상태코드 와 함께 Client에 반환하기

# 요구사항에 맞게 수정
1. 전체 게시글 목록 조회 API
    - 제목, 작성자명(username), 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
2. 게시글 작성 API
    - 토큰을 검사하여, 유효한 토큰일 경우에만 게시글 작성 가능
    - 제목, 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기(username은 로그인 된 사용자)
3. 선택한 게시글 조회 API
    - 선택한 게시글의 제목, 작성자명(username), 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
4. 선택한 게시글 수정 API
    - ~~수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후~~
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능
    - 제목, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
5. 선택한 게시글 삭제 API  
    - ~~삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후~~
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기

# API 명세서
<img width="1583" alt="image" src="https://github.com/uiseongsang/spring-lv2/assets/40707686/a35ca44c-d34c-4bda-9d2e-73ca76335c14">


# ERD
![image](https://github.com/uiseongsang/spring-lv2/assets/40707686/c8450eea-f891-4bc0-b910-4a38079677b6)



 # PostMan Test
 
## Signup
![Pasted Graphic](https://github.com/uiseongsang/spring-lv2/assets/40707686/cf866a7b-2ca8-45a0-aa8d-774ec3c91904)

## Login
![Pasted Graphic 1](https://github.com/uiseongsang/spring-lv2/assets/40707686/36839527-92e1-45a1-a119-5d8498d6cfc5)

## Post
![Pasted Graphic 5](https://github.com/uiseongsang/spring-lv2/assets/40707686/674c12c9-27d2-43b2-bb1c-2d4220d9a966)

 ## Put
 ![image](https://github.com/uiseongsang/spring-lv2/assets/40707686/f0a74c1c-605d-4d31-acbd-c3dd1c7265ab)

 ## Delete
 ![image](https://github.com/uiseongsang/spring-lv2/assets/40707686/ea034dc9-9a6f-4885-bcc7-8300c7ebf1de)



