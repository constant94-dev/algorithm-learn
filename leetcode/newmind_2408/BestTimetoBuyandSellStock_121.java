package newmind_2408;

public class BestTimetoBuyandSellStock_121 {
    private int maxPrice = Integer.MIN_VALUE;
    private int minPrice = Integer.MAX_VALUE;
    private int priceLength = 0;
    public int maxProfit(int[] prices) {
        priceLength = prices.length;
        for (int i=0; i<priceLength; i++) {
            operMinus(prices, i, i+1);
        }

        return Math.max(maxPrice, 0);
    }

    private void operMinus(int[] prices, int pivot, int sale) {
        if (priceLength <= sale) return;

        if (prices[sale] >= prices[pivot]) {
            int profit = prices[sale] - prices[pivot];
            maxPrice = Math.max(maxPrice, profit);
        }

        operMinus(prices, pivot, sale+1);
    }

    public int maxProfitSolution2(int[] prices) {
        for (int price : prices) { // 1. 배열을 순회하며 현재 가장 작은 값(min)을 갱신
            minPrice = Math.min(minPrice, price);
            int profit = 0;
            if (price > minPrice) {
                profit = price - minPrice; // 2. 갱신된 min값을 구매가격으로하고 다음 요소인 판매가격을 '-' 연산
            }

            maxPrice = Math.max(maxPrice, profit); // 3. 현재 가장 큰 값을 max에 저장
        }

        // max 값 반환
        return maxPrice;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock_121 test = new BestTimetoBuyandSellStock_121();
        int[] prices = {7,6,4,3,1};

        System.out.println(test.maxProfitSolution2(prices));
    }
}
