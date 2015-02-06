package instactile.models;

import java.awt.Point;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class BattleGroundTest {
    
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Tests de la class BattleGround");
    }
    
    @AfterClass
    public static void afterAll() {
        System.out.println("");
    }

    @Test
    public void testSetNumberPlayers() {
        System.out.println("  #setNumberPlayers");
        System.out.println("    - MUST set the right number of players in a game.");
        
        BattleGround instance = new BattleGround(2);
        instance.setNumberPlayers(4);
        assertEquals(instance.getNumberPlayers(), 4);
    }
    
    @Test
    public void testSetNumberPlayersInList() {
        System.out.println("    - MUST reset the list of players with the right size if the number of players changes.");
        
        BattleGround instance = new BattleGround(2);
        instance.setNumberPlayers(4);
        assertEquals(instance.getZones().size(), 4);
        instance.setNumberPlayers(2);
        assertEquals(instance.getZones().size(), 2);
    }

    @Test
    public void testGetNumberPlayers() {
        System.out.println("  #getNumberPlayers");
        System.out.println("    - MUST return the right number of player in a game.");
        BattleGround instance = new BattleGround(2);
        assertEquals(instance.getNumberPlayers(), 2);
    }
    
    @Test
    public void testZonesForTwoPlayers() {
        System.out.println("  #getZones");
        System.out.println("    - MUST correctly get the zones for two players");
        
        BattleGround instance = new BattleGround(2);
        List<BattleZone> zones = instance.getZones();
        
        assertEquals(zones.get(0).getPosition(), new Point(0, 0));
        assertEquals(zones.get(1).getPosition(), new Point(1, 0));
    }
    
    @Test
    public void testZonesForFourPlayers() {
        System.out.println("    - MUST correctly get the zones for four players");
        
        BattleGround instance = new BattleGround(4);
        List<BattleZone> zones = instance.getZones();
        
        assertEquals(zones.get(0).getPosition(), new Point(0, 0));
        assertEquals(zones.get(1).getPosition(), new Point(0, 1));
        assertEquals(zones.get(2).getPosition(), new Point(1, 0));
        assertEquals(zones.get(3).getPosition(), new Point(1, 1));
    }
    
    @Test
    public void testZonesForSixPlayers() {
        System.out.println("    - MUST correctly get the zones for six players");
        
        BattleGround instance = new BattleGround(6);
        List<BattleZone> zones = instance.getZones();
        
        assertEquals(zones.get(0).getPosition(), new Point(0, 0));
        assertEquals(zones.get(1).getPosition(), new Point(0, 1));
        assertEquals(zones.get(2).getPosition(), new Point(1, 0));
        assertEquals(zones.get(3).getPosition(), new Point(1, 1));
        assertEquals(zones.get(4).getPosition(), new Point(2, 0));
        assertEquals(zones.get(5).getPosition(), new Point(2, 1));
    }
    
    @Test
    public void testZonesForMorePlayers() {
        System.out.println("    - MUST correctly get the zones for any other number of players");
        
        BattleGround instance = new BattleGround(8);
        List<BattleZone> zones = instance.getZones();
        
        assertEquals(zones.get(0).getPosition(), new Point(0, 0));
        assertEquals(zones.get(1).getPosition(), new Point(0, 1));
        assertEquals(zones.get(2).getPosition(), new Point(1, 0));
        assertEquals(zones.get(3).getPosition(), new Point(1, 1));
        assertEquals(zones.get(4).getPosition(), new Point(2, 0));
        assertEquals(zones.get(5).getPosition(), new Point(2, 1));
    }
    
}
