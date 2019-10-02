import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paprotka {

    private static boolean isPrime(long n)
    {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) { if (n % i == 0) return false;}
        return true;
    }

    public static List<Long> divideNumber(long n)
    {
        List<Long> primeFactors = new ArrayList<>();
        for (long i = 2; i <= n; i++)
        {
            if (n % i == 0)
            {
                primeFactors.add(i);
                n /= i;
                i--;
            }
        }
        return primeFactors;
    }

    public static void end(String info)
    {
        System.out.print(info);
        System.exit(1);
    }

    public static void writeFactors(List<Long> longFactors)
    {
        for (int i = 0; i < longFactors.size() - 1; i++) { System.out.print(longFactors.get(i) + ",");}
        System.out.print(longFactors.get(longFactors.size() - 1));
    }

    public static void writeNumber(long argument)
    {
        System.out.println(argument);
    }

    public static void main(String[] args) {

        Scanner file = new Scanner(System.in);
        List<String[]> stringFactors = new ArrayList<>();
        List<Long> longFactors = new ArrayList<>();

        long number = 0;
        boolean NumberExist;
        boolean FactorsExist;
        boolean PartCorrect = true;
        boolean AllFactors = true;

        try {
            number = Long.valueOf(file.nextLine());
            NumberExist = true;
        } catch (Exception e) { NumberExist = false;}

        while (file.hasNextLine()) { stringFactors.add(file.nextLine().split(","));}

        if (stringFactors.size() == 1 && stringFactors.get(0) != null) { FactorsExist = true; }
        else FactorsExist = false;

        if (!NumberExist && !FactorsExist) { end("klops");}

        if (NumberExist && !FactorsExist)
        {
            writeNumber(number);
            longFactors = divideNumber(number);
            writeFactors(longFactors);
        }

        if (FactorsExist)
        {
            for (String[] item : stringFactors)
            {
                for (String num : item)
                {
                    try { longFactors.add(Long.valueOf(num));} catch (Exception e) {}
                }
            }

            for (Long item : longFactors) {
                if (isPrime(item)) { PartCorrect = true;}
                else PartCorrect = false;
            }
            if (!PartCorrect) { end("klops");}
            else
            {
                long sum = 1;
                for (long num : longFactors) {
                    sum = sum * num;
                }

                if (NumberExist)
                {
                    if (sum == number) { AllFactors = true;}
                    else AllFactors = false;
                }

                if (!AllFactors)
                {
                    writeNumber(number);
                    long rest = number / sum;
                    longFactors = divideNumber(rest);
                    writeFactors(longFactors);
                }
                else
                {
                    if (!NumberExist){ writeNumber(sum);}
                    else writeNumber(number);
                }
            }
        }
    }
}