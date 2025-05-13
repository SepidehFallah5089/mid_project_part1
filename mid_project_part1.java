public class Book {
    private  String name;
    private  String nevisandeh;
    private  int  year;
    private int page;

    //سازنده
    public Book (String name , String nevisandeh , int year ,int page){
        this.name=name;
        this.nevisandeh=nevisandeh;
        this.year=year;
        this.page=page;
    }
    //setter & getter
    public String getName(){return name;}
    public String getNeisandeh(){return nevisandeh;}
    public int getYear(){return year;}
    public int getpage(){return page;}
    public void setName(String name){this.name=name;}
    public void setNevisandeh(String nevisandeh){this.nevisandeh=nevisandeh;}
    public void setYear(int year){this.year=year;}
    public void setpage(int page){this.page=page;}
   //نمایش
    public void namayeshBook(){
      System.out.println("name: "+ name +"      nevisandeh:"+ nevisandeh +"       year:"+ year + "       page:"+ page);
    }
}




import java.time.LocalDate;
public class Student {
    private String fname;
    private String lname;
    private String idstudent;
    private String reshte;
    private LocalDate tarikhOzviat;

    public Student(String fname,String lname,String idstudent,String reshte){
        this.fname=fname;
        this.lname=lname;
        this.idstudent=idstudent;
        this.reshte=reshte;
        this.tarikhOzviat=tarikhOzviat;
    }
    public String getFname(){return fname;}
    public String getLname(){return lname;}
    public String getId(){return idstudent;}
    public String getReshte(){return reshte;}
    public LocalDate getTarikhOzviat(){return tarikhOzviat;}
    public void setFname(String fname){this.fname=fname;}
    public void setLname(String lname){this.lname=lname;}
    public void setId(String id){this.idstudent=idstudent;}
    public void setRashte(String reshte){this.reshte=reshte;}
    public void setTarikhOzvaiat(LocalDate tarikhOzviat){this.tarikhOzviat=tarikhOzviat;}

    public void namayeshStudent(){
        System.out.println("fname:"+fname +"      lname:"+lname + "     id"+idstudent +"       reshte:"+reshte +"      tarikhOzviat:"+tarikhOzviat);
    }

}



public class Librarian {
    private String fname;
    private String lname;
    private int idlibrarian;
    //سازنده
    public Librarian(String fname,String lname,int idlibrarian ){
        this.fname=fname;
        this.lname=lname;
        this.idlibrarian=idlibrarian;
    }
    public String getFname() {return fname;}
    public String getLname(){return lname;}
    public int getIdlibrarion(){return idlibrarian;}

    public void namayeshLibrarian(){
        System.out.println("fname:"+fname   +"    lname:"+lname +"   idlibrarian:"+idlibrarian);
    }

}




import java.time.LocalDate;
public class Loan {
    private Book book;
    private Student student;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Librarian librarianTahvil;
    private Librarian librarianDaryaft;

    //سازنده
    public Loan(Book book , Student student , Librarian librarianTahvil, Librarian librarianDaryaft, long loanPeriodDays) {
        this.book=book;
        this.student=student;
        this.librarianTahvil=librarianTahvil;
        this.librarianDaryaft=null;
        this.loanDate=LocalDate.now();
        this.dueDate=loanDate.plusDays(loanPeriodDays);
        this.returnDate=null;
    }

    //geter

    public Book getBook(){return book;}
    public Student getStudent(){return student;}
    public LocalDate getLoanDate(){return loanDate;}
    public LocalDate getDueDate(){return dueDate;}
    public LocalDate getReturnDate(){return returnDate;}
    public Librarian getLibrarian(){return librarianTahvil;}
    public Librarian getLibrarionDaryaft(){return librarianDaryaft; }
    public void setLibrarianDaryaft(Librarian librarianDaryaft){this.librarianDaryaft=librarianDaryaft;}


    public void returnBook(Librarian librarianDaryaft){
        this.returnDate=LocalDate.now();
        this.librarianDaryaft=librarianDaryaft;
    }

    public void namayeshLoan() {
        System.out.println("Book: " + book.getName() +
                " | Borrowed by: " + student.getFname()+ " " + student.getLname() +
                " | Issued by: " + librarianTahvil.getFname() + " " + librarianTahvil.getLname() +
                " | Loan Date: " + loanDate +
                " | Due Date: " + dueDate +
                " | Returned: " + (returnDate != null ? returnDate : "Not returned yet"));
    }


}





public class Main{
    public static void main(String[] args) {
        Book book1=new Book("Java","n",2018,1000);
        book1.namayeshBook();
        Librarian librarianTahvil = new Librarian("Sara", "Mohammadi", 1001);
        Librarian librarianDaryaft = new Librarian("Reza", "Karimi", 1002);

        Student student1=new Student("s","f","22","k");
        student1.namayeshStudent();

        Librarian librarian1=new Librarian("A","f",50);
        librarian1.namayeshLibrarian();

        Loan loan1 =new Loan(book1,student1,librarian1,null,14);
        loan1.namayeshLoan();

        loan1.returnBook(librarianDaryaft);
        loan1.namayeshLoan();
    }
}