package Girls_Package;

import static java.lang.Math.log;


public class girls_class {
    
    boolean committed ;
    public String name , type , boyfriend , committedtype ;
    public int maintenance_budget , intelligence ,happiness,attractiveness ;
    public int total_gift_price , total_gift_value ;
    public String criteria_boys;
    
    public girls_class(){
        this.committed = false ;
    }
    
    public void Set_Committed(){
        this.committed = true ;
    }
    public void initialize( String name , int attract , int main_budget , int intell , String cb , String type  ){
        this.name = name ;
        this.attractiveness = attract ;
        this.maintenance_budget = main_budget ;
        this.criteria_boys = cb ;
        this.intelligence = intell ;
        this.committedtype = type ;
    }
    public void Setting_Happiness(){
        if( this.committed == false )
            return ;
        switch (this.committedtype) {
            case "Choosy":
                int x = ( total_gift_price + total_gift_value) ;
                int t = 0 ;
                while(x != 0){
                    t++ ;
                    x = x/10 ;
                }
                this.happiness = t ;
                break;
            case "Normal":
                this.happiness = (total_gift_price)+(total_gift_value) ;
                break;
            case "Desperate":
                this.happiness = (total_gift_price)*(total_gift_price)*(total_gift_price) ;
                break;
        }
    }
    
    public void Setting_BoyFriend( String boyfriend ){
        if( this.committed == false )
            return ;
        this.boyfriend = boyfriend ;
    }

    public void Unset_Committed() {
        this.committed = false ;
    }
}
class committed_girl extends girls_class{
    public String name , committed_type ;
}
