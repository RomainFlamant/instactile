/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile.factories;

import instactile.models.BattleGround;
import instactile.models.BattleZone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Babausse
 */
public class BattleZonesFactory {
    
    public static List<BattleZone> createBattleZone(BattleGround battleGround) {
        List<BattleZone> zones;
        int numberPlayers = battleGround.getNumberPlayers();
        switch(numberPlayers) {
            case 2: zones = createZones(battleGround, 2, 1); break;
            case 4: zones = createZones(battleGround, 2, 2); break;
            case 6:
            default: zones = createZones(battleGround, 3, 2); break;
        }
        return zones;
    }
    
    public static List<BattleZone> createZones(BattleGround battleGround, int horizontalNumber, int verticalNumber) {
        List<BattleZone> zones = new ArrayList<BattleZone>();
        for(int i = 0; i < horizontalNumber; i++) {
            for(int j = 0; j < verticalNumber; j++) {
                zones.add(new BattleZone(battleGround, i, j));
            }
        }
        return zones;
    }
}
