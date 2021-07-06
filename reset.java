 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
{                                         
      DefaultTableModel model1=(DefaultTableModel) STable1.getModel();
      int rows1=model1.getRowCount();
      if(rows1>0)
        {
          for(int i = 0; i<rows1 ; i++)
              model1.removeRow(0);    //removes all the rows from the table
        }
      DefaultTableModel model2=(DefaultTableModel) STable2.getModel();
      int rows2=model2.getRowCount();
      if(rows2>0)
        {
          for(int i = 0; i<rows2 ; i++)
              model2.removeRow(0);    //removes all the rows from the table
        }
    }  

