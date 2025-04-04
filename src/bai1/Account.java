package bai1;

public class Account {
    private String id;
    private String name;
    private int balance;
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }


    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }


    public int debit(int amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return this.balance;
        } else {
            System.out.println("Amount exceeded balance");
            return this.balance;
        }
    }

    public int transferTo(Account another, int amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            another.credit(amount);
            return this.balance;
        } else {
            System.out.println("Amount exceeded balance");
            return this.balance;
        }
    }


    public String toString() {
        return "Account[id=" + this.id + ", name=" + this.name + ", balance=" + this.balance + "]";
    }
    public static void main(String[] args) {

        Account a1 = new Account("A101", "Tran Van A", 88);
        System.out.println(a1);
        Account a2 = new Account("A102", "Nguyen thi B");
        System.out.println(a2);


        System.out.println("ID: " + a1.getId());
        System.out.println("Name: " + a1.getName());
        System.out.println("Balance: " + a1.getBalance());


        a1.credit(100);
        System.out.println(a1);
        a1.debit(50);
        System.out.println(a1);
        a1.debit(500);
        System.out.println(a1);
        a1.transferTo(a2, 100);
        System.out.println(a1);
        System.out.println(a2);
    }
}