# -*- coding:utf-8 -*-

"""
二叉查找树
"""


class Node(object):

    def __init__(self, data, leftchild=None, rightchild=None):
        self.data = data
        self.leftchild = leftchild
        self.rightchild = rightchild

    def is_leaf(self):
        if self.rightchild is None and self.leftchild is None:
            return True

    def __repr__(self):
        return "T-Node:{%s}" % self.data


class BinarySearchTree(object):
    def __init__(self):
        self.root = None
    
    def insert(self, item):
        """
        循环插入
        """
        node = Node(item)
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
        if current is None:
            current = Node(item)
        elif item < current.data:
            current.leftchild = self._recursive_insert(
                item, 
                current.leftchild
            )
        elif item >= current.data:
            current.rightchild = self._recursive_insert(
                item, 
                current.rightchild
            )

    def recursive_insert(self, item):
        """
        递归插入
        """
        if self.root is None:
            self.root = Node(item)
        else:
            self._recurisve_insert(item, self.root)


    def recursive_preOrderTraverse(self, node):
        """
        递归实现树的先序遍历
        """
        if node is not None:
            print node.data
            self.preOrderTraverse(node.leftchild)
            self.preOrderTraverse(node.rightchild)

    def find(self, item):
        """
        查找某个结点是否存在
        """
        flag = False
        current = self.root
        parent = current
        while current is not None:
            data = current.data
            if item > data:
                parent = current
                current = current.rightchild
            elif item < data:
                parent = current
                current = current.leftchild
            elif item == data:
                flag = True
                break
        return flag, parent, current

    def delete_node(self, item):
        """
        (1).如果待删除的节点是叶子节点，那么可以立即被删除
        (2).如果节点只有一个儿子，则将此节点parent的指针指向此节点的儿子，
            然后删除节点。
        (3).如果节点有两个儿子，则将其右子树的最小数据代替此节点的数据，
            并将其右子树的最小数据删除。
        """
        # 先找到结点
        flag, parent, current = self.find(item)
        if flag:
            if current.is_leaf(): # 如果叶子结点
                if parent.leftchild is current:
                    parent.leftchild = None
                else:
                    parent.rightchild = None
                del current
            elif current.leftchild is not None and current.rightchild is not None: # 如果有两个结点 
                # 找出右子树所有最左边结点
                pnode = current.rightchild
                while pnode:
                    pnode = pnode.leftchild
                    if pnode is None:
                        break
                current.data = pnode.data # 内容替换当前结点内容 
                del pnode # 删除最小结点数据
            elif current.leftchild is not None: # 如果只有左结点存在
                parent.leftchild = current.leftchild
                current.leftchild = None
                del current
            elif current.rightchild is not None: # 如果只有右结点
                parent.rightchild = current.leftchild
                current.rightchild = None
                del current
   
    def layer_traverse(self, node):
        """
        层级遍历
        """
        que = queue.Queue()
        que.push(node)
        while not que.empty(): 
           node = que.get()
           print node.data
           if que.leftchild:
                que.push(que.leftchild)
           if que.rightchild:
                que.push(que.rightchild)

    def preOrderTraverse(self, node):
        """
        树的先序遍历：先遍历树根结点，再遍历树的左结点，然后遍历右结点
        算法实现采用无递归方式，利用栈的先进后出原则实现树的遍历。实现步骤
        如下：
        1. 根结点先入栈，然后出栈
        2. 出栈结点右子树先入栈，然后左子树
        >>>bst = BinarySearchTree()
        >>>bst.insert(4)
        >>>bst.insert(5)
        >>>bst.insert(6)
        >>>bst.insert(2)
        >>>bst.insert(1)
        >>>bst.insert(3)
        >>>print bst.preOrderTraverse(bst.root)
        [4, 2, 1, 3, 5, 6]
        """
        orders = []
        stack = [node]
        while len(stack) > 0:
            node = stack.pop()
            orders.append(node)
            if node.rightchild is not None:
                stack.append(node.rightchild)
            if node.leftchild is not None:
                stack.append(node.leftchild)
        return orders


    def inOrderTraverse(self, node):
        """
        树的中序遍历: 首先遍历左子树，然后遍历根结点，其次右子树
        算法实现：首先所有的左子树全部进栈，进站后右子树进栈
        >>>bst = BinarySearchTree()
        >>>bst.insert(4)
        >>>bst.insert(5)
        >>>bst.insert(6)
        >>>bst.insert(2)
        >>>bst.insert(1)
        >>>bst.insert(3)
        >>>print bst.inOrderTraverse(bst.root)
        [1, 2, 3, 4, 5, 6]
        """
        orders = []
        stack = []
        pos = node
        while pos is not None or len(stack) > 0: 
            if pos is not None:
                stack.append(pos)
                pos = pos.leftchild
            else:
                pos = stack.pop()
                orders.append(pos)
                pos = pos.rightchild
        return orders

    def postOrderTraverse(self, node):
        """
        树的后序遍历: 首先遍历左子树，然后是右子树，其次是根结点
        算法实现：
        """
        stack = [node]
        orders = []
        while pos is not None and len(stack) > 0: 
            pos = stack.pop()
            orders.append(node)
            if node.rightchild is not None:
                stack.append(node.righchild)
            if node.leftchild is not None:
                stack.append(node.leftchild)

        # 采用栈形式输出
        while len(orders) > 0:
            print orders.pop().data

    def reversal_tree(self, node):
        """
        二叉树的翻转
        """
        if node is None:
            return None
        node.leftchild, node.rightchild = (
            node.rightchild,
            node.leftchild
        )
        self.reversal_tree(node.leftchild)
        self.reversal_tree(node.rightchild)

    def treeNodenums(node):
       """
       二叉树的结点数量 
       """
       if node is None:
           return 0
       nums = treeNodenums(node.left)
       nums += treeNodenums(node.right)
       return nums + 1

    def bTreeDepth(node):
       """
       # 二叉树的最大深度
       """
       if node is None:
           return 0
       ldepth = bTreeDepth(node.left)
       rdepth = bTreeDepth(node.right)
       return (max(ldepth, rdepth) + 1)


if __name__ == "__main__":
    bst = BinarySearchTree()
    bst.insert(4)
    bst.insert(5)
    bst.insert(6)
    bst.insert(2)
    bst.insert(1)
    bst.insert(3)
    print bst.preOrderTraverse(bst.root)
    print bst.find(7)
    bst.delete_node(2)
    print bst.preOrderTraverse(bst.root)
