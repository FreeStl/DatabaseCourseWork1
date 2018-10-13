package com.company;

import java.sql.*;

public class PrepStat {
    private static final String userName = "root";
    private static final String password = "4647";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/" +
            "medicbase?verifyServerCertificate=false&useSSL=false" +
            "&useUnicode=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";

	static void userOutDate1(){
        try(Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);){
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL UserOutDateList1()");
            if (cs.execute()){
                int count = 0;
                ResultSet rs = cs.getResultSet();
                while (rs.next()){
                    System.out.print(rs.getString("Surname")+" ");
                    System.out.print(rs.getString("Name")+" ");
                    System.out.print(rs.getString("MidName")+"  ");
                    System.out.print(rs.getString("Number")+"  ");
                    System.out.print(rs.getString("Adress")+"  ");
                    System.out.print(rs.getString("Age")+"  ");
                    System.out.println("Receive Date: " + rs.getDate("Receive Date"));
                    count++;
                }
                System.out.println("User count: "+count);
            }

        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }

    static void userWait2() {
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL UserWaiting2()");
            if (cs.execute()) {
                int count = 0;
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getString("Surname") + " ");
                    System.out.print(rs.getString("Name") + " ");
                    System.out.print(rs.getString("MidName") + "  ");
                    System.out.print(rs.getString("Number") + "  ");
                    System.out.print(rs.getString("Adress") + "  ");
                    System.out.println(rs.getString("Age") + "  ");
                    count++;
                }
                System.out.println("User count: " + count);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void userWait2(String medClass) {
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL UserWaitingCategory2(?)");
            cs.setString(1,medClass);
            if (cs.execute()) {
                int count = 0;
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getString("Surname") + " ");
                    System.out.print(rs.getString("Name") + " ");
                    System.out.print(rs.getString("MidName") + "  ");
                    System.out.print(rs.getString("Number") + "  ");
                    System.out.print(rs.getString("Adress") + "  ");
                    System.out.println(rs.getString("Age") + "  ");
                    count++;
                }
                System.out.println("User count: " + count);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void popularMedsTop3() {
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL PopularMedsTop3()");
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Meds Name: "+rs.getString("Name") + ", ");
                    System.out.println(rs.getInt(2)+" Sold");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void popularMedsTop3(String medClass) {
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL PopularMedsTopByCategory3(?)");
            cs.setString(1,medClass);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Meds Name: "+rs.getString("Name") + ", ");
                    System.out.println(rs.getInt(2)+" Sold");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void medsUsedForPeriod4(String medName, long from, long till) {
	    Date frm = new Date(from);
        Date tll = new Date(till);

        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsUsedForPeriod4(?,?,?)");
            cs.setString(1,medName);
            cs.setDate(2,frm);
            cs.setDate(3,tll);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                if (rs.next())
                System.out.println(medName+" used/sold "+rs.getInt(1) + " times");
                else System.out.println(medName+" never used/sold");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void userOrderList5(String medName, long from, long till) {
        Date frm = new Date(from);
        Date tll = new Date(till);

        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL UserOrderList5(?,?,?)");
            cs.setString(1,medName);
            cs.setDate(2,frm);
            cs.setDate(3,tll);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getString("Surname") + " ");
                    System.out.print(rs.getString("Name") + " ");
                    System.out.print(rs.getString("MidName") + "  ");
                    System.out.print(rs.getString("Number") + "  ");
                    System.out.print(rs.getString("Adress") + "  ");
                    System.out.println(rs.getString("Age") + "  ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void userOrderListCategory5(String CatName, long from, long till) {
        Date frm = new Date(from);
        Date tll = new Date(till);

        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL UserOrderListCategory5(?,?,?)");
            cs.setString(1,CatName);
            cs.setDate(2,frm);
            cs.setDate(3,tll);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getString("Surname") + " ");
                    System.out.print(rs.getString("Name") + " ");
                    System.out.print(rs.getString("MidName") + "  ");
                    System.out.print(rs.getString("Number") + "  ");
                    System.out.print(rs.getString("Adress") + "  ");
                    System.out.println(rs.getString("Age") + "  ");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void outOfMeds67(int crit) {
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL OutOfMeds6(?)");
            cs.setInt(1,crit);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getString("Name") + ", ");
                    System.out.println("Caterogy: "+rs.getString("Class"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void outOfMeds67(String ctgr, int crit) {
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL OutOfMedsCategory6(?,?)");
            cs.setString(1,ctgr);
            cs.setInt(2,crit);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print(rs.getString("Name") + ", ");
                    System.out.println("Caterogy: "+rs.getString("Class"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void ordersInProd8(){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL OrdersInProd8()");
            if (cs.execute()) {
                int count = 0;
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Order number: "+rs.getString("id") + ", ");
                    System.out.print("Patient: "+rs.getString("p.Name")
                            +" "+rs.getString("p.Surname")+", ");
                    System.out.print("Doctor: "+rs.getString("d.Name")+" "
                            +rs.getString("d.Surname")+", ");
                    System.out.print("Medicines: "+rs.getString("m.Name")+", ");
                    System.out.println("Creation Date: "+rs.getString("Creation Date"));
                    count++;
                }
                System.out.println("Total: "+count);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void medsComponents9(){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsComponents9()");
            if (cs.execute()) {
                int count = 0;
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.println("Medicine name: "+rs.getString(1));
                    count++;
                }
                System.out.println("Total: "+count);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void medsTechnology10(){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsTechnologyOnProd10()");
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Technology name: "+rs.getString(1)+"; ");
                    System.out.print("Days to make: "+rs.getString(2)+"; ");
                    System.out.println("Information: "+rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void medsTechnology10(String name){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsTechnology10(?)");
            cs.setString(1,name);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Technology name: "+rs.getString(1)+"; ");
                    System.out.print("Days to make: "+rs.getString(2)+"; ");
                    System.out.println("Information: "+rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void medsTechnologyCategory10(String ctgr){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsTechnologyCategory10(?)");
            cs.setString(1,ctgr);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Technology name: "+rs.getString(1)+"; ");
                    System.out.print("Days to make: "+rs.getString(2)+"; ");
                    System.out.println("Information: "+rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void medsPrice11(String name){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsPrice11_13(?)");
            cs.setString(1,name);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Class: "+rs.getString("Class")+"; ");
                    System.out.print("Amount: "+rs.getString("Amout")+"; ");
                    System.out.print("Price: "+rs.getString("Price")+"; ");
                    System.out.print("Technology: "+rs.getString("Name")+"; ");
                    System.out.print("Days: "+rs.getString("Days")+"; ");
                    System.out.println("Info: "+rs.getString("info"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    static void compPrice11(String name){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL CompPrice11_13(?)");
            cs.setString(1,name);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Component name: "+rs.getString(1)+"; ");
                    System.out.print("Price: "+rs.getString(2)+"; ");
                    System.out.println("Amount: "+rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    static void medsInfo13(String name){
        try (Connection conn = DriverManager.getConnection(connectionURL,
                userName, password);) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            CallableStatement cs = conn.prepareCall("CALL MedsPrice11_13(?)");
            cs.setString(1,name);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Class: "+rs.getString("Class")+"; ");
                    System.out.print("Amount: "+rs.getString("Amout")+"; ");
                    System.out.print("Price: "+rs.getString("Price")+"; ");
                    System.out.print("Technology: "+rs.getString("Name")+"; ");
                    System.out.print("Days: "+rs.getString("Days")+"; ");
                    System.out.println("Info: "+rs.getString("info"));
                }
            }
            cs = conn.prepareCall("CALL CompPrice11_13(?)");
            cs.setString(1,name);
            if (cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    System.out.print("Component name: "+rs.getString(1)+"; ");
                    System.out.print("Price: "+rs.getString(2)+"; ");
                    System.out.println("Amount: "+rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}

