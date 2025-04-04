package bai25;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(101, "Hayate", 'f');
        Account account=new Account(141006, customer1, 500.0);
        System.out.println(account);
        System.out.println(customer1);


        account.deposit(200.0);
        System.out.println("After deposit: " + account);


        account.withdraw(100.0);
        System.out.println("After withdrawal: " + account);


        account.withdraw(1000.0);
    }
}
