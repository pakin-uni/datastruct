import javax.swing.*;

public class ArrayList implements ListADT {
    private int total;
    private Book[] book;
    int current, size;

    public ArrayList() {
        current = -1;
        total = 50;
        book = new Book[total];
        size = 0;

    }

    @Override
    public void insert(Book e) throws Exception {
        if (isFull()) {
            throw new Exception("List is full");
        } else {
            size++;
            if (size == 1) {
                current++;
                System.out.println(current);
                book[current] = e;
            } else {
                for (int i = size - 1; i > current; i--)
                    book[i] = book[i - 1];
                current++;
                book[current] = e;
            }
        }
        System.out.println(book[current].getBookName());
    }

    @Override
    public Object retrieve() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        } else {
            return book[current];
        }
    }

    public Object retrieveName() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        } else {
            return book[current].getBookName();
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
        } else {
            if (size == 1)
                current = -1;
            else if (current == size - 1)
                current = 0;
            else {
                for (int i = current; i < size - 1; i++)
                    book[i] = book[i + 1];
                current = 0;
            }
            size--;
        }

    }

    public void deleteBook(int row) throws Exception {
        int Row = row;
        System.out.println(Row);
        if (isEmpty()) {
            throw new Exception("List is empty");
        } else {
            if (size == 1)
                Row = -1;
            else if (Row == size - 1)
                Row = 0;
            else {
                for (int i = Row; i < size - 1; i++)
                    book[i] = book[i + 1];
                Row = 0;
            }
            size--;
        }

    }

    @Override
    public void update(Book e) throws Exception {
        book[current] = e;
    }

    @Override
    public void findFirst() throws Exception {
        current = 0;
    }

    @Override
    public void findNext() throws Exception {
        if(current>total)
            throw new Exception("the end of list");
        current += 1;
    }

    @Override
    public boolean isFull() {
        return size == 50;
    }

    @Override
    public boolean findKey(Object tKey) {
        SortByBookname();
        return false;
    }
    public void sortBookname() {
        SortByBookname();
        for (int i = 0; i < size; i++) {
            JOptionPane.showMessageDialog(null,
                    " "+book[i].getBookName());
        }
    }

    public void sortAuthorname() {
        SortByAuthor();
        for (int i = 0; i < size; i++) {
            JOptionPane.showMessageDialog(null,
                    book[i].getBookName());
        }
    }

    public void sortPrice() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }else{
            quickSort(0,size-1);
            for (int i = 0; i < size; i++) {
                JOptionPane.showMessageDialog(null,
                        " Author       : "+book[i].getAuthor()+
                                 "\nTitle      : "+book[i].getBookName()+
                                 "\nPrice      : "+book[i].getPrice()+
                                 "\nGenera     : "+book[i].getGenera());
            }
        }

    }

    public void SortByBookname() {
        Book temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                // to compare one string with other strings
                if (book[i].getBookName().compareTo(book[j].getBookName()) > 0) {
                    // swapping
                    temp = book[i];
                    book[i] = book[j];
                    book[j] = temp;
                }
            }

        }
    }

    public void SortByAuthor() {
        Book temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                // to compare one string with other strings
                if (book[i].getBookName().compareTo(book[j].getBookName()) > 0) {
                    // swapping
                    temp = book[i];
                    book[i] = book[j];
                    book[j] = temp;
                }
            }

        }
    }

        public void quickSort( int left, int right) throws Exception {
            if (isEmpty()) {
                throw new Exception("List is empty");
            }else {
                Book tmp;
                int i, j;
                i = left;
                j = right;
                int mid = (left + right) / 2;
                do {
                    while ((book[i].getPrice()) < (book[mid].getPrice()))
                        i++;
                    while ((book[mid].getPrice()) < (book[j].getPrice()))
                        j--;
                    if (i <= j) {
                        tmp = book[i];
                        book[i] = book[j];
                        book[j] = tmp;
                        i++;
                        j--;
                    }
                } while (i <= j);
                if (left < j) quickSort(left, j);
                if (i < right) quickSort(i, right);
                printAll();
            }
        }

    public boolean SearchName(Object name) {
        boolean nameFound = false;
        for (int i = 0; i<size;i++) {
            System.out.println((book[i].getAuthor()));
            if((book[i].getAuthor()).equals(name)) {
                System.out.println(name);

                System.out.println(name+ " is found at position " +i+"\n");
                JOptionPane.showMessageDialog(null,name+ " is found at position " +i+"\n");
                nameFound = true;
            }
        }
        return nameFound;
    }



    public void printAll () {
            for (int i = 0; i < size; i++) {
                System.out.print(book[i]);
            }
            System.out.println();
        }
}