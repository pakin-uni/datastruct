public class LinkedList implements ListADT{
    Object e;
    Mynode first,current;

    public void LinkedList() {
        first=current= null;
    }

    @Override
    public void insert(Object e) throws Exception {
        Mynode p = new Mynode(e,null);
        if(isEmpty()){
            first=p;
            current=p;
        }else {
            p.setNextNode(current.getNextNode());
            current.setNextNode(p);
            current = p;
        }

    }

    @Override
    public Object retrieve() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        else {
            return current.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void delete() throws Exception {
        Mynode previous;
        if (isEmpty()) {
            throw new Exception("List is Empty");
        } else {
            previous = first;
            if (previous == current && current.getNextNode() == null)
                first = current = null;
            else if (previous == current && current.getNextNode() != null) {
                first = first.getNextNode();
                current = first;
            } else {
                while (previous.getNextNode() != current)
                    previous = previous.getNextNode();
                previous.setNextNode(current.getNextNode());
                current = first;
            }
        }
    }

    @Override
    public void update(Object e) throws Exception {
        Mynode p = new Mynode(e,null);
        p.setNextNode(current.getNextNode());
        current.setNextNode(p);
        current = p;
    }

    @Override
    public void findFirst() throws Exception {
        current = first;
    }

    @Override
    public void findNext() throws Exception {
        current = current.getNextNode();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean findKey(Object tKey) {
        return false;
    }
}
