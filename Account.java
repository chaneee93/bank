public class Account {
    String owner;
    int balance;

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public Account(String owner) {
        this(owner, 0);          // 위 생성자를 부른다 (잔액 0)
    }
}
