/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop.service;

import bookshop.entity.Editorial;
import bookshop.persistence.EditorialDAO;
import java.util.Collection;

/**
 *
 * @author Exequiel Hordt
 * @version 22 Jan 2023
 */
public class EditorialService {
    
    private EditorialDAO DAO;
    
    public EditorialService() {
        
        this.DAO = new EditorialDAO();
        
    }

    //Save Record
    public void save(String name) throws Exception {
        try {
            
            if (name.trim().isEmpty() || name == null) {
                
                throw new Exception("Debe indicar un nombre");
                
            }
            Editorial editorial = new Editorial();
            editorial.setName(name);
            DAO.save(editorial);
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }

    //Validate if is a Duplicate Record
    public void isDuplicate(String name) throws Exception {
        
        try {
            
            Collection<Editorial> editorials = DAO.print();
            
            if (!editorials.isEmpty() || editorials != null) {
                for (Editorial editorial : editorials) {
                    if (editorial.getName().equalsIgnoreCase(name)) {
                        throw new Exception("El nombre ya se encuentra en la base de datos");
                    }
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }

    //Print Record
    public void print() throws Exception {
        
        try {
            
            boolean flag = false;
            Collection<Editorial> editorials = DAO.print();
            if (editorials.isEmpty() || editorials == null) {
                
                throw new Exception("No existen registros");
                
            }
            
            for (Editorial editorial : editorials) {
                if (editorial.isStatus() == true) {
                    flag = true;
                    System.out.println(editorial);
                    System.out.println("");
                    
                }
                
            }
            
            if (flag == false) {
                
                throw new Exception("No existen registros");
                
            }
            
        } catch (Exception e) {
            
            throw e;
            
        }
        
    }

    //Search by Name
    public Editorial byName(String name) throws Exception {
        
        try {
            
            if (name.trim().isEmpty() || name == null) {
                
                throw new Exception("Debe indicar un nombre");
                
            }
            Editorial editorial = DAO.byName(name);
            if (editorial.isStatus() == false || editorial == null) {
                
                throw new Exception("No existe registro");
                
            }
            return editorial;
            
        } catch (Exception e) {
            
            throw e;
            
        }
    }
    
}
