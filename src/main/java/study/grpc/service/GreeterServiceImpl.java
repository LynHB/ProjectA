package study.grpc.service;

import io.grpc.stub.StreamObserver;
import study.grpc.pojo.GreeterOuterClass.*;
import study.grpc.rpc.GreeterGrpc;

/**
 * @Author LynHB
 * @Description : grpc实现接口
 * @Date 19:53 2020/7/29
 **/
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
