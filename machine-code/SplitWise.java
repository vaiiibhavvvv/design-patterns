import java.util.*;


class User{

    private String userId;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private Map<String,Double> balanceSheet;

    public User(String userId, String name,String email, String mobileNumber){

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.balanceSheet = new HashMap<>();
    }

    public String getUserId(){
        return userId;
    }

    public Map<String, Double> getBalanceSheet(){
        return balanceSheet;
    }

    public void updateBalance(String otherUserId, double amount){

    balanceSheet.put(otherUserId, balanceSheet.getOrDefault(otherUserId, 0.0) + amount);

    }

    public void showBalance(){
        boolean noBalance = true;
        for(Map.Entry<String,Double> entry: balanceSheet.entrySet()){
            if (entry.getValue() != 0) {
                if (entry.getValue() > 0) {
                    System.out.println(entry.getKey() + " owes " + userId + ": " + String.format("%.2f", entry.getValue()));
                } else {
                    System.out.println(userId + " owes " + entry.getKey() + ": " + String.format("%.2f", Math.abs(entry.getValue())));
                }
                noBalance = false;
            }
        } 

        if(noBalance){
            System.out.println("No balance");
        }

    }
    

}

class Expense{

    private String payer;
    private double amount;
    private List<String> userInvolved;
    private String expenseType;
    private List<Double> splitDetails;

        public Expense(String payer, double amount, List<String> userInvolved, String expenseType, List<Double> splitDetails){

            this.payer = payer;
            this.amount = amount;
            this.userInvolved = userInvolved;
            this.expenseType = expenseType;
            this.splitDetails = splitDetails;

        }

        


}

class ExpenseManager{

    private Map<String,User> users;

    public ExpenseManager(){
        users = new HashMap<>();
    }

}


public class SplitWise {
    

}
