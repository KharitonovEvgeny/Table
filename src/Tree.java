//Дерево
public class Tree {
    Node root;
    public Tree(){
        root=null;
    }
    
    boolean insert(String s, String m, String p ,String n){
        if (root==null){
            root=new Node(s,m,p,n,null);
            return true;
        }
        return insertR(s,m,p,n,root);
    }
    private boolean insertR(String s, String m, String p ,String n, Node a){
        if (p.compareTo(a.getPas())==0) // уже существует
            return false;
        else if (p.compareTo(a.getPas())<0){ //p < номер паспорта этого
            if(a.getLeft()==null){
                a.setLeft(new Node (s,m,p,n,a));
                return true;
            }
            else return insertR(s,m,p,n, a.getLeft()); 
        }
        else   //p < номер паспорта этого
            if(a.getRight()==null){
                a.setRight(new Node (s,m,p,n, a));
                return true;
            }
            else return insertR(s,m,p,n, a.getRight()); 
    }
    private void showR(Node a)
    {
        if (a==null) return;
        showR(a.getLeft());
    	System.out.println("  "+a.getSurname()+"("+a.getPas()+", "+a.getNum()+")");
        showR(a.getRight());
    }
    void show()
    {
        System.out.println("TREE:");
        showR(root);
    }
    Node search (String p){
        if (root==null)
            return null;
        return searchR(p,root);
    }
    private Node searchR (String p,Node a){
        if (p.compareTo(a.getPas())==0)
            return a;
        if ((p.compareTo(a.getPas())<0)&&(a.getLeft()!=null)){
            return searchR(p,a.getLeft());
        }
        if ((p.compareTo(a.getPas())>0)&&(a.getRight()!=null)){
            return searchR(p,a.getRight());
        }
        return null;
    }
    private Node findMinR (Node a){
        if (a.getLeft()==null)
            return a;
        return findMinR(a.getLeft());
    }
    private void changeNode (Node a, Node b){
        a.setSurname(b.getSurname());
        a.setMail(b.getMail());
        a.setPas(b.getPas());
        a.setNum(b.getNum());
    }
    void delete(String p){
        if (root == null) return;
        if (p.compareTo(root.getPas())==0){  //если хотим удалить корень
            if (root.getRight() == null){ // если только левая ветка
                root=root.getLeft();
            }
            else{    //обе ветки или одна правая
                Node minRight = findMinR(root.getRight());
                changeNode(root,minRight);
                deleteR(minRight.getPas(),minRight);
            }
        }
        else
        deleteR(p,root);
    }
    private void deleteR(String p, Node a){
        if (a==null) return;  // not found
        if (p.compareTo(a.getPas())<0)
            deleteR(p,a.getLeft());
        else if (p.compareTo(a.getPas())>0)
            deleteR(p,a.getRight());
        else if (a.getLeft() == null){
            if (a.getPrev().getRight()==a){
                a.getPrev().setRight(a.getRight()); 
            }
            else if (a.getPrev().getLeft()==a){
                a.getPrev().setLeft(a.getRight());
            }
        }
        else if (a.getRight() == null){
            if (a.getPrev().getRight()==a){
                a.getPrev().setRight(a.getLeft()); 
            }
            else if (a.getPrev().getLeft()==a){
                a.getPrev().setLeft(a.getLeft());
            }
        }
        else {
            Node minRight = findMinR(a.getRight());
            changeNode(a,minRight); 
            deleteR(minRight.getPas(),minRight);
            }
        }
}
