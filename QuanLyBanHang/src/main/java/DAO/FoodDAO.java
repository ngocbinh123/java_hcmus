package DAO;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import pojo.*;
import util.HibernateUtil;
public class FoodDAO extends BaseDao{
	public static List<Food> getAllFoods() {

		 List<Food> flist = null;
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 try {
			 String hql = "select * from FOOD";
			 Query query = session.createQuery(hql);
			 flist = query.list();
		 } catch (HibernateException ex) {
			 //Log the exception
			 System.err.println(ex);
		 } finally {
			 session.close();
		 }
		 	return flist;
	}
}

