class Book{
    // change Book to Book
    // add author,BookName,Genera,Price by using refactor to change the attribute
    // dont forgot to change the type for variable
    private String Author, BookName, Genera;
    private double Price;
    public Book(String idS, String nameS, double midS, String finalS){
        Author = idS;
        BookName = nameS;
        Price = midS;
        Genera = finalS;
    }
    public void setStudent(String idS,String nameS,double midS,String finalS){
        Author = idS;
        BookName = nameS;
        Price = midS;
        Genera = finalS;
    }
    public Book getBook(){
        return this;
    }

    public String getAuthor(){
        return this.Author;
    }
    public String getBookName(){
        return this.BookName;
    }
    public  double getPrice(){
        return this.Price;
    }
    public String getGenera(){
        return this.Genera;
    }

//    @Override
//    public int compareTo(Book o) {
//        return this.BookName.compareTo(o.getBookName());
//    }
}
//class BookComparator implements java.util.Comparator<Book> {
//    @Override
//    public int compare(Book veg1, Book veg2) {
//        return veg1.compareTo(veg2);
//    }
//}
