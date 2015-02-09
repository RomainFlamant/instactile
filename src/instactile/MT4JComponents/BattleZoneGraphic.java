package instactile.MT4JComponents;

import instactile.models.BattleGround;
import instactile.models.BattleZone;
import instactile.singletons.Configuration;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * @author Benjamin MILHAU
 * b.milhau@insta.fr
 */
public class BattleZoneGraphic extends MTRectangle {
    
    private BattleZone battleZone;
    private BattleGround battleGround;
    private PApplet pApplet;

    public BattleZoneGraphic(float x, float y, float width, float height, BattleZone battleZone,BattleGround battleGround, PApplet pApplet) {
        super(x, y, width, height, pApplet);
        this.battleGround = battleGround;
        this.battleZone = battleZone;
        this.pApplet = pApplet;
        this.unregisterAllInputProcessors();
        
        fillBackground();
        
    }
    
    private void fillBackground(){
        PImage backgroung = this.pApplet.loadImage((String)Configuration.getKey("textures."+this.getName()));
        this.setTexture(backgroung);
    }
    
    public String getName(){
        return this.battleZone.getName();
    }

}
