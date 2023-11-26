import javax.swing.*;

class ListTest {
    public static void main(String[] args) {
        String choice;
        int ch = 0;
        Book e;
        ListTest test = new ListTest();
        Object obj,j;
        ArrayList list = new ArrayList();
        while(ch != 8){
            try{
                choice = JOptionPane.showInputDialog(null,
                        "---------------------------------------\n"+
                                "                  menu\n"+
                                "---------------------------------------\n"+
                                "               1. Insert\n"+
                                "               2. Retrieve\n"+
                                "               3. Delete\n"+
                                "               4. Update\n"+
                                "               5. Find First\n"+
                                "               6. Find Next\n"+
                                "               7. Find key\n"+
                                "               8. Exit\n"+
                                "---------------------------------------\n");
            ch = Integer.parseInt(choice);
            switch (ch){
                case 1:
                    list.insert(new Book("J","Pride and Prejudice",105,"Romance"));
                    list.insert(new Book("H","Murder on the Orient Express",95,"Romance"));
                    list.insert(new Book("A","The Old Man and the Sea",75,"Adventure"));
                    list.insert(new Book("JR","The Adventures of Tom Sawyer",85,"Dystopian"));
                    list.insert(new Book("B","The Time Machine",55,"Science Fiction"));
                    //
                    //obj = e;
                    //list.insert(e);
                    break;
                case 2:
                    obj = list.retrieve();
                    e = (Book) obj;
                    test.printElement(e);
                    break;
                case 3:
                    list.delete();
                    break;
                case 4:
                    e = test.getElement();
                    obj = e;
                    list.update(e);
                    break;
                case 5:
                    list.findFirst();
                    break;
                case 6:
                    list.findNext();
                    break;
                case 7:
                    String Key = JOptionPane.showInputDialog("Enter key : ");
                    int tKey = Integer.parseInt(Key);
                    if (list.findKey(tKey)){
                        JOptionPane.showMessageDialog(null,"Correct.");
                    } else{
                        JOptionPane.showMessageDialog(null,"Incorrect.");
                    }
                    break;
                case 8:
                    System.exit(0);
                case 9:
                    list.sortBookname();
                    break;
                case 10:
                    list.sortPrice();
                    break;
                case 11:
                    j = test.getEle();
                    if (list.SearchName(j))
                        JOptionPane.showMessageDialog(null,"Found "+list.retrieveName());
                    else
                        JOptionPane.showMessageDialog(null,"Not Found");


                    break;
                default :
                    JOptionPane.showMessageDialog(null,
                            "Not a correct choice, try again",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    public Book getElement(){
        Book temp;
        String Author, bookName, Genera;
        double price;


        Author = JOptionPane.showInputDialog(null, "Input Name of Author. ");
        bookName = JOptionPane.showInputDialog(null, "Input Name of the book. ");
        price = Double.parseDouble(JOptionPane.showInputDialog(null, "Input price of book. "));
        Genera = JOptionPane.showInputDialog(null, "Input Genera of book. ");
        temp = new Book(Author, bookName, price, Genera);
        temp.setStudent(Author, bookName, price, Genera);
        return temp;
    }
    public void printElement(Book e){
        if (e != null){
            JOptionPane.showMessageDialog(null,
                    "ID                    : "+e.getAuthor()+
                            "\nName                : "+e.getBookName()+
                            "\nMidterm Score       : "+e.getPrice()+
                            "\nFinal Score         : "+e.getGenera());

        }
    }

    public String getEle()
    {
        String temp = JOptionPane.showInputDialog(null,"Please Book number :");
        return temp;
    }
}
