/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Benjamin Crew
 */
public class Inventory {
    public static Part selectedPart;
    public static Product selectedProduct;

    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;
    
    private int nextPartId;
    private int nextProductId;
    
    private Inventory() {
        allParts = FXCollections.observableArrayList();
        allProducts = FXCollections.observableArrayList();

        nextPartId = 0;
        nextProductId = 0;
    }
    
    public static Inventory getInstance() {
        return InventoryHolder.INSTANCE;
    }
    
    private static class InventoryHolder {
        private static final Inventory INSTANCE = new Inventory();
    }
    
    public void addPart(Part newPart) {
        allParts.add(newPart);
        nextPartId++;
    }

    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
        nextProductId++;
    }

    public boolean deletePart (Part selectedPart) {
        return allParts.remove(selectedPart);
    }

    public boolean deleteProduct (Product selectedProduct) {
        return allProducts.remove(selectedProduct);
    }
    
    public int getNextPartId () {
        return nextPartId;
    }

    public int getNextProductId () {
        return nextProductId;
    }

    public ObservableList<Part> getAllParts () {
        return this.allParts;
    }

    public ObservableList<Product> getAllProducts () {
        return this.allProducts;
    }    
    
    public Part lookupPart(int partId) {
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getId() == partId)
                return allParts.get(i);
        }

        return null;
    }

    public Product lookupProduct(int productId) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getId() == productId)
                return allProducts.get(i);
        }

        return null;
    }

    public ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> lookupList = FXCollections.observableArrayList();

        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getName().toUpperCase().contains(partName.toUpperCase()))
                lookupList.add(allParts.get(i));
        }

        return lookupList;
    }

    public ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> lookupList = FXCollections.observableArrayList();

        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getName().toUpperCase().contains(productName.toUpperCase()))
                lookupList.add(allProducts.get(i));
        }

        return lookupList;
    }

    public void updatePart (int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }
    
    public void updateProduct (int index, Product newProduct) {
        allProducts.set(index, newProduct);
    }
}