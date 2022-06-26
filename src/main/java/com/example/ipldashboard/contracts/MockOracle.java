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
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Bytes4;
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
public class MockOracle extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610c3a380380610c3a8339818101604052602081101561003357600080fd5b5051600080546001600160a01b039092166001600160a01b0319909216919091179055610bd5806100656000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063165d35e1146100675780631f8f238c1461008b57806340429946146100c25780634b602282146101755780636ee4d5531461018f578063a4c0ed36146101c8575b600080fd5b61006f610283565b604080516001600160a01b039092168252519081900360200190f35b6100ae600480360360408110156100a157600080fd5b5080359060200135610292565b604080519115158252519081900360200190f35b61017360048036036101008110156100d957600080fd5b6001600160a01b038235811692602081013592604082013592606083013516916001600160e01b03196080820135169160a08201359160c081013591810190610100810160e082013564010000000081111561013457600080fd5b82018360208201111561014657600080fd5b8035906020019184600183028401116401000000008311171561016857600080fd5b5090925090506104a9565b005b61017d610776565b60408051918252519081900360200190f35b610173600480360360808110156101a557600080fd5b508035906020810135906001600160e01b0319604082013516906060013561077c565b610173600480360360608110156101de57600080fd5b6001600160a01b038235169160208101359181019060608101604082013564010000000081111561020e57600080fd5b82018360208201111561022057600080fd5b8035906020019184600183028401116401000000008311171561024257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506108fa945050505050565b6000546001600160a01b031690565b60008281526001602052604081205483906001600160a01b03166102fd576040805162461bcd60e51b815260206004820152601b60248201527f4d757374206861766520612076616c6964207265717565737449640000000000604482015290519081900360640190fd5b610305610b88565b506000848152600160208181526040808420815180830190925280546001600160a01b03811683526001600160e01b0319600160a01b820460e01b168385015294899052929091526001600160c01b0319909216905562061a805a10156103b3576040805162461bcd60e51b815260206004820181905260248201527f4d7573742070726f7669646520636f6e73756d657220656e6f75676820676173604482015290519081900360640190fd5b805160208083015160408051602481018a905260448082018a9052825180830390910181526064909101825292830180516001600160e01b03166001600160e01b03199093169290921782525182516000946001600160a01b0316939282918083835b602083106104355780518252601f199092019160209182019101610416565b6001836020036101000a0380198251168184511680821785525050505050509050019150506000604051808303816000865af19150503d8060008114610497576040519150601f19603f3d011682016040523d82523d6000602084013e61049c565b606091505b5090979650505050505050565b6104b1610283565b6001600160a01b0316336001600160a01b03161461050c576040805162461bcd60e51b815260206004820152601360248201527226bab9ba103ab9b2902624a725903a37b5b2b760691b604482015290519081900360640190fd5b60005486906001600160a01b0380831691161415610571576040805162461bcd60e51b815260206004820152601760248201527f43616e6e6f742063616c6c6261636b20746f204c494e4b000000000000000000604482015290519081900360640190fd5b604080516bffffffffffffffffffffffff1960608d901b166020808301919091526034808301899052835180840390910181526054909201835281519181019190912060008181526001909252919020546001600160a01b031615610614576040805162461bcd60e51b8152602060048201526014602482015273135d5cdd081d5cd94818481d5b9a5c5d5948125160621b604482015290519081900360640190fd5b60006106224261012c610b27565b905060405180604001604052808a6001600160a01b03168152602001896001600160e01b0319168152506001600084815260200190815260200160002060008201518160000160006101000a8154816001600160a01b0302191690836001600160a01b0316021790555060208201518160000160146101000a81548163ffffffff021916908360e01c0217905550905050897fd8d7ecc4800d25fa53ce0372f13a416d98907a7ef3d8d3bdd79cf4fe75529c658d848e8d8d878d8d8d604051808a6001600160a01b03168152602001898152602001888152602001876001600160a01b03168152602001866001600160e01b0319168152602001858152602001848152602001806020018281038252848482818152602001925080828437600083820152604051601f909101601f19169092018290039c50909a5050505050505050505050a2505050505050505050505050565b61012c81565b6000848152600160205260409020546001600160a01b03166107dc576040805162461bcd60e51b8152602060048201526014602482015273135d5cdd081d5cd94818481d5b9a5c5d5948125160621b604482015290519081900360640190fd5b4281111561082a576040805162461bcd60e51b815260206004820152601660248201527514995c5d595cdd081a5cc81b9bdd08195e1c1a5c995960521b604482015290519081900360640190fd5b60008481526001602052604080822080546001600160c01b03191690555185917fa7842b9ec549398102c0d91b1b9919b2f20558aefdadf57528a95c6cd3292e9391a2600080546040805163a9059cbb60e01b81523360048201526024810187905290516001600160a01b039092169263a9059cbb926044808401936020939083900390910190829087803b1580156108c257600080fd5b505af11580156108d6573d6000803e3d6000fd5b505050506040513d60208110156108ec57600080fd5b50516108f457fe5b50505050565b610902610283565b6001600160a01b0316336001600160a01b03161461095d576040805162461bcd60e51b815260206004820152601360248201527226bab9ba103ab9b2902624a725903a37b5b2b760691b604482015290519081900360640190fd5b80518190604411156109af576040805162461bcd60e51b8152602060048201526016602482015275092dcecc2d8d2c840e4cae2eacae6e840d8cadccee8d60531b604482015290519081900360640190fd5b602082015182906001600160e01b031981166320214ca360e11b14610a1b576040805162461bcd60e51b815260206004820152601e60248201527f4d757374207573652077686974656c69737465642066756e6374696f6e730000604482015290519081900360640190fd5b8560248501528460448501526000306001600160a01b0316856040518082805190602001908083835b60208310610a635780518252601f199092019160209182019101610a44565b6001836020036101000a038019825116818451168082178552505050505050905001915050600060405180830381855af49150503d8060008114610ac3576040519150601f19603f3d011682016040523d82523d6000602084013e610ac8565b606091505b5050905080610b1e576040805162461bcd60e51b815260206004820152601860248201527f556e61626c6520746f2063726561746520726571756573740000000000000000604482015290519081900360640190fd5b50505050505050565b600082820183811015610b81576040805162461bcd60e51b815260206004820152601b60248201527f536166654d6174683a206164646974696f6e206f766572666c6f770000000000604482015290519081900360640190fd5b9392505050565b60408051808201909152600080825260208201529056fea26469706673582212205ee75445ace9ef9d9e14586a5ae080a34b7794a44bb03b6f6638abd056685f7f64736f6c634300060c0033";

    public static final String FUNC_EXPIRY_TIME = "EXPIRY_TIME";

    public static final String FUNC_CANCELORACLEREQUEST = "cancelOracleRequest";

    public static final String FUNC_FULFILLORACLEREQUEST = "fulfillOracleRequest";

    public static final String FUNC_GETCHAINLINKTOKEN = "getChainlinkToken";

    public static final String FUNC_ONTOKENTRANSFER = "onTokenTransfer";

    public static final String FUNC_ORACLEREQUEST = "oracleRequest";

    public static final Event CANCELORACLEREQUEST_EVENT = new Event("CancelOracleRequest", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event ORACLEREQUEST_EVENT = new Event("OracleRequest", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes4>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MockOracle(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MockOracle(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MockOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MockOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<CancelOracleRequestEventResponse> getCancelOracleRequestEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CANCELORACLEREQUEST_EVENT, transactionReceipt);
        ArrayList<CancelOracleRequestEventResponse> responses = new ArrayList<CancelOracleRequestEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelOracleRequestEventResponse typedResponse = new CancelOracleRequestEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelOracleRequestEventResponse> cancelOracleRequestEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CancelOracleRequestEventResponse>() {
            @Override
            public CancelOracleRequestEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCELORACLEREQUEST_EVENT, log);
                CancelOracleRequestEventResponse typedResponse = new CancelOracleRequestEventResponse();
                typedResponse.log = log;
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelOracleRequestEventResponse> cancelOracleRequestEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCELORACLEREQUEST_EVENT));
        return cancelOracleRequestEventFlowable(filter);
    }

    public List<OracleRequestEventResponse> getOracleRequestEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ORACLEREQUEST_EVENT, transactionReceipt);
        ArrayList<OracleRequestEventResponse> responses = new ArrayList<OracleRequestEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OracleRequestEventResponse typedResponse = new OracleRequestEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.specId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.requester = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.requestId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.payment = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.callbackAddr = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.callbackFunctionId = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.cancelExpiration = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.dataVersion = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OracleRequestEventResponse> oracleRequestEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OracleRequestEventResponse>() {
            @Override
            public OracleRequestEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ORACLEREQUEST_EVENT, log);
                OracleRequestEventResponse typedResponse = new OracleRequestEventResponse();
                typedResponse.log = log;
                typedResponse.specId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.requester = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.requestId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.payment = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.callbackAddr = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.callbackFunctionId = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.cancelExpiration = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.dataVersion = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OracleRequestEventResponse> oracleRequestEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ORACLEREQUEST_EVENT));
        return oracleRequestEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> EXPIRY_TIME() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EXPIRY_TIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelOracleRequest(byte[] _requestId, BigInteger _payment, byte[] param2, BigInteger _expiration) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCELORACLEREQUEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Uint256(_payment), 
                new org.web3j.abi.datatypes.generated.Bytes4(param2), 
                new org.web3j.abi.datatypes.generated.Uint256(_expiration)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> fulfillOracleRequest(byte[] _requestId, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FULFILLORACLEREQUEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getChainlinkToken() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCHAINLINKTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> onTokenTransfer(String _sender, BigInteger _amount, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONTOKENTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_sender), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> oracleRequest(String _sender, BigInteger _payment, byte[] _specId, String _callbackAddress, byte[] _callbackFunctionId, BigInteger _nonce, BigInteger _dataVersion, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ORACLEREQUEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_sender), 
                new org.web3j.abi.datatypes.generated.Uint256(_payment), 
                new org.web3j.abi.datatypes.generated.Bytes32(_specId), 
                new org.web3j.abi.datatypes.Address(_callbackAddress), 
                new org.web3j.abi.datatypes.generated.Bytes4(_callbackFunctionId), 
                new org.web3j.abi.datatypes.generated.Uint256(_nonce), 
                new org.web3j.abi.datatypes.generated.Uint256(_dataVersion), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MockOracle load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockOracle(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MockOracle load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockOracle(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MockOracle load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MockOracle(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MockOracle load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MockOracle(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MockOracle> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _link) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_link)));
        return deployRemoteCall(MockOracle.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MockOracle> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _link) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_link)));
        return deployRemoteCall(MockOracle.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MockOracle> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _link) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_link)));
        return deployRemoteCall(MockOracle.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MockOracle> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _link) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_link)));
        return deployRemoteCall(MockOracle.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class CancelOracleRequestEventResponse extends BaseEventResponse {
        public byte[] requestId;
    }

    public static class OracleRequestEventResponse extends BaseEventResponse {
        public byte[] specId;

        public String requester;

        public byte[] requestId;

        public BigInteger payment;

        public String callbackAddr;

        public byte[] callbackFunctionId;

        public BigInteger cancelExpiration;

        public BigInteger dataVersion;

        public byte[] data;
    }
}
