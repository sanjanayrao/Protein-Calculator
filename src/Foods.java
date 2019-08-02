import java.util.HashMap;


public class Foods {

  protected static HashMap<String, Integer> myFoods = new HashMap<String, Integer>();

  protected Foods() {
    myFoods.put("tofu", 20);
    myFoods.put("almonds", 8);
    myFoods.put("brown rice", 5);
    myFoods.put("peanut butter granola", 10);
    myFoods.put("protein bar", 20);
    myFoods.put("soy milk", 9);
    myFoods.put("protein shake", 36);
    myFoods.put("peanut butter", 9);
    myFoods.put("egg", 7);
    myFoods.put("brown rice", 5);
    myFoods.put("lentils", 13);
    myFoods.put("split pea soup", 14);
    myFoods.put("potato", 4);
  }

  protected boolean containsKey(String s) {
    if(myFoods.containsKey(s)) return true;
    return false;
  }

  protected int get(String s) {
    return myFoods.get(s);
  }

}
