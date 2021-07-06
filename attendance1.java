  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
   {                                       
        String day=(String) Day.getSelectedItem();
        String month=(String)Month.getSelectedItem();
        String year=(String)Year.getSelectedItem();
        String date =year + "-"+ month +"-"+ day;
        int total=Integer.parseInt(Total.getText());
        int present=Integer.parseInt(Present.getText());
        int leave=Integer.parseInt(Leave.getText());
        int sick=Integer.parseInt(Sick.getText());
        int od=Integer.parseInt(OD.getText());
        
        try
           {
               Class.forName("java.sql.DriverManager");
               Connection con=(Connection)DriverManager.getConnection
                                                             ("jdbc:mysql://localhost:3306/student","root","password");
               Statement stmt=(Statement)con.createStatement();
               String query="Select * from Admission where Relieved ='NO';";
               ResultSet rs = stmt.executeQuery(query);
               int check=present+leave+sick+od;
               int count = 0;       //to check the total entered by the user is correct
               while (rs.next())
                  {
                       count++;
                  }
               if(count<total)
                  {
                        JOptionPane.showMessageDialog(this,"Please Enter Details of Fresher ");
                        new SAdmission().show();
                        this.setVisible(false);
                  }
                
               else if (count>total)
                 {
                     String admno1;
                     for(int i=count;count>total;i--)
                      {
                         admno1 = JOptionPane.showInputDialog(this,"Enter AdmNo. of the Student Relieved");
                         try
                             {
                                 Class.forName("java.sql.DriverManager");
                                 Connection con1 = (Connection)DriverManager.getConnection
                                                                                ("jdbc:mysql://localhost:3306/student", "root","password");
                                 Statement stmt1 = (Statement)con1.createStatement();
                                 String query1="UPDATE Admission set Relieved='YES' WHERE Admno='"+admno1+"';";
                                 stmt1.executeUpdate(query1);
                             } 
                         catch(Exception e)
                             {
                                 JOptionPane.showMessageDialog(this,e.getMessage());
                             }
                      }
                 }         
              
               
               else if(check!=total)
                   {
                       JOptionPane.showMessageDialog(this,"Please check the Attendance");
                   }

               if(leave>0)   //gets the Admno of Student on leave
                  {
                        String admno2;
                        for(int i=leave;i>0;i--)
                          {
                              admno2=JOptionPane.showInputDialog(this,"Enter Admno. of the Student on Leave");
                                try
                                {
                                    Class.forName("java.sql.DriverManager");
                                    Connection con2=(Connection)DriverManager.getConnection
                                                                                  ("jdbc:mysql://localhost:3306/student","root","password");
                                    Statement stmt2=(Statement)con2.createStatement();
                                    String query2="UPDATE Admission set OnLeave=OnLeave+1 
                                                                                                        WHERE Admno='"+admno2+"';";
                                    stmt2.executeUpdate(query2);
                                } 
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(this,e.getMessage());
                                }
                          }
                   }    
               if(sick>0)       //gets the Admno of Student on Sick
                  {
                      String admno3;
                        for(int i=sick;i>0;i--)
                          {
                              admno3=JOptionPane.showInputDialog(this,"Enter Admno. of the Sick Student");
                                try
                                {
                                    Class.forName("java.sql.DriverManager");
                                    Connection con3=(Connection)DriverManager.getConnection
                                                                         ("jdbc:mysql://localhost:3306/student", "root","password");
                                    Statement stmt3=(Statement)con3.createStatement();
                                    String query3="UPDATE Admission set Sick=Sick+1 WHERE Admno='"+admno3+"';";
                                    stmt3.executeUpdate(query3);
                                } 
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(this,e.getMessage());
                                }
                         }
                  }
               if(od>0)     //  //gets the Admno of Student on OD
                  {
                      String admno4;
                        for(int i=od;i>0;i--)
                          {
                              admno4=JOptionPane.showInputDialog(this,"Enter Admno. of the OD Student ");
                                try
                                {
                                    Class.forName("java.sql.DriverManager");

                                    Connection con4=(Connection)DriverManager.getConnection
                                                                            ("jdbc:mysql://localhost:3306/student", "root","password");
                                    Statement stmt4=(Statement)con4.createStatement();
                                    String query4="UPDATE Admission set OD=OD+1 WHERE Admno='"+admno4+"';";
                                    stmt4.executeUpdate(query4);
                                } 
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(this,e.getMessage());
                                }
                         }
                  } 
               if(count==total)    // if entered total is coorect attendance gets saved
                 {         
                        try
                             {
                                 Class.forName("java.sql.DriverManager");
                                 Connection con5=(Connection)DriverManager.getConnection
                                                                                      ("jdbc:mysql://localhost:3306/student", "root","password");
                                 Statement stmt5=(Statement)con5.createStatement();
                                 String query5="INSERT INTO Attendance values
                                                                        ('"+date+"','"+total+"','"+present+"','"+leave+"','"+sick+"','"+od+"');";
                                 stmt5.executeUpdate(query5);
                                 JOptionPane.showMessageDialog(this,"Attendance is Saved");
                                 Total.setText("");
                                 Present.setText("");
                                 Leave.setText("");
                                 Sick.setText("");
                                 OD.setText("");
                                 Day.setSelectedIndex(0);
                                 Month.setSelectedIndex(0);
                                 Year.setSelectedIndex(0);
                             }
                          catch(Exception e)
                             {
                                      JOptionPane.showMessageDialog(this,e.getMessage());
                             }
                  }
            }      
        catch(Exception e)
           {
               JOptionPane.showMessageDialog(this,e.getMessage());
           }  
     }  

