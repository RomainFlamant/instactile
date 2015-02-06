package instactile.MT4JComponents;

import instactile.models.BattleGround;
import org.mt4j.AbstractMTApplication;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

/**
 * @author Benjamin MILHAU b.milhau@insta.fr
 */
public class BattleGroundScene extends AbstractScene {

    public BattleGroundScene(AbstractMTApplication mtApplication, String name, Integer nbJoueur) {
        super(mtApplication, name);

        this.setClearColor(MTColor.GREY);

        BattleGround battleGround = new BattleGround(nbJoueur);

        int width = this.getCanvas().getRenderer().getWidth() / (nbJoueur / 2);
        int height = this.getCanvas().getRenderer().getHeight() / 2;

        for (int i = 0; i < nbJoueur; i++) {
            this.getCanvas().addChild(new BattleZoneGraphic(i * width, 0, width, height, battleGround, mtApplication));
            this.getCanvas().addChild(new BattleZoneGraphic(i * width, height, width, height, battleGround, mtApplication));
        }

    }

}
