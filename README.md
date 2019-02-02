# DMProject2  
Add your name as a comment at top of every file:  
  Done  

Add a description of the program as a comment at top:  
  Done  

Add a list and description of Java built-in data types within the user interface or in comments:  
  Done  

Add a greeting / introduction to the user:  
  System.out.println("Welcome to the Hoenn Safari Zone!");  

Use a boolean variable with an appropriate name  (singular noun, lowerCamelCase):  
  boolean yes = start.equalsIgnoreCase("y");  
  if (yes = true) {  

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
