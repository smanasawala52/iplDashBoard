package com.example.ipldashboard.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.example.ipldashboard.config.EthAccountConfig;
import com.example.ipldashboard.contracts.CricketStats;
import com.example.ipldashboard.model.NFTMetadata;
import com.example.ipldashboard.repository.NFTRepository;
import com.example.ipldashboard.service.DataService;
import com.example.ipldashboard.service.NFTService;

@RestController
public class NFTController {
	@Autowired
	private DataService dataService;

	private static final BigInteger GAS_LIMIT = new BigInteger("6721975");
	private static final BigInteger GAS_PRICE = new BigInteger("20000000000");
	private static final BigInteger DECIMALS = new BigInteger("18");
	private static final BigInteger INITIAL_ANSWER = Convert.toWei("2000", Unit.ETHER).toBigInteger();
	private static String ethNFTCricketStatAddress;

	// demo purpose add private keys to map with account so that easier to switch in
	// UI
	private static Map<String, String> ethAddressPrivateKeysMap = new HashMap<>();
	@Autowired
	private EthAccountConfig ethAccountConfig;
	@Autowired
	private NFTService nftService;

	@Autowired
	private NFTRepository nftRepository;

	@PostConstruct
	private void ethDappInitPvtMap() {
		ethAddressPrivateKeysMap.put(ethAccountConfig.getEthAddressAccount1(),
				ethAccountConfig.getEthPrivateKeyAccount1());
		ethAddressPrivateKeysMap.put(ethAccountConfig.getEthAddressAccount2(),
				ethAccountConfig.getEthPrivateKeyAccount2());
		ethAddressPrivateKeysMap.put(ethAccountConfig.getEthAddressAccount3(),
				ethAccountConfig.getEthPrivateKeyAccount3());
		if (ethAccountConfig.getNftCricStatAddress() != null && !ethAccountConfig.getNftCricStatAddress().isEmpty()) {
			ethNFTCricketStatAddress = ethAccountConfig.getNftCricStatAddress();
		} else {
			String url = ethAccountConfig.getUrl();
			String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
			Web3j web3j = Web3j.build(new HttpService(url));
			Credentials credentialsAccount1 = Credentials.create(ethPrivateKeyAccount1);
			ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);

			// deploy ethNFTCricketStatAddress
			String baseUriInput = ethAccountConfig.getNftBaseURI();
			BigInteger _minimumWEI = Convert.toWei("0.005", Convert.Unit.ETHER).toBigInteger();
			try {
				CricketStats contract = CricketStats.deploy(web3j, credentialsAccount1, contractGasProvider,
						"CricketStats", "CKST", baseUriInput, _minimumWEI).send();
				ethNFTCricketStatAddress = contract.getContractAddress();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@GetMapping("/team/nftMetaData/{id}")
	public NFTMetadata getTeamNftMetaData(@PathVariable("id") final String id) {
		NFTMetadata temp = nftRepository.findById(Long.parseLong(id)).get();
		// convert attributes String to attributes map
		if (temp.getAttributesStr() != null) {
			temp.setAttributes(new HashMap<>());
			String[] playerTeams = temp.getAttributesStr().split("\\^");
			for (int i = 0; i < playerTeams.length; i++) {
				String[] playerTeamsPlayer = playerTeams[i].split("\\|");
				temp.getAttributes().put(playerTeamsPlayer[0], playerTeamsPlayer[1]);
			}
		}
		return temp;
		// return "{\"id\":0,\"name\":\"Gujarat Titans 2022\",\"description\":\"Gujarat
		// Titans in the season of
		// 2022\",\"externalLink\":\"https://ipl-dashboard-shabbir.herokuapp.com/?venue=&tossDecision=&tossWinner=&playerOfMatch=&city=&team1=Gujarat
		// Titans&team2=&result=&winner=&stage=&season=2022&group=&player=\",\"image\":\"https://ipl-dashboard-shabbir.herokuapp.com/image/teams/gujarattitans.jpg\",\"attributes\":{\"teamName\":\"Gujarat
		// Titans\",\"number-of-matches-batted-first-percent\":\"43.75\",{\"trait_type\":\"cities\",\"value\":[\"Ahmedabad\",
		// \"Kolkata\", \"Mumbai\", \"Pune\"]},\"played-with-teams\":\"Chennai Super
		// Kings, Delhi Capitals, Kolkata Knight Riders, Lucknow Super Giants, Mumbai
		// Indians, Punjab Kings, Rajasthan Royals, Royal Challengers Bangalore,
		// Sunrisers Hyderabad\",\"number-of-matches-won\":\"12\",\"players\":\"A
		// Manohar, AS Joseph, B Sai Sudharsan, DA Miller, DG Nalkande, HH Pandya, LH
		// Ferguson, MS Wade, Mohammed Shami, PJ Sangwan, R Sai Kishore, R Tewatia,
		// Rashid Khan, Shubman Gill, V Shankar, VR Aaron, WP Saha, Yash
		// Dayal\",\"stages\":\"[Final, Qualifier 1]\",\"venues\":\"Brabourne Stadium,
		// Dr DY Patil Sports Academy, Eden Gardens, Maharashtra Cricket Association
		// Stadium, Narendra Modi Stadium, Wankhede
		// Stadium\",\"percent-of-matches-won\":\"75.0\",\"number-of-matches-batted-first\":\"7\",\"number-of-matches-played\":\"16\"}}";
		// return "{\"id\":0,\"name\":\"Gujarat Titans 2022\",\"description\":\"Gujarat
		// Titans in the season of
		// 2022\",\"externalLink\":\"https://ipl-dashboard-shabbir.herokuapp.com/?venue=&tossDecision=&tossWinner=&playerOfMatch=&city=&team1=Gujarat
		// Titans&team2=&result=&winner=&stage=&season=2022&group=&player=\",\"image\":\"https://ipl-dashboard-shabbir.herokuapp.com/image/teams/gujarattitans.jpg\",\"attributes\":{\"array_property\":{\"name\":\"Cities1\",\"value\":[\"Ahmedabad\",
		// \"Kolkata\", \"Mumbai\", \"Pune\"], \"class\": \"emphasis\"}}}";
	}

	@GetMapping("/team/nftMetaDataJson")
	public NFTMetadata nftMetaDataJson(@RequestParam final Map<String, String> queryParams) {
		NFTMetadata temp = nftService.getTeamNftMetadata(queryParams, null);
		if (temp != null) {
			// convert attributes String to attributes map
			List<String> lst = Arrays.asList(temp.getAttributesStr().split("\\^"));
			for (String l : lst) {
				List<String> attr = Arrays.asList(String.valueOf(l).split("\\|"));
				temp.getAttributes().put(String.valueOf(attr.get(0)), String.valueOf(attr.get(1)));
			}
		}
		System.out.println(temp);
		return temp;
		// return "{\"id\":0,\"name\":\"Gujarat Titans 2022\",\"description\":\"Gujarat
		// Titans in the season of
		// 2022\",\"externalLink\":\"https://ipl-dashboard-shabbir.herokuapp.com/?venue=&tossDecision=&tossWinner=&playerOfMatch=&city=&team1=Gujarat
		// Titans&team2=&result=&winner=&stage=&season=2022&group=&player=\",\"image\":\"https://ipl-dashboard-shabbir.herokuapp.com/image/teams/gujarattitans.jpg\",\"attributes\":{\"teamName\":\"Gujarat
		// Titans\",\"number-of-matches-batted-first-percent\":\"43.75\",\"cities\":[\"Ahmedabad\",
		// \"Kolkata\", \"Mumbai\", \"Pune\"],\"played-with-teams\":\"Chennai Super
		// Kings, Delhi Capitals, Kolkata Knight Riders, Lucknow Super Giants, Mumbai
		// Indians, Punjab Kings, Rajasthan Royals, Royal Challengers Bangalore,
		// Sunrisers Hyderabad\",\"number-of-matches-won\":\"12\",\"players\":\"A
		// Manohar, AS Joseph, B Sai Sudharsan, DA Miller, DG Nalkande, HH Pandya, LH
		// Ferguson, MS Wade, Mohammed Shami, PJ Sangwan, R Sai Kishore, R Tewatia,
		// Rashid Khan, Shubman Gill, V Shankar, VR Aaron, WP Saha, Yash
		// Dayal\",\"stages\":\"[Final, Qualifier 1]\",\"venues\":\"Brabourne Stadium,
		// Dr DY Patil Sports Academy, Eden Gardens, Maharashtra Cricket Association
		// Stadium, Narendra Modi Stadium, Wankhede
		// Stadium\",\"percent-of-matches-won\":\"75.0\",\"number-of-matches-batted-first\":\"7\",\"number-of-matches-played\":\"16\"}}";
	}

	@GetMapping("/team/nftTokenUri/{id}")
	public String getNftTokenUri(@PathVariable("id") final String id) {
		String url = ethAccountConfig.getUrl();
		String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
		Web3j web3j = Web3j.build(new HttpService(url));
		Credentials credentialsAccount1 = Credentials.create(ethPrivateKeyAccount1);
		ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
		CricketStats contract = CricketStats.load(ethNFTCricketStatAddress, web3j, credentialsAccount1,
				contractGasProvider);
		String temp = "No value";
		try {
			temp = ethAccountConfig.getNftBaseURI() + contract.tokenURI(new BigInteger(id)).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@GetMapping("/team/nftMint")
	public ModelAndView getTeamMint(@RequestParam final Map<String, String> queryParams) {
		NFTMetadata nFTMetadata = new NFTMetadata();// nftService.getTeamNftMetadata(queryParams, null);
		NFTMetadata temp = nftRepository.getByName(nFTMetadata.getName());
		if (temp == null) {
			String url = ethAccountConfig.getUrl();
			String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
			Web3j web3j = Web3j.build(new HttpService(url));
			Credentials credentialsAccount1 = Credentials.create(ethPrivateKeyAccount1);
			ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
			CricketStats contract = CricketStats.load(ethNFTCricketStatAddress, web3j, credentialsAccount1,
					contractGasProvider);
			// get Token id/counter
			BigInteger tokenId = null;
			try {
				tokenId = contract.count().send();
				System.out.println(tokenId.toString());
				nFTMetadata.setId(tokenId.longValue());
				NFTMetadata val = nftRepository.save(nFTMetadata);
				System.out.println("---------DB STORED----" + val);
			} catch (Exception e) {
				e.printStackTrace();
			}
			NFTMetadata tempNew = nftRepository.findById((tokenId.longValue())).get();
			// convert attributes String to attributes map
			if (tempNew != null) {
				System.out.println("-------========ashdvas---" + tempNew);
			}

			// publish nFTMetadata
			String recipient = ethAccountConfig.getEthAddressAccount2();
			String metadataURI = tokenId.toString();
			try {
				BigInteger amount = Convert.toWei("0.05", Convert.Unit.ETHER).toBigInteger();
				TransactionReceipt tx = contract
						.payToMintOwner(recipient, metadataURI, nFTMetadata.getAttributesStr(), amount).send();
				System.out.println(tx);
			} catch (Exception e) {
				List<Long> ids = new ArrayList<>();
				ids.add(nFTMetadata.getId());
				// nftRepository.deleteAllById(ids);
				e.printStackTrace();
			}
			return new ModelAndView("redirect:" + "https://testnets.opensea.io/assets/"
					+ ethAccountConfig.getNetwork().toLowerCase() + "/" + ethNFTCricketStatAddress + "/" + tokenId);
		}
		return new ModelAndView("redirect:" + "https://testnets.opensea.io/assets/"
				+ ethAccountConfig.getNetwork().toLowerCase() + "/" + ethNFTCricketStatAddress + "/" + temp.getId());
	}

	@GetMapping("/team/nftMintOwner")
	public ModelAndView getTeamMintOwner(@RequestParam final Map<String, String> queryParams) {
		NFTMetadata nFTMetadata = nftService.getTeamNftMetadata(queryParams, null);
		NFTMetadata temp = nftRepository.getByName(nFTMetadata.getName());
		if (temp == null) {
			String url = ethAccountConfig.getUrl();
			String ethPrivateKeyAccount1 = ethAccountConfig.getEthPrivateKeyAccount1();
			Web3j web3j = Web3j.build(new HttpService(url));
			Credentials credentialsAccount1 = Credentials.create(ethPrivateKeyAccount1);
			ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
			CricketStats contract = CricketStats.load(ethNFTCricketStatAddress, web3j, credentialsAccount1,
					contractGasProvider);
			// get Token id/counter
			BigInteger tokenId = null;
			try {
				tokenId = contract.count().send();
				System.out.println(tokenId.toString());
				nFTMetadata.setId(tokenId.longValue());
				NFTMetadata val = nftRepository.save(nFTMetadata);
				System.out.println("---------DB STORED----" + val);
			} catch (Exception e) {
				e.printStackTrace();
			}
			NFTMetadata tempNew = nftRepository.findById((tokenId.longValue())).get();
			// convert attributes String to attributes map
			if (tempNew != null) {
				System.out.println("-------========ashdvas---" + tempNew);
			}

			// publish nFTMetadata
			String recipient = ethAccountConfig.getEthAddressAccount2();
			String metadataURI = tokenId.toString();
			try {
				BigInteger amount = Convert.toWei("0.05", Convert.Unit.ETHER).toBigInteger();
				TransactionReceipt tx = contract
						.payToMintOwner(recipient, metadataURI, nFTMetadata.getAttributesStr(), amount).send();
				System.out.println(tx);
			} catch (Exception e) {
				List<Long> ids = new ArrayList<>();
				ids.add(nFTMetadata.getId());
				// nftRepository.deleteAllById(ids);
				e.printStackTrace();
			}
			return new ModelAndView("redirect:" + "https://testnets.opensea.io/assets/"
					+ ethAccountConfig.getNetwork().toLowerCase() + "/" + ethNFTCricketStatAddress + "/" + tokenId);
		}
		return new ModelAndView("redirect:" + "https://testnets.opensea.io/assets/"
				+ ethAccountConfig.getNetwork().toLowerCase() + "/" + ethNFTCricketStatAddress + "/" + temp.getId());
	}

	@GetMapping("/ethNFTCricketStatAddress")
	public static String getEthNFTCricketStatAddress() {
		return ethNFTCricketStatAddress;
	}
}
