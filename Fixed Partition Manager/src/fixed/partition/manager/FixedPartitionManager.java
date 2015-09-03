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
        int initialTime = 0;
        int time = 0;
        int caseNo = 1;
        
             
        System.out.println("Welcome to the Fixed Partition Manager");
        System.out.println("=======================================");
        
        
        //Data input Start
        
        //Get genaral the inputs 
        
        Scanner getInput = new Scanner(System.in);
        
        while (true)
        {
            
            System.out.println("\nCase " + caseNo);
            System.out.print(" \nPlease Enter the number of memory Reigoions : ");

            noOfRegions = getInput.nextInt();

            System.out.print("Please Enter the number of programs to be executed : ");

            noOfPrograms = getInput.nextInt();
            
            //Exit the loop when 0 0 pair is given as inputs
            if(noOfPrograms == 0 && noOfRegions == 0 )
            {
                break;
            }

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


            System.out.println("\nAccording to the No of programs mentioned above Enter the Size and the time taken to execute each program");
            System.out.println("===========================================================================================================");


           // Get program size and time to execute each program
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
            //Data input Stop
            
            
            caseNo++; // increment case
            
        }//while end

        
        
        
            //Program Start
            
        System.out.println("\nProgram will now Start Calculateion");
        System.out.println("====================================\n");
        
        System.out.println("Memory Regions =====>\n");
        System.out.println("Index [0] is = " +RegionsArray.get(0));
        System.out.println("Index [1] is = " +RegionsArray.get(1));
        
        System.out.println("\n");
            
        System.out.println("Program size and Time taken as Pairs of two ======>\n");
        System.out.println("Index [2] is = " +RegionsArray.get(2));
        System.out.println("Index [3] is = " +RegionsArray.get(3));
        System.out.println("Index [4] is = " +RegionsArray.get(4));
        System.out.println("Index [5] is = " +RegionsArray.get(5));
        System.out.println("Index [6] is = " +RegionsArray.get(6));
        System.out.println("Index [7] is = " +RegionsArray.get(7));
        System.out.println("Index [8] is = " +RegionsArray.get(8));
        System.out.println("Index [9] is = " +RegionsArray.get(9));
       
        
    }
    
}
