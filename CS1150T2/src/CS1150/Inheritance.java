package CS1150;

public class Inheritance {

    public static void main(String[] args) {
    	//Creating the bank
        bank myBank = new bank();
        
        //Customers
        account act1 = new account("Student Smith", "1111-1111-1111-1111", 200.0);
        account act2 = new account("Student Johnson", "2222-2222-2222-2222", 350.0);
        account act3 = new premiumAcct("Student Brown", "3333-3333-3333-3333", 1000.0);
        
        //Adding accounts to the bank
        myBank.addAccount(act1);
        myBank.addAccount(act2);
        myBank.addAccount(act3);

        //Diplays the information
        myBank.display();
    }
}

// Bank class
class bank {
	//Array
    private account[] acctNums = new account[10];
    int index = 0;

    //accounts added to the bank
    public void addAccount(account newAccount) {
        if (index < 10) {
            acctNums[index] = newAccount;
            index++;
        } else {
            System.out.println("Bank is full.");
        }
    }

    //display accounts information
    public void display() {
        for (account acc : acctNums) {
            if (acc != null) {
            	//Acct info
                System.out.println("Name:\t\t" + acc.getName());
                System.out.println("Acct #:\t\t" + acc.getAccount());
                System.out.println("Amt:\t\t$" + acc.getAmount());
                acc.display();
                System.out.println(); // Spacer
            }
        }
    }
}

// Basic Account class
class account {
    private String name;
    private String account;
    private double amount;

    //null setup
    public account() {
        this.name = null;
        this.account = null;
        this.amount = 0.0;
    }

    //sets account details
    public account(String name, String account, double amount) {
        this.name = name;
        this.account = account;
        this.amount = amount;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    //setters
    public void setName(String newName) {
        name = newName;
    }

    public void setAccount(String newAccount) {
        account = newAccount;
    }

    public void setAmount(double newAmount) {
        amount = newAmount;
    }

    //display for type of account(If not premium)
    public void display() {
        System.out.println("This is not a premium account");
    }
}

// Premium Account subclass
class premiumAcct extends account {

	//Sets premium Account details
    public premiumAcct(String name, String account, double amount) {
        super(name, account, amount);
    }

    @Override
    //Displays for type of account(If is premium)
    public void display() {
        System.out.println("This is a premium account");
    }
}
