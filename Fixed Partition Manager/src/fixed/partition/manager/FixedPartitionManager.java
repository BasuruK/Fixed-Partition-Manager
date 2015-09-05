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
        
        /**
         * These are test array lists
         * may or may not be used in the final, best to ignore
         */
        ArrayList<ArrayList<Integer>> PrintArray = new ArrayList<>();
        ArrayList<Integer> addToPrintArray = new ArrayList<>();
        
        
        int [][] memoryRegionsAndSizes = {{2,4}};
        int [][] ram = {{40,60}};
        int [][] programsAndTime = {{1,35,4}, {1,20,3}, {1,40,10}, {1,60,7}};
        boolean [] isSet = {false, false};
        int timeCounter [][] = {{0, 0},{0, 0}};
        int memoryRegion;
        
        System.out.println(memoryRegionsAndSizes[0][0] + " " + memoryRegionsAndSizes[0][1]);
        System.out.println(ram[0][0] + " " + ram[0][1]);
        
        for(int i = 0; i < programsAndTime.length; i++)
        {
            for(int j = 0; j<3;j++)
            {
                System.out.print(programsAndTime[i][j] + " ");
            }
            System.out.println("");
        }
        
        //Program logic
        System.out.println("\nCase 1");

        for(int i = 0; i < memoryRegionsAndSizes[0][1];i++)
        {
            if(isSet[0]==false)
            {
                if(programsAndTime[i][1] <= ram[0][0])
                {
                    memoryRegion = 1;
                    timeCounter[0][1]+=programsAndTime[i][2];
                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[0][0] + " to " + timeCounter[0][1] );
                    isSet[0]=true;
                    isSet[1]=false;
                    timeCounter[0][0] = timeCounter[0][1];
                }
                else if(programsAndTime[i][1] > ram[0][0] && programsAndTime[i][1] <= ram[0][1])
                {
                    memoryRegion = 2;
                    timeCounter[0][1]+=programsAndTime[i][2];
                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[0][0] + " to " + timeCounter[0][1] );
                    isSet[0]=true;
                    isSet[1]=false;
                    timeCounter[0][0] = timeCounter[0][1];
                }
            }
            else if(isSet[1]==false)
            {
                if(programsAndTime[i][1] <= ram[0][1])
                {
                    memoryRegion = 2;
                    timeCounter[1][1]+=programsAndTime[i][2];
                    System.out.println("Program "+ (i+1) + " runs in region " + memoryRegion + " from " + timeCounter[1][0] + " to " + timeCounter[1][1] );
                    isSet[1]=true;
                    isSet[0]=false;
                    timeCounter[1][0] = timeCounter[1][1];
                }
            }
            
        }
    
    }
}
