package linkedlist.ds_program;

import java.util.Scanner;

public class DLinkedListMain {

  static DLinkedListMain list = null;

  public static void main(String[] args) {
    System.out
      .println("============================Doubly Linked List===================================");
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
    list = new DLinkedListMain();
    int insertData = 0;
    int deleteData = 0;
    DNode head = null;

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
          head = list.insertAtLast(head, insertData);
          break;
        case 4:
          System.out.println("Enter the data to insert at any position");
          insertData = in.nextInt();
          System.out.println("Enter the position");
          int pos = in.nextInt();
          head = list.insertAtPosition(head, insertData, pos);
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
          head = list.deleteNodeByValue(head, deleteData);;
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

  public int listLength(DNode head) {
    DNode current = head;
    int count = 0;

    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public DNode insertAtPosition(DNode head, int data, int position) {
    DNode newNode = new DNode(data);


    if (head == null || position == 0) {
      head = newNode;
    } else {
      if (list.listLength(head) < position) {
        System.out.println("position is not available");
        return head;
      }
      DNode temp = head;
      if (position == 1) {
        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev = newNode;
        head = newNode;
      } else {
        int count = 1;
        DNode current = null;
        while (temp.next != null && count++ < position) {
          current = temp;
          temp = current.next;
        }
        current.next = newNode;
        temp.prev = newNode;
        newNode.next = temp;
        newNode.prev = current;
      }
    }
    return head;
  }

  public DNode insertAtStart(DNode head, int data) {
    return insertAtPosition(head, data, 1);
  }

  public DNode insertAtLast(DNode head, int data) {
    DNode lastNode = new DNode(data);
    DNode temp = head;

    if (head == null) {
      return lastNode;
    }
    while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = lastNode;
      lastNode.prev = temp;
    return head;
  }

  public DNode deleteNodeAtPosition(DNode head, int p) {

    if (head == null) {
      System.out.println("Empty Node");
      return head;
    } else {
      if (list.listLength(head) < p) {
        System.out.println("position is not available");
        return head;
      }
      DNode temp = head;
      if (p == 1) {
        head = temp.next;
        temp.next = null;
        head.prev = null;
      } else {
        int count = 1;
        DNode currNode = null;
        while (temp.next != null && count++ < p) {
          currNode = temp;
          temp = temp.next;
        }
        currNode.next = temp.next;
        currNode.next.prev = currNode;
      }
    }
    return head;
  }

  public DNode deleteAtFirstPosition(DNode head) {
    return deleteNodeAtPosition(head, 1);
  }

  public int deleteAtLast(DNode head) {
    int deletedElement = 0;

    if (head == null) {
      System.out.println("Empty Node");
      return deletedElement;
    } else {
      DNode temp = head;
      DNode currNode = null;

      while (temp.next != null) {
        currNode = temp;
        temp = temp.next;
      }
      deletedElement = currNode.value;
      currNode.next = null;
    }
    return deletedElement;
  }

  public DNode deleteNodeByValue(DNode head, int ele) {
    if (list.findEle(head, ele) == false) {
      System.out.println("element is not found.");
      return head;
    }
    if (head == null) {
      System.out.println("Empty Node");
    } else {
      DNode temp = head;
      DNode currNode = null;
      if (temp.value == ele) {
        temp = temp.next;
        temp.prev = null;
        return temp;
      }
      while (temp.value != ele) {
        currNode = temp;
        temp = temp.next;
      }
      currNode.next = temp.next;
      if (temp.next != null) {
        temp.next.prev = currNode;
      }
    }
    return head;
  }

  public void displayAll(DNode head) {
    DNode temp = head;

    if (head == null) {
      System.out.println("List is empty.");
    } else {
      while (temp != null) {
        System.out.println(temp.value);
        temp = temp.next;
      }
    }
  }

  public DNode reverseTheList(DNode head) {
    DNode curr = head;

    if (curr == null) {
      System.out.println("List is empty.");
    } else {
      DNode prevTemp = null;
      DNode nextTemp = null;

      while (curr != null) {
        nextTemp = curr.next;
        curr.next = prevTemp;
        curr.prev = nextTemp;
        prevTemp = curr;
        curr = nextTemp;
      }
      head = prevTemp;
    }
    return head;
  }

  public void sortTheList(DNode head) {
    DNode curr = head;
    DNode currNext = null;

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

  public int findMiddleElement(DNode head) {
    DNode temp = head;
    DNode curr = head;
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

  public boolean findEle(DNode head, int ele) {
    boolean flag = false;
    DNode temp = head;
    while (temp != null) {
      if (temp.value == ele) {
        flag = true;
      }
      temp = temp.next;
    }
    return flag;
  }

}
