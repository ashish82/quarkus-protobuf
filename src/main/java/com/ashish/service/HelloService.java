package com.ashish.service;

import com.ashish.quarkus.proto.GreeterGrpc;
import com.ashish.quarkus.proto.HelloReply;
import com.ashish.quarkus.proto.HelloRequest;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

/**
 * Created by ashishsr on 23/03/21
 */
@Singleton
public class HelloService extends GreeterGrpc.GreeterImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello " + name;
        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
        responseObserver.onCompleted();
    }
}
