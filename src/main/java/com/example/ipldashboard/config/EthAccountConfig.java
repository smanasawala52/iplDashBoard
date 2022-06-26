package com.example.ipldashboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:envionment.properties")
public class EthAccountConfig {

	@Value("${URL}")
	private String url;

	@Value("${NETWORK}")
	private String network;

	@Value("${IMAGE_BASE_URL_TEAMS}")
	private String nftImageBaseURLTeams;

	@Value("${IMAGE_BASE_URL_PLAYERS}")
	private String nftImageBaseURLPlayers;

	@Value("${IMAGE_BASE_URL_VENUES}")
	private String nftImageBaseURLVenues;

	@Value("${NFT_BASE_URI}")
	private String nftBaseURI;

	@Value("${NFT_CRIC_STAT_ADDRESS}")
	private String nftCricStatAddress;

	@Value("${ETH_ADDRESS_ACCOUNT_1}")
	private String ethAddressAccount1;

	@Value("${ETH_ADDRESS_ACCOUNT_2}")
	private String ethAddressAccount2;

	@Value("${ETH_ADDRESS_ACCOUNT_3}")
	private String ethAddressAccount3;

	@Value("${ETH_PRIVATE_KEY_ACCOUNT_1}")
	private String ethPrivateKeyAccount1;

	@Value("${ETH_PRIVATE_KEY_ACCOUNT_2}")
	private String ethPrivateKeyAccount2;

	@Value("${ETH_PRIVATE_KEY_ACCOUNT_3}")
	private String ethPrivateKeyAccount3;

	@Value("${ETH_USD_PRICE_FEED}")
	private String ethUSDPriceFeed;

	@Value("${ETH_VRF_COORDINATOR}")
	private String ethVrfCoordinator;
	@Value("${ETH_LINK_TOKEN}")
	private String ethLinkToken;
	@Value("${ETH_KEY_HASH}")
	private String ethKeyHash;
	@Value("${ETH_FEE}")
	private String ethFee;
	@Value("${ETH_ORACLE}")
	private String ethOracle;
	@Value("${ETH_JOB_ID}")
	private String ethJobId;
	@Value("${ETH_WETH_TOKEN}")
	private String ethWethToken;
	@Value("${ETH_FAU_TOKEN}")
	private String ethFauToken;
	@Value("${ETH_DAI_USD_PRICE_FEED}")
	private String ethDaiUsdPriceFeed;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getNftCricStatAddress() {
		return nftCricStatAddress;
	}

	public void setNftCricStatAddress(String nftCricStatAddress) {
		this.nftCricStatAddress = nftCricStatAddress;
	}

	public String getEthAddressAccount1() {
		return ethAddressAccount1;
	}

	public void setEthAddressAccount1(String ethAddressAccount1) {
		this.ethAddressAccount1 = ethAddressAccount1;
	}

	public String getEthAddressAccount2() {
		return ethAddressAccount2;
	}

	public void setEthAddressAccount2(String ethAddressAccount2) {
		this.ethAddressAccount2 = ethAddressAccount2;
	}

	public String getEthAddressAccount3() {
		return ethAddressAccount3;
	}

	public void setEthAddressAccount3(String ethAddressAccount3) {
		this.ethAddressAccount3 = ethAddressAccount3;
	}

	public String getEthPrivateKeyAccount1() {
		return ethPrivateKeyAccount1;
	}

	public void setEthPrivateKeyAccount1(String ethPrivateKeyAccount1) {
		this.ethPrivateKeyAccount1 = ethPrivateKeyAccount1;
	}

	public String getEthPrivateKeyAccount2() {
		return ethPrivateKeyAccount2;
	}

	public void setEthPrivateKeyAccount2(String ethPrivateKeyAccount2) {
		this.ethPrivateKeyAccount2 = ethPrivateKeyAccount2;
	}

	public String getEthPrivateKeyAccount3() {
		return ethPrivateKeyAccount3;
	}

	public void setEthPrivateKeyAccount3(String ethPrivateKeyAccount3) {
		this.ethPrivateKeyAccount3 = ethPrivateKeyAccount3;
	}

	public String getEthUSDPriceFeed() {
		return ethUSDPriceFeed;
	}

	public void setEthUSDPriceFeed(String ethUSDPriceFeed) {
		this.ethUSDPriceFeed = ethUSDPriceFeed;
	}

	public String getEthVrfCoordinator() {
		return ethVrfCoordinator;
	}

	public void setEthVrfCoordinator(String ethVrfCoordinator) {
		this.ethVrfCoordinator = ethVrfCoordinator;
	}

	public String getEthLinkToken() {
		return ethLinkToken;
	}

	public void setEthLinkToken(String ethLinkToken) {
		this.ethLinkToken = ethLinkToken;
	}

	public String getEthKeyHash() {
		return ethKeyHash;
	}

	public void setEthKeyHash(String ethKeyHash) {
		this.ethKeyHash = ethKeyHash;
	}

	public String getEthFee() {
		return ethFee;
	}

	public void setEthFee(String ethFee) {
		this.ethFee = ethFee;
	}

	public String getEthOracle() {
		return ethOracle;
	}

	public void setEthOracle(String ethOracle) {
		this.ethOracle = ethOracle;
	}

	public String getEthJobId() {
		return ethJobId;
	}

	public void setEthJobId(String ethJobId) {
		this.ethJobId = ethJobId;
	}

	public String getEthWethToken() {
		return ethWethToken;
	}

	public void setEthWethToken(String ethWethToken) {
		this.ethWethToken = ethWethToken;
	}

	public String getEthFauToken() {
		return ethFauToken;
	}

	public void setEthFauToken(String ethFauToken) {
		this.ethFauToken = ethFauToken;
	}

	public String getEthDaiUsdPriceFeed() {
		return ethDaiUsdPriceFeed;
	}

	public void setEthDaiUsdPriceFeed(String ethDaiUsdPriceFeed) {
		this.ethDaiUsdPriceFeed = ethDaiUsdPriceFeed;
	}

	public String getNftBaseURI() {
		return nftBaseURI;
	}

	public void setNftBaseURI(String nftBaseURI) {
		this.nftBaseURI = nftBaseURI;
	}

	public String getNftImageBaseURLTeams() {
		return nftImageBaseURLTeams;
	}

	public void setNftImageBaseURLTeams(String nftImageBaseURLTeams) {
		this.nftImageBaseURLTeams = nftImageBaseURLTeams;
	}

	public String getNftImageBaseURLPlayers() {
		return nftImageBaseURLPlayers;
	}

	public void setNftImageBaseURLPlayers(String nftImageBaseURLPlayers) {
		this.nftImageBaseURLPlayers = nftImageBaseURLPlayers;
	}

	public String getNftImageBaseURLVenues() {
		return nftImageBaseURLVenues;
	}

	public void setNftImageBaseURLVenues(String nftImageBaseURLVenues) {
		this.nftImageBaseURLVenues = nftImageBaseURLVenues;
	}

}
