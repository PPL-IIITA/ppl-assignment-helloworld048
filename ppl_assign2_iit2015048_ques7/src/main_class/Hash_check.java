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
public class Hash_check extends check {
    @Override
    public void check( ArrayList<String>vb){
        String fileName = "question_7_output.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String content = "Checking if boys are committed or not" ;
            bufferedWriter.write(content) ;
            bufferedWriter.newLine();
            for( int i = 0 ; i < vb.size() ; i++ ){
                content = i + " " ;
                for( int j = 0 ; j < vob.size() ; j++ ){
                    if( vb.get(i) == vob.get(j).name && vob.get(j).committed == true ){
                        content = content + " " + vb.get(i) + " is committed " ;
                        bufferedWriter.write(content) ;
                        bufferedWriter.newLine(); ;
                        break ;
                    }
                }
            }
            bufferedWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void check() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
