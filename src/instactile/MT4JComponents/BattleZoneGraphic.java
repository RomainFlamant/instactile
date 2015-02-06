package instactile.MT4JComponents;

import instactile.factories.BattleZonesFactory;
import instactile.models.BattleGround;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import processing.core.PApplet;

/**
 * @author Benjamin MILHAU
 * b.milhau@insta.fr
 */
public class BattleZoneGraphic extends MTRectangle {

    public BattleZoneGraphic(float x, float y, float width, float height, BattleGround battleGround, PApplet pApplet) {
        super(x, y, width, height, pApplet);
        
        BattleZonesFactory.createBattleZone(battleGround);
    }

}
