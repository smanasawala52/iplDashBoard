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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class TokenFarm extends Contract {
    public static final String BINARY = "600160045560c0604052600f60808190526e4461707020546f6b656e204661726d60881b60a0908152620000379160079190620000eb565b503480156200004557600080fd5b50604051620012b8380380620012b8833981016040819052620000689162000191565b620000733362000099565b600880546001600160a01b0319166001600160a01b0392909216919091179055620001ff565b600680546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b828054620000f990620001c3565b90600052602060002090601f0160209004810192826200011d576000855562000168565b82601f106200013857805160ff191683800117855562000168565b8280016001018555821562000168579182015b82811115620001685782518255916020019190600101906200014b565b50620001769291506200017a565b5090565b5b808211156200017657600081556001016200017b565b600060208284031215620001a457600080fd5b81516001600160a01b0381168114620001bc57600080fd5b9392505050565b600181811c90821680620001d857607f821691505b602082108103620001f957634e487b7160e01b600052602260045260246000fd5b50919050565b6110a9806200020f6000396000f3fe608060405234801561001057600080fd5b50600436106101215760003560e01c8063715018a6116100ad578063b83e023411610071578063b83e023414610279578063dd5b846714610299578063df00018d146102bc578063f2fde38b146102e6578063fd5e6dd1146102f957600080fd5b8063715018a614610227578063877dd39d1461022f5780638da5cb5b146102425780639109754014610253578063af3f5e221461026657600080fd5b806329161a00116100f457806329161a00146101ad5780632d1ad8b8146101e65780635e5f2e26146101f95780635eb186f81461020c57806360ab58521461021f57600080fd5b806306fdde03146101265780630bea440d14610144578063171e44ea1461015957806327927b3e1461016c575b600080fd5b61012e61030c565b60405161013b9190610cae565b60405180910390f35b610157610152366004610d1f565b61039a565b005b610157610167366004610d4b565b610565565b61019561017a366004610d4b565b600c602052600090815260409020546001600160a01b031681565b6040516001600160a01b03909116815260200161013b565b6101d86101bb366004610d6d565b600a60209081526000928352604080842090915290825290205481565b60405190815260200161013b565b6101576101f4366004610d4b565b6105e1565b610195610207366004610d97565b610712565b600854610195906001600160a01b031681565b61015761073c565b61015761083b565b61015761023d366004610d6d565b610871565b6006546001600160a01b0316610195565b6101d8610261366004610d6d565b6108c9565b6101d8610274366004610d4b565b610953565b6101d8610287366004610d4b565b600b6020526000908152604090205481565b6102ac6102a7366004610d4b565b6109d6565b604051901515815260200161013b565b6102cf6102ca366004610d4b565b610a3f565b6040805192835260ff90911660208301520161013b565b6101576102f4366004610d4b565b610b49565b610195610307366004610d97565b610be1565b6007805461031990610db0565b80601f016020809104026020016040519081016040528092919081815260200182805461034590610db0565b80156103925780601f1061036757610100808354040283529160200191610392565b820191906000526020600020905b81548152906001019060200180831161037557829003601f168201915b505050505081565b600082116103e45760405162461bcd60e51b81526020600482015260126024820152710616d6f756e742063616e6e6f7420626520360741b60448201526064015b60405180910390fd5b6103ed816109d6565b6104395760405162461bcd60e51b815260206004820152601d60248201527f546f6b656e2063757272656e746c792069736e277420616c6c6f77656400000060448201526064016103db565b6104433382610bf1565b6040516323b872dd60e01b8152336004820152306024820152604481018390526001600160a01b038216906323b872dd906064016020604051808303816000875af1158015610496573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104ba9190610dea565b506001600160a01b0381166000908152600a602090815260408083203384529091529020546104ea908390610e22565b6001600160a01b0382166000908152600a60209081526040808320338452825280832093909355600b9052205460010361056157600980546001810182556000919091527f6e1540171b6c0c960b71a7020d9f60077f6af931a8bbf590da0223dacf75c7af0180546001600160a01b031916331790555b5050565b6006546001600160a01b0316331461058f5760405162461bcd60e51b81526004016103db90610e3a565b600d80546001810182556000919091527fd7b6990105719101dabeb77144f2a3385c8033acd3af97e9423a695e81ad1eb50180546001600160a01b0319166001600160a01b0392909216919091179055565b6001600160a01b0381166000908152600a60209081526040808320338452909152902054806106525760405162461bcd60e51b815260206004820152601b60248201527f7374616b696e672062616c616e63652063616e6e6f742062652030000000000060448201526064016103db565b60405163a9059cbb60e01b8152336004820152602481018290526001600160a01b0383169063a9059cbb906044016020604051808303816000875af115801561069f573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906106c39190610dea565b506001600160a01b0382166000908152600a602090815260408083203384528252808320839055600b9091529020546106fe90600190610e6f565b336000908152600b60205260409020555050565b600d818154811061072257600080fd5b6000918252602090912001546001600160a01b0316905081565b6006546001600160a01b031633146107665760405162461bcd60e51b81526004016103db90610e3a565b60005b6009548110156108385760006009828154811061078857610788610e86565b6000918252602090912001546008546001600160a01b0391821692501663a9059cbb826107b481610953565b6040516001600160e01b031960e085901b1681526001600160a01b03909216600483015260248201526044016020604051808303816000875af11580156107ff573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906108239190610dea565b5050808061083090610e9c565b915050610769565b50565b6006546001600160a01b031633146108655760405162461bcd60e51b81526004016103db90610e3a565b61086f6000610c5c565b565b6006546001600160a01b0316331461089b5760405162461bcd60e51b81526004016103db90610e3a565b6001600160a01b039182166000908152600c6020526040902080546001600160a01b03191691909216179055565b6001600160a01b0382166000908152600b60205260408120546108ee5750600061094d565b6000806108fa84610a3f565b909250905061090d60ff8216600a610f99565b6001600160a01b038086166000908152600a60209081526040808320938a168352929052205461093e908490610fa5565b6109489190610fc4565b925050505b92915050565b6001600160a01b0381166000908152600b602052604081205481901561094d5760005b600d548110156109cf576109b184600d838154811061099757610997610e86565b6000918252602090912001546001600160a01b03166108c9565b6109bb9083610e22565b9150806109c781610e9c565b915050610976565b5092915050565b6000805b600d54811015610a3657826001600160a01b0316600d8281548110610a0157610a01610e86565b6000918252602090912001546001600160a01b031603610a245750600192915050565b80610a2e81610e9c565b9150506109da565b50600092915050565b6001600160a01b038082166000908152600c6020526040808220548151633fabe5a360e21b8152915192938493911691829184918291829182918291879163feaf968c9160048082019260a0929091908290030181865afa158015610aa8573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610acc9190611000565b9450945094509450945083866001600160a01b031663313ce5676040518163ffffffff1660e01b8152600401602060405180830381865afa158015610b15573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610b399190611050565b9850985050505050505050915091565b6006546001600160a01b03163314610b735760405162461bcd60e51b81526004016103db90610e3a565b6001600160a01b038116610bd85760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b60648201526084016103db565b61083881610c5c565b6009818154811061072257600080fd5b6001600160a01b038082166000908152600a6020908152604080832093861683529290522054610561576001600160a01b0382166000908152600b6020526040902054610c3f906001610e22565b6001600160a01b0383166000908152600b60205260409020555050565b600680546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b600060208083528351808285015260005b81811015610cdb57858101830151858201604001528201610cbf565b81811115610ced576000604083870101525b50601f01601f1916929092016040019392505050565b80356001600160a01b0381168114610d1a57600080fd5b919050565b60008060408385031215610d3257600080fd5b82359150610d4260208401610d03565b90509250929050565b600060208284031215610d5d57600080fd5b610d6682610d03565b9392505050565b60008060408385031215610d8057600080fd5b610d8983610d03565b9150610d4260208401610d03565b600060208284031215610da957600080fd5b5035919050565b600181811c90821680610dc457607f821691505b602082108103610de457634e487b7160e01b600052602260045260246000fd5b50919050565b600060208284031215610dfc57600080fd5b81518015158114610d6657600080fd5b634e487b7160e01b600052601160045260246000fd5b60008219821115610e3557610e35610e0c565b500190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b600082821015610e8157610e81610e0c565b500390565b634e487b7160e01b600052603260045260246000fd5b600060018201610eae57610eae610e0c565b5060010190565b600181815b80851115610ef0578160001904821115610ed657610ed6610e0c565b80851615610ee357918102915b93841c9390800290610eba565b509250929050565b600082610f075750600161094d565b81610f145750600061094d565b8160018114610f2a5760028114610f3457610f50565b600191505061094d565b60ff841115610f4557610f45610e0c565b50506001821b61094d565b5060208310610133831016604e8410600b8410161715610f73575081810a61094d565b610f7d8383610eb5565b8060001904821115610f9157610f91610e0c565b029392505050565b6000610d668383610ef8565b6000816000190483118215151615610fbf57610fbf610e0c565b500290565b600082610fe157634e487b7160e01b600052601260045260246000fd5b500490565b805169ffffffffffffffffffff81168114610d1a57600080fd5b600080600080600060a0868803121561101857600080fd5b61102186610fe6565b945060208601519350604086015192506060860151915061104460808701610fe6565b90509295509295909350565b60006020828403121561106257600080fd5b815160ff81168114610d6657600080fdfea2646970667358221220efeae032acf62fe24dedf88e65ba3478660357358de94c8fe61713ae8e4c4f6764736f6c634300080d0033";

    public static final String FUNC_ADDALLOWEDTOKENS = "addAllowedTokens";

    public static final String FUNC_ALLOWEDTOKENS = "allowedTokens";

    public static final String FUNC_DAPPTOKEN = "dappToken";

    public static final String FUNC_GETTOKENETHPRICE = "getTokenEthPrice";

    public static final String FUNC_GETUSERTOKENSTAKINGBALANCEETHVALUE = "getUserTokenStakingBalanceEthValue";

    public static final String FUNC_GETUSERTOTALVALUE = "getUserTotalValue";

    public static final String FUNC_ISSUETOKENS = "issueTokens";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETPRICEFEEDCONTRACT = "setPriceFeedContract";

    public static final String FUNC_STAKETOKENS = "stakeTokens";

    public static final String FUNC_STAKERS = "stakers";

    public static final String FUNC_STAKINGBALANCE = "stakingBalance";

    public static final String FUNC_TOKENISALLOWED = "tokenIsAllowed";

    public static final String FUNC_TOKENPRICEFEEDMAPPING = "tokenPriceFeedMapping";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UNIQUETOKENSSTAKED = "uniqueTokensStaked";

    public static final String FUNC_UNSTAKETOKENS = "unstakeTokens";

    public static final Event CHAINLINKCANCELLED_EVENT = new Event("ChainlinkCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event CHAINLINKFULFILLED_EVENT = new Event("ChainlinkFulfilled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event CHAINLINKREQUESTED_EVENT = new Event("ChainlinkRequested", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected TokenFarm(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TokenFarm(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TokenFarm(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TokenFarm(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ChainlinkCancelledEventResponse> getChainlinkCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHAINLINKCANCELLED_EVENT, transactionReceipt);
        ArrayList<ChainlinkCancelledEventResponse> responses = new ArrayList<ChainlinkCancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChainlinkCancelledEventResponse typedResponse = new ChainlinkCancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChainlinkCancelledEventResponse> chainlinkCancelledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ChainlinkCancelledEventResponse>() {
            @Override
            public ChainlinkCancelledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHAINLINKCANCELLED_EVENT, log);
                ChainlinkCancelledEventResponse typedResponse = new ChainlinkCancelledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChainlinkCancelledEventResponse> chainlinkCancelledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHAINLINKCANCELLED_EVENT));
        return chainlinkCancelledEventFlowable(filter);
    }

    public List<ChainlinkFulfilledEventResponse> getChainlinkFulfilledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHAINLINKFULFILLED_EVENT, transactionReceipt);
        ArrayList<ChainlinkFulfilledEventResponse> responses = new ArrayList<ChainlinkFulfilledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChainlinkFulfilledEventResponse typedResponse = new ChainlinkFulfilledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChainlinkFulfilledEventResponse> chainlinkFulfilledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ChainlinkFulfilledEventResponse>() {
            @Override
            public ChainlinkFulfilledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHAINLINKFULFILLED_EVENT, log);
                ChainlinkFulfilledEventResponse typedResponse = new ChainlinkFulfilledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChainlinkFulfilledEventResponse> chainlinkFulfilledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHAINLINKFULFILLED_EVENT));
        return chainlinkFulfilledEventFlowable(filter);
    }

    public List<ChainlinkRequestedEventResponse> getChainlinkRequestedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHAINLINKREQUESTED_EVENT, transactionReceipt);
        ArrayList<ChainlinkRequestedEventResponse> responses = new ArrayList<ChainlinkRequestedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChainlinkRequestedEventResponse typedResponse = new ChainlinkRequestedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChainlinkRequestedEventResponse> chainlinkRequestedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ChainlinkRequestedEventResponse>() {
            @Override
            public ChainlinkRequestedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHAINLINKREQUESTED_EVENT, log);
                ChainlinkRequestedEventResponse typedResponse = new ChainlinkRequestedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChainlinkRequestedEventResponse> chainlinkRequestedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHAINLINKREQUESTED_EVENT));
        return chainlinkRequestedEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> addAllowedTokens(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDALLOWEDTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> allowedTokens(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWEDTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> dappToken() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DAPPTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> getTokenEthPrice(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTOKENETHPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getUserTokenStakingBalanceEthValue(String user, String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETUSERTOKENSTAKINGBALANCEETHVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.Address(token)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getUserTotalValue(String user) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETUSERTOTALVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> issueTokens() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ISSUETOKENS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
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

    public RemoteFunctionCall<TransactionReceipt> setPriceFeedContract(String token, String priceFeed) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETPRICEFEEDCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token), 
                new org.web3j.abi.datatypes.Address(priceFeed)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> stakeTokens(BigInteger _amount, String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STAKETOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Address(token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> stakers(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STAKERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> stakingBalance(String param0, String param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STAKINGBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> tokenIsAllowed(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENISALLOWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> tokenPriceFeedMapping(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENPRICEFEEDMAPPING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> uniqueTokensStaked(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_UNIQUETOKENSSTAKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> unstakeTokens(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNSTAKETOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TokenFarm load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenFarm(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TokenFarm load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenFarm(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TokenFarm load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TokenFarm(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TokenFarm load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TokenFarm(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TokenFarm> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _dappTokenAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dappTokenAddress)));
        return deployRemoteCall(TokenFarm.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TokenFarm> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _dappTokenAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dappTokenAddress)));
        return deployRemoteCall(TokenFarm.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TokenFarm> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _dappTokenAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dappTokenAddress)));
        return deployRemoteCall(TokenFarm.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TokenFarm> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _dappTokenAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dappTokenAddress)));
        return deployRemoteCall(TokenFarm.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ChainlinkCancelledEventResponse extends BaseEventResponse {
        public byte[] id;
    }

    public static class ChainlinkFulfilledEventResponse extends BaseEventResponse {
        public byte[] id;
    }

    public static class ChainlinkRequestedEventResponse extends BaseEventResponse {
        public byte[] id;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
