/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.partition.manager;

import java.util.ArrayList;

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
        
        
        int [] memoryRegionsAndSizes = {3,5};
        int [] ram = {10,20,30};
        int [][] programsAndTime = {{4,10,50,12,30,30,50,20,200}, {2,10,100,20,25}, {1,25,19}, {1,19,41}, {2,10,18,30,42}};
        boolean [] isSet = {false, false, false};
        int timeCounter [][] = {{0, 0},{0, 0},{0, 0}};
        int memoryRegion;
        double avgTurnAroundTime = 0;
        int minimumIndexValue = 0 ,minimumIndex = 0;
        
        
        System.out.println(memoryRegionsAndSizes[0] + " " + memoryRegionsAndSizes[1]);
        System.out.println(ram[0] + " " + ram[1] + " " + ram[2]);
        
        
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
        System.out.println("\nCase 2");

        for(int i = 0; i < memoryRegionsAndSizes[1];i++)
        {
            //Switch&Replace Sort
            if(programsAndTime[i][0] > 1)
            {
                System.out.println( programsAndTime[i][0] + " Pairs on program " + (i+1));
                
                for(int k = 1; k <= programsAndTime[i][0]*2;k++)
                {
                    minimumIndexValue = programsAndTime[i][2];
                    if((k%2)==0)
                    {
                        try
                        {
                            System.out.println(k);
                            if(minimumIndexValue >= programsAndTime[i][k+2])
                            {
                                minimumIndexValue = programsAndTime[i][k+2];
                                minimumIndex = programsAndTime[i][k+1];
                            }
                        }
                        catch(ArrayIndexOutOfBoundsException e)
                        {
                            //Do nothing
                        }
                    }
                }
                System.out.println("Minimum time is = " + minimumIndexValue + " ,Minimum Time's Size is =  " + minimumIndex + "\n");

            }
//            if(isSet[0]==false)
//            {
//                //Memory region 1
//                if(programsAndTime[i][1] <= ram[0])
//                {
//                    memoryRegion = 1;
//                    timeCounter[0][1]+=programsAndTime[i][2];
//                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[0][0] + " to " + timeCounter[0][1] );
//                    isSet[0]=true;
//                    isSet[1]=false;
//                    isSet[2]=false;
//                    
//                    timeCounter[0][0] = timeCounter[0][1];
//                    avgTurnAroundTime+= timeCounter[0][1];
//                }
//                else if(programsAndTime[i][1] > ram[0] && programsAndTime[i][1] <= ram[1])
//                {
//                    memoryRegion = 2;
//                    timeCounter[1][1]+=programsAndTime[i][2];
//                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
//                    isSet[0]=true;
//                    isSet[1]=false;
//                    isSet[2]=false;
//                   
//                    timeCounter[1][0] = timeCounter[1][1];
//                    avgTurnAroundTime += timeCounter[1][1];
//                }
//                else if(programsAndTime[i][1] > ram[1] && programsAndTime[i][1] <= ram[2])
//                {
//                    memoryRegion = 3;
//                    timeCounter[2][1]+=programsAndTime[i][2];
//                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
//                    isSet[0]=true;
//                    isSet[1]=false;
//                    isSet[2]=false;
//                    
//                    timeCounter[2][0] = timeCounter[2][1];
//                    avgTurnAroundTime += timeCounter[2][1];
//                    
//                }
//            }
//            else if(isSet[1]==false)
//            {
//                //Memory region 2
//                if(programsAndTime[i][1] <= ram[1])
//                {
//                    memoryRegion = 2;
//                    timeCounter[1][1]+=programsAndTime[i][2];
//                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
//                    isSet[1]=true;
//                    isSet[0]=false;
//                    isSet[2]=false;
//                    
//                    timeCounter[1][0] = timeCounter[1][1];
//                    avgTurnAroundTime+= timeCounter[1][1];
//                }
//                else if(programsAndTime[i][1] > ram[1] && programsAndTime[i][1] <= ram[2])
//                {
//                    memoryRegion = 3;
//                    timeCounter[2][1]+=programsAndTime[i][2];
//                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
//                    isSet[1]=true;
//                    isSet[0]=false;
//                    isSet[2]=false;
//                    
//                    timeCounter[2][0] = timeCounter[2][1];
//                    avgTurnAroundTime+= timeCounter[2][1];
//                }
//            }
//            else if(isSet[2]==false)
//            {
//                //Memory region 3
//                if(programsAndTime[i][1] <= ram[2])
//                {
//                    System.out.println("sdsds");
//                    memoryRegion = 3;
//                    timeCounter[2][1]+=programsAndTime[i][2];
//                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[2][0] + " to " + timeCounter[2][1] );
//                    isSet[0]=false;
//                    isSet[1]=false;
//                    isSet[2]=true;
//                    timeCounter[2][0] = timeCounter[2][1];
//                    avgTurnAroundTime += timeCounter[2][1];
//                }
//            }
//            
        }
        System.out.println("Average turnaround time = " + avgTurnAroundTime/memoryRegionsAndSizes[1]);
    }
}
