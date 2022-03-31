package fis.java.topic13.constant;

public class ContextUrl {
	public static final String API_URL = "/api/v1";

	// customer url
	public static final String CUSTOMER_FIND_ALL = "/customers";

	public static final String CUSTOMER_SAVE = "/customer/save";

	public static final String CUSTOMER_FIND_ONE = "/customer/{id}";

	public static final String CUSTOMER_UPDATE = "/customer/update/{id}";

	public static final String CUSTOMER_DELETE = "/customer/delete/{id}";

	// product url
	public static final String PRODUCT_FIND_ALL = "/products";

	public static final String PRODUCT_SAVE = "/product/save";

	public static final String PRODUCT_FIND_ONE = "/product/{id}";

	public static final String PRODUCT_UPDATE = "/product/update/{id}";

	public static final String PRODUCT_DELETE = "/product/delete/{id}";
	
	//order url
	public static final String ORDER_FIND_BY_CUSTOMER = "/orders"; 
	
	public static final String ORDER_SAVE = "/order/save/{id}"; 
	
	//detail url
	public static final String DETAIL_SAVE = "/detail/save"; 
	
	public static final String DETAIL_FIND_BY_ORDER = "/details"; 
	
	//category url
	public static final String CATEGORY_FIND_ALL = "/categories";

}
