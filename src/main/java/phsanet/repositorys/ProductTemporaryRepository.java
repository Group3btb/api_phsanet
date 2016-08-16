package phsanet.repositorys;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import phsanet.entitys.Products;
import phsanet.entitys.Temporary_Item;
import phsanet.repositorys.ProductRepository.SQL;

@Repository
@Qualifier("proudcttemporaryrepository")
public interface ProductTemporaryRepository {
	
	@Insert(SQL.INSERT_IGNORE)
	public boolean save(@Param("all_product") ArrayList<Products> all_product);
		
	interface SQL{
	
			String INSERT_IGNORE="<script> Insert Into temporary_item "
					+ "	(	"
					+ "		subcategory_id				,"
					+ "		product_name				,"
					+ "		price						,"
					+ " 	description					,"
					+ "		web_source_id 				,"
					+ "		product_image			  	"
					+ "	)"
					+ "		(SELECT 					"
					+ "			1,					"
					+ "			'name',					"
					+ "			'price'	   			   ,"
					+ "			'description'	   	   ,"
					+ "			 34	   			   	   ,"
					+ "			'product_image' 		"
					+ "			WHERE NOT EXISTS(		"
					+ "			SELECT description FROM temporary_item where trim(both ' ' from description)= trim(both ' ' from #{product.description}) "
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
					+ "				#{product.product_image} 				 "
					+ "			WHERE NOT EXISTS("
					+ "				SELECT description FROM temporary_item where trim(both ' ' from description)= trim(both ' ' from #{product.description})"
					+ "			) "
					+ "		) "
					+ "	</foreach> "
					+ "</script>";
			
				
		}
	
}
