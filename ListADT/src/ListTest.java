import javax.swing.*;

class ListTest {
    public static void main(String[] args) {
        String choice;
        int ch = 0;
        Student e;
        ListTest test = new ListTest();
        Object obj;

        ArrayList list = new ArrayList();
        //SinglyLinkedList list = new SinglyLinkedList();
        //DoublyLinkedList list = new DoublyLinkedList();
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
                    e = test.getElement();
                    obj = e;
                    list.insert(e);
                    break;
                case 2:
                    obj = list.retrieve();
                    e = (Student) obj;
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
            }
            } catch (Exception ex) {
                throw 
                new RuntimeException(ex);
            }
        }
    }
    public Student getElement(){
        Student temp;
        String Author, bookName, Genera;
        double price;

        Author = JOptionPane.showInputDialog(null, "Input Name of Author. ");
        bookName = JOptionPane.showInputDialog(null, "Input Name of the book. ");
        price = Double.parseDouble(JOptionPane.showInputDialog(null, "Input price of book. "));
        Genera = JOptionPane.showInputDialog(null, "Input Genera of book. ");
        temp = new Student(Author, bookName, price, Genera);
        temp.setStudent(Author, bookName, price, Genera);
        return temp;
    }
    public void printElement(Student e){
        if (e != null){
            JOptionPane.showInputDialog(null,
                    "ID                    : "+e.getAuthor()+
                            "\nName                : "+e.getBookName()+
                            "\nMidterm Score       : "+e.getPrice()+
                            "\nFinal Score         : "+e.getGenera());

        }
    }
}
