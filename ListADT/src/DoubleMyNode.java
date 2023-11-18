public class DoubleMyNode {
        private Object data;
        private DoubleMyNode nextNode,prevNode;
    DoubleMyNode(Object object){
            this( object, null , null);
        }
    DoubleMyNode(Object object,DoubleMyNode nextNode , DoubleMyNode previousNode){
            data = object;
            nextNode = nextNode;
            prevNode = previousNode;
        }
        public Object getData(){
            return data; }
        public void setData(Object object){
            data=object; }
        public void setNextNode( DoubleMyNode node){
            nextNode = node ; }
        public DoubleMyNode getNextNode() {
            return nextNode; }
        public void setPreviousNode(DoubleMyNode node){ prevNode = node;}
        public DoubleMyNode getPrevNode() {return prevNode;}
}
