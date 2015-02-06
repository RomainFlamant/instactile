/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile.models;

import java.awt.Point;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Babausse
 */
public class BattleZoneTest {
    
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Tests de la class BattleZone");
    }
    
    @AfterClass
    public static void afterAll() {
        System.out.println("");
    }

    @Test
    public void testGetPosition() {
        System.out.println("  #getPosition");
        System.out.println("    - MUST return the correct position for a zone");
        
        BattleZone zone = new BattleZone(new BattleGround(6), 1, 1);
        assertEquals(zone.getPosition(), new Point(1, 1));
    }
    
}
