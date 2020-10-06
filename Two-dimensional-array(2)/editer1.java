class Main{
	public static double getTotalForProductList(double[][] product2dPriceList){
		double finalTotal = 0;
	    for (int i = 0; i < product2dPriceList.length; i++){
	        double[] priceList = product2dPriceList[i];
	        double price = priceList[0];
	        double total = price;
	        // 最初の値の後に開始
	        for (int j = 1; j < priceList.length; j++){
	            double multiplier = priceList[j];
	            total += price * multiplier;
	        }
	        // finalTotalを足していきます。
	        System.out.println("Total for current item is:" + (total));
	        finalTotal += total;
	    }
	    return finalTotal;
	}
	public static void main(String[] args) {
		// 商品の配列
		double[] product1 = {100, 0.1, 0.02, 0.03, 0.02};
		double[] product2 = {50, -0.5, 0.1, 0.05, 0.02};
		double[] product3 = {34, 0.05, 0.2, 0.03, 0.1};
		double[] product4 = {10, -0.2, 0.3, 0.05, 0.03};

		// Shopping cartは全てのアイテムを含んでいます。2次元配列。
		double[][] shoppingCartArray = new double [][]{product1, product2, product3, product4};
		System.out.println(getTotalForProductList(shoppingCartArray));
	}
}