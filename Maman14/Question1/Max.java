package Question1;

public class Max{

    public static <E extends Comparable<E>> Node<E> max(LinkedList<E> list){
        Node<E> curr = list.getHead();
        Node<E> max = curr;

        while(curr != null){
            int comparison = curr.getContent().compareTo(max.getContent());
            if (comparison >= 0) max = curr;

            curr = curr.getNext();
        }
        return max;
    }
}
