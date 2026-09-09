# 미션2 은행 계좌 — 학습 노트

## v0.2 를 만들고 느낀 것
- 계좌를 3개로 제한한 이유: acc1·acc2·acc3 변수로만 담아서. 배열을 아직 안 배움
- 10개로 늘리려면: acc4~acc10 변수 추가 + 개설/조회/find 전부 손봐야 함 (완전 노가다)
- find가 null을 돌려주면 부르는 쪽은: null 검사를 해야 함. 안 하면 NullPointerException
- 잔액 부족을 println으로 알리는 게 아쉬운 이유: 부르는 쪽이 그냥 무시할 수 있음

→ 미션3에서 배열 + 예외로 해결 (도서관 도메인으로)

## 배운 것
클래스/객체, 생성자·오버로딩·this(), 캡슐화(private+getter), static, 참조 복사
Git: 브랜치, 충돌 해결, GitHub push, fetch/pull, Pull Request
