

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Krolik {

    public static void main(String[] args){

        Scanner file = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        int column = -1;
        int found = 0;
        int good = 0;


        while (file.hasNextLine()) {
            list.add(file.nextLine().split(","));
        }

        for (int y=0; y < list.size(); y++ ) {
            for (int x=0; x < list.get(y).length; x++){
                if (list.get(y)[x].equals("{"+ args[0] +"}")) {
                    column = x;
                    found++;
                }

            }
        }

        switch (found){
            case 0:
                System.out.print("klops");
                break;

            case 1:
                for (int y = 0; y < list.size(); y++)
                {
                    try
                    {
                        if ( -10000 < Integer.valueOf(list.get(y)[column]) && 10000 > Integer.valueOf(list.get(y)[column]))
                        { good += Integer.valueOf(list.get(y)[column]);}
                    }
                    catch (Exception e) {}
                }
                System.out.println(good);
                break;

            default:
                System.out.print("klops");
                break;

        }
    }
}
