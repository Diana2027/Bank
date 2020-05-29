import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Введите количество каждой купюры номиналом 30, 100, 500 и 1000:\n");
    int k30 = in.nextInt(), k100 = in.nextInt(), k500 = in.nextInt(), k1000 = in.nextInt();
    System.out.println("\nВведите сумму, которую хотите получить: \n");
    int sum = in.nextInt();
    int n1000 = 0, n500 = 0, n100 = 0, n30 = 0, o500 = 0, o100 = 0, o30 = 0, m = 0;
    if (k30 * 30 + k100 * 100 + k500 * 500 + k1000 * 1000 > sum) {
      if (sum % 1000 == 0 && sum / 1000 <= k1000) n1000 = sum / 1000;
      else {
        n1000 = sum / 1000;
        if (n1000 > k1000) {
          while (n1000 > k1000)
            n1000--;
        }
        if (n1000 >= 0) o500 = sum - n1000 * 1000;
        else o500 = sum;
        if (o500 % 500 == 0 && o500 / 500 <= k500) n500 = o500 / 500;
        else {
          n500 = o500 / 500;
          if (n500 > k500) {
            while (n500 > k500)
              n500--;
          }
          if (n500 >= 0) o100 = o500 - n500 * 500;
          else o100 = o500;
          if (o100 % 100 == 0 && o100 / 100 <= k100) n100 = o100 / 100;
          else {
            n100 = o100 / 100;
            if (n100 > k100) {
              while (n100 > k100)
                n100--;
            }
            if (n100 >= 0) o30 = o100 - n100 * 100;
            else o30 = o100;
            if (o30 % 30 == 0 && o30 / 30 <= k30) n30 = o30 / 30;
            else if (sum % 30 == 0) {
              System.out.println("\nВы получите желаемую сумму, состоящую из:\n" + sum / 30 + " куп. номиналом 30");
              m = 1;
            }
            else {
              System.out.print("\nНевозможно получить желаемую сумму, введите другую!");
              m = 1;
            }
          }
        }
      }
      if (m != 1) {
        System.out.println("\nВы получите желаемую сумму, состоящую из:\n");
        if (n1000 > 0) System.out.println(n1000 + " куп. номиналом 1000\n");
        if (n500 > 0)  System.out.println(n500 + " куп. номиналом 500\n");
        if (n100 > 0)  System.out.println(n100 + " куп. номиналом 100\n");
        if (n30 > 0)   System.out.println(n30 + " куп. номиналом 30");
      }
    }
    else if (k30 * 30 + k100 * 100 + k500 * 500 + k1000 * 1000 == sum)
      System.out.print("\nВы получите желаемую сумму, состоящую из:\n\n" + k30 + " куп. номиналом 30;\n\n" + k100 + " куп. номиналом 100;\n\n" + k500 + " куп. номиналом 500;\n\n" + k1000 + " куп. номиналом 1000.");
    else
      System.out.print("\nНевозможно получить желаемую сумму, введите другую.");
  }
}