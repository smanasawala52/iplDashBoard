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
public class PaymentSplitter extends Contract {
    public static final String BINARY = "0x60806040526040516200116b3803806200116b83398101604081905262000026916200042e565b8051825114620000985760405162461bcd60e51b815260206004820152603260248201527f5061796d656e7453706c69747465723a2070617965657320616e6420736861726044820152710cae640d8cadccee8d040dad2e6dac2e8c6d60731b60648201526084015b60405180910390fd5b6000825111620000eb5760405162461bcd60e51b815260206004820152601a60248201527f5061796d656e7453706c69747465723a206e6f2070617965657300000000000060448201526064016200008f565b60005b82518110156200015757620001428382815181106200011157620001116200050c565b60200260200101518383815181106200012e576200012e6200050c565b60200260200101516200016060201b60201c565b806200014e8162000538565b915050620000ee565b50505062000571565b6001600160a01b038216620001cd5760405162461bcd60e51b815260206004820152602c60248201527f5061796d656e7453706c69747465723a206163636f756e74206973207468652060448201526b7a65726f206164647265737360a01b60648201526084016200008f565b600081116200021f5760405162461bcd60e51b815260206004820152601d60248201527f5061796d656e7453706c69747465723a2073686172657320617265203000000060448201526064016200008f565b6001600160a01b038216600090815260026020526040902054156200029b5760405162461bcd60e51b815260206004820152602b60248201527f5061796d656e7453706c69747465723a206163636f756e7420616c726561647960448201526a206861732073686172657360a81b60648201526084016200008f565b60048054600181019091557f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b0180546001600160a01b0319166001600160a01b0384169081179091556000908152600260205260408120829055546200030390829062000556565b600055604080516001600160a01b0384168152602081018390527f40c340f65e17194d14ddddb073d3c9f888e3cb52b5aae0c6c7706b4fbc905fac910160405180910390a15050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f191681016001600160401b03811182821017156200038d576200038d6200034c565b604052919050565b60006001600160401b03821115620003b157620003b16200034c565b5060051b60200190565b600082601f830112620003cd57600080fd5b81516020620003e6620003e08362000395565b62000362565b82815260059290921b840181019181810190868411156200040657600080fd5b8286015b848110156200042357805183529183019183016200040a565b509695505050505050565b600080604083850312156200044257600080fd5b82516001600160401b03808211156200045a57600080fd5b818501915085601f8301126200046f57600080fd5b8151602062000482620003e08362000395565b82815260059290921b84018101918181019089841115620004a257600080fd5b948201945b83861015620004d95785516001600160a01b0381168114620004c95760008081fd5b82529482019490820190620004a7565b91880151919650909350505080821115620004f357600080fd5b506200050285828601620003bb565b9150509250929050565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b60006000198214156200054f576200054f62000522565b5060010190565b600082198211156200056c576200056c62000522565b500190565b610bea80620005816000396000f3fe60806040526004361061008a5760003560e01c80638b83209b116100595780638b83209b146101845780639852595c146101bc578063ce7c2ac2146101f2578063d79779b214610228578063e33b7de31461025e57600080fd5b806319165587146100d85780633a98ef39146100fa578063406072a91461011e57806348b750441461016457600080fd5b366100d3577f6ef95f06320e7a25a04a175ca677b7052bdd97131872c2192525a629f51be77033604080516001600160a01b0390921682523460208301520160405180910390a1005b600080fd5b3480156100e457600080fd5b506100f86100f336600461095e565b610273565b005b34801561010657600080fd5b506000545b6040519081526020015b60405180910390f35b34801561012a57600080fd5b5061010b61013936600461097b565b6001600160a01b03918216600090815260066020908152604080832093909416825291909152205490565b34801561017057600080fd5b506100f861017f36600461097b565b6103aa565b34801561019057600080fd5b506101a461019f3660046109b4565b610592565b6040516001600160a01b039091168152602001610115565b3480156101c857600080fd5b5061010b6101d736600461095e565b6001600160a01b031660009081526003602052604090205490565b3480156101fe57600080fd5b5061010b61020d36600461095e565b6001600160a01b031660009081526002602052604090205490565b34801561023457600080fd5b5061010b61024336600461095e565b6001600160a01b031660009081526005602052604090205490565b34801561026a57600080fd5b5060015461010b565b6001600160a01b0381166000908152600260205260409020546102b15760405162461bcd60e51b81526004016102a8906109cd565b60405180910390fd5b60006102bc60015490565b6102c69047610a29565b905060006102f383836102ee866001600160a01b031660009081526003602052604090205490565b6105c2565b9050806103125760405162461bcd60e51b81526004016102a890610a41565b6001600160a01b0383166000908152600360205260408120805483929061033a908490610a29565b9250508190555080600160008282546103539190610a29565b9091555061036390508382610607565b604080516001600160a01b0385168152602081018390527fdf20fd1e76bc69d672e4814fafb2c449bba3a5369d8359adf9e05e6fde87b056910160405180910390a1505050565b6001600160a01b0381166000908152600260205260409020546103df5760405162461bcd60e51b81526004016102a8906109cd565b6001600160a01b0382166000908152600560205260408120546040516370a0823160e01b81523060048201526001600160a01b038516906370a082319060240160206040518083038186803b15801561043757600080fd5b505afa15801561044b573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061046f9190610a8c565b6104799190610a29565b905060006104b283836102ee87876001600160a01b03918216600090815260066020908152604080832093909416825291909152205490565b9050806104d15760405162461bcd60e51b81526004016102a890610a41565b6001600160a01b03808516600090815260066020908152604080832093871683529290529081208054839290610508908490610a29565b90915550506001600160a01b03841660009081526005602052604081208054839290610535908490610a29565b909155506105469050848483610725565b604080516001600160a01b038581168252602082018490528616917f3be5b7a71e84ed12875d241991c70855ac5817d847039e17a9d895c1ceb0f18a910160405180910390a250505050565b6000600482815481106105a7576105a7610aa5565b6000918252602090912001546001600160a01b031692915050565b600080546001600160a01b0385168252600260205260408220548391906105e99086610abb565b6105f39190610ada565b6105fd9190610afc565b90505b9392505050565b804710156106575760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a20696e73756666696369656e742062616c616e636500000060448201526064016102a8565b6000826001600160a01b03168260405160006040518083038185875af1925050503d80600081146106a4576040519150601f19603f3d011682016040523d82523d6000602084013e6106a9565b606091505b50509050806107205760405162461bcd60e51b815260206004820152603a60248201527f416464726573733a20756e61626c6520746f2073656e642076616c75652c207260448201527f6563697069656e74206d6179206861766520726576657274656400000000000060648201526084016102a8565b505050565b604080516001600160a01b03848116602483015260448083018590528351808403909101815260649092018352602080830180516001600160e01b031663a9059cbb60e01b17905283518085019094528084527f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c656490840152610720928692916000916107b5918516908490610832565b80519091501561072057808060200190518101906107d39190610b13565b6107205760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b60648201526084016102a8565b60606105fd8484600085856001600160a01b0385163b6108945760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016102a8565b600080866001600160a01b031685876040516108b09190610b65565b60006040518083038185875af1925050503d80600081146108ed576040519150601f19603f3d011682016040523d82523d6000602084013e6108f2565b606091505b509150915061090282828661090d565b979650505050505050565b6060831561091c575081610600565b82511561092c5782518084602001fd5b8160405162461bcd60e51b81526004016102a89190610b81565b6001600160a01b038116811461095b57600080fd5b50565b60006020828403121561097057600080fd5b813561060081610946565b6000806040838503121561098e57600080fd5b823561099981610946565b915060208301356109a981610946565b809150509250929050565b6000602082840312156109c657600080fd5b5035919050565b60208082526026908201527f5061796d656e7453706c69747465723a206163636f756e7420686173206e6f2060408201526573686172657360d01b606082015260800190565b634e487b7160e01b600052601160045260246000fd5b60008219821115610a3c57610a3c610a13565b500190565b6020808252602b908201527f5061796d656e7453706c69747465723a206163636f756e74206973206e6f742060408201526a191d59481c185e5b595b9d60aa1b606082015260800190565b600060208284031215610a9e57600080fd5b5051919050565b634e487b7160e01b600052603260045260246000fd5b6000816000190483118215151615610ad557610ad5610a13565b500290565b600082610af757634e487b7160e01b600052601260045260246000fd5b500490565b600082821015610b0e57610b0e610a13565b500390565b600060208284031215610b2557600080fd5b8151801515811461060057600080fd5b60005b83811015610b50578181015183820152602001610b38565b83811115610b5f576000848401525b50505050565b60008251610b77818460208701610b35565b9190910192915050565b6020815260008251806020840152610ba0816040850160208701610b35565b601f01601f1916919091016040019291505056fea2646970667358221220e34b492284674d234656096aede60eedf553b01d4c4d9040a707c85136134edc64736f6c63430008090033";

    public static final String FUNC_PAYEE = "payee";

    public static final String FUNC_release = "release";

    public static final String FUNC_released = "released";

    public static final String FUNC_SHARES = "shares";

    public static final String FUNC_totalReleased = "totalReleased";

    public static final String FUNC_TOTALSHARES = "totalShares";

    public static final Event ERC20PAYMENTRELEASED_EVENT = new Event("ERC20PaymentReleased", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event PAYEEADDED_EVENT = new Event("PayeeAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event PAYMENTRECEIVED_EVENT = new Event("PaymentReceived", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event PAYMENTRELEASED_EVENT = new Event("PaymentReleased", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected PaymentSplitter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PaymentSplitter(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PaymentSplitter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PaymentSplitter(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ERC20PaymentReleasedEventResponse> getERC20PaymentReleasedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ERC20PAYMENTRELEASED_EVENT, transactionReceipt);
        ArrayList<ERC20PaymentReleasedEventResponse> responses = new ArrayList<ERC20PaymentReleasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ERC20PaymentReleasedEventResponse typedResponse = new ERC20PaymentReleasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ERC20PaymentReleasedEventResponse> eRC20PaymentReleasedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ERC20PaymentReleasedEventResponse>() {
            @Override
            public ERC20PaymentReleasedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ERC20PAYMENTRELEASED_EVENT, log);
                ERC20PaymentReleasedEventResponse typedResponse = new ERC20PaymentReleasedEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ERC20PaymentReleasedEventResponse> eRC20PaymentReleasedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ERC20PAYMENTRELEASED_EVENT));
        return eRC20PaymentReleasedEventFlowable(filter);
    }

    public List<PayeeAddedEventResponse> getPayeeAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAYEEADDED_EVENT, transactionReceipt);
        ArrayList<PayeeAddedEventResponse> responses = new ArrayList<PayeeAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PayeeAddedEventResponse typedResponse = new PayeeAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.shares = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PayeeAddedEventResponse> payeeAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PayeeAddedEventResponse>() {
            @Override
            public PayeeAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAYEEADDED_EVENT, log);
                PayeeAddedEventResponse typedResponse = new PayeeAddedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.shares = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PayeeAddedEventResponse> payeeAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYEEADDED_EVENT));
        return payeeAddedEventFlowable(filter);
    }

    public List<PaymentReceivedEventResponse> getPaymentReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAYMENTRECEIVED_EVENT, transactionReceipt);
        ArrayList<PaymentReceivedEventResponse> responses = new ArrayList<PaymentReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PaymentReceivedEventResponse typedResponse = new PaymentReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PaymentReceivedEventResponse> paymentReceivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PaymentReceivedEventResponse>() {
            @Override
            public PaymentReceivedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAYMENTRECEIVED_EVENT, log);
                PaymentReceivedEventResponse typedResponse = new PaymentReceivedEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PaymentReceivedEventResponse> paymentReceivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYMENTRECEIVED_EVENT));
        return paymentReceivedEventFlowable(filter);
    }

    public List<PaymentReleasedEventResponse> getPaymentReleasedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAYMENTRELEASED_EVENT, transactionReceipt);
        ArrayList<PaymentReleasedEventResponse> responses = new ArrayList<PaymentReleasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PaymentReleasedEventResponse typedResponse = new PaymentReleasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PaymentReleasedEventResponse> paymentReleasedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PaymentReleasedEventResponse>() {
            @Override
            public PaymentReleasedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAYMENTRELEASED_EVENT, log);
                PaymentReleasedEventResponse typedResponse = new PaymentReleasedEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PaymentReleasedEventResponse> paymentReleasedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAYMENTRELEASED_EVENT));
        return paymentReleasedEventFlowable(filter);
    }

    public RemoteFunctionCall<String> payee(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAYEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> release(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_release, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> release(String token, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_release, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> released(String token, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_released, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token), 
                new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> released(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_released, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> shares(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SHARES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalReleased(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_totalReleased, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalReleased() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_totalReleased, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalShares() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSHARES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static PaymentSplitter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PaymentSplitter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PaymentSplitter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PaymentSplitter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PaymentSplitter load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PaymentSplitter(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PaymentSplitter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PaymentSplitter(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PaymentSplitter> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<String> payees, List<BigInteger> shares_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(payees, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(shares_, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(PaymentSplitter.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PaymentSplitter> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<String> payees, List<BigInteger> shares_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(payees, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(shares_, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(PaymentSplitter.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PaymentSplitter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> payees, List<BigInteger> shares_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(payees, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(shares_, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(PaymentSplitter.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PaymentSplitter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> payees, List<BigInteger> shares_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(payees, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(shares_, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(PaymentSplitter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ERC20PaymentReleasedEventResponse extends BaseEventResponse {
        public String token;

        public String to;

        public BigInteger amount;
    }

    public static class PayeeAddedEventResponse extends BaseEventResponse {
        public String account;

        public BigInteger shares;
    }

    public static class PaymentReceivedEventResponse extends BaseEventResponse {
        public String from;

        public BigInteger amount;
    }

    public static class PaymentReleasedEventResponse extends BaseEventResponse {
        public String to;

        public BigInteger amount;
    }
}
