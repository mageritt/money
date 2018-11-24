package transactions;

import java.util.ArrayList;

public class Transaction extends Record  {

    /**
     * aprasomas darbas su irasais
     */
    private  ArrayList<Record>list;

    public  Transaction(){
        list = new ArrayList<>();
    }

    public Transaction(String description, double amount) {
        super(description, amount);
    }

    public void registerIncome(Record record) {
        list.add(record);
    }

    public void registerExpences (Record record){
        list.add(record);
    }

    public ArrayList<Record> showAllTransactions (){
 return list;
    }

    public void add(Record record){
        list.add(record);
    }

    public double getbalance (){
        double bal = 0.00;
        if (list.size()==0)
            return 0;
        for (Record record: list) {
            bal += record.getAmount();
        }
        return bal;
    }
}
