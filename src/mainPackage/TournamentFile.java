package mainPackage;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jay-to-the-dee <jay-to-the-dee@users.noreply.github.com>
 */
public class TournamentFile
{
    private final File brainFile;
    
    private int wins;
    private int draws;
    private int loses;
    
    ArrayList<TournamentFile> brainsBattled;

    public void addBrainBattled(TournamentFile brainBattled)
    {
        brainsBattled.add(brainBattled);
    }

    public ArrayList<TournamentFile> getBrainsBattled()
    {
        return brainsBattled;
    }

    public TournamentFile(File brainFile)
    {
        this.brainFile = brainFile;
        brainsBattled = new ArrayList<>();
    }

    public File getBrainFile()
    {
        return brainFile;
    }

    @Override
    public String toString()
    {
        return brainFile.getName();
    }
    
    public int getWins()
    {
        return wins;
    }

    public int getDraws()
    {
        return draws;
    }

    public int getLoses()
    {
        return loses;
    }

    public void increaseWins()
    {
        wins++;
    }

    public void increaseDraws()
    {
        draws++;
    }

    public void increaseLoses()
    {
        loses++;
    }
       
}
