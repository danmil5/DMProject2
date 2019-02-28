// Daniel Miller

// Pikachu - Catch Rate 190 - Encounter Rate 5%
// Oddish - Catch Rate 255 - Encounter Rate 40%
// Gloom - Catch Rate 120 - Encounter Rate 5%
// Doduo - Catch Rate 190 - Encounter Rate 10%
// Natu - Catch Rate 190 - Encounter Rate 10%
// Girafarig - Catch Rate 60 - Encounter Rate 20%
// Wobbuffet - Catch Rate 45 - Encounter Rate 10%

// The header determines the name of the method "Enc", and determines which...
// type of variable will be returned, which in this case is a string.

// The only parameter used is the integer "enco", which is a randomly generated
// number that determines which pokemon will be encountered.
public class Encounter {
	public static String Enc(int enco) {
		String pmon = "";
		// All statements below fulfill conditional operator requirements
		
		// Due to operator precedence, the relational operators >= and <= are..
		// evaluated before the conditional operator &&.
		
		if (enco>=0 && enco<=4) {
    		pmon = "Pikachu";
    	}
    	else if (enco>=5 && enco<=44) {
    		pmon = "Oddish";
    	}
    	else if (enco>=45 && enco<=49) {
    		pmon = "Gloom";
    	}
    	else if (enco>=50 && enco<=59) {
    		pmon = "Doduo";
    	}
    	else if (enco>=60 && enco<=69) {
    		pmon = "Natu";
    	}
    	else if (enco>=70 && enco<=89) {
    		pmon = "Girafarig";
    	}
    	else if (enco>=90 && enco<=99) {
    		pmon = "Wobbuffet";
    	}
    	else {}
		
		return pmon;
	}
}
