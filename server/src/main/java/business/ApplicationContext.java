package business;

import business.discount.DiscountDAO;
import business.discount.DiscountDAOJdbc;

public class ApplicationContext {
    private DiscountDAO discountDAO;
    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        discountDAO = new DiscountDAOJdbc();
    }

    public DiscountDAO getDiscountDAO() {return discountDAO;}
}
