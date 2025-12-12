<<<<<<< HEAD
// BankAccount.java
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited.");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(amount + " withdrawn.");
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------------");
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}


// SavingsAccount.java
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    // Override withdraw to prevent overdraft
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println(amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Insufficient balance. Withdrawal denied.");
        }
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest);
    }
}


// Main.java
public class Main {
    public static void main(String[] args) {

        // BankAccount object
        BankAccount acc1 = new BankAccount("A101", "Amit Kumar", 5000);
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.printDetails();

        // SavingsAccount object
        SavingsAccount sav1 = new SavingsAccount("S202", "Rohit Sharma", 8000, 5);
        sav1.deposit(3000);
        sav1.withdraw(12000); // Should block
        sav1.withdraw(2000);  // Allowed
        sav1.applyInterest();
        sav1.printDetails();
    }
}
=======
// BankAccount.java
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited.");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(amount + " withdrawn.");
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------------");
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}


// SavingsAccount.java
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    // Override withdraw to prevent overdraft
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println(amount + " withdrawn from Savings Account.");
        } else {
            System.out.println("Insufficient balance. Withdrawal denied.");
        }
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest);
    }
}


// Main.java
public class Main {
    public static void main(String[] args) {

        // BankAccount object
        BankAccount acc1 = new BankAccount("A101", "Amit Kumar", 5000);
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.printDetails();

        // SavingsAccount object
        SavingsAccount sav1 = new SavingsAccount("S202", "Rohit Sharma", 8000, 5);
        sav1.deposit(3000);
        sav1.withdraw(12000); // Should block
        sav1.withdraw(2000);  // Allowed
        sav1.applyInterest();
        sav1.printDetails();
    }
}
>>>>>>> d39d009846cdcd3b3fc4f78f8f0e2a42e4e12c4c
