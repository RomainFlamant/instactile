package instactile.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A battle zone is the zone owned by a player in which creatures spawn and can be exploded.
 * @author Vincent Courtois <vincent.courtois@mycar-innovations.com>
 */
public class BattleZone {
    
    private final String name;
    private final int horizontalPosition;
    private final int verticalPosition;
    private final BattleGround battleGround;
    private final List<Entity> creatures;
    
    /**
     * Default constructor of a battle zone. All given positions begins at zero.
     * @param battleGround the battleground in which the zones are drawn.
     * @param name the name of the zone
     * @param horizontalPosition the horizontal position of the zone in the whole battleground.
     * @param verticalPosition the vertical position of the zone in the whole battleground.
     */
    public BattleZone(BattleGround battleGround, String name, int horizontalPosition, int verticalPosition) {
        this.name = name;
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
        this.battleGround = battleGround;
        this.creatures = new ArrayList<Entity>();
    }
    
    /**
     * Returns an AWT point representing the current position of the zone in the battleground.
     * @return a point representing the position of the zone in the whole battle ground.
     */
    public Point getPosition() {
        return new Point(horizontalPosition, verticalPosition);
    }
    
    public BattleGround getBattleGround() {
        return this.battleGround;
    }

    public String getName() {
        return name;
    }
    
    public void removeCreature(Entity creature) {
        creatures.remove(creature);
    }
    
    public void addCreature(Entity creature) {
        creatures.add(creature);
    }
    
    public List<Entity> getCreatures() {
        return creatures;
    }
}
