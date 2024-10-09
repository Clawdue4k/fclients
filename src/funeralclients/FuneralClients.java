package funeralclients;
import java.util.Scanner;
public class FuneralClients {
   
    public void addClients(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Clients ID: ");
        int id = sc.nextInt();
        System.out.print("Clients First Name: ");
        String fname = sc.next();
        System.out.print("Clients Last Name: ");
        String lname = sc.next();
        System.out.print("Cliets Date of birth: ");
        String cdob = sc.next();
        System.out.print("Clients Date of death: ");
        String cdod = sc.next();
        System.out.print("Clients cause of death: ");
        String ccod = sc.next();

        String sql = "INSERT INTO Clients (c_id, c_fname, c_lname, c_dateofbirth, c_dateofdeath, c_causeofdeath) VALUES (?, ?, ?, ?, ?, ?)";

        conf.addRecord(sql, id, fname, lname, cdob, cdod, ccod);
    }
    
     public void updateClients(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter Clients ID to Update: ");
         int id = sc.nextInt();
         
         System.out.print("Enter new Date of death: ");
         String cdod = sc.next();
         System.out.print("Enter new cause of death: ");
         String ccod = sc.next();
         
        String sql = "UPDATE Clients SET c_dateofdeath = ?, c_causeofdeath = ? WHERE c_id = ?";
        
        config conf = new config();
        conf.updateRecord(sql, cdod, ccod, id);
    }
     
    public void deleteClients(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter Clients ID to Delete: ");
         int id = sc.nextInt();
         
         String sql = "DELETE FROM Clients WHERE c_id = ?";
        
        config conf = new config();
        conf.updateRecord(sql, id);
    }
     
    public static void main(String[] args) {
        FuneralClients tls = new FuneralClients();
        config conf = new config();
        Scanner sc = new Scanner (System.in);
        int chose;
do{ 
        System.out.println("------Welcome To Clients Funeral System----");
        System.out.println("1. Add Clients ");
        System.out.println("2. View Clients");
        System.out.println("3. Update Clients");
        System.out.println("4. Delete Clients");
        System.out.println("5. Exit");
        System.out.print("Enter Action: ");
        int act = sc.nextInt();
       
        switch(act){
            case 1:
                tls.addClients();
            break;

            case 2:
                System.out.println("\nList of Clients");
                conf.viewClients();
                break;

            case 3:
                System.out.println("\nList of Clients");
                conf.viewClients();
                tls.updateClients();
                break;

            case 4:
                System.out.println("\nList of Clients");
                conf.viewClients();
                tls.deleteClients();
                break;

            case 5:
                System.out.println("Exiting");
                break;

            default:
                System.out.println("Action Error!");
        }
        System.out.print("Enter Again: ");
        chose = sc.nextInt();
        
}while(chose != 0);
        System.out.println("Thank You!");
    }

}
