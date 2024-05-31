package Question1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Please enter 6 strings: ");
        for (int i = 0; i < 6; i++) {
            System.out.print("String " + (i+1) + ": ");
            String input = scanner.nextLine();
            list.add(input);
        }

        System.out.println("Original List: " + list);

        LinkedList<String> reversedList = reverseList(list);

        System.out.println("Reversed List: " + reversedList);

    }

    public static <E> LinkedList<E> reverseList(LinkedList<E> originalList) {
        LinkedList<E> reversedList = new LinkedList<>();

        for (Node<E> currentNode = originalList.getHead(); currentNode != null; currentNode = currentNode.getNext()) {
            reversedList.add(currentNode.getContent());
        }

        reversedList.reverseList();

        return reversedList;
    }
}
