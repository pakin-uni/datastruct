public class ArrayList implements ListADT{
    private int total;
    private Object s[];
    int current,size;
    public  ArrayList() {
        current= -1;
        total = 50;
        s = new Object[total];
        size=0;
    }

    @Override
    public void insert(Object e) throws Exception {
        if (isFull()){
            throw new Exception("List is full");
        }else {
            size++;
            if (size==1){
                current++;
                s[current]=e;
            }else {
                for(int i=size-1;i>current;i--)
                    s[i]=s[i-1];
                current++;
                s[current] = e;
            }
        }
    }

    @Override
    public Object retrieve() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }else {
            return s[current];
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }else {
            if (size == 1)
                current = -1;
            else if (current==size-1)
                current = 0;
            else{
                for(int i=current;i<size-1;i++)
                    s[i]=s[i+1];
                current = 0;
            }
            size--;
        }

    }

    @Override
    public void update(Object e) throws Exception {
        s[current] = e;
    }

    @Override
    public void findFirst() throws Exception {
        current = 0;
    }

    @Override
    public void findNext() throws Exception {
            current++;
    }

    @Override
    public boolean isFull() {
        return size == 50;
    }

    @Override
    public boolean findKey(Object tKey) {
        return false;
    }

    public void SortByBookname(){
        int mid=0;
        Object book = s[mid];
        for(int i=0;i<size-1;i++){

        }
    }
}
