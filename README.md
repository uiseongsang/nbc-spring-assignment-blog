# spring-lv2

강의 미완료로 프로젝트는 이후에 진행할 예정입니다

12:59: 숙련 2주차 15 : 관심삼품 API 구현 진행중

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
1. 구현의 복잡도가 생각보다 많다
2. JWT에 담는 내용 즉, JWT 길이가 길어지면 네트워크 비용이 증가한다.
3.Secret Key 유출시 JWT 조작이 가능하다 현재 프로젝트에선 application.properties파일에 JWT secret Key를 설정 하는데 보통은 이렇게 허술하게 관리되지 않고 실제로 키를 볼수 없다.
오직관리자만이 알수 있게 따로 관리된다. 왜냐하면 저 키를 알면 값을 다 디코딩 할수 있기 떄문이다.


------
# API 명세서
<img width="1348" alt="image" src="https://github.com/uiseongsang/spring-lv2/assets/40707686/fcdc5b57-e15d-4b08-8775-0c62a2b8e748">

# ERD



 

