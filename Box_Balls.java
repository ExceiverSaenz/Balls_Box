import java.lang.Math;
import java.io.*;
import java.util.*;

class Box_Balls{
	public static void main(String[] args){


		Box[] theBoxes = getBoxArrayFromDataFile("data_base.txt");
        



		printAllBoxes(theBoxes);

		//randomly generate the diameter of the ball to be shipped. 
		int range = 20;  
		int diameter = (int) (Math.random() * range) + 2;

		canContain(theBoxes, diameter);

		smallestBox(theBoxes, diameter);

		int l_index = largestBox(theBoxes, diameter);

        System.out.println(l_index);
		if(l_index >= 0){
			int count = shipHowMany (diameter, theBoxes[l_index]);
			System.out.println(count+" ball(s) can be shipped in the largest box.");
			System.out.println("----------------------------------------------------------------------------\n");
		}
	}

	/**
	 * Complete this method to print the Box
	 * objects in the array parameter theBoxes
	 * @param theBoxes is the array of Box objects
	 */

	public static void printAllBoxes (Box[] theBoxes){
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Printing box dimensions.");

		for(int i = 0; i<theBoxes.length;i++){
            System.out.println("index: " + i + " " +theBoxes[i].toString());
        }

	}

	/**
	 * Change the body of this method to print the box
	 * objects in the array parameter that can hold/store
	 * the ball whose diameter is given in the parameter. 
	 * @param theBoxes is the array of Box objects
	 * @param diameter of the ball
	 */  


	public static void canContain(Box[] theBoxes, int diameter){
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Checking for boxes that can hold the ball.");
		System.out.println("The diameter of the ball: "+diameter);
        int counter = 0;
        
        for(int i = 0; i<theBoxes.length; i++){
            if(theBoxes[i].getWidth()>diameter && theBoxes[i].getHeight()>diameter && theBoxes[i].getLength()>diameter){
                System.out.println("Index: " + i + " " + theBoxes[i].toString());
                counter++;
            }
        }
		
        System.out.println("The number of boxes that can hold the ball is " + counter);

	}

	/**
	 * Change the body of this method to print the information 
	 * of the smallest Box object that can hold the ball of 
	 * the given diameter	
	 * @param theBoxes is the array of Box objects
	 * @param diameter of the ball
	 */    


	public static void smallestBox (Box[] theBoxes, int diameter){
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Finding the smallest box to ship the ball.\nDiameter of the ball to ship: " + diameter);
        int index = 0;
        for(int i = 0;i<theBoxes.length; i++){
            if(theBoxes[i].getWidth()>diameter && theBoxes[i].getHeight()>diameter && theBoxes[i].getLength()>diameter){
                if(theBoxes[i].getVolume()<theBoxes[index].getVolume()){
                    index = i;
                }
            }
        }

        System.out.println("Information of the smallest box \nindex:" + index + "  Width: " + theBoxes[index].getWidth() + "  Height: " + theBoxes[index].getHeight() + "  Length: " + theBoxes[index].getLength());
	}

	/**
	 * Change the body of this method to (a) print the information 
	 * of the largest Box object that can hold the ball of 
	 * the given diameter, and (b) return the index of that object.	
	 * @param theBoxes is the array of Box objects
	 * @param diameter of the ball
	 * @return index of the largest box, -1 if no such box is found. 
	 */    

	public static int largestBox (Box[] theBoxes, int diameter){
        int index = 0;
	   for(int i = 1; i<theBoxes.length; i++){
           if(theBoxes[i].getWidth()>diameter && theBoxes[i].getHeight()>diameter && theBoxes[i].getLength()>diameter){
               if(theBoxes[i].getVolume()>diameter){
                if(theBoxes[i].getVolume()>theBoxes[index].getVolume()){
                    index = i;
                }
            }
           }
       }
        return index;

	}

	/**
	 * Change the body of this method to return â€œthe number of  
	 * ballsâ€ with the given diameter that can be shipped in the largest box
	 * @param diameter of the ball to be shipped
	 * @param largestBox is the box Object with largest volume
	 * @return the number of ball(s) that can be shipped in the
	 * largest Box object 
	 */


	public static int shipHowMany(int diameter, Box largestBox){
         int sop = (((int)largestBox.getLength() / (int)diameter)*((int)largestBox.getWidth() / (int)diameter)*((int)largestBox.getHeight() / (int)diameter));
        return sop;

	}

	/**
	 * Change the body of this method to return an array 
	 * of Box objects, created after reading the file.
	 * @param filename
	 * @return the array of Box objects created from the fileName file 
	 */    

	static Box[] getBoxArrayFromDataFile (String fileName){
        Box[] theBoxes = new Box[10];
		// You are not allowed to change the header.
		// Change the body of this method.    
        int row = 0;

		try{
            Scanner database = new Scanner (new File(fileName));
            
            
            while(database.hasNextLine()){
                for(int length = 0; length<theBoxes.length;length++){
                    theBoxes[length] = new Box(database.nextDouble(),database.nextDouble(), database.nextDouble());
                }
            }
        
        }catch(FileNotFoundException e){ System.out.println("File not found"); }

		return theBoxes;
	}  
}