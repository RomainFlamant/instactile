package instactile.models;

import instactile.factories.BattleZonesFactory;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class of the application, representing the whole battleground containing the six subzones.
 * @author Vincent Courtois <vincent.courtois@mycar-innovations.com>
 */
public class BattleGround {
    
    /** Number of players currently playing on this batthefield. */
    private int numberPlayers = 0;
    
    private List<BattleZone> zones;
    
    /**
     * Default constructor of the class.
     * @param numberPlayers the number of players desired in the current game.
     */
    public BattleGround(int numberPlayers) {
        this.setNumberPlayers(numberPlayers);
    }
    
    /**
     * Setter for the number of players.
     * If the number of players changes, the zones are reinitialized.
     * @param numberPlayers the number of players in the current game.
     */
    public final void setNumberPlayers(int numberPlayers) {
        if(numberPlayers != this.numberPlayers) {
            this.numberPlayers = numberPlayers;
            this.zones = BattleZonesFactory.createBattleZone(this);
        }
    }
    /**
     * Getter for the number of players.
     * @return the current number of players in the game.
     */
    public final int getNumberPlayers() {
        return this.numberPlayers;
    }
    
    /**
     * Getter of the list of zones in the battleground.
     * @return the list of zones in the battleground.
     */
    public List<BattleZone> getZones() {
        return zones;
    }
}
