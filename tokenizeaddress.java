import java.util.*;
import java.util.stream.IntStream;

public class tokenizeaddress {
//--------------------------------------------------------------------------
    public static boolean isNoRumah(String strValue)
    {
        
        //check if value start with "No"
        if(strValue.startsWith("no")) { return true; }

        //check if value is number
        String regex = "^[0-9]{2}?$";
        if(strValue.matches(regex)){ return true; }
        return false;
    }

//--------------------------------------------------------------------------
    public static boolean isBandar(String strValue, String assign)
    {
        String[] city = {"Kuala Terengganu","kuala lumpur","kajang","bangi", "damansara","petaling jaya","puchong","subang jaya","cyberjaya","putrajaya","mantin","kuching","seremban"};
        for (int i = 0; i < city.length; i++) {

            boolean match = false;
            if(assign.equalsIgnoreCase("abc") || assign.equalsIgnoreCase("ghi")){
              match = strValue.contains(city[i].toLowerCase());
            }else if(assign.equalsIgnoreCase("def")){
              match = city[i].toLowerCase().contains(strValue);
            }
            //check if value is match the value of array
            if (match){ return true; }
        }
        
        return false;
    }
//--------------------------------------------------------------------------
    public static boolean isDaerah(String strValue)
    {
        
        String[] state = {"Selangor","Terengganu","Pahang", "JOhor","Kelantan","Melaka","Pulau Pinang","Kedah","Johor","Perlis","Sabah","Sarawak"};
        for (int i = 0; i < state.length; i++) {
            boolean state_match = strValue.contains(state[i].toLowerCase());
            //check if value is match the value of array
            if (state_match){ return true; }
        }
        
        return false;
    }

//--------------------------------------------------------------------------    
    public static boolean isStreet(String strValue)
    {
        String [] street = {"jalan", "jln", "lorong", "persiaran"};
        for(String i : street) {
            if (strValue.startsWith(i)){
                return true;
            }
        }
        return false;
    }
    
//--------------------------------------------------------------------------
    public static boolean isPoscode(String strValue) {
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        if(strValue.matches(regex)){
            
            return true;
        }
    
        return false;
    }
    
//--------------------------------------------------------------------------
   public static void main(String[]args){
       
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter your address : "); 
      String address = input.nextLine();
      //List<String> toCheckValue = new ArrayList<String>(); //

      //To assign value & differentiate type of split
      String assign = ""; 
      String[] toCheckValue = address.split(", "); 
      if(address.contains(", ")) {
       //toCheckValue = Arrays.asList(address.split(", "));
       
       assign="abc";
      }
      /*else if(address.contains(" ")) {
       toCheckValue = Arrays.asList(address.split(" ")); 
       assign="def";
      }
      else if(address.contains(",")) {
       toCheckValue = Arrays.asList(address.split(",")); 
       assign="ghi";
      }*/
        

       ArrayList<String> apts = new ArrayList<String>();
       ArrayList<String> streets = new ArrayList<String>();
       ArrayList<String> citys = new ArrayList<String>();
       ArrayList<String> states = new ArrayList<String>();
       ArrayList<String> sections = new ArrayList<String>();
       ArrayList<String> poscode = new ArrayList<String>();
       
       for(String i : toCheckValue) {
        System.out.println(toCheckValue);
           if(isBandar(i.toLowerCase().trim(), assign)) {
               citys.add(i);
           }else if(isDaerah(i.toLowerCase().trim())){
               states.add(i);
           }else if(isNoRumah(i.toLowerCase().trim())){
               apts.add(i);
           }else if(isPoscode(i.toLowerCase().trim())){
               poscode.add(i);
           }else if(isStreet(i.toLowerCase().trim())) {
              streets.add(i);
           }else{
              sections.add(i);
           }
       }

       //Display the element
       System.out.println("{");
       
       if(!apts.isEmpty()) {
           String newApt = "";
           for (String s : apts) newApt += s + " ";
           System.out.println("'apt': '" + newApt.trim() + "',");
       }

       if(!sections.isEmpty()){
          String newSection = "";
          for (String s : sections) newSection += s + " ";
          System.out.println("'section': '" + newSection.trim() + "',");
       }
       
       if(!poscode.isEmpty()){
           String newPoscode = "";
           for (String s : poscode) newPoscode += s + " ";
           System.out.println("'poscode': '" + newPoscode + "',");
       }
       
       if(!citys.isEmpty()) {
           String newCity = "";
           for (String s : citys) newCity += s + " ";
           System.out.println("'city': '" + newCity.trim() + "',");
       }
       
       if(!states.isEmpty()) {
           String newState = "";
           for (String s : states) newState += s + " ";
           System.out.println("'state': '" + newState.trim() + "'");
       }

       if(!streets.isEmpty()) {
           String newStreet = "";
           for (String s : streets) newStreet += s + " ";
           System.out.println("'street': '" + newStreet.trim() + "'");
       }
       System.out.println("}");
        
   }
}