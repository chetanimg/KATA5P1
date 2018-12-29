package kata_p1;

public class Kata5 {
     public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
        CreateBD.createNewDatabase("mail.db");
        CreateTable.createNewTable();
        InsertDataInTable idt = new InsertDataInTable();
        idt.refill();
        SelectAppMail app2 = new SelectAppMail();
        app2.selectAll();
    }
}
