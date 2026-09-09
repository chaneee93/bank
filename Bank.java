import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Account acc1 = null, acc2 = null, acc3 = null;   // 3개까지
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("========== OO은행 ==========");
            System.out.println("개설된 계좌: " + Account.getTotalAccounts() + " / 3");
            System.out.println("[1] 계좌 개설  [2] 입금  [3] 출금");
            System.out.println("[4] 이체       [5] 조회  [0] 종료");
            System.out.print("> ");

            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                if (acc3 != null) { System.out.println("계좌는 3개까지입니다."); continue; }
                System.out.print("예금주: ");
                String owner = sc.nextLine();
                System.out.print("초기 입금액 (없으면 엔터): ");
                String money = sc.nextLine();

                Account created = money.isBlank()
                        ? new Account(owner)
                        : new Account(owner, Integer.parseInt(money));

                if (acc1 == null) acc1 = created;
                else if (acc2 == null) acc2 = created;
                else acc3 = created;

                System.out.printf("%d번 계좌를 개설했습니다. %s님, 잔액 %,d원%n",
                        created.getNumber(), created.getOwner(), created.getBalance());

            } else if (menu == 2) {                       // 입금
                System.out.print("계좌번호: ");
                long num = Long.parseLong(sc.nextLine());
                Account acc = find(acc1, acc2, acc3, num);
                if (acc == null) { System.out.println("계좌를 찾을 수 없습니다."); continue; }
                System.out.print("입금액: ");
                int amount = Integer.parseInt(sc.nextLine());
                acc.deposit(amount);
                System.out.printf("입금 완료. %d번 잔액 %,d원%n", acc.getNumber(), acc.getBalance());

            } else if (menu == 3) {                       // 출금
                System.out.print("계좌번호: ");
                long num = Long.parseLong(sc.nextLine());
                Account acc = find(acc1, acc2, acc3, num);
                if (acc == null) { System.out.println("계좌를 찾을 수 없습니다."); continue; }
                System.out.print("출금액: ");
                int amount = Integer.parseInt(sc.nextLine());
                if (acc.withdraw(amount)) {
                    System.out.printf("출금 완료. %d번 잔액 %,d원%n", acc.getNumber(), acc.getBalance());
                }

            } else if (menu == 4) {                       // 이체
                System.out.print("보내는 계좌: ");
                long fromN = Long.parseLong(sc.nextLine());
                System.out.print("받는 계좌: ");
                long toN = Long.parseLong(sc.nextLine());
                System.out.print("금액: ");
                int amount = Integer.parseInt(sc.nextLine());
                Account from = find(acc1, acc2, acc3, fromN);
                Account to = find(acc1, acc2, acc3, toN);
                if (transfer(from, to, amount)) {
                    System.out.printf("이체 완료. %d번 잔액 %,d원%n", from.getNumber(), from.getBalance());
                }

            } else if (menu == 5) {                       // 조회
                int total = 0;
                if (acc1 != null) { print(acc1); total += acc1.getBalance(); }
                if (acc2 != null) { print(acc2); total += acc2.getBalance(); }
                if (acc3 != null) { print(acc3); total += acc3.getBalance(); }
                System.out.printf("── 총 예치금 %,d원 / 은행이 만든 계좌 %d개%n",
                        total, Account.getTotalAccounts());

            } else if (menu == 0) {
                System.out.println("안녕히 가세요.");
                break;
            }
        }
    }

    static void print(Account a) {
        System.out.printf("%d  %s  %,d원%n", a.getNumber(), a.getOwner(), a.getBalance());
    }

    static Account find(Account a1, Account a2, Account a3, long number) {
        if (a1 != null && a1.getNumber() == number) return a1;
        if (a2 != null && a2.getNumber() == number) return a2;
        if (a3 != null && a3.getNumber() == number) return a3;
        return null;
    }

    static boolean transfer(Account from, Account to, int amount) {
        if (from == null || to == null) { System.out.println("계좌를 찾을 수 없습니다."); return false; }
        if (from == to) { System.out.println("같은 계좌로는 이체할 수 없습니다."); return false; }
        if (!from.withdraw(amount)) return false;   // 출금 성공해야 입금
        to.deposit(amount);
        return true;
    }
}
