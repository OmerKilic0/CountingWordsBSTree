public class BSTree {
    private BTNode<String> root=null;

    public BSTree() {}

    public void insert(String word) {
        if(root==null){
            root=new BTNode<String>(word);
            return;
        }
        BTNode<String> w=root;
        while(true){
            if(w.data.compareTo(word)<0){
                if(w.rchild==null) {
                    w.rchild=new BTNode<String>(word);
                    break;
                }
                w=w.rchild;
            }
            else {
                if(w.lchild==null) {
                    w.lchild=new  BTNode<String>(word);
                    break;
                }
                w=w.lchild;
            }
        }
    }

    public boolean isMember(String key) {
        return isMember(root,key);
    }
    private boolean isMember(BTNode<String>r,String e) {
        if(r==null)return false;
        if(r.data.equals(e))return true;
        if(r.data.compareTo(e)<0)
            return isMember(r.rchild,e);
        return isMember(r.lchild,e);
    }

    public BTNode<String> search(String key){
        return search(root,key);
    }

    private BTNode<String> search(BTNode<String> r, String key){
        if(r == null || r.data.equals(key)) return r;
        if(r.data.compareTo(key) < 0){
            return search(r.rchild, key);
        }
        return search(r.lchild, key);
    }

    public String InOrder(){
        return InOrder(root);
    }

    private String InOrder(BTNode<String> r) {
        if(r==null) return null;
        String str="";
        if(r.lchild!=null) {
            str = InOrder(r.lchild);
            str += r.data + ": " + r.getFreq() + "\n";
        }
        if(r.rchild!=null) {
            str = InOrder(r.rchild);
            str += r.data + ": " + r.getFreq() + "\n";
        }
        return str;
    }
}

