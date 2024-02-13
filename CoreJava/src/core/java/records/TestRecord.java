package core.java.records;

/**
 *  Records cannot extend any class
 *  Records con be implements  any interface
 *  No instance fields allowed
 *  Final or static attributes allowed
 *  toString, equals, hashcode, constructor and access methods are generated
 */
public record TestRecord(String name, String address) implements TestInterface {
//    public String notAllowedAttribute;
    final static String finalStaticAttributesAllowed = "OK";
    static int count = 9;

    /* Compact constructors are allowed validations
        It should be public access modifier only
    * */
    public TestRecord {
        System.out.println(" compact constructor is called ");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //all fields are declared as final access modifier. So we can not be allowed  to modify or assign
//        this.name = name;
//        this.address = address;
    }
}

interface TestInterface {
    public String getName();
}
