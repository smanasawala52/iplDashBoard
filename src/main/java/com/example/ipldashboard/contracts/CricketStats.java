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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class CricketStats extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200203f3803806200203f83398101604081905262000034916200026c565b8351849084906200004d906000906020850190620000f9565b50805162000063906001906020840190620000f9565b505050620000806200007a620000a360201b60201c565b620000a7565b81516200009590600d906020850190620000f9565b50600a555062000341915050565b3390565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b828054620001079062000305565b90600052602060002090601f0160209004810192826200012b576000855562000176565b82601f106200014657805160ff191683800117855562000176565b8280016001018555821562000176579182015b828111156200017657825182559160200191906001019062000159565b506200018492915062000188565b5090565b5b8082111562000184576000815560010162000189565b634e487b7160e01b600052604160045260246000fd5b600082601f830112620001c757600080fd5b81516001600160401b0380821115620001e457620001e46200019f565b604051601f8301601f19908116603f011681019082821181831017156200020f576200020f6200019f565b816040528381526020925086838588010111156200022c57600080fd5b600091505b8382101562000250578582018301518183018401529082019062000231565b83821115620002625760008385830101525b9695505050505050565b600080600080608085870312156200028357600080fd5b84516001600160401b03808211156200029b57600080fd5b620002a988838901620001b5565b95506020870151915080821115620002c057600080fd5b620002ce88838901620001b5565b94506040870151915080821115620002e557600080fd5b50620002f487828801620001b5565b606096909601519497939650505050565b600181811c908216806200031a57607f821691505b6020821081036200033b57634e487b7160e01b600052602260045260246000fd5b50919050565b611cee80620003516000396000f3fe60806040526004361061014b5760003560e01c8063715018a6116100b6578063b88d4fde1161006f578063b88d4fde1461038a578063c87b56dd146103aa578063d204c45e146103ca578063dc0d3dff146103ea578063e985e9c51461040a578063f2fde38b1461045357600080fd5b8063715018a6146102ec5780637e007c1e146103015780638da5cb5b1461031757806395d89b41146103355780639f1cabc61461034a578063a22cb4651461036a57600080fd5b80633c7e7d28116101085780633c7e7d28146102445780633ccfd60b1461027157806342842e0e14610279578063615fd9e2146102995780636352211e146102ac57806370a08231146102cc57600080fd5b806301ffc9a71461015057806306661abd1461018557806306fdde03146101a8578063081812fc146101ca578063095ea7b31461020257806323b872dd14610224575b600080fd5b34801561015c57600080fd5b5061017061016b36600461172f565b610473565b60405190151581526020015b60405180910390f35b34801561019157600080fd5b5061019a6104c5565b60405190815260200161017c565b3480156101b457600080fd5b506101bd6104d5565b60405161017c91906117a4565b3480156101d657600080fd5b506101ea6101e53660046117b7565b610567565b6040516001600160a01b03909116815260200161017c565b34801561020e57600080fd5b5061022261021d3660046117ec565b61058e565b005b34801561023057600080fd5b5061022261023f366004611816565b6106a8565b34801561025057600080fd5b5061019a61025f366004611852565b60096020526000908152604090205481565b6102226106d9565b34801561028557600080fd5b50610222610294366004611816565b61078c565b61019a6102a7366004611919565b6107a7565b3480156102b857600080fd5b506101ea6102c73660046117b7565b610999565b3480156102d857600080fd5b5061019a6102e7366004611852565b6109f9565b3480156102f857600080fd5b50610222610a7f565b34801561030d57600080fd5b5061019a600a5481565b34801561032357600080fd5b506007546001600160a01b03166101ea565b34801561034157600080fd5b506101bd610a93565b34801561035657600080fd5b50610170610365366004611967565b610aa2565b34801561037657600080fd5b5061022261038536600461199c565b610ad1565b34801561039657600080fd5b506102226103a53660046119d8565b610ae0565b3480156103b657600080fd5b506101bd6103c53660046117b7565b610b18565b3480156103d657600080fd5b506102226103e5366004611919565b610b23565b3480156103f657600080fd5b506101ea6104053660046117b7565b610b5a565b34801561041657600080fd5b50610170610425366004611a54565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b34801561045f57600080fd5b5061022261046e366004611852565b610b84565b60006001600160e01b031982166380ac58cd60e01b14806104a457506001600160e01b03198216635b5e139f60e01b145b806104bf57506301ffc9a760e01b6001600160e01b03198316145b92915050565b60006104d060085490565b905090565b6060600080546104e490611a87565b80601f016020809104026020016040519081016040528092919081815260200182805461051090611a87565b801561055d5780601f106105325761010080835404028352916020019161055d565b820191906000526020600020905b81548152906001019060200180831161054057829003601f168201915b5050505050905090565b600061057282610bfa565b506000908152600460205260409020546001600160a01b031690565b600061059982610999565b9050806001600160a01b0316836001600160a01b03160361060b5760405162461bcd60e51b815260206004820152602160248201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656044820152603960f91b60648201526084015b60405180910390fd5b336001600160a01b038216148061062757506106278133610425565b6106995760405162461bcd60e51b815260206004820152603e60248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f7420746f60448201527f6b656e206f776e6572206e6f7220617070726f76656420666f7220616c6c00006064820152608401610602565b6106a38383610c59565b505050565b6106b23382610cc7565b6106ce5760405162461bcd60e51b815260040161060290611ac1565b6106a3838383610d46565b6106e1610ee2565b60405133904780156108fc02916000818181858888f1935050505015801561070d573d6000803e3d6000fd5b5060005b600b5481101561076b57600060096000600b848154811061073457610734611b0f565b60009182526020808320909101546001600160a01b031683528201929092526040019020558061076381611b3b565b915050610711565b50604080516000815260208101918290525161078991600b9161162b565b50565b6106a383838360405180602001604052806000815250610ae0565b600a5460009034908110156108155760405162461bcd60e51b815260206004820152602e60248201527f596f75206e65656420746f207370656e64206d6f726520455448202d206d696e60448201526d696d756d20302e3035204554482160901b6064820152608401610602565b600c836040516108259190611b54565b9081526040519081900360200190205460ff1660010361087d5760405162461bcd60e51b81526020600482015260136024820152724e465420616c7265616479206d696e7465642160681b6044820152606401610602565b66b1a2bc2ec500003410156108c65760405162461bcd60e51b815260206004820152600f60248201526e4e65656420746f207061792075702160881b6044820152606401610602565b60006108d160085490565b90506108e1600880546001019055565b6001600c856040516108f39190611b54565b908152604051908190036020019020805460ff9290921660ff199092169190911790556109208582610f3c565b61092a818561107e565b3360009081526009602052604081208054849290610949908490611b70565b9091555050600b80546001810182556000919091527f0175b7a638427703f0dbe7bb9bbf987a2551717b34e79f33b5b1008d1fa01db90180546001600160a01b0319163317905591505092915050565b6000818152600260205260408120546001600160a01b0316806104bf5760405162461bcd60e51b8152602060048201526018602482015277115490cdcc8c4e881a5b9d985b1a59081d1bdad95b88125160421b6044820152606401610602565b60006001600160a01b038216610a635760405162461bcd60e51b815260206004820152602960248201527f4552433732313a2061646472657373207a65726f206973206e6f7420612076616044820152683634b21037bbb732b960b91b6064820152608401610602565b506001600160a01b031660009081526003602052604090205490565b610a87610ee2565b610a916000611118565b565b6060600180546104e490611a87565b60006001600c83604051610ab69190611b54565b9081526040519081900360200190205460ff16101592915050565b610adc33838361116a565b5050565b610aea3383610cc7565b610b065760405162461bcd60e51b815260040161060290611ac1565b610b1284848484611238565b50505050565b60606104bf8261126b565b610b2b610ee2565b6000610b3660085490565b9050610b46600880546001019055565b610b508382611366565b6106a3818361107e565b600b8181548110610b6a57600080fd5b6000918252602090912001546001600160a01b0316905081565b610b8c610ee2565b6001600160a01b038116610bf15760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b6064820152608401610602565b61078981611118565b6000818152600260205260409020546001600160a01b03166107895760405162461bcd60e51b8152602060048201526018602482015277115490cdcc8c4e881a5b9d985b1a59081d1bdad95b88125160421b6044820152606401610602565b600081815260046020526040902080546001600160a01b0319166001600160a01b0384169081179091558190610c8e82610999565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b600080610cd383610999565b9050806001600160a01b0316846001600160a01b03161480610d1a57506001600160a01b0380821660009081526005602090815260408083209388168352929052205460ff165b80610d3e5750836001600160a01b0316610d3384610567565b6001600160a01b0316145b949350505050565b826001600160a01b0316610d5982610999565b6001600160a01b031614610dbd5760405162461bcd60e51b815260206004820152602560248201527f4552433732313a207472616e736665722066726f6d20696e636f72726563742060448201526437bbb732b960d91b6064820152608401610602565b6001600160a01b038216610e1f5760405162461bcd60e51b8152602060048201526024808201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646044820152637265737360e01b6064820152608401610602565b610e2a600082610c59565b6001600160a01b0383166000908152600360205260408120805460019290610e53908490611b88565b90915550506001600160a01b0382166000908152600360205260408120805460019290610e81908490611b70565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b6007546001600160a01b03163314610a915760405162461bcd60e51b815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610602565b6001600160a01b038216610f925760405162461bcd60e51b815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f20616464726573736044820152606401610602565b6000818152600260205260409020546001600160a01b031615610ff75760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e746564000000006044820152606401610602565b6001600160a01b0382166000908152600360205260408120805460019290611020908490611b70565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b03861690811790915590518392907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b6000828152600260205260409020546001600160a01b03166110f95760405162461bcd60e51b815260206004820152602e60248201527f45524337323155524953746f726167653a2055524920736574206f66206e6f6e60448201526d32bc34b9ba32b73a103a37b5b2b760911b6064820152608401610602565b600082815260066020908152604090912082516106a392840190611690565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b816001600160a01b0316836001600160a01b0316036111cb5760405162461bcd60e51b815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c6572000000000000006044820152606401610602565b6001600160a01b03838116600081815260056020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b611243848484610d46565b61124f84848484611380565b610b125760405162461bcd60e51b815260040161060290611b9f565b606061127682610bfa565b6000828152600660205260408120805461128f90611a87565b80601f01602080910402602001604051908101604052809291908181526020018280546112bb90611a87565b80156113085780601f106112dd57610100808354040283529160200191611308565b820191906000526020600020905b8154815290600101906020018083116112eb57829003601f168201915b505050505090506000611319611481565b9050805160000361132b575092915050565b81511561135d578082604051602001611345929190611bf1565b60405160208183030381529060405292505050919050565b610d3e84611490565b610adc8282604051806020016040528060008152506114f7565b60006001600160a01b0384163b1561147657604051630a85bd0160e11b81526001600160a01b0385169063150b7a02906113c4903390899088908890600401611c20565b6020604051808303816000875af19250505080156113ff575060408051601f3d908101601f191682019092526113fc91810190611c5d565b60015b61145c573d80801561142d576040519150601f19603f3d011682016040523d82523d6000602084013e611432565b606091505b5080516000036114545760405162461bcd60e51b815260040161060290611b9f565b805181602001fd5b6001600160e01b031916630a85bd0160e11b149050610d3e565b506001949350505050565b6060600d80546104e490611a87565b606061149b82610bfa565b60006114a5611481565b905060008151116114c557604051806020016040528060008152506114f0565b806114cf8461152a565b6040516020016114e0929190611bf1565b6040516020818303038152906040525b9392505050565b6115018383610f3c565b61150e6000848484611380565b6106a35760405162461bcd60e51b815260040161060290611b9f565b6060816000036115515750506040805180820190915260018152600360fc1b602082015290565b8160005b811561157b578061156581611b3b565b91506115749050600a83611c90565b9150611555565b60008167ffffffffffffffff8111156115965761159661186d565b6040519080825280601f01601f1916602001820160405280156115c0576020820181803683370190505b5090505b8415610d3e576115d5600183611b88565b91506115e2600a86611ca4565b6115ed906030611b70565b60f81b81838151811061160257611602611b0f565b60200101906001600160f81b031916908160001a905350611624600a86611c90565b94506115c4565b828054828255906000526020600020908101928215611680579160200282015b8281111561168057825182546001600160a01b0319166001600160a01b0390911617825560209092019160019091019061164b565b5061168c929150611704565b5090565b82805461169c90611a87565b90600052602060002090601f0160209004810192826116be5760008555611680565b82601f106116d757805160ff1916838001178555611680565b82800160010185558215611680579182015b828111156116805782518255916020019190600101906116e9565b5b8082111561168c5760008155600101611705565b6001600160e01b03198116811461078957600080fd5b60006020828403121561174157600080fd5b81356114f081611719565b60005b8381101561176757818101518382015260200161174f565b83811115610b125750506000910152565b6000815180845261179081602086016020860161174c565b601f01601f19169290920160200192915050565b6020815260006114f06020830184611778565b6000602082840312156117c957600080fd5b5035919050565b80356001600160a01b03811681146117e757600080fd5b919050565b600080604083850312156117ff57600080fd5b611808836117d0565b946020939093013593505050565b60008060006060848603121561182b57600080fd5b611834846117d0565b9250611842602085016117d0565b9150604084013590509250925092565b60006020828403121561186457600080fd5b6114f0826117d0565b634e487b7160e01b600052604160045260246000fd5b600067ffffffffffffffff8084111561189e5761189e61186d565b604051601f8501601f19908116603f011681019082821181831017156118c6576118c661186d565b816040528093508581528686860111156118df57600080fd5b858560208301376000602087830101525050509392505050565b600082601f83011261190a57600080fd5b6114f083833560208501611883565b6000806040838503121561192c57600080fd5b611935836117d0565b9150602083013567ffffffffffffffff81111561195157600080fd5b61195d858286016118f9565b9150509250929050565b60006020828403121561197957600080fd5b813567ffffffffffffffff81111561199057600080fd5b610d3e848285016118f9565b600080604083850312156119af57600080fd5b6119b8836117d0565b9150602083013580151581146119cd57600080fd5b809150509250929050565b600080600080608085870312156119ee57600080fd5b6119f7856117d0565b9350611a05602086016117d0565b925060408501359150606085013567ffffffffffffffff811115611a2857600080fd5b8501601f81018713611a3957600080fd5b611a4887823560208401611883565b91505092959194509250565b60008060408385031215611a6757600080fd5b611a70836117d0565b9150611a7e602084016117d0565b90509250929050565b600181811c90821680611a9b57607f821691505b602082108103611abb57634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602e908201527f4552433732313a2063616c6c6572206973206e6f7420746f6b656e206f776e6560408201526d1c881b9bdc88185c1c1c9bdd995960921b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b600060018201611b4d57611b4d611b25565b5060010190565b60008251611b6681846020870161174c565b9190910192915050565b60008219821115611b8357611b83611b25565b500190565b600082821015611b9a57611b9a611b25565b500390565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60008351611c0381846020880161174c565b835190830190611c1781836020880161174c565b01949350505050565b6001600160a01b0385811682528416602082015260408101839052608060608201819052600090611c5390830184611778565b9695505050505050565b600060208284031215611c6f57600080fd5b81516114f081611719565b634e487b7160e01b600052601260045260246000fd5b600082611c9f57611c9f611c7a565b500490565b600082611cb357611cb3611c7a565b50069056fea264697066735822122045b9dea7fdf86fb81141e59e1998e44733dd8927fc049e6f31c1185b28b7e04b64736f6c634300080d0033";

    public static final String FUNC_ADDRESSTOAMOUNT = "addressToAmount";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_COUNT = "count";

    public static final String FUNC_FUNDERS = "funders";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_ISCONTENTOWNED = "isContentOwned";

    public static final String FUNC_MINIMUMWEI = "minimumWEI";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_PAYTOMINT = "payToMint";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SAFEMINT = "safeMint";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected CricketStats(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CricketStats(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CricketStats(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CricketStats(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
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

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> addressToAmount(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADDRESSTOAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> count() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> funders(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FUNDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.Address(operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isContentOwned(String uri) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISCONTENTOWNED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> minimumWEI() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINIMUMWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payToMint(String recipient, String metadataURI, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAYTOMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(recipient), 
                new org.web3j.abi.datatypes.Utf8String(metadataURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function,amount);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeMint(String to, String uri) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SAFEMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.Utf8String(uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String operator, Boolean approved) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operator), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenURI(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), 
                new org.web3j.abi.datatypes.Address(to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
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

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CricketStats load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CricketStats(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CricketStats load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CricketStats(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CricketStats load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CricketStats(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CricketStats load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CricketStats(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CricketStats> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _name, String _symbol, String _baseUriInput, BigInteger _minimumWEI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_symbol), 
                new org.web3j.abi.datatypes.Utf8String(_baseUriInput), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
        return deployRemoteCall(CricketStats.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CricketStats> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _name, String _symbol, String _baseUriInput, BigInteger _minimumWEI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_symbol), 
                new org.web3j.abi.datatypes.Utf8String(_baseUriInput), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
        return deployRemoteCall(CricketStats.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CricketStats> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, String _symbol, String _baseUriInput, BigInteger _minimumWEI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_symbol), 
                new org.web3j.abi.datatypes.Utf8String(_baseUriInput), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
        return deployRemoteCall(CricketStats.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CricketStats> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, String _symbol, String _baseUriInput, BigInteger _minimumWEI) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_symbol), 
                new org.web3j.abi.datatypes.Utf8String(_baseUriInput), 
                new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
        return deployRemoteCall(CricketStats.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }
}
