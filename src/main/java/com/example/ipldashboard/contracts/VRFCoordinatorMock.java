package com.example.ipldashboard.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class VRFCoordinatorMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516104073803806104078339818101604052602081101561003357600080fd5b5051600080546001600160a01b039092166001600160a01b03199092169190911790556103a2806100656000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80631b6b6d2314610046578063a4c0ed361461006a578063cf55fe9714610127575b600080fd5b61004e610159565b604080516001600160a01b039092168252519081900360200190f35b6101256004803603606081101561008057600080fd5b6001600160a01b03823516916020810135918101906060810160408201356401000000008111156100b057600080fd5b8201836020820111156100c257600080fd5b803590602001918460018302840111640100000000831117156100e457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610168945050505050565b005b6101256004803603606081101561013d57600080fd5b50803590602081013590604001356001600160a01b0316610222565b6000546001600160a01b031681565b6000546001600160a01b031633146101bd576040805162461bcd60e51b815260206004820152601360248201527226bab9ba103ab9b2902624a725903a37b5b2b760691b604482015290519081900360640190fd5b6000808280602001905160408110156101d557600080fd5b5080516020909101516040519193509150819083906001600160a01b038816907f7a9a0a6960d95b32cded93c30e63e7c2eb9e877230813c172110ea54dc1c915c90600090a45050505050565b604080516024810185905260448082018590528251808303909101815260649091019091526020810180516001600160e01b03166394985ddd60e01b179052600090620324b0805a10156102bd576040805162461bcd60e51b815260206004820152601b60248201527f6e6f7420656e6f7567682067617320666f7220636f6e73756d65720000000000604482015290519081900360640190fd5b6000846001600160a01b0316836040518082805190602001908083835b602083106102f95780518252601f1990920191602091820191016102da565b6001836020036101000a0380198251168184511680821785525050505050509050019150506000604051808303816000865af19150503d806000811461035b576040519150601f19603f3d011682016040523d82523d6000602084013e610360565b606091505b5050505050505050505056fea264697066735822122011ee94d9a23e4f6040e9ab160268618bc5bcece5227cbae024c26d9edeca394b64736f6c63430006060033";

    public static final String FUNC_LINK = "LINK";

    public static final String FUNC_CALLBACKWITHRANDOMNESS = "callBackWithRandomness";

    public static final String FUNC_ONTOKENTRANSFER = "onTokenTransfer";

    public static final Event RANDOMNESSREQUEST_EVENT = new Event("RandomnessRequest", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VRFCoordinatorMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<RandomnessRequestEventResponse> getRandomnessRequestEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RANDOMNESSREQUEST_EVENT, transactionReceipt);
        ArrayList<RandomnessRequestEventResponse> responses = new ArrayList<RandomnessRequestEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RandomnessRequestEventResponse typedResponse = new RandomnessRequestEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.keyHash = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.seed = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RandomnessRequestEventResponse> randomnessRequestEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RandomnessRequestEventResponse>() {
            @Override
            public RandomnessRequestEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RANDOMNESSREQUEST_EVENT, log);
                RandomnessRequestEventResponse typedResponse = new RandomnessRequestEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.keyHash = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.seed = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RandomnessRequestEventResponse> randomnessRequestEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RANDOMNESSREQUEST_EVENT));
        return randomnessRequestEventFlowable(filter);
    }

    public RemoteFunctionCall<String> LINK() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LINK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> callBackWithRandomness(byte[] requestId, BigInteger randomness, String consumerContract) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CALLBACKWITHRANDOMNESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(requestId), 
                new org.web3j.abi.datatypes.generated.Uint256(randomness), 
                new org.web3j.abi.datatypes.Address(consumerContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onTokenTransfer(String sender, BigInteger fee, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONTOKENTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sender), 
                new org.web3j.abi.datatypes.generated.Uint256(fee), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VRFCoordinatorMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VRFCoordinatorMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VRFCoordinatorMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VRFCoordinatorMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VRFCoordinatorMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VRFCoordinatorMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String linkAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(linkAddress)));
        return deployRemoteCall(VRFCoordinatorMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class RandomnessRequestEventResponse extends BaseEventResponse {
        public String sender;

        public byte[] keyHash;

        public BigInteger seed;
    }
}
