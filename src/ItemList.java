//Элемент списка
public class ItemList {
    private final Struct data;
    private ItemList next;
    
    public ItemList (String s, String m, String p ,String n){
        data = new Struct(s,m,p,n);
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
    ItemList getNext (){
        return next;
    }
    void setNext (ItemList a){
        next=a;
    }
}