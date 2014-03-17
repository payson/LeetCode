package mySolutions;

import dataStructures.ListNode;

import java.util.HashMap;
/**
 * Created by Payson Wu on 16/03/14.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode a = head;
        ListNode b = head;
        while (b != null) {
            if (b.val == a.val) {
                b = b.next;
                a.next = b;
            } else {
                a = b;
                b = b.next;
            }
        }
        return head;
    }
}
