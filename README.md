# 5주차 ~ 14주차
전반적인 프로그램 구조 변경.  
메인이 되는 프레임에 컴포넌트를 클래스단위로 생성하여 붙임.  
  
기본적인 동작은 메뉴 선택 및 수량 선택, 결제하기, 주문취소 버튼이 있음.  
메뉴와 가격은 DB로 불러오며 관리자 아이디로 로그인시, 메뉴 추가, 삭제, 수정 기능을 사용할 수 있도록 할 것  

전체적인 UI는 5~7주차에 설계하였고,  
8주차 부터는 버튼과 라벨들간의 상호작용들에 대해서 고심하고 설계하고 코딩하였습니다.  
메뉴들마다 액션리스너를 구현해 주문내역에 수량추가, 총 결제 금액 추가를 구현하였고  
주문내역에 또한 +, - 버튼을 구현해 손쉽게 수량을 추가, 감소 시킬 수 있도록 하였습니다.  



***
# 4주차 활동 내역
기본 예시로 만들어 놓은 돈까스, 치즈돈까스, 스테이크, 파스타 버튼에 이미지를 씌우고 메뉴 이름을 등록  

***


# 3주차 활동 내역
Myframe.java,  
배치 관리자를 사용하지 않은 채 직접 버튼과 라벨의 크기를 결정,  
키오스크의 가장 기본이 되는 화면을 구현하였음.


***
# JAVA-Project-201810972_유승민
3학년 1학기 자바프로그래밍II 프로젝트

# 키오스크 프로그램
다른 사람들은 대부분 구현해본 경험이 있을 것으로 생각되는데,  
아직 저는 키오스크 프로그램을 구현해본 적이 없어 구현해보려 합니다.  
데이터베이스 연동까지 해보려고 합니다.

## 기능
+ __관리자__
  + 제품관리
    + 등록, 수정, 삭제, 확인
  + 매출관리
    + 일간 매출, 주간 매출, 월간 매출
+ __사용자__
  + 메뉴판
    + 메뉴 확인
    + 구매 수량
