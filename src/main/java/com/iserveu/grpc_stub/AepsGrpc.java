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
public final class AepsGrpc {

  private AepsGrpc() {}

  public static final String SERVICE_NAME = "Aeps";

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
    if ((getAepsCDMethod = AepsGrpc.getAepsCDMethod) == null) {
      synchronized (AepsGrpc.class) {
        if ((getAepsCDMethod = AepsGrpc.getAepsCDMethod) == null) {
          AepsGrpc.getAepsCDMethod = getAepsCDMethod = 
              io.grpc.MethodDescriptor.<com.iserveu.grpc_stub.AxisRequest, com.iserveu.grpc_stub.AxisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Aeps", "aepsCD"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.iserveu.grpc_stub.AxisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.iserveu.grpc_stub.AxisResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AepsMethodDescriptorSupplier("aepsCD"))
                  .build();
          }
        }
     }
     return getAepsCDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.iserveu.grpc_stub.AxisRequest,
      com.iserveu.grpc_stub.AxisResponse> getAepsCWMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "aepsCW",
      requestType = com.iserveu.grpc_stub.AxisRequest.class,
      responseType = com.iserveu.grpc_stub.AxisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.iserveu.grpc_stub.AxisRequest,
      com.iserveu.grpc_stub.AxisResponse> getAepsCWMethod() {
    io.grpc.MethodDescriptor<com.iserveu.grpc_stub.AxisRequest, com.iserveu.grpc_stub.AxisResponse> getAepsCWMethod;
    if ((getAepsCWMethod = AepsGrpc.getAepsCWMethod) == null) {
      synchronized (AepsGrpc.class) {
        if ((getAepsCWMethod = AepsGrpc.getAepsCWMethod) == null) {
          AepsGrpc.getAepsCWMethod = getAepsCWMethod = 
              io.grpc.MethodDescriptor.<com.iserveu.grpc_stub.AxisRequest, com.iserveu.grpc_stub.AxisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Aeps", "aepsCW"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.iserveu.grpc_stub.AxisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.iserveu.grpc_stub.AxisResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AepsMethodDescriptorSupplier("aepsCW"))
                  .build();
          }
        }
     }
     return getAepsCWMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AepsStub newStub(io.grpc.Channel channel) {
    return new AepsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AepsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AepsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AepsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AepsFutureStub(channel);
  }

  /**
   */
  public static abstract class AepsImplBase implements io.grpc.BindableService {

    /**
     */
    public void aepsCD(com.iserveu.grpc_stub.AxisRequest request,
        io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAepsCDMethod(), responseObserver);
    }

    /**
     */
    public void aepsCW(com.iserveu.grpc_stub.AxisRequest request,
        io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAepsCWMethod(), responseObserver);
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
          .addMethod(
            getAepsCWMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.iserveu.grpc_stub.AxisRequest,
                com.iserveu.grpc_stub.AxisResponse>(
                  this, METHODID_AEPS_CW)))
          .build();
    }
  }

  /**
   */
  public static final class AepsStub extends io.grpc.stub.AbstractStub<AepsStub> {
    private AepsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AepsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AepsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AepsStub(channel, callOptions);
    }

    /**
     */
    public void aepsCD(com.iserveu.grpc_stub.AxisRequest request,
        io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAepsCDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void aepsCW(com.iserveu.grpc_stub.AxisRequest request,
        io.grpc.stub.StreamObserver<com.iserveu.grpc_stub.AxisResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAepsCWMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AepsBlockingStub extends io.grpc.stub.AbstractStub<AepsBlockingStub> {
    private AepsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AepsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AepsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AepsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.iserveu.grpc_stub.AxisResponse aepsCD(com.iserveu.grpc_stub.AxisRequest request) {
      return blockingUnaryCall(
          getChannel(), getAepsCDMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.iserveu.grpc_stub.AxisResponse aepsCW(com.iserveu.grpc_stub.AxisRequest request) {
      return blockingUnaryCall(
          getChannel(), getAepsCWMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AepsFutureStub extends io.grpc.stub.AbstractStub<AepsFutureStub> {
    private AepsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AepsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AepsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AepsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.iserveu.grpc_stub.AxisResponse> aepsCD(
        com.iserveu.grpc_stub.AxisRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAepsCDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.iserveu.grpc_stub.AxisResponse> aepsCW(
        com.iserveu.grpc_stub.AxisRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAepsCWMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AEPS_CD = 0;
  private static final int METHODID_AEPS_CW = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AepsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AepsImplBase serviceImpl, int methodId) {
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
        case METHODID_AEPS_CW:
          serviceImpl.aepsCW((com.iserveu.grpc_stub.AxisRequest) request,
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

  private static abstract class AepsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AepsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.iserveu.grpc_stub.AepsAxis.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Aeps");
    }
  }

  private static final class AepsFileDescriptorSupplier
      extends AepsBaseDescriptorSupplier {
    AepsFileDescriptorSupplier() {}
  }

  private static final class AepsMethodDescriptorSupplier
      extends AepsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AepsMethodDescriptorSupplier(String methodName) {
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
      synchronized (AepsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AepsFileDescriptorSupplier())
              .addMethod(getAepsCDMethod())
              .addMethod(getAepsCWMethod())
              .build();
        }
      }
    }
    return result;
  }
}
