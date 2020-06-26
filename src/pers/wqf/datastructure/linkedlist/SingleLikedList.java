package pers.wqf.datastructure.linkedlist;


/**
 * @author Qifeng Wen
 * @date 2020-06-04 下午8:43
 */
public class SingleLikedList {

    private Node head = null;

    public Node getHead() {
        return head;
    }


    /**
     * 尾部添加Node
     *
     * @param node
     */
    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }

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
        if (head == null) {
            head = node;
            return;
        }

        if (head.data > node.data) {
            node.next = head;
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data <= node.data) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public Node query(int data) {

        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public void update(Node newNode, int data) {
        if (head == null) {
            System.out.println("当前列表为空");
            return;
        }
        Node temp = head;
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
        if (head == null) {
            System.out.println("当前链表为空");
        }

        Node temp = head;

        if (temp.data == data) {
            Node curNode = temp.next;
            head.next = null;
            head = curNode;
            return;
        }

        boolean flag = false;
        while (temp.next != null) {
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

        Node temp = head;
        while (true) {
            if (temp == null)
                break;

            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void clear() {
        head = null;
    }


    public Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            this.head = head;
            return head;
        }
        Node node = reverse(head.next);
        node.next = head;
        head.next = null;
        return head;

    }

}

