3.21B: SymbolBalanceCheck 
	The program starts by creating two methods: private static boolean symbolDirection(String symbol) and  private static boolean isMatching(String open, String close). These two methods return true if the given symbol is an open symbol and if the two given symbols are matching, respectively. They both have the complexity of O(1).
	The method:  public static boolean isBalanced(String str) uses the two methods above to check if the given string of symbols are balanced. The push and pop function of a stack is only O(1); however, since the program iterates through all the characters in the given string, the overall complexity of the program is O(n).

