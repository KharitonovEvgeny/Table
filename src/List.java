//Динамический список
public class List {
    ItemList root;
    
    public List (){
        root = null;
    }
    
    public boolean insert (String s, String m, String p ,String n){
        if (root==null) {
            root=new ItemList(s,m,p,n);
            return true;
        }
        ItemList tRoot = root;
        while (tRoot.getNext() != null){
            if (n.compareTo(tRoot.getNum())==0) 
                return false;
            tRoot = tRoot.getNext();
        }
        if (n.compareTo(tRoot.getNum())==0)
            return false;
        tRoot.setNext(new ItemList(s,m,p,n));
        return true;
    }
    
    public ItemList search (String n){
        ItemList tRoot = root;
        while (tRoot != null && n.compareTo(tRoot.getNum())!=0){
            tRoot = tRoot.getNext();
        }          
        return tRoot;
    }
    public void show () {
        ItemList tRoot = root;
        while (tRoot != null) { 
            System.out.println("  "+tRoot.getSurname()+"("+tRoot.getPas()+", "+tRoot.getNum()+")");
            tRoot = tRoot.getNext();
        }
    }
    void delete (String n) {
        if (root ==null)
            return;
        if (n.compareTo(root.getNum())==0) {
            root=root.getNext();
            return;
        }
        ItemList tRoot = root;
        while (tRoot.getNext() != null){
            if (n.compareTo(tRoot.getNext().getNum())==0){ //
                tRoot.setNext(tRoot.getNext().getNext());
                return;
            }
            tRoot = tRoot.getNext();        
        }
    }
}
