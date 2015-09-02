/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.partition.manager;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Basuru
 */
public class FixedPartitionManager {
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        //Variables the system needs are defined here
        ArrayList<Integer> RegionsArray = new ArrayList<>();
        int noOfRegions;
        int noOfPrograms;
        int MemorySizes;
        
        
             
        System.out.println("Welcome to the Fixed Partition Manager");
        System.out.println("======================================= \n");
        
        //Get the inputs 
        
        Scanner getInput = new Scanner(System.in);
        
        System.out.print("Please Enter the number of memory Reigoions : ");
        
        noOfRegions = getInput.nextInt();
        
        System.out.print("Please Enter the number of programs to be executed : ");
        
        noOfPrograms = getInput.nextInt();
        
        System.out.println("\nAccording to the Regions you have entered, enter the Memory sizes in order ");
        System.out.println("=========================================================================== \n");
        
        
        //Get the sizes of memory regions as inputs
        for(int i = 0; i < noOfRegions; i++)
        {
            if(i==0)
            {
                System.out.print("Enter the "+ (i + 1) +"st Memory size : ");
                RegionsArray.add(getInput.nextInt());
            }
            else if(i==1)
            {
                System.out.print("Enter the "+ (i + 1) +"nd Memory size : ");
                RegionsArray.add(getInput.nextInt());
            }
            else if(i==2)
            {
                System.out.print("Enter the "+ (i + 1) +"rd Memory size : ");
                RegionsArray.add(getInput.nextInt());
            }
            else if(i>=3)
            {
                System.out.println("Enter the "+ (i + 1) +"th Memory size : ");
                RegionsArray.add(getInput.nextInt());
            }
              
        }
        
             
        System.out.println("\nAccording to the No of programs mentioned above Enter the Size and the time taken to execute each program ");
        System.out.println("=============================================================================================================");
        
        
       
        for(int i=1; i <= noOfPrograms; i++)
        {
            if(i==1)
            {
                System.out.print("\n" + i + "st program size : ");
                RegionsArray.add(getInput.nextInt());
                System.out.print(i + "st program Time : ");
                RegionsArray.add(getInput.nextInt());
            }
            else if(i==2)
            {
                System.out.print("\n" + i + "nd program size : ");
                RegionsArray.add(getInput.nextInt());
                System.out.print(i + "nd program Time : ");
                RegionsArray.add(getInput.nextInt());
            }
            else if(i==3)
            {
                System.out.print("\n" + i + "rd program size : ");
                RegionsArray.add(getInput.nextInt());
                System.out.print(i + "rd program Time : ");
                RegionsArray.add(getInput.nextInt());
            }
            else if(i>=4)
            {
                System.out.print("\n" + i + "th program size : ");
                RegionsArray.add(getInput.nextInt());
                System.out.print(i + "th program Time : ");
                RegionsArray.add(getInput.nextInt());
            }
        }
        
        
        
        
        
        
        
    }
    
}
