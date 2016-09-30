import java.util.ArrayList;

public class Playground {

	public String firstWordToAdd;
	public String secondWordToAdd;
	
	public static ArrayList<Character> firstCharList = new ArrayList<Character>();
	public static ArrayList<Character> secondCharList = new ArrayList<Character>();

	public static ArrayList<Integer> firstCharListValues = new ArrayList<Integer>();
	public static ArrayList<Integer> secondCharListValues = new ArrayList<Integer>();

	public static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static ArrayList<Character> resultChars = new ArrayList<Character>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//This -- is a secret message! Shhh. Never tell anyone what I did.|SECRETKEYS
		polluteArrays("This -- is", "secretkeys");
		
		System.out.println(firstCharList);
		System.out.println(secondCharList);
		
		System.out.println(firstCharListValues);
		System.out.println(secondCharListValues);

		
		getResult();
		//13, 18, 25, 14, 15, 5, 8):


		System.out.println(result);
		System.out.println(resultChars);


		
	//	System.out.println(Character.forDigit(27, 36));
		
		char c = 'Z';
		int i = (int) c; // i will have the value 65 decimal
		
		int v = 92;
		char m = (char) v;
		
		System.out.println(m);
		
	
	}
	
	public void setWords(String first, String second){
		firstWordToAdd = first;
		secondWordToAdd = second;
	}
	
	public static void polluteArrays(String first, String second){
		for (int i = 0; i < first.length() ; i++){
			firstCharList.add(first.charAt(i));
		}
		int k = 0;
		for (int i = 0; i<firstCharList.size(); i++){
			
			if (i != 0 && (i % second.length()) == 0){
				k = 0;
			}
				secondCharList.add(second.charAt(k));
				k++;
				
		}
		
		fillArrayValues();
	}
	
	public static void fillArrayValues(){
		for (int i = 0; i < firstCharList.size(); i++){
			if (getNumericValueForChar(firstCharList.get(i)) < 0 || getNumericValueForChar(firstCharList.get(i)) > 25){
				firstCharListValues.add((int)firstCharList.get(i));
				secondCharListValues.add(getNumericValueForChar(secondCharList.get(i)));

			}else{
				firstCharListValues.add(getNumericValueForChar(firstCharList.get(i)));
				secondCharListValues.add(getNumericValueForChar(secondCharList.get(i)));
			}
			
		}
	}

	public static char getCharValueForNumber(int number){
	//	char b = Integer.toString(a).charAt(0);
	//	System.out.println("test");
		if (number < 0 || number > 25){
			return (char) number;
		}
		return Character.toUpperCase(Character.forDigit(number + 10, 36));
	}
	
	public static void getResult(){
		for (int i = 0; i < firstCharListValues.size(); i++){
			if ( firstCharListValues.get(i) < 0 || firstCharListValues.get(i) > 25){
				result.add(firstCharListValues.get(i));
			}else{
				result.add((firstCharListValues.get(i) + secondCharListValues.get(i)) % 26);

			}
		}
		
		getResultInChars();
	}
	
	public static void getResultInChars(){
		for (int i = 0; i < result.size(); i++){
			resultChars.add(getCharValueForNumber(result.get(i)));
		}
	}
	public static int getNumericValueForChar(char ch){

		return Character.getNumericValue(Character.toLowerCase(ch)) - 10;
	}

}
