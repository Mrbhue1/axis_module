// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aepsAxis.proto

package com.iserveu.grpc_stub;

public final class AepsOuterClass {
  private AepsOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AxisRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AxisRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AxisResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AxisResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\naepsAxis.proto\"\200\002\n\013AxisRequest\022\017\n\007aadhaar\030" +
      "\001 \001(\t\022\013\n\003iin\030\002 \001(\t\022\016\n\006amount\030\003 \001(\005\022\r\n\005tx" +
      "nId\030\004 \001(\003\022\020\n\010latitude\030\005 \001(\t\022\021\n\tlongitude" +
      "\030\006 \001(\t\022\022\n\nmerchantId\030\007 \001(\003\022\020\n\010bankName\030\010" +
      " \001(\t\022\020\n\010mobileNo\030\t \001(\t\022\017\n\007pidData\030\n \001(\t\022" +
      "\021\n\tipAddress\030\013 \001(\t\022\017\n\007imeiMac\030\014 \001(\t\022\020\n\010d" +
      "eviceNo\030\r \001(\t\022\020\n\010userName\030\017 \001(\t\"\274\005\n\014Axis" +
      "Response\022\022\n\nstatusCode\0302 \001(\005\022\025\n\rsubStatu" +
      "sCode\0303 \001(\005\022\022\n\nstatusDesc\030\001 \001(\t\022\023\n\013clien" +
      "tRefId\030\002 \001(\t\022\025\n\rmessageString\030\003 \001(\t\022\024\n\014r" +
      "esponseCode\030\004 \001(\t\022\021\n\trequestID\030\005 \001(\t\022\016\n\006" +
      "amount\030\006 \001(\t\022\020\n\010adhaarNo\030\007 \001(\t\022\017\n\007txnTim" +
      "e\030\010 \001(\t\022\017\n\007txnDate\030\t \001(\t\022\020\n\010bankName\030\n \001" +
      "(\t\022\013\n\003rrn\030\013 \001(\t\022\016\n\006status\030\014 \001(\t\022\026\n\016custo" +
      "merMobile\030\r \001(\t\022\030\n\020availableBalance\030\016 \001(" +
      "\t\022\026\n\016dispalyMessage\030\017 \001(\t\022\031\n\021transaction" +
      "Status\030\020 \001(\t\022\033\n\023transactionDateTime\030\021 \001(" +
      "\t\022\027\n\017transactionList\030\022 \001(\t\022\024\n\014npciTranDa" +
      "ta\030\023 \001(\t\022\022\n\nisFormated\030\024 \001(\t\022\030\n\020systemTr" +
      "aceAudit\030\025 \001(\t\022\021\n\tlocalTime\030\026 \001(\t\022\021\n\tloc" +
      "alDate\030\027 \001(\t\022\027\n\017authIndentyResp\030\030 \001(\t\022\022\n" +
      "\ntxnCurCode\030\031 \001(\t\022\023\n\013uidAuthCode\030\032 \001(\t\022\026" +
      "\n\016terminalIdenty\030\033 \001(\t\022\031\n\021cardAccceptorC" +
      "ode\030\034 \001(\t\022\024\n\014nameLocation\030\035 \001(\t\022\025\n\rledge" +
      "rBalance\030\036 \001(\t2-\n\004Aeps\022%\n\006aepsCD\022\014.AxisR" +
      "equest\032\r.AxisResponseB\031\n\025com.iserveu.grp" +
      "c_stubP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_AxisRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AxisRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AxisRequest_descriptor,
        new java.lang.String[] { "Aadhaar", "Iin", "Amount", "TxnId", "Latitude", "Longitude", "MerchantId", "BankName", "MobileNo", "PidData", "IpAddress", "ImeiMac", "DeviceNo", "UserName", });
    internal_static_AxisResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_AxisResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AxisResponse_descriptor,
        new java.lang.String[] { "StatusCode", "SubStatusCode", "StatusDesc", "ClientRefId", "MessageString", "ResponseCode", "RequestID", "Amount", "AdhaarNo", "TxnTime", "TxnDate", "BankName", "Rrn", "Status", "CustomerMobile", "AvailableBalance", "DispalyMessage", "TransactionStatus", "TransactionDateTime", "TransactionList", "NpciTranData", "IsFormated", "SystemTraceAudit", "LocalTime", "LocalDate", "AuthIndentyResp", "TxnCurCode", "UidAuthCode", "TerminalIdenty", "CardAccceptorCode", "NameLocation", "LedgerBalance", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
