// استاد من چون نتونستم intllij  وصل کنم به github 
//ولی vscode ام وصل شد به این دلیل کد هام رو وارد کردم 


public class mid_project_part2 {

    //کلاس کتاب

    public class Ketab {
        private String onvan;
        private String nevisande;
        private int salEnteshar;
        private int tedadSafahat;
        public Ketab(String onvan, String nevisande, int salEnteshar, int tedadSafahat) {
            this.onvan= onvan;
            this.nevisande= nevisande;
            this.salEnteshar= salEnteshar;
            this.tedadSafahat= tedadSafahat;
        }
        public String getOnvan() {return onvan;}
        public String getNevisande() {return nevisande;}
        public int getSalEnteshar() {return salEnteshar;}
        public int getTedadSafhat() {return tedadSafahat;}
        public void setOnvan(String onvan) {this.onvan= onvan;}
        public void setNevisande(String nevisande) {this.nevisande= nevisande;}
        public void setSalEnteshar(int salEnteshar) {this.salEnteshar = salEnteshar;}
        public void setTedadSafahat(int tedadSafahat) {this.tedadSafahat = tedadSafahat;}
    }


// کلاس دانشجو


        import java.time.LocalDate;

        public class Daneshju {
            private String name;
            private String family;
            private int studentId;
            private String reshte;
            private LocalDate tarikheOzviat;
        
            // Constructor
            public Daneshju(String name, String family, int studentId, String reshte, LocalDate tarikheOzviat) {
                this.name = name;
                this.family = family;
                this.studentId = studentId;
                this.reshte = reshte;
                this.tarikheOzviat = tarikheOzviat;
            }
        
            // Getters
            public String getName() { return name; }
            public String getFamily() { return family; }
            public int getStudentId() { return studentId; }
            public String getReshte() { return reshte; }
            public LocalDate getTarikheOzviat() { return tarikheOzviat; }
        
            // Setter برای ویرایش اطلاعات دانشجو در صورت نیاز
            public void setReshte(String reshte) {
                this.reshte = reshte;
            }
        }





//کلاس امانت




        import java.time.LocalDate;

public class Amanat {
    private Ketab ketab;
    private Daneshju daneshju;
    private MotazadiKetabkhane motazadiEmanatDahande;
    private LocalDate tarikheEmanat;
    private LocalDate tarikheBazgasht;
    private LocalDate tarikheVagheieBazgasht;
    private MotazadiKetabkhane motazadiBazgasht;

    public Amanat(Ketab ketab, Daneshju daneshju, MotazadiKetabkhane motazadiEmanatDahande, LocalDate tarikheEmanat, LocalDate tarikheBazgasht) {
        this.ketab = ketab;
        this.daneshju = daneshju;
        this.motazadiEmanatDahande = motazadiEmanatDahande;
        this.tarikheEmanat = tarikheEmanat;
        this.tarikheBazgasht = tarikheBazgasht;
        this.tarikheVagheieBazgasht = null; // هنوز کتاب تحویل داده نشده
        this.motazadiBazgasht = null; // هنوز متصدی تحویل‌دهنده مشخص نشده
    }

    // Getters
    public Ketab getKetab() { return ketab; }
    public Daneshju getDaneshju() { return daneshju; }
    public MotazadiKetabkhane getMotazadiEmanatDahande() { return motazadiEmanatDahande; }
    public LocalDate getTarikheEmanat() { return tarikheEmanat; }
    public LocalDate getTarikheBazgasht() { return tarikheBazgasht; }
    public LocalDate getTarikheVagheieBazgasht() { return tarikheVagheieBazgasht; }
    public MotazadiKetabkhane getMotazadiBazgasht() { return motazadiBazgasht; }

    // ثبت بازگرداندن کتاب
    public void setBazgashtKetab(LocalDate tarikheVagheieBazgasht, MotazadiKetabkhane motazadiBazgasht) {
        this.tarikheVagheieBazgasht = tarikheVagheieBazgasht;
        this.motazadiBazgasht = motazadiBazgasht;
    }
}



// کلاس مدیر کتابخونه



public class ModirKetabkhane {
    private String name;
    private String family;
    private String tahsilat;

    public ModirKetabkhane(String name, String family, String tahsilat) {
        this.name = name;
        this.family = family;
        this.tahsilat = tahsilat;
    }

    // Getters
    public String getName() { return name; }
    public String getFamily() { return family; }
    public String getTahsilat() { return tahsilat; }

    // افزودن متصدی کتابخانه
    public MotazadiKetabkhane addMotazadi(String name, String family, int employeeId) {
        return new MotazadiKetabkhane(name, family, employeeId);
    }
}



// کلاس کتابخونه

import java.util.ArrayList;
import java.util.List;

public class Ketabkhane {
    private String name;
    private List<Ketab> ketabha;
    private List<Daneshju> daneshjuyan;
    private List<MotazadiKetabkhane> motazadian;
    private List<Amanat> amanatha;

    public Ketabkhane(String name) {
        this.name = name;
        this.ketabha = new ArrayList<>();
        this.daneshjuyan = new ArrayList<>();
        this.motazadian = new ArrayList<>();
        this.amanatha = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public List<Ketab> getKetabha() { return ketabha; }
    public List<Daneshju> getDaneshjuyan() { return daneshjuyan; }
    public List<MotazadiKetabkhane> getMotazadian() { return motazadian; }
    public List<Amanat> getAmanatha() { return amanatha; }

    // افزودن کتاب به کتابخانه
    public void addKetab(Ketab ketab) {
        ketabha.add(ketab);
    }

    // ثبت‌نام دانشجو در کتابخانه
    public void addDaneshju(Daneshju daneshju) {
        daneshjuyan.add(daneshju);
    }

    // اضافه کردن متصدی کتابخانه
    public void addMotazadi(MotazadiKetabkhane motazadi) {
        motazadian.add(motazadi);
    }

    // ثبت امانت
    public void addAmanat(Amanat amanat) {
        amanatha.add(amanat);
    }
}



//کلاس ذخیره 


import java.io.*;
import java.util.List;

public class ZakhireBazyabi {
    // ذخیره لیست کتاب‌ها در فایل
    public static void saveKetabha(List<Ketab> ketabha, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(ketabha);
        }
    }

    // بازیابی لیست کتاب‌ها از فایل
    public static List<Ketab> loadKetabha(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Ketab>) ois.readObject();
        }
    }
}



// کلاس منو


import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    // نمایش منوی دانشجو
    public void showStudentMenu() {
        System.out.println("1. ثبت نام در کتابخانه");
        System.out.println("2. ورود به کتابخانه");
        System.out.println("3. جستجوی کتاب");
        System.out.println("4. درخواست امانت کتاب");
        System.out.println("5. مشاهده کتاب‌های امانت گرفته شده");
        System.out.println("6. درخواست بازگرداندن کتاب");
        System.out.println("7. مشاهده تاریخچه امانات");
        System.out.println("0. خروج");
    }

    // نمایش منوی متصدی کتابخانه
    public void showLibrarianMenu() {
        System.out.println("1. ورود به کتابخانه");
        System.out.println("2. ویرایش اطلاعات شخصی");
        System.out.println("3. اضافه کردن کتاب جدید");
        System.out.println("4. تایید درخواست امانت کتاب");
        System.out.println("5. تایید تحویل کتاب");
        System.out.println("6. مشاهده تاریخچه کتاب‌های امانت داده شده");
        System.out.println("7. مشاهده سابقه امانات دانشجو");
        System.out.println("0. خروج");
    }

    // نمایش منوی مدیر کتابخانه
    public void showManagerMenu() {
        System.out.println("1. اضافه کردن متصدی کتابخانه");
        System.out.println("2. مشاهده لیست کتاب‌های دیر بازگردانده شده");
        System.out.println("3. مشاهده تعداد تحویل و دریافت کتاب‌ها به ازای هر متصدی");
        System.out.println("4. مشاهده ۱۰ کتاب پرامانت در یک سال اخیر");
        System.out.println("0. خروج");
    }

    // دریافت ورودی از کاربر
    public int getUserChoice() {
        System.out.print("لطفاً گزینه مورد نظر را انتخاب کنید: ");
        return scanner.nextInt();
    }
}



// کلاس دریافت و دریافت وروی


import java.util.Scanner;

public class DaryaftVaPardazeshVoroodiha {
    private Scanner scanner;

    public DaryaftVaPardazeshVoroodiha() {
        this.scanner = new Scanner(System.in);
    }

    // دریافت ورودی رشته‌ای
    public String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    // دریافت ورودی عدد صحیح
    public int getIntInput(String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("لطفاً یک عدد صحیح وارد کنید.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // دریافت ورودی تاریخ
    public String getDateInput(String prompt) {
        System.out.print(prompt + " (YYYY-MM-DD): ");
        return scanner.next();
    }
}

//متصدی کتابخونه


public class MotazadiKetabkhane {
    private String name;
    private String family;
    private int employeeId;

    public MotazadiKetabkhane(String name, String family, int employeeId) {
        this.name = name;
        this.family = family;
        this.employeeId = employeeId;
    }

    // Getters
    public String getName() { return name; }
    public String getFamily() { return family; }
    public int getEmployeeId() { return employeeId; }

    // Metodha baraye taghir etelaate ketab
    public void updateKetab(Ketab ketab, String onvan, String nevisande, int salEnteshar, int tedadSafahat) {
        ketab.setOnvan(onvan);
        ketab.setNevisande(nevisande);
        ketab.setSalEnteshar(salEnteshar);
        ketab.setTedadSafahat(tedadSafahat);
    }
}




// کلاس main



import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ketabkhane ketabkhane = new Ketabkhane("Ketabkhane Daneshgah");
        Menu menu = new Menu();
        DaryaftVaPardazeshVoroodiha inputHandler = new DaryaftVaPardazeshVoroodiha();

        System.out.println("به سیستم مدیریت کتابخانه خوش آمدید!");
        System.out.print("لطفاً نوع کاربر را انتخاب کنید (1: دانشجو، 2: متصدی، 3: مدیر): ");
        int userType = scanner.nextInt();

        boolean running = true;
        while (running) {
            switch (userType) {
                case 1:
                    menu.showStudentMenu();
                    int studentChoice = scanner.nextInt();
                    handleStudentChoice(studentChoice, ketabkhane, inputHandler);
                    break;

                case 2:
                    menu.showLibrarianMenu();
                    int librarianChoice = scanner.nextInt();
                    handleLibrarianChoice(librarianChoice, ketabkhane, inputHandler);
                    break;

                case 3:
                    menu.showManagerMenu();
                    int managerChoice = scanner.nextInt();
                    handleManagerChoice(managerChoice, ketabkhane, inputHandler);
                    break;

                default:
                    System.out.println("گزینه نامعتبر! لطفاً دوباره امتحان کنید.");
                    running = false;
            }

            System.out.println("\nلطفاً دوباره گزینه‌ای انتخاب کنید یا 0 را برای خروج وارد کنید:");
            int newChoice = scanner.nextInt();
            if (newChoice == 0) {
                running = false;
            }
        }

        scanner.close();
        System.out.println("برنامه پایان یافت!");
    }

    // **مدیریت عملیات دانشجو**
    private static void handleStudentChoice(int choice, Ketabkhane ketabkhane, DaryaftVaPardazeshVoroodiha inputHandler) {
        switch (choice) {
            case 1:
                System.out.println("ثبت نام دانشجو");
                String name = inputHandler.getStringInput("نام");
                String family = inputHandler.getStringInput("نام خانوادگی");
                int studentId = inputHandler.getIntInput("شماره دانشجویی");
                String reshte = inputHandler.getStringInput("رشته تحصیلی");
                LocalDate tarikheOzviat = LocalDate.now();
                ketabkhane.addDaneshju(new Daneshju(name, family, studentId, reshte, tarikheOzviat));
                System.out.println("ثبت نام با موفقیت انجام شد!");
                break;
            case 2:
                System.out.println("ورود دانشجو به سیستم");
                int searchId = inputHandler.getIntInput("شماره دانشجویی");
                for (Daneshju d : ketabkhane.getDaneshjuyan()) {
                    if (d.getStudentId() == searchId) {
                        System.out.println("ورود موفق! خوش آمدید " + d.getName());
                        return;
                    }
                }
                System.out.println("دانشجو یافت نشد.");
                break;
            case 3:
                System.out.println("جستجوی کتاب");
                String searchTitle = inputHandler.getStringInput("نام کتاب مورد نظر");
                for (Ketab ketab : ketabkhane.getKetabha()) {
                    if (ketab.getOnvan().equalsIgnoreCase(searchTitle)) {
                        System.out.println("کتاب یافت شد: " + ketab.getOnvan() + " - " + ketab.getNevisande());
                        return;
                    }
                }
                System.out.println("کتاب مورد نظر یافت نشد.");
                break;
            case 4:
                System.out.println("درخواست امانت کتاب");
                break;
            case 5:
                System.out.println("مشاهده کتاب‌های امانت گرفته شده");
                break;
            case 6:
                System.out.println("درخواست بازگرداندن کتاب");
                break;
            case 7:
                System.out.println("مشاهده تاریخچه امانات");
                break;
            default:
                System.out.println("گزینه نامعتبر!");
        }
    }

    // **مدیریت عملیات متصدی کتابخانه**
    // مدیریت عملیات متصدی کتابخانه
    private static void handleLibrarianChoice(int choice, Ketabkhane ketabkhane, DaryaftVaPardazeshVoroodiha inputHandler) {
        switch (choice) {
            case 1:
                System.out.println("ورود متصدی به سیستم");
                break;
            case 2:
                System.out.println("ویرایش اطلاعات شخصی");
                break;
            case 3:
                System.out.println("اضافه کردن کتاب جدید");

                String title = inputHandler.getStringInput("عنوان کتاب");
                String author = inputHandler.getStringInput("نام نویسنده");
                int year = inputHandler.getIntInput("سال انتشار");
                int pages = inputHandler.getIntInput("تعداد صفحات");

                Ketab ketab = new Ketab(title, author, year, pages);
                ketabkhane.addKetab(ketab);

                System.out.println("کتاب جدید با موفقیت اضافه شد: " + title + " - " + author);
                break;
            case 4:
                System.out.println("تایید درخواست امانت کتاب");
                break;
            case 5:
                System.out.println("تایید تحویل کتاب");
                break;
            case 6:
                System.out.println("مشاهده تاریخچه کتاب‌های امانت داده شده");
                break;
            case 7:
                System.out.println("مشاهده سابقه امانات دانشجو");
                break;
            default:
                System.out.println("گزینه نامعتبر!");
        }
    }


    // **مدیریت عملیات مدیر کتابخانه**
    private static void handleManagerChoice(int choice, Ketabkhane ketabkhane, DaryaftVaPardazeshVoroodiha inputHandler) {
        switch (choice) {
            case 1:
                System.out.println("اضافه کردن متصدی کتابخانه");
                String name = inputHandler.getStringInput("نام");
                String family = inputHandler.getStringInput("نام خانوادگی");
                int employeeId = inputHandler.getIntInput("شناسه کارمندی");
                ketabkhane.addMotazadi(new MotazadiKetabkhane(name, family, employeeId));
                System.out.println("متصدی جدید اضافه شد!");
                break;
            case 2:
                System.out.println("مشاهده لیست کتاب‌های دیر بازگردانده شده");
                break;
            case 3:
                System.out.println("مشاهده تعداد تحویل و دریافت کتاب‌ها به ازای هر متصدی");
                break;
            case 4:
                System.out.println("مشاهده ۱۰ کتاب پرامانت در یک سال اخیر");
                break;
            default:
                System.out.println("گزینه نامعتبر!");
        }
    }
}


   
    
}
