package com.iserveu.grpc_stub;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: aepsAxis.proto")
public final class AepsServiceGrpc {

  private AepsServiceGrpc() {}

  public static final String SERVICE_NAME = "AepsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.iserveu.grpc_stub.AxisRequest,
      com.iserveu.grpc_stub.AxisResponse> getAepsCDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "aepsCD",
      requestType = com.iserveu.grpc_stub.AxisRequest.class,
      responseType = com.iserveu.grpc_stub.AxisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.iserveu.grpc_stub.AxisRequest,
      com.iserveu.grpc_stub.AxisResponse> getAepsCDMethod() {
    io.grpc.MethodDescriptor<com.iserveu.grpc_stub.AxisRequest, com.iserveu.grpc_stub.AxisResponse> getAepsCDMethod;
    if ((getAepsCDMethod = AepsServiceGrpc.getAepsCDMethod) == null) {
      synchronized (AepsServiceGrpc.class) {
        if ((getAepsCDMethod = AepsServiceGrpc.getAepsCDMethod) == null) {
          AepsServiceGrpc.getAepsCDMethod = getAepsCDMethod = 
              io.grpc.MethodDescriptor.<com.iserveu.grpc_stub.AxisRequest, com.iserveu.grpc_stub.AxisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AepsService", "aepsCD"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.iserveu.grpc_stub.AxisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.iserveu.grpc_stub.AxisResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AepsServiceMethodDescriptorSupplier("aepsCD"))
                  .build();
          }
        }
     }
     return getAepsCDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AepsServiceStub newStub(io.grpc.Channel channel) {
    return new AepsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AepsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AepsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AepsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AepsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AepsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void aepsCD(com.iserveu.grpc_stub.AxisRequest request,
        io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAepsCDMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAepsCDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.iserveu.grpc_stub.AxisRequest,
                com.iserveu.grpc_stub.AxisResponse>(
                  this, METHODID_AEPS_CD)))
          .build();
    }
  }

  /**
   */
  public static final class AepsServiceStub extends io.grpc.stub.AbstractStub<AepsServiceStub> {
    private AepsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AepsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AepsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AepsServiceStub(channel, callOptions);
    }

    /**
     */
    public void aepsCD(com.iserveu.grpc_stub.AxisRequest request,
        io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAepsCDMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AepsServiceBlockingStub extends io.grpc.stub.AbstractStub<AepsServiceBlockingStub> {
    private AepsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AepsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AepsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AepsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.iserveu.grpc_stub.AxisResponse aepsCD(com.iserveu.grpc_stub.AxisRequest request) {
      return blockingUnaryCall(
          getChannel(), getAepsCDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AepsServiceFutureStub extends io.grpc.stub.AbstractStub<AepsServiceFutureStub> {
    private AepsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AepsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AepsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AepsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.iserveu.grpc_stub.AxisResponse> aepsCD(
        com.iserveu.grpc_stub.AxisRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAepsCDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AEPS_CD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AepsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AepsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AEPS_CD:
          serviceImpl.aepsCD((com.iserveu.grpc_stub.AxisRequest) request,
              (io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AepsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AepsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.iserveu.grpc_stub.Aeps.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AepsService");
    }
  }

  private static final class AepsServiceFileDescriptorSupplier
      extends AepsServiceBaseDescriptorSupplier {
    AepsServiceFileDescriptorSupplier() {}
  }

  private static final class AepsServiceMethodDescriptorSupplier
      extends AepsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AepsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AepsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AepsServiceFileDescriptorSupplier())
              .addMethod(getAepsCDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
