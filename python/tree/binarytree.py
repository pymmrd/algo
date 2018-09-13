# -*- coding:utf-8 -*-

"""
二叉查找树
"""


class Node(object):

    def __init__(self, data, leftchild=None, rightchild=None):
        self.data = data
        self.leftchild = leftchild
        self.rightchild = rightchild

    def __repr__(self):
        return "T-Node:{%s}" % self.data


    def search(self, parent, item):
        if parent is None:


class BinarySearchTree(object):
    def __init__(self):
        self.root = None

    
    def insert(self, item):
        """
        循环插入
        """
        node = Noe(item)
        if self.root is None:
            self.root = node
        else:
            current = self.root  # 从根结点起
            parent = None
            while True:
                parent = current # 保留当前结点
                if item < current.data: # 去左子树
                    current = current.leftchild
                    if current is None: # 当左子树为空时，则插入到左边
                        parent.leftchild = node
                        return None
                else:
                    current = current.rightchild # 去右子树
                    if current is None: # 当右子树为空时，则插入右边
                        parent.rightchild = node
                        return None

    def _recursive_insert(self, item, current):
        """
        递归插入时传入当前插入值用做比较确定插入左，右结点。
        """
        if item < current.data:
            if current.leftchild:
                self._recursive_insert(item, current.leftchild)
            else:
                current.leftchild = Node(item)
        else:
            if current.rightchild:
                self._recursive_insert(item, current.rightchild)
            else:
                current.rightchild = Node(item)

    def recursive_insert(self, item):
        """
        递归插入
        """
        if self.root is None:
            self.root = Node(item)
        else:
            self._recurisve_insert(item, self.root)
