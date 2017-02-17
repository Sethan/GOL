/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author ZuraH
 */
public class FileHandler {
    
    public static void loadFile(CellGraph cg)
    {   
        try
        {
            JButton open = new JButton();
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Object File", "dat");
            fc.setFileFilter(filter);
            if(fc.showOpenDialog(open)== JFileChooser.APPROVE_OPTION)
            {
                String fullPath = fc.getSelectedFile().getAbsolutePath();
                
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(fullPath));
                Boolean[][] loadCopy = (Boolean[][]) is.readObject();
                if(loadCopy.length==cg.getW()&&loadCopy[0].length==cg.getH())
                {
                    
                    for(int i=0; i<cg.getW();i++)
                    {
                        for(int n=0; n<cg.getH(); n++)
                        {
                            if(loadCopy[i][n]!=cg.table[i][n].isAlive())
                            {
                                cg.table[i][n].changeState();
                            }
                        }
                    }
                }
                else
                {
                    System.err.println("Wrong dimensions");
                }
            }  
        }
        catch(Exception e)
        {
            System.err.println("Error reading data");
        }
    }
    public static void saveFile(CellGraph cg ) 
    {
        try
        {
         
            JButton save = new JButton();
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Java Object File", "dat"));
            if(fc.showSaveDialog(save)==JFileChooser.APPROVE_OPTION)
            {
                String fullPath = fc.getSelectedFile().getAbsolutePath();
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fullPath));
                Boolean[][] saveCopy = new Boolean[cg.getW()][cg.getH()];
                
                
                for(int i=0; i<cg.getW();i++)
                {
                    for(int n=0; n<cg.getH(); n++)
                    {
                        saveCopy[i][n]=cg.table[i][n].isAlive();
                    }
                }
                
                os.writeObject(saveCopy);
            }
        }
        catch(Exception e)
        {
            System.err.println("Error is " + e.toString());
        }
    }
}
