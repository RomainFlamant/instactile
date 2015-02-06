/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile.models;

/**
 * Standard entity superclassing all creatures and/or powers.
 * @author Vincent Courtois <vincent.courtois@mycar-innovations.com>
 */
public class Entity {
    
    private BattleZone zone;
    
    public Entity(BattleZone zone) {
        this.setZone(zone);
    }
    
    public final void setZone(BattleZone zone) {
        this.zone = zone;
    }
    
    public final BattleZone getZone() {
        return this.zone;
    }
    
    public void onClick() {
        getZone().removeCreature(this);
    }
}
