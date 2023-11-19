package uz.pdp.appgrpcserver.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import uz.pdp.appgrpcinterface.service.HelloWorldServiceGrpc;
import uz.pdp.appgrpcinterface.service.Request;
import uz.pdp.appgrpcinterface.service.Response;

@GrpcService
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    @Override
    public void sayHello(Request request, StreamObserver<Response> responseObserver) {
        final String name = request.getName();
        final Response response = Response.newBuilder()
                .setMessage("Hello " + name + ". Welcome to gRPC.")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
