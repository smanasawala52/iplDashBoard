package com.example.ipldashboard.contracts;

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

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

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
public class CricketStats extends Contract {
	public static final String BINARY = "60806040523480156200001157600080fd5b506040516200226e3803806200226e83398101604081905262000034916200026c565b8351849084906200004d906000906020850190620000f9565b50805162000063906001906020840190620000f9565b505050620000806200007a620000a360201b60201c565b620000a7565b81516200009590600e906020850190620000f9565b50600a555062000341915050565b3390565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b828054620001079062000305565b90600052602060002090601f0160209004810192826200012b576000855562000176565b82601f106200014657805160ff191683800117855562000176565b8280016001018555821562000176579182015b828111156200017657825182559160200191906001019062000159565b506200018492915062000188565b5090565b5b8082111562000184576000815560010162000189565b634e487b7160e01b600052604160045260246000fd5b600082601f830112620001c757600080fd5b81516001600160401b0380821115620001e457620001e46200019f565b604051601f8301601f19908116603f011681019082821181831017156200020f576200020f6200019f565b816040528381526020925086838588010111156200022c57600080fd5b600091505b8382101562000250578582018301518183018401529082019062000231565b83821115620002625760008385830101525b9695505050505050565b600080600080608085870312156200028357600080fd5b84516001600160401b03808211156200029b57600080fd5b620002a988838901620001b5565b95506020870151915080821115620002c057600080fd5b620002ce88838901620001b5565b94506040870151915080821115620002e557600080fd5b50620002f487828801620001b5565b606096909601519497939650505050565b600181811c908216806200031a57607f821691505b6020821081036200033b57634e487b7160e01b600052602260045260246000fd5b50919050565b611f1d80620003516000396000f3fe6080604052600436106101815760003560e01c806370a08231116100d1578063a22cb4651161008a578063d204c45e11610064578063d204c45e14610433578063dc0d3dff14610453578063e985e9c514610473578063f2fde38b146104bc57600080fd5b8063a22cb465146103d3578063b88d4fde146103f3578063c87b56dd1461041357600080fd5b806370a0823114610335578063715018a6146103555780637e007c1e1461036a5780638da5cb5b1461038057806395d89b411461039e5780639f1cabc6146103b357600080fd5b806323b872dd1161013e5780633ccfd60b116101185780633ccfd60b146102cd57806342842e0e146102d55780635b6adec5146102f55780636352211e1461031557600080fd5b806323b872dd1461026d5780633085dfce1461028d5780633c7e7d28146102a057600080fd5b806301ffc9a71461018657806306661abd146101bb57806306fdde03146101de578063081812fc14610200578063095ea7b3146102385780631defad9b1461025a575b600080fd5b34801561019257600080fd5b506101a66101a13660046118ea565b6104dc565b60405190151581526020015b60405180910390f35b3480156101c757600080fd5b506101d061052e565b6040519081526020016101b2565b3480156101ea57600080fd5b506101f361053e565b6040516101b2919061195f565b34801561020c57600080fd5b5061022061021b366004611972565b6105d0565b6040516001600160a01b0390911681526020016101b2565b34801561024457600080fd5b506102586102533660046119a7565b6105f7565b005b6101d0610268366004611a7d565b610711565b34801561027957600080fd5b50610258610288366004611af1565b61093b565b6101d061029b366004611a7d565b61096c565b3480156102ac57600080fd5b506101d06102bb366004611b2d565b60096020526000908152604090205481565b6102586109e1565b3480156102e157600080fd5b506102586102f0366004611af1565b610a94565b34801561030157600080fd5b506101f3610310366004611b48565b610aaf565b34801561032157600080fd5b50610220610330366004611972565b610b54565b34801561034157600080fd5b506101d0610350366004611b2d565b610bb4565b34801561036157600080fd5b50610258610c3a565b34801561037657600080fd5b506101d0600a5481565b34801561038c57600080fd5b506007546001600160a01b0316610220565b3480156103aa57600080fd5b506101f3610c4e565b3480156103bf57600080fd5b506101a66103ce366004611b48565b610c5d565b3480156103df57600080fd5b506102586103ee366004611b7d565b610c8c565b3480156103ff57600080fd5b5061025861040e366004611bb9565b610c9b565b34801561041f57600080fd5b506101f361042e366004611972565b610cd3565b34801561043f57600080fd5b5061025861044e366004611c35565b610cde565b34801561045f57600080fd5b5061022061046e366004611972565b610d15565b34801561047f57600080fd5b506101a661048e366004611c83565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b3480156104c857600080fd5b506102586104d7366004611b2d565b610d3f565b60006001600160e01b031982166380ac58cd60e01b148061050d57506001600160e01b03198216635b5e139f60e01b145b8061052857506301ffc9a760e01b6001600160e01b03198316145b92915050565b600061053960085490565b905090565b60606000805461054d90611cb6565b80601f016020809104026020016040519081016040528092919081815260200182805461057990611cb6565b80156105c65780601f1061059b576101008083540402835291602001916105c6565b820191906000526020600020905b8154815290600101906020018083116105a957829003601f168201915b5050505050905090565b60006105db82610db5565b506000908152600460205260409020546001600160a01b031690565b600061060282610b54565b9050806001600160a01b0316836001600160a01b0316036106745760405162461bcd60e51b815260206004820152602160248201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656044820152603960f91b60648201526084015b60405180910390fd5b336001600160a01b03821614806106905750610690813361048e565b6107025760405162461bcd60e51b815260206004820152603e60248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f7420746f60448201527f6b656e206f776e6572206e6f7220617070726f76656420666f7220616c6c0000606482015260840161066b565b61070c8383610e14565b505050565b600a5460009034908110156107805760405162461bcd60e51b815260206004820152602f60248201527f596f75206e65656420746f207370656e64206d6f726520455448202d206d696e60448201526e696d756d20302e303035204554482160881b606482015260840161066b565b600c846040516107909190611cf0565b9081526040519081900360200190205460ff166001036107e85760405162461bcd60e51b81526020600482015260136024820152724e465420616c7265616479206d696e7465642160681b604482015260640161066b565b6611c37937e080003410156108315760405162461bcd60e51b815260206004820152600f60248201526e4e65656420746f207061792075702160881b604482015260640161066b565b600061083c60085490565b905061084c600880546001019055565b6001600c8660405161085e9190611cf0565b908152602001604051809103902060006101000a81548160ff021916908360ff16021790555083600d866040516108959190611cf0565b908152602001604051809103902090805190602001906108b69291906117e6565b506108c18682610e82565b6108cb8186610fc4565b33600090815260096020526040812080548492906108ea908490611d22565b9091555050600b80546001810182556000919091527f0175b7a638427703f0dbe7bb9bbf987a2551717b34e79f33b5b1008d1fa01db90180546001600160a01b031916331790559150509392505050565b610945338261105e565b6109615760405162461bcd60e51b815260040161066b90611d3a565b61070c8383836110dd565b6000610976611279565b6040513490600c90610989908690611cf0565b9081526040519081900360200190205460ff166001036108315760405162461bcd60e51b81526020600482015260136024820152724e465420616c7265616479206d696e7465642160681b604482015260640161066b565b6109e9611279565b60405133904780156108fc02916000818181858888f19350505050158015610a15573d6000803e3d6000fd5b5060005b600b54811015610a7357600060096000600b8481548110610a3c57610a3c611d88565b60009182526020808320909101546001600160a01b0316835282019290925260400190205580610a6b81611d9e565b915050610a19565b506040805160008152602081019182905251610a9191600b9161186a565b50565b61070c83838360405180602001604052806000815250610c9b565b8051602081830181018051600d8252928201919093012091528054610ad390611cb6565b80601f0160208091040260200160405190810160405280929190818152602001828054610aff90611cb6565b8015610b4c5780601f10610b2157610100808354040283529160200191610b4c565b820191906000526020600020905b815481529060010190602001808311610b2f57829003601f168201915b505050505081565b6000818152600260205260408120546001600160a01b0316806105285760405162461bcd60e51b8152602060048201526018602482015277115490cdcc8c4e881a5b9d985b1a59081d1bdad95b88125160421b604482015260640161066b565b60006001600160a01b038216610c1e5760405162461bcd60e51b815260206004820152602960248201527f4552433732313a2061646472657373207a65726f206973206e6f7420612076616044820152683634b21037bbb732b960b91b606482015260840161066b565b506001600160a01b031660009081526003602052604090205490565b610c42611279565b610c4c60006112d3565b565b60606001805461054d90611cb6565b60006001600c83604051610c719190611cf0565b9081526040519081900360200190205460ff16101592915050565b610c97338383611325565b5050565b610ca5338361105e565b610cc15760405162461bcd60e51b815260040161066b90611d3a565b610ccd848484846113f3565b50505050565b606061052882611426565b610ce6611279565b6000610cf160085490565b9050610d01600880546001019055565b610d0b8382611521565b61070c8183610fc4565b600b8181548110610d2557600080fd5b6000918252602090912001546001600160a01b0316905081565b610d47611279565b6001600160a01b038116610dac5760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b606482015260840161066b565b610a91816112d3565b6000818152600260205260409020546001600160a01b0316610a915760405162461bcd60e51b8152602060048201526018602482015277115490cdcc8c4e881a5b9d985b1a59081d1bdad95b88125160421b604482015260640161066b565b600081815260046020526040902080546001600160a01b0319166001600160a01b0384169081179091558190610e4982610b54565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b6001600160a01b038216610ed85760405162461bcd60e51b815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f2061646472657373604482015260640161066b565b6000818152600260205260409020546001600160a01b031615610f3d5760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e74656400000000604482015260640161066b565b6001600160a01b0382166000908152600360205260408120805460019290610f66908490611d22565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b03861690811790915590518392907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b6000828152600260205260409020546001600160a01b031661103f5760405162461bcd60e51b815260206004820152602e60248201527f45524337323155524953746f726167653a2055524920736574206f66206e6f6e60448201526d32bc34b9ba32b73a103a37b5b2b760911b606482015260840161066b565b6000828152600660209081526040909120825161070c928401906117e6565b60008061106a83610b54565b9050806001600160a01b0316846001600160a01b031614806110b157506001600160a01b0380821660009081526005602090815260408083209388168352929052205460ff165b806110d55750836001600160a01b03166110ca846105d0565b6001600160a01b0316145b949350505050565b826001600160a01b03166110f082610b54565b6001600160a01b0316146111545760405162461bcd60e51b815260206004820152602560248201527f4552433732313a207472616e736665722066726f6d20696e636f72726563742060448201526437bbb732b960d91b606482015260840161066b565b6001600160a01b0382166111b65760405162461bcd60e51b8152602060048201526024808201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646044820152637265737360e01b606482015260840161066b565b6111c1600082610e14565b6001600160a01b03831660009081526003602052604081208054600192906111ea908490611db7565b90915550506001600160a01b0382166000908152600360205260408120805460019290611218908490611d22565b909155505060008181526002602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b6007546001600160a01b03163314610c4c5760405162461bcd60e51b815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604482015260640161066b565b600780546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b816001600160a01b0316836001600160a01b0316036113865760405162461bcd60e51b815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c657200000000000000604482015260640161066b565b6001600160a01b03838116600081815260056020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b6113fe8484846110dd565b61140a8484848461153b565b610ccd5760405162461bcd60e51b815260040161066b90611dce565b606061143182610db5565b6000828152600660205260408120805461144a90611cb6565b80601f016020809104026020016040519081016040528092919081815260200182805461147690611cb6565b80156114c35780601f10611498576101008083540402835291602001916114c3565b820191906000526020600020905b8154815290600101906020018083116114a657829003601f168201915b5050505050905060006114d461163c565b905080516000036114e6575092915050565b815115611518578082604051602001611500929190611e20565b60405160208183030381529060405292505050919050565b6110d58461164b565b610c978282604051806020016040528060008152506116b2565b60006001600160a01b0384163b1561163157604051630a85bd0160e11b81526001600160a01b0385169063150b7a029061157f903390899088908890600401611e4f565b6020604051808303816000875af19250505080156115ba575060408051601f3d908101601f191682019092526115b791810190611e8c565b60015b611617573d8080156115e8576040519150601f19603f3d011682016040523d82523d6000602084013e6115ed565b606091505b50805160000361160f5760405162461bcd60e51b815260040161066b90611dce565b805181602001fd5b6001600160e01b031916630a85bd0160e11b1490506110d5565b506001949350505050565b6060600e805461054d90611cb6565b606061165682610db5565b600061166061163c565b9050600081511161168057604051806020016040528060008152506116ab565b8061168a846116e5565b60405160200161169b929190611e20565b6040516020818303038152906040525b9392505050565b6116bc8383610e82565b6116c9600084848461153b565b61070c5760405162461bcd60e51b815260040161066b90611dce565b60608160000361170c5750506040805180820190915260018152600360fc1b602082015290565b8160005b8115611736578061172081611d9e565b915061172f9050600a83611ebf565b9150611710565b60008167ffffffffffffffff811115611751576117516119d1565b6040519080825280601f01601f19166020018201604052801561177b576020820181803683370190505b5090505b84156110d557611790600183611db7565b915061179d600a86611ed3565b6117a8906030611d22565b60f81b8183815181106117bd576117bd611d88565b60200101906001600160f81b031916908160001a9053506117df600a86611ebf565b945061177f565b8280546117f290611cb6565b90600052602060002090601f016020900481019282611814576000855561185a565b82601f1061182d57805160ff191683800117855561185a565b8280016001018555821561185a579182015b8281111561185a57825182559160200191906001019061183f565b506118669291506118bf565b5090565b82805482825590600052602060002090810192821561185a579160200282015b8281111561185a57825182546001600160a01b0319166001600160a01b0390911617825560209092019160019091019061188a565b5b8082111561186657600081556001016118c0565b6001600160e01b031981168114610a9157600080fd5b6000602082840312156118fc57600080fd5b81356116ab816118d4565b60005b8381101561192257818101518382015260200161190a565b83811115610ccd5750506000910152565b6000815180845261194b816020860160208601611907565b601f01601f19169290920160200192915050565b6020815260006116ab6020830184611933565b60006020828403121561198457600080fd5b5035919050565b80356001600160a01b03811681146119a257600080fd5b919050565b600080604083850312156119ba57600080fd5b6119c38361198b565b946020939093013593505050565b634e487b7160e01b600052604160045260246000fd5b600067ffffffffffffffff80841115611a0257611a026119d1565b604051601f8501601f19908116603f01168101908282118183101715611a2a57611a2a6119d1565b81604052809350858152868686011115611a4357600080fd5b858560208301376000602087830101525050509392505050565b600082601f830112611a6e57600080fd5b6116ab838335602085016119e7565b600080600060608486031215611a9257600080fd5b611a9b8461198b565b9250602084013567ffffffffffffffff80821115611ab857600080fd5b611ac487838801611a5d565b93506040860135915080821115611ada57600080fd5b50611ae786828701611a5d565b9150509250925092565b600080600060608486031215611b0657600080fd5b611b0f8461198b565b9250611b1d6020850161198b565b9150604084013590509250925092565b600060208284031215611b3f57600080fd5b6116ab8261198b565b600060208284031215611b5a57600080fd5b813567ffffffffffffffff811115611b7157600080fd5b6110d584828501611a5d565b60008060408385031215611b9057600080fd5b611b998361198b565b915060208301358015158114611bae57600080fd5b809150509250929050565b60008060008060808587031215611bcf57600080fd5b611bd88561198b565b9350611be66020860161198b565b925060408501359150606085013567ffffffffffffffff811115611c0957600080fd5b8501601f81018713611c1a57600080fd5b611c29878235602084016119e7565b91505092959194509250565b60008060408385031215611c4857600080fd5b611c518361198b565b9150602083013567ffffffffffffffff811115611c6d57600080fd5b611c7985828601611a5d565b9150509250929050565b60008060408385031215611c9657600080fd5b611c9f8361198b565b9150611cad6020840161198b565b90509250929050565b600181811c90821680611cca57607f821691505b602082108103611cea57634e487b7160e01b600052602260045260246000fd5b50919050565b60008251611d02818460208701611907565b9190910192915050565b634e487b7160e01b600052601160045260246000fd5b60008219821115611d3557611d35611d0c565b500190565b6020808252602e908201527f4552433732313a2063616c6c6572206973206e6f7420746f6b656e206f776e6560408201526d1c881b9bdc88185c1c1c9bdd995960921b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b600060018201611db057611db0611d0c565b5060010190565b600082821015611dc957611dc9611d0c565b500390565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b60008351611e32818460208801611907565b835190830190611e46818360208801611907565b01949350505050565b6001600160a01b0385811682528416602082015260408101839052608060608201819052600090611e8290830184611933565b9695505050505050565b600060208284031215611e9e57600080fd5b81516116ab816118d4565b634e487b7160e01b600052601260045260246000fd5b600082611ece57611ece611ea9565b500490565b600082611ee257611ee2611ea9565b50069056fea2646970667358221220c5430862891539407443759a91b594708d2ac06abf8c4a3061b79b5301a77b4464736f6c634300080d0033";

	public static final String FUNC_ADDRESSTOAMOUNT = "addressToAmount";

	public static final String FUNC_APPROVE = "approve";

	public static final String FUNC_BALANCEOF = "balanceOf";

	public static final String FUNC_COUNT = "count";

	public static final String FUNC_EXISTINGURISATTRIBUTES = "existingURIsAttributes";

	public static final String FUNC_FUNDERS = "funders";

	public static final String FUNC_GETAPPROVED = "getApproved";

	public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

	public static final String FUNC_ISCONTENTOWNED = "isContentOwned";

	public static final String FUNC_MINIMUMWEI = "minimumWEI";

	public static final String FUNC_NAME = "name";

	public static final String FUNC_OWNER = "owner";

	public static final String FUNC_OWNEROF = "ownerOf";

	public static final String FUNC_PAYTOMINT = "payToMint";

	public static final String FUNC_PAYTOMINTOWNER = "payToMintOwner";

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
			Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
			}, new TypeReference<Address>(true) {
			}, new TypeReference<Uint256>(true) {
			}));;

	public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll",
			Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
			}, new TypeReference<Address>(true) {
			}, new TypeReference<Bool>() {
			}));;

	public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred",
			Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
			}, new TypeReference<Address>(true) {
			}));;

	public static final Event TRANSFER_EVENT = new Event("Transfer",
			Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
			}, new TypeReference<Address>(true) {
			}, new TypeReference<Uint256>(true) {
			}));;

	protected static final HashMap<String, String> _addresses;

	static {
		_addresses = new HashMap<String, String>();
	}

	@Deprecated
	protected CricketStats(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	protected CricketStats(String contractAddress, Web3j web3j, Credentials credentials,
			ContractGasProvider contractGasProvider) {
		super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
	}

	@Deprecated
	protected CricketStats(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}

	protected CricketStats(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			ContractGasProvider contractGasProvider) {
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

	public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock,
			DefaultBlockParameter endBlock) {
		EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
		filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
		return approvalEventFlowable(filter);
	}

	public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
		List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT,
				transactionReceipt);
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

	public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock,
			DefaultBlockParameter endBlock) {
		EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
		filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
		return approvalForAllEventFlowable(filter);
	}

	public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(
			TransactionReceipt transactionReceipt) {
		List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT,
				transactionReceipt);
		ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(
				valueList.size());
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
				Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT,
						log);
				OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
				typedResponse.log = log;
				typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
				typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
				return typedResponse;
			}
		});
	}

	public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
			DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
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

	public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
			DefaultBlockParameter endBlock) {
		EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
		filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
		return transferEventFlowable(filter);
	}

	public RemoteFunctionCall<BigInteger> addressToAmount(String param0) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADDRESSTOAMOUNT,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_APPROVE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(tokenId)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<BigInteger> count() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COUNT,
				Arrays.<Type>asList(), Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<String> existingURIsAttributes(String param0) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
				FUNC_EXISTINGURISATTRIBUTES, Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<String> funders(BigInteger param0) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FUNDERS,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner),
						new org.web3j.abi.datatypes.Address(operator)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
				}));
		return executeRemoteCallSingleValueReturn(function, Boolean.class);
	}

	public RemoteFunctionCall<Boolean> isContentOwned(String uri) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISCONTENTOWNED,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
				}));
		return executeRemoteCallSingleValueReturn(function, Boolean.class);
	}

	public RemoteFunctionCall<BigInteger> minimumWEI() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINIMUMWEI,
				Arrays.<Type>asList(), Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteFunctionCall<String> name() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME,
				Arrays.<Type>asList(), Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<String> owner() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER,
				Arrays.<Type>asList(), Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNEROF,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<TransactionReceipt> payToMint(String recipient, String metadataURI,
			String metadataAttributes, BigInteger amount) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAYTOMINT,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(recipient),
						new org.web3j.abi.datatypes.Utf8String(metadataURI),
						new org.web3j.abi.datatypes.Utf8String(metadataAttributes)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function, amount);
	}

	public RemoteFunctionCall<TransactionReceipt> payToMintOwner(String recipient, String metadataURI,
			String metadataAttributes, BigInteger amount) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAYTOMINTOWNER,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(recipient),
						new org.web3j.abi.datatypes.Utf8String(metadataURI),
						new org.web3j.abi.datatypes.Utf8String(metadataAttributes)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function, amount);
	}

	public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RENOUNCEOWNERSHIP,
				Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> safeMint(String to, String uri) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SAFEMINT, Arrays
				.<Type>asList(new org.web3j.abi.datatypes.Address(to), new org.web3j.abi.datatypes.Utf8String(uri)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_safeTransferFrom,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(tokenId)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId,
			byte[] data) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_safeTransferFrom,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(tokenId),
						new org.web3j.abi.datatypes.DynamicBytes(data)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String operator, Boolean approved) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SETAPPROVALFORALL,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operator),
						new org.web3j.abi.datatypes.Bool(approved)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
				}));
		return executeRemoteCallSingleValueReturn(function, Boolean.class);
	}

	public RemoteFunctionCall<String> symbol() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL,
				Arrays.<Type>asList(), Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<String> tokenURI(BigInteger tokenId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENURI,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRANSFERFROM,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(from), new org.web3j.abi.datatypes.Address(to),
						new org.web3j.abi.datatypes.generated.Uint256(tokenId)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRANSFEROWNERSHIP,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteFunctionCall<TransactionReceipt> withdraw() {
		final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_WITHDRAW,
				Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	@Deprecated
	public static CricketStats load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return new CricketStats(contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	@Deprecated
	public static CricketStats load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit) {
		return new CricketStats(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}

	public static CricketStats load(String contractAddress, Web3j web3j, Credentials credentials,
			ContractGasProvider contractGasProvider) {
		return new CricketStats(contractAddress, web3j, credentials, contractGasProvider);
	}

	public static CricketStats load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			ContractGasProvider contractGasProvider) {
		return new CricketStats(contractAddress, web3j, transactionManager, contractGasProvider);
	}

	public static RemoteCall<CricketStats> deploy(Web3j web3j, Credentials credentials,
			ContractGasProvider contractGasProvider, String _name, String _symbol, String _baseUriInput,
			BigInteger _minimumWEI) {
		String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(
				new org.web3j.abi.datatypes.Utf8String(_name), new org.web3j.abi.datatypes.Utf8String(_symbol),
				new org.web3j.abi.datatypes.Utf8String(_baseUriInput),
				new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
		return deployRemoteCall(CricketStats.class, web3j, credentials, contractGasProvider, BINARY,
				encodedConstructor);
	}

	public static RemoteCall<CricketStats> deploy(Web3j web3j, TransactionManager transactionManager,
			ContractGasProvider contractGasProvider, String _name, String _symbol, String _baseUriInput,
			BigInteger _minimumWEI) {
		String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(
				new org.web3j.abi.datatypes.Utf8String(_name), new org.web3j.abi.datatypes.Utf8String(_symbol),
				new org.web3j.abi.datatypes.Utf8String(_baseUriInput),
				new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
		return deployRemoteCall(CricketStats.class, web3j, transactionManager, contractGasProvider, BINARY,
				encodedConstructor);
	}

	@Deprecated
	public static RemoteCall<CricketStats> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit, String _name, String _symbol, String _baseUriInput, BigInteger _minimumWEI) {
		String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(
				new org.web3j.abi.datatypes.Utf8String(_name), new org.web3j.abi.datatypes.Utf8String(_symbol),
				new org.web3j.abi.datatypes.Utf8String(_baseUriInput),
				new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
		return deployRemoteCall(CricketStats.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
	}

	@Deprecated
	public static RemoteCall<CricketStats> deploy(Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit, String _name, String _symbol, String _baseUriInput,
			BigInteger _minimumWEI) {
		String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(
				new org.web3j.abi.datatypes.Utf8String(_name), new org.web3j.abi.datatypes.Utf8String(_symbol),
				new org.web3j.abi.datatypes.Utf8String(_baseUriInput),
				new org.web3j.abi.datatypes.generated.Uint256(_minimumWEI)));
		return deployRemoteCall(CricketStats.class, web3j, transactionManager, gasPrice, gasLimit, BINARY,
				encodedConstructor);
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
