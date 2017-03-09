package org.eclipse.scout.trading.network;


import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.0.2.
 */
public final class FXTrading extends Contract {
    private static final String BINARY = "6060604052600060035534156200001257fe5b60405162000fb838038062000fb8833981016040528080518201919050505b806004908051906020019062000049929190620002a5565b50600280548060010182816200006091906200032c565b916000526020600020900160005b604060405190810160405280600681526020017f4669726d6131000000000000000000000000000000000000000000000000000081525090919091509080519060200190620000bf929190620002a5565b505060028054806001018281620000d791906200032c565b916000526020600020900160005b604060405190810160405280600681526020017f4669726d613200000000000000000000000000000000000000000000000000008152509091909150908051906020019062000136929190620002a5565b5050600280548060010182816200014e91906200032c565b916000526020600020900160005b604060405190810160405280600681526020017f4669726d6133000000000000000000000000000000000000000000000000000081525090919091509080519060200190620001ad929190620002a5565b505060028054806001018281620001c591906200032c565b916000526020600020900160005b604060405190810160405280600681526020017f4669726d613400000000000000000000000000000000000000000000000000008152509091909150908051906020019062000224929190620002a5565b5050600280548060010182816200023c91906200032c565b916000526020600020900160005b604060405190810160405280600681526020017f4669726d61350000000000000000000000000000000000000000000000000000815250909190915090805190602001906200029b929190620002a5565b50505b5062000400565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620002e857805160ff191683800117855562000319565b8280016001018555821562000319579182015b8281111562000318578251825591602001919060010190620002fb565b5b5090506200032891906200035b565b5090565b815481835581811511620003565781836000526020600020918201910162000355919062000383565b5b505050565b6200038091905b808211156200037c57600081600090555060010162000362565b5090565b90565b620003b191905b80821115620003ad5760008181620003a39190620003b4565b506001016200038a565b5090565b90565b50805460018160011615610100020316600290046000825580601f10620003dc5750620003fd565b601f016020900490600052602060002090810190620003fc91906200035b565b5b50565b610ba880620004106000396000f30060606040523615610076576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806350c0259c1461007857806352706d6c1461014e578063708fe440146101fe578063afe91a0d14610289578063c0b869271461035f578063d137aadc146103f8575bfe5b341561008057fe5b61009660048080359060200190919050506104aa565b60405180868152602001858152602001841515151581526020018060200183815260200182810382528481815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561013b5780601f106101105761010080835404028352916020019161013b565b820191906000526020600020905b81548152906001019060200180831161011e57829003601f168201915b5050965050505050505060405180910390f35b341561015657fe5b61017560048080359060200190919080359060200190919050506104fc565b60405180806020018281038252838181518152602001915080519060200190808383600083146101c4575b8051825260208311156101c4576020820191506020810190506020830392506101a0565b505050905090810190601f1680156101f05780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561020657fe5b6102736004808035906020019091908035906020019091908035151590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061050b565b6040518082815260200191505060405180910390f35b341561029157fe5b6102a7600480803590602001909190505061067c565b60405180868152602001858152602001841515151581526020018060200183815260200182810382528481815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561034c5780601f106103215761010080835404028352916020019161034c565b820191906000526020600020905b81548152906001019060200180831161032f57829003601f168201915b5050965050505050505060405180910390f35b341561036757fe5b61036f6106ce565b60405180806020018281038252838181518152602001915080519060200190808383600083146103be575b8051825260208311156103be5760208201915060208101905060208303925061039a565b505050905090810190601f1680156103ea5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561040057fe5b6104216004808035906020019091908035151590602001909190505061076c565b6040518080602001828103825283818151815260200191508051906020019080838360008314610470575b8051825260208311156104705760208201915060208101905060208303925061044c565b505050905090810190601f16801561049c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000818154811015156104b957fe5b906000526020600020906005020160005b915090508060000154908060010154908060020160009054906101000a900460ff169080600301908060040154905085565b61050461091a565b5b92915050565b600061051561092e565b6003600081548092919060010191905055915060a060405190810160405280878152602001868152602001851515815260200184815260200183815250905083156105e8576000805480600101828161056e9190610966565b916000526020600020906005020160005b839091909150600082015181600001556020820151816001015560408201518160020160006101000a81548160ff02191690831515021790555060608201518160030190805190602001906105d5929190610998565b5060808201518160040155505050610672565b600180548060010182816105fc9190610966565b916000526020600020906005020160005b839091909150600082015181600001556020820151816001015560408201518160020160006101000a81548160ff0219169083151502179055506060820151816003019080519060200190610663929190610998565b50608082015181600401555050505b5b50949350505050565b60018181548110151561068b57fe5b906000526020600020906005020160005b915090508060000154908060010154908060020160009054906101000a900460ff169080600301908060040154905085565b60048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107645780601f1061073957610100808354040283529160200191610764565b820191906000526020600020905b81548152906001019060200180831161074757829003601f168201915b505050505081565b61077461091a565b600060006000600092508461078a57600161078d565b60005b9150600090505b8180549050811015610910578582828154811015156107af57fe5b906000526020600020906005020160005b506004015414156107d057600192505b82156109025760018280549050038110156108a35781600182018154811015156107f657fe5b906000526020600020906005020160005b50828281548110151561081657fe5b906000526020600020906005020160005b5060008201548160000155600182015481600101556002820160009054906101000a900460ff168160020160006101000a81548160ff02191690831515021790555060038201816003019080546001816001161561010002031660029004610890929190610a18565b5060048201548160040155905050610901565b81818154811015156108b157fe5b906000526020600020906005020160005b600082016000905560018201600090556002820160006101000a81549060ff02191690556003820160006108f69190610a9f565b600482016000905550505b5b5b8080600101915050610794565b5b50505092915050565b602060405190810160405280600081525090565b60a0604051908101604052806000815260200160008152602001600015158152602001610959610ae7565b8152602001600081525090565b815481835581811511610993576005028160050283600052602060002091820191016109929190610afb565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106109d957805160ff1916838001178555610a07565b82800160010185558215610a07579182015b82811115610a065782518255916020019190600101906109eb565b5b509050610a149190610b57565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a515780548555610a8e565b82800160010185558215610a8e57600052602060002091601f016020900482015b82811115610a8d578254825591600101919060010190610a72565b5b509050610a9b9190610b57565b5090565b50805460018160011615610100020316600290046000825580601f10610ac55750610ae4565b601f016020900490600052602060002090810190610ae39190610b57565b5b50565b602060405190810160405280600081525090565b610b5491905b80821115610b50576000600082016000905560018201600090556002820160006101000a81549060ff0219169055600382016000610b3f9190610a9f565b600482016000905550600501610b01565b5090565b90565b610b7991905b80821115610b75576000816000905550600101610b5d565b5090565b905600a165627a7a72305820fa66b57c22575b7d951b867a4a5886046bb35f342742b29c7e3c9866f0141dd20029";

    private FXTrading(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private FXTrading(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<StatusChangedEventResponse> getStatusChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("statusChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<StatusChangedEventResponse> responses = new ArrayList<StatusChangedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            StatusChangedEventResponse typedResponse = new StatusChangedEventResponse();
            typedResponse.eventType = (Utf8String)eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<StatusChangedEventResponse> statusChangedEventObservable() {
        final Event event = new Event("statusChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, StatusChangedEventResponse>() {
            @Override
            public StatusChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                StatusChangedEventResponse typedResponse = new StatusChangedEventResponse();
                typedResponse.eventType = (Utf8String)eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<List<Type>> buyDeals(Uint256 param0) {
        Function function = new Function("buyDeals", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> mergeDeals(Uint256 _dealNr1, Uint256 _dealNr2) {
        Function function = new Function("mergeDeals", Arrays.<Type>asList(_dealNr1, _dealNr2), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> createDeal(Uint256 _quantity, Uint256 _price, Bool _buy, Utf8String _company) {
        Function function = new Function("createDeal", Arrays.<Type>asList(_quantity, _price, _buy, _company), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<List<Type>> sellDeals(Uint256 param0) {
        Function function = new Function("sellDeals", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<Utf8String> currencyPair() {
        Function function = new Function("currencyPair", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> revokeDeal(Uint256 _dealNr, Bool _buy) {
        Function function = new Function("revokeDeal", Arrays.<Type>asList(_dealNr, _buy), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<FXTrading> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Utf8String _currencyPair) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_currencyPair));
        return deployAsync(FXTrading.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static Future<FXTrading> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Utf8String _currencyPair) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_currencyPair));
        return deployAsync(FXTrading.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static FXTrading load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FXTrading(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static FXTrading load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FXTrading(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class StatusChangedEventResponse {
        public Utf8String eventType;
    }
}
