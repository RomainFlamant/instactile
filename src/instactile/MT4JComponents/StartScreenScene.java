package instactile.MT4JComponents;

import antlr.collections.impl.Vector;
import instactile.factories.BattleZonesGraphicFactory;
import instactile.models.BattleGround;
import java.awt.Component;
import java.util.List;
import org.mt4j.AbstractMTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import processing.core.PImage;

/**
 * @author Benjamin MILHAU b.milhau@insta.fr
 */
public class StartScreenScene extends AbstractScene {
    

    public StartScreenScene(AbstractMTApplication mtApplication, String name) {
        super(mtApplication, name);
        this.setClearColor(MTColor.WHITE);
        PImage StartScreenImageWithMessage = mtApplication.loadImage("data/image/StartMessageOn.png");
        MTImage mtImage = new MTImage(mtApplication, StartScreenImageWithMessage);
        mtImage.unregisterAllInputProcessors();
        Vector3D v = new Vector3D(1600/2, 900/2);
        mtImage.setPositionGlobal(v);
        this.getCanvas().addChild(mtImage);
    }
    

}
