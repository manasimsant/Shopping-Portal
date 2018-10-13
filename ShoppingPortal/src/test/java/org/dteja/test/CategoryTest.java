package org.dteja.test;

import static org.junit.Assert.assertTrue;

import org.dteja.dao.CategoryDAO;
import org.dteja.models.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class CategoryTest {
	static CategoryDAO categorydao;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.dteja");
		context.refresh();
		categorydao = (CategoryDAO) context.getBean("categoryDao");
	}
	
	@Ignore
	@Test
	public void addCategory() {
		Category category = new Category();
		category.setCategoryid(001);
		category.setCategoryname("KURTI");
		category.setCategorydescription("These are fashioned Kurtis");
		assertTrue("Problem in adding category", categorydao.addCategory(category));
	}

}
