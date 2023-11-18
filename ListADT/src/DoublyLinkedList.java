public class DoublyLinkedList implements ListADT{
    Object e;
    DoubleMyNode first,current;
    public DoublyLinkedList()
    {
        first=current= null;
    }

    @Override
    public void insert(Object e) throws Exception {
        DoubleMyNode p = new DoubleMyNode(e,null,null);
        if(isEmpty()){
            first=p;
            current=p;
        }else{
                p.setNextNode(current.getNextNode());
                p.setPreviousNode(current);
                current.setNextNode(p);
                if(p.getNextNode()!=null)
                    p.getNextNode().setPreviousNode(p);
                current = p;
        }
    }

    @Override
    public Object retrieve() throws Exception {
        return current.getData();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void delete() throws Exception {
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        if(first == current){
            if(first.getNextNode() == null){
                first = current = null;
            } else {
                first = first.getNextNode();
                first.setPreviousNode(null);
                current = first;
            }
        } else {
            current.getPrevNode().setPreviousNode(current.getNextNode());
            if (current.getNextNode() != null)
                current.getNextNode().setPreviousNode(current.getPrevNode());
                current = first;

        }
    }

    @Override
    public void update(Object e) throws Exception {
        if(isEmpty()){
            throw new Exception("List is empty");
        }
        DoubleMyNode p = new DoubleMyNode(e);
        if(first==current){
            first = p;
        } else {
            current.getPrevNode().setNextNode(p);
            if(current.getNextNode()!=null) current.getNextNode().setPreviousNode(p);
        }
        p.setNextNode(current.getNextNode());
        current = p;
    }

    @Override
    public void findFirst() throws Exception {
        if(isEmpty()) throw new Exception("List is empty");
        current = first;
    }

    @Override
    public void findNext() throws Exception {
        if(current.getNextNode()!=null) current = current.getNextNode();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean findKey(Object tKey) {
        DoubleMyNode temp = first;
        while (temp != null){
            if(temp.getData().equals(tKey)){
                current = temp;
                return true;
            }
            temp = temp.getNextNode();
        }
        return false;
    }
}
