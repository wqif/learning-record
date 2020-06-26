package com.datastructure.linkedlist.demo;

import com.datastructure.linkedlist.Node;
import com.datastructure.linkedlist.SingleLikedList;

/**
 * @author Qifeng Wen
 * @date 2020-06-06 下午3:38
 */
public class SingleLikedListDemo {
    public static void main(String[] args) {
        SingleLikedList singleLikedList = new SingleLikedList();

        // 添加Node
        System.out.println("---------add test----------");
        singleLikedList.add(new Node(1));
        singleLikedList.add(new Node(2));
        singleLikedList.add(new Node(3));
        singleLikedList.add(new Node(4));
        singleLikedList.printList();
        singleLikedList.clear();

        // 按顺序添加
        System.out.println("---------addByOrder test----------");
        singleLikedList.addByOrder(new Node(2));
        singleLikedList.addByOrder(new Node(1));
        singleLikedList.addByOrder(new Node(3));
        singleLikedList.addByOrder(new Node(4));
        singleLikedList.printList();
        singleLikedList.clear();

        // 修改Node
        System.out.println("--------update test-----------");
        singleLikedList.add(new Node(1));
        singleLikedList.add(new Node(2));
        singleLikedList.add(new Node(3));
        singleLikedList.update(new Node(6), 2);
        singleLikedList.printList();
        singleLikedList.clear();

        // 删除Node
        System.out.println("--------delete test-----------");
        singleLikedList.add(new Node(1));
        singleLikedList.add(new Node(2));
        singleLikedList.printList();
        singleLikedList.delete(2);
        singleLikedList.printList();
        singleLikedList.delete(3);
        singleLikedList.printList();
        singleLikedList.clear();

        // 查找Node
        System.out.println("--------query test-----------");
        singleLikedList.add(new Node(1));
        singleLikedList.add(new Node(4));
        singleLikedList.add(new Node(2));
        System.out.println(singleLikedList.query(2));
        singleLikedList.clear();

        System.out.println("---------reverse before----------");
        singleLikedList.add(new Node(1));
        singleLikedList.add(new Node(2));
        singleLikedList.add(new Node(3));
        singleLikedList.add(new Node(4));
        singleLikedList.printList();
        System.out.println("---------reverse----------");
        singleLikedList.reverse(singleLikedList.getHead());
        singleLikedList.printList();
        singleLikedList.clear();
    }
}
