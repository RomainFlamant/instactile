package instactile.singletons;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ConfigurationTest {
    
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Tests de la class Configuration");
    }
    
    @AfterClass
    public static void afterAll() {
        System.out.println("");
    }
    
    @Test
    public void testDimensionsForTwoPlayers() {
        System.out.println("  #getKey");
        System.out.println("    - MUST return the good dimensions for a zone in a 2 players game.");
        
        assertEquals(Configuration.getKey("zonesDimensions.2"), "860x1080");
    }
    
    @Test
    public void testDimensionsForFourPlayers() {
        System.out.println("    - MUST return the good dimensions for a zone in a 4 players game.");
        
        assertEquals(Configuration.getKey("zonesDimensions.4"), "860x540");
    }
    
    @Test
    public void testDimensionsForSixPlayers() {
        System.out.println("    - MUST return the good dimensions for a zone in a 6 players game.");
        
        assertEquals(Configuration.getKey("zonesDimensions.6"), "640x540");
    }
    
}
