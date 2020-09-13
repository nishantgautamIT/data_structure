package stack.based_problem;

import java.util.Scanner;

public class BalancingSymbol {

  private static char deletedSymbol;

  public static void main(String[] args) {
    Node node = null;
    System.out.println("Enter symbol expression.");
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    String exp = input.next();
    int i = 0;

    while (i < exp.length()) {
      if (exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(') {
        node = push(exp.charAt(i), node);
      }

      if (exp.charAt(i) == '}' || exp.charAt(i) == ']' || exp.charAt(i) == ')') {
        if (node == null) {
          System.out.print("report an error");
          return;
        }

        node = pop(node);
        char symbol = exp.charAt(i);

        if (symbol == '}' && deletedSymbol == '{') {
          i++;
          continue;
        }

        else if (symbol == ']' && deletedSymbol == '[') {
          i++;
          continue;
        }

        else if (symbol == ')' && deletedSymbol == '(') {
          i++;
          continue;
        }
        else {
          System.out.print("report an error");
          return;
        }
      }
      i++;
    }

    if (node != null) {
      System.out.print("report an error");
      return;
    } else {
      System.out.print("balaced exp.");
    }
  }

  private static Node pop(Node node) {
    deletedSymbol = node.value;
    return node.next;
  }

  private static Node push(char symbol, Node node) {
    Node temp = new Node(symbol);

    if (node == null) {
      return temp;
    } else {
      temp.next = node;
    }

    return temp;
  }

}
