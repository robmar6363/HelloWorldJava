package edu.hippie.examples;

/**
 * 
 * Literal: Any constant value which can be assigned to the variable is called literal/constant. 
 * Below please find examples of assigning values to variables within the code using literals.
 * 
 * @author Robert Marciniak
 *
 */
public class Literals {

	public static void main(String[] args) {
		
		
		// integer numbers literals
        int decimalIntLiteral = 101;
        int octalIntLiteral = 0100;
        int hexadecimalIntLiteral = 0xFace;
        int binaryIntLiteral = 0b1111;
   
        System.out.println(decimalIntLiteral);
        System.out.println(octalIntLiteral);
        System.out.println(hexadecimalIntLiteral);
        System.out.println(binaryIntLiteral);
        
        // floating-point literals        
        float floatLiteral = (float) 101.230;
        float octalFloatingLiteral = (float) 0123.222;
        
        System.out.println(floatLiteral);
        System.out.println(octalFloatingLiteral);
        
        // character literals
        char characterLiteral = 'a';
        char characterAsNumberLiteral = 041;
        char unicodeCharacterLiteral = '\u0061';
     
        System.out.println(characterLiteral);
        System.out.println(characterAsNumberLiteral);
        System.out.println(unicodeCharacterLiteral);

     
        // string literal
        String text = "This is a String literal\n"
                + " spanned over\n"
                + " three lines of text.\n";

        
        System.out.println(text);

   
	}

}
