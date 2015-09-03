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
        ArrayList<Integer> RegionsArray = new ArrayList<>();//Array with Modules,Programsize and Time for imput data
        ArrayList<Integer> RegionsAndSize = new ArrayList<>();
        ArrayList<Integer> ProgramCounter = new ArrayList<>();//Array with the program and the time
        ArrayList<ArrayList<Integer>> ProgramCounter1 = new ArrayList<ArrayList<Integer>>();
        
        int noOfRegionsInput;
        int noOfProgramsInput;
        int noOfRegions;
        int noOfPrograms;
        int programNumber=1;
        int memoryRegion;
        int initialTime = 0;
        int calculatedTime = 0;
        int caseNo = 0;
        
        
             
        System.out.println("Welcome to the Fixed Partition Manager");
        System.out.println("=======================================");
        
        
        //Data input Start
        
        //Get genaral the inputs 
        
        Scanner getInput = new Scanner(System.in);
        
        while (true)
        {
            
            System.out.println("\nCase " + (caseNo+1));
            System.out.print(" \nPlease Enter the number of memory Reigoions : ");

            noOfRegionsInput = getInput.nextInt();
            RegionsAndSize.add(noOfRegionsInput);
            System.out.print("Please Enter the number of programs to be executed : ");

            noOfProgramsInput = getInput.nextInt();
            RegionsAndSize.add(noOfProgramsInput);
            
            //Exit the loop when 0 0 pair is given as inputs
            if(noOfProgramsInput == 0 && noOfRegionsInput == 0 )
            {
                break;
            }

            System.out.println("\nAccording to the Regions you have entered, enter the Memory sizes in order ");
            System.out.println("=========================================================================== \n");

            
            //Get the sizes of memory regions as inputs
            for(int i = 0; i < RegionsAndSize.get(0); i++)
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


           // Get no of modules, program size and time to execute each program
            
            for(int i=1; i <=  RegionsAndSize.get(1); i++)
            {
                if(i==1)
                {
                    System.out.print("\nNo of modules : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "st program size : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "st program Time : ");
                    RegionsArray.add(getInput.nextInt());
                }
                else if(i==2)
                {
                    System.out.print("\nNo of modules : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "nd program size : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "nd program Time : ");
                    RegionsArray.add(getInput.nextInt());
                }
                else if(i==3)
                {
                    System.out.print("\nNo of modules : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "rd program size : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "rd program Time : ");
                    RegionsArray.add(getInput.nextInt());
                }
                else if(i>=4)
                {
                    System.out.print("\nNo of modules : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "th program size : ");
                    RegionsArray.add(getInput.nextInt());
                    System.out.print(i + "th program Time : ");
                    RegionsArray.add(getInput.nextInt());
                }
            }
            //Data input Stop
            
            
            caseNo++; // increment case
            
        }//while end


        
        //Print the Indexes
            
        System.out.println("\nProgram will now Start Calculateion");
        System.out.println("====================================\n");
        
        System.out.println("Memory Regions =====>\n");
        System.out.println("Index [0] is = " +RegionsArray.get(0));
        System.out.println("Index [1] is = " +RegionsArray.get(1));
        
        System.out.println("Modules,Size, Time Taken =====>\n");
        System.out.println("Index [2] is = " +RegionsArray.get(2));
        System.out.println("Index [3] is = " +RegionsArray.get(3));
        System.out.println("Index [4] is = " +RegionsArray.get(4));
        System.out.println("Index [5] is = " +RegionsArray.get(5));
        System.out.println("Index [6] is = " +RegionsArray.get(6));
        System.out.println("Index [7] is = " +RegionsArray.get(7));
        System.out.println("Index [8] is = " +RegionsArray.get(8));
        System.out.println("Index [9] is = " +RegionsArray.get(9));
        System.out.println("Index [10] is = " +RegionsArray.get(10));
        System.out.println("Index [11] is = " +RegionsArray.get(11));
        System.out.println("Index [12] is = " +RegionsArray.get(12));
        System.out.println("Index [13] is = " +RegionsArray.get(13));

       
        System.out.println("\nRegions = " + RegionsAndSize.get(0) + " And the No. Of times the loop should run = " + (RegionsAndSize.get(1)*3) );
        
        //Start the Program
        boolean isSet = false;
        
        for(int i= RegionsAndSize.get(0);i <= (RegionsAndSize.get(1)*3); i++)
        {
            
            if((i % 3) == 0)
            {
                System.out.println("\nRunning for Index ["+i+"]");
                
                programNumber++;
                
                
                System.out.println("Running for Indexes are Ended");
                System.out.println("=============================\n");
            }
            
        }
        
        
        int FValue=0;
        int SValue=1;
        int TValue=2;
        int FoValue=3;
        
        
        for(ArrayList<Integer> r : ProgramCounter1)
        {
            //System.out.print(" " + r);
            
            int rem = r.size()/4;
            int rem2 = r.size();


                //System.out.println("Cheking Values are : " + FValue + " " + SValue + " " + TValue + " " + FoValue );
                System.out.println("Program " + r.get(FValue) +" runs in region " + r.get(SValue) + " from " + r.get(TValue) + " to " + r.get(FoValue));
                
                FValue+=4;
                SValue+=4;
                TValue+=4;
                FoValue+=4;
         
            
            
        }
        
        System.out.println("\n");
    }
    
}
