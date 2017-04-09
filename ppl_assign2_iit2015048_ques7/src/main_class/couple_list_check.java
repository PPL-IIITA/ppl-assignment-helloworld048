/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main_class;

import Check_Class.check;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author aish
 */
public class couple_list_check extends check{
        public void check(ArrayList<String>vb) {
            String fileName = "question_7_output.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String content = "Checking if boys are committed or not" ;
            bufferedWriter.write(content) ;
            for( int i = 0 ; i < vb.size() ; i++ ){
                for( int j = 0 ; j < voc.size() ; j++ ){
                    if( vb.get(i) == voc.get(j).boy_name ){
                        content = vb.get(i) + "Is Committed " ;
                        bufferedWriter.write(content) ;
                        bufferedWriter.newLine(); ;
                    }
                }
            }
            bufferedWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
}





