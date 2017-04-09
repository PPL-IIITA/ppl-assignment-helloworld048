package Couple;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Boys_Package.boys_class ;
import Gift_Package.gift_class ;
import Girls_Package.girls_class;
import java.util.ArrayList;

/**
 *
 * @author aish
 */
public class couple_class {
    public String girl_name , boy_name ;
    public int happiness , compatibility ;

    public couple_class() {
    }
    
    public void set_Happiness( ArrayList<boys_class>b , int nb , ArrayList<girls_class>g , int ng){
        int boy = 0, girl = 0 ;
        for( int i = 0 ; i < ng ; i++ ){
            if( this.girl_name.equals(g.get(i).name) ) 
                girl = i ;
        }
        for( int i = 0 ; i < nb ; i++ ){
            if( this.boy_name.equals(b.get(i).name) )
                boy = i ;
        }
        this.happiness = b.get(boy).happiness + g.get(girl).happiness ;
    }
    
    public void set_compatibility( boys_class boy , girls_class girl ){
        this.compatibility = boy.boys_gf_budget - girl.maintenance_budget ;
        this.compatibility += Math.abs( boy.attractiveness - girl.attractiveness) ;
        this.compatibility += Math.abs( boy.intelligence - girl.intelligence ) ;
    }

    public void add_Couple( boys_class b, girls_class g ){

        this.boy_name = b.name ;
        b.Set_Committed() ;
        b.Set_GirlFriend(g.name);
        this.girl_name = g.name ;
        g.Set_Committed() ;
        g.Setting_BoyFriend(b.name);
        this.set_compatibility(b,g);
    }
    
    boolean cmp( gift_class a , gift_class b){
        return a.price > b.price;
    }
    
    public void Set_Gifts( ArrayList<boys_class>b, int nb, ArrayList<girls_class>g , int ng,ArrayList<gift_class>vg ){
        int boy = 0, girl = 0 ;
        for( int i = 0 ; i < nb ; i++ )
            if(this.boy_name.equals(b.get(i).name) )
                boy = i ;
        for( int i = 0 ; i < ng ; i++ )
            if( this.girl_name.equals(g.get(i).name) )
                girl = i ;
        int basket_price = 0 , basket_value = 0 ;
        if( "Generous".equals(b.get(boy).committed_type) ){
            for( int i = vg.size()-1 ; i >= 0 ; i--){
                if( basket_price + vg.get(i).price <= b.get(boy).boys_gf_budget ){
                    basket_price += vg.get(i).price ;
                    if( ("Choosy".equals(g.get(girl).committedtype)) && "Luxury".equals(vg.get(i).type))
                        basket_value += 2*vg.get(i).value ;
                    else
                        basket_value += vg.get(i).value ;
                }
            }
        }
        else
            for( int i = 0 ; i < vg.size() ; i++ ){
                if( basket_price + vg.get(i).price <= b.get(boy).boys_gf_budget){
                    basket_price += vg.get(i).price ;
                    if( g.get(girl).committedtype == "Choosy" && vg.get(i).type == "Luxury" ){
                        basket_value += 2*vg.get(i).value ;
                    }
                    else
                        basket_value += vg.get(i).value ;
                }
            }
        b.get(boy).total_gift_price = basket_price ;
        b.get(boy).total_gift_value = basket_value ;
        g.get(girl).total_gift_price = basket_price ;
        g.get(girl).total_gift_value = basket_value ;
        g.get(girl).Setting_Happiness();
        b.get(boy).Set_Happiness(g, ng);
        this.set_Happiness(b, nb, g, ng);
        
        
    }
    
    
}
