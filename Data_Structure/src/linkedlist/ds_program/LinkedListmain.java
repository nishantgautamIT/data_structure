package linkedlist.ds_program;

import java.util.Scanner;

public class LinkedListmain {
  static LinkedListmain list = null;

  public static void main(String[] args) {
    System.out
        .println("============================Linked List===================================");
    System.out.println("Enter the option to perform operation");
    System.out.println("Enter  1 to diplay List");
    System.out.println("Enter  2 to insert at start of the List");
    System.out.println("Enter  3 to insert at last of the List");
    System.out.println("Enter  4 to insert at any position of the List");
    System.out.println("Enter  5 to get the lenght of the List");
    System.out.println("Enter  6 to delete at start of the List");
    System.out.println("Enter  7 to delete at end of the List");
    System.out.println("Enter  8 to delete at any position of the List");
    System.out.println("Enter  9 to delete the element of the List");
    System.out.println("Enter  10 to reverse the list");
    System.out.println("Enter  11 to sort the List");
    System.out.println("Enter  12 find the middle element of the list");
    System.out
        .println("============================Linked List===================================");
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    list = new LinkedListmain();
    int insertData = 0;
    int deleteData = 0;
    Node head = null;

    while (true) {
      System.out.println("Enter the choice");
      int c = in.nextInt();
      switch (c) {
        case 1:
          list.displayAll(head);
          break;
        case 2:
          System.out.println("Enter the data to insert at start");
          insertData = in.nextInt();
          head = list.insertAtStart(head, insertData);
          break;
        case 3:
          System.out.println("Enter the data to insert at last");
          insertData = in.nextInt();
          list.insertAtLast(head, insertData);
          break;
        case 4:
          System.out.println("Enter the data to insert at any position");
          insertData = in.nextInt();
          System.out.println("Enter the position");
          int pos = in.nextInt();
          list.insertAtPosition(head, insertData, pos);
          break;
        case 5:
          System.out.println("length of list" + list.listLength(head));
          break;
        case 6:
          head = list.deleteAtFirstPosition(head);
          break;
        case 7:
          list.deleteAtLast(head);
          break;
        case 8:
          System.out.println("Enter the position to delete");
          int delpos = in.nextInt();
          head = list.deleteNodeAtPosition(head, delpos);
          break;
        case 9:
          System.out.println("Enter the ele to delete");
          deleteData = in.nextInt();
          list.deleteNodeByValue(head, deleteData);;
          break;
        case 10:
          head = list.reverseTheList(head);
          break;
        case 11:
          list.sortTheList(head);;
          break;
        case 12:
          System.out.println("Middle ele :  " + list.findMiddleElement(head));
          break;
        default:
          System.out.println("Program exited");
          System.exit(1);
          break;
      }
    }

  }

  public Node createNode(int data) {
    Node head = new Node(data);
    return head;
  }

  public int listLength(Node head) {
    Node current = head;
    int count = 0;

    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public Node insertAtPosition(Node head, int data, int position) {
    Node newNode = new Node(data);


    if (head == null || position == 0) {
      head = newNode;
    } else {
      if (list.listLength(head) < position) {
        System.out.println("position is not available");
        return head;
      }
      Node temp = head;
      if (position == 1) {
        newNode.next = temp;
        head = newNode;
      } else {
        int count = 1;
        Node current = null;
        while (temp.next != null && count++ < position) {
          current = temp;
          temp = current.next;
        }
        current.next = newNode;
        newNode.next = temp;
      }
    }
    return head;
  }

  public Node insertAtStart(Node head, int data) {
    return insertAtPosition(head, data, 1);
  }

  public void insertAtLast(Node head, int data) {
    Node lastNode = new Node(data);
    Node temp = head;
    if (head == null) {
      head = lastNode;
    } else {
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = lastNode;
    }
  }

  public Node deleteNodeAtPosition(Node head, int p) {

    if (head == null) {
      System.out.println("Empty Node");
      return head;
    } else {
      if (list.listLength(head) < p) {
        System.out.println("position is not available");
        return head;
      }
      Node temp = head;
      if (p == 1) {
        head = temp.next;
        temp.next = null;
      } else {
        int count = 1;
        Node currNode = null;
        while (temp.next != null && count++ < p) {
          currNode = temp;
          temp = temp.next;
        }
        currNode.next = temp.next;
      }
    }
    return head;
  }

  public Node deleteAtFirstPosition(Node head) {
    return deleteNodeAtPosition(head, 1);
  }

  public int deleteAtLast(Node head) {
    int deletedElement = 0;

    if (head == null) {
      System.out.println("Empty Node");
      return deletedElement;
    } else {
      Node temp = head;
      Node currNode = null;

      while (temp.next != null) {
        currNode = temp;
        temp = temp.next;
      }
      deletedElement = currNode.value;
      currNode.next = null;
    }
    return deletedElement;
  }

  public void deleteNodeByValue(Node head, int ele) {
    if (list.findEle(head, ele) == false) {
      System.out.println("element is not found.");
      return;
    }
    if (head == null) {
      System.out.println("Empty Node");
    } else {
      Node temp = head;
      Node currNode = null;
      while (temp.value != ele) {
        currNode = temp;
        temp = temp.next;
      }
      currNode.next = temp.next;
    }
  }

  public void displayAll(Node head) {
    Node temp = head;
    
    if(head == null) {
      System.out.println("List is empty.");
    }
    else {
      while(temp != null) {
        System.out.println(temp.value);
        temp = temp.next;
      }
    }
  }

  public Node reverseTheList(Node head) {
    Node curr = head;

    if (curr == null) {
      System.out.println("List is empty.");
    } else {
      Node prevTemp = null;
      Node nextTemp = null;

      while (curr != null) {
        nextTemp = curr.next;
        curr.next = prevTemp;
        prevTemp = curr;
        curr = nextTemp;
      }
      head = prevTemp;
    }
    return head;
  }

  public void sortTheList(Node head) {
    Node curr = head;
    Node currNext = null;

    while (curr != null) {
      if (curr.next == null) {
        break;
      }
      currNext = curr.next;
      while (currNext != null) {
        if (curr.value > currNext.value) {
          int temp = curr.value;
          curr.value = currNext.value;
          currNext.value = temp;
        }

        currNext = currNext.next;
      }
      curr = curr.next;
    }
  }

  public int findMiddleElement(Node head) {
    Node temp = head;
    Node curr = head;
    if (temp == null) {
      return 0;
    }

    while (temp.next != null) {
      curr = curr.next;
      temp = temp.next;
      if (temp.next != null) {
        temp = temp.next;
      } else {
        break;
      }
    }
    return curr.value;
  }
  
  public boolean findEle(Node head, int ele) {
    boolean flag = false;
    Node temp = head;
    while (temp != null) {
      if (temp.value == ele) {
        flag = true;
      }
      temp = temp.next;
    }
    return flag;
  }
}
