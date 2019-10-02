class Spirala {
    public static void main(String[] args) {
        int wpisana = 3;
        int vertical = 6;
        int horizontal = 7;
        String[][] tab = new String[horizontal][vertical];

        for (int i = 0; i < tab.length; i++)
        {
            for (int j = 0; j < tab[i].length; j++)
            {
                tab[i][j] = "o";
            }
        }

        int x = 0;
        int y = 0;
        tab[x][y] = "*";

        for (int i = 0; i < vertical; i++)
        { tab[x][y] = "*"; y++;}

        while(horizontal > 0 && vertical > 0 )
        {
            for (int i = 0; i < horizontal; i++)
            { tab[x][y - 1] = "*"; x++; }
            horizontal = horizontal - 2;
            for (int i = 0; i < vertical; i++)
            { tab[x - 1][y - 1] = "*"; y--; }
            vertical = vertical - 2;
            if(horizontal < 0 || vertical < 0 )
                break;

            for (int i = 0; i < horizontal; i++)
            { tab[x - 1][y] = "*"; x--; }
            horizontal = horizontal - 2;
            for (int i = 0; i < vertical; i++)
            { tab[x][y] = "*"; y++; }
            vertical = vertical - 2;
        }


        for (int i = 0; i < tab.length; i++)
        {
            for (int j = 0; j < tab[i].length; j++)
            {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
    }

}