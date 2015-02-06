/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile;

import instactile.MT4JComponents.BattleGroundScene;
import org.mt4j.MTApplication;

/**
 *
 * @author Babausse
 */
public class Instactile extends MTApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initialize();
    }

    @Override
    public void startUp() {
        addScene(new BattleGroundScene(this, P2D, 6));
    }
    
}
