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
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class TimelockController extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b50604051620022aa380380620022aa8339810160408190526200003491620003f7565b6200004f6000805160206200222a833981519152806200021c565b620000796000805160206200224a8339815191526000805160206200222a8339815191526200021c565b620000a36000805160206200226a8339815191526000805160206200222a8339815191526200021c565b620000cd6000805160206200228a8339815191526000805160206200222a8339815191526200021c565b620000e86000805160206200222a8339815191523362000267565b620001036000805160206200222a8339815191523062000267565b60005b825181101562000189576200014d6000805160206200224a8339815191528483815181106200013957620001396200046b565b60200260200101516200026760201b60201c565b620001766000805160206200228a8339815191528483815181106200013957620001396200046b565b620001818162000481565b905062000106565b5060005b8151811015620001d357620001c06000805160206200226a8339815191528383815181106200013957620001396200046b565b620001cb8162000481565b90506200018d565b5060028390556040805160008152602081018590527f11c24f4ead16507c69ac467fbd5e4eed5fb5c699626d2cc6d66421df253886d5910160405180910390a1505050620004ab565b600082815260208190526040808220600101805490849055905190918391839186917fbd79b86ffe0ab8e8776151514217cd7cacd52c909f66475c3af44e129f0b00ff9190a4505050565b62000273828262000277565b5050565b6000828152602081815260408083206001600160a01b038516845290915290205460ff1662000273576000828152602081815260408083206001600160a01b03851684529091529020805460ff19166001179055620002d33390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b634e487b7160e01b600052604160045260246000fd5b80516001600160a01b03811681146200034557600080fd5b919050565b600082601f8301126200035c57600080fd5b815160206001600160401b03808311156200037b576200037b62000317565b8260051b604051601f19603f83011681018181108482111715620003a357620003a362000317565b604052938452858101830193838101925087851115620003c257600080fd5b83870191505b84821015620003ec57620003dc826200032d565b83529183019190830190620003c8565b979650505050505050565b6000806000606084860312156200040d57600080fd5b835160208501519093506001600160401b03808211156200042d57600080fd5b6200043b878388016200034a565b935060408601519150808211156200045257600080fd5b5062000461868287016200034a565b9150509250925092565b634e487b7160e01b600052603260045260246000fd5b6000600019821415620004a457634e487b7160e01b600052601160045260246000fd5b5060010190565b611d6f80620004bb6000396000f3fe6080604052600436106101bb5760003560e01c80638065657f116100ec578063bc197c811161008a578063d547741f11610064578063d547741f14610582578063e38335e5146105a2578063f23a6e61146105b5578063f27a0c92146105e157600080fd5b8063bc197c8114610509578063c4d252f514610535578063d45c44351461055557600080fd5b806391d14854116100c657806391d1485414610480578063a217fddf146104a0578063b08e51c0146104b5578063b1c5f427146104e957600080fd5b80638065657f1461040c5780638f2a0bb01461042c5780638f61f4f51461044c57600080fd5b8063248a9ca31161015957806331d507501161013357806331d507501461038c57806336568abe146103ac578063584b153e146103cc57806364d62353146103ec57600080fd5b8063248a9ca31461030b5780632ab0f5291461033b5780632f2ff15d1461036c57600080fd5b80630d3cf6fc116101955780630d3cf6fc14610260578063134008d31461029457806313bc9f20146102a7578063150b7a02146102c757600080fd5b806301d5062a146101c757806301ffc9a7146101e957806307bd02651461021e57600080fd5b366101c257005b600080fd5b3480156101d357600080fd5b506101e76101e2366004611368565b6105f6565b005b3480156101f557600080fd5b506102096102043660046113dc565b61068b565b60405190151581526020015b60405180910390f35b34801561022a57600080fd5b506102527fd8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e6381565b604051908152602001610215565b34801561026c57600080fd5b506102527f5f58e3a2316349923ce3780f8d587db2d72378aed66a8261c916544fa6846ca581565b6101e76102a2366004611406565b6106b6565b3480156102b357600080fd5b506102096102c2366004611471565b61072e565b3480156102d357600080fd5b506102f26102e236600461153f565b630a85bd0160e11b949350505050565b6040516001600160e01b03199091168152602001610215565b34801561031757600080fd5b50610252610326366004611471565b60009081526020819052604090206001015490565b34801561034757600080fd5b50610209610356366004611471565b6000908152600160208190526040909120541490565b34801561037857600080fd5b506101e76103873660046115a6565b610754565b34801561039857600080fd5b506102096103a7366004611471565b61077e565b3480156103b857600080fd5b506101e76103c73660046115a6565b610797565b3480156103d857600080fd5b506102096103e7366004611471565b61081a565b3480156103f857600080fd5b506101e7610407366004611471565b610830565b34801561041857600080fd5b50610252610427366004611406565b6108d4565b34801561043857600080fd5b506101e7610447366004611616565b610913565b34801561045857600080fd5b506102527fb09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc181565b34801561048c57600080fd5b5061020961049b3660046115a6565b610a65565b3480156104ac57600080fd5b50610252600081565b3480156104c157600080fd5b506102527ffd643c72710c63c0180259aba6b2d05451e3591a24e58b62239378085726f78381565b3480156104f557600080fd5b506102526105043660046116c7565b610a8e565b34801561051557600080fd5b506102f26105243660046117ee565b63bc197c8160e01b95945050505050565b34801561054157600080fd5b506101e7610550366004611471565b610ad3565b34801561056157600080fd5b50610252610570366004611471565b60009081526001602052604090205490565b34801561058e57600080fd5b506101e761059d3660046115a6565b610ba8565b6101e76105b03660046116c7565b610bcd565b3480156105c157600080fd5b506102f26105d0366004611897565b63f23a6e6160e01b95945050505050565b3480156105ed57600080fd5b50600254610252565b7fb09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc161062081610d02565b60006106308989898989896108d4565b905061063c8184610d0f565b6000817f4cf4410cc57040e44862ef0f45f3dd5a5e02db8eb8add648d4b0e236f1d07dca8b8b8b8b8b8a60405161067896959493929190611924565b60405180910390a3505050505050505050565b60006001600160e01b03198216630271189760e51b14806106b057506106b082610dfe565b92915050565b7fd8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e636106e2816000610a65565b6106f0576106f08133610e33565b60006107008888888888886108d4565b905061070c8185610e97565b61071b8160008a8a8a8a610f33565b61072481611047565b5050505050505050565b60008181526001602052604081205460018111801561074d5750428111155b9392505050565b60008281526020819052604090206001015461076f81610d02565b6107798383611080565b505050565b60008181526001602052604081205481905b1192915050565b6001600160a01b038116331461080c5760405162461bcd60e51b815260206004820152602f60248201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560448201526e103937b632b9903337b91039b2b63360891b60648201526084015b60405180910390fd5b6108168282611104565b5050565b6000818152600160208190526040822054610790565b3330146108935760405162461bcd60e51b815260206004820152602b60248201527f54696d656c6f636b436f6e74726f6c6c65723a2063616c6c6572206d7573742060448201526a62652074696d656c6f636b60a81b6064820152608401610803565b60025460408051918252602082018390527f11c24f4ead16507c69ac467fbd5e4eed5fb5c699626d2cc6d66421df253886d5910160405180910390a1600255565b60008686868686866040516020016108f196959493929190611924565b6040516020818303038152906040528051906020012090509695505050505050565b7fb09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc161093d81610d02565b88871461095c5760405162461bcd60e51b815260040161080390611961565b88851461097b5760405162461bcd60e51b815260040161080390611961565b600061098d8b8b8b8b8b8b8b8b610a8e565b90506109998184610d0f565b60005b8a811015610a575780827f4cf4410cc57040e44862ef0f45f3dd5a5e02db8eb8add648d4b0e236f1d07dca8e8e858181106109d9576109d96119a4565b90506020020160208101906109ee91906119ba565b8d8d86818110610a0057610a006119a4565b905060200201358c8c87818110610a1957610a196119a4565b9050602002810190610a2b91906119d5565b8c8b604051610a3f96959493929190611924565b60405180910390a3610a5081611a31565b905061099c565b505050505050505050505050565b6000918252602082815260408084206001600160a01b0393909316845291905290205460ff1690565b60008888888888888888604051602001610aaf989796959493929190611adc565b60405160208183030381529060405280519060200120905098975050505050505050565b7ffd643c72710c63c0180259aba6b2d05451e3591a24e58b62239378085726f783610afd81610d02565b610b068261081a565b610b6c5760405162461bcd60e51b815260206004820152603160248201527f54696d656c6f636b436f6e74726f6c6c65723a206f7065726174696f6e2063616044820152701b9b9bdd0818994818d85b98d95b1b1959607a1b6064820152608401610803565b6000828152600160205260408082208290555183917fbaa1eb22f2a492ba1a5fea61b8df4d27c6c8b5f3971e63bb58fa14ff72eedb7091a25050565b600082815260208190526040902060010154610bc381610d02565b6107798383611104565b7fd8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e63610bf9816000610a65565b610c0757610c078133610e33565b878614610c265760405162461bcd60e51b815260040161080390611961565b878414610c455760405162461bcd60e51b815260040161080390611961565b6000610c578a8a8a8a8a8a8a8a610a8e565b9050610c638185610e97565b60005b89811015610cec57610cdc82828d8d85818110610c8557610c856119a4565b9050602002016020810190610c9a91906119ba565b8c8c86818110610cac57610cac6119a4565b905060200201358b8b87818110610cc557610cc56119a4565b9050602002810190610cd791906119d5565b610f33565b610ce581611a31565b9050610c66565b50610cf681611047565b50505050505050505050565b610d0c8133610e33565b50565b610d188261077e565b15610d7d5760405162461bcd60e51b815260206004820152602f60248201527f54696d656c6f636b436f6e74726f6c6c65723a206f7065726174696f6e20616c60448201526e1c9958591e481cd8da19591d5b1959608a1b6064820152608401610803565b600254811015610dde5760405162461bcd60e51b815260206004820152602660248201527f54696d656c6f636b436f6e74726f6c6c65723a20696e73756666696369656e746044820152652064656c617960d01b6064820152608401610803565b610de88142611b87565b6000928352600160205260409092209190915550565b60006001600160e01b03198216637965db0b60e01b14806106b057506301ffc9a760e01b6001600160e01b03198316146106b0565b610e3d8282610a65565b61081657610e55816001600160a01b03166014611169565b610e60836020611169565b604051602001610e71929190611bcf565b60408051601f198184030181529082905262461bcd60e51b825261080391600401611c44565b610ea08261072e565b610ebc5760405162461bcd60e51b815260040161080390611c77565b801580610ed85750600081815260016020819052604090912054145b6108165760405162461bcd60e51b815260206004820152602660248201527f54696d656c6f636b436f6e74726f6c6c65723a206d697373696e6720646570656044820152656e64656e637960d01b6064820152608401610803565b6000846001600160a01b0316848484604051610f50929190611cc1565b60006040518083038185875af1925050503d8060008114610f8d576040519150601f19603f3d011682016040523d82523d6000602084013e610f92565b606091505b5050905080610fff5760405162461bcd60e51b815260206004820152603360248201527f54696d656c6f636b436f6e74726f6c6c65723a20756e6465726c79696e6720746044820152721c985b9cd858dd1a5bdb881c995d995c9d1959606a1b6064820152608401610803565b85877fc2617efa69bab66782fa219543714338489c4e9e178271560a91b82c3f612b58878787876040516110369493929190611cd1565b60405180910390a350505050505050565b6110508161072e565b61106c5760405162461bcd60e51b815260040161080390611c77565b600090815260016020819052604090912055565b61108a8282610a65565b610816576000828152602081815260408083206001600160a01b03851684529091529020805460ff191660011790556110c03390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b61110e8282610a65565b15610816576000828152602081815260408083206001600160a01b0385168085529252808320805460ff1916905551339285917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45050565b60606000611178836002611d03565b611183906002611b87565b6001600160401b0381111561119a5761119a61148a565b6040519080825280601f01601f1916602001820160405280156111c4576020820181803683370190505b509050600360fc1b816000815181106111df576111df6119a4565b60200101906001600160f81b031916908160001a905350600f60fb1b8160018151811061120e5761120e6119a4565b60200101906001600160f81b031916908160001a9053506000611232846002611d03565b61123d906001611b87565b90505b60018111156112b5576f181899199a1a9b1b9c1cb0b131b232b360811b85600f1660108110611271576112716119a4565b1a60f81b828281518110611287576112876119a4565b60200101906001600160f81b031916908160001a90535060049490941c936112ae81611d22565b9050611240565b50831561074d5760405162461bcd60e51b815260206004820181905260248201527f537472696e67733a20686578206c656e67746820696e73756666696369656e746044820152606401610803565b80356001600160a01b038116811461131b57600080fd5b919050565b60008083601f84011261133257600080fd5b5081356001600160401b0381111561134957600080fd5b60208301915083602082850101111561136157600080fd5b9250929050565b600080600080600080600060c0888a03121561138357600080fd5b61138c88611304565b96506020880135955060408801356001600160401b038111156113ae57600080fd5b6113ba8a828b01611320565b989b979a50986060810135976080820135975060a09091013595509350505050565b6000602082840312156113ee57600080fd5b81356001600160e01b03198116811461074d57600080fd5b60008060008060008060a0878903121561141f57600080fd5b61142887611304565b95506020870135945060408701356001600160401b0381111561144a57600080fd5b61145689828a01611320565b979a9699509760608101359660809091013595509350505050565b60006020828403121561148357600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f191681016001600160401b03811182821017156114c8576114c861148a565b604052919050565b600082601f8301126114e157600080fd5b81356001600160401b038111156114fa576114fa61148a565b61150d601f8201601f19166020016114a0565b81815284602083860101111561152257600080fd5b816020850160208301376000918101602001919091529392505050565b6000806000806080858703121561155557600080fd5b61155e85611304565b935061156c60208601611304565b92506040850135915060608501356001600160401b0381111561158e57600080fd5b61159a878288016114d0565b91505092959194509250565b600080604083850312156115b957600080fd5b823591506115c960208401611304565b90509250929050565b60008083601f8401126115e457600080fd5b5081356001600160401b038111156115fb57600080fd5b6020830191508360208260051b850101111561136157600080fd5b600080600080600080600080600060c08a8c03121561163457600080fd5b89356001600160401b038082111561164b57600080fd5b6116578d838e016115d2565b909b50995060208c013591508082111561167057600080fd5b61167c8d838e016115d2565b909950975060408c013591508082111561169557600080fd5b506116a28c828d016115d2565b9a9d999c50979a969997986060880135976080810135975060a0013595509350505050565b60008060008060008060008060a0898b0312156116e357600080fd5b88356001600160401b03808211156116fa57600080fd5b6117068c838d016115d2565b909a50985060208b013591508082111561171f57600080fd5b61172b8c838d016115d2565b909850965060408b013591508082111561174457600080fd5b506117518b828c016115d2565b999c989b509699959896976060870135966080013595509350505050565b600082601f83011261178057600080fd5b813560206001600160401b0382111561179b5761179b61148a565b8160051b6117aa8282016114a0565b92835284810182019282810190878511156117c457600080fd5b83870192505b848310156117e3578235825291830191908301906117ca565b979650505050505050565b600080600080600060a0868803121561180657600080fd5b61180f86611304565b945061181d60208701611304565b935060408601356001600160401b038082111561183957600080fd5b61184589838a0161176f565b9450606088013591508082111561185b57600080fd5b61186789838a0161176f565b9350608088013591508082111561187d57600080fd5b5061188a888289016114d0565b9150509295509295909350565b600080600080600060a086880312156118af57600080fd5b6118b886611304565b94506118c660208701611304565b9350604086013592506060860135915060808601356001600160401b038111156118ef57600080fd5b61188a888289016114d0565b81835281816020850137506000828201602090810191909152601f909101601f19169091010190565b60018060a01b038716815285602082015260a06040820152600061194c60a0830186886118fb565b60608301949094525060800152949350505050565b60208082526023908201527f54696d656c6f636b436f6e74726f6c6c65723a206c656e677468206d69736d616040820152620e8c6d60eb1b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b6000602082840312156119cc57600080fd5b61074d82611304565b6000808335601e198436030181126119ec57600080fd5b8301803591506001600160401b03821115611a0657600080fd5b60200191503681900382131561136157600080fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415611a4557611a45611a1b565b5060010190565b81835260006020808501808196508560051b810191508460005b87811015611acf5782840389528135601e19883603018112611a8757600080fd5b870180356001600160401b03811115611a9f57600080fd5b803603891315611aae57600080fd5b611abb86828985016118fb565b9a87019a9550505090840190600101611a66565b5091979650505050505050565b60a0808252810188905260008960c08301825b8b811015611b1d576001600160a01b03611b0884611304565b16825260209283019290910190600101611aef565b5083810360208501528881526001600160fb1b03891115611b3d57600080fd5b8860051b9150818a602083013781810191505060208101600081526020848303016040850152611b6e81888a611a4c565b6060850196909652505050608001529695505050505050565b60008219821115611b9a57611b9a611a1b565b500190565b60005b83811015611bba578181015183820152602001611ba2565b83811115611bc9576000848401525b50505050565b7f416363657373436f6e74726f6c3a206163636f756e7420000000000000000000815260008351611c07816017850160208801611b9f565b7001034b99036b4b9b9b4b733903937b6329607d1b6017918401918201528351611c38816028840160208801611b9f565b01602801949350505050565b6020815260008251806020840152611c63816040850160208701611b9f565b601f01601f19169190910160400192915050565b6020808252602a908201527f54696d656c6f636b436f6e74726f6c6c65723a206f7065726174696f6e206973604082015269206e6f7420726561647960b01b606082015260800190565b8183823760009101908152919050565b60018060a01b0385168152836020820152606060408201526000611cf96060830184866118fb565b9695505050505050565b6000816000190483118215151615611d1d57611d1d611a1b565b500290565b600081611d3157611d31611a1b565b50600019019056fea264697066735822122010e71600fc2c443c5f1536afb90f31d3ceb3caa530fc34b81903d561cb40160664736f6c634300080900335f58e3a2316349923ce3780f8d587db2d72378aed66a8261c916544fa6846ca5b09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc1d8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e63fd643c72710c63c0180259aba6b2d05451e3591a24e58b62239378085726f783";

    public static final String FUNC_CANCELLER_ROLE = "CANCELLER_ROLE";

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_EXECUTOR_ROLE = "EXECUTOR_ROLE";

    public static final String FUNC_PROPOSER_ROLE = "PROPOSER_ROLE";

    public static final String FUNC_TIMELOCK_ADMIN_ROLE = "TIMELOCK_ADMIN_ROLE";

    public static final String FUNC_CANCEL = "cancel";

    public static final String FUNC_EXECUTE = "execute";

    public static final String FUNC_EXECUTEBATCH = "executeBatch";

    public static final String FUNC_GETMINDELAY = "getMinDelay";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GETTIMESTAMP = "getTimestamp";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_HASHOPERATION = "hashOperation";

    public static final String FUNC_HASHOPERATIONBATCH = "hashOperationBatch";

    public static final String FUNC_ISOPERATION = "isOperation";

    public static final String FUNC_ISOPERATIONDONE = "isOperationDone";

    public static final String FUNC_ISOPERATIONPENDING = "isOperationPending";

    public static final String FUNC_ISOPERATIONREADY = "isOperationReady";

    public static final String FUNC_ONERC1155BATCHRECEIVED = "onERC1155BatchReceived";

    public static final String FUNC_ONERC1155RECEIVED = "onERC1155Received";

    public static final String FUNC_ONERC721RECEIVED = "onERC721Received";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SCHEDULE = "schedule";

    public static final String FUNC_SCHEDULEBATCH = "scheduleBatch";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_UPDATEDELAY = "updateDelay";

    public static final Event CALLEXECUTED_EVENT = new Event("CallExecuted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event CALLSCHEDULED_EVENT = new Event("CallScheduled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CANCELLED_EVENT = new Event("Cancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event MINDELAYCHANGE_EVENT = new Event("MinDelayChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected TimelockController(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TimelockController(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TimelockController(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TimelockController(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<CallExecutedEventResponse> getCallExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CALLEXECUTED_EVENT, transactionReceipt);
        ArrayList<CallExecutedEventResponse> responses = new ArrayList<CallExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CallExecutedEventResponse typedResponse = new CallExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CallExecutedEventResponse> callExecutedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CallExecutedEventResponse>() {
            @Override
            public CallExecutedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CALLEXECUTED_EVENT, log);
                CallExecutedEventResponse typedResponse = new CallExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CallExecutedEventResponse> callExecutedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CALLEXECUTED_EVENT));
        return callExecutedEventFlowable(filter);
    }

    public List<CallScheduledEventResponse> getCallScheduledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CALLSCHEDULED_EVENT, transactionReceipt);
        ArrayList<CallScheduledEventResponse> responses = new ArrayList<CallScheduledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CallScheduledEventResponse typedResponse = new CallScheduledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.predecessor = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.delay = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CallScheduledEventResponse> callScheduledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CallScheduledEventResponse>() {
            @Override
            public CallScheduledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CALLSCHEDULED_EVENT, log);
                CallScheduledEventResponse typedResponse = new CallScheduledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.predecessor = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.delay = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CallScheduledEventResponse> callScheduledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CALLSCHEDULED_EVENT));
        return callScheduledEventFlowable(filter);
    }

    public List<CancelledEventResponse> getCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CANCELLED_EVENT, transactionReceipt);
        ArrayList<CancelledEventResponse> responses = new ArrayList<CancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelledEventResponse typedResponse = new CancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelledEventResponse> cancelledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CancelledEventResponse>() {
            @Override
            public CancelledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCELLED_EVENT, log);
                CancelledEventResponse typedResponse = new CancelledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelledEventResponse> cancelledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCELLED_EVENT));
        return cancelledEventFlowable(filter);
    }

    public List<MinDelayChangeEventResponse> getMinDelayChangeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINDELAYCHANGE_EVENT, transactionReceipt);
        ArrayList<MinDelayChangeEventResponse> responses = new ArrayList<MinDelayChangeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MinDelayChangeEventResponse typedResponse = new MinDelayChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.oldDuration = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newDuration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MinDelayChangeEventResponse> minDelayChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MinDelayChangeEventResponse>() {
            @Override
            public MinDelayChangeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINDELAYCHANGE_EVENT, log);
                MinDelayChangeEventResponse typedResponse = new MinDelayChangeEventResponse();
                typedResponse.log = log;
                typedResponse.oldDuration = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newDuration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MinDelayChangeEventResponse> minDelayChangeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINDELAYCHANGE_EVENT));
        return minDelayChangeEventFlowable(filter);
    }

    public List<RoleAdminChangedEventResponse> getRoleAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<RoleAdminChangedEventResponse> responses = new ArrayList<RoleAdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleAdminChangedEventResponse>() {
            @Override
            public RoleAdminChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, log);
                RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEADMINCHANGED_EVENT));
        return roleAdminChangedEventFlowable(filter);
    }

    public List<RoleGrantedEventResponse> getRoleGrantedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEGRANTED_EVENT, transactionReceipt);
        ArrayList<RoleGrantedEventResponse> responses = new ArrayList<RoleGrantedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleGrantedEventResponse>() {
            @Override
            public RoleGrantedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEGRANTED_EVENT, log);
                RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEGRANTED_EVENT));
        return roleGrantedEventFlowable(filter);
    }

    public List<RoleRevokedEventResponse> getRoleRevokedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ROLEREVOKED_EVENT, transactionReceipt);
        ArrayList<RoleRevokedEventResponse> responses = new ArrayList<RoleRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleRevokedEventResponse>() {
            @Override
            public RoleRevokedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEREVOKED_EVENT, log);
                RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEREVOKED_EVENT));
        return roleRevokedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> CANCELLER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CANCELLER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> DEFAULT_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULT_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> EXECUTOR_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EXECUTOR_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> PROPOSER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PROPOSER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> TIMELOCK_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TIMELOCK_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancel(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> execute(String target, BigInteger value, byte[] data, byte[] predecessor, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> executeBatch(List<String> targets, List<BigInteger> values, List<byte[]> payloads, byte[] predecessor, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTEBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(payloads, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getMinDelay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETMINDELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getRoleAdmin(byte[] role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROLEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getTimestamp(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> grantRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GRANTROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> hasRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> hashOperation(String target, BigInteger value, byte[] data, byte[] predecessor, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASHOPERATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> hashOperationBatch(List<String> targets, List<BigInteger> values, List<byte[]> payloads, byte[] predecessor, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASHOPERATIONBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(payloads, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Boolean> isOperation(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOperationDone(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATIONDONE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOperationPending(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATIONPENDING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOperationReady(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATIONREADY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC1155BatchReceived(String param0, String param1, List<BigInteger> param2, List<BigInteger> param3, byte[] param4) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC1155BATCHRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(param2, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(param3, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicBytes(param4)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC1155Received(String param0, String param1, BigInteger param2, BigInteger param3, byte[] param4) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC1155RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.generated.Uint256(param3), 
                new org.web3j.abi.datatypes.DynamicBytes(param4)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC721Received(String param0, String param1, BigInteger param2, byte[] param3) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC721RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.DynamicBytes(param3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> schedule(String target, BigInteger value, byte[] data, byte[] predecessor, byte[] salt, BigInteger delay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SCHEDULE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.generated.Uint256(delay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> scheduleBatch(List<String> targets, List<BigInteger> values, List<byte[]> payloads, byte[] predecessor, byte[] salt, BigInteger delay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SCHEDULEBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(payloads, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.generated.Uint256(delay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateDelay(BigInteger newDelay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEDELAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newDelay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TimelockController load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimelockController(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TimelockController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimelockController(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TimelockController load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TimelockController(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TimelockController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TimelockController(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TimelockController> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger minDelay, List<String> proposers, List<String> executors) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(TimelockController.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TimelockController> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger minDelay, List<String> proposers, List<String> executors) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(TimelockController.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TimelockController> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger minDelay, List<String> proposers, List<String> executors) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(TimelockController.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TimelockController> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger minDelay, List<String> proposers, List<String> executors) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(TimelockController.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class CallExecutedEventResponse extends BaseEventResponse {
        public byte[] id;

        public BigInteger index;

        public String target;

        public BigInteger value;

        public byte[] data;
    }

    public static class CallScheduledEventResponse extends BaseEventResponse {
        public byte[] id;

        public BigInteger index;

        public String target;

        public BigInteger value;

        public byte[] data;

        public byte[] predecessor;

        public BigInteger delay;
    }

    public static class CancelledEventResponse extends BaseEventResponse {
        public byte[] id;
    }

    public static class MinDelayChangeEventResponse extends BaseEventResponse {
        public BigInteger oldDuration;

        public BigInteger newDuration;
    }

    public static class RoleAdminChangedEventResponse extends BaseEventResponse {
        public byte[] role;

        public byte[] previousAdminRole;

        public byte[] newAdminRole;
    }

    public static class RoleGrantedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class RoleRevokedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }
}
