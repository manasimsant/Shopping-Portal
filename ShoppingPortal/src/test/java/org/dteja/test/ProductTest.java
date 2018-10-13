package org.dteja.test;

import static org.junit.Assert.assertTrue;

import org.dteja.dao.ProductDAO;
import org.dteja.models.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTest {

	static ProductDAO productdao;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.dteja");
		context.refresh();

		ProductDAO productdao = (ProductDAO) context.getBean("productdao");
	}

	@Test
	public void addProduct() {

		Product product = new Product();
		product.setProductid(101);
		product.setProductname("Leggings");
		product.setProductdescription("Very comfortable leggings");
		product.setPrice(270);
		product.setQuantity(8);
		assertTrue("Problem in adding product", productdao.addProduct(product));
	}
	
	
	
	
}
