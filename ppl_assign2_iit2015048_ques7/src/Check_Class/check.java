/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Check_Class;

import Boys_Package.boys_class;
import Couple.couple_class;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author aish
 */
public abstract class check {
    public ArrayList<boys_class> vob = new ArrayList<>() ;
    public ArrayList<couple_class> voc = new ArrayList<>() ;
    public abstract void check(ArrayList<String>vb);
}
