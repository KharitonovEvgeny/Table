//Узел дерева
public class Node {
    private final Struct data;
    private Node left;
    private Node right;
    private Node prev;
    public Node(String s, String m, String p ,String n, Node pr){
        data = new Struct(s,m,p,n);
        left = null;
        right = null;
        prev = pr;        
    }
    
    String getSurname(){
        return data.surname;  
    }
    String getMail(){
        return data.mail;
    }
    String getPas(){
        return data.pas;
    }
    String getNum(){
        return data.num;
    }
    Node getLeft(){
        return left;
    }
    Node getRight(){
        return right;
    }
    Node getPrev(){
        return prev;
    }
    void setSurname(String s){
        data.surname=s;
    }
    void setMail(String m){
        data.mail = m;
    }
    void setPas(String p){
        data.pas=p;
    }
    void setNum(String n){
        data.num=n;
    }
    void setLeft(Node a){
        left=a;
    }
    void setRight(Node a){
        right=a;
    }
    void setPrev(Node a){
        prev=a;
    } 
}
