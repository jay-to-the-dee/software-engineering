package antgame.gui;

import java.awt.Color;

/**
 *
 * @author jay-to-the-dee <jay-to-the-dee@users.noreply.github.com>
 */
public class ColourScheme
{
    static final Color plainCellColor = Color.WHITE;

    //TODO: make redder - currently just lighter
    static final Color[] blackAntChemicalColors =
    {
        new Color(86, 94, 205),
        new Color(176, 86, 205),
        new Color(205, 86, 111),
        new Color(205, 183, 86),
        new Color(106, 205, 86),
        new Color(86, 205, 197)
    };

    static final Color[] redAntChemicalColors =
    {
        new Color(131, 136, 206),
        new Color(188, 131, 206),
        new Color(206, 131, 147),
        new Color(206, 192, 131),
        new Color(144, 206, 131),
        new Color(131, 206, 201)
    };

    static final Color blackAnthillColor = new Color(15, 15, 15);
    static final Color redAnthillColor = Color.RED;
}
