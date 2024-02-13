package core.java.records;

public class RecordsMain {
    private static TestRecord testRecord;

    public static void main(String[] args) {


        var testRecord = new TestRecord("raju", "402");

        var testRecord1 = new TestRecord("raju", "402");
        var testRecord2 = new TestRecord("raju", "403");

        System.out.println(testRecord); // toStrings is generated

        System.out.println(testRecord.getName());

        System.out.println(testRecord.equals(testRecord1)); // equals is generated

        System.out.println(testRecord.equals(testRecord2));


    }
}
