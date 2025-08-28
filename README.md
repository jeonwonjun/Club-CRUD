# CLUB API Application

CLUB API Application은 클럽과 회원정보를 저장하고, RESTful API로 각 동아리에 회원 등록, 회원 정보 수정, 회원 삭제, 동아리 회원 목록 조회하는 프로젝트 입니다.

## 주요기능
- 동아리 만들기, 동아리 정보 수정하기, 동아리 삭제하기 , 동아리 목록 조회하기
- 각 동아리에 회원 등록하기, 회원 정보 수정하기, 회원 삭제하기, 동아리의 회원 목록 조회하기

/*### API 스펙

| Method | Endpoint                 | Request Body                                                                                 | Response Body                                                                                                                                                                                                                  | Description                             |
|--------|--------------------------|----------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------|
| POST   | `/tasks`                 | `{ "title": "Task 1", "description": "Do something", "dueDate": "2023-05-01" }`              | `{"id": 1, "title": "Task 1", "description": "Do something", "dueDate": "2023-05-01", "status": "TODO"}`                                                                                                                       | 새로운 할 일 생성                              |
| GET    | `/tasks`                 | `dueDate` (optional)                                                                         | `[{"id": 1, "title": "Task 1", "description": "Do something", "dueDate": "2023-05-01", "status": "TODO"}, {"id": 2, "title": "Task 2", "description": "Do something else", "dueDate": "2023-05-01", "status": "IN_PROGRESS"}]` | 모든 할 일 조회(마감일이 있을 경우, 마감일에 해당하는 할 일 조회) |
| GET    | `/tasks/{id}`            | N/A                                                                                          | `{"id": 1, "title": "Task 1", "description": "Do something", "dueDate": "2023-05-01", "status": "TODO"}`                                                                                                                       | 특정 ID 에 해당하는 할 일 조회                     |
| GET    | `/tasks/status/{status}` | N/A                                                                                          | `[{"id": 1, "title": "Task 1", "description": "Do something", "dueDate": "2023-05-01", "status": "TODO"}, {"id": 3, "title": "Task 3", "description": "Do something else", "dueDate": "2023-05-02", "status": "TODO"}]`        | 특정 상태에 해당하는 할 일 모두 조회                   |
| PUT    | `/tasks/{id}`            | `{ "title": "Updated Task 1", "description": "Do something else", "dueDate": "2023-05-02" }` | `{"id": 1, "title": "Updated Task 1", "description": "Do something else", "dueDate": "2023-05-02", "status": "TODO"}`                                                                                                          | 특정 ID 에 해당하는 할 일 수정                     |
| PATCH  | `/tasks/{id}/status`     | `{ "status": "IN_PROGRESS" }`                                                                | `{"id": 1, "title": "Task 1", "description": "Do something", "dueDate": "2023-05-01", "status": "IN_PROGRESS"}`                                                                                                                | 특정 ID 에 해당하는 할 일의 상태 변경                 |
| DELETE | `/tasks/{id}`            | N/A                                                                                          | `{ "success": true }`                                                                                                                                                                                                          | 특정 ID 에 해당하는 할 일 삭제                     |
*/

### 리소스 표현

- 동아리 (Club):
    - club_id: `Long`
    - club_name: `String`
    - club_description: `String`
    - created_at: `LocalDateTime`

- 회원 (User):
    - user_id: `Long`
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

### 설치 및 실행
1. 레포지토리를 클론하고 프로젝트 디렉토리로 이동합니다 
```sh
$> git clone https://github.com/jeonwonjun/Club-CRUD.git
$> cd Club-CRUD   # 프로젝트 디렉토리로 이동
```
2. gradle 로 프로젝트를 빌드합니다
```sh
$> gradle clean build
```
3. JAR 파일을 실행합니다
```sh
$> java -jar build/libs/todo-server-1.0-SNAPSHOT.jar
```

## 라이센스
이 프로젝트는 [MIT 라이센스](./LICENSE)에 따라 사용할 수 있습니다
