package com.example.ipldashboard.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint64;
import org.web3j.abi.datatypes.generated.Uint96;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class VRFCoordinatorV2Interface extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_ACCEPTSUBSCRIPTIONOWNERTRANSFER = "acceptSubscriptionOwnerTransfer";

    public static final String FUNC_ADDCONSUMER = "addConsumer";

    public static final String FUNC_CANCELSUBSCRIPTION = "cancelSubscription";

    public static final String FUNC_CREATESUBSCRIPTION = "createSubscription";

    public static final String FUNC_GETREQUESTCONFIG = "getRequestConfig";

    public static final String FUNC_GETSUBSCRIPTION = "getSubscription";

    public static final String FUNC_PENDINGREQUESTEXISTS = "pendingRequestExists";

    public static final String FUNC_REMOVECONSUMER = "removeConsumer";

    public static final String FUNC_REQUESTRANDOMWORDS = "requestRandomWords";

    public static final String FUNC_REQUESTSUBSCRIPTIONOWNERTRANSFER = "requestSubscriptionOwnerTransfer";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected VRFCoordinatorV2Interface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VRFCoordinatorV2Interface(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VRFCoordinatorV2Interface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VRFCoordinatorV2Interface(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptSubscriptionOwnerTransfer(BigInteger subId) {
        final Function function = new Function(
                FUNC_ACCEPTSUBSCRIPTIONOWNERTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addConsumer(BigInteger subId, String consumer) {
        final Function function = new Function(
                FUNC_ADDCONSUMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId), 
                new org.web3j.abi.datatypes.Address(consumer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelSubscription(BigInteger subId, String to) {
        final Function function = new Function(
                FUNC_CANCELSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId), 
                new org.web3j.abi.datatypes.Address(to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createSubscription() {
        final Function function = new Function(
                FUNC_CREATESUBSCRIPTION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, BigInteger, List<byte[]>>> getRequestConfig() {
        final Function function = new Function(FUNC_GETREQUESTCONFIG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}, new TypeReference<Uint32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, BigInteger, List<byte[]>>>(function,
                new Callable<Tuple3<BigInteger, BigInteger, List<byte[]>>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, List<byte[]>>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, List<String>>> getSubscription(BigInteger subId) {
        final Function function = new Function(FUNC_GETSUBSCRIPTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint96>() {}, new TypeReference<Uint64>() {}, new TypeReference<Address>() {}, new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, List<String>>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, String, List<String>>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, String, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, String, List<String>>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                convertToNative((List<Address>) results.get(3).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<Boolean> pendingRequestExists(BigInteger subId) {
        final Function function = new Function(FUNC_PENDINGREQUESTEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeConsumer(BigInteger subId, String consumer) {
        final Function function = new Function(
                FUNC_REMOVECONSUMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId), 
                new org.web3j.abi.datatypes.Address(consumer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> requestRandomWords(byte[] keyHash, BigInteger subId, BigInteger minimumRequestConfirmations, BigInteger callbackGasLimit, BigInteger numWords) {
        final Function function = new Function(
                FUNC_REQUESTRANDOMWORDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(keyHash), 
                new org.web3j.abi.datatypes.generated.Uint64(subId), 
                new org.web3j.abi.datatypes.generated.Uint16(minimumRequestConfirmations), 
                new org.web3j.abi.datatypes.generated.Uint32(callbackGasLimit), 
                new org.web3j.abi.datatypes.generated.Uint32(numWords)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> requestSubscriptionOwnerTransfer(BigInteger subId, String newOwner) {
        final Function function = new Function(
                FUNC_REQUESTSUBSCRIPTIONOWNERTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(subId), 
                new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static VRFCoordinatorV2Interface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VRFCoordinatorV2Interface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VRFCoordinatorV2Interface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VRFCoordinatorV2Interface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VRFCoordinatorV2Interface load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VRFCoordinatorV2Interface(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VRFCoordinatorV2Interface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VRFCoordinatorV2Interface(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VRFCoordinatorV2Interface> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VRFCoordinatorV2Interface.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VRFCoordinatorV2Interface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VRFCoordinatorV2Interface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<VRFCoordinatorV2Interface> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VRFCoordinatorV2Interface.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VRFCoordinatorV2Interface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VRFCoordinatorV2Interface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
