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
        
        assertEquals(Configuration.getKey("zonesDimensions.2"), "960x1080");
    }
    
    @Test
    public void testDimensionsForFourPlayers() {
        System.out.println("    - MUST return the good dimensions for a zone in a 4 players game.");
        
        assertEquals(Configuration.getKey("zonesDimensions.4"), "960x540");
    }
    
    @Test
    public void testGetThePathToTexture1() {
        System.out.println("    - MUST return the good path for the texture 1.");
        
        assertEquals(Configuration.getKey("textures.zone0"), "data/image/Texture1.png");
    }    
    
    @Test
    public void testGetThePathToTexture2() {
        System.out.println("    - MUST return the good path for the texture 2.");
        
        assertEquals(Configuration.getKey("textures.zone1"), "data/image/Texture2.png");
    }    
    
    @Test
    public void testGetThePathToTexture3() {
        System.out.println("    - MUST return the good path for the texture 3.");
        
        assertEquals(Configuration.getKey("textures.zone2"), "data/image/Texture3.png");
    }    
    
    @Test
    public void testGetThePathToTexture4() {
        System.out.println("    - MUST return the good path for the texture 4.");
        
        assertEquals(Configuration.getKey("textures.zone3"), "data/image/Texture4.png");
    }    
    
    @Test
    public void testGetThePathToTexture5() {
        System.out.println("    - MUST return the good path for the texture 5.");
        
        assertEquals(Configuration.getKey("textures.zone4"), "data/image/Texture5.png");
    }    
    
    @Test
    public void testGetThePathToTexture6() {
        System.out.println("    - MUST return the good path for the texture 6.");
        
        assertEquals(Configuration.getKey("textures.zone5"), "data/image/Texture6.png");
    }    
    
}
