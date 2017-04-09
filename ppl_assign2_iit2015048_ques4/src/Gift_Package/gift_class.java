
package Gift_Package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aish
 */

public class gift_class {
    public int price, value ;
    public String type ;
    public int luxury_rating , difficulty ;
    public int utility_class , utility_values ;
    
    public gift_class(){
        this.luxury_rating = 0 ;
        this.difficulty = 0 ;
        this.utility_class = 0 ;
        this.utility_values = 0 ;
    }
    public void add_gift( int pr, int val , String tt, int lr, int df, int uv,  int uc ){
        this.price = pr ;
        this.value = val ;
        this.type = tt ;
    }   
}
class essential_class extends gift_class{
    public void add_gift( int pr , int val , String tt, int lr , int df , int uv , int uc ){
        this.price = pr ;
        this.value = val ;
        this.type = "Essential" ;
    }
}
class luxuary_class extends gift_class{
    public int luxury_rating , difficulty ;
    public void add_gift( int pr , int val , String tt , int lr , int df, int uv, int uc ){
        this.price = pr ;
        this.value = val ;
        this.luxury_rating = lr ;
        this.difficulty = df ;
        this.type = "Luxury" ;
    }
}
class utility_class extends gift_class{
    public int utility_value , utility_class ;
    public void add_gift(int pr, int val ,String tt , int lr , int df, int uv, int uc ){
        this.price = pr ;
        this.value = val ;
        this.utility_class = uc ;
        this.utility_value = uv ;
        this.type = "Utility" ;
    }
}