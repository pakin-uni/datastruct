public class Mynode {
    private Object data;
    private Mynode nextNode;
    Mynode(Object object){
        this( object, null);
    }
    Mynode(Object object, Mynode node ){
        data = object;
        nextNode = node;
    }
    public Object getData(){
        return data; }
    public void setData(Object object){
        data=object; }
    public void setNextNode( Mynode node){
        nextNode = node ; }
    public Mynode getNextNode(){
        return nextNode; }
}
