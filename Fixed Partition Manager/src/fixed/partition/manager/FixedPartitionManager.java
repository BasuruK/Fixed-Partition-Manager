/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.partition.manager;

import java.util.ArrayList;
import java.util.Arrays;
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
        
        /**
         * These are test array lists
         * may or may not be used in the final, best to ignore
         */
        ArrayList<ArrayList<Integer>> PrintArray = new ArrayList<>();
        ArrayList<Integer> addToPrintArray = new ArrayList<>();

        int [] memoryRegionsAndSizes = new int [2];
        int [] ram = null;
        int [][] programsAndTime = null;
        boolean [] isSet = {false, false, false};
        int timeCounter [][] = {{0, 0},{0, 0},{0, 0},{0, 0}};

        int caseNo =1;
        int memoryRegion;
        double avgTurnAroundTime = 0;
        
        Scanner getInput = new Scanner(System.in);
        
        //Get keyboard Inputs
        System.out.print("No. Of Mempory Regions : ");
        memoryRegionsAndSizes[0] = getInput.nextInt();
        System.out.print("No. of Programs : ");
        memoryRegionsAndSizes[1] = getInput.nextInt();
        
        while(memoryRegionsAndSizes[0] != 0 && memoryRegionsAndSizes[1] != 0)
        {
            ram = new int [memoryRegionsAndSizes[0]];
            programsAndTime = new int [memoryRegionsAndSizes[1]][5];
            
            System.out.println("=====Begining=====");
            
            //Fill the Ram
            for(int i = 0; i < memoryRegionsAndSizes[0]; i++)
            {
                System.out.print("Enter Memory Region " + (i+1) + " size : ");
                ram[i] = getInput.nextInt();
            }
            
            //Fill the programs and sizes
            for(int i = 0; i < memoryRegionsAndSizes[1]; i++)
            { 
                System.out.print("Enter Program " + (i+1) + " Pairs : ");
                programsAndTime[i][0] = getInput.nextInt();
                
                if(programsAndTime[i][0] == 1)
                {
                    for(int k = 1; k <= programsAndTime[i][0]; k++)
                    {
                        System.out.print("Enter Program " + (i+1) + " Size : ");
                        programsAndTime[i][k] = getInput.nextInt();
                        System.out.print("Enter Program " + (i+1) + " Execution Time : ");
                        programsAndTime[i][k+1] = getInput.nextInt();
                    }
                }
                else
                {
                    for(int k = 1; k <= programsAndTime[i][0]+2; k++)
                    {
                        System.out.print("Enter Program " + (i+1) + " Size : ");
                        programsAndTime[i][k] = getInput.nextInt();
                        System.out.print("Enter Program " + (i+1) + " Execution Time : ");
                        programsAndTime[i][k+1] = getInput.nextInt();
                        k++;
                    }
                }
            }
            

                try 
                {
                    //Print sizes and ram
                    System.out.println(memoryRegionsAndSizes[0] + " " + memoryRegionsAndSizes[1]);
                    for(int k : ram)
                    {
                        System.out.print(k + " ");
                    }
                    System.out.println("");
                    
             }catch(IndexOutOfBoundsException e)
             {
                 System.out.println(e.getMessage());
             }


                for(int i = 0; i < programsAndTime.length; i++)
                {
                    for(int j = 0; j<9; j++)
                    {
                        try
                        {
                            System.out.print(programsAndTime[i][j] + " ");
                        }
                        catch(ArrayIndexOutOfBoundsException e)
                        {
                            //Do nothing
                        }
                    }
                    System.out.println("");
                }


            //Program logic
            System.out.println("\nCase " + caseNo);

            //Sort the Array
            Algorithms Algorithm = new Algorithms();
            Algorithm.ReplaceSort(programsAndTime,memoryRegionsAndSizes[1]);
            Algorithm.locationSort(programsAndTime,memoryRegionsAndSizes[1]);

            int [] Array = Algorithm.getChangedIndexs();
            
            for(int i = 0; i < memoryRegionsAndSizes[1];i++)
            {

                //Assiginin Start
                if(isSet[0]==false)
                {
                    //Memory region 1
                    if(programsAndTime[i][1] <= ram[0])
                    {
                        memoryRegion = 1;
                        timeCounter[0][1]+=programsAndTime[i][2];
                        System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[0][0] + " to " + timeCounter[0][1] );
                        addToPrintArray.add(i);
                        addToPrintArray.add(memoryRegion);
                        addToPrintArray.add(timeCounter[0][0]);
                        addToPrintArray.add(timeCounter[0][1]);
                        isSet[0]=true;
                        isSet[1]=false;
                        isSet[2]=false;

                        timeCounter[0][0] = timeCounter[0][1];
                        avgTurnAroundTime+= timeCounter[0][1];
                    }
                    else if(programsAndTime[i][1] > ram[0] && programsAndTime[i][1] <= ram[1])
                    {
                        memoryRegion = 2;
                        timeCounter[1][1]+=programsAndTime[i][2];
                        System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
                        addToPrintArray.add(i);
                        addToPrintArray.add(memoryRegion);
                        addToPrintArray.add(timeCounter[1][0]);
                        addToPrintArray.add(timeCounter[1][1]);
                        isSet[0]=true;
                        isSet[1]=true;
                        isSet[2]=false;

                        timeCounter[1][0] = timeCounter[1][1];
                        avgTurnAroundTime += timeCounter[1][1];
                    }
                    else if(programsAndTime[i][1] > ram[1] && programsAndTime[i][1] <= ram[2])
                    {
                        memoryRegion = 3;
                        timeCounter[2][1]+=programsAndTime[i][2];
                        System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
                        addToPrintArray.add(i);
                        addToPrintArray.add(memoryRegion);
                        addToPrintArray.add(timeCounter[2][0]);
                        addToPrintArray.add(timeCounter[2][1]);
                        isSet[0]=true;
                        isSet[1]=true;
                        isSet[2]=false;

                        timeCounter[2][0] = timeCounter[2][1];
                        avgTurnAroundTime += timeCounter[2][1];

                    }
                }
                else if(isSet[1]==false)
                {
                    //Memory region 2
                    if(programsAndTime[i][1] <= ram[1])
                    {
                        memoryRegion = 2;
                        timeCounter[1][1]+=programsAndTime[i][2];
                        System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
                        addToPrintArray.add(i);
                        addToPrintArray.add(memoryRegion);
                        addToPrintArray.add(timeCounter[1][0]);
                        addToPrintArray.add(timeCounter[1][1]);
                        isSet[1]=true;
                        isSet[0]=false;
                        isSet[2]=false;

                        timeCounter[1][0] = timeCounter[1][1];
                        avgTurnAroundTime+= timeCounter[1][1];
                    }
                    else if(programsAndTime[i][1] > ram[1] && programsAndTime[i][1] <= ram[2])
                    {
                        memoryRegion = 3;
                        timeCounter[2][1]+=programsAndTime[i][2];
                        System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
                        addToPrintArray.add(i);
                        addToPrintArray.add(memoryRegion);
                        addToPrintArray.add(timeCounter[2][0]);
                        addToPrintArray.add(timeCounter[2][1]);
                        isSet[1]=true;
                        isSet[0]=false;
                        isSet[2]=false;

                        timeCounter[2][0] = timeCounter[2][1];
                        avgTurnAroundTime+= timeCounter[2][1];
                    }

                }
                else if(isSet[2]==false)
                {
                    //Memory region 3
                    if(programsAndTime[i][1] <= ram[2])
                    {
                        memoryRegion = 3;
                        timeCounter[2][1]+=programsAndTime[i][2];
                        System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
                        addToPrintArray.add(i);
                        addToPrintArray.add(memoryRegion);
                        addToPrintArray.add(timeCounter[2][0]);
                        addToPrintArray.add(timeCounter[2][1]);
                        isSet[0]=false;
                        isSet[1]=false;
                        isSet[2]=true;

                        timeCounter[2][0] = timeCounter[2][1];
                        avgTurnAroundTime += timeCounter[2][1];
                    }
                }

            }
            System.out.println("Average turnaround time = " + avgTurnAroundTime/memoryRegionsAndSizes[1]);
            caseNo++;
            
            //Clear time Counter
            for(int [] p : timeCounter)
            {
                Arrays.fill(p,0);
            }
            //Clear AVG time
            avgTurnAroundTime = 0;
            //Clear Programs and times
            for(int [] p : programsAndTime)
            {
                Arrays.fill(p, 0);
            }
            //clear isSet array
            Arrays.fill(isSet, false);
            
            System.out.print("No. Of Mempory Regions : ");
            memoryRegionsAndSizes[0] = getInput.nextInt();
            System.out.print("No. of Programs : ");
            memoryRegionsAndSizes[1] = getInput.nextInt();
        }
        
        PrintArray.add(addToPrintArray);
        int i = 0;
        System.out.println("\n");

   }
}
