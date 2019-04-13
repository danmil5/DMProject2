# DMProject2  

Daniel Miller

PSI 1 Requirements:  

Add your name as a comment at top of every file:  
  Done  

Add a description of the program as a comment at top:  
  Done  

Add a list and description of Java built-in data types within the user interface or in comments:  
  Done  

Add a greeting / introduction to the user:  
  System.out.println("Welcome to the Hoenn Safari Zone!");  

Use a boolean variable with an appropriate name  (singular noun, lowerCamelCase):  
  battle = true;  
  default: battle = false;  
  if (battle = true) {    

Use an int variable with an appropriate name (singular noun, lowerCamelCase):  
  int encVar = rand.nextInt(100) + 1;  
  if (encVar < encRate) {  

Use an double variable with an appropriate name (singular noun, lowerCamelCase):  
  final double encRate = 53.3;  
  if (encVar < encRate) {  

Use a String object with an appropriate name (singular noun, lowerCamelCase):  
  String start = scan.nextLine();  
  String startChar = start.toLowerCase();  
  if (startChar.charAt(0) == 'y') {  

Define (in English) the term "variable" as it relates to computer programming in a comment or the user interface:  
  A variable is most similar to a box which a value can be put into, or "assigned to," which allows more convenient expression  
  and usage of the value contained within the variable.  

Define (in English) the term "scope" as it relates to computer programming in a comment or the user interface:  
  The term scope refers to the access that a class has to a variable or set of variables, most notably used when describing  
  the ability of classes to access only private variables declared within that specific class.  

Use final with a variable and describe what it means in a comment:  
  final double encRate = 53.3;  
  if (encVar < encRate) {  

Use casting and describe what it means in a comment:  
    double pikaCatchChance = (190*100)/1275;  
    int pikaFactor = (int)pikaCatchChance;  
    double pikaFactor2 = (double)pikaFactor;  
    Casting means to create an x-type variable copy of a y-type variable.  

Format strings using escape sequences:  
  String continue = "\"\\ENTER\\\""  
  System.out.println("Press " + continue + " to continue.");  
  
  
PSI 2 Requirements:  

Create a method with arguments and return values:  
	Created method "Enc" in class "Encounter"  

Identify a method call and argument in comments:  
	pmon = Encounter.Enc(enco);  
	with the argument "enco = rand.nextInt(100);"  

Identify a header and parameter in comments:  
  Done  

Use the Random class:  
  enco = rand.nextInt(100);  

Use the Math class:  
  Math.pow(num2, 2)  

Create if/else constructs:  
	if (battle = true) {   

Create ternary constructs:
	only = (steps<=10 ? " only" : "");

Use a switch statement:  
	switch(pmon) {  
    	  case "Pikachu":  

Compare two String objects by using the compareTo and equals methods and make  
a comment describing how == works with objects:  
	num.compareTo("9") < 0  
	confChar.equals("y")  
	Done  

Use +, -, *, /, %, ++, --, +=:  
	Done  

Use relational operators:  
	if (enco>=0 && enco<=4) {  

Use conditional operators:  
	if (enco>=0 && enco<=4) {  

Describe operator precedence as a comment:  
	Done in the Encounter class  

Create and use while loops:  
	while (n == 0) {  
      System.out.println("You'll have 50 steps, ready to begin? (y/n)");  

Create and use for loops:  
	for (k = 1; k <= 5; k++) {  
    	System.out.println("Please type an integer less than 9!");  

Create and use do/while loops:  
	do {  
    		//body  
	} while (flee > 3*escape);  

Use break in a loop with a comment describing what it does:  
	// Break statement will exit the loop if pokemon has been caught  
              break;  

Use continue in a loop with a comment describing what it does:  
	// If the ball misses, the next loop will be iterated before..  
    // the pokemon has a chance to flee.  
    System.out.println("The Safari Ball missed! Try again!");  
    continue;  


PSI 3 Requirements:  

Make a class in a separate file with private fields, public getters and:  
setters, a constructor with and without parameters  
Done, EX: "Pokemon" class

Overload a method:  
Done, EX:  
  static public void setEnc(int num) {  
    enc = num;  
  }  

  static public void setEnc(double num) {  
    enc = (int)num;  
  }  

Describe inheritance and its benefits:  
Inheritance is the concept by which a subclass can inherit the fields and  
methods from another class. This is very beneficial when multiple subclasses  
inherit from the same superclass, which saves a lot of time and makes the  
code easier to follow.  

Develop code that makes use of polymorphism:  
Done, EX: A "Pikachu" subclass which inherits from the "Pokemon" class can  
be contained in an array designed to hold only "Pokemon"-type objects, and  
overrides the "getSpecies" method to state "Mouse Pokemon" instead of  
"Pikachu" when it is does not have a nickname.  

Use super and this to access objects and constructors  
Done, EX: Pikachu object using Pokemon-class constructor to establish fields:  

Declare, instantiate, initialize and use a one-dimensional array:  
Done  

Manually find the smallest value in an array:  
Done, EX: Least amount of balls used to catch a Pokemon/multiple Pokemon  

Get a sum of the values in an array using an accumulator:  
Done, EX: Total amount of Safari Balls thrown  

Search an array and identify the index where a value was found:  
Done, toward the end of the program a for loop searches the array of all  
Pokemon and identifies the locations in the array at which an Oddish was  
found using an "index plus one" value.  

Create and use the enhanced for loop:  
Done at the end of the program  

Declare, instantiate, initialize and use multi-dimensional arrays:  
Done  

Declare and use an ArrayList of a given type:  
Done, EX: ArrayList<Integer> ThrownBalls= new ArrayList<Integer>(0);  

Search a two-dimensional array and identify the coordinates  
where a value was found:  
Done, EX: search a two dimensional array for each instance of Oddish and  
the corresponding number of safari balls used to catch it.  

Effectively utilize exception handling for user input of an int:  
Done at beginning of program (Line 154 at the time of writing this)  
