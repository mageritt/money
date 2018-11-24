package transactions;

public class Record {

    /**
     * klase naudojama nedideliems veiksmams su irasais
     */

    private String description;
   private double amount;

    /**
     * metodas sukuria iraso konstruktoriu
     * @param description aprasymas
     * @param amount sumos aprasymas
     */
    public Record(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
     Record() {
        description = description;
        amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Saltinis: " + description  + ", suma: " + amount + "\n";
    }


}
