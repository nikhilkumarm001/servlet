package dao;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.border.EtchedBorder;

import java.util.*;

import dto.Studentdto;

public class Studentdao {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();

//To create the table in database and add the data into that created table...
public String create(Studentdto d1) {
	entityTransaction.begin();
	entityManager.persist(d1);
	entityTransaction.commit();
	
	return "Data inserted Successfully";
}

//To delete The data in table...
public String delete(int d1) {
	Studentdto std=entityManager.find(Studentdto.class, d1);
	if(std!=null) {
		entityTransaction.begin();
		entityManager.remove(std);
		entityTransaction.commit();
		return "data deleted Successfully";
	}
	return "data not found";
}


//To update The data in table...
public String update(int id,long pno) {
	Studentdto d1=entityManager.find(Studentdto.class, id);
	if(d1!=null) {
	d1.setPh_no(pno);
	entityTransaction.begin();
	entityManager.merge(d1);
	entityTransaction.commit();
	return "The data updated Successfully";
}
	else {
		return "The data not found and not Updated..";
	}
}

//To fetch The data from table...
public String fetch(int id) {
	Studentdto d1=entityManager.find(Studentdto.class, id);
	if(d1!=null) {
		entityTransaction.begin();
		entityManager.contains(d1);
		entityTransaction.commit();
		return " Student id is -> "+d1.getStd_id()+"\n"+ " Student name is -> "+d1.getStd_name()+"\n"+" Student gender is -> "+d1.getGender()+"\n"+" phone Number of Student is -> "+d1.getPh_no();
	}else {
		return "DNF";
	}
}

//To fetch The data from table by using id...
public Studentdto fetchbyid(int id) {
	Studentdto d1=entityManager.find(Studentdto.class, id);
	return d1;
}


//To fetch  The data from table by using httpservlet...
public Object fetchid(int id) {
	Studentdto d1=entityManager.find(Studentdto.class, id);
	if(d1!=null) {
	return d1;
}else {
	return "Data Not Found";
}
} 


//To fetch all The data from table.../
public List<Studentdto> fetchall() {
	Query q1=entityManager.createQuery("select data from Studentdto data");
	List<Studentdto> list=q1.getResultList();
	return list;
}

//URL rewriting is one of the type of  Session tracking...to delete data by id
public void urldelete(int id) {
	Studentdto S1=entityManager.find(Studentdto.class, id);
	entityTransaction.begin();
	entityManager.remove(S1);
	entityTransaction.commit();
}

//URL rewriting Update using another jsp file here we connect one jsp file with another by using anchor tag
public void updating(Studentdto d1) {
	entityTransaction.begin();
	entityManager.merge(d1);
	entityTransaction.commit();
}
}

