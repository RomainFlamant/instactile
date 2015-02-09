package instactile.factories;

import instactile.models.BattleGround;
import instactile.models.BattleZone;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class BattleZonesFactoryTest {
    
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Tests de la class BattleZonesFactory");
    }
    
    @AfterClass
    public static void afterAll() {
        System.out.println("");
    }
    
    private BattleGround battleGround = new BattleGround(4);
    
    @Test
    public void testCreateBattleZoneForTwoPlayers() {
        System.out.println("  #createBattleZone");
        System.out.println("    - MUST correctly initialize the number of zones for two players.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(2));
        assertEquals(zones.size(), 2);
    }
    
    @Test
    public void testCreateBattleZoneForFourPlayers() {
        System.out.println("    - MUST correctly initialize the number of zones for four players.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(battleGround);
        assertEquals(zones.size(), 4);
    }
    
    @Test
    public void testCreateBattleZoneForSixPlayers() {
        System.out.println("    - MUST correctly initialize the number of zones for six players.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.size(), 6);
    }
    
    @Test
    public void testCreateBattleZoneForMorePlayers() {
        System.out.println("    - MUST correctly initialize the number of zones for any otther number of players.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(8));
        assertEquals(zones.size(), 6);
    }

    @Test
    public void testCreateZones() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly initialize a list given horizontal and vertical numbers of zones.");
        
        List<BattleZone> zones = BattleZonesFactory.createZones(battleGround, 1, 2);
        assertEquals(zones.size(), 2);
    }
    
    @Test
    public void testNameZone0() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly name zone0.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.get(0).getName(), "zone0");
    }
    @Test
    public void testNameZone1() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly name zone1.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.get(1).getName(), "zone1");
    }
    @Test
    public void testNameZone2() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly name zone2.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.get(2).getName(), "zone2");
    }
    @Test
    public void testNameZone3() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly name zone3.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.get(3).getName(), "zone3");
    }
    @Test
    public void testNameZone4() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly name zone4.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.get(4).getName(), "zone4");
    }
    @Test
    public void testNameZone5() {
        System.out.println("  #createZones");
        System.out.println("    - MUST correctly name zone5.");
        
        List<BattleZone> zones = BattleZonesFactory.createBattleZone(new BattleGround(6));
        assertEquals(zones.get(5).getName(), "zone5");
    }
}
