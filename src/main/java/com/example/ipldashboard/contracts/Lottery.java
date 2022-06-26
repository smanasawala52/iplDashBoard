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
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint64;
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
public class Lottery extends Contract {
    public static final String BINARY = "60a0604052600880546001600160e01b0316610c3560e51b1790556009805465ffffffffffff1916620200031790553480156200003b57600080fd5b5060405162001606380380620016068339810160408190526200005e916200017c565b846200006a336200010f565b6001600160a01b03908116608052600880549187166801000000000000000002600160401b600160e01b0319909216919091179055620000b387670de0b6b3a764000062000207565b600355600480546005939093556006939093556001600160a01b03959095166001600160a81b031990911617600160a01b1790555050600880546001600160401b0319166001600160401b039092169190911790555062000235565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b80516001600160a01b03811681146200017757600080fd5b919050565b600080600080600080600060e0888a0312156200019857600080fd5b87519650620001aa602089016200015f565b9550620001ba604089016200015f565b9450620001ca606089016200015f565b608089015160a08a015160c08b015192965090945092506001600160401b0381168114620001f757600080fd5b8091505092959891949750929550565b60008160001904831182151516156200023057634e487b7160e01b600052601160045260246000fd5b500290565b6080516113ae6200025860003960008181610816015261085801526113ae6000f3fe6080604052600436106101c25760003560e01c80637ccfd7fc116100f7578063b0fb162f11610095578063e97dcb6211610064578063e97dcb621461054f578063f2fde38b14610557578063f6eaffc814610577578063f71d96cb1461059757600080fd5b8063b0fb162f146104b6578063b2bf4b6b146104e4578063ddca3f4314610523578063e89e106a1461053957600080fd5b80638ac00021116100d15780638ac00021146104275780638b5b9ccc146104615780638da5cb5b14610483578063aaae7b86146104a157600080fd5b80637ccfd7fc146103c057806381447999146103e357806388ab139a1461041157600080fd5b80633b2bcbf11161016457806360e3949f1161013e57806360e3949f1461032957806366d0ca721461037557806369ebe78e14610395578063715018a6146103ab57600080fd5b80633b2bcbf1146102ac578063473f1ddc146102eb5780634f8c70cf1461030957600080fd5b80631fe543e3116101a05780631fe543e31461021b57806324f746971461023b5780632b6524cd14610274578063360131891461029657600080fd5b806309bc33a7146101c75780631593a8c7146101ef578063160344e214610204575b600080fd5b3480156101d357600080fd5b506101dc6105b7565b6040519081526020015b60405180910390f35b3480156101fb57600080fd5b506101dc6105fd565b34801561021057600080fd5b50610219610765565b005b34801561022757600080fd5b50610219610236366004610ffd565b61080b565b34801561024757600080fd5b5060085461025f90600160e01b900463ffffffff1681565b60405163ffffffff90911681526020016101e6565b34801561028057600080fd5b50610289610893565b6040516101e691906110c7565b3480156102a257600080fd5b506101dc60075481565b3480156102b857600080fd5b506008546102d390600160401b90046001600160a01b031681565b6040516001600160a01b0390911681526020016101e6565b3480156102f757600080fd5b506002546001600160a01b03166102d3565b34801561031557600080fd5b506002546102d3906001600160a01b031681565b34801561033557600080fd5b5061033e6109a5565b6040805169ffffffffffffffffffff968716815260208101959095528401929092526060830152909116608082015260a0016101e6565b34801561038157600080fd5b5061021961039036600461111c565b610a41565b3480156103a157600080fd5b506101dc60065481565b3480156103b757600080fd5b50610219610ab4565b3480156103cc57600080fd5b5060095461025f9062010000900463ffffffff1681565b3480156103ef57600080fd5b5060045461040490600160a01b900460ff1681565b6040516101e6919061115d565b34801561041d57600080fd5b506101dc60035481565b34801561043357600080fd5b506008546104489067ffffffffffffffff1681565b60405167ffffffffffffffff90911681526020016101e6565b34801561046d57600080fd5b50610476610aea565b6040516101e69190611185565b34801561048f57600080fd5b506000546001600160a01b03166102d3565b3480156104ad57600080fd5b506007546101dc565b3480156104c257600080fd5b506009546104d19061ffff1681565b60405161ffff90911681526020016101e6565b3480156104f057600080fd5b506102196104ff3660046111d2565b6009805463ffffffff909216620100000265ffffffff000019909216919091179055565b34801561052f57600080fd5b506101dc60055481565b34801561054557600080fd5b506101dc600b5481565b610219610b4c565b34801561056357600080fd5b506102196105723660046111f8565b610c56565b34801561058357600080fd5b506101dc610592366004611221565b610cee565b3480156105a357600080fd5b506102d36105b2366004611221565b610d0f565b6000806105ce644091ad62e66402540be40061123a565b90506000670de0b6b3a7640000905081816003546105ec919061123a565b6105f6919061127d565b9250505090565b600080546001600160a01b031633146106315760405162461bcd60e51b815260040161062890611291565b60405180910390fd5b6000600454600160a01b900460ff16600281111561065157610651611147565b146106955760405162461bcd60e51b81526020600482015260146024820152734c6f7474657279206973206e6f74206f70656e2160601b6044820152606401610628565b60048054600160a11b60ff60a01b199091161781556008546006546009546040516305d3b1d360e41b81529384019190915267ffffffffffffffff8216602484015261ffff8116604484015263ffffffff600160e01b830481166064850152620100009091041660848301526001600160a01b03600160401b9091041690635d3b1d309060a4016020604051808303816000875af115801561073b573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061075f91906112c6565b600b5590565b6000546001600160a01b0316331461078f5760405162461bcd60e51b815260040161062890611291565b6001600454600160a01b900460ff1660028111156107af576107af611147565b146107fc5760405162461bcd60e51b815260206004820152601960248201527f43616e6e6f74207374617274206e6577204c6f747465727921000000000000006044820152606401610628565b6004805460ff60a01b19169055565b336001600160a01b037f000000000000000000000000000000000000000000000000000000000000000016146108855760405163073e64fd60e21b81523360048201526001600160a01b037f0000000000000000000000000000000000000000000000000000000000000000166024820152604401610628565b61088f8282610d39565b5050565b60606000600454600160a01b900460ff1660028111156108b5576108b5611147565b036108e4575060408051808201909152600f81526e2637ba3a32b93c9034b99027b832b760891b602082015290565b6001600454600160a01b900460ff16600281111561090457610904611147565b036109355750604080518082019091526011815270131bdd1d195c9e481a5cc810db1bdcd959607a1b602082015290565b6002600454600160a01b900460ff16600281111561095557610955611147565b03610992575060408051808201909152601d81527f4c6f74746572792069732043414c43554c4154494e475f57494e4e4552000000602082015290565b5060408051602081019091526000815290565b600080600080600080600080600080600460009054906101000a90046001600160a01b03166001600160a01b031663feaf968c6040518163ffffffff1660e01b815260040160a060405180830381865afa158015610a07573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610a2b91906112fe565b939e929d50909b50995090975095505050505050565b8061ffff16600003610a6b57600480546000919060ff60a01b1916600160a01b835b021790555050565b8061ffff16600103610a9157600480546001919060ff60a01b1916600160a01b83610a63565b8061ffff16600203610ab1576004805460ff60a01b1916600160a11b1790555b50565b6000546001600160a01b03163314610ade5760405162461bcd60e51b815260040161062890611291565b610ae86000610ee2565b565b60606001805480602002602001604051908101604052809291908181526020018280548015610b4257602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610b24575b5050505050905090565b6000600454600160a01b900460ff166002811115610b6c57610b6c611147565b14610bae5760405162461bcd60e51b81526020600482015260126024820152714c6f747465727920697320636c6f7365642160701b6044820152606401610628565b610bb66105b7565b341015610c135760405162461bcd60e51b815260206004820152602560248201527f506c6561736520616464206d6f7265207468616e205f6d696e557364456e7472604482015264794665652160d81b6064820152608401610628565b6001805480820182556000919091527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf60180546001600160a01b03191633179055565b6000546001600160a01b03163314610c805760405162461bcd60e51b815260040161062890611291565b6001600160a01b038116610ce55760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b6064820152608401610628565b610ab181610ee2565b600a8181548110610cfe57600080fd5b600091825260209091200154905081565b60018181548110610d1f57600080fd5b6000918252602090912001546001600160a01b0316905081565b600b8290558051610d5190600a906020840190610f32565b506002600454600160a01b900460ff166002811115610d7257610d72611147565b14610db85760405162461bcd60e51b8152602060048201526016602482015275596f7520617265206e6f74207468657265207965742160501b6044820152606401610628565b8051610dcb90600a906020840190610f32565b50600081600081518110610de157610de161134e565b6020026020010151905060008111610e2e5760405162461bcd60e51b815260206004820152601060248201526f14985b991bdb481b9bdd08199bdd5b9960821b6044820152606401610628565b600154600090610e3e9083611364565b905060018181548110610e5357610e5361134e565b6000918252602082200154600280546001600160a01b0319166001600160a01b03909216918217905560405190914780156108fc02929091818181858888f19350505050158015610ea8573d6000803e3d6000fd5b506040805160008152602081019182905251610ec691600191610f7d565b505060075550506004805460ff60a01b1916600160a01b179055565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b828054828255906000526020600020908101928215610f6d579160200282015b82811115610f6d578251825591602001919060010190610f52565b50610f79929150610fd2565b5090565b828054828255906000526020600020908101928215610f6d579160200282015b82811115610f6d57825182546001600160a01b0319166001600160a01b03909116178255602090920191600190910190610f9d565b5b80821115610f795760008155600101610fd3565b634e487b7160e01b600052604160045260246000fd5b6000806040838503121561101057600080fd5b8235915060208084013567ffffffffffffffff8082111561103057600080fd5b818601915086601f83011261104457600080fd5b81358181111561105657611056610fe7565b8060051b604051601f19603f8301168101818110858211171561107b5761107b610fe7565b60405291825284820192508381018501918983111561109957600080fd5b938501935b828510156110b75784358452938501939285019261109e565b8096505050505050509250929050565b600060208083528351808285015260005b818110156110f4578581018301518582016040015282016110d8565b81811115611106576000604083870101525b50601f01601f1916929092016040019392505050565b60006020828403121561112e57600080fd5b813561ffff8116811461114057600080fd5b9392505050565b634e487b7160e01b600052602160045260246000fd5b602081016003831061117f57634e487b7160e01b600052602160045260246000fd5b91905290565b6020808252825182820181905260009190848201906040850190845b818110156111c65783516001600160a01b0316835292840192918401916001016111a1565b50909695505050505050565b6000602082840312156111e457600080fd5b813563ffffffff8116811461114057600080fd5b60006020828403121561120a57600080fd5b81356001600160a01b038116811461114057600080fd5b60006020828403121561123357600080fd5b5035919050565b600081600019048311821515161561126257634e487b7160e01b600052601160045260246000fd5b500290565b634e487b7160e01b600052601260045260246000fd5b60008261128c5761128c611267565b500490565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b6000602082840312156112d857600080fd5b5051919050565b805169ffffffffffffffffffff811681146112f957600080fd5b919050565b600080600080600060a0868803121561131657600080fd5b61131f866112df565b9450602086015193506040860151925060608601519150611342608087016112df565b90509295509295909350565b634e487b7160e01b600052603260045260246000fd5b60008261137357611373611267565b50069056fea2646970667358221220fabfe9d26f29a7a7f37d4d80f5deecc0ad14950d2c6693bda184ae5c3244680d64736f6c634300080d0033";

    public static final String FUNC_COORDINATOR = "COORDINATOR";

    public static final String FUNC_CALLBACKGASLIMIT = "callbackGasLimit";

    public static final String FUNC_ENDLOTTERY = "endLottery";

    public static final String FUNC_ENTER = "enter";

    public static final String FUNC_FEE = "fee";

    public static final String FUNC_GETENTRANCEFEE = "getEntranceFee";

    public static final String FUNC_GETLOTTERYSTATUS = "getLotteryStatus";

    public static final String FUNC_GETPLAYERS = "getPlayers";

    public static final String FUNC_GETPRICEALL = "getPriceAll";

    public static final String FUNC_GETRANDOMNESS = "getRandomness";

    public static final String FUNC_GETRECENTWINNER = "getRecentWinner";

    public static final String FUNC_KEYHASH = "keyhash";

    public static final String FUNC_LOTTERY_STATE = "lottery_state";

    public static final String FUNC_NUMWORDS = "numWords";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PLAYERS = "players";

    public static final String FUNC_RANDOMNESS = "randomness";

    public static final String FUNC_RAWFULFILLRANDOMWORDS = "rawFulfillRandomWords";

    public static final String FUNC_RECENTWINNER = "recentWinner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_REQUESTCONFIRMATIONS = "requestConfirmations";

    public static final String FUNC_S_RANDOMWORDS = "s_randomWords";

    public static final String FUNC_S_REQUESTID = "s_requestId";

    public static final String FUNC_S_SUBSCRIPTIONID = "s_subscriptionId";

    public static final String FUNC_SETLOTTERYSTATE = "setLotteryState";

    public static final String FUNC_SETNUMRANDOMWORDS = "setNumRandomWords";

    public static final String FUNC_STARTLOTTERY = "startLottery";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_USDENTRYFEE = "usdEntryFee";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Lottery(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Lottery(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Lottery(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Lottery(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<String> COORDINATOR() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COORDINATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> callbackGasLimit() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CALLBACKGASLIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> endLottery() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ENDLOTTERY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> enter() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ENTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> fee() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getEntranceFee() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETENTRANCEFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getLotteryStatus() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETLOTTERYSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> getPlayers() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPLAYERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getPriceAll() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRICEALL, 
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

    public RemoteFunctionCall<BigInteger> getRandomness() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRANDOMNESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getRecentWinner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRECENTWINNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> keyhash() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_KEYHASH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> lottery_state() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LOTTERY_STATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> numWords() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NUMWORDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> players(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PLAYERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> randomness() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RANDOMNESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> rawFulfillRandomWords(BigInteger requestId, List<BigInteger> randomWords) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RAWFULFILLRANDOMWORDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(requestId), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(randomWords, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> recentWinner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RECENTWINNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> requestConfirmations() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_REQUESTCONFIRMATIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> s_randomWords(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_S_RANDOMWORDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> s_requestId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_S_REQUESTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> s_subscriptionId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_S_SUBSCRIPTIONID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setLotteryState(BigInteger _lotState) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETLOTTERYSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(_lotState)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setNumRandomWords(BigInteger _numWords) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETNUMRANDOMWORDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_numWords)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> startLottery() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STARTLOTTERY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> usdEntryFee() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USDENTRYFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Lottery load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Lottery(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Lottery load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Lottery(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Lottery load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Lottery(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Lottery load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Lottery(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Lottery> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _minUsdEntryFee, String _priceFeedAddress, String _vrfCoordinator, String _link, byte[] _keyhash, BigInteger _fee, BigInteger _subscriptionId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minUsdEntryFee), 
                new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.Address(_vrfCoordinator), 
                new org.web3j.abi.datatypes.Address(_link), 
                new org.web3j.abi.datatypes.generated.Bytes32(_keyhash), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee), 
                new org.web3j.abi.datatypes.generated.Uint64(_subscriptionId)));
        return deployRemoteCall(Lottery.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Lottery> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _minUsdEntryFee, String _priceFeedAddress, String _vrfCoordinator, String _link, byte[] _keyhash, BigInteger _fee, BigInteger _subscriptionId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minUsdEntryFee), 
                new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.Address(_vrfCoordinator), 
                new org.web3j.abi.datatypes.Address(_link), 
                new org.web3j.abi.datatypes.generated.Bytes32(_keyhash), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee), 
                new org.web3j.abi.datatypes.generated.Uint64(_subscriptionId)));
        return deployRemoteCall(Lottery.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Lottery> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _minUsdEntryFee, String _priceFeedAddress, String _vrfCoordinator, String _link, byte[] _keyhash, BigInteger _fee, BigInteger _subscriptionId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minUsdEntryFee), 
                new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.Address(_vrfCoordinator), 
                new org.web3j.abi.datatypes.Address(_link), 
                new org.web3j.abi.datatypes.generated.Bytes32(_keyhash), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee), 
                new org.web3j.abi.datatypes.generated.Uint64(_subscriptionId)));
        return deployRemoteCall(Lottery.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Lottery> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _minUsdEntryFee, String _priceFeedAddress, String _vrfCoordinator, String _link, byte[] _keyhash, BigInteger _fee, BigInteger _subscriptionId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minUsdEntryFee), 
                new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.Address(_vrfCoordinator), 
                new org.web3j.abi.datatypes.Address(_link), 
                new org.web3j.abi.datatypes.generated.Bytes32(_keyhash), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee), 
                new org.web3j.abi.datatypes.generated.Uint64(_subscriptionId)));
        return deployRemoteCall(Lottery.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
