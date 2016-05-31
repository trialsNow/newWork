package com.entrust.BinarySearchTree;

/**
 * The idea is simple.

 Denote the number of null nodes as nullCnt, the number of actual nodes as nodeCnt.

 For a binary tree, the number of null nodes is always the number of actual nodes plus 1.nullCnt==nodeCnt+1;

 So,

 if nullCnt<nodeCnt+1, the tree is incomplete.
 if nullCnt>nodeCnt+1, the tree is invalid.
 if nullCnt==nodeCnt+1, the tree is complete and can't be extended.
 We just need to keep track of nullCnt and nodeCnt as we go through the sequence and check these conditions above.

 Actually, recording nullCnt-nodeCnt is enough, so you can further improve the code.
 */
public class VerifyPreOrderSerialization {
    public static boolean isValidSerialization(String preorder) {
        String [] splits = preorder.split(",");
        int countNum=0;
        for(int i=splits.length-1;i>=0;i--)
        {
            countNum=splits[i].equals("#") ?(countNum-1):(countNum+1);
            if(countNum>-1)
                return false;
        }
        return countNum==-1;
    }

    public static void main(String[] args){
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("20,#,8,#,10,#,5,#,#"));
    }
}
