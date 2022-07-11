package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/*
Points to Remember:
1. Approach is simple maintain temp node first push all left into the stack
   and update temp node to left.
2. If temp is null that means all the left node done, then It's time to pop from
   stack print node and update temp to right node so left of those can be iterated first.
3. If stack is empty then break from while that means all nodes are iterated.
 */
@Service
public class InOrderTraversalIterative {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        for (Integer integer : inOrderTraversalIterative(node)) {
            System.out.print(integer+" ");
        }
    }
      
    private List<Integer> inOrderTraversalIterative(TreeNode node) {
        List<Integer> result=new LinkedList<>();
        if(node==null){
            return result;
        }

        Stack<TreeNode> st=new Stack<>();
        TreeNode temp=node;
        while(true){
            if(temp!=null){
                st.add(temp);
                temp=temp.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                else{
                    TreeNode temp2=st.pop();
                    result.add(temp2.value);
                    temp=temp2.right;
                }
            }
        }
        return result;
    }
}
