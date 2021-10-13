package com.circuit.breaker;

public class CircuitBreaker {

    private String request;
    private String state;
    private int failureCount;
    private int failureThreshold;
    private int successCount;
    private int successThreshold;
    private long timeout;
    private long nextAttempt;

    /*
CLOSED to OPEN: If failureCount > failureThreshold.
OPEN to HALF: If the current time > nextAttempt.
HALF to OPEN: If any failure occurs
HALF to CLOSED: If successCount >= successThreshold
     */

    public CircuitBreaker(String request) {
        this.request = request;
        this.state = "CLOSED";
        this.failureThreshold = 3;
        this.failureCount = 0;
        this.successThreshold = 2;
        this.successCount = 0;
        this.timeout = 6000;
        this.nextAttempt = System.currentTimeMillis();
    }

    public void fire(){
        if (this.state == "OPEN") {
            if (this.nextAttempt <= System.currentTimeMillis()) {
                this.state = "HALF";
            } else {
                throw new Error("Circuit is currently OPEN");
            }
        }
       /* try {
            const response = await this.request()
            return this.success(response)
        } catch (err) {
            return this.fail(err)
        }*/

    }

    public String success(String response){
        if(this.state== "HALF"){
            this.successCount++;
            if (this.successCount > this.successThreshold) {
                this.successCount = 0;
                this.state = "CLOSED";
            }
        }

        this.failureCount = 0;
        return response;

    }

    public String fail(String err){
        this.failureCount++;
        if (this.failureCount >= this.failureThreshold) {
            this.state = "OPEN";
            this.nextAttempt = System.currentTimeMillis() + this.timeout;
        }
        return err;


    }
}
