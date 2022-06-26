package com.example.ipldashboard.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import io.reactivex.Flowable;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j
 * command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen
 * module</a> to update.
 *
 * <p>
 * Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class LinkToken extends Contract {
	public static final String BINARY = "608060405234801561001057600080fd5b503360009081526001602052604090206b033b2e3c9fd0803ce80000009055610aca8061003e6000396000f3006080604052600436106100b95763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306fdde0381146100be578063095ea7b31461014857806318160ddd1461018057806323b872dd146101a7578063313ce567146101d15780634000aea0146101fc578063661884631461026557806370a082311461028957806395d89b41146102aa578063a9059cbb146102bf578063d73dd623146102e3578063dd62ed3e14610307575b600080fd5b3480156100ca57600080fd5b506100d361032e565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561010d5781810151838201526020016100f5565b50505050905090810190601f16801561013a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561015457600080fd5b5061016c600160a060020a0360043516602435610365565b604080519115158252519081900360200190f35b34801561018c57600080fd5b506101956103a6565b60408051918252519081900360200190f35b3480156101b357600080fd5b5061016c600160a060020a03600435811690602435166044356103b6565b3480156101dd57600080fd5b506101e66103f9565b6040805160ff9092168252519081900360200190f35b34801561020857600080fd5b50604080516020600460443581810135601f810184900484028501840190955284845261016c948235600160a060020a03169460248035953695946064949201919081908401838280828437509497506103fe9650505050505050565b34801561027157600080fd5b5061016c600160a060020a0360043516602435610438565b34801561029557600080fd5b50610195600160a060020a0360043516610528565b3480156102b657600080fd5b506100d3610543565b3480156102cb57600080fd5b5061016c600160a060020a036004351660243561057a565b3480156102ef57600080fd5b5061016c600160a060020a03600435166024356105b3565b34801561031357600080fd5b50610195600160a060020a036004358116906024351661064c565b60408051808201909152600f81527f436861696e4c696e6b20546f6b656e0000000000000000000000000000000000602082015281565b600082600160a060020a038116158015906103895750600160a060020a0381163014155b151561039457600080fd5b61039e8484610677565b949350505050565b6b033b2e3c9fd0803ce800000081565b600082600160a060020a038116158015906103da5750600160a060020a0381163014155b15156103e557600080fd5b6103f08585856106dd565b95945050505050565b601281565b600083600160a060020a038116158015906104225750600160a060020a0381163014155b151561042d57600080fd5b6103f08585856107e9565b336000908152600260209081526040808320600160a060020a03861684529091528120548083111561048d57336000908152600260209081526040808320600160a060020a03881684529091528120556104c2565b61049d818463ffffffff6108ce16565b336000908152600260209081526040808320600160a060020a03891684529091529020555b336000818152600260209081526040808320600160a060020a0389168085529083529281902054815190815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a35060019392505050565b600160a060020a031660009081526001602052604090205490565b60408051808201909152600481527f4c494e4b00000000000000000000000000000000000000000000000000000000602082015281565b600082600160a060020a0381161580159061059e5750600160a060020a0381163014155b15156105a957600080fd5b61039e84846108e0565b336000908152600260209081526040808320600160a060020a03861684529091528120546105e7908363ffffffff61099016565b336000818152600260209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b600160a060020a03918216600090815260026020908152604080832093909416825291909152205490565b336000818152600260209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a350600192915050565b600160a060020a0383166000818152600260209081526040808320338452825280832054938352600190915281205490919061071f908463ffffffff6108ce16565b600160a060020a038087166000908152600160205260408082209390935590861681522054610754908463ffffffff61099016565b600160a060020a03851660009081526001602052604090205561077d818463ffffffff6108ce16565b600160a060020a03808716600081815260026020908152604080832033845282529182902094909455805187815290519288169391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a3506001949350505050565b60006107f584846108e0565b5083600160a060020a031633600160a060020a03167fe19260aff97b920c7df27010903aeb9c8d2be5d310a2c67824cf3f15396e4c1685856040518083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610870578181015183820152602001610858565b50505050905090810190601f16801561089d5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a36108b4846109a3565b156108c4576108c48484846109ab565b5060019392505050565b6000828211156108da57fe5b50900390565b33600090815260016020526040812054610900908363ffffffff6108ce16565b3360009081526001602052604080822092909255600160a060020a03851681522054610932908363ffffffff61099016565b600160a060020a0384166000818152600160209081526040918290209390935580518581529051919233927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a350600192915050565b8181018281101561099d57fe5b92915050565b6000903b1190565b6040517fa4c0ed360000000000000000000000000000000000000000000000000000000081523360048201818152602483018590526060604484019081528451606485015284518794600160a060020a0386169463a4c0ed369490938993899360840190602085019080838360005b83811015610a32578181015183820152602001610a1a565b50505050905090810190601f168015610a5f5780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b158015610a8057600080fd5b505af1158015610a94573d6000803e3d6000fd5b50505050505050505600a165627a7a723058204595c3adf6068922a0858a44f5ad2cee860ce6fc7b25a71f2fbd18703c2d30ec0029";

	public static final String FUNC_NAME = "name";

	public static final String FUNC_APPROVE = "approve";

	public static final String FUNC_TOTALSUPPLY = "totalSupply";

	public static final String FUNC_TRANSFERFROM = "transferFrom";

	public static final String FUNC_DECIMALS = "decimals";

	public static final String FUNC_TRANSFERANDCALL = "transferAndCall";

	public static final String FUNC_DECREASEAPPROVAL = "decreaseApproval";

	public static final String FUNC_BALANCEOF = "balanceOf";

	public static final String FUNC_SYMBOL = "symbol";

	public static final String FUNC_TRANSFER = "transfer";

	public static final String FUNC_INCREASEAPPROVAL = "increaseApproval";

	public static final String FUNC_ALLOWANCE = "allowance";

	public static final Event TRANSFER_EVENT = new Event("Transfer",
			Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
			}, new TypeReference<Address>(true) {
			}, new TypeReference<Uint256>() {
			}, new TypeReference<DynamicBytes>() {
			}));;

	public static final Event APPROVAL_EVENT = new Event("Approval",
			Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
			}, new TypeReference<Address>(true) {
			}, new TypeReference<Uint256>() {
			}));;

	protected static final HashMap<String, String> _addresses;

	static {
		_addresses = new HashMap<String, String>();
	}

	@Deprecated
	protected LinkToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	protected LinkToken(String contractAddress, Web3j web3j, Credentials credentials,
			ContractGasProvider contractGasProvider) {
		super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
	}

	@Deprecated
	protected LinkToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}

	protected LinkToken(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			ContractGasProvider contractGasProvider) {
		super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
	}

	public RemoteFunctionCall<String> name() {
		final Function function = new Function(FUNC_NAME, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
		final Function function = new Function(FUNC_APPROVE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender),
						new org.web3j.abi.datatypes.generated.Uint256(_value)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<BigInteger> totalSupply() {
		final Function function = new Function(FUNC_TOTALSUPPLY, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
		final Function function = new Function(FUNC_TRANSFERFROM,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from),
						new org.web3j.abi.datatypes.Address(_to),
						new org.web3j.abi.datatypes.generated.Uint256(_value)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<BigInteger> decimals() {
		final Function function = new Function(FUNC_DECIMALS, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<TransactionReceipt> transferAndCall(String _to, BigInteger _value, byte[] _data) {
		final Function function = new Function(FUNC_TRANSFERANDCALL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to),
						new org.web3j.abi.datatypes.generated.Uint256(_value),
						new org.web3j.abi.datatypes.DynamicBytes(_data)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> decreaseApproval(String _spender, BigInteger _subtractedValue) {
		final Function function = new Function(FUNC_DECREASEAPPROVAL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender),
						new org.web3j.abi.datatypes.generated.Uint256(_subtractedValue)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<BigInteger> balanceOf(String _owner) {
		final Function function = new Function(FUNC_BALANCEOF,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<String> symbol() {
		final Function function = new Function(FUNC_SYMBOL, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
		final Function function = new Function(FUNC_TRANSFER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to),
						new org.web3j.abi.datatypes.generated.Uint256(_value)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> increaseApproval(String _spender, BigInteger _addedValue) {
		final Function function = new Function(FUNC_INCREASEAPPROVAL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender),
						new org.web3j.abi.datatypes.generated.Uint256(_addedValue)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<BigInteger> allowance(String _owner, String _spender) {
		final Function function = new Function(FUNC_ALLOWANCE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner),
						new org.web3j.abi.datatypes.Address(_spender)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
		List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
		ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
		for (Contract.EventValuesWithLog eventValues : valueList) {
			TransferEventResponse typedResponse = new TransferEventResponse();
			typedResponse.log = eventValues.getLog();
			typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
			typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
			typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
			typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
			responses.add(typedResponse);
		}
		return responses;
	}

	public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
		return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferEventResponse>() {
			@Override
			public TransferEventResponse apply(Log log) {
				Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
				TransferEventResponse typedResponse = new TransferEventResponse();
				typedResponse.log = log;
				typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
				typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
				typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
				typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
				return typedResponse;
			}
		});
	}

//	public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
//			DefaultBlockParameter endBlock) {
//		EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//		filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
//		return transferEventFlowable(filter);
//	}

	public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
		List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
		ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
		for (Contract.EventValuesWithLog eventValues : valueList) {
			ApprovalEventResponse typedResponse = new ApprovalEventResponse();
			typedResponse.log = eventValues.getLog();
			typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
			typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
			typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
			responses.add(typedResponse);
		}
		return responses;
	}

	public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
		return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalEventResponse>() {
			@Override
			public ApprovalEventResponse apply(Log log) {
				Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
				ApprovalEventResponse typedResponse = new ApprovalEventResponse();
				typedResponse.log = log;
				typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
				typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
				typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
				return typedResponse;
			}
		});
	}

	public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock,
			DefaultBlockParameter endBlock) {
		EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
		filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
		return approvalEventFlowable(filter);
	}

//	public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
//		List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
//		ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
//		for (Contract.EventValuesWithLog eventValues : valueList) {
//			TransferEventResponse typedResponse = new TransferEventResponse();
//			typedResponse.log = eventValues.getLog();
//			typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
//			typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
//			typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//			responses.add(typedResponse);
//		}
//		return responses;
//	}

//	public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
//		return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferEventResponse>() {
//			@Override
//			public TransferEventResponse apply(Log log) {
//				Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
//				TransferEventResponse typedResponse = new TransferEventResponse();
//				typedResponse.log = log;
//				typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
//				typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
//				typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//				return typedResponse;
//			}
//		});
//	}

	public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
			DefaultBlockParameter endBlock) {
		EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
		filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
		return transferEventFlowable(filter);
	}

	@Deprecated
	public static LinkToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return new LinkToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	@Deprecated
	public static LinkToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit) {
		return new LinkToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}

	public static LinkToken load(String contractAddress, Web3j web3j, Credentials credentials,
			ContractGasProvider contractGasProvider) {
		return new LinkToken(contractAddress, web3j, credentials, contractGasProvider);
	}

	public static LinkToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			ContractGasProvider contractGasProvider) {
		return new LinkToken(contractAddress, web3j, transactionManager, contractGasProvider);
	}

	public static RemoteCall<LinkToken> deploy(Web3j web3j, Credentials credentials,
			ContractGasProvider contractGasProvider) {
		return deployRemoteCall(LinkToken.class, web3j, credentials, contractGasProvider, BINARY, "");
	}

	public static RemoteCall<LinkToken> deploy(Web3j web3j, TransactionManager transactionManager,
			ContractGasProvider contractGasProvider) {
		return deployRemoteCall(LinkToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
	}

	@Deprecated
	public static RemoteCall<LinkToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(LinkToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
	}

	@Deprecated
	public static RemoteCall<LinkToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(LinkToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
	}

	protected String getStaticDeployedAddress(String networkId) {
		return _addresses.get(networkId);
	}

	public static String getPreviouslyDeployedAddress(String networkId) {
		return _addresses.get(networkId);
	}

	public static class TransferEventResponse extends BaseEventResponse {
		public String from;

		public String to;

		public BigInteger value;

		public byte[] data;
	}

	public static class ApprovalEventResponse extends BaseEventResponse {
		public String owner;

		public String spender;

		public BigInteger value;
	}

}
