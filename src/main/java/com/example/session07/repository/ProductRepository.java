package com.example.session07.repository;

import com.example.session07.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from Product", Product.class).list();
        }catch (Exception e) {
            return null;
        }
    }

    public Product findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(Product.class, id);
        }catch (Exception e) {
            return null;
        }
    }

    public boolean save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Product product = findById(id);
            if (product != null) {
                session.delete(product);
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }

    public boolean checkProductNameExists(String productName) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.createQuery("from Product where productName = :productName",Product.class)
                .setParameter("productName", productName).uniqueResult();
        return product != null;
    }

}
