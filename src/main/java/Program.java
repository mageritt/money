import data.Storage;
import transactions.Record;
import transactions.Transaction;

import java.io.IOException;
import java.util.ArrayList;

 class Program {
    /**
     * programa
     */

    private Record record; //= new Record();
    private Dialog dialog = new Dialog();
    private Transaction transaction;
    private Storage storage = new Storage("money.txt");

     /**
      * isvedamas meniu
       * @throws IOException aprasoma klaida, taip isvengiant programos uzsidarymo
      */
    void start() throws IOException {

        Dialog dialog = new Dialog();
        dialog.show("Sveiki prisijunge prie pajamu/islaidu registravimo sistemos!");
        transaction = Storage.load();

        while (true) {
            showMenu();
            String item = dialog.inputWithMessage("Pasirinkite meniu punkta: ");
            switch (item) {
                case "1":
                    registerIncome();
                    break;
                case "2":
                    registerExpences();
                    break;
                case "3":
                    showAllTransactions();
                    break;
                case "4":
                    showBalance();
                    break;
                case "0":
                    if (exit())
                        return;
                    break;
                default:
                    dialog.show("iveskite skaiciu nuo 0 iki 4");
            }
        }
    }

    private void showMenu() {
        dialog.show("==++== BALANSINĖ SISTEMA ==++==");
        dialog.show("1. Užregistruoti pajamas.");
        dialog.show("2. Užregistruoti išlaidas.");
        dialog.show("3. Parodyti visas transakcijas.");
        dialog.show("4. Bendro balanso skaičiavimas");
        dialog.show("0. Išsaugoti ir užbaigti darbą.");
    }

    private void registerIncome () throws IllegalArgumentException  {
        String desc = dialog.inputWithMessage("Iveskite pajamu saltini: ");
       try {
        String temprorary = dialog.inputWithMessage("suma: ");
        double sum = Double.parseDouble(temprorary);
        Record record = new Record(desc, sum);
        transaction.registerIncome(record);
       }catch (Exception e) {
           System.out.println ( "Iveskite teisingus duomenis!" );
           registerIncome();
       }
    }

    private void registerExpences() throws  IOException{

        String desc = dialog.inputWithMessage("Iveskite islaidu saltini: ");
        String temprorary = dialog.inputWithMessage("suma: ");
        try {
            double sum = Double.parseDouble(temprorary);
            if (sum > 0)
                sum = -sum;
            Record record = new Record(desc, sum);
            transaction.registerIncome(record);
        }catch (Exception e) {
            System.out.println ( "Iveskite teisingus duomenis!" );
            registerExpences();
        }
    }

    private void showAllTransactions() {
        dialog.show("Transakcijos: " + transaction.showAllTransactions());
    }

    private void showBalance() {
      dialog.show("Likutis: "+ transaction.getbalance());
    }

     private boolean exit() {
        try {
            storage.save(transaction);
        dialog.show("Issaugota");
         return true;}
         catch (IOException e ){
        dialog.show("Issaugoti nepavyko");
        return false;
         }
    }
}