package org.eclipse.scout.trading.network;

import java.lang.String;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.0.2.
 */
public final class OrderBook extends Contract {
    private static final String BINARY = "0x606060405234610000576040516116fa3803806116fa833981016040528051015b60058054600160a060020a0319166c01000000000000000000000000338102041790819055600160a060020a031660009081526004602090815260408220805460ff1916600190811790915583516003805494819052937fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b600261010094831615949094026000190190911692909204601f9081018490048301939192918601908390106100d957805160ff1916838001178555610106565b82800160010185558215610106579182015b828111156101065782518255916020019190600101906100eb565b5b506101279291505b80821115610123576000815560010161010f565b5090565b505060016006555b505b6115bb8061013f6000396000f3606060405236156100da5760e060020a600035046305a7585b81146100df57806329b948481461010057806335cea2881461011f5780633adbcccb1461016357806341c0e1b5146101825780634a8393f31461019157806351a742e0146101d557806361915e5d146101f4578063668a2001146102385780637c33e99a1461024a578063929066f51461026957806395d89b411461028d578063a8c67f0514610308578063be46128f14610389578063c4ccb40a146103b1578063ca8836d2146103d0578063cf4b6c49146103f4578063dfafe10f1461041e575b610000565b34610000576100ec610430565b604080519115158252519081900360200190f35b346100005761010d6104c2565b60408051918252519081900360200190f35b346100005761012f6004356104c9565b60408051958652602086019490945291151584840152600160a060020a031660608401526080830152519081900360a00190f35b346100005761010d610515565b60408051918252519081900360200190f35b346100005761018f61051c565b005b346100005761012f600435610544565b60408051958652602086019490945291151584840152600160a060020a031660608401526080830152519081900360a00190f35b346100005761010d610590565b60408051918252519081900360200190f35b346100005761012f600435610597565b60408051958652602086019490945291151584840152600160a060020a031660608401526080830152519081900360a00190f35b346100005761018f6004356105e3565b005b346100005761010d610607565b60408051918252519081900360200190f35b34610000576100ec600435610649565b604080519115158252519081900360200190f35b346100005761029a61066b565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156102fa5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100005761029a6004356024356106f9565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156102fa5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100005761010d6004356024356044356108dc565b60408051918252519081900360200190f35b346100005761010d610b50565b60408051918252519081900360200190f35b34610000576100ec600435610b90565b604080519115158252519081900360200190f35b3461000057610407600435602435610c40565b6040805160009290920b8252519081900360200190f35b346100005761018f600435610e5b565b005b600080548190819015806104445750600154155b1561045257600092506104bd565b6000805460001981019081101561000057906000526020600020906004020160005b50600180549193509060001981019081101561000057906000526020600020906004020160005b509050806001015482600101541015156104b857600192506104bd565b600092505b505090565b6001545b90565b600081815481101561000057906000526020600020906004020160005b508054600182015460028301546003909301549193509160ff811691610100909104600160a060020a03169085565b6002545b90565b60055433600160a060020a039081169116141561054157600554600160a060020a0316ff5b5b565b600181815481101561000057906000526020600020906004020160005b508054600182015460028301546003909301549193509160ff811691610100909104600160a060020a03169085565b6000545b90565b600281815481101561000057906000526020600020906004020160005b508054600182015460028301546003909301549193509160ff811691610100909104600160a060020a03169085565b600160a060020a0381166000908152600460205260409020805460ff191690555b50565b600154600090151561061c57506000196104c6565b6001805460001981019081101561000057906000526020600020906004020160005b506003015490505b90565b600160a060020a03811660009081526004602052604090205460ff165b919050565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106f15780601f106106c6576101008083540402835291602001916106f1565b820191906000526020600020905b8154815290600101906020018083116106d457829003601f168201915b505050505081565b6040805160208101909152600080825280808461071757600161071a565b60005b9150600090505b81548110156108d257858282815481101561000057906000526020600020906004020160005b5060030154141561075757600192505b82156108c857815460001901811015610817578181600101815481101561000057906000526020600020906004020160005b508282815481101561000057906000526020600020906004020160005b50815481556001808301549082015560028083018054918301805460f860020a60ff90941684029390930460ff19909316929092178083559054606060020a600160a060020a0361010092839004168102040261010060a860020a03199091161790556003918201549101556108c8565b8181815481101561000057906000526020600020906004020160005b50600080825560018201819055600282018054600160a860020a031916905560039091015581546000198101808455908390829080158290116108c2576004028160040283600052602060002091820191016108c291905b808211156108be57600080825560018201819055600282018054600160a860020a0319169055600382015560040161088b565b5090565b5b505050505b5b5b600101610721565b5b50505092915050565b6040805160a081018252600080825260208083018290528284018290526060830182905260808301829052600160a060020a0333168252600490529182205460ff16151561092957610000565b506040805160a08101825285815260208101859052908101839052336060820152600680546001810190915560808201528215610a5557600080548060010182818154818355818115116109c9576004028160040283600052602060002091820191016109c991905b808211156108be57600080825560018201819055600282018054600160a860020a0319169055600382015560040161088b565b5090565b5b505050916000526020600020906004020160005b5082518155602083015160018083019190915560408401516002830180546060870151606060020a908102046101000261010060a860020a031960f860020a9485029490940460ff1990921691909117929092169190911790556080840151600390920191909155610a509150610e82565b610b3f565b60018054806001018281815481835581811511610abe57600402816004028360005260206000209182019101610abe91905b808211156108be57600080825560018201819055600282018054600160a860020a0319169055600382015560040161088b565b5090565b5b505050916000526020600020906004020160005b50825181556020830151600182015560408301516002820180546060860151606060020a908102046101000261010060a860020a031960f860020a9485029490940460ff199092169190911792909216919091179055608083015160039091015550610b3f6000610e82565b5b806080015191505b509392505050565b600080541515610b6357506000196104c6565b6000805460001981019081101561000057906000526020600020906004020160005b506003015490505b90565b600080808311610ba35760009150610c3a565b5060005b600054811015610bec57600081815481101561000057906000526020600020906004020160005b5060030154831415610be35760019150610c3a565b5b600101610ba7565b5060005b600154811015610c3557600181815481101561000057906000526020600020906004020160005b5060030154831415610c2c5760019150610c3a565b5b600101610bf0565b600091505b50919050565b6000600060006000600060008054905060001480610c8457506000805460001981019081101561000057906000526020600020906004020160005b50600301548714155b15610c93576000199450610e51565b6001541580610cc857506001805460001981019081101561000057906000526020600020906004020160005b50600301548614155b15610cd7576001199450610e51565b6001805460001981019081101561000057906000526020600020906004020160005b50600101546000805460001981019081101561000057906000526020600020906004020160005b50600101541015610d35576002199450610e51565b6000805460001981019081101561000057906000526020600020906004020160005b50600180549195509060001981019081101561000057906000526020600020906004020160005b50805485549194509010610d93578254610d96565b83545b600184810154908601546040805160a08101825288548152602081018390526002808a015460ff8116151593830193909352610100909204600160a060020a03166060820152600389015460808201529395509101049150610df99083836112dd565b6040805160a0810182528454815260018501546020820152600285015460ff8116151592820192909252610100909104600160a060020a0316606082015260038401546080820152610e4c9083836112dd565b600094505b5050505092915050565b600160a060020a0381166000908152600460205260409020805460ff191660011790555b50565b600060a060405190810160405280600081526020016000815260200160008152602001600081526020016000815260200150600083156110ca5750600054915060001982015b60008111156110c557600060018203815481101561000057906000526020600020906004020160005b5060010154600082815481101561000057906000526020600020906004020160005b506001015410156110bb57600060018203815481101561000057906000526020600020906004020160005b506040805160a0810182528254815260018301546020820152600283015460ff8116151592820192909252610100909104600160a060020a0316606082015260039091015460808201526000805491935090829081101561000057906000526020600020906004020160005b50600060018303815481101561000057906000526020600020906004020160005b50815481556001808301549082015560028083018054918301805460f860020a60ff90941684029390930460ff19909316929092178083559054606060020a600160a060020a0361010092839004168102040261010060a860020a031990911617905560039182015491015560008054839190839081101561000057906000526020600020906004020160005b50815181556020820151600182015560408201516002820180546060850151606060020a908102046101000261010060a860020a031960f860020a9485029490940460ff1990921691909117929092169190911790556080909101516003909101555b5b60001901610ec8565b6112d5565b50600154915060001982015b60008111156112d557600160018203815481101561000057906000526020600020906004020160005b5060010154600182815481101561000057906000526020600020906004020160005b506001015411156112cb57600160018203815481101561000057906000526020600020906004020160005b506040805160a081018252825481526001808401546020830152600284015460ff8116151593830193909352610100909204600160a060020a031660608201526003909201546080830152805491935090829081101561000057906000526020600020906004020160005b50600160018303815481101561000057906000526020600020906004020160005b50815481556001808301548183015560028084018054918401805460f860020a60ff90941684029390930460ff19909316929092178083559054606060020a600160a060020a0361010092839004168102040261010060a860020a031990911617905560039283015492909101919091558054839190839081101561000057906000526020600020906004020160005b50815181556020820151600182015560408201516002820180546060850151606060020a908102046101000261010060a860020a031960f860020a9485029490940460ff1990921691909117929092169190911790556080909101516003909101555b5b600019016110d6565b5b5b50505050565b825182900380151561146b578360400151156113af576000805460001981019081101561000057906000526020600020906004020160005b50600080825560018201819055600282018054600160a860020a03191690556003909101819055805460001981018083559190829080158290116113a5576004028160040283600052602060002091820191016113a591905b808211156108be57600080825560018201819055600282018054600160a860020a0319169055600382015560040161088b565b5090565b5b50505050611466565b6001805460001981019081101561000057906000526020600020906004020160005b5060008082556001808301829055600283018054600160a860020a0319169055600390920155805460001981018083559190829080158290116114605760040281600402836000526020600020918201910161146091905b808211156108be57600080825560018201819055600282018054600160a860020a0319169055600382015560040161088b565b5090565b5b505050505b6114c9565b8360400151156114a1576000805482919060001981019081101561000057906000526020600020906004020160005b50556114c9565b6001805482919060001981019081101561000057906000526020600020906004020160005b50555b5b828452602084018290526002805460018101808355828183801582901161153d5760040281600402836000526020600020918201910161153d91905b808211156108be57600080825560018201819055600282018054600160a860020a0319169055600382015560040161088b565b5090565b5b505050916000526020600020906004020160005b50855181556020860151600182015560408601516002820180546060890151606060020a908102046101000261010060a860020a031960f860020a9485029490940460ff1990921691909117929092169190911790556080860151600390910155505b5050505056";

    private OrderBook(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private OrderBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<Bool> matchExists() {
        Function function = new Function("matchExists", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getNumberOfSellOrders() {
        Function function = new Function("getNumberOfSellOrders", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> buyOrders(Uint256 param0) {
        Function function = new Function("buyOrders", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<Uint256> getNumberOfExecutedOrders() {
        Function function = new Function("getNumberOfExecutedOrders", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<List<Type>> sellOrders(Uint256 param0) {
        Function function = new Function("sellOrders", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<Uint256> getNumberOfBuyOrders() {
        Function function = new Function("getNumberOfBuyOrders", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> executedOrders(Uint256 param0) {
        Function function = new Function("executedOrders", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> removeParticipant(Address _participant) {
        Function function = new Function("removeParticipant", Arrays.<Type>asList(_participant), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Int256> topSellOrderId() {
        Function function = new Function("topSellOrderId", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> isParticipant(Address _participant) {
        Function function = new Function("isParticipant", 
                Arrays.<Type>asList(_participant), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> cancelOrder(Int256 _orderId, Bool _buy) {
        Function function = new Function("cancelOrder", Arrays.<Type>asList(_orderId, _buy), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> createOrder(Uint256 _quantity, Uint256 _price, Bool _buy) {
        Function function = new Function("createOrder", Arrays.<Type>asList(_quantity, _price, _buy), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Int256> topBuyOrderId() {
        Function function = new Function("topBuyOrderId", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> isPending(Uint256 _orderId) {
        Function function = new Function("isPending", 
                Arrays.<Type>asList(_orderId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> executeMatch(Int256 _buyOrderId, Int256 _sellOrderId) {
        Function function = new Function("executeMatch", Arrays.<Type>asList(_buyOrderId, _sellOrderId), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> addParticipant(Address _participant) {
        Function function = new Function("addParticipant", Arrays.<Type>asList(_participant), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<OrderBook> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Utf8String _symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_symbol));
        return deployAsync(OrderBook.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static Future<OrderBook> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Utf8String _symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_symbol));
        return deployAsync(OrderBook.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static OrderBook load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OrderBook(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static OrderBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OrderBook(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
