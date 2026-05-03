package N21;

import java.util.LinkedList;
import java.util.List;

public class N21 {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(), new ListNode()));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listResult = new ListNode();
        ListNode currentElement = listResult;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentElement.next = list1;
                list1 = list1.next;
            } else {
                currentElement.next = list2;
                list2 = list2.next;
            }
            currentElement = currentElement.next;
        }
        if (list1 == null) {
            currentElement.next = list2;
        } else currentElement.next = list1;
        return listResult.next;
    }
}
//    public static int[] mergeTwoLists(int[] list1, int[] list2) {
//        int[] listResult = new int[list1.length+list2.length];
//        int currentIndex = 0;
//        if (list1.length == list2.length) {
//            for (int i = 0; i < list1.length; i++) {
//                if (list1[i] > list2[i]) {
//                    listResult[currentIndex] = list2[i];
//                    listResult[currentIndex + 1] = list1[i];
//                    currentIndex += 2;
//                } else if (list1[i] == list2[i]) {
//                    listResult[currentIndex] = list2[i];
//                    listResult[currentIndex + 1] = list1[i];
//                    currentIndex += 2;
//                } else {
//                    listResult[currentIndex] = list1[i];
//                    listResult[currentIndex + 1] = list2[i];
//                    currentIndex += 2;
//                }
//            }
//        } else if (list1.length < list2.length) {
//            for (int i = 0; i < list1.length; i++) {
//                if (list1[i] > list2[i]) {
//                    listResult[currentIndex] = list2[i];
//                    listResult[currentIndex + 1] = list1[i];
//                    currentIndex += 2;
//                } else if (list1[i] == list2[i]) {
//                    listResult[currentIndex] = list2[i];
//                    listResult[currentIndex + 1] = list1[i];
//                    currentIndex += 2;
//                } else {
//                    listResult[currentIndex] = list1[i];
//                    listResult[currentIndex + 1] = list2[i];
//                    currentIndex += 2;
//                }
//            }
//            for (int i = list1.length+1; i < list2.length; i++) {
//                listResult[i] = list2[i];
//            }
//        } else {
//            for (int i = 0; i < list1.length; i++) {
//                if (list1[i] > list2[i]) {
//                    listResult[currentIndex] = list2[i];
//                    listResult[currentIndex + 1] = list1[i];
//                    currentIndex += 2;
//                } else if (list1[i] == list2[i]) {
//                    listResult[currentIndex] = list2[i];
//                    listResult[currentIndex + 1] = list1[i];
//                    currentIndex += 2;
//                } else {
//                    listResult[currentIndex] = list1[i];
//                    listResult[currentIndex + 1] = list2[i];
//                    currentIndex += 2;
//                }
//            }
//            for (int i = list2.length+1; i < list1.length; i++) {
//                listResult[i] = list1[i];
//            }
//        }
//        return listResult;
//    }


