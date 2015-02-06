/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Babausse
 */
public class EntityTest {
    
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Tests de la class Entity");
    }
    
    @AfterClass
    public static void afterAll() {
        System.out.println("");
    }
    @Test
    public void testOnClick() {
        System.out.println("  #onClick");
        System.out.println("    - MUST remove the current creature from its former zone.");
        
        BattleZone zone = new BattleZone(new BattleGround(2), 0, 0);
        Entity creature = new Entity(zone);
        
        zone.addCreature(creature);
        zone.removeCreature(creature);
        
        assertEquals(zone.getCreatures().size(), 0);
    }
    
}
