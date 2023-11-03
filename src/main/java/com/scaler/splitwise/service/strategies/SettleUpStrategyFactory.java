package com.scaler.splitwise.service.strategies;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(SettleUpStrategies strategyName){
        return new HeapBasedSettleUpStrategy();
    }
}
