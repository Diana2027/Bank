import java.util.Scanner;
class Stack {
  private int mSize;
  private int[] stackArray;
  private int top;
  public Stack(int m) {
    this.mSize = m;
    stackArray = new int[mSize];
    top = -1;
  }
  public void addElement(int element) {
    stackArray[++top] = element;
  }
  public int deleteElement() {
    return stackArray[top--];
  }
  public int readTop() {
    return stackArray[top]; 
  }
  public boolean isEmpty() {
    return (top == -1);
  }
  public boolean isFull() {
    return (top == mSize - 1);
  }
}
class Check { 
    private String input;
    private int lengthInput;
    private Stack stack;
    //В конструкторе инициализируем поля
    public Check(String input) {
      this.input = input;
      this.lengthInput = input.length();
      stack = new Stack(lengthInput);
    }
    public void makeCheck() {  
      for (int i = 0; i < lengthInput; i++) {  // начинаем последовательно считывать
        char ch = input.charAt(i);             // считывание символа 
        switch (ch) {
          case '{':
          case '[':
          case '(':
            stack.addElement(ch);
            break;
          case '}':
          case ']':
          case ')':
            if (!stack.isEmpty()) { //если стек не пустой
              char chClosed = (char)stack.deleteElement(); //удалить и проверить
              if ((ch == '}' && chClosed != '{') || (ch == ']' && chClosed != '[') || (ch == ')' && chClosed != '(')) {
                System.out.println("\nНеправильное расположение скобки " + ch + " в " + i + " позиции.");
                return;
              }
            }
            else {
              i--;
              System.out.println("\nНеправильное расположение скобки " + ch + " в " + i + " позиции.");
              return;
            } //недостаток элементов в стеке
            break;
          default:    // для других символов действия не выполняются
              break;
        }
      }
      if (!stack.isEmpty()) System.out.println("\nНеправильное расположение! Отсутствует закрывающая скобка");
      else System.out.println("\nРасположение и количество скобок в введенной строке верно!");
    }
}
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Введите строку, состоящую из скобок '(', ')', '{', '}', '[', ']' :\n");
    String str = in.nextLine();
    Check check = new Check(str);
    check.makeCheck();
    in.close();
  }
}