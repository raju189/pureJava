package core.java.switchexpression;

import static java.lang.StringTemplate.STR;

public class Main {

    public static void main(String[] args) {

        var day = "SAT";

        var result = "";

        //old approach
        switch (day) {
            case "SUN" :
                result = "HD";
                break; // mandatory
            case "SAT" :
                result = "WE";
                break; // mandatory
            case "MOD", "TUE", "WED", "THU", "FRI" :
                result = "WD";
                break; // mandatory
            default:
                result = "NOT VALID WEEK CODE!";
        }

        //it's preview feature for 21 version as String templates
        System.out.println(STR."Result of week is \{result}!");


        // with arrow operator
        switch (day) {
            case "SUN" -> result = "HD";
//                break; // no need
            case "SAT" ->  result = "WE";
//                break; // no need
            case "MOD", "TUE", "WED", "THU", "FRI" ->  result = "WD";
//                break; // no need
            default -> result = "NOT VALID WEEK CODE!";
        }

        System.out.println(STR." (-> switch) Result of week is \{result}!");

        // with switch expression without Yield operator
       result = switch (day) {
            case "SUN" ->  "HD";
            case "SAT" ->   "WE";
            case "MOD", "TUE", "WED", "THU", "FRI" ->  "WD";
            default -> "NOT VALID WEEK CODE!";
        }; // expression should be ends with semicolon

        System.out.println(STR." (-> switch expression) Result of week is \{result}!");

        // with switch expression without Yield operator
        result = switch (day) {
            case "SUN" : yield  "HD";
            case "SAT" : yield   "WE";
            case "MOD", "TUE", "WED", "THU", "FRI" : yield   "WD";
            default : yield  "NOT VALID WEEK CODE!";
        }; // expression should be ends with semicolon

        System.out.println(STR." (-> switch expression with yield) Result of week is \{result}!");
    }
}
