package com.algorithm.joseph;

import com.datastructure.linkedlist.CircleSingleLikedList;
import com.datastructure.linkedlist.Node;

import java.sql.PreparedStatement;

/**
 * @author Qifeng Wen
 * @date 2020-06-07 上午9:41
 */
public class Joseph {
    CircleSingleLikedList circleSingleLikedList = new CircleSingleLikedList();

    /**
     * @param size    环状链表节点个数
     * @param num     到num就出环
     * @param startNo 从地几个节点开始
     */
    public void start(int size, int num, int startNo) {
        if (size < 1 || num < 1 || startNo < 1 || startNo > size) {
            System.out.println("参数错误");
            return;
        }

        circleSingleLikedList.add(size); // 构建num个节点的环
        Node first = circleSingleLikedList.getFirst();
        Node helper = first; //辅助指针，指向first的上一个节点
        while (helper.next != first) {
            helper = helper.next;
        }

        // 使first指向参数指定开始节点
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        while (true) {
            if (helper == first) { //如果只有一个节点
                System.out.println(first);// 最后在环中的节点
                break;
            }
            // 让first和helper同时移动num-1
            for (int i = 0; i < num - 1; i++) {
                first = first.next;
                helper = helper.next;
            }

            // 此时就是要出圈的节点
            System.out.println(first);
            first = first.next;
            helper.next = first;

        }
    }
}
