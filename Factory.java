//Please comment each modification of this skeleton to highlight the code asked for this lab.

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Objects of class Factory represent a factory with two processing workshops.
 * A factory has a stock of products to process and, a stock of processed products (initially empty).
 * Both workshops process half of the products. The method activate() launch successively the two
 * workshops and then print the state of the stocks when the processing is finished.
 */
class Factory {
    /**
     * source stock
     */
    Stock sourceStock = new Stock("source", 10);
    /**
     * destination stock
     */
    Stock destinationStock = new Stock("destin", 0);
    /**
     * 
     * processing workshops
     */
    Workshop workshop1 = new Workshop(sourceStock, destinationStock, 5);
    Workshop workshop2 = new Workshop(sourceStock, destinationStock, 5);


    /**
     * Launch the factory work
     */
    public void activate() {

        sourceStock.print();
        destinationStock.print();
        workshop1.start();
        workshop2.start();
        try { workshop1.join(); } catch(InterruptedException e) {}
        try { workshop2.join(); } catch(InterruptedException e) {}
        sourceStock.print();
        destinationStock.print();
    }

    /**
     * Entry point for the lab
     * @param args Not used
     */
    public static void main(String[] args) {

        //Get Timestamp
        String timeStampStart = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println(timeStampStart);


        Factory f1 = new Factory();
        f1.activate();

        //Get Timestamp
        String timeStampEnd = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println(timeStampEnd);
    }
}
