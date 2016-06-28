/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migraçãotempo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acpm
 */
public class MigraçãoTempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String s = " YES      leading spaces     9999   are valid't,    problemsetters are         evillllll";
        System.out.println(s.split("[^A-Za-z]+\\s").length);
        for (String string : s.split("[^A-Za-z]+")) {
            System.out.println(string);
        }
    }

}
