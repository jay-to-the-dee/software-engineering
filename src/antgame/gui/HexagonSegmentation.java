package antgame.gui;

import java.awt.geom.GeneralPath;

/**
 * Does all the maths to necessary correctly segment up a hexagon into 6 or less
 *
 * @author Jonathan Dilks
 */
public class HexagonSegmentation
{

    /**
     * Split's half of a hexagon up into 6 so that it can be used to represent
     * multiple chemical markers
     * @param hexagonSize  the width in pixels that the hexagon to be split 
     * should be
     * @param markerCount up to the amount  6 - the amount to split the hexagon 
     * up into
     * @return all the segments from the split that can be coloured in by 
     * g2d.fill
     */
    public static GeneralPath[] getSegments(int hexagonSize, int markerCount)
    {
        GeneralPath[] segments;
        segments = new GeneralPath[markerCount];

        final float singleSideSize = (float) (hexagonSize / 2 / Math.cos(Math.toRadians(30)));

        float hypotenuse, x, y;

        switch (markerCount)
        {
            case 1:
                segments[0] = new GeneralPath();
                segments[0].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[0].lineTo(0.5 * hexagonSize, 0);
                segments[0].lineTo(0.5 * hexagonSize, singleSideSize * 2);
                segments[0].lineTo(0, singleSideSize * 2 - (hexagonSize * (Math.sqrt(3) / 6)));
                segments[0].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                break;

            case 2:
                segments[0] = new GeneralPath();
                segments[0].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[0].lineTo(0.5 * hexagonSize, 0);
                segments[0].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[0].lineTo(0, singleSideSize);
                segments[0].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);

                segments[1] = new GeneralPath();
                segments[1].moveTo(0, singleSideSize);
                segments[1].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[1].lineTo(0.5 * hexagonSize, singleSideSize * 2);
                segments[1].lineTo(0, singleSideSize * 2 - (hexagonSize * (Math.sqrt(3) / 6)));
                segments[1].lineTo(0, singleSideSize);
                break;

            case 3:
                segments[0] = new GeneralPath();
                segments[0].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[0].lineTo(0.5 * hexagonSize, 0);
                segments[0].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[0].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);

                segments[1] = new GeneralPath();
                segments[1].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[1].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[1].lineTo(0, singleSideSize * 2 - (hexagonSize * (Math.sqrt(3) / 6)));
                segments[1].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);

                segments[2] = new GeneralPath();
                segments[2].moveTo(0, singleSideSize * 2 - (hexagonSize * (Math.sqrt(3) / 6)));
                segments[2].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[2].lineTo(0.5 * hexagonSize, singleSideSize * 2);
                segments[2].lineTo(0, singleSideSize * 2 - (hexagonSize * (Math.sqrt(3) / 6)));
                break;

            case 4:
                hypotenuse = (float) (Math.sin(Math.toRadians(15)) * (singleSideSize / Math.sin(Math.toRadians(105))));

                x = (float) (Math.sin(Math.toRadians(60))) * hypotenuse;
                y = (float) (((Math.sqrt(3) / 6) * hexagonSize) - ((Math.sin(Math.toRadians(30)))) * hypotenuse);

                segments[0] = new GeneralPath();
                segments[0].moveTo(x, y);
                segments[0].lineTo(0.5 * hexagonSize, 0);
                segments[0].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[0].lineTo(x, y);

                segments[1] = new GeneralPath();
                segments[1].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[1].lineTo(x, y);
                segments[1].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[1].lineTo(0, singleSideSize);
                segments[1].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);

                y = (float) ((float) (singleSideSize * 2 - ((Math.sqrt(3) / 6) * hexagonSize)) + (Math.sin(Math.toRadians(30)) * hypotenuse));

                segments[2] = new GeneralPath();
                segments[2].moveTo(0, singleSideSize * 2 - (Math.sqrt(3) / 6) * hexagonSize);
                segments[2].lineTo(x, y);
                segments[2].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[2].lineTo(0, singleSideSize);
                segments[2].lineTo(0, hexagonSize - (Math.sqrt(3) / 6) * hexagonSize);

                segments[3] = new GeneralPath();
                segments[3].moveTo(x, y);
                segments[3].lineTo(0.5 * hexagonSize, singleSideSize * 2);
                segments[3].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[3].lineTo(x, y);
                break;

            case 5:
                hypotenuse = (float) ((float) (Math.sin(Math.toRadians(36)) * singleSideSize) / Math.sin(Math.toRadians(84)));
                float hypotenuse2 = (float) ((hexagonSize / 2) / Math.sin(Math.toRadians(72)));

                x = (float) ((hexagonSize / 2) - (Math.sin(Math.toRadians(60))) * hypotenuse);
                y = (float) ((Math.sin(Math.toRadians(30))) * hypotenuse);

                segments[0] = new GeneralPath();
                segments[0].moveTo(x, y);
                segments[0].lineTo(hexagonSize / 2, 0);
                segments[0].lineTo(hexagonSize / 2, singleSideSize);
                segments[0].lineTo(x, y);

                segments[1] = new GeneralPath();
                segments[1].moveTo(hexagonSize / 2, singleSideSize);
                segments[1].lineTo(x, y);
                segments[1].lineTo(0, ((Math.sqrt(3) / 6) * hexagonSize));
                y = (float) (singleSideSize - (hypotenuse2 * Math.sin(Math.toRadians(18))));
                segments[1].lineTo(0, y);
                segments[1].lineTo(hexagonSize / 2, singleSideSize);

                segments[2] = new GeneralPath();
                segments[2].moveTo(hexagonSize / 2, singleSideSize);
                segments[2].lineTo(0, y);
                y = (float) (singleSideSize + (hypotenuse2 * Math.sin(Math.toRadians(18))));
                segments[2].lineTo(0, y);
                segments[2].lineTo(hexagonSize / 2, singleSideSize);

                segments[3] = new GeneralPath();
                segments[3].moveTo(hexagonSize / 2, singleSideSize);
                segments[3].lineTo(0, y);
                segments[3].lineTo(0, singleSideSize * 2 - ((Math.sqrt(3) / 6) * hexagonSize));
                y = (float) (singleSideSize * 2 - (Math.sin(Math.toRadians(30))) * hypotenuse);
                segments[3].lineTo(x, y);
                segments[3].lineTo(hexagonSize / 2, singleSideSize);

                segments[4] = new GeneralPath();
                segments[4].moveTo(x, y);
                segments[4].lineTo(hexagonSize / 2, singleSideSize);
                segments[4].lineTo(hexagonSize / 2, singleSideSize * 2);
                segments[4].lineTo(x, y);
                break;

            case 6:
                hypotenuse = (float) singleSideSize / 2;

                x = (float) (Math.sin(Math.toRadians(60))) * hypotenuse;
                y = (float) (((Math.sqrt(3) / 6) * hexagonSize) - ((Math.sin(Math.toRadians(30)))) * hypotenuse);

                segments[0] = new GeneralPath();
                segments[0].moveTo(x, y);
                segments[0].lineTo(0.5 * hexagonSize, 0);
                segments[0].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[0].lineTo(x, y);

                segments[1] = new GeneralPath();
                segments[1].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[1].lineTo(x, y);
                segments[1].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[1].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);

                segments[2] = new GeneralPath();
                segments[2].moveTo(0, (Math.sqrt(3) / 6) * hexagonSize);
                segments[2].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[2].lineTo(0, singleSideSize);
                segments[2].lineTo(0, (Math.sqrt(3) / 6) * hexagonSize);

                segments[3] = new GeneralPath();
                segments[3].moveTo(0, singleSideSize * 2 - (Math.sqrt(3) / 6) * hexagonSize);
                segments[3].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[3].lineTo(0, singleSideSize);
                segments[3].lineTo(0, singleSideSize * 2 - (Math.sqrt(3) / 6) * hexagonSize);

                y = (float) ((float) (singleSideSize * 2 - ((Math.sqrt(3) / 6) * hexagonSize)) + ((Math.sin(Math.toRadians(30))) * hypotenuse));
                segments[4] = new GeneralPath();
                segments[4].moveTo(x, y);
                segments[4].lineTo(0, singleSideSize * 2 - (Math.sqrt(3) / 6) * hexagonSize);
                segments[4].lineTo(0.5 * hexagonSize, singleSideSize);
                segments[4].lineTo(x, y);

                segments[5] = new GeneralPath();
                segments[5].moveTo(x, y);
                segments[5].lineTo(hexagonSize * 0.5, singleSideSize);
                segments[5].lineTo(0.5 * hexagonSize, singleSideSize * 2);
                segments[5].lineTo(x, y);
                break;

            default:
                throw new RuntimeException("Cannot segment by " + markerCount + ". Only value's of 6 or less are supported.");
        }

        return segments;
    }

}
