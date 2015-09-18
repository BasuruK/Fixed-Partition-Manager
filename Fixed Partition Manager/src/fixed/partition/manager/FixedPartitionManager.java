/*
 * Fixed Parition Manager Created by Basuru Kusal
 * Using the program without the authorization will result in violation of certain rules
 * All rights not Reserved
 */
package fixed.partition.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
        
        //Final Results are stored in these ArrayLists
        ArrayList<ArrayList<String>> Arr = new ArrayList<>();
        ArrayList<String> A = new ArrayList<>();

        int [] memoryRegionsAndSizes = new int [2];
        int [] ram = null;
        int [][] programsAndTime = null;
        boolean [] isSet = {false, false, false};
        int timeCounter [][];

        int caseNo = 1;
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
            isSet = new boolean[memoryRegionsAndSizes[0]*2];
           timeCounter = new int [memoryRegionsAndSizes[0]][2];
            ram = new int [memoryRegionsAndSizes[0]];
            programsAndTime = new int [memoryRegionsAndSizes[1]][5];
            
            Arrays.fill(isSet, false);
            
            for(int [] r: timeCounter)
            {
                Arrays.fill(r, 0);
            }
            
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
            
            //Program logic
            A.add("\nCase " + caseNo);
            
            //Sort the Array
            Algorithms Algorithm = new Algorithms();
            Algorithm.ReplaceSort(programsAndTime,memoryRegionsAndSizes[1]);
            Algorithm.addProgramNo(programsAndTime, memoryRegionsAndSizes[1]);
            Algorithm.SORT(programsAndTime,memoryRegionsAndSizes[1]);
 

            /**
             * Ignore this Array
             * UNDER CONSTRUCTION
             */
            
            try
            {
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
                            A.add("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[0][0] + " to " + timeCounter[0][1] );
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
                            A.add("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
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
                            A.add("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
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
                             A.add("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
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
                             A.add("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
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
                             A.add("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
                            isSet[0]=false;
                            isSet[1]=false;
                            isSet[2]=true;

                            timeCounter[2][0] = timeCounter[2][1];
                            avgTurnAroundTime += timeCounter[2][1];
                        }
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                //Do nothing
            }
            A.add("Average turnaround time = " + avgTurnAroundTime/memoryRegionsAndSizes[1]);
            caseNo++;
            avgTurnAroundTime = Algorithm.Clear(timeCounter, programsAndTime, isSet);
            
            System.out.print("\nNo. Of Mempory Regions : ");
            memoryRegionsAndSizes[0] = getInput.nextInt();
            System.out.print("No. of Programs : ");
            memoryRegionsAndSizes[1] = getInput.nextInt();
        }
        
        //Add the values to a STRING ARRAY
        Arr.add(A);
        
        int i = 0;
        int size;
       
        System.out.println("\n");
        
       
        
        for(ArrayList<String> r : Arr)
        {
            size = r.size();
            while(i < size)
            {
                System.out.println(r.get(i));
                i++;
            }
        }
   }
}
