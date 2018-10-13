package org.dteja.ShoppingPortal;

import org.dteja.config.DBConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String args[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	}
}
