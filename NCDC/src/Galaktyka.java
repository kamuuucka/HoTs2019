public class Galaktyka {
    public static void main(String[] args){

        char direction = 0;
        int telescope = 0;
        String[][] tab;
        int vertical;
        int horizontal;
        int x = 0;
        int y = 0;

        try{
            telescope = Character.getNumericValue(args[0].charAt(0));
            direction = args[0].charAt(1);
        }catch(Exception ex){System.out.print("klops"); System.exit(1);}



        if ('N' == direction || 'S' == direction)
        {
            vertical = telescope + 3;
            horizontal = telescope + 2;
            tab = new String[horizontal][vertical];
        }
        else if ('E' == direction || 'W' == direction)
        {
            vertical = telescope + 2;
            horizontal = telescope + 3;
            tab = new String[horizontal][vertical];

            for (int i = 0; i < tab.length; i++)
            {
                for (int j = 0; j < tab[i].length; j++)
                {
                    tab[i][j] = "o";
                }
            }

            tab[x][y] = "*";

            for (int i = 0; i < vertical; i++) {
                tab[x][y] = "*";
                y++;
            }
            Spirala.drawing(horizontal, tab, x, y);

            for (int i = 0; i < tab.length; i++)
            {
                for (int j = 0; j < tab[i].length; j++)
                {
                    System.out.print(tab[i][j]);
                }
                System.out.println();
            }
        }
        else {System.out.print("klops"); System.exit(1);}

    }
}
