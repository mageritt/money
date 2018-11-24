package transactions;

import static org.junit.Assert.*;

public class RecordTest {
    /**
     *iraso klases testavimas
     */

    @org.junit.Test
    public void getDescription() {
Record record = new Record("Parduotuve", 10);
assertEquals("Parduotuve", record.getDescription());
    }

    @org.junit.Test
    public void getAmount() {
        Record record = new Record("Parduotuve", 10.0);
        assertEquals("10.00", String.format("%.2f",record.getAmount()));
    }

    @org.junit.Test
    public void toString2() {
        Record record = new Record("Parduotuve", 10);
        assertEquals("Saltinis: Parduotuve, suma: 10.0", record.toString());
    }
}


