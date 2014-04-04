
import antgame.model.Ant;
import antgame.instructions.InstructionSet;
import antgame.model.World;
import antgame.parsers.worldparser.SomeException;
import antgame.parsers.worldparser.SymbolNotFoundException;
import antgame.parsers.worldparser.TokenSizeMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Main User
 */
public class EverythingFactory {
    AntFactory ants;
    WorldFactory world;

    /**
     *
     */
    public EverythingFactory(){
    };
        //List<Ant> a= ants.generateAnts(100, 2);
        public void makeEverything(){
        try {
            World w = world.loadWorld(null, null, null);
        } catch (SomeException ex) {
            Logger.getLogger(EverythingFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SymbolNotFoundException ex) {
            Logger.getLogger(EverythingFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TokenSizeMismatchException ex) {
            Logger.getLogger(EverythingFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

        //Color color, InstructionSet[] antBrain,int position,World world
    

