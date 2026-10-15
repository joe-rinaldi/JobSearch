package JPMC;

import java.util.*;

interface IPortfolio {
    Map<String, Integer> getAllocations();
}

class SimplePortfolio implements IPortfolio {

    private Map<String, Integer> allocations;

    public SimplePortfolio(Map<String, Integer> allocations) {
        this.allocations = allocations;
    }

    @Override
    public Map<String, Integer> getAllocations() {
        return allocations;
    }
}

class PortfolioManager {

    public Map<String, Integer> rebalancePortfolio(IPortfolio currentPortfolio,
                                                   IPortfolio targetPortfolio) {

        Map<String, Integer> current = currentPortfolio.getAllocations();
        Map<String, Integer> target = targetPortfolio.getAllocations();

        Map<String, Integer> adjustments = new HashMap<>();

        // For each asset in target, compute buy/sell difference
        for (String asset : target.keySet()) {
            int curr = current.getOrDefault(asset, 0);
            int targ = target.get(asset);

            int diff = targ - curr;   // positive = buy, negative = sell
            adjustments.put(asset, diff);
        }

        // If current portfolio has assets not in target, they must be sold completely
        for (String asset : current.keySet()) {
            if (!target.containsKey(asset)) {
                adjustments.put(asset, -current.get(asset)); // sell all
            }
        }

        return adjustments;
    }

    public static void main(String[] args) {

        Map<String, Integer> curr = new HashMap<>();
        curr.put("Stocks", 50);
        curr.put("Bonds", 30);
        curr.put("Gold", 20);

        Map<String, Integer> targ = new HashMap<>();
        targ.put("Stocks", 40);
        targ.put("Bonds", 40);
        targ.put("Gold", 20);

        IPortfolio currentPortfolio = new SimplePortfolio(curr);
        IPortfolio targetPortfolio = new SimplePortfolio(targ);

        PortfolioManager pm = new PortfolioManager();
        Map<String, Integer> result = pm.rebalancePortfolio(currentPortfolio, targetPortfolio);

        for (String asset : result.keySet()) {
            System.out.println(asset + ": " + result.get(asset));
        }
    }

}



