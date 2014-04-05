package antgame.world.textworldgenerator;

/**
 *
 * @author n
 */
import antgame.model.Position;
import antgame.world.worldTokens.World;
import antgame.world.worldTokens.BlackAnthillToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.RedAnthillToken;
import antgame.world.worldTokens.RockToken;
import antgame.model.Food;
import antgame.world.worldTokens.WorldToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GenRandomMap
{
    private static final int ANTHILL_SIZE = 7;
    private static final int FOOD_CLUMPS = 5;
    private static final int FOOD_STACK = 5;
    private static final int FOOD_NUMBER = 11;
    private static final int ROCK_NUMBER = 14;
    
    private final int mapSize;
    private int min;
    private int max;
    private int redAnthillCenterX;
    private int redAnthillCenterY;
    private int blackAnthillCenterX;
    private int blackAnthillCenterY;
    private List<Integer> foodX;
    private List<Integer> foodY;
    private String[][] world;
    private String masterString;

    public GenRandomMap(int mapSize)
    {
        this.mapSize = mapSize;

        min = ANTHILL_SIZE + 1;
        max = mapSize / 2 - min;
        world = new String[mapSize][mapSize];
        Random r = new Random();
        redAnthillCenterX = r.nextInt(max - min + 1) + min;
        redAnthillCenterY = r.nextInt(max * 2 - min + 1) + min;

        blackAnthillCenterX = r.nextInt(max - min + 1) + min + mapSize / 2;
        blackAnthillCenterY = r.nextInt(max * 2 - min + 1) + min;


        for (int i = 0; i < mapSize; i++)
        {//Fills entire array with empty nodes.
            for (int j = 0; j < mapSize; j++)
            {
                world[j][i] = ". ";
            }
        }

        world = rockBorder(world); // Adds rock border.
        world = genAnthill(redAnthillCenterX, redAnthillCenterY, world, "+");// Adds red anthill.
        world = genAnthill(blackAnthillCenterX, blackAnthillCenterY, world, "-");// Adds black anthill.

        for (int k = 0; k < FOOD_NUMBER; k++)
        {//Finds valid locations for food blocks then places them individually.
            int foodX = r.nextInt(max * 2 - 1) + 1;//Change added/minused numbers for buffer around border.
            int foodY = r.nextInt(max * 2 - 1) + 1;
            int test1 = 0;
            int test2 = 0;
            while (test1 < (FOOD_CLUMPS + 3) / 2)
            {//Valid location test. Increase to spread food out more.
                while (test2 < (FOOD_CLUMPS + 3) / 2)
                {
                    while (world[foodY - test1][foodX + test2] != ". " || world[foodY + test1][foodX + test2] != ". " || world[foodY - test1][foodX - test2] != ". " || world[foodY + test1][foodX - test2] != ". ")
                    {
                        foodX = r.nextInt(mapSize - FOOD_CLUMPS) + FOOD_CLUMPS;
                        foodY = r.nextInt(mapSize - FOOD_CLUMPS) + FOOD_CLUMPS;
                        test1 = 0;
                        test2 = 0;
                    }
                    //Prints x's to show the food's valid location range.
                    //world[foodY-test1][foodX+test2] = "x ";
                    //world[foodY+test1] [foodX+test2]= "x ";
                    //world[foodY-test1][foodX-test2] = "x ";
                    //world[foodY+test1][foodX-test2] = "x ";
                    test2++;
                }
                test2 = 0;
                test1++;
            }
            world = genFood(foodX, foodY, world);
        }

        int rocks = 0;
        while (rocks < ROCK_NUMBER)
        {//Creates random rocks in unused locations.
            int rockX = r.nextInt(max * 2 - 1) + 1;
            int rockY = r.nextInt(max * 2 - 1) + 1;
            if (world[rockX][rockY] == ". ")
            {
                world[rockX][rockY] = "# ";
                rocks++;
            }
        }

    }

    private String[][] rockBorder(String[][] world)
    {//Creates the rock border first rock in a row makes a new line.
        for (int i = 0; i < mapSize; i++)
        {
            world[0][i] = "# ";
            world[mapSize - 1][i] = "# ";
            world[mapSize - 1][0] = "\n# ";
            world[i][mapSize - 1] = "#";
            if (i % 2 == 0)
            {
                world[i][0] = "\n# ";
            }
            else
            {
                world[i][0] = "\n # ";
            }
        }
        return world;
    }

    private String[][] genAnthill(int x, int y, String[][] world, String sign)
    {
        if (y % 2 == 1)
        { //Creates anthill hexagon  at coordinates depending on y axis due to offset.
            for (int j = 0; j < ANTHILL_SIZE; j++)
            {
                for (int i = 0; i < (ANTHILL_SIZE * 2 - j); i++)
                {
                    world[y - j][x + ((i) / 2)] = sign + " ";
                    world[y + j][x + ((i) / 2)] = sign + " ";
                    world[y - j][x - ((i - 1) / 2)] = sign + " ";
                    world[y + j][x - ((i - 1) / 2)] = sign + " ";
                }
            }
        }
        else
        {
            for (int j = 0; j < ANTHILL_SIZE; j++)
            {
                for (int i = 0; i < (ANTHILL_SIZE * 2 - j); i++)
                {
                    world[y - j][x + ((i - 1) / 2)] = sign + " ";
                    world[y + j][x + ((i - 1) / 2)] = sign + " ";
                    world[y - j][x - ((i) / 2)] = sign + " ";
                    world[y + j][x - ((i) / 2)] = sign + " ";
                }
            }
        }
        return world;
    }

    private String[][] genFood(int x, int y, String[][] world)
    {
        if (y % 2 == 1)
        { //Creates food rectangle depending on y axis due to offset.
            for (int j = 0; j < (FOOD_CLUMPS + 1) / 2; j++)
            {
                for (int i = 0; i < (FOOD_CLUMPS + 1) / 2; i++)
                {
                    world[y - j][x + ((i))] = FOOD_STACK + " ";
                    world[y + j][x + ((i))] = FOOD_STACK + " ";
                    world[y - j][x - ((i))] = FOOD_STACK + " ";
                    world[y + j][x - ((i))] = FOOD_STACK + " ";
                }
            }
        }
        else
        {
            for (int j = 0; j < (FOOD_CLUMPS + 1) / 2; j++)
            {
                for (int i = 0; i < (FOOD_CLUMPS + 1) / 2; i++)
                {
                    world[y - j][x + ((i))] = FOOD_STACK + " ";
                    world[y + j][x + ((i))] = FOOD_STACK + " ";
                    world[y - j][x - ((i))] = FOOD_STACK + " ";
                    world[y + j][x - ((i))] = FOOD_STACK + " ";
                }
            }
        }
        return world;
    }

    private void printWorld(String[][] world)
    {// Prints map array for testing purposes.
        System.out.println(mapSize);
        System.out.println(mapSize);
        for (int j = 0; j < mapSize; j++)
        {
            for (int i = 0; i < mapSize; i++)
            {
                if (i == 0 && j % 2 == 1)
                {
                    System.out.print(" ");
                }
                System.out.print(world[i][j]);

            }

            System.out.println();
        }
    }

    public String createString()
    {//Creates the final map string.
        masterString = mapSize + "\n";
        masterString += mapSize;

        StringBuilder sb = new StringBuilder();
        for (String[] s1 : world)
        {
            for (String s2 : s1)
            {
                sb.append(s2);
            }
        }
        masterString += sb.toString();
        //System.out.println(masterString);
        return masterString;
    }
    
    public World createWorld(){
        List wlist = new ArrayList<>();
        int x=0;
        int y=0;
        for (String[] s1 : world)
        {
            for (String s2 : s1)
            {
                if (s2.contains(""+FOOD_STACK)){
                    Stack s = new Stack();
                    for (int i=0;i<FOOD_STACK;i++){
                        s.push(new Food());
                    }
                
                    wlist.add(new PlainToken(new Position(x,y),s));
                }
                if (s2.contains("#")){
                    wlist.add(new RockToken(new Position(x,y),null));
                }
                if (s2.contains(".")){
                    wlist.add(new PlainToken(new Position(x,y),new Stack()));
                }
                if (s2.contains("+")){
                    wlist.add(new RedAnthillToken(new Position(x,y)));
                }
                if (s2.contains("-")){
                    wlist.add(new BlackAnthillToken(new Position(x,y)));
                }
                x++;
            }
            x=0;
            y++;
        }
        y=0;
        World genWorld = new World(mapSize, mapSize, wlist);
        return genWorld;
    }
}