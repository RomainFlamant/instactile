/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile.models;

import static org.hamcrest.CoreMatchers.not;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

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
    public void testAddCreature() {
        System.out.println("  #addCreature");
        System.out.println("    - MUST correctly add a creature to the creatures in that zone.");
        
        BattleZone zone = new BattleZone(new BattleGround(2), 0, 0);
        Entity creature = new Entity(zone);
        
        zone.addCreature(creature);
        
        assertEquals(zone.getCreatures().size(), 1);
        assertEquals(zone.getCreatures().get(0), creature);
    }
    
    @Test
    public void testRemoveCreature() {
        System.out.println("  #removeCreature");
        System.out.println("    - MUST correctly remove a creature from the creatures in that zone.");
        
        BattleZone zone = new BattleZone(new BattleGround(2), 0, 0);
        Entity creature = new Entity(zone);
        
        zone.addCreature(new Entity(zone));
        zone.addCreature(creature);
        zone.removeCreature(creature);
        
        assertEquals(zone.getCreatures().size(), 1);
        assertThat(zone.getCreatures().get(0), not(creature));
    }
    
    @Test
    public void testRemoveCreatureWhenNoCreatures() {
        System.out.println("    - MUST NOT remove any creature or fail if the creatures list is empty.");
        
        BattleZone zone = new BattleZone(new BattleGround(2), 0, 0);
        Entity creature = new Entity(zone);
        
        zone.removeCreature(creature);
        
        assertEquals(zone.getCreatures().size(), 0);
    }
    
    @Test
    public void testRemoveCreatureIfCreatureNotInList() {
        System.out.println("    - MUST NOT remove any creature or fail if the creature is not in the list.");
        
        BattleZone zone = new BattleZone(new BattleGround(2), 0, 0);
        Entity creature = new Entity(zone);
        
        zone.addCreature(new Entity(zone));
        zone.removeCreature(creature);
        
        assertEquals(zone.getCreatures().size(), 1);
        assertThat(zone.getCreatures().get(0), not(creature));
    }
    
}
