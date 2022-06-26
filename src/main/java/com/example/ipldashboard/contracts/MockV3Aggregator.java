package com.example.ipldashboard.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.abi.datatypes.generated.Uint80;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class MockV3Aggregator extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516104df3803806104df8339818101604052604081101561003357600080fd5b5080516020909101516000805460ff191660ff84161790556100548161005b565b50506100a2565b600181815542600281905560038054909201808355600090815260046020908152604080832095909555835482526005815284822083905592548152600690925291902055565b61042e806100b16000396000f3fe608060405234801561001057600080fd5b50600436106100b45760003560e01c80638205bf6a116100715780638205bf6a146101b85780639a6fc8f5146101c0578063a87a20ce1461022a578063b5ab58dc14610247578063b633620c14610264578063feaf968c14610281576100b4565b8063313ce567146100b95780634aa2011f146100d757806350d25bcd1461011157806354fd4d501461012b578063668a0f02146101335780637284e4161461013b575b600080fd5b6100c1610289565b6040805160ff9092168252519081900360200190f35b61010f600480360360808110156100ed57600080fd5b506001600160501b038135169060208101359060408101359060600135610292565b005b6101196102dc565b60408051918252519081900360200190f35b6101196102e2565b6101196102e7565b6101436102ed565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561017d578181015183820152602001610165565b50505050905090810190601f1680156101aa5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610119610324565b6101e6600480360360208110156101d657600080fd5b50356001600160501b031661032a565b60405180866001600160501b03168152602001858152602001848152602001838152602001826001600160501b031681526020019550505050505060405180910390f35b61010f6004803603602081101561024057600080fd5b5035610360565b6101196004803603602081101561025d57600080fd5b50356103a7565b6101196004803603602081101561027a57600080fd5b50356103b9565b6101e66103cb565b60005460ff1681565b6001600160501b0390931660038181556001849055600283905560009182526004602090815260408084209590955581548352600581528483209390935554815260069091522055565b60015481565b600081565b60035481565b60408051808201909152601f81527f76302e362f74657374732f4d6f636b563341676772656761746f722e736f6c00602082015290565b60025481565b6001600160501b038116600090815260046020908152604080832054600683528184205460059093529220549293919290918490565b600181815542600281905560038054909201808355600090815260046020908152604080832095909555835482526005815284822083905592548152600690925291902055565b60046020526000908152604090205481565b60056020526000908152604090205481565b6003546000818152600460209081526040808320546006835281842054600590935292205483909192939456fea26469706673582212207187207c12d6995dc180959267888da84c0f04205b0364e324c69c293ddaf7c264736f6c634300060c0033";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DESCRIPTION = "description";

    public static final String FUNC_GETANSWER = "getAnswer";

    public static final String FUNC_GETROUNDDATA = "getRoundData";

    public static final String FUNC_GETTIMESTAMP = "getTimestamp";

    public static final String FUNC_LATESTANSWER = "latestAnswer";

    public static final String FUNC_LATESTROUND = "latestRound";

    public static final String FUNC_LATESTROUNDDATA = "latestRoundData";

    public static final String FUNC_LATESTTIMESTAMP = "latestTimestamp";

    public static final String FUNC_UPDATEANSWER = "updateAnswer";

    public static final String FUNC_UPDATEROUNDDATA = "updateRoundData";

    public static final String FUNC_VERSION = "version";

    public static final Event ANSWERUPDATED_EVENT = new Event("AnswerUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWROUND_EVENT = new Event("NewRound", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MockV3Aggregator(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MockV3Aggregator(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MockV3Aggregator(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MockV3Aggregator(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AnswerUpdatedEventResponse> getAnswerUpdatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ANSWERUPDATED_EVENT, transactionReceipt);
        ArrayList<AnswerUpdatedEventResponse> responses = new ArrayList<AnswerUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AnswerUpdatedEventResponse typedResponse = new AnswerUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.current = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.updatedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AnswerUpdatedEventResponse> answerUpdatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AnswerUpdatedEventResponse>() {
            @Override
            public AnswerUpdatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ANSWERUPDATED_EVENT, log);
                AnswerUpdatedEventResponse typedResponse = new AnswerUpdatedEventResponse();
                typedResponse.log = log;
                typedResponse.current = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.updatedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AnswerUpdatedEventResponse> answerUpdatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ANSWERUPDATED_EVENT));
        return answerUpdatedEventFlowable(filter);
    }

    public List<NewRoundEventResponse> getNewRoundEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWROUND_EVENT, transactionReceipt);
        ArrayList<NewRoundEventResponse> responses = new ArrayList<NewRoundEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewRoundEventResponse typedResponse = new NewRoundEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.startedBy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.startedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewRoundEventResponse> newRoundEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewRoundEventResponse>() {
            @Override
            public NewRoundEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWROUND_EVENT, log);
                NewRoundEventResponse typedResponse = new NewRoundEventResponse();
                typedResponse.log = log;
                typedResponse.roundId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.startedBy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.startedAt = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewRoundEventResponse> newRoundEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWROUND_EVENT));
        return newRoundEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> description() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getAnswer(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getRoundData(BigInteger _roundId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint80(_roundId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint80>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getTimestamp(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latestAnswer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTANSWER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latestRound() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUND, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> latestRoundData() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTROUNDDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint80>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> latestTimestamp() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LATESTTIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateAnswer(BigInteger _answer) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEANSWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_answer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateRoundData(BigInteger _roundId, BigInteger _answer, BigInteger _timestamp, BigInteger _startedAt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEROUNDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint80(_roundId), 
                new org.web3j.abi.datatypes.generated.Int256(_answer), 
                new org.web3j.abi.datatypes.generated.Uint256(_timestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(_startedAt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> version() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static MockV3Aggregator load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockV3Aggregator(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MockV3Aggregator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockV3Aggregator(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MockV3Aggregator load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MockV3Aggregator(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MockV3Aggregator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MockV3Aggregator(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MockV3Aggregator> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _decimals, BigInteger _initialAnswer) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_decimals), 
                new org.web3j.abi.datatypes.generated.Int256(_initialAnswer)));
        return deployRemoteCall(MockV3Aggregator.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AnswerUpdatedEventResponse extends BaseEventResponse {
        public BigInteger current;

        public BigInteger roundId;

        public BigInteger updatedAt;
    }

    public static class NewRoundEventResponse extends BaseEventResponse {
        public BigInteger roundId;

        public String startedBy;

        public BigInteger startedAt;
    }
}
