/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main_class;
import Boys_Package.* ;
import Couple.* ;
import Gift_Package.* ;
import Girls_Package.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.* ;
/**
 *
 * @author aish
 */

public class main_class {
    public static void main( String[] args ) throws IOException{
        ArrayList< boys_class >vob = new ArrayList<>() ;
        ArrayList<boys_class>temp = new ArrayList<>()  ;
        ArrayList< girls_class >vog =new ArrayList<>() ;
        ArrayList< couple_class >voc = new ArrayList<>()  ;
        ArrayList< gift_class >vogift = new ArrayList<>() ;
        
      //  DataOutputStream dos = new DataOutputStream(new FileOutputStream("log.txt"));
        String name = null ;
        String file_name = "boys_list.csv" ;
        String line = "" ;
        String splitBy = "," ;
        
       
            try(BufferedReader br = new BufferedReader( new FileReader(file_name))){
                
                while( (line = br.readLine()) != null ){
                    String[] boy = line.split(splitBy) ;
                    name = boy[0] ;
                  //  System.out.println(name);
                    if( name == "%$#")
                        break ;
                    boys_class b = new boys_class();
                    int attractive ;
                    attractive = Integer.parseInt(boy[1]);
                    int budget = Integer.parseInt(boy[2]) ;
                    int intell = Integer.parseInt(boy[3]) ;
                    int min_att = Integer.parseInt(boy[4]) ;
                    String ct = boy[5] ;
                //    System.out.println(ct +" "+  name +" "+ attractive +" "+ budget +" "+ intell +" "+ min_att +" ") ;
                    b._Initialize(name , attractive , budget , intell, min_att, ct) ;
                    vob.add(b) ;
                }
            }
        catch( FileNotFoundException ex){
            System.out.println(file_name + "Unable to open file named :: " ) ;
        }
        catch(IOException ex){
            System.out.println("Error Reading File");
        }
            
        name = null ;
        file_name = "girls_list.csv" ;
        line = "" ;
        
        try(BufferedReader br = new BufferedReader( new FileReader(file_name))){
                
                while( (line = br.readLine()) != null ){
                    String[] girl = line.split(splitBy) ;
                    name = girl[0] ;
                    if( name == "%$#")
                        break ;
                    girls_class g = new girls_class();
                    int attractive = Integer.parseInt(girl[1]) ;
                    int mb = Integer.parseInt(girl[2]) ;
                    int intell = Integer.parseInt(girl[3]) ;
                    String cb = girl[4] ;
                    String ct = girl[5] ;
                 //   System.out.println(cb + " "+ ct ) ;
                    g.initialize(name , attractive ,mb, intell,cb , ct) ;
                    vog.add(g) ;
                }
            }
        catch( FileNotFoundException ex){
            System.out.println("Unable to open file named :: " + file_name ) ;
        }
        catch(IOException ex){
            System.out.println("Error Reading File");
        }
        
        name = null ;
        file_name = "couples_list.csv" ;
        line = "" ;
        
        try(BufferedReader br = new BufferedReader( new FileReader(file_name))){
                
                while( (line = br.readLine()) != null ){
                    String[] inp = line.split(splitBy) ;
                    String bname , gname ;
                    int happ , comp ;
                    bname = inp[0] ;
                    if(  "***".equals(bname))
                        break ;
                    gname =  inp[1] ;
                    happ = Integer.parseInt(inp[2]) ;
                    comp = Integer.parseInt(inp[3]) ;
                    couple_class c = new couple_class();
                    //System.out.println(bname + " " + gname + " " + happ + " " + comp ) ;
                    c.boy_name = bname ;
                    c.girl_name = gname ;
                    c.happiness = happ ;
                    c.compatibility = comp ;
                    voc.add(c) ;
                }
            }
        catch( FileNotFoundException ex){
            System.out.println("Unable to open file named :: " + file_name ) ;
        }
        catch(IOException ex){
            System.out.println("Error Reading File");
        }  
        
        //sort fucntion
        for( int i= 0 ; i < voc.size()-1 ; i++ ){
            for( int j = 0 ; j < voc.size()-i-1 ; j++ ){
                if( voc.get(j).happiness > voc.get(j+1).happiness){
                   String bname , gname ;
                   int happ , comp ;
                   bname=voc.get(j).boy_name;
                   gname=voc.get(j).girl_name;
                   happ=voc.get(j).happiness;
                   comp=voc.get(j).compatibility;
                   
                   voc.get(j).boy_name=voc.get(j+1).boy_name;
                   voc.get(j).girl_name=voc.get(j+1).girl_name;
                   voc.get(j).happiness=voc.get(j+1).happiness;
                   voc.get(j).compatibility=voc.get(j+1).compatibility;
                  
                   voc.get(j+1).boy_name=bname;
                   voc.get(j+1).girl_name = gname;
                   voc.get(j+1).happiness = happ ;
                   voc.get(j+1).compatibility = comp;
                   
                }
            }
        }
        int k = 1 ;
        for( int i = 0 ; i < k && i < voc.size() ; i++ ){
            int ind1 = 0,ind2 = 0;
            couple_class c = voc.get(i) ;
            for( int j = 0 ; j < vob.size() ; j++ ){
                if( vob.get(j).name == voc.get(i).boy_name) {
                  ind1 = j ;
                } 
            }
            for( int j = 0 ; j < vog.size();j++ ){
                if( vog.get(j).name == voc.get(i).boy_name){
                    ind2 = j ;
                }
            }
            c.break_up(vob.get(ind1), vog.get(ind2));
            voc.get(i).boy_name = "****" ;
    }
        String fileName = "couples_list_after_breakup.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
           for( int i = 0 ; i < voc.size();i++ ){
        //  System.out.println("aish");
            if( voc.get(i).boy_name == "****" )continue ;
            String content = voc.get(i).boy_name + " " + voc.get(i).girl_name + " "+ voc.get(i).happiness + " "+ voc.get(i).compatibility ;
            System.out.println(content) ;
            bufferedWriter.write(content);
            bufferedWriter.newLine();
        }
            bufferedWriter.write("***");
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
   
}
}

