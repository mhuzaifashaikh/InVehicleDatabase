/**
 * @author Mohammad Huzaifa Shaikh
 */


import java.util.*;
import java.util.Scanner;


public class IVIS{

    /**
     * Using an ArrayList to store the keys of the key-value pairs.
     * Array List instead of arrays as it is much easier to search, insert and delete.
     * The index of each element(each key) will be the values.
     */
    ArrayList<String> keyArray;
    HashMap<String, Integer> mainHash;


    
    private IVIS(){
        keyArray = new ArrayList<>();
        mainHash = new HashMap<>();
    }

    /**
     * This Function adds a key to the keys array and the main hash table if it does not already exist.
     * 
     * @param key
     */
    void insert(String key){
        
        //check if the value already exists in the hash table, if it does alert the user and return.
        if(mainHash.get(key) != null){
            System.out.println("This value already exists");
            return;
        }

        //otherwise add the key to the key array and the main hash table along with the value (which is the index of the corresponding element(latest) in the array)
        keyArray.add(key);
        mainHash.put(key, keyArray.size() - 1);
        System.out.println("---Inserted: " + key + "--- Value given: " + mainHash.get(key) + "---");

    }

    
    /**
     * This Function deletes the given key.
     * 
     * First it checks if the provided key exists already in the hashtable. If it does not, there is nothing to remove.
     * Then, it removes the key if it exists.
     * Then, it removes the key from the key array.
     * It does so by swapping the key to delete with the last key in the array, this makes it easier to remove.
     * @param Key
     */
    void delete(String Key){

        //First we check if the element even exists in the hash map.
        Integer check = mainHash.get(Key); //Get the value of the key
        if(check == null){ //if value does not exist
            System.out.println("Key not found"); // alert the user
            return; 
        }

        else mainHash.remove(Key); //if it does exist then remove the key 


        //now we remove the corresponding index (value) of this key from the key array.
        //we will do this by swapping the key to remove with the last key in the array.
        
         int lastIndex = keyArray.size() - 1; //index (value) of last key

         if(check == lastIndex){
            keyArray.remove(lastIndex);
         }

         else{
         String lastKey = keyArray.get(lastIndex); //get the last key from the array
         Collections.swap(keyArray, check, lastIndex); //swap the current key(one that is being delted) and the last key

         keyArray.remove(lastIndex); //finally we remove the last index(which we changed to the key to ne removed)

         mainHash.put(lastKey, check); //Now, in the hash table we add the latest index of the last element

         }


         System.out.println("---Deleted: " + Key + "---"); //alert the user that the key is deleted
    }


    /**
     * This Functions searches for the corresponding value of the given key.
     * 
     * @param key
     */
    Integer search(String key){
    	
    	Integer value = mainHash.get(key); //retreive value of the key

        if(value == null){
      
            System.out.println("Key not found"); //if the value is null then there is no such key in the hashmap
            return null;
        }
        
        System.out.println("Found key: -" + key + "- with value " + value); // otherwise display the key thats found!
        return value; //not a void function, return the value (for jUnit testing purposes)
     }

     void view(){
        if(mainHash.isEmpty())
            System.out.println("No existing keys. Enter 'I' to insert.");
            
        for (String key : mainHash.keySet()) {
            System.out.println("Key: " + key + "\tValue: " + mainHash.get(key));
        }
     }

     public void menu(){ //helper function to print menu in the main method for each iteration.
        System.out.println("\nEnter 'I' to Insert key.");
        System.out.println("Enter 'D' to Delete key.");
        System.out.println("Enter 'S' to Search key.");
        System.out.println("Enter 'V' to View all keys.");
        System.out.println("or enter \"exit\" to stop the program.\n");
     }


     public static void main(String[] args) {
        IVIS myIVIS = new IVIS(); //initialize IVIS object

        Scanner in = new Scanner(System.in); //open scanner

        myIVIS.menu(); //display menu

        

        while(true){ //enter a while loop that runs unless there is an error in the code 

            String input = in.nextLine(); //read input

            if(input.length() > 1){ //the input cannot be greater than 1 charchter, since we only ask the user to pick I, D or S
                if (input.equals("exit")) //if it is then it should only be exit, which stops the system from running
                    return;

                else System.out.println("Invalid input. "); //otherwise alert the user of an error 

                myIVIS.menu(); //display the menu again

            }


            else if(input.charAt(0) == 'I' || input.charAt(0) == 'i'){ //if the input is the character I
                System.out.println("Enter the key to insert: "); //Ask user to 'I'nsert key
                input = in.nextLine(); //read input
                myIVIS.insert(input); // add it to the hashmap using insert method

                myIVIS.menu(); // display menu again
            }

            else if(input.charAt(0) == 'D' || input.charAt(0) == 'd'){//if the input is the character D
                System.out.println("Enter the key to delete: ");// ask user to 'D'elete key
                input = in.nextLine();// read input
                myIVIS.delete(input);// use delete method to remove key

                myIVIS.menu(); //display menu
            }

            else if(input.charAt(0) == 'S' || input.charAt(0) == 's'){//if the input is the character S
                System.out.println("Enter the key to search: "); //ask user to 'S'earch key
                input = in.nextLine();// read input
                myIVIS.search(input);// search method to search they key

                myIVIS.menu(); // display menu again
            }

            else if(input.charAt(0) == 'V' || input.charAt(0) == 'v'){//if the input is the character S
                
                myIVIS.view();

                myIVIS.menu(); // display menu again
            }

            else{
                System.out.println(input +" is not a valid input, try again"); //error handling, wrong input
                myIVIS.menu();// display menu again
            }


        }


        
        
     }
   
     
}










