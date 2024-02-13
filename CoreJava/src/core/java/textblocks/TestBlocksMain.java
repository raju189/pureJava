package core.java.textblocks;

/**
 *  preview version of 13 and 14
 *  since 15
 */
public class TestBlocksMain {
    public static void main(String[] args) {
        var textBlocks = """ 
                Line should be started next line of \""" 
                        Second line onwards follows the space as given
                     Any space  end of line will be ignore/striped     
                   Formatted strings also use of text blocks""";

        System.out.println(textBlocks);
    }

}
