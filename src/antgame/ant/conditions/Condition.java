/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.conditions;

import antgame.model.TerrainToken;
import antgame.model.world.Color;

/**
 *
 * @author Main User
 */
public interface Condition {

    /**
     *
     * @param token
     * @param color
     * @return
     */
    public boolean checkCondition(TerrainToken token, Color color);
}