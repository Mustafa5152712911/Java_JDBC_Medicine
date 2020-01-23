import java.sql.*;
import java.util.*;
import java.io.*;



public class Medicine {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        ResultSet rs=null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory", "root", "enya");

    do {
     System.out.println("Press 1 Enter the Details of Medicines");
     System.out.println("Press 2 Delete Records of Medicine");
     System.out.println("Press 3 Update the Details of Medicines");
     System.out.println("Press 4 View all the details of Medicines");
     System.out.println("Press 5 to EXIT");
     System.out.println("Enter your choice");
     int  ch=Integer.parseInt(sc.nextLine());

    switch (ch)
    {
        case 1:
            System.out.println("Enter the Code of the Medicine");
            String Code = sc.nextLine();
            System.out.println("Enter the Name of the Medicine");
            String Name = sc.nextLine();
            System.out.println("Enter the Brand of the Medicine ");
            String Brand = sc.nextLine();
            System.out.println("Enter the Description of the Medicine ");
            String Description = sc.nextLine();
            System.out.println("Enter the Rate of the Medicine");
            String Rate= sc.nextLine();

            try {

                String query="Insert into Medicine values('"+Code+"','"+Name+"','"+Brand+"','"+Description+"','"+Rate+"')";
                 Statement stmt=con.createStatement();
                 stmt.executeUpdate(query);
                System.out.println("row inserted...");

            } catch (Exception ex)
            {
                System.out.println(ex);
            }
break;


       //*****************************************************************


        case 2:
            System.out.println("Enter the Name of the Medicine that you wanna to Delete from Database");
            String medicine= sc.nextLine();

            try {

                String query="Delete from Medicine where name='"+medicine+"'";
                Statement stmt=con.createStatement();
                stmt.executeUpdate(query);
                System.out.println("Record Deleted Successfully....");

            } catch (Exception ex)
            {
                System.out.println(ex);
            }
break;
          //******************************************************************

        case 3:
            System.out.println("Name the Field in the Medicine Table, that you wanna to Update");
            String field= sc.nextLine();
            System.out.println("Enter the value that you wanna to set");
            String set= sc.nextLine();
            System.out.println("Name the Field in the Medicine Table where you wanna to change");
            String WhereFiled= sc.nextLine();
            System.out.println("Enter the Exciting Value that you wanna to replace with set value");
            String Exciting= sc.nextLine();



            try {

                String query="update Medicine set "+field+" ='"+set+"' where  "+WhereFiled+" = '"+Exciting+"' ";
                Statement stmt=con.createStatement();
                 stmt.executeUpdate(query);
                System.out.println("Record Updated Successfully....");

            } catch (Exception ex)
            {
                System.out.println(ex);
            }

break;
            //********************************************************************


        case 4:

            try {

                String query="select code,name,brand,description,rate from Medicine";
                Statement stmt=con.createStatement();
                rs= stmt.executeQuery(query);
                //stmt.executeQuery(query);
                boolean record=rs.next();
                while(!record)
                {
                    System.out.println("no record");
                }

                do
                {
                    String code=rs.getString(1);
                    String name=rs.getString(2);
                    String brand=rs.getString(3);
                    String description=rs.getString(4);
                    String rate=rs.getString(5);
                    System.out.print(code+"\t");
                    System.out.print(name+"\t");
                    System.out.println(brand+"\t");
                    System.out.println(description+"\t");
                    System.out.println(rate+"\t");

                }while(rs.next());

            } catch (Exception ex)
            {
                System.out.println(ex);
            }

break;
            //******************************************************


        case 5:
            System.exit(1);
            break;

        default:
            System.out.println("iam default");



    }
        System.out.println("do u want to continue(yes /no)");
        String str=sc.nextLine();
        if(str.equals("yes")|| str.equals("y"))
              flag=true;
        if(str.equals("no")||str.equals("no"))
             flag=false;
    }while (true);

    }
}