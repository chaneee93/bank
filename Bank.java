public class Bank {
    public static void main(String[] args) {
        System.out.println("========== BANK ==========");
        Account a = new Account();
        a.owner = "홍길동";
        a.balance = 50000;

        Account b = new Account();
        b.owner = "김철수";
        b.balance = 30000;

        System.out.println(a.owner + " " + a.balance);
        System.out.println(b.owner + " " + b.balance);
    }
}
