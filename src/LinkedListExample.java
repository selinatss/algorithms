
     /*   Linked List are linear data structures where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.
     The elements are linked using pointers and addresses. Each element is known as a node. Due to the dynamicity and ease of insertions and deletions, they are preferred over the arrays.
     It also has few disadvantages like the nodes cannot be accessed directly instead we need to start from the head and follow through the link to reach to a node we wish to access.

     To store the elements in a linked list we use a doubly linked list which provides a linear data structure and also used to inherit an abstract class and implement list and deque interfaces.

     In Java, LinkedList class implements the list interface. The LinkedList class also consists of various constructors and methods like other java collections.

     Constructors for Java LinkedList:
        LinkedList(): Used to create an empty linked list.
        LinkedList(Collection C): Used to create a ordered list which contains all the elements of a specified collection, as returned by the collection’s iterator.
     */

     import java.util.Iterator;
     import java.util.LinkedList;

     public class LinkedListExample {
        public static void main(String args[]) {
            LinkedList<String> list = new LinkedList<String>();
            list.add("Selin1");
            list.add("Selin2");
            list.add("Selin2");
            list.add("Selin2");
            list.add("Selin2");
            list.add("Selin2");

            Iterator<String> itr= list.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }

        }
     }
