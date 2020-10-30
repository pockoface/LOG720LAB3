package ca.etsmtl.log720.lab3.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernate {
	private static final SessionFactory sf = create();
	
	private static SessionFactory create() {
		try{
			return new Configuration().configure().buildSessionFactory();
		}
		catch(Exception e){
            System.err.println("Failed to instatiate session please try again." + e);
            throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory session(){
		return sf;
	}
	
}