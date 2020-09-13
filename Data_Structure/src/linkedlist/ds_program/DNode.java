package linkedlist.ds_program;

public class DNode {
  int value;
  DNode next;
  DNode prev;

  public DNode(int value) {
    this.value = value;
    prev = null;
    next = null;
  }
}
