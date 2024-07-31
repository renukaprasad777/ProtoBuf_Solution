package endpoints;

public class Routes {

	public static String baseUrl="https://www.shoppersstack.com/shopping";
	
	public static String LoginUrl=baseUrl+"/users/login";
	public static String ViewProductsUrl=baseUrl+"/products/alpha";
	
	public static String addToWishListUrl=baseUrl+"/shoppers/{shopperId}/wishlist";
	public static String getFromWishListUrl=baseUrl+"/shoppers/{shopperId}/wishlist";
	public static String deleteFromWishListUrl=baseUrl+"/shoppers/{shopperId}/wishlist/{productId}";
	
	
}
