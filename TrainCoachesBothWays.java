
public class TrainCoachesBothWays {

    static class Node {
        String name;
        Node prev;
        Node next;

        Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        // Add a coach at the end
        void addLast(String name) {
            Node newNode = new Node(name);

            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        // Remove a coach by name
        void remove(String name) {
            Node current = head;

            while (current != null &&
                   !current.name.equals(name)) {
                current = current.next;
            }

            // Coach not found
            if (current == null) {
                return;
            }

            // Update the previous node or head
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            // Update the next node or tail
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }

        // Print from engine end to guard end
        void printForward() {
            System.out.print("Forward: ");
            Node current = head;

            while (current != null) {
                System.out.print(current.name);
                if (current.next != null) {
                    System.out.print(" <-> ");
                }
                current = current.next;
            }

            System.out.println();
        }

        // Print from guard end to engine end
        void printBackward() {
            System.out.print("Backward: ");
            Node current = tail;

            while (current != null) {
                System.out.print(current.name);
                if (current.prev != null) {
                    System.out.print(" <-> ");
                }
                current = current.prev;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList train = new DoublyLinkedList();

        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        // Remove coach B1
        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
