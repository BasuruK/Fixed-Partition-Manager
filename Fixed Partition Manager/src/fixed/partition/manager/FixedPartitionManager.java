/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.partition.manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        
//        int [] memoryRegionsAndSizes = {3,5};
//        int [] ram = {10,20,30};
//        int [][] programsAndTime = {{2,10,50,12,30}, {2,10,100,20,25}, {1,25,19}, {1,19,41}, {2,10,18,30,42}};
//        boolean [] isSet = {false, false, false};
//        int timeCounter [][] = {{0, 0},{0, 0},{0, 0}};
//        int memoryRegion;
//        double avgTurnAroundTime = 0;
        int [] memoryRegionsAndSizes = new int [2];
        int [] ram = null;
        int [][] programsAndTime = null;
        boolean [] isSet = {false, false, false};
        int timeCounter [][] = {{0, 0},{0, 0},{0, 0}};
        
        String [][] TEMP = new String[10][10];
        boolean [] status = {true,true,true};
        int g=0;
       
        int memoryRegion;
        double avgTurnAroundTime = 0;
        
        String S;
        try {
            BufferedReader getInputs = new BufferedReader(new FileReader("src\\fixed\\partition\\manager\\Inputs.txt"));
            while(!( S = getInputs.readLine()).matches("0 0")) {
                
               String [] Tokens = S.split(" ");
                if(status[0])
                {
                    for(int i = 0;i < Tokens.length-1;i++)
                    {
                        for(int j = 0;j < Tokens.length;j++)
                        {
                            System.out.println("memoryRegionsAndSizes["+j+"] = Tokens["+j+"]");       
                            memoryRegionsAndSizes[j] = Integer.parseInt(Tokens[j]);
                        }
                    }
                    programsAndTime = new int[memoryRegionsAndSizes[1]][5];
                    status[0]=false;
                }
                else if(status[1])
                {
                    ram = new int[memoryRegionsAndSizes[0]];
                    for(int i = 0;i < Tokens.length-2;i++)
                    {
                        for(int j = 0;j < Tokens.length;j++)
                        {
                            System.out.println("RAM["+j+"] = Tokens["+j+"]");       
                            ram[j] = Integer.parseInt(Tokens[j]);
                        }
                    }
                    status[1]=false;
                }
                else if(status[2])
                {
                        for(int j = 0;j < Tokens.length;j++)
                        {
                            System.out.println("programsAndTime["+g+"]["+j+"] = Tokens["+j+"]");       
                            programsAndTime[g][j] = Integer.parseInt(Tokens[j]);
                        }
                    g++;
                    if(g<memoryRegionsAndSizes[1])
                    {
                        status[2]=true;
                    }
                    else
                    {
                        status[2]=false;
                    }
                }
                System.out.print("");
                
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FixedPartitionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FixedPartitionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
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
                    isSet[1]=false;
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


        
        PrintArray.add(addToPrintArray);
        int i = 0;
        System.out.println("\n");
        
        for(int r : Array)
        {
            System.out.print(r + " ");
        }
        
        for(ArrayList<Integer> r: PrintArray)
        {
            while(true)
            {
             i = Array[0];
             System.out.println("Program "+ r.get(i-1) + " runs in region " + r.get(i) + " from " + r.get(i+1) + " to " + r.get(i+2) );
             break;
                             
            }
        }


        
        
   }
}
