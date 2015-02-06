package instactile.MT4JComponents;

import instactile.factories.BattleZonesGraphicFactory;
import instactile.models.BattleGround;
import java.util.List;
import org.mt4j.AbstractMTApplication;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

/**
 * @author Benjamin MILHAU b.milhau@insta.fr
 */
public class BattleGroundScene extends AbstractScene {
    
    private final BattleGround battleGround;
    private List<BattleZoneGraphic> listBattleZoneGraphic;

    public BattleGroundScene(AbstractMTApplication mtApplication, String name, Integer nbJoueur) {
        super(mtApplication, name);

        this.setClearColor(MTColor.GREY);

        this.battleGround = new BattleGround(nbJoueur);
        
        this.listBattleZoneGraphic = BattleZonesGraphicFactory.createBattleZonesGraphic(battleGround, mtApplication);
        
        for (BattleZoneGraphic battleZoneGraphic : this.listBattleZoneGraphic){
            this.getCanvas().addChild(battleZoneGraphic);
        }

    }

}
