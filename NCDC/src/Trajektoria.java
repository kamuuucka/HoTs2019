public class Trajektoria {

    public static void main (String[] args){

        int amplitude=0;
        int flightLength=0;

        try{
            amplitude = Integer.valueOf(args[0]);
            flightLength = Integer.valueOf(args[1]);
        }catch(Exception ex){System.out.print("klops"); System.exit(1);}

        String[][] tab = new String[amplitude][flightLength];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = " ";
            }
        }

        int x = 0;
        int y = 0;

        tab[x][y] = "*";

        while (flightLength !=0) {
            while (x != amplitude - 1 && flightLength != 0) {

                tab[x][y] = "*";
                x++;
                y++;
                flightLength--;
            }
            while (x != 0 && flightLength != 0) {

                tab[x][y] = "*";
                x--;
                y++;
                flightLength--;
            }
        }

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
    }
}
