package com.example.benchmarkkafkaconsumermultithread.models;

import lombok.Getter;

@Getter
public class CalculateTime {
    private  long timeConsumeOrder;
    private  long timeConsumeOrderItem;


    public long getTime(){
       return System.currentTimeMillis();
    }

    public void sumTimeOrder(long timeExecution){
       this.timeConsumeOrder += timeExecution;
    }

    public void sumTimeOrderItem(long timeExecution){
        this.timeConsumeOrderItem += timeExecution;
    }
}
