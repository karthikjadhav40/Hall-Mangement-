 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
 {                                         

        String day =(String) Day.getSelectedItem();
        String month= (String) Month.getSelectedItem();
        String year=(String) Year.getSelectedItem();
        String date =year + "-" + month + "-" + day;
        String sclass=(String)SClass.getSelectedItem();
        String admno=AdmNo.getText();
        String sname=SName.getText();
        String fname=FName.getText();
        String mname=MName.getText();
        String gname =GName.getText();
        String address=Address.getText();
        String phone=Phone.getText();
        String email=Email.getText();
        String hm=HM.getText();
        String house=(String)House.getSelectedItem();
        String fstatus=(String)FStatus.getSelectedItem();
        if(Day.getSelectedIndex()==0)
        JOptionPane.showMessageDialog(this,"Please select Day");
        if(Month.getSelectedIndex()==0)
        JOptionPane.showMessageDialog(this,"Please select Month");
        if(Year.getSelectedIndex()==0)
        JOptionPane.showMessageDialog(this,"Please select Year");
        if(SClass.getSelectedIndex()==0)
        JOptionPane.showMessageDialog(this,"Please select Class");
        if(House.getSelectedIndex()==0)
        JOptionPane.showMessageDialog(this,"Please select House");
        if(FStatus.getSelectedIndex()==0)
        JOptionPane.showMessageDialog(this,"Please select Financial Status");
        if(admno.isEmpty())                        
        JOptionPane.showMessageDialog(this,"Please enter AdmNo");
        if(sname.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter Student's Name");
        if(fname.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter Father's Name");
        if(mname.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter Mother's Name");
        if(address.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter Address");
        if(phone.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter PhoneNo");
        if(email.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter Email");
        if(hm.isEmpty())
        JOptionPane.showMessageDialog(this,"Please enter HMName");

        try
        {
            Class.forName("java.sql.DriverManager");
            Connection con=(Connection)DriverManager.getConnection
                                                 ("jdbc:mysql://localhost:3306/student","root","password");
            Statement stmt=(Statement)con.createStatement();
            String query="INSERT INTO Admission VALUES     
                                         ('"+date+"','"+admno+"','"+sname+"',
                                        '"+sclass+"','"+fname+"','"+mname+"','"+gname+"','"+house+"',
                                        '"+hm+"','"   +address+"','"+phone+"','"+email+"','"+fstatus+"',0,0,0,'NO');";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this,"YOUR ENTRY IS SAVED");
            SName.setText("");
            FName.setText("");
            MName.setText("");
            GName.setText("");
            Address.setText("");
            Phone.setText("");
            Email.setText("");
            AdmNo.setText("");
            HM.setText("");
            Day.setSelectedIndex(0);
            Month.setSelectedIndex(0);
            Year.setSelectedIndex(0);
            SClass.setSelectedIndex(0);
            House.setSelectedIndex(0);
            FStatus.setSelectedIndex(0);

        }

        catch (Exception o)
        {
            JOptionPane.showMessageDialog(this,o.getMessage());
        }

    }                                        


