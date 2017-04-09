package Boys_Package;

import Girls_Package.girls_class;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aish
 */
public class boys_class {
    
    public boolean committed ;
    public String name , status , gf_name , committed_type;
    public int attractiveness , happiness , boys_gf_budget , intelligence , min_attract_require, total_gift_price ;
    public int total_gift_value ;
    public boys_class(){
        committed = false ;
        gf_name = "" ;
    }
    public void _Initialize(String name , int attract , int intell , int girl_budg ,int min_attract_req, String tp){
        this.name = name ;
        this.attractiveness = attract ;
        this.boys_gf_budget = girl_budg ;
        this.intelligence = intell ;
        this.min_attract_require = min_attract_req ;
        this.committed_type = tp ;
    }
    public void Set_Committed(){
        this.committed = true ;
    }
    public void Set_Happiness( ArrayList<girls_class>g , int ng ){
        if( this.committed == false )
            return ;
        switch (this.committed_type) {
            case "Miser":
                this.happiness = boys_gf_budget - total_gift_price ;
                break;
            case "Generous":
                for( int i = 0 ; i < ng ; i++ ){
                    if( this.gf_name == null ? g.get(i).name == null : this.gf_name.equals(g.get(i).name) )
                        this.happiness = g.get(i).happiness ;
                }   break;
            case "Geeks":
                for( int i = 0 ; i < ng ; i++ ){
                    if( this.gf_name == null ? g.get(i).name == null : this.gf_name.equals(g.get(i).name) )
                        this.happiness = g.get(i).intelligence ;
                }   break;
        }
    }
    public void Set_GirlFriend( String gf ){
        this.committed = true ;
        this.gf_name = gf ;
    }
    
}

/**
 *
 * @author aish
 */
class committed_boy_class extends boys_class{
    public String name ;
    public String type  ;
} 
