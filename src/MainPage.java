public class MainPage {

	public static void main(String[] args) throws Exception {
		
		try {
			// Start of scenario 1 and 2
			FlipkartPage flipkartPage = new FlipkartPage();
			flipkartPage.initialize();
			int flipkartItemPrice = flipkartPage.NavigateTo();
			System.out.println("Item price from Flipkart is: ₹"+flipkartItemPrice);
			flipkartPage.closeDriver();
			// End of scenario 1

			// Scenario 2 continue
			AmazonPage amazonPage = new AmazonPage();
			amazonPage.initialize();
			int amazonItemPrice = amazonPage.NavigateTo();
			System.out.println("Item price from Amazon is: ₹"+amazonItemPrice);
			amazonPage.closeDriver();

			if(amazonItemPrice > flipkartItemPrice){
				System.out.println("Flipkart is selling at cheaper rates. The rate is: ₹" + flipkartItemPrice);
			}
			else if (flipkartItemPrice > amazonItemPrice){
				System.out.println("Amazon is selling at cheaper rates. The rate is: ₹" + amazonItemPrice);
			}
			else{
				System.out.println("Both the sites are selling at same rates");
			}

			// End of scenario 2
			
		} catch (Exception e) {
			e.printStackTrace();

	
		}

	}

}
