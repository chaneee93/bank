public class Bank {
    public static void main(String[] args) {
        Account a = new Account("홍길동", 50000);
        Account b = new Account("김철수", 30000);
        Account c = new Account("이영희");      // 초기 입금 없음

        System.out.println(a.owner + " " + a.balance);
        System.out.println(b.owner + " " + b.balance);
        System.out.println(c.owner + " " + c.balance);
    }
}
