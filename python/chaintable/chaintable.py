# -*- coding:utf-8 -*-


class Node(object):
    def __init__(self, val, pnext=None):
        self.data = val
        self.pnext = pnext

    def __repr__(self):
        return "Node{%s}" % self.data


class ChainTable(object):
    def __init__(self):
        self.head = None # 链表头部
        self.length = 0  # 链表长度

    def isEmpty(self):
        return self.length == 0

    def append(self, val):
        """
        从链表尾部开始插入结点
        """
        if isinstance(val, Node):
            node = val
        else:
            node = Node(val)

        if self.isEmpty:
            # 如果是空链表把头部指向第一个结点
            self.head = node

        # 从链表头开始循环遍历链表直到链表尾部
        curNode = self.head
        while curNode.pnext is not None:
            curNode = curNode.pnext
        curNode.pnext = node
        self.length += 1

    def prepend(self, val):
        """
        从链表头部插入结点
        """
        if isinstance(val, Node):
            node = val
        else:
            node = Node(val)
        if self.isEmpty(): # 如果链表为空
            self.head = node
            self.length += 1
        else:
            # 如果不为空，将头结点指向当前结点
            node.pnext = self.head
            self.head = node
            self.length += 1

    def insert(self, index, val):
        """
        向链表的某个位置插入数据
        """
        if self.isEmpty() or index < 0 or index > self.length:
            raise "Error: Out of index"

        if isinstance(val, Node):
            node = val
        else:
            node = Node(val)

        if index == 0:
            pnext = self.head.pnext
            self.head = node
            node.pnext = pnext

        # 从头部遍历链表找到插入结点
        pnode = self.head
        jump = 0
        while pnode is not None and jump < index:
            pnode = pnode.pnext
            jump += 1

        if j == index:
            pnext = pnode.pnext # 取出找到插入结点的下一个结点
            pnode.pnext = node  # 更新原有结点的下一点结点为当前插入结点
            node.pnext = pnext  # 更新插入结点的下一结点
            self.length += 1


    def delete(self, index):
        """
        删除某个结点的数据, 删除的时候只需要删除结点的前缀结点指向
        删除结点的后缀结点即可
        """
        if self.isEmpty() or index < 0 or index > self.length:
            raise "Error: Out of index"

        prev = None
        pnode = self.head
        jump = 0
        while pnode is not None and jump < index:
            prev = pnode
            pnode = pnode.pnext
            jump += 1
        if jump == index:
            #pnode.pnext = None
            prev.pnext = pnode.pnext
            self.length -= 1


    def update(self, index, val):
        """
        更新某个结点的数据
        """
        if self.isEmpty() or index < 0 or index > self.length:
            raise "Error: Out of index"

        jump = 0
        pnode = self.head
        while pnode is not None and jump < index:
            pnode = pnode.pnext
            jump +=1

        if jump == index:
            pnode.data = val
        return pnode

    def reverse_chain_with_prepend(self):
        """
        遍历现有链表，创建新的链表往链表头部插入数据
        """
        newChain = ChainTable()
        pnode = self.head
        while pnode is not None:
            tempnode = pnode # 当前结点赋值到临时结点
            pnode = pnode.pnext
            tempnode.pnext = None  # 并且设置临时的下一结点指针为空 
            # 以无任何指向结点，往链表头部插入结点
            newChain.prepend(tempnode) 
        return newChain

    def getItem(self, index):
        """
        获取某个位置结点
        """
        jump = 0
        pnode = self.head
        while pnode is not None and jump < index:
            pnode = pnode.pnext
            jump += 1
        return pnode

    def indexOf(self, val):
        """
        找出某个相同值的第一个位置
        """
        jump = 0
        pnode = self.head
        while pnode is not None and jump < self.length:
            if pnode.data == val:
                break
            pnode = pnode.pnext
            jump += 1
        return jump


    def __repr__(self):
        s = ''
        pnode = self.head
        while pnode is not None:
            s += str(pnode.data) + " "
            pnode = pnode.pnext
        return s


if __name__ == "__main__":
    ct = ChainTable()
    ct.prepend(1)
    ct.prepend(2)
    ct.prepend(3)
    """
    >>> print ct  
    3 2 1
    >>> print ct.reverse_chain_with_prepend()
    1 2 3
    >>> ct.delete(1)
    >>> print ct
    1 3
    >>> ct.update(1, 5)
    >>> print ct
    1 5
    >>> print ct.indexOf(5)
    1
    """
