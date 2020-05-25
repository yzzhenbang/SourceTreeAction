	

        add func1

	package com.dairy.sell.service;
 
	import com.dairy.sell.dataobject.ProductCategory;
 
	import java.util.List;
 

	public interface CategoryService {
	    ProductCategory findOne(Integer categoryId);
	    List<ProductCategory> findAll();
	    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeId);
	    ProductCategory save(ProductCategory productCategory);
 
	}
        
        add func2

	
	package com.dairy.sell.service.impl;
 
	import com.dairy.sell.dataobject.ProductCategory;
	import com.dairy.sell.repository.ProductCategoryRepository;
	import com.dairy.sell.service.CategoryService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
 
	import java.util.List;
	@Service
	public class CategoryServiceImpl implements CategoryService {
	    @Autowired
	    private ProductCategoryRepository productCategoryRepository;
	    @Override
	    public ProductCategory findOne(Integer categoryId) {
	        return productCategoryRepository.findByCategoryId(categoryId);
 
	    }
 
	    @Override
	    public List<ProductCategory> findAll() {
	        return productCategoryRepository.findAll();
	    }
 
	    @Override
	    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeId) {
	        return productCategoryRepository.findByCategoryTypeIn(categoryTypeId);
	    }
 
	    @Override
	    public ProductCategory save(ProductCategory productCategory) {
	        return productCategoryRepository.save(productCategory);
	    }
	}
 
         add func3
	
 
	package com.dairy.sell.service.impl;
 
	import com.dairy.sell.dataobject.ProductCategory;
	import org.junit.Assert;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.annotation.Rollback;
	import org.springframework.test.context.junit4.SpringRunner;
	import org.springframework.transaction.annotation.Transactional;
 
	import java.util.Arrays;
	import java.util.Date;
	import java.util.List;
 
	import static org.junit.Assert.*;
 
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class CategoryServiceImplTest {
 
	    @Autowired
	    private CategoryServiceImpl categoryService;
add func1
	    @Test
	    public void findOne() {
	        ProductCategory productCategory = categoryService.findOne(1);
	        Assert.assertNotEquals(new Integer(2), productCategory.getCategoryId());
	    }
add func2
	    @Test
	    public void findAll() {
	        List<ProductCategory> productCategory = categoryService.findAll();
	        Assert.assertNotEquals(0, productCategory.size());
 
 
	    }
add func3
	    @Test
	    public void findByCategoryTypeIn() {
	        List<Integer> list = Arrays.asList(1, 2, 3, 4);
	        List<ProductCategory> productCategory = categoryService.findByCategoryTypeIn(list);
	        Assert.assertNotEquals(0, productCategory.size());
	    }
 
	    @Test
	    @Transactional
	    @Rollback(true)
	    public void save() {
	        ProductCategory productCategory = new ProductCategory(new Date(), new Date(), "аЌзг", new Integer(02));
 
	        ProductCategory productCategory1 = categoryService.save(productCategory);
	        Assert.assertNotNull(productCategory1);
	    }
	}