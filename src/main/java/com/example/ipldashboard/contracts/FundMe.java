package com.example.ipldashboard.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint80;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class FundMe extends Contract {
    public static final String BINARY = "60806040526802b5e3af16b188000060045534801561001d57600080fd5b5060405161094538038061094583398101604081905261003c91610082565b60028054336001600160a01b031991821617909155600080549091166001600160a01b03841617905561007781670de0b6b3a76400006100bc565b600455506100e99050565b6000806040838503121561009557600080fd5b82516001600160a01b03811681146100ac57600080fd5b6020939093015192949293505050565b60008160001904831182151516156100e457634e487b7160e01b600052601160045260246000fd5b500290565b61084d806100f86000396000f3fe6080604052600436106100a75760003560e01c8063741bef1a11610064578063741bef1a1461018d5780638395a744146101c55780638da5cb5b146101e557806398d5fdca14610205578063b60d42881461021a578063dc0d3dff1461022257600080fd5b806309bc33a7146100ac57806327e1855d146100d45780633430a88c146100f45780633c7e7d281461010a5780633ccfd60b1461013757806360e3949f14610141575b600080fd5b3480156100b857600080fd5b506100c1610242565b6040519081526020015b60405180910390f35b3480156100e057600080fd5b506100c16100ef3660046106c1565b61027c565b34801561010057600080fd5b506100c160045481565b34801561011657600080fd5b506100c16101253660046106da565b60016020526000908152604090205481565b61013f61028d565b005b34801561014d57600080fd5b50610156610397565b6040805169ffffffffffffffffffff968716815260208101959095528401929092526060830152909116608082015260a0016100cb565b34801561019957600080fd5b506000546101ad906001600160a01b031681565b6040516001600160a01b0390911681526020016100cb565b3480156101d157600080fd5b506100c16101e03660046106c1565b610431565b3480156101f157600080fd5b506002546101ad906001600160a01b031681565b34801561021157600080fd5b506100c1610465565b61013f6104de565b34801561022e57600080fd5b506101ad61023d3660046106c1565b61061d565b60008061024d610465565b90506000670de0b6b3a76400009050818160045461026b9190610720565b610275919061073f565b9250505090565b600061028782610431565b92915050565b6002546001600160a01b031633146102ec5760405162461bcd60e51b815260206004820152601e60248201527f4f6e6c792061646d696e2063616e2077697468647261772066756e647321000060448201526064015b60405180910390fd5b60405133904780156108fc02916000818181858888f19350505050158015610318573d6000803e3d6000fd5b5060005b600354811015610376576000600160006003848154811061033f5761033f610761565b60009182526020808320909101546001600160a01b031683528201929092526040019020558061036e81610777565b91505061031c565b50604080516000815260208101918290525161039491600391610647565b50565b60008060008060008060008060008060008054906101000a90046001600160a01b03166001600160a01b031663feaf968c6040518163ffffffff1660e01b815260040160a060405180830381865afa1580156103f7573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061041b91906107af565b939e929d50909b50995090975095505050505050565b60008061043c610465565b90506000670de0b6b3a76400006104538584610720565b61045d919061073f565b949350505050565b6000805460408051633fabe5a360e21b8152905183926001600160a01b03169163feaf968c9160048083019260a09291908290030181865afa1580156104af573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104d391906107af565b509195945050505050565b600254336001600160a01b039091160361053a5760405162461bcd60e51b815260206004820152601d60248201527f4f6e6c79206e6f6e2061646d696e2063616e2066756e6420746869732100000060448201526064016102e3565b6000349050600061054c600454610431565b9050808210156105b35760405162461bcd60e51b815260206004820152602c60248201527f596f75206e65656420746f207370656e64206d6f726520455448202d206d696e60448201526b696d756d203530205553442160a01b60648201526084016102e3565b33600090815260016020526040812080548492906105d29084906107ff565b9091555050600380546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b0180546001600160a01b031916331790555050565b6003818154811061062d57600080fd5b6000918252602090912001546001600160a01b0316905081565b82805482825590600052602060002090810192821561069c579160200282015b8281111561069c57825182546001600160a01b0319166001600160a01b03909116178255602090920191600190910190610667565b506106a89291506106ac565b5090565b5b808211156106a857600081556001016106ad565b6000602082840312156106d357600080fd5b5035919050565b6000602082840312156106ec57600080fd5b81356001600160a01b038116811461070357600080fd5b9392505050565b634e487b7160e01b600052601160045260246000fd5b600081600019048311821515161561073a5761073a61070a565b500290565b60008261075c57634e487b7160e01b600052601260045260246000fd5b500490565b634e487b7160e01b600052603260045260246000fd5b6000600182016107895761078961070a565b5060010190565b805169ffffffffffffffffffff811681146107aa57600080fd5b919050565b600080600080600060a086880312156107c757600080fd5b6107d086610790565b94506020860151935060408601519250606086015191506107f360808701610790565b90509295509295909350565b600082198211156108125761081261070a565b50019056fea26469706673582212201c2796927546b19be21f65c88f8c307e3f1a81e0e5baa1d56d9c33a4c06c69b764736f6c634300080d0033";

    public static final String FUNC_ADDRESSTOAMOUNT = "addressToAmount";

    public static final String FUNC_FUND = "fund";

    public static final String FUNC_FUNDERS = "funders";

    public static final String FUNC_GETCONVERSIONUSDTOWEI = "getConversionUSDToWEI";

    public static final String FUNC_GETCONVERSIONUSDTOWEIVIEW = "getConversionUSDToWEIView";

    public static final String FUNC_GETENTRANCEFEE = "getEntranceFee";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_GETPRICEALL = "getPriceAll";

    public static final String FUNC_MINIMUMUSD = "minimumUSD";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PRICEFEED = "priceFeed";

    public static final String FUNC_WITHDRAW = "withdraw";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected FundMe(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected FundMe(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected FundMe(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected FundMe(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> addressToAmount(String param0) {
        final Function function = new Function(FUNC_ADDRESSTOAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> fund(BigInteger entranceFee) {
        final Function function = new Function(
                FUNC_FUND, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function,entranceFee);
    }

    public RemoteFunctionCall<String> funders(BigInteger param0) {
        final Function function = new Function(FUNC_FUNDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getConversionUSDToWEI(BigInteger ethAmount) {
        final Function function = new Function(FUNC_GETCONVERSIONUSDTOWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ethAmount)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getConversionUSDToWEIView(BigInteger ethAmount) {
        final Function function = new Function(FUNC_GETCONVERSIONUSDTOWEIVIEW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ethAmount)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getEntranceFee() {
        final Function function = new Function(FUNC_GETENTRANCEFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPrice() {
        final Function function = new Function(FUNC_GETPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getPriceAll() {
        final Function function = new Function(FUNC_GETPRICEALL, 
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

    public RemoteFunctionCall<BigInteger> minimumUSD() {
        final Function function = new Function(FUNC_MINIMUMUSD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> priceFeed() {
        final Function function = new Function(FUNC_PRICEFEED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static FundMe load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FundMe(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static FundMe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FundMe(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static FundMe load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new FundMe(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FundMe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new FundMe(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<FundMe> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _priceFeedAddress, BigInteger _minimumUSD) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumUSD)));
        return deployRemoteCall(FundMe.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<FundMe> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _priceFeedAddress, BigInteger _minimumUSD) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumUSD)));
        return deployRemoteCall(FundMe.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FundMe> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _priceFeedAddress, BigInteger _minimumUSD) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumUSD)));
        return deployRemoteCall(FundMe.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FundMe> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _priceFeedAddress, BigInteger _minimumUSD) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_priceFeedAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumUSD)));
        return deployRemoteCall(FundMe.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
