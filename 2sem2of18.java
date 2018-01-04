import java.util.Random;

public class 2sem2of18 {

    public static void main(String[] args) {
        Random rand = new Random();

    int count = 5;
    int sum = 0;

    int mas[] = new int[7];
    for(int i = 1; i <= count; i++) {
        mas[i] = rand.nextInt(6);
        System.out.println("Число - " + mas[i]);
        sum += mas[i];
    }

    System.out.println("Среднее - " + (sum/count));
    }

}