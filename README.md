# 미션 - 크리스마스 프로모션

## 🚀 기능 요구 사항

#### 메뉴

```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

#### 12월 이벤트 계획

- [ ] 총주문 금액 10,000원 이상부터 이벤트가 적용

<hr>

- 2023.12.1 ~ 2023.12.25 적용 이벤트
- [ ] 크리스마스 디데이 할인 
    - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
    - 총주문 금액에서 해당 금액만큼 할인  
      (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)

<hr>

- 2023.12.1 ~ 2023.12.31 적용 이벤트
- [ ] 평일 할인(일요일~목요일)
  - 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
- [ ] 주말 할인(금요일, 토요일)
  - 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
- [ ] 특별 할인
  - 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
- [ ] 증정 이벤트
  - 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정

#### 고객에게 안내할 이벤트 주의 사항

- 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- [ ] 방문할 날짜는 1 이상 31 이하의 숫자가 아닌 경우 
  > "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
- [ ] 음료만 주문 시, 주문할 수 없음 예외처리
  > "[ERROR] 음료만 주문 시, 주문할 수 없습니다."
- [ ] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)
  > "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."
- [ ] 고객이 메뉴판에 없는 메뉴를 입력하는 경우
  > "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [ ] 메뉴의 개수는 1 이상의 숫자 이외의 입력값은 
  > "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [ ] 메뉴 형식이 예시와 다른 경우
  > "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [ ] 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1)
  > "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."

#### '12월 이벤트 플래너' 개발 요청 사항

- 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.
- [ ] 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- [ ] 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- [ ] 증정 메뉴
    - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
- [ ] 혜택 내역
    - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
    - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력
- [ ] 총 혜택 금액에 따른 이벤트 배지
    - 5천 원 이상: 별
    - 1만 원 이상: 트리
    - 2만 원 이상: 산타
    - 이벤트 배지가 부여되지 않는 경우, "없음"

#### 적용된 이벤트가 하나도 없는 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26 
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1 
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
타파스 1개
제로콜라 1개

<할인 전 총주문 금액>
8,500원
 
<증정 메뉴>
없음
 
<혜택 내역>
없음
 
<총혜택 금액>
0원
 
<할인 후 예상 결제 금액>
8,500원
 
<12월 이벤트 배지>
없음
```

#### '12월 이벤트 플래너'의 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

### 추가된 요구 사항

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

