package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import phsanet.entitys.Products;
import phsanet.repositorys.provider.TemporaryproProvider;
import phsanet.util.Paging;
import phsanet.util.ProductFilter;

@Repository
@Qualifier("proudcttemporaryrepository")
public interface ProductTemporaryRepository {
	
	@SelectProvider(type=TemporaryproProvider.class, method = "selectPersonLike")
	//@Select(SQL.select_pagin)
	@Results({
		@Result(property="product_id" 										,	column="pro_id"),
		@Result(property="product_name" 									,	column="pro_name"),
		@Result(property="product_image" 									,	column="pro_image"),
		@Result(property="price"											,	column="pro_price"),
		@Result(property="description"										,	column="pro_description"),
		//@Result(property="link"							,	column="pro_link"),
		@Result(property="subcategory.subcategory_id"						,	column="sub_id"),
		@Result(property="subcategory.subcategory_name"						,	column="sub_category_name"),
		@Result(property="subcategory.description"							,	column="sub_description"),
		@Result(property="subcategory.category.category_name"				,	column="cat_name"),
		@Result(property="subcategory.category.main_category.category_name"	,	column="main_name"),
		@Result(property="web.web_source_id"								,	column="web_id"),
		@Result(property="web.website"										,	column="web_website"),
		@Result(property="web.url"											,	column="web_url"),
		@Result(property="web.logo"											,	column="web_logo")
	})
	public ArrayList<Products> findAll(@Param("filter") ProductFilter filter , @Param("paging") Paging paging);
	
	
	@Insert(SQL.INSERT_IGNORE)
	public boolean save(@Param("all_product") ArrayList<Products> all_product);
	
	@Update(SQL.UPDATE_SUBCATEGORY)
	public boolean update(Products product);
	
	@Select(SQL.FIND_INTO_PRODUCT)
	@Results({
		@Result(property="product_id" 										,	column="product_id"),
		@Result(property="product_name" 									,	column="product_name"),
		@Result(property="product_image" 									,	column="product_image"),
		@Result(property="price"											,	column="price"),
		@Result(property="description"										,	column="description"),
		@Result(property="subcategory.subcategory_id"						,	column="subcategory_id"),
		@Result(property="web.web_source_id"								,	column="web_source_id")
	})
	public Products find_into_product(int id);
	
	@Update(SQL.UPDATE_STATUS)
	public boolean update_status(@Param("status")String  status, @Param("id")int id);
	
	@Delete(SQL.REMOVE)
	public boolean remove(int id);
	
	//@Select(SQL.count)
	@SelectProvider(type=TemporaryproProvider.class, method = "selectcount")
	public long count(@Param("filter") ProductFilter filter);
	
	interface SQL{
		
			String INSERT_IGNORE="<script> Insert Into temporary_item "
					+ "	(	"
					+ "		subcategory_id				,"
					+ "		product_name				,"
					+ "		price						,"
					+ " 	description					,"
					+ "		web_source_id 				,"
					+ "		status						,"
					+ "		product_image			  	"
					+ "	)"
					+ "		(SELECT 					"
					+ "			1,					    "
					+ "			'name',					"
					+ "			'price'	   			   ,"
					+ "			'description'	   	   ,"
					+ "			 1	   			   	   ,"
					+ "			 '1'	   			   ,"
					+ "			'product_image' 		"
					+ "			WHERE NOT EXISTS(		"
					+ "			SELECT description FROM temporary_item where trim(both ' ' from description)= trim(both ' ' from 'description') "
					+ "				) 					"		
					+ " )								"
					+ "	<foreach  collection='all_product' item='product' separator=' '>"
					+ "		UNION"
					+ "		( "
					+ "			SELECT "
					+ "				#{product.subcategory.subcategory_id}	,"
					+ "				#{product.product_name}					,"
					+ "				#{product.price}						,"
					+ "				#{product.description}					,"
					+ "				#{product.web.web_source_id} 			,"
					+ "				'no'						 			,"
					+ "				#{product.product_image} 				 "
					+ "			WHERE NOT EXISTS("
					+ "				SELECT description FROM temporary_item where trim(both ' ' from description)= trim(both ' ' from #{product.description})"
					+ "			) "
					+ "		) "
					+ "	</foreach> "
					+ "</script>";	
			
			String UPDATE_SUBCATEGORY=" Update temporary_item set subcategory_id=#{subcategory.subcategory_id} Where product_id = #{product_id}";
			
			String FIND_INTO_PRODUCT="Select "
					+ " product_id 			,"
					+ " product_name 		,"
					+ " price	      		,"
					+ " product_image 		,"
					+ " subcategory_id 		,"
					+ " web_source_id 		,"
					+ " description 		 "
					+ " From temporary_item where product_id = #{id}";
			
			String UPDATE_STATUS = "Update temporary_item set status = #{status} Where product_id = #{id} ";
		
			String REMOVE ="Delete From temporary_item Where product_id=#{id}";
		}
	
}
