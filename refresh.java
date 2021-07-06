private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
 {                                       
        DefaultTableModel model1 = (DefaultTableModel) STable1.getModel();
       DefaultTableModel model2 = (DefaultTableModel) STable2.getModel();


     try
     {
            Class.forName("java.sql.DriverManager");
            Connection con=(Connection)DriverManager.getConnection
                                                          ("jdbc:mysql://localhost:3306/student","root","password");
            Statement stmt=(Statement)con.createStatement();
            String query1="",  admno;
            if(jRadioButton1.isSelected())       
                query1="Select * from Admission;";
            else if(jRadioButton2.isSelected())
            {
                admno=JOptionPane.showInputDialog(this,"Enter Admission Number");
                query1="Select * from Admission where AdmNo='"+admno+"';";
            }
                ResultSet rs1 =stmt.executeQuery(query1);
                while(rs1.next())
                {
                        String date =rs1.getString("DOA");
                        String sclass=rs1.getString("Class");
                        String admno1=rs1.getString("Admno");
                        String sname=rs1.getString("StudentName");
                        String fname=rs1.getString("FatherName");
                        String mname=rs1.getString("MotherName");
                        String gname =rs1.getString("GuardianName");
                        String address=rs1.getString("Address");
                        String phone=rs1.getString("Phone");
                        String email=rs1.getString("Email");
                        String house=rs1.getString("House");
                        String fstatus=rs1.getString("FinancialStatus");
                        int onleave=rs1.getInt("OnLeave");
                        int sick=rs1.getInt("Sick");
                        int od=rs1.getInt("OnDuty");
                        String relieved=rs1.getString("Relieved");
                        model1.addRow(new Object[] 
                                                       {sname,date,sclass,admno1,fname,mname,gname,address,phone,email});
                        model2.addRow(new Object[] {fstatus,house,onleave,sick,od,relieved});
                
                }
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(this,e.getMessage());
     }
}                                         

