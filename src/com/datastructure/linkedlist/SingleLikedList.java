package com.datastructure.linkedlist;


/**
 * @author Qifeng Wen
 * @date 2020-06-04 下午8:43
 */
public class SingleLikedList {
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
        singleLikedList.delete(1);
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


    }

    private Node head = new Node(null);

    /**
     * 尾部添加Node
     *
     * @param node
     */
    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            // 当找到链表最后一个节点时，退出循环
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按顺序添加Node
     *
     * @param node
     */
    public void addByOrder(Node node) {
        Node temp = head;
        while (temp.next != null && temp.next.data <= node.data) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public Node query(int data) {
        if (head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                return temp.next;
            }
            temp = temp.next;
        }
        return null;
    }


    public void update(Node newNode, int data) {
        if (head.next == null) {
            System.out.println("当前列表为空");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.data == data) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.data = newNode.data;
        } else {
            System.out.println("没有找打data值为" + data + "的Node");
        }
    }

    /**
     * 删除Node
     *
     * @param data
     */
    public void delete(int data) {
        Node temp = head;
        boolean flag = false;
        while (temp.next != null) {
            System.out.println(temp.next.data + "---------" + data);
            if (temp.next.data == data) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("找不到data值为" + data + "的Node");
        }
    }

    public void printList() {
        // 判断链表是否为空
        if (head.next == null) {
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null)
                break;

            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void clear() {
        head.next = null;
    }
}

class Node {
    public Integer data;
    public Node next;

    public Node(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}