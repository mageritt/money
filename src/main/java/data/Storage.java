package data;

import transactions.Record;
import transactions.Transaction;

import java.io.*;

/**
 * Klase skirta darbui su duomenimis
 */

public class Storage extends Transaction {

    private static String FILENAME;


    public Storage(String filename) {

        FILENAME = filename;
    }
    /**
     *
     * @param transaction
     * @return
     * @throws IOException
     */
    public static Transaction load() throws IOException {
        String desc;
        Transaction transaction = new Transaction();
        try {
            FileReader reader = new FileReader(FILENAME);
            BufferedReader buffer = new BufferedReader(reader);
            while (true) {
                desc = buffer.readLine();
                if (desc == null)
                    break;
                double amount = Double.parseDouble(buffer.readLine());
                transaction.add(new Record(desc, amount));
            }
            return transaction;
        } catch (IOException ignored) {
            return transaction;
        }
    }

    public void save(Transaction trans) throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            for (Record record : trans.showAllTransactions()) {

                writer.write(record.getDescription() + "\n");
                writer.write(record.getAmount() + "\n");
            }
        }
    }
}
