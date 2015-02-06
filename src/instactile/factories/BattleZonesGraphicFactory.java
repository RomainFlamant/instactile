package instactile.factories;

import instactile.MT4JComponents.BattleZoneGraphic;
import instactile.models.BattleGround;
import instactile.models.BattleZone;
import instactile.singletons.Configuration;
import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;

/**
 * @author Benjamin MILHAU b.milhau@insta.fr
 */
public class BattleZonesGraphicFactory {

    public static List<BattleZoneGraphic> createBattleZonesGraphic(BattleGround battleGround, PApplet pApplet) {

        List<BattleZoneGraphic> listBattleZoneGraphic = new ArrayList<BattleZoneGraphic>();
        
        List<BattleZone> listBattleZone = BattleZonesFactory.createBattleZone(battleGround);
        
        String dimension = (String) Configuration.getKey("zonesDimensions." + listBattleZone.size());
        String[] dimTab = dimension.split("x");
        Integer width = Integer.parseInt(dimTab[0]);
        Integer height = Integer.parseInt(dimTab[1]);
        Integer size = listBattleZone.size();
        Integer i = 0;

        for (BattleZone battleZone : listBattleZone) {
            if (size == 2 || (size == 4 && i < 2) || (size == 6 && i < 3)) {
                listBattleZoneGraphic.add(new BattleZoneGraphic(i*width, 0, width, height, battleZone, battleGround, pApplet));
            }else if ((size == 4 && i >= 2)){
                listBattleZoneGraphic.add(new BattleZoneGraphic((i-2)*width, height, width, height, battleZone, battleGround, pApplet));
            }else if ((size == 6 && i >= 3)){
                listBattleZoneGraphic.add(new BattleZoneGraphic((i-3)*width, height, width, height, battleZone, battleGround, pApplet));
            }
            i++;
        }
        return listBattleZoneGraphic;
    }

}
