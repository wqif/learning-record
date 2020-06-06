package com.datastructure.linkedlist.demo;

import com.datastructure.linkedlist.DoubleLinkedList;
import com.datastructure.linkedlist.Node;

/**
 * @author Qifeng Wen
 * @date 2020-06-06 下午3:47
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        // 按顺序添加
        System.out.println("---------addByOrder test----------");
        doubleLinkedList.addByOrder(new Node(2));
        doubleLinkedList.addByOrder(new Node(1));
        doubleLinkedList.addByOrder(new Node(3));
        doubleLinkedList.addByOrder(new Node(4));
        doubleLinkedList.printList();
        doubleLinkedList.clear();
        
        // 修改Node
        System.out.println("--------update test-----------");
        doubleLinkedList.add(new Node(1));
        doubleLinkedList.add(new Node(2));
        doubleLinkedList.add(new Node(3));
        doubleLinkedList.add(new Node(4));
        doubleLinkedList.update(new Node(6), 4);
        doubleLinkedList.printList();
        doubleLinkedList.clear();
        
        // 删除Node
        System.out.println("--------delete test-----------");
        doubleLinkedList.add(new Node(1));
        doubleLinkedList.add(new Node(2));
        doubleLinkedList.add(new Node(3));
        doubleLinkedList.add(new Node(4));
        doubleLinkedList.printList();
        doubleLinkedList.delete(1);
        doubleLinkedList.printList();
        doubleLinkedList.delete(5);
        doubleLinkedList.printList();
        doubleLinkedList.clear();

    }
}
