public interface ListADT {
    //public void List();
    public void insert(Book e) throws Exception;
    public Object retrieve() throws Exception;
    public boolean isEmpty();
    public void delete() throws Exception;
    public void update(Book e) throws Exception;
    public void findFirst() throws Exception;
    public void findNext() throws Exception;
    public boolean isFull();
    public boolean findKey(Object tKey);
}
