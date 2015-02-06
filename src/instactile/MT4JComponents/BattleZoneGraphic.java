package instactile.MT4JComponents;

import instactile.models.BattleGround;
import instactile.models.BattleZone;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import processing.core.PApplet;

/**
 * @author Benjamin MILHAU
 * b.milhau@insta.fr
 */
public class BattleZoneGraphic extends MTRectangle {
    
    private BattleZone battleZone;
    private BattleGround battleGround;

    public BattleZoneGraphic(float x, float y, float width, float height, BattleZone battleZone,BattleGround battleGround, PApplet pApplet) {
        super(x, y, width, height, pApplet);
        this.battleGround = battleGround;
        this.battleZone = battleZone;
        this.unregisterAllInputProcessors();
        
    }

}
