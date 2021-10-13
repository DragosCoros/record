package com.grpc.healthcheck;


import grpc.health.test.HealthCheck;
import grpc.health.test.HealthGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.stereotype.Controller;

@GRpcService
@Controller
public class HealthController extends HealthGrpc.HealthImplBase {

    @Override
    public void check(HealthCheck.HealthCheckRequest request, StreamObserver<HealthCheck.HealthCheckResponse> responseObserver) {
        super.check(request, responseObserver);
    }
}
