package com.example.ipldashboard.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class SimpleStorage extends Contract {
    public static final String BINARY = "60016080818152610100604052600760c08181526629b430b13134b960c91b60e090815260a091909152600393845591929161003e9160049190610098565b50505034801561004d57600080fd5b5060405161092538038061092583398101604081905261006c91610131565b600280546001600160a01b031916331790558051610091906001906020840190610098565b5050610244565b8280546100a4906101f3565b90600052602060002090601f0160209004810192826100c6576000855561010c565b82601f106100df57805160ff191683800117855561010c565b8280016001018555821561010c579182015b8281111561010c5782518255916020019190600101906100f1565b5061011892915061011c565b5090565b5b80821115610118576000815560010161011d565b60006020808385031215610143578182fd5b82516001600160401b0380821115610159578384fd5b818501915085601f83011261016c578384fd5b81518181111561017e5761017e61022e565b604051601f8201601f19168101850183811182821017156101a1576101a161022e565b60405281815283820185018810156101b7578586fd5b8592505b818310156101d857838301850151818401860152918401916101bb565b818311156101e857858583830101525b979650505050505050565b60028104600182168061020757607f821691505b6020821081141561022857634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fd5b6106d2806102536000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c8063893d20e81161005b578063893d20e8146100d35780638ec4dc95146100e8578063a6b7fc5b146100f0578063ce6d41de146101055761007d565b80636057361d146100825780636f760f411461009757806384c335e6146100aa575b600080fd5b61009561009036600461055f565b61011a565b005b6100956100a536600461051c565b61011f565b6100bd6100b83660046104e1565b610180565b6040516100ca91906105ed565b60405180910390f35b6100db610254565b6040516100ca91906105bf565b6100bd610263565b6100f8610315565b6040516100ca9190610612565b61010d61031b565b6040516100ca91906105d3565b600055565b60408051808201825282815260208101849052905181906005906101449086906105a3565b90815260200160405180910390206000820151816000015560208201518160010190805190602001906101789291906103ad565b505050505050565b610188610431565b60058260405161019891906105a3565b9081526020016040518091039020604051806040016040529081600082015481526020016001820180546101cb9061064b565b80601f01602080910402602001604051908101604052809291908181526020018280546101f79061064b565b80156102445780601f1061021957610100808354040283529160200191610244565b820191906000526020600020905b81548152906001019060200180831161022757829003601f168201915b5050505050815250509050919050565b6002546001600160a01b031690565b61026b610431565b604080518082019091526003805482526004805460208401919061028e9061064b565b80601f01602080910402602001604051908101604052809291908181526020018280546102ba9061064b565b80156103075780601f106102dc57610100808354040283529160200191610307565b820191906000526020600020905b8154815290600101906020018083116102ea57829003601f168201915b505050505081525050905090565b60005490565b60606001805461032a9061064b565b80601f01602080910402602001604051908101604052809291908181526020018280546103569061064b565b80156103a35780601f10610378576101008083540402835291602001916103a3565b820191906000526020600020905b81548152906001019060200180831161038657829003601f168201915b5050505050905090565b8280546103b99061064b565b90600052602060002090601f0160209004810192826103db5760008555610421565b82601f106103f457805160ff1916838001178555610421565b82800160010185558215610421579182015b82811115610421578251825591602001919060010190610406565b5061042d92915061044b565b5090565b604051806040016040528060008152602001606081525090565b5b8082111561042d576000815560010161044c565b600082601f830112610470578081fd5b813567ffffffffffffffff8082111561048b5761048b610686565b604051601f8301601f1916810160200182811182821017156104af576104af610686565b6040528281528483016020018610156104c6578384fd5b82602086016020830137918201602001929092529392505050565b6000602082840312156104f2578081fd5b813567ffffffffffffffff811115610508578182fd5b61051484828501610460565b949350505050565b6000806040838503121561052e578081fd5b823567ffffffffffffffff811115610544578182fd5b61055085828601610460565b95602094909401359450505050565b600060208284031215610570578081fd5b5035919050565b6000815180845261058f81602086016020860161061b565b601f01601f19169290920160200192915050565b600082516105b581846020870161061b565b9190910192915050565b6001600160a01b0391909116815260200190565b6000602082526105e66020830184610577565b9392505050565b6000602082528251602083015260208301516040808401526105146060840182610577565b90815260200190565b60005b8381101561063657818101518382015260200161061e565b83811115610645576000848401525b50505050565b60028104600182168061065f57607f821691505b6020821081141561068057634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fdfea2646970667358221220fa369e8c8956bba9ace7c312ea21881c9087028c262156c9e0bce32184cf33c264736f6c63430008000033";

    public static final String FUNC_ADDPERSON = "addPerson";

    public static final String FUNC_GETMESSAGE = "getMessage";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETPERSON = "getPerson";

    public static final String FUNC_RETRIVE = "retrive";

    public static final String FUNC_RETRIVEPEOPLE = "retrivePeople";

    public static final String FUNC_STORE = "store";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected SimpleStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SimpleStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SimpleStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SimpleStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addPerson(String _name, BigInteger _favNum) {
        final Function function = new Function(
                FUNC_ADDPERSON, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_favNum)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getMessage() {
        final Function function = new Function(FUNC_GETMESSAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<People> getPerson() {
        final Function function = new Function(FUNC_GETPERSON, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<People>() {}));
        return executeRemoteCallSingleValueReturn(function, People.class);
    }

    public RemoteFunctionCall<BigInteger> retrive() {
        final Function function = new Function(FUNC_RETRIVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<People> retrivePeople(String _name) {
        final Function function = new Function(FUNC_RETRIVEPEOPLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<People>() {}));
        return executeRemoteCallSingleValueReturn(function, People.class);
    }

    public RemoteFunctionCall<TransactionReceipt> store(BigInteger _favNum) {
        final Function function = new Function(
                FUNC_STORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_favNum)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SimpleStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SimpleStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SimpleStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SimpleStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SimpleStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SimpleStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _msg) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_msg)));
        return deployRemoteCall(SimpleStorage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _msg) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_msg)));
        return deployRemoteCall(SimpleStorage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _msg) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_msg)));
        return deployRemoteCall(SimpleStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SimpleStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _msg) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_msg)));
        return deployRemoteCall(SimpleStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class People extends DynamicStruct {
        public BigInteger favoriteNumber;

        public String name;

        public People(BigInteger favoriteNumber, String name) {
            super(new org.web3j.abi.datatypes.generated.Uint256(favoriteNumber),new org.web3j.abi.datatypes.Utf8String(name));
            this.favoriteNumber = favoriteNumber;
            this.name = name;
        }

        public People(Uint256 favoriteNumber, Utf8String name) {
            super(favoriteNumber,name);
            this.favoriteNumber = favoriteNumber.getValue();
            this.name = name.getValue();
        }
    }
}
