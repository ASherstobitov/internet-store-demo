package com.alexey.demo.repository;

import com.alexey.demo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Product> getProducts() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Product> theQuery =
                currentSession.createQuery("from Product order by nameProduct");

        List<Product> products = theQuery.getResultList();

        return products;
    }

    @Override
    public void saveProduct(Product theProduct) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theProduct);
    }

    @Override
    public Product getProduct(long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product theProduct = currentSession.get(Product.class, theId);
        return theProduct;
    }

    @Override
    public void deleteProduct(long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Product> theQuery =
                currentSession.createQuery("delete from Product where id=:theProductId");
        theQuery.setParameter("theProductId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public List<Product> searchProduct(String theNameProduct) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;


        if (theNameProduct != null && theNameProduct.trim().length() > 0) {

            theQuery =currentSession.createQuery("from Product where lower(nameProduct) like :theName");
            theQuery.setParameter("theName", "%" + theNameProduct.toLowerCase() + "%");

        }
        else {

            theQuery =currentSession.createQuery("from Product");
        }

        List<Product> products = theQuery.getResultList();

        return products;
    }
}
