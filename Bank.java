public class Bank {
    public static void main(String[] args) {
        Account a = new Account("홍길동", 50000);
        a.deposit(10000);
        a.withdraw(100000);   // 잔액 초과 → 거부
        a.withdraw(20000);    // 정상
        System.out.println(a.getBalance());
    }
}
