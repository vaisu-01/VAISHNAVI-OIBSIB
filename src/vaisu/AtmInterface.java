package vaisu;

import java.util.Scanner;
class BankAccount {

    String name;
    String userId;
    int PIN;
    int AccountNo;
    int IFSCCode;
    float balance;
    int transactions = 0;
    String ShowtransactionHistory ;

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your UserId ");
        this.userId = sc.nextLine();
        System.out.print("\nEnter Your PIN");
        this.PIN = sc.nextInt();
        System.out.print("\nEnter Your Account Number ");
        this.AccountNo = sc.nextInt();
        System.out.println("\nYour Registration is successfully  completed ");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while ( !isLogin ) {
            System.out.print("\nEnter Your UserId - ");
            String UserId= sc.nextLine();
            if ( UserId.equals(userId) ) {
                while ( !isLogin ) {
                    System.out.print("\nEnter Your PIN - ");
                    String PIN = sc.nextLine();
                    if ( PIN.equals(PIN) ) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    }
                    else {
                        System.out.println("\nIncorrect PIN");
                    }
                }
            }
            else {
                System.out.println("\nUserId not found");
            }
        }
        return isLogin;
    }
    public void withdraw() {

        System.out.print("\nEnter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if ( balance >= amount ) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + " Rs Withdraw\n";
                ShowtransactionHistory = ShowtransactionHistory.concat(str);
            }
            else {
                System.out.println("\nyou have not sufficient balance ");
            }
        }
        catch ( Exception e) {
        }
    }
    public void deposit() {

        System.out.print("\nEnter amount to deposit");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if ( amount <= 100000f ) {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                ShowtransactionHistory = ShowtransactionHistory.concat(str);
            }
            else {
                System.out.println("\nSorry...Limit is 100000.00");
            }

        }
        catch ( Exception e) {
        }
    }
    public void Banktransfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter Accountno");
        String accountno=sc.nextLine();
        System.out.println("enter IFSC Code");
        String IFSCCode=sc.nextLine();
        System.out.print("\nEnter Recipient's Name - ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float amount = sc.nextFloat();

        try {
            if ( balance >= amount ) {
                if ( amount <= 100000f ) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    ShowtransactionHistory = ShowtransactionHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry Limit is 100000.00");
                }
            }
            else {
                System.out.println("\nyou have not sufficient Balance");
            }
        }
        catch ( Exception e) {
        }
    }
    public void checkBalance() {
        System.out.println("\n" + balance + " Rs");
    }public void transactionHistory() {
        if ( transactions == 0 ) {
            System.out.println("\nEmpty");
        }
        else {
            System.out.println("\n" + ShowtransactionHistory);
        }
    }
}
public class AtmInterface {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while ( !flag ) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if ( flag && input > limit || input < 1 ) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e ) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }
    public static void main(String[] args) {
        System.out.println("\n**********WELCOME**********\n");
        System.out.println("1.Register \n2.Exiting Account");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntegerInput(2);
        if ( choice == 1 ) {
            BankAccount b = new BankAccount();
            b.register();
            while(true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = takeIntegerInput(2);
                if ( ch == 1 ) {
                    if (b.login()) {
                        System.out.println("\n**********WELCOME BACK " + b.name + " **********\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.TransactionHistory \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = takeIntegerInput(6);
                            switch(c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.Banktransfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transactionHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
}