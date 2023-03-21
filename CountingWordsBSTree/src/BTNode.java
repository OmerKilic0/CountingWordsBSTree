public class BTNode <T>{

    public T data;
    public BTNode<T> lchild;
    public BTNode <T>rchild;
    private int freq = 1;

    public 	BTNode() {
        lchild=rchild=null;
    }

    public BTNode(T e) {
        lchild=rchild=null;
        data=e;
    }

    public int getFreq(){
        return freq;
    }

    public void incrementFreq(){
        freq++;
    }
}

