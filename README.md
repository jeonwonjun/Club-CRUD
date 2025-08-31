# CLUB API Application

CLUB API Application은 클럽과 회원정보를 저장하고, RESTful API로 각 동아리에 회원 등록, 회원 정보 수정, 회원 삭제, 동아리 회원 목록 조회하는 프로젝트 입니다.

## 주요기능
- 동아리 만들기, 동아리 정보 수정하기, 동아리 삭제하기 , 동아리 목록 조회하기
- 각 동아리에 회원 등록하기, 회원 정보 수정하기, 회원 삭제하기, 동아리의 회원 목록 조회하기

### API 스펙

| Method | Endpoint                 | Request Body                                                                                 | Response Body                                                                                                                                                                                                                  | Description                             |
|--------|--------------------------|----------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------|
| POST   | `/api/club`                 | `{ "club_name": "개그동아리", "description": "Do something"}`              | `{"id": 1, "club_name": "개그동아리", "description": "Do something", "dueDate": "2025-08-31"}`                                                                                                                       | 새로운 동아리 생성                              |
| GET    | `/api/club/all`                 |     N/A                                                                  | `[{"id": 1, "club_name": "개그동아리", "description": "Do something", "dueDate": "2025-08-31", "userList": []}, {"id": 2, "club_name": "풋살동아리", "description": "Do something", "dueDate": "2025-08-31", "userList": []}]` | 모든 동아리 조회 |
| GET    | `/api/club/id/{id}`            | N/A                                                                                          | `{"id": 1, "club_name": "개그동아리", "description": "Do something", "dueDate": "2025-08-31", "userList": []}`                                                                                                                       | 특정 ID 에 해당하는 동아리 조회                     |
| PUT    | `/api/club/id/{id}`            | `{ "club_name": "코믹동아리", "description": "Do something else"}` | `{"id": 1, "club_name": "코믹동아리", "description": "Do something else", "dueDate": "2025-08-31", "userList": []}`                                                                                                          | 특정 ID 에 해당하는 동아리 수정                     |
| DELETE | `/api/club/id/{id}`            | N/A                                                                                          | N/A                                                                                                                                                                                                         | 특정 ID 에 해당하는 동아리 삭제                     |
* user도 같은 원리

### 리소스 표현

- 동아리 (Club):
    - id: `Long`
    - club_name: `String`
    - club_description: `String`
    - created_at: `LocalDateTime`

- 회원 (User):
    - id: `Long`
    - club_id: `Long`
    - user_name: `String`
    - user_age: `Integer`
    - registed_at: `LocalDateTime`

## 시작하기

### 필요 도구
- JDK 17 이상
- Gradle 7.3 이상 

### 개발환경
- Spring Boot 3.0.4
- H2 인메모리 데이터베이스
- JPA
- Lombok

### 테스트환경
- Spring Boot Test
- Mockito
- JUnit 5
```

## 라이센스
이 프로젝트는 [MIT 라이센스](./LICENSE)에 따라 사용할 수 있습니다
