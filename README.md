# spring-lv1

# Questions

--------

Q1) 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)

A1) 수정, 삭제 API는 API 명세서에 보면 알수 있듯이 JSON body를 사용해서 request를 해주었다.

--------

Q2) 어떤 상황에 어떤 방식의 request를 써야하나요?

A2) 
1. param:
    - 주소에 포함된 변수를 담는다. 예를 들면 http://localhost8080/api/post/1234라는 주소가 있으면 1234를 담는다.
    - resource를 식별해야하는 상황에서는 Path Variable이 적합.
2. query
    - url에 ? 이후에 변수를 담는다. 예를 들면 http//localhost8080/api/post?post_id=12345
    - &으로 연결하여 여러 데이터를 넘길 수 있다. 예를 들면 http//localhost8080/api/post?post_id=12345&key=value | query string = post_id=12345&key=value, query parameter = post_id, key
    - 정렬이나 필터링을 해야하느 상황에 이 적합하다.
3. body
    - XML, JSON등의 데이터를 담는다. 주소에서 확인 불가
    - 개발자 도구에서 볼수 있어서 민감한 데이터의 경우 암호화!!
    - 매우 많은 인수가 있는 상황에 body를 쓰는게 적합하다.
       
--------

Q3) RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?

A3) 제 API명세서에서 Post, Put, Delete에 posts 복수를 써주면 더 좋은건가요??

--------

Q4) 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

A4) 네! MVC 패턴으로 잘 분리해서 잘 주입 받아서 설계를 하였습니다

--------

# 요구사항

1. 요구사항을 기반으로 Use Case 그려보기

2. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
3. 게시글 작성 API 
    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
4. 선택한 게시글 조회 API 
    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
5. 선택한 게시글 수정 API
    - 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
6. 선택한 게시글 삭제 API
    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기
   
# Use Case Diagram
![use Case Diagram](https://github.com/uiseongsang/blog/assets/40707686/389ff67f-1cf5-47a5-9c8a-4d25bc7c2430)

# API 
![API specification](https://github.com/uiseongsang/blog/assets/40707686/1abd2931-4dad-4e53-b915-db36d72bdd4b)

# Postman Test

## Post Test
Post - /api/post
![](https://velog.velcdn.com/images/uiseongsang/post/39ff530e-fffb-4d0a-8644-0b6e632eddc0/image.png)

## Get Test
Get - /api/posts
![](https://velog.velcdn.com/images/uiseongsang/post/c4a462aa-89ed-42fd-922e-2f74f22bf9a3/image.png)

Get - /api/post/2
![](https://velog.velcdn.com/images/uiseongsang/post/fa335fcd-6529-4ceb-a48d-9ea086508c6a/image.png)

## Put Test
Put = /api/post/4

1. 먼저 Post를 만들어 준다
![](https://velog.velcdn.com/images/uiseongsang/post/9ffec36b-fd6f-4793-ab9d-e41b3b5f139b/image.png)
2. 수정하기
![](https://velog.velcdn.com/images/uiseongsang/post/dfeda253-5152-439a-aa3a-160c15764995/image.png)
3. 수정 확인하기
![](https://velog.velcdn.com/images/uiseongsang/post/3b36cfcd-a272-4ff3-a62f-115ed10e7a81/image.png)

## Delete Test
Delete - /api/post/4

1.삭제하기
![](https://velog.velcdn.com/images/uiseongsang/post/ca03a2ac-bc03-485d-9d78-6e214829a0b9/image.png)
2.삭제확인
![](https://velog.velcdn.com/images/uiseongsang/post/86452faf-6421-429e-bad3-5a86833634c9/image.png)

3.모든 포스트확인
![](https://velog.velcdn.com/images/uiseongsang/post/bbf9bca3-c000-49a3-a671-89e434d141c8/image.png)


----------

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
    - ~~제목,~~ **작성자명(username)**, ~~작성 내용, 작성 날짜를 조회하기~~
    - ~~작성 날짜 기준 내림차순으로 정렬하기~~
2. 게시글 작성 API
    - **토큰을 검사하여, 유효한 토큰일 경우에만 게시글 작성 가능**
    - **제목, 작성 내용을 저장하고**
    - 저장된 게시글을 Client 로 반환하기(**username은 로그인 된 사용자**)
3. 선택한 게시글 조회 API
    - ~~선택한 게시글의 제목~~, **작성자명(username)**, ~~작성 날짜, 작성 내용을 조회하기~~ 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
4. 선택한 게시글 수정 API
    - ~~수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후~~
    - **토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능**
    - **제목, 작성 내용을 수정**하고 수정된 게시글을 Client 로 반환하기
5. 선택한 게시글 삭제 API  
    - ~~삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후~~
    - **토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능**
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기

# API 명세서
<img width="1584" alt="image" src="https://github.com/uiseongsang/nbc-spring-assignment-blog/assets/40707686/3e57b120-115a-4d18-b64b-f2738706dd8e">


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

-> lv2 코드 보고 싶거나 복습하고 싶으면 인가된 사용자가 작성한 게시글 POST/PUT/DELETE Commit에서 새로운 브랜치 만들어서 보면 된다!!

-------------------------

# spring-lv3

# 추가된 요구사항을 구현

1. 회원 가입 API
    - ~~username, password를 Client에서 전달받기~~
    - ~~username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성되어야 한다.~~
    - ~~password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)',~~ 특수문자로 구성되어야 한다. (특수문자 추가!!!!)
    - ~~DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환하기~~
    - 회원 권한 부여하기 (ADMIN, USER) - ADMIN 회원은 모든 게시글, 댓글 수정 / 삭제 가능
    - 참고자료
        1. https://mangkyu.tistory.com/174
        2. [https://ko.wikipedia.org/wiki/정규_표현식](https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D)
        3. https://bamdule.tistory.com/35
        
2. 로그인 API
    - ~~username, password를 Client에서 전달받기~~
    - ~~DB에서 username을 사용하여 저장된 회원의 유무를 확인하고 있다면 password 비교하기~~
    - ~~로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급하고, 
    발급한 토큰을 Header에 추가하고 성공했다는 메시지, 상태코드 와 함께 Client에 반환하기~~
3. 댓글 작성 API
    - 토큰을 검사하여, 유효한 토큰일 경우에만 댓글 작성 가능
    - 선택한 게시글의 DB 저장 유무를 확인하기
    - 선택한 게시글이 있다면 댓글을 등록하고 등록된 댓글 반환하기
4. 댓글 수정 API
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 수정 가능
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 수정하고 수정된 댓글 반환하기
5. 댓글 삭제 API
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 삭제 가능
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기
6. 예외 처리
    - 토큰이 필요한 API 요청에서 토큰을 전달하지 않았거나 정상 토큰이 아닐 때는 "토큰이 유효하지 않습니다." 라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 토큰이 있고, 유효한 토큰이지만 해당 사용자가 작성한 게시글/댓글이 아닌 경우에는 “작성자만 삭제/수정할 수 있습니다.”라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - DB에 이미 존재하는 username으로 회원가입을 요청한 경우 "중복된 username 입니다." 라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 로그인 시, 전달된 username과 password 중 맞지 않는 정보가 있다면 "회원을 찾을 수 없습니다."라는 에러메시지와 statusCode: 400을 Client에 반환하기
  
# 요구사항에 맞게 수정
1. 전체 게시글 목록 조회 API
    - ~~제목, 작성자명(username), 작성 내용, 작성 날짜를 조회하기~~
    - ~~작성 날짜 기준 내림차순으로 정렬하기~~
    - 각각의 게시글에 등록된 모든 댓글을 게시글과 같이 Client에 반환하기
    - 댓글은 작성 날짜 기준 내림차순으로 정렬하기
2. 게시글 작성 API
    - ~~토큰을 검사하여, 유효한 토큰일 경우에만 게시글 작성 가능~~
    - ~~제목, 작성자명(username), 작성 내용을 저장하고~~
    - ~~저장된 게시글을 Client 로 반환하기~~
3. 선택한 게시글 조회 API
    - ~~선택한 게시글의 제목, 작성자명(username), 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)~~
    - 선택한 게시글에 등록된 모든 댓글을 선택한 게시글과 같이 Client에 반환하기
    - 댓글은 작성 날짜 기준 내림차순으로 정렬하기
4. 선택한 게시글 수정 API
    - ~~수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후~~
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능
    - 제목, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
5. 선택한 게시글 삭제 API
    - ~~삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후~~
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기

# API 명세서
<img width="1586" alt="image" src="https://github.com/uiseongsang/nbc-spring-assignment-blog/assets/40707686/c6360266-09b2-4465-b319-e46d46efe3f3">

# ERD
<img width="787" alt="image" src="https://github.com/uiseongsang/nbc-spring-assignment-blog/assets/40707686/c8423bf4-a4a2-4009-9dfe-b157debe73b2">

----------

# spring-lv4

# Questions

----------

Q1) Spring Security를 적용했을 때 어떤 점이 도움이 되셨나요?

A1) config에서 접근 허용부분을 손쉽게 설정 할 수 있고 프레임워크에서 주는 이점들을 잘 활용할 수 있어서 편리했습니다.

----------

Q2) Spring Security를 사용하지 않는다면 어떻게 인증/인가를 효율적으로 처리할 수 있을까요?

A2) 직접 인증 인가 부분 Filter를 만들어야 합니다. 

----------

Q3) AOP에 대해 설명해 주세요!

A3) AOP는 관점 지향 프로그래밍이다. 프로그래밍을 하다보면 공통적인 기능이 많이 발생한다. 
    보통 공통적인 기능을 핵심 기능 부분에 여러번을 넣게 되면 중복적이게 되고 곧 이것은 좋은 코드가 아니다!
    왜냐하면 수정에 용이하지 않다는 단점이 있기 떄문이다! 그러기 떄문에 AOP가 생겨났다.
    예를 들면 API의 호출 시간을 측정하고 싶다고 하면 공통 관심 사항으로 호출 시간 측정 로직을 따로 만들어서
    공통적인 기능으로 사용할 수 있는것이다.

----------

Q4) RefreshToken 적용에 대한 장/단점을 작성해 주세요! 적용해 보지 않으셨다면 JWT를 사용하여 인증/인가를 구현 했을 때의 장/단점에 대해 숙련주차의 답변을 Upgrade 하여 작성해 주세요!

A4)  JWT를 사용하여 인증/인가를 구현 했을떄 장/단점
장점: DB를 따로 살 필요가 없다 왜냐하면 secret key가 외부 DB에 저장되어 있는게 아니라서 서버 자체에서 검증이 가능하다, 요즘 로그인을 Oauth를 많이 사용하는데 JWT를 사용한다!
단점: 구현의 복잡도가 상당하고 Secret key가 유출 시 조작이 가능하므로 위험성 부담이 있고 강제 로그아웃이 불가해서 어떤 서비스냐따라 JWT 토큰을 지향해야한다.


----------

Q5) 즉시로딩 / 지연로딩에 대해 설명해 주세요

A5) 
즉시로딩: 연관관계가 설정된 Entity의 즉시 정보를 가져오기
지연로딩: 연관관계가 설정된 Entity의 필요한 시점의 정보를 가져오기(조회시 반드시 영속성 컨텍스트가 존재해야한다 = @Transactional)

----------

**추가된 요구사항을 구현해 보세요!**

1. 게시글 좋아요 API
    - 사용자는 선택한 게시글에 ‘좋아요’를 할 수 있습니다.
    - 사용자가 이미 ‘좋아요’한 게시글에 다시 ‘좋아요’ 요청을 하면 ‘좋아요’를 했던 기록이 취소됩니다.
    - 요청이 성공하면 Client 로 성공했다는 메시지, 상태코드 반환하기
2. 댓글 좋아요 API
    - 사용자는 선택한 댓글에 ‘좋아요’를 할 수 있습니다.
    - 사용자가 이미 ‘좋아요’한 댓글에 다시 ‘좋아요’ 요청을 하면 ‘좋아요’를 했던 기록이 취소됩니다.
    - 요청이 성공하면 Client 로 성공했다는 메시지, 상태코드 반환하기
3. 예외처리
    - 아래 예외처리를 AOP 를 활용하여 구현하기


**요구사항에 맞게 수정해 보세요!**

1. 회원 가입 API
    - username, password를 Client에서 전달받기
    - username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성되어야 한다.
    - password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자`로 구성되어야 한다.
    - DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환하기
    - 회원 권한 부여하기 (ADMIN, USER) - ADMIN 회원은 모든 게시글, 댓글 수정 / 삭제 가능
    - 참고자료
        1. https://mangkyu.tistory.com/174
        2. [https://ko.wikipedia.org/wiki/정규_표현식](https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D)
        3. https://bamdule.tistory.com/35
        
2. 로그인 API
    - username, password를 Client에서 전달받기
    - DB에서 username을 사용하여 저장된 회원의 유무를 확인하고 있다면 password 비교하기
    - 로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급하고, 
    발급한 토큰을 Header에 추가하고 성공했다는 메시지, 상태코드 와 함께 Client에 반환하기
3. 전체 게시글 목록 조회 API
    - 제목, 작성자명(username), 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
    - 각각의 게시글에 등록된 모든 댓글을 게시글과 같이 Client에 반환하기
    - 댓글은 작성 날짜 기준 내림차순으로 정렬하기
    - 게시글/댓글에 ‘좋아요’ 개수도 함께 반환하기 (구현)
4. 게시글 작성 API
    - ~~토큰을 검사하여, 유효한 토큰일 경우에만 게시글 작성 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기! (구현)
    - 제목, 작성자명(username), 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
5. 선택한 게시글 조회 API
    - 선택한 게시글의 제목, 작성자명(username), 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
    - 선택한 게시글에 등록된 모든 댓글을 선택한 게시글과 같이 Client에 반환하기
    - 댓글은 작성 날짜 기준 내림차순으로 정렬하기
    - 게시글/댓글에 ‘좋아요’ 개수도 함께 반환하기 (구현)
6. 선택한 게시글 수정 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기! (구현)
    - 제목, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
    - 게시글에 ‘좋아요’ 개수도 함께 반환하기 (구현)
7. 선택한 게시글 삭제 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기! (구현)
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기
8. 댓글 작성 API
    - ~~토큰을 검사하여, 유효한 토큰일 경우에만 댓글 작성 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기! (구현)
    - 선택한 게시글의 DB 저장 유무를 확인하기
    - 선택한 게시글이 있다면 댓글을 등록하고 등록된 댓글 반환하기
9. 댓글 수정 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 수정 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기! (구현)
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 수정하고 수정된 댓글 반환하기
    - 댓글에 ‘좋아요’ 개수도 함께 반환하기
10. 댓글 삭제 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 삭제 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기! (구현)
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기
11. 예외 처리 (구현)
    - 토큰이 필요한 API 요청에서 토큰을 전달하지 않았거나 정상 토큰이 아닐 때는 "토큰이 유효하지 않습니다." 라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 토큰이 있고, 유효한 토큰이지만 해당 사용자가 작성한 게시글/댓글이 아닌 경우에는 “작성자만 삭제/수정할 수 있습니다.”라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - DB에 이미 존재하는 username으로 회원가입을 요청한 경우 "중복된 username 입니다." 라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 로그인 시, 전달된 username과 password 중 맞지 않는 정보가 있다면 "회원을 찾을 수 없습니다."라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 회원가입 시 username과 password의 구성이 알맞지 않으면 에러메시지와 statusCode: 400을 Client에 반환하기 (구현)

-------

# API 명세서
<img width="1509" alt="image" src="https://github.com/uiseongsang/nbc-spring-assignment-blog/assets/40707686/990e9140-0a99-45c2-8d7e-824ce9237f88">


-------

# ERD
<img width="1157" alt="image" src="https://github.com/uiseongsang/nbc-spring-assignment-blog/assets/40707686/6f31459d-279c-4b05-9108-8924c9d5c248">
<img width="727" alt="image" src="https://github.com/uiseongsang/nbc-spring-assignment-blog/assets/40707686/269ecc7c-3daf-4d4f-9640-b478ae2bfebd">


