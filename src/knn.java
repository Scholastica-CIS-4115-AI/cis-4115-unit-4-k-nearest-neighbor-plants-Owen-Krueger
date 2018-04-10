
import java.util.Scanner;
/**
 * The knn class implements the nearest neighbor algorithm to classify if a new test plant is a tree or a bush
 *     Data is read in that is already classified as trees or bushes.
 *     The height and circumference of the new plant is entered
 *     This data is compared to each of the known plants
 *     It is classified based on which known plant is nearest the new plant.
 *
 * @author      Original author: Tom Gibbons.
 * @version     Spring 2017 version
 */
public class knn {

	public static void main(String[] args) {
            noScanner();
            //withScanner();
            threeClosest();
        }
        
        public static void withScanner(){
            Scanner scnr = new Scanner(System.in);    // needed to read input from the keyboard
            System.out.println("Initializing tree and bush data.");
            dataPoint[] data = new dataPoint[6];
            data[0] = new dataPoint(40.0,14.0,"Tree");
            data[1] = new dataPoint(35.0,23.0,"Tree");
            data[2] = new dataPoint(29.0,19.0,"Tree");
            data[3] = new dataPoint(19.0,9.0,"Bush");
            data[4] = new dataPoint(9.0,12.0,"Bush");
            data[5] = new dataPoint(7.0,5.0,"Bush");

            // Read in data on the new plant to classify
            System.out.println("Enter the height of the plant [5-50]");
            float height = scnr.nextFloat(); 
            System.out.println("Enter the circumference of the plant [3-25)");
            float circumference = scnr.nextFloat(); 
            dataPoint testDataPoint = new dataPoint(height,circumference);

            // display the distance from the new plant to each of the known plants
            for (int i=0;i<data.length;i++){
                    System.out.println("distance to point "+i+" which is a "+ data[i].type + " is "+String.format("%6.2f",data[i].distanceTo(testDataPoint)));
            }	

            // determine which of the known plants is closest
            int nearest = 0;
            double min = testDataPoint.distanceTo(data[nearest]);
            for (int i=0;i<data.length;i++){
                    if ( min > testDataPoint.distanceTo(data[i])) {
                            nearest = i;
                            min = testDataPoint.distanceTo(data[nearest]);
                    }
            }

            System.out.println("My best guess is that the new object is a "+ data[nearest].type);
        }
        
        public static void noScanner(){
            System.out.println("Initializing tree and bush data.");
            dataPoint[] data = new dataPoint[6];
            data[0] = new dataPoint(40.0,14.0,"Tree");
            data[1] = new dataPoint(35.0,23.0,"Tree");
            data[2] = new dataPoint(29.0,19.0,"Tree");
            data[3] = new dataPoint(19.0,9.0,"Bush");
            data[4] = new dataPoint(9.0,12.0,"Bush");
            data[5] = new dataPoint(7.0,5.0,"Bush");
            
            dataPoint newPoint = new dataPoint(17,20);
            
            int smallestIndex = 0;
            
            double minDistance = data[0].distanceTo(newPoint);
            for(int i = 0; i < data.length; i++){
                if(data[i].distanceTo(newPoint) < minDistance){
                    smallestIndex = i;
                    minDistance = data[i].distanceTo(newPoint);
                }
                System.out.println("Distance to point " + i + " is " + data[i].distanceTo(newPoint));
            }
            
            System.out.println("My best guess is that the new object is a "+ data[smallestIndex].type);
        }
        	
        
        public static void threeClosest(){
            System.out.println("Initializing tree and bush data.");
            dataPoint[] data = new dataPoint[6];
            data[0] = new dataPoint(40.0,14.0,"Tree");
            data[1] = new dataPoint(35.0,23.0,"Tree");
            data[2] = new dataPoint(29.0,19.0,"Tree");
            data[3] = new dataPoint(19.0,9.0,"Bush");
            data[4] = new dataPoint(9.0,12.0,"Bush");
            data[5] = new dataPoint(7.0,5.0,"Bush");
            
            dataPoint newPoint = new dataPoint(17,20);
            
            double[] distances = new double[5];
            
            int smallestIndex = 0;
            
            //Add distances to array
            for(int i = 0; i < data.length-1; i++){
                distances[i] = data[i].distanceTo(newPoint);
            }
            
            //Bubble sort through distance array
            for(int j = 0; j < distances.length-1; j++){
                for(int k = 0; k < distances.length-1; k++){
                    if(distances[k] > distances[k+1]){
                        double temp = distances[k];
                        distances[k] = distances[k+1];
                        distances[k + 1] = temp;
                    }
                }
            }
            
            //int numTree = 0;
            //for(int i = 0; i < 3; i++){
            //    if(distances[i])
            //}
                        
            //System.out.println("My best guess is that the new object is a "+ data[smallestIndex].type);
        }
	
}
