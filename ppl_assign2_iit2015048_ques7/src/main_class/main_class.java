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
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.* ;
import Check_Class.*;
/**
 *
 * @author aish
 */

public class main_class {
    
    
    
    public static void main( String[] args ) throws IOException {
        //System.out.println("ajsiad") ;
        ArrayList< boys_class >vob = new ArrayList<>() ;
        ArrayList<boys_class>temp = new ArrayList<>()  ;
        ArrayList< girls_class >vog =new ArrayList<>() ;
        ArrayList< couple_class >voc = new ArrayList<>()  ;
        ArrayList< gift_class >vogift = new ArrayList<>() ;
        ArrayList< String >vb = new ArrayList<>();
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("log.txt"));
        String name = null ;
        String file_name = "boys_list.csv" ;
        String line = "" ;
        String splitBy = "," ;
        
       
            try(BufferedReader br = new BufferedReader( new FileReader(file_name))){
                
                while( (line = br.readLine()) != null ){
                    String[] boy = line.split(splitBy) ;
                    name = boy[0] ;
                  //  System.out.println(name);
                    if( "%$#".equals(name))
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
            System.out.println("Unable to open file named :: " + file_name ) ;
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
                    if( "%$#".equals(name))
                        break ;
                    girls_class g = new girls_class();
                    int attractive = Integer.parseInt(girl[1]) ;
                    int mb = Integer.parseInt(girl[2]) ;
                    int intell = Integer.parseInt(girl[3]) ;
                    String cb = girl[4] ;
                    String ct = girl[5] ;
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
        file_name = "gift_list.csv" ;
        line = "" ;
        
        try(BufferedReader br = new BufferedReader( new FileReader(file_name))){
                
                while( (line = br.readLine()) != null ){
                    String[] inp = line.split(splitBy) ;
                    int pr,val,lr,df,uv,uc ;
                    String tt ;
                    pr = Integer.parseInt(inp[0]) ;
                    val = Integer.parseInt(inp[1]) ;
                    tt = inp[2] ;
                    if(  "***".equals(tt) )
                        break ;
                    lr = Integer.parseInt(inp[3]) ;
                    df = Integer.parseInt(inp[4]) ;
                    uv = Integer.parseInt(inp[5]) ;
                    uc = Integer.parseInt(inp[6]) ;
                    
                    gift_class gi = new gift_class();
                    gi.add_gift(pr,val,tt,lr,df,uv,uc) ;
                    vogift.add(gi) ;
                }
            }
        catch( FileNotFoundException ex){
            System.out.println("Unable to open file named :: " + file_name ) ;
        }
        catch(IOException ex){
            System.out.println("Error Reading File");
        }  
        
        //sort fucntion
        for( int i= 0 ; i < vogift.size()-1 ; i++ ){
            for( int j = 0 ; j < vogift.size()-i-1 ; j++ ){
                if( vogift.get(j).price > vogift.get(j+1).price){
                   int pr,value,lr,df,uv,uc;
                   String tt;
                   pr=vogift.get(j).price;
                   value=vogift.get(j).value;
                   tt=vogift.get(j).type;
                   lr=vogift.get(j).luxury_rating;
                   df=vogift.get(j).difficulty;
                   uc=vogift.get(j).utility_class;
                   uv=vogift.get(j).utility_values;
                   vogift.get(j).price=vogift.get(j+1).price;
                   vogift.get(j).value=vogift.get(j+1).value;
                   vogift.get(j).type=vogift.get(j+1).type;
                   vogift.get(j).luxury_rating=vogift.get(j+1).luxury_rating;
                   vogift.get(j).difficulty=vogift.get(j+1).difficulty;
                   vogift.get(j).utility_class=vogift.get(j+1).utility_class;
                   vogift.get(j).utility_values=vogift.get(j+1).utility_values;
                   vogift.get(j+1).price=pr;
                   vogift.get(j+1).value = value;
                   vogift.get(j+1).type = tt ;
                   vogift.get(j+1).luxury_rating = lr;
                   vogift.get(j+1).difficulty = df;
                   vogift.get(j+1).utility_class = uc;
                   vogift.get(j+1).utility_values = uv;
                   
                }
            }
        }
        //make_couple for given question
        int nb = vob.size() ;
        int ng = vog.size() ;
        for( int i = 0 ; i < ng ; i++ ){
            temp.clear() ;
            for( int j = 0 ; j < nb ; j++ ){
                if( !vob.get(j).committed && (vob.get(j).boys_gf_budget >= vog.get(i).maintenance_budget ) &&  vob.get(j).min_attract_require <= vog.get(i).attractiveness) {
                  temp.add( vob.get(j)) ;  
                } 
            }
            int nt = temp.size() , ind = -1 , mx = -1 ;
            if( "Most_Attractive".equals(vog.get(i).criteria_boys) ){
                for( int j = 0 ; j < nt ; j++ ){
                    if ( temp.get(j).attractiveness >= mx ) {
                        mx = temp.get(j).attractiveness ;
                        ind = j ;
                    }
                }
            }
            if( "Most_Rich".equals(vog.get(i).criteria_boys) ){
                for( int j = 0 ; j < nt ; j++ ){
                    if ( temp.get(j).boys_gf_budget >= mx ) {
                        mx = temp.get(j).boys_gf_budget;
                        ind = j ;
                    }
                }
            }
            if( "Most_Intelligent".equals(vog.get(i).criteria_boys) ){
                for( int j = 0 ; j < nt ; j++ ){
                    if ( temp.get(j).intelligence >= mx ) {
                        mx = temp.get(j).intelligence ;
                        ind = j ;
                    }
                }
            }
            
            if( ind != -1 ){
                couple_class c ;
                int ind2 = -1 ;
                for( int j = 0 ; j < nb ; j++ ){
                    if( vob.get(j).name.equals(temp.get(ind).name) ){
                        ind2 = j ;
                    }
                }
                c = new couple_class() ;
                c.add_Couple(vob.get(ind2),vog.get(i));
                voc.add(c) ;
            }
    }
    for( int i = 0 ; i < voc.size() ; i++ ){
        voc.get(i).Set_Gifts( vob, nb , vog , ng , vogift ) ; 
    }
    //boys who are to be checked 
    for( int i = 0 ; i < vob.size() ; i++ ){
        vb.add(vob.get(i).name);
    }
            int i = 0 ;
            if( i % 2 == 0 ){
                //implementing couple list check 
                couple_list_check c1 = new couple_list_check() ;
                c1.vob = vob ;
                c1.voc = voc ;
                c1.check(vb) ;
            }
            else{
                //implementing hash check
               Hash_check hc = new Hash_check() ;
               hc.vob = vob ;
               hc.voc = voc ;
               hc.check(vb) ;
            }
}
}

